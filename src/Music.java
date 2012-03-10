/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kevin
 */
import javax.sound.sampled.*;
import java.io.File;

public class Music implements Runnable {
   
    @Override
    public void run(){
        try {
                        AudioInputStream stream = AudioSystem.getAudioInputStream(new File("music/output.wav"));

                        // From URL
                        //stream = AudioSystem.getAudioInputStream(new URL("http://hostname/audiofile"));

                        // At present, ALAW and ULAW encodings must be converted
                        // to PCM_SIGNED before it can be played
                        AudioFormat format = stream.getFormat();
                        if (format.getEncoding() != AudioFormat.Encoding.PCM_SIGNED) {
                            format = new AudioFormat(
                                    AudioFormat.Encoding.PCM_SIGNED,
                                    format.getSampleRate(),
                                    format.getSampleSizeInBits()*2,
                                    format.getChannels(),
                                    format.getFrameSize()*2,
                                    format.getFrameRate(),
                                    true);        // big endian
                            stream = AudioSystem.getAudioInputStream(format, stream);
                        }

                        // Create line
                        SourceDataLine.Info info = new DataLine.Info(
                            SourceDataLine.class, stream.getFormat(),
                            ((int)stream.getFrameLength()*format.getFrameSize()));
                        SourceDataLine line = (SourceDataLine) AudioSystem.getLine(info);
                        line.open(stream.getFormat());
                        line.start();

                        // Continuously read and play chunks of audio
                        int numRead = 0;
                        byte[] buf = new byte[line.getBufferSize()];
                        while ((numRead = stream.read(buf, 0, buf.length)) >= 0) {
                            int offset = 0;
                            while (offset < numRead) {
                                offset += line.write(buf, offset, numRead-offset);
                            }
                        }
                        line.drain();
                        line.stop();
                } catch (Exception e) {
                        e.printStackTrace();
                        System.exit(1);
                }
    }

}
