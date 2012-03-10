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


public class Actor implements Actors  {
	public Image image;
	private ArrayList<String> perimeter=new ArrayList<String>();
	public int x;
	public int y;
	private String location;
	public String img;
        public String imgn;
	public static boolean collision;
	public static ArrayList<Actor> actors=new ArrayList<Actor>();
	public Actor(){

	}
	public Actor(int slocx,int slocy,String im){
	imgn=im;
            newImage(im);
		img=im;
        x=slocx;
        y=slocy;

        act();


	}
	public void act(){
		actors.add(this);
                AList.add(this);
	}
	public int getX(){
		return this.x;
	}

	public int getY(){
		return this.y;
	}
        public void move(){
            backdropY(4);

        }
	public Image newImage(String i){
		ImageIcon icon = new ImageIcon(i);
        image = icon.getImage();
        return image;

	}
        public Rectangle getRect(){
	return new Rectangle(getX(),getY(),image.getWidth(null),image.getHeight(null));
}
	public ArrayList<Actor> getActors(){
		return actors;
	}
        public BufferedImage getBimage(){
            BufferedImage bimage = null;
            BufferedImage bimage2=null;
try {
    bimage = ImageIO.read(new File(imgn));

return bimage2;
} catch (IOException e) {
}
       

return bimage2;

        }
	public Image getImage(){
		return image;
	}
public void setLocation(int sx,int sy){
	x=sx;
	y=sy;
}
public void removeSelf(){
for(int c=0;c<actors.size();c++){
	if(actors.get(c).equals(this)){
		actors.remove(c);
                AList.remove(c);
	}

}

}
public void backdropX(int spd){

	x+=spd;


}
public void backdropY(int spd){

	y+=spd;


}
public int leftx(){
	return x;
}
public int rightx(){
	return x+image.getWidth(null);
}
public int topy(){
	return y;
}
public int boty(){
	return y+image.getHeight(null);
}
public ArrayList perimeterofSelf(){
	String x1=Integer.toString(x);
	String y1=Integer.toString(y);
	for(int n=x;n<x+image.getWidth(null);n++){
		String n1=Integer.toString(n);
		perimeter.add(n1+","+y1);
	}
	return perimeter;
}
	public String getLocation(){
		Class cls = java.lang.String.class;
		String name=cls.getName();
		String x1=Integer.toString(x);
		String y1=Integer.toString(y);
		//location=this.getClass().getName()+" at "+x1+","+y1;
		location=x1+","+y1;
		return location;
	}

}
