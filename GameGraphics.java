package fun1;

//Graphics
import java.awt.Color;
import java.awt.Graphics;
//Events
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.JComponent;
import javax.swing.Timer;

import com.sun.glass.events.KeyEvent; //Sorta deprecated ... So not finalSolution


@SuppressWarnings("restriction")
public class GameGraphics extends JComponent implements ActionListener , KeyListener{
	
	private  float gravity = -.2f;
	
	private  float terminalVelocity = 200f; //Max Of parabola
	private  float acceleration = .2f;
	//private  double speed;
	
	int floorX = 200 , floorY = 450;
	int playerHeight = 100 , playerWidth = 50;
	int playerX = floorX, playerY = 450 - playerHeight;
	
	GameGraphics()
	{
		Timer t = new Timer(30, this); //change this to 60fps later
		t.start();
		addKeyListener(this);
		
	}
	
	public void paintComponent(Graphics g)
	{
		/**
		 * Creates A gridLine that can be used to position Shapes 
		 * @returns Grid
		 */
		super.paintComponent(g);
		
		g.setColor(Color.green);
		int squareSize = 25; 
		int row, col, x = 0, y = 0; //Creates the Starting Points at the Top left
		//Gets the Total width of the screen and creates 25 boxes
		int num = this.getWidth() / squareSize + 1;
		//
		for (row = 0; row < num; row++)
		{	y = row * squareSize;
		for (col = 0; col < num; col++)
		{	x = col * squareSize;
		g.drawRect(x, y, squareSize, squareSize);
		if (x==0){
		g.drawString("" + y, x+2, y+11);
		}
		if (y==0){
		g.drawString("" + x, x+2, y+11);
		}
		//g.drawString("(" + x + ", " + y + ")", x+3, y+10);
		}	
		}
		//---------------------------------------------------------------------
		
		//Heres some triangles if you need them
		
			int[] traingleX = {
				50,
				80,
				20
			};
				
			int[] traingleY = {
				70,
				20,
				20
			};
		//---------------------------------------------------------------------
		
		//Character model = new Character();
		
		g.setColor(Color.red);
		g.fillRect(floorX, floorY , getWidth() - 400, 25);
		
		//Player Model
		
		g.setColor(Color.blue);
		g.fillRect(playerX, playerY, playerWidth, playerHeight);
		
		repaint();
	}
	
	
	//Takes in Events
	public void actionPerformed (ActionEvent e){
		
		//Gravity
		if(playerY < terminalVelocity){
			playerY -= acceleration;
			System.out.println("Falling back down");
		}
		else if(playerY > terminalVelocity){
			playerY += gravity;
			System.out.println("Going up");
		}
		
		
		requestFocusInWindow();
		repaint();
	}
	
	
	
	//Keylistener
	public void keyPressed(java.awt.event.KeyEvent e) 
	{
		int keyCode =  e.getKeyCode();
		
		switch(keyCode) 
		    {  
		
		        case KeyEvent.VK_UP:
		        	playerY -= 50;
		        	break;
		        case KeyEvent.VK_DOWN:
		        	if(playerY > floorY){
		        		playerY += 25;
		        	}
		        	break;
		        case KeyEvent.VK_LEFT:
		        	playerX -= 25;
		        	break;
		        case KeyEvent.VK_RIGHT:
		        	playerX += 25;
		        	break;
		   }
			//Diaganol Movement
		 	if(keyCode == KeyEvent.VK_UP && keyCode == KeyEvent.VK_RIGHT){
		    	playerX += 40;
		    	playerY -= 40;
		    }
		    
		    else if(keyCode == KeyEvent.VK_UP && keyCode == KeyEvent.VK_LEFT){
		    	playerX -= 40;
		    	playerY += 40; 
		    }
	}

	
	@Override
	public void keyReleased(java.awt.event.KeyEvent e) 
	{
		int keyCode =  e.getKeyCode();
		
		switch(keyCode)
		{
		case KeyEvent.VK_UP:
			playerY += 50;
			if(playerY < floorY){
				playerY = 0;
			}
		}
	}


	@Override
	public void keyTyped(java.awt.event.KeyEvent arg0) {
		
		
	}
}
	
	
	