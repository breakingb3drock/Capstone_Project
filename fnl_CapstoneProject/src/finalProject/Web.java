// Authors: Ido Nir
//Date: 5/27/24
//Rev: 
//Notes:

package finalProject;

import java.awt.Image;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;

public class Web extends Item{

	Image pic ;
	
	// BORROWED FROM GAMEPHYSICS DEMO
	//Constructors
	public Web (double x, double y) {
		this("COBWEB.png",x,y,40,40);
	}
	
	public Web(String filename, double x, double y, int w, int h) {
		this((new ImageIcon(filename)).getImage(),x,y,w,h);
	}
	
	public Web(Image pic,double x, double y, int width, int height) {
		
		super(x, y, pic, width, height);
		// TODO Auto-generated constructor stub
	} 
	
	//Called once the web touched by runner
	public void actionR() {
		
        Runner.setStick(true);
        

	}
	
	//Called once the web touched by hunter
	public void actionH() {
		Hunter.setStick(true);

	}
	
}
