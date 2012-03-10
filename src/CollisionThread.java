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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;

public class CollisionThread implements Runnable,Actors  {
PodRacer one;
Thread runner2;
    public CollisionThread(PodRacer o){
        one=o;
        runner2 = new Thread(this, "three");
    	runner2.start();
        //one.go();
     // Timer t3=new Timer(5,this);
    //  t3.start();
    }
public void actionPerformed(ActionEvent e) {


                //one.go();
    
                

                }
@Override
public void run(){
    for(Actor a:AList){

              if(a instanceof Rock){
            	//  System.out.println("PodR: "+one.getRect());
            	  // System.out.println("Rock :"+a.getRect());
            	   if(a.getRect().intersects(one.getRect())==true){
            		
                      


            	   }



               }
             }
    try {
		runner2.sleep(5);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	run();


}

}
