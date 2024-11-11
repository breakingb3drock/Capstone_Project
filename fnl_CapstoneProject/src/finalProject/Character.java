//Authors: Nikhil Anoop
//Period: 3
//Date: 5/27/24
//Notes:

package finalProject;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

public class Character {
	
	
	//Chacter fields
	double x;
	double y;
	Image pic;
	int width;
	int height;
	double speedH = 0;
	double speedV = 0;
	
	
	public Character(double x, double y, Image pic, int width,int height) {
		this.x = x;
		this.y = y;
		this.pic = pic;
		this.width = width;
		this.height = height;
	}
	
	// from GAMEPHYSICSDEMO
	public void draw(Graphics g, ImageObserver io) {
		g.drawImage(pic, (int)x, (int)y, width, height, io);
		x = x + speedH;
		y = y + speedV;
	}
	
	//Sets the horizontal speed
	public void setSpeedH(double speed) {
		speedH = speed;
	}
	
	//Sets the vertical speed
	public void setSpeedV(double speed) {
		speedV = speed;
	}

}
