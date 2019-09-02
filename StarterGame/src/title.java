import java.awt.Color;
import java.awt.Graphics;

public class title {
	

	public title() {
		
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawString("This is the title", 100, 100);
		g.drawString("Start Game: Space", 100, 130);
		g.drawString("Start Game1: Shift", 100, 160);
	}
	
	public void move() {
		

	}
	
}
