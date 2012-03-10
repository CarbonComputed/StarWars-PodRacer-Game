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

public class TextLayer implements Runnable,Actors  {
PodRacer one;
Thread runner4;
public int score=0;
    public TextLayer(PodRacer o){
        one=o;
        runner4 = new Thread(this, "four");
    	runner4.start();
        //one.go();
     // Timer t3=new Timer(5,this);
    //  t3.start();
    }

@Override
public void run(){
if(one.collision==true){
    runner4.stop();
}



    try {
		runner4.sleep(100);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	run();


}
public void text(String s,int time){
    
}
}
