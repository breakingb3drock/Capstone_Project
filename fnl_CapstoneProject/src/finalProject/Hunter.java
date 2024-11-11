package finalProject;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;

//Authors: Nikhil Anoop
//Date: 5/2/24
//Per: 3
//Rev: 
//Notes:

//Hunter is a character
public class Hunter extends Character {

	private boolean dead = false;
	private static boolean boost = false;
	private static boolean sticky = false;
	private int counter = 0;
	private static boolean go = false;
	public static boolean touch = false;
	public static String stat = "";
	double x = 0;
	double y = 0;
	Image pic ;
	
	// BORROWED FROM GAMEPHYSICS DEMO
	//Constructors...
	public Hunter (double x, double y) {
		this("HUNTER.png",x,y,55,55);
	}
	
	public Hunter(String filename, double x, double y, int w, int h) {
		this((new ImageIcon(filename)).getImage(),x,y,w,h);
	}
	
	public Hunter(Image pic,double x, double y, int width, int height) {
		
		super(x, y, pic, width, height);
		// TODO Auto-generated constructor stub
	}
	
	//moves hunter side to side
	public void moveHorizontal (double distance) {
		if (dead == false) {
			if(boost == true) {
				distance = distance*1.5;
				stat = "Hunter Boost!";
			}
			if(sticky == true) {
				distance = distance/1.5;
				stat = "Hunter Stuck!";
			}
			if(sticky && boost) {
				stat = "Hunter Boost & Stuck?";
			}
			super.setSpeedH(distance);
		}
		else {
			super.setSpeedH(0);
		}
		
		if(touch = true) {
			counter++;
		}
		if(counter % 20 == 0) {
			stat = "";
			setStick(false);
			setBoost(false);
			touch = false;
			counter = 0;
		}
		
	}
	
	//moves hunter up and down
	public void moveUp (double distance) {
		if (dead==false) {
			if(boost == true) {
				distance = distance*1.5;
				stat = "Hunter Boost!";
			}
			if(sticky == true) {
				distance = distance/1.5;
				stat = "Hunter Stuck!";
			}
			if(sticky && boost) {
				stat = "Hunter Boost & Stuck?";
			}
			super.setSpeedV(distance);
		}
		else {
			super.setSpeedV(0);
		}
		if(touch = true) {
			counter++;
		}
		if(counter % 20 == 0) {
			stat = "";
			setStick(false);
			setBoost(false);
			touch = false;
			counter = 0;
		}
		
	}
	
	//boost/drink
	public static void setBoost(boolean b) {
		boost = b;
		go = true;
	}
	
	//stick/cobweb
	public static void setStick(boolean b) {
		sticky = b;
		go = true;
	}
	
	//Mutators/accesors
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
	
	//resepawns hunter
	public void respawn() {
		if(dead == true) {
			setX(50);
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
