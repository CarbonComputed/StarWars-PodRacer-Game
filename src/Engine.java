import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.font.TextAttribute;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;

import java.text.AttributedString;

import javax.swing.*;


public class Engine extends JPanel implements ActionListener,Runnable {
Timer timer;
Timer two;
int width=0;
int height=0;
int ctr=0;
int ctr3=0;
Thread five;
boolean input=false;
Image lase=newImage("images/Ammo.png");
boolean end=false;
 //Actor background=new Actor(-5,-5,"images/background.png");
//Actor background2=new Actor(-5,-350,"images/background.png");
//PodRacer one=new PodRacer();
ArrayList<Actor> actors=new ArrayList<Actor>();
Graphics bufferGraphics;
BackDrop b;
ScoreKeeper score;
CollisionThread c;
Thread music;
 Thread thread2;
 Thread main;
StartMenu begin;
JPanel panel;
Image image2;
JLabel pic;
ImageIcon icon;
int cstop=0;
int pctr=0;
int pctr2=0;
Timer time;
GameDriver driver;
TAdapter k;
ArrayList<String> highscores=new ArrayList<String>();
ArrayList<String> names=new ArrayList<String>();
//ArrayList<Actor> allactors=new ArrayList<Actor>();
	public Engine(GameDriver drv){
         this.requestFocusInWindow();

            cstop=0;
            driver=drv;
          // setFocusable(false);
           //  icon =new  ImageIcon("/images/Startmenu.png");
newImage("images/Startmenu.png");
          // pic=new JLabel(newIcon());
            main=new Thread(this,"main");
            main.start();
         //   music = new Thread(new Music(), "music");
//music.start();
           setVisible(true);
        setFocusable(true);
        requestFocus();
        addKeyListener(k);
        setBackground(Color.white);
     setDoubleBuffered(true);
          // add(pic);
     begin=null;
     setLayout(null);


          begin=new StartMenu();
          //begin.setFocusable(true);
           // begin.requestFocus();
           // this.transferFocusBackward();
           // begin.setBounds(200,350,25,25);
            //Dimension size = begin.getPreferredSize();
           // begin.setSelected(true);
begin.setBounds(280,300,80,25);
begin.setMnemonic(KeyEvent.VK_ENTER);
//begin.setBackground(Color.GRAY);
           add(begin);


	}
	public void paintComponent(Graphics g) {
           //System.out.println(begin.strt);

            super.paintComponent(g);

            if(begin.strt==false){
                 Graphics2D g2d = (Graphics2D)g;
                 g2d.drawImage(image2, 0, 0, this);
                 transferFocus();
            }
            if(begin.strt==true){
                //remove(pic);
                main.resume();
        remove(begin);
        if(end==true){

        if(b.tstop==true){
         // music.stop();
            thread2.stop();
            cstop++;
            five.stop();
            try {
            	if(pctr2==0){
				pctr2++;
            		rScore();

				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

          if(pctr==0){



            		pctr++;



                         wScore();
                         //System.out.println("test");
                         //inp.stop();


                }


           // five.stop();
            //System.out.println(cstop);
            if(cstop>=500){


                    b.one.collision=false;
                    timer.stop();
                    Engine o=null;
                    Actors.AList.clear();
                    actors.clear();
                    b.one.image.flush();
                    main.stop();
                    input=true;


                    //setFocusable(true);
                    //

                  //  this.transferFocus();
                    begin.setVisible(true);
                    begin.setFocusable(true);

                    driver.removeEandadd(o);
                    this.setVisible(false);





            }
            if(cstop>1){

            }
        }
        Graphics2D g2d = (Graphics2D)g;
        this.actors=b.actors;
      // g2d.drawImage(background.getImage(), -5, -5, this);
      // g2d.drawImage(background.getImage(), -5, -500, this);
       for(int z=0;z<actors.size();z++){
Actor a=actors.get(z);

       g2d.drawImage(a.getImage(), a.getX(),a.getY(), this);



           }
       String x1=Integer.toString(score.score);
       String x2="Score: "+x1;
       AttributedString as1 = new AttributedString(x2);

as1.addAttribute(TextAttribute.FOREGROUND, Color.BLACK, 0, x2.length());
 as1.addAttribute(TextAttribute.SIZE, 16);
as1.addAttribute(TextAttribute.BACKGROUND, Color.LIGHT_GRAY, 0, x2.length());

if(b.tstop==true){
           as1.addAttribute(TextAttribute.SIZE, 24);
           g2d.drawString(as1.getIterator(), 145, 150);
          int h=180;
           for(int j=0;j<10;j++){

           String x3=Integer.toString(j+1)+". "+names.get(j)+" "+highscores.get(j)+"\n";
           AttributedString as3 = new AttributedString(x3);
    as3.addAttribute(TextAttribute.FOREGROUND, Color.BLUE, 0, x3.length());
     as3.addAttribute(TextAttribute.SIZE, 11);
    as3.addAttribute(TextAttribute.BACKGROUND, Color.LIGHT_GRAY, 0, x3.length());
           g2d.drawString(as3.getIterator(),145,h);
           h+=12;
           }
       }
else{
       g2d.drawString(as1.getIterator(), 285, 15);}
                  String sz=Integer.toString(b.one.arsenal.size());
            String sz2="x"+sz;
            AttributedString as2 = new AttributedString(sz2);

as2.addAttribute(TextAttribute.FOREGROUND, Color.BLACK, 0, sz2.length());
 as2.addAttribute(TextAttribute.SIZE, 16);
 Font f = new Font("Times New Roman",Font.BOLD, 18);
 as2.addAttribute(TextAttribute.FONT, f, 0, sz.length()+1);

 g2d.drawString(as2.getIterator(), 23, 15);
 g2d.drawImage(lase, 0,0, this);
 Toolkit.getDefaultToolkit().sync();
        g2d.dispose();
            }

            }
            else{
                repaint();

            }

    }

	public void actionPerformed(ActionEvent e) {
		if(input==false){
		repaint();}


	}
        public void run(){
            main.suspend();
            k=new TAdapter();
            addKeyListener(k);
            setFocusable(true);
            requestFocus();
            setVisible(true);
            if(begin.strt==true){
              //  remove(begin);




//main.start();

 b=new BackDrop();
 score=new ScoreKeeper(b.one);
 //c=new CollisionThread(b.one);
thread2 = new Thread(b, "thread2");
thread2.start();
//score.runner3.start();
        timer = new Timer(5, this);
        timer.start();
        end=true;
}


        }
        public Image newImage(String i){
		ImageIcon icon = new ImageIcon(i);
        image2 = icon.getImage();
        return image2;

	}
        public void wScore(){
        	int linenum=0;
                input i=new input(score.score,names,highscores);
             	 Thread inp=new Thread(i,"input");
                 inp.start();
        	//System.out.println(highscores);


        }
        public void rScore() throws IOException{

        	File file=new File("HighScore.txt");
        	BufferedReader input =  new BufferedReader(new FileReader(file));

        //	Scanner scanner = new Scanner("HighScore.txt");
        	String line=null;
            try {
              //first use a Scanner to get each line
              while ( ( line = input.readLine()) != null){
                //line=input.nextLine();
                for(int z=0;z<line.length();z++){

                	if(line.substring(z,z+1).equals(" ")){
                		names.add(line.substring(0,z));
                		highscores.add(line.substring(z+1,line.length()));
                	}
                }
              }
            }
            finally {
              //ensure the underlying stream is always closed
              try {
				input.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            }

//System.out.println(names);
//System.out.println(highscores);
        }

	private class TAdapter extends KeyAdapter implements Runnable,ActionListener{
	//Timer t= new Timer(10,this);


	public TAdapter(){
		five=new Thread(this,"five");
		five.start();
	}
        KeyEvent key=null;

            public void keyReleased(KeyEvent e) {
             // t.stop();
            five.suspend();
                if(begin.strt==true&&b!=null){

               b.one.keyReleased(key);
                  }
        }
		public void keyPressed(KeyEvent e) {
        key=e;
        five.resume();
                 //   t.start();
        //
           //     one.go();
            //one.keyPressed(e);
        }
             public void actionPerformed(ActionEvent e) {


	}
			//@Override
			public void run() {
				// TODO Auto-generated method stub
				if(ctr3==0){
					five.suspend();
					ctr3++;
				}
				 if(begin.strt==true){
			         if(b.tstop==true){
			             //t.stop();
			            // main=new Thread(new Engine(),"main");
			             return;
			         }
			         if(key.getKeyCode()==KeyEvent.VK_ENTER){
			            begin.strt=true;
			        }
			                 b.one.move();
			         b.one.keyPressed(key);

			}

				 try {
					five.sleep(5);

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				run();
			}

	}


}