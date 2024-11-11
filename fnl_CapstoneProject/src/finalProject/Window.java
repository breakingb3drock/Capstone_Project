// Authors: Ido Nir & Nikhil Anoop
//Date: 5/2/24
//Rev: 
//Notes:

package finalProject;
import javax.swing.JFrame;

public class Window {

	//Window size
	public static int width = 1450;
	public static int height = 800;
	
	public static void main(String[] args) {
		// key listen, bounds...
		
		JFrame w = new JFrame("Timmy Time");
		w.setBounds(50, 50, width, height);
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DrawingSurface panel = new DrawingSurface();
		w.addKeyListener(panel);
		w.add(panel);
		w.setVisible(true);
		w.setResizable(false);
		
		panel.run();

	}

}
