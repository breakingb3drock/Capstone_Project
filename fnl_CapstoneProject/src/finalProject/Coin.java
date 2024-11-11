//Authors: Ido Nir
//Period: 3
//Date: 5/27/24
//Notes:

package finalProject;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Coin extends Item{
	
	
	Image pic ;
	
	// BORROWED FROM GAMEPHYSICS DEMO
	public Coin () {
		
	}
	
	public Coin (double x, double y) {
		this("COIN.png",x,y,25,25);
	}
	
	public Coin(String filename, double x, double y, int w, int h) {
		this((new ImageIcon(filename)).getImage(),x,y,w,h);
	}
	
	public Coin(Image pic,double x, double y, int width, int height) {
		
		super(x, y, pic, width, height);
	} 
	
	//Called once the coin touched by runner (coinCounter)
	public void actionR() {

	}
	
	//Called once the coin touched by runner (does nothing)
	public void actionH() {
		
	}
	
	
}
