
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GameDriver extends JFrame {
Engine e;
Engine f;
    public GameDriver() {
        //add(new StartMenu());
      //  e=null;

        e=new Engine(this);
        add(e);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setTitle("APCOMPSCI");
        setResizable(false);
        setVisible(true);

    }

public void removeEandadd(Engine n){
    remove(e);
    e=null;
    e=new Engine(this);
//GameDriver d=new GameDriver();
    add(e);
   // requestFocus();
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setTitle("APCOMPSCI");
        setResizable(false);
       // requestFocusInWindow();
        setVisible(true);
        
}
    public static void main(String[] args) {
    
        GameDriver GD=new GameDriver();
        
    }
}
