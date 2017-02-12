package fun1;

import java.awt.Color;

import javax.swing.JFrame;

public class GUI extends JFrame {
	
	
	GameGraphics game = new GameGraphics(); 
	JFrame fr = new JFrame();
	
	
	
	GUI(){
		
		super("PreAlpha .06");
		
		
		fr.add(game);
		fr.getContentPane().setBackground(Color.black);
		
		fr.setSize(1280, 600);
		fr.setVisible(true);
		fr.setLocationRelativeTo(null);
		fr.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	
}
