// Authors: Ido Nir
//Date: 5/27/24
//Per: 3
//Rev: 
//Notes:

package finalProject;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;

//Runner is a character
public class Runner extends Character {

	private boolean dead = false;
	public static boolean touch = false;
	private static boolean boost = false;
	private static boolean sticky = false;
	public static String stat = "";
	private int counter = 0;
	double x = 0;
	double y = 0;
	Image pic ;
	
	// BORROWED FROM GAMEPHYSICS DEMO
	//Constructors...
	public Runner (double x, double y) {
		this("RUNNER.png",x,y,45,50);
		this.x = x;
		this.y = y;
	}
	
	public Runner(String filename, double x, double y, int w, int h) {
		this((new ImageIcon(filename)).getImage(),x,y,w,h);
	}
	
	public Runner(Image pic,double x, double y, int width, int height) {
		
		super(x, y, pic, width, height);
	}
	
	//Side to side movement
	public void moveHorizontal (double distance) {
		if (dead == false) {
			if(boost == true) {
				stat = "Runner Boost!";
				distance = distance*1.5;
			}
			if(sticky == true) {
				stat = "Runner Stuck!";
				distance = distance/1.5;
			}
			super.setSpeedH(distance);
		}
		if(boost && sticky) {
			stat = "Runner Boost and Stuck?";
		}
		
		if (dead==true) {
			super.setSpeedH(0);
		}
		
		if(touch) {
			counter++;
		}
		if(counter % 20 == 0) {
			setStick(false);
			setBoost(false);
			stat = "";
			counter = 0;
		}
		
	}
	
	//move up/down
	public void moveUp (double distance) {
		if (dead==false) {
			if(boost == true) {
				stat = "Runner Boost!";
				distance = distance*1.5;
			}
			if(sticky == true) {
				stat = "Runner Stuck!";
				distance = distance/1.5;
			}
			super.setSpeedV(distance);
		}
		if(boost && sticky) {
			stat = "Runner Boost and Stuck?";
		}
		
		if (dead==true) {
			super.setSpeedV(0);
		}
		
		if(touch) {
			counter++;
		}
		if(counter % 20 == 0) {
			touch = false;
			setStick(false);
			setBoost(false);
			stat = "";
			counter = 0;
		}
	}
	
	//drink/boost
	public static void setBoost(boolean b) {
		boost = b;
	}
	
	//stick/web
	public static void setStick(boolean b) {
		sticky = b;
	}
	
	//accessors/mutators
	public double getX () {
		return super.x;
	}
	
	public double getY () {
		return super.y;
	}
	
	public void setX(double i) {
		super.x = i;
	}
	
	public void setY(double i) {
		super.y = i;
	}
	
	public int getWidth () {
		return super.width;
	}
	
	public int getHeight () {
		return super.height;
	}

	public void setDead(boolean r) {
		dead = r;
	}
	
	//respawns runner when game over
	public void respawn() {
		if(dead == true) {
			setX(680);
			setY(200);
			dead = false;
		}
		touch = false;
		setBoost(false);
		setStick(false);
		counter = 0;
		stat = "";
	}
	
}
