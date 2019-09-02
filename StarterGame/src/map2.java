import java.awt.Color;
import java.awt.Graphics;

public class map2 {
	
	object p1;
	computer c;
	
	object t;
	
	int s1;
	int s2;

	public map2() {
		
		this.p1 = new object(100, 100, 20, 20, Color.RED);
		this.c = new computer(300, 100, 20, 20, Color.BLACK);
		
		this.t = new object(200, 100, 20, 20, Color.GREEN);
		
		s1 = 0;
		s2 = 0;
		
		// relocate the treasure immediately
		relocate();
	}
	
	public void draw(Graphics g) {
		
		p1.draw(g);
		c.draw(g);
		
		t.draw(g);
		
		g.setColor(Color.BLACK);
		g.drawString("P1: " + s1 + "          C: " + s2, 10, 480);
	}
	
	public void move() {
		
		p1.move();
		// the computer moves just like the player but...
		// their move function is sligthly different!
		c.move();
		
		collision();
	}
	
	public void relocate() {
		int nx = (int)(Math.random() * 480);
		int ny = (int)(Math.random() * 480);
		
		t.x = nx; t.y = ny;
		// updated the computer's treasure coordinates
		c.tx = nx; c.ty = ny;
	}
	
	public void collision() {
		
		if(p1.x < 0) p1.x = 0;
		if(p1.x > 500 - p1.w) p1.x = 500 - p1.w;
		if(p1.y < 0) p1.y = 0;
		if(p1.y > 500 - p1.h) p1.y = 500 - p1.h;
		
		if(c.x < 0) c.x = 0;
		if(c.x > 500 - c.w) c.x = 500 - c.w;
		if(c.y < 0) c.y = 0;
		if(c.y > 500 - c.h) c.y = 500 - c.h;
		
		if(p1.getHitBox().intersects(t.getHitBox())) {
			s1++;
			relocate();
		}
		
		if(c.getHitBox().intersects(t.getHitBox())) {
			s2++;
			relocate();
		}
		
		
	}
	
}
