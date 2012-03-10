/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kevin
*/
import java.awt.*;
import java.lang.Thread;

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
public class BackDrop implements ActionListener,Actors,Runnable {
	Thread runner;

     Actor background=new Actor(-5,-5,"images/background.png");
Actor background2=new Actor(-5,-350,"images/background.png");
PodRacer one=new PodRacer();
Rock r=new Rock(-85,-5,"images/RockF.png");
Rock r2=new Rock(-85,-351,"images/RockF.png");
Rock r3=new Rock(355,-5,"images/RockF2.png");
Rock r4=new Rock(355,-351,"images/RockF2.png");
Rock[] rs=new Rock[5];
boolean tstop=false;
boolean laserremove=false;
Laser mtemp;
Ammo ammo=new Ammo(200,200,"images/Ammo.png");
public int speed=one.backSpeed;
ArrayList<Actor> actors=new ArrayList<Actor>();
    public BackDrop(){
        //one.go();
    	runner = new Thread(this, "two");
    	runner.start();
        //Timer t=new Timer(15,this);
        //t.start();
        for(int ctr=0;ctr<rs.length;ctr++){
            rs[ctr]=new Rock(0,0,"images/tinyrock.png");
        }
    }
public void actionPerformed(ActionEvent e) {





}
@Override
public void run() {
	// TODO Auto-generated method stub
    while(runner.isAlive()){
	actors=one.getActors();

    //one.go();
    for(int z=0;z<AList.size();z++){
        Actor a=AList.get(z);
       if(a.equals(background)&&a.topy()>=350){
            a.setLocation(-5, -360);
        }
        if(a.equals(background2)&&a.topy()>=350){
            a.setLocation(-5, -360);
        }
    
if(a.equals(ammo)&&a.topy()>=350){
    a.setLocation((int)(330 * Math.random()) + 30, (int)(-1000 * Math.random()) + -1);
}
          if(a.equals(r)&&a.topy()>=350){
             
            a.setLocation(-85, -361);
        }
       if(a.equals(r2)&&a.topy()>=350){
              
            a.setLocation(-85, -361);
        }
       if(a.equals(r3)&&a.topy()>=350){

            a.setLocation(355, -361);
        }
       if(a.equals(r4)&&a.topy()>=350){

            a.setLocation(355, -361);
        }
       for(int ctr=0;ctr<rs.length;ctr++){
           if(a.equals(rs[ctr])&&a.topy()>=350){
        a.setLocation((int)(330 * Math.random()) + 30, (int)(-370 * Math.random()) + -1);}
       }
if(a instanceof Ammo){
   
    if(a.getRect().intersects(one.getLeft())==true||a.getRect().intersects(one.getRight())==true||
            a.getRect().intersects(one.getBottom())==true){
        a.setLocation((int)(330 * Math.random()) + 30, (int)(-370 * Math.random()) + -1);
        Laser laser=new Laser(one.getX(),one.getY(),"images/laser2.png");
            one.arsenal.add(laser);
            //a.removeSelf();
            one.ammohit=true;
             
            
        }
    }


       
        
       if(a instanceof Rock){
            	//  System.out.println("PodR: "+one.getRect());
            	  // System.out.println("Rock :"+a.getRect());
           
            	   if(a.getRect().intersects(one.getLeft())==true||a.getRect().intersects(one.getRight())==true)
                           {
            		   //System.out.println("collision");
                       one.collision=true;
                     one.newImage("images/Explosion1.gif");
                     one.y-=60;
                           tstop=true;
                          
        speed=one.backSpeed;
		runner.stop();
                
	
                           
                           
            	   }


                    //  if(one.collision(a)==true){
                      //     System.out.println("collide");
                      // }

               }
        if(a instanceof PodRacer){

  while(a.getY()<=0){
             a.y+=1;
         }
  while(a.getY()>=288){
             a.y+=-1;
         }

        }
        
        else{

  a.move();}
   
if(a instanceof Laser){
    Laser temp=(Laser)a;
    for(int ctr=0;ctr<rs.length;ctr++){
        if(a.getRect().intersects(rs[ctr].getRect())==false||a.boty()>=0){
        // System.out.println("test");
           temp.Shot();
        }

        if(a.boty()<=0){
           mtemp=temp;
            laserremove=true;
        }
 if(a.getRect().intersects(rs[ctr].getRect())){
     mtemp=temp;
     laserremove=true;
     rs[ctr].setLocation((int)(330 * Math.random()) + 30, (int)(-370 * Math.random()) + -1);
     one.rockhit=true;
 }
    }
}
     
    }
        if(laserremove==true){
            laserremove=false;
            //System.out.println("test");
            //one.arsenal.remove(0);
             mtemp.removeSelf();
        }
        
    try {
        speed=one.backSpeed;
		runner.sleep(speed);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//run();
}
}
}