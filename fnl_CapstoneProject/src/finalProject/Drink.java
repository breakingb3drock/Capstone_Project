// Authors: Ido Nir
//Date: 5/27/24
//Per: 3
//Rev: 
//Notes:
package finalProject;

import java.awt.Image;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;

public class Drink extends Item{

	
	Image pic ;
	
	// BORROWED FROM GAMEPHYSICS DEMO
	//Constructors...
	public Drink (double x, double y) {
		this("DRINK.png",x,y,20,30);
	}
	
	public Drink(String filename, double x, double y, int w, int h) {
		this((new ImageIcon(filename)).getImage(),x,y,w,h);
	}
	
	public Drink(Image pic,double x, double y, int width, int height) {
		
		super(x, y, pic, width, height);
	} 
	
	//Called once the drink touched by runner
	public void actionR() {
		Runner.setBoost(true);

	}
	
	//Called once the drink touched by hunter
	public void actionH() {
        Hunter.setBoost(true);

	}
	
}
