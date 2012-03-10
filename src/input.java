/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kevin
 */
import java.awt.*;
import java.util.*;
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
import javax.swing.JOptionPane;
public class input implements Runnable {
    String in;
    boolean done=false;
    int linenum=0;
    int sc=0;
    ArrayList<String> highscores=new ArrayList<String>();
ArrayList<String> names=new ArrayList<String>();
public input(int h,ArrayList n,ArrayList o){
  sc=h;
  names=n;
  highscores=o;
}
    public void run(){
       for(int z=0;z<highscores.size();z++){

        		int hscore=Integer.parseInt(highscores.get(z));
        		 if(sc>=hscore){
        			 linenum=z;



        		String nme=JOptionPane.showInputDialog(null,"Enter Name","NEW HIGH SCORE!!");
        			nme=nme.replace(" ", "_");
        			//String fme=nme.substring(0,9);
        			names.add(linenum,nme);

        			 highscores.add(linenum,Integer.toString(sc));
        			 names.remove(names.size()-1);
        			 highscores.remove(highscores.size()-1);
        			 break;
        		 }
        	}
        	Writer writer = null;

            try
            {


                File file = new File("HighScore.txt");
                writer = new BufferedWriter(new FileWriter(file));
                for(int z=0;z<names.size();z++){
                	writer.write(names.get(z));
                	writer.write(" ");
                	writer.write(highscores.get(z)+"\n");
                }
            } catch (FileNotFoundException e)
            {
                e.printStackTrace();
            } catch (IOException e)
            {
                e.printStackTrace();
            } finally
            {
                try
                {
                    if (writer != null)
                    {
                        writer.close();
                    }
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }

    }

}
