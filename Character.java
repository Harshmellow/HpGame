package fun1;

import java.awt.Color;
import java.awt.Graphics;

public class Character {
	
	private int height;
	private int width;
	private int x = 0;
	private int y = 0;
	
	Character(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public void paintComponent(Graphics g){
		g.setColor(Color.red);
		g.fillRect(0, 450 - getCharacterHeight(), width, height);
	}
	
	public int getCharacterHeight(){
		return height;
	}
	
	public int getCharacterWidth(){
		return width;
	}
}
