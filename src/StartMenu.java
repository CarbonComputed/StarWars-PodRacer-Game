/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kevin
*/
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;
import java.awt.event.KeyListener;
import java.awt.event.*;
import java.awt.event.KeyEvent;
import javax.swing.Action;
public class StartMenu extends JButton implements MouseListener,KeyListener,Actors  {
    Image image;

    public boolean strt=false;
public int score=0;
    public StartMenu(){
        super("Play");
        getInputMap().put(KeyStroke.getKeyStroke("ENTER"),
                            "clicked");
        //setVerticalTextPosition(AbstractButton.BOTTOM);
//getInputMap().put(KeyStroke.getKeyStroke("ENTER"),
  //                          );
setFocusable(true);
//setSelected(true);
requestFocusInWindow();
        

//getActionMap().put("pressed",strt=);
   getActionMap().put("pressed", new AbstractAction("actionName") {
       public void actionPerformed(ActionEvent evt) {
           strt=true;
           //System.out.println("test");
       }
   }
   );

//super.setBounds(500,350,100,100);
 //super.setBackground(Color.BLUE);
        this.addMouseListener(this);
        addKeyListener(this);
    //    this.requestFocus();
       // requestFocusInWindow();
//requestFocusInWindow();
   //setVisible(true);
        setFocusable(true);
        requestFocus();
        requestFocusInWindow();
       setVisible(true);
      // JLabel label=new JLabel("one");
        
//this.grabFocus();
  //      this.transferFocusBackward();
//this.addFocusListener(new MyFocusListener());
        setBackground(Color.white);
//     setDoubleBuffered(true);
        //t.keyPressed(null);
 // System.out.println(isFocusable());
     setVisible(true);
     requestFocus();
     //requestFocusInWindow();
    
    }
    KeyEvent key=null;
 public void mouseClicked(MouseEvent e) {
//System.out.println("The frame was clicked.");

}

public void mouseEntered(MouseEvent e) {
//System.out.println("The mouse entered the frame.");

}

public void mouseExited(MouseEvent e) {
//System.out.println("The mouse exited the frame.");

}

public void mousePressed(MouseEvent e) {
//System.out.println("The left mouse button was pressed.");
strt=true;
//remove(this);
}

public void mouseReleased(MouseEvent e) {
//System.out.println("The left mouse button was released.");

}

            public void keyReleased(KeyEvent e) {
           //   t.stop();


        }
            public void keyTyped(KeyEvent e){

            }
           
		public void keyPressed(KeyEvent e) {
                    
                    int key2 = e.getKeyCode();
 //strt=true;
//System.out.println(e);
             if(key2==KeyEvent.VK_ENTER){
strt=true;
setFocusable(false);
              //  t.stop();
                 return;
             }
                    
       //key=e;
                    //int key2 = e.getKeyCode();

                  //  t.start();


        }
    public Image newImage(String i){
		ImageIcon icon = new ImageIcon(i);
        image = icon.getImage();
        return image;

	}

public class MyFocusListener extends FocusAdapter {
    public void focusGained(FocusEvent evt) {
        // The component gained the focus.
        System.out.println("test");
    }
    public void focusLost(FocusEvent evt) {
        // The component lost the focus.
        boolean isTemporary = evt.isTemporary();
        System.out.println(evt.isTemporary());
    }
}

}
