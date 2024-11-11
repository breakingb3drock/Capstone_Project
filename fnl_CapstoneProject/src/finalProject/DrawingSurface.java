// Authors: Ido Nir & Nikhil Anoop
//Date: 5/2/24
//Per: 3
//Rev: 
//Notes:
package finalProject;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class DrawingSurface extends JPanel implements KeyListener
{
	//Window height/width
	public static final int DRAWING_WIDTH = 800;
	public static final int DRAWING_HEIGHT = 800;
	
	//random item
	Random random = new Random();
	
	//Feilds
	private Hunter hunter;
	private Runner runner;
	private Item item;
	private int type = random.nextInt(101);
	public int score = 0;
	public boolean isCoin = false;
	private boolean win = false; 
    int x = random.nextInt(750);
    int y = random.nextInt(375);
    int counter = 0;
	private int width = getWidth();
    private int height = getHeight();

	
    //constructor
	public DrawingSurface () {
		super();
		hunter = new Hunter(50,200);
		runner = new Runner(680,200);
		item = new Coin(1000, 500);
		
		setBackground(Color.BLACK);
	}
	
	//paints everything
	public void paintComponent (Graphics g) {
	    
		width = getWidth();
		height = getHeight();
		
		super.paintComponent(g);
		
		
		
		double ratioX = (double)width/DRAWING_WIDTH;
		double ratioY = (double)width/DRAWING_HEIGHT;
		
		((Graphics2D)g).scale(ratioX,ratioY);
		
		
		hunter.draw(g, this);
		runner.draw(g, this);
		item.draw(g, this);
		
		g.setColor(Color.YELLOW);
    	String a = "Coin Counter: " + score;
    	g.drawString(a, 10, 25);
    	String statsR = Runner.stat;
    	g.drawString(statsR, 10, 375);
    	String statsH = Hunter.stat;
    	g.drawString(statsH, 10, 415);
		
    	//Checks if hunter caught runner
		if(runner.getX() > hunter.getX() - 32 && runner.getX() < hunter.getX() + 42 && runner.getY() < hunter.getY() + 52 && runner.getY() > hunter.getY() - 52) {
			
			runner.setX(0);
			runner.setY(0);
			hunter.setX(0);
			hunter.setY(0);
			runner.setSpeedH(0);
			runner.setSpeedV(0);
			hunter.setSpeedH(0);
			hunter.setSpeedV(0);
			
			runner.setDead(true);
			hunter.setDead(true);
			isCoin = false;
			g.setColor(Color.RED);
			g.fillRect(0, 0, DRAWING_WIDTH, DRAWING_HEIGHT);
			g.setColor(Color.BLACK);
	    	g.setFont(new Font("SansSerif",Font.BOLD,30));
	    	String s = "Hunter WINS!";
	    	g.drawString(s, 300, height/5);
	    	String e = "Hunter caught the Runner";
	    	g.drawString(e, 215, height/4);
	    	String r = "Press Space to Restart";
	    	g.drawString(r, 230, height/4 + 35);
	    	counter = 0;
	    	win = true;
		}
		
		//Checks if runner got 3 coins
		if(score >= 3) {
			
			runner.setDead(true);
			hunter.setDead(true);
			g.setColor(Color.RED);
			g.fillRect(0, 0, DRAWING_WIDTH, DRAWING_HEIGHT);
			g.setColor(Color.BLACK);
	    	g.setFont(new Font("SansSerif",Font.BOLD,30));
	    	String s = "RUNNER WINS!";
	    	g.drawString(s, 300, height/5);
	    	String e = "Runner collected 3 coins";
	    	g.drawString(e, 225, height/4);
	    	String r = "Press Space to Restart";
	    	g.drawString(r, 235, height/4 + 35);

	    	win = true;
		}
		
		//Did runner get item
		if(runner.getX() > item.getX() - 32 && runner.getX() < item.getX() + 42 && runner.getY() < item.getY() + 52 && runner.getY() > item.getY() - 52) {
			item.actionR();
			if(isCoin == true) {
				score++;
				isCoin = false;
			}
			else{
				Runner.touch = true;
				Hunter.touch = true;
			}
			counter = 150000000;

		}
		
		//Did hunter get item
		if(hunter.getX() > item.getX() - 32 && hunter.getX() < item.getX() + 42 && hunter.getY() < item.getY() + 52 && hunter.getY() > item.getY() - 52) {
			item.actionH();
			counter = 150000000;
		}
		
		
		
	}
	
	
	public void keyPressed(KeyEvent a) {

		//Moves runner/hunter
		if (a.getKeyCode() == KeyEvent.VK_LEFT ) {
			hunter.moveHorizontal(-0.2);
		}  
		if (a.getKeyCode() == KeyEvent.VK_RIGHT) {
			hunter.moveHorizontal(0.2);
		}  
		if (a.getKeyCode() == KeyEvent.VK_UP) {
			hunter.moveUp(-0.2);
		} 
		if (a.getKeyCode() == KeyEvent.VK_DOWN) {
			hunter.moveUp(0.2);
		}
		if (a.getKeyCode() == KeyEvent.VK_A) {
			runner.moveHorizontal(-0.25);
		}  
		if (a.getKeyCode() == KeyEvent.VK_D) {
			runner.moveHorizontal(0.25);
		}  
		if (a.getKeyCode() == KeyEvent.VK_W) {
			runner.moveUp(-0.25);
		} 
		if (a.getKeyCode() == KeyEvent.VK_S) {
			runner.moveUp(0.25);
		}
		if(a.getKeyCode() == KeyEvent.VK_SPACE) {
			hunter.respawn();
			runner.respawn();
			reset();
				
			
			
		}
		
	}
	
	
	
	public void keyReleased(KeyEvent e) {
		

		//Stops moving runner/hunter
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			if(hunter.speedH == -0.2 || hunter.speedH == -0.2*1.5  || hunter.speedH == -0.2/1.5 || hunter.speedH == -0.2*1.5/1.5) {
				hunter.moveHorizontal(0);
			}
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if(hunter.speedH == 0.2 || hunter.speedH == 0.2*1.5  || hunter.speedH == 0.2/1.5 || hunter.speedH == 0.2*1.5/1.5) {
				hunter.moveHorizontal(0);
			}
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			if(hunter.speedV == -0.2 || hunter.speedV == -0.2*1.5  || hunter.speedV == -0.2/1.5 || hunter.speedV == -0.2*1.5/1.5) {
				hunter.moveUp(0);
			}
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			if(hunter.speedV == 0.2 || hunter.speedV == 0.2*1.5 || hunter.speedV == 0.2/1.5 || hunter.speedV == 0.2*1.5/1.5) {
				hunter.moveUp(0);
			}
		} else if (e.getKeyCode() == KeyEvent.VK_A) {
			if(runner.speedH == -0.25 ||runner.speedH == -0.25*1.5  || runner.speedH == -0.25/1.5) {
				runner.moveHorizontal(0);
			}
		} else if (e.getKeyCode() == KeyEvent.VK_D) {
			if(runner.speedH == 0.25 || runner.speedH == 0.25*1.5 || runner.speedH == 0.25/1.5) {
				runner.moveHorizontal(0);
			}
		} else if (e.getKeyCode() == KeyEvent.VK_W) {
			if(runner.speedV == -0.25 || runner.speedV == -0.25*1.5 || runner.speedV == -0.25/1.5) {
				runner.moveUp(0);
			}
		} else if (e.getKeyCode() == KeyEvent.VK_S) {
			if(runner.speedV == 0.25 || runner.speedV == 0.25*1.5 || runner.speedV == 0.25/1.5) {
				runner.moveUp(0);
			}
		}
	}

	public void keyTyped(KeyEvent e) {

	}
	
	public void stayOnWindowRunner(Runner r) {
		
		//Makes runner/hunter stay on the window		
		if (runner.getX() < 0) {
			runner.setX(0);
		}
		if (runner.getX() > Window.width/1.92) {
			runner.setX(Window.width/1.92);
		}
		if (runner.getY() < 0) {
			runner.setY(0);
		}
		if (runner.getY() > Window.height/2.2) {
			runner.setY(Window.height/2.2);
		}
	}
	
	public void stayOnWindowHunter(Hunter r) {
		
		//Makes runner/hunter stay on the window	
		if (hunter.getX() < 0) {
			hunter.setX(0);
		}
		if (hunter.getX() > Window.width/1.92) {
			hunter.setX(Window.width/1.92);
		}
		if (hunter.getY() < 0) {
			hunter.setY(0);
		}
		if (hunter.getY() > Window.height/2.2) {
			hunter.setY(Window.height/2.2);
		}
	}
	
	
	//Runs/redoes everything
	public void run() {
		
		
		while(true) {

			stayOnWindowRunner(runner);
			stayOnWindowHunter(hunter);
		
			
			repaint();
			

			//spawns new item every ~10 seconds
			if(counter%150000000 == 0) {
				if(type < 26 && win == false) {	
				item = new Coin(x, y);
				isCoin = true;
				
				}
				if(type > 25 && type < 60) {
					item = new Drink(x,y);
				}
				if(type > 59 && type < 95) {
					item = new Web(x,y);
				}
				if(type > 94) {
					item = new Coin(x, y);
					isCoin = true;
				}
				
				type = random.nextInt(101);
			    x = random.nextInt(700);
			    y = random.nextInt(400);
			}
			counter++;

		}
	}
	
	//resets score when game over
	public void reset () {
		while (win == true){
			score = 0;
			win = false;
		}
	}
	

}
