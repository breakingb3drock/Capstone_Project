// Authors: Ido Nir
//Date: 5/27/24
//Rev: 
//Notes:

package finalProject;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

public abstract class Item {

	double x, y;
	Image pic;
	int width, height;
	
	//Constructor
	public Item (double x, double y, Image pic, int width, int height) {
		this.x = x;
		this.y = y;
		this.pic = pic;
		this.width = width;
		this.height = height;
	}
	
	public Item() {
		
	}
	
	//Action of item (different between items)
	public abstract void actionR();
	
	public abstract void actionH();
	
	//Draws the item
	public void draw(Graphics g, ImageObserver IO) {
		g.drawImage(pic, (int)(x), (int)(y), width, height, IO);
	}
	
	//accessors...
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
}
