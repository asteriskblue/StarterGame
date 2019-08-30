import java.awt.Color;
import java.awt.Graphics;

public class map {
	
	object p1;
	object p2;
	
	object t;
	
	int s1;
	int s2;

	public map() {
		
		this.p1 = new object(100, 100, 20, 20, Color.RED);
		this.p2 = new object(300, 100, 20, 20, Color.BLUE);
		
		this.t = new object(200, 100, 20, 20, Color.GREEN);
		
		s1 = 0;
		s2 = 0;
	}
	
	public void draw(Graphics g) {
		
		p1.draw(g);
		p2.draw(g);
		
		t.draw(g);
		
		g.setColor(Color.BLACK);
		g.drawString("P1: " + s1 + "          P2: " + s2, 10, 480);
	}
	
	public void move() {
		
		p1.move();
		p2.move();
		
		collision();
	}
	
	public void relocate() {
		int nx = (int)(Math.random() * 480);
		int ny = (int)(Math.random() * 480);
		
		t.x = nx; t.y = ny;
	}
	
	public void collision() {
		
		if(p1.x < 0) p1.x = 0;
		if(p1.x > 500 - p1.w) p1.x = 500 - p1.w;
		if(p1.y < 0) p1.y = 0;
		if(p1.y > 500 - p1.h) p1.y = 500 - p1.h;
		
		if(p2.x < 0) p2.x = 0;
		if(p2.x > 500 - p2.w) p2.x = 500 - p2.w;
		if(p2.y < 0) p2.y = 0;
		if(p2.y > 500 - p2.h) p2.y = 500 - p2.h;
		
		if(p1.getHitBox().intersects(t.getHitBox())) {
			s1++;
			relocate();
		}
		
		if(p2.getHitBox().intersects(t.getHitBox())) {
			s2++;
			relocate();
		}
		
	}
	
}
