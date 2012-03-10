/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kevin
 */
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import javax.swing.ImageIcon;

public class PodRacer extends Actor {
    	//private int x;
	//private int y;
	//private Image image;
    int actX=0;
    int actY=0;
    ArrayList<Laser> arsenal=new ArrayList<Laser>();
    ArrayList<String> pixels1=new ArrayList<String>();
ArrayList<String> pixels2=new ArrayList<String>();
	private int health=150;
	private int damage;
	private int speedx;
	private int speedy;
        boolean rockhit=false;
	private String location;
	private int direction;
	private boolean canmove;
	private boolean collisionD=false;
	private boolean collisionU=false;
	private boolean collisionL=false;
	private boolean collisionR=false;
	private int ctr=0;
        public int backSpeed=40;
        public boolean ammohit=false;
public PodRacer(){
    super(170,275,"images/PodRacer1.png");
collision=false;
}
public void go(){
		
		



	}
public Rectangle getLeft(){
    return new Rectangle(getX(),getY()+2,19,41);
}
public Rectangle getRight(){
    return new Rectangle(getX()+36,getY()+2,18,39);
}
public Rectangle getBottom(){
    return new Rectangle(getX()+19,getY()+50,16,19);
}
        public void act(){
            AList.add(this);
            actors.add(this);
        }
	public void move(){
		x+=speedx;
                y+=speedy;
                
	}
	public void swordswipe(){

	}
	public int getHealth(){
		return health;
	}
	public void setHealth(int h){
		health=h;
	}
	public void loseHealth(int h){
		health-=h;
	}

	public void gainHealth(int h){
		health+=h;
	}
	public int getDirection(){
		return direction;
	}
        public Rectangle getRect(){
	return new Rectangle(getX(),getY(),image.getWidth(null)-2,image.getHeight(null)-2);
}
	public boolean collision(Actor a,PodRacer p){
pixels1.clear();
pixels2.clear();
	   BufferedImage buffImage =new BufferedImage(
         a.image.getWidth(null),
          a.image.getHeight(null),
          BufferedImage.TYPE_INT_ARGB);

    
    Graphics g = buffImage.getGraphics();
    g.drawImage(a.image, a.getX(), a.getY(), null);
    BufferedImage buffImage2 =new BufferedImage(
          p.image.getWidth(null),
          p.image.getHeight(null),
          BufferedImage.TYPE_INT_ARGB);

    // Draw Image into BufferedImage
    g = buffImage2.getGraphics();
    g.drawImage(p.image, getX(), getY(), null);
    //System.out.println(a.image.getWidth(null));
    //System.out.println(a.image.getHeight(null));
    
    for(int n=a.getX();n<a.image.getWidth(null);n++){
        for(int z=a.getY();z<a.image.getHeight(null);z++){
          //  System.out.println(alpha);
            if(n>-1&&z>-1){
           int alpha =(buffImage.getRGB(n, z)& 0x00ff0000) >>16 ;
           
           //
           
           if(alpha!=0){
               String x1=Integer.toString(n);
		String y1=Integer.toString(z);
               pixels1.add(x1+","+y1);
           }
            }
        }
    }
   // System.out.println(pixels1.size());
    for(int n=0;n<p.image.getWidth(null);n++){
        for(int z=0;z<p.image.getHeight(null);z++){
          //  System.out.println(alpha);
            if(n>-1&&z>-1){
           int alpha =(buffImage2.getRGB(n, z)& 0x00ff0000) >>16 ;
           System.out.println(alpha);
           //

           if(alpha!=0){
               String x1=Integer.toString(n);
		String y1=Integer.toString(z);
               pixels2.add(x1+","+y1);
           }
            }
        }
    }
    for(int n=0;n<pixels2.size();n++){
        for(int z=0;z<pixels1.size();z++){
            if(pixels1.get(z).equals(pixels2.get(n))){
                return true;
            }
        }
    }

	return false;
        }


        public boolean pixCollision(Actor a){
            
            int [] rgbs2 = new int[image.getWidth(null)*image.getHeight(null)];
 
int x1=getX();
int y1=getY();
int x2=actX;
int y2=actY;

    

  return false;



        }
	 public void keyPressed(KeyEvent e) {

	        int key = e.getKeyCode();
                
	        if (key == KeyEvent.VK_LEFT) {
	         speedx=-2;

	            direction=270;
	           // return;
	        }

	        if (key == KeyEvent.VK_RIGHT) {
	        	//speedx=1;
                        speedx=2;

	            direction=90;
	           // return;
	        }

	        if (key == KeyEvent.VK_UP) {
	        	
                    speedy=-2;
	        	direction=0;
	       //return;
	        }

	        if (key == KeyEvent.VK_DOWN) {
	        	speedy=2;

	            direction=180;
	         //   return;
	        }

	 }
	 public void keyReleased(KeyEvent e) {
	        int key = e.getKeyCode();
if(key==KeyEvent.VK_SPACE){
             if(arsenal.size()>0){
                 actors.add(arsenal.get(0));
                 AList.add(arsenal.get(0));
                 arsenal.get(0).x=((getX()+rightx())/2)-10;
                 arsenal.get(0).y=(getY()+boty())/2;
                    arsenal.get(0).Shot();
                    arsenal.remove(0);
                    //return;
             }
                }
	        if (key == KeyEvent.VK_UP) {
	        	
	           speedy =0;
	          //  return;
	        }

	        if (key == KeyEvent.VK_RIGHT) {
	        	
	        	
                            speedx=0;
                       
	        //	return;
	        }

	        if (key == KeyEvent.VK_LEFT) {
	        	//speedx=0;
	          
                            speedx=0;
                        
	         //   return;
	        }

	        if (key == KeyEvent.VK_DOWN) {
	        
	        speedy =0;
	           // return;
	        }
	 direction=0;
         }




}


