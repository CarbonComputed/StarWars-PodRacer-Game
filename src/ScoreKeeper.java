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

public class ScoreKeeper implements Runnable,Actors  {
PodRacer one;
Thread runner3;
public int score=0;
    public ScoreKeeper(PodRacer o){
        one=o;
        runner3 = new Thread(this, "three");
    	runner3.start();
        //one.go();
     // Timer t3=new Timer(5,this);
    //  t3.start();
    }

@Override
public void run(){
if(one.collision==true){
    runner3.stop();
}
if(one.rockhit==true){
    score+=25;
    one.rockhit=false;
}
if(one.ammohit==true){
    score+=10;
    one.ammohit=false;
}
    score++;
    if(score%30==0&&one.backSpeed>15){
        one.backSpeed-=2;
    }

    try {
		runner3.sleep(100);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	run();


}

}
