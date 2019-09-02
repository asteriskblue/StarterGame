import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class map1 {
	
	object p1;
	object p2;
	
	object t;
	
	ArrayList<object> tseries = new ArrayList<object>(); //tseries gang
	object t1;
	object t2;
	object t3;
	object t4;
	object t5;
	object t6;
	
	
	int s1;
	int s2;

	public map1() {
		
		this.p1 = new object(100, 100, 20, 20, Color.RED);
		this.p2 = new object(300, 100, 20, 20, Color.BLUE);
		
		this.t = new object(200, 200, 20, 20, Color.GREEN);
		this.t1 = new object(200, 75, 40, 20, Color.BLACK); //make tseries
		this.t2 = new object(50, 50, 20, 80, Color.BLACK);
		this.t3 = new object(25, 25, 100, 20, Color.BLACK);
		this.t4 = new object(425, 100, 20, 64, Color.BLACK);
		this.t5 = new object(400, 200, 30, 30, Color.BLACK);
		this.t6 = new object(375, 250, 90, 10, Color.BLACK);
		
		tseries.add(t1); //add to tseries
		tseries.add(t2);
		tseries.add(t3);
		tseries.add(t4);
		tseries.add(t5);
		tseries.add(t6);
		
		s1 = 0;
		s2 = 0;
	}
	
	public void draw(Graphics g) {
		
		p1.draw(g);
		p2.draw(g);
		
		t.draw(g);
		t1.draw(g);
		t2.draw(g);
		t3.draw(g);
		t4.draw(g);
		t5.draw(g);
		t6.draw(g);
		
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
	
	public void relocate1() { // relocates all tseries 
		for (int i = 0; i < 6; i++) {
		int nx = (int)(Math.random() * 400);
		int ny = (int)(Math.random() * 400);
		
		tseries.get(i).x = nx; tseries.get(i).y = ny;
		}
	}
	
	public void collision() { //when touched, relocate if tseries, -1 1, if green boi, +1
		
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
			relocate1();
		}
		
		if(p2.getHitBox().intersects(t.getHitBox())) {
			s2++;
			relocate();
			relocate1();
		}
		
		if(p1.getHitBox().intersects(t1.getHitBox())) {
			s1--;
			relocate1();
		}
		
		if(p2.getHitBox().intersects(t1.getHitBox())) {
			s2--;
			relocate1();
		}
		if(p1.getHitBox().intersects(t2.getHitBox())) {
			s1--;
			relocate1();
		}
		
		if(p2.getHitBox().intersects(t2.getHitBox())) {
			s2--;
			relocate1();
		}
		if(p1.getHitBox().intersects(t3.getHitBox())) {
			s1--;
			relocate1();
		}
		
		if(p2.getHitBox().intersects(t3.getHitBox())) {
			s2--;
			relocate1();
		}
		if(p1.getHitBox().intersects(t4.getHitBox())) {
			s1--;
			relocate1();
		}
		
		if(p2.getHitBox().intersects(t4.getHitBox())) {
			s2--;
			relocate1();
		}
		if(p1.getHitBox().intersects(t5.getHitBox())) {
			s1--;
			relocate1();
		}
		
		if(p2.getHitBox().intersects(t5.getHitBox())) {
			s2--;
			relocate1();
		}
		if(p1.getHitBox().intersects(t6.getHitBox())) {
			s1--;
			relocate1();
		}
		
		if(p2.getHitBox().intersects(t6.getHitBox())) {
			s2--;
			relocate1();
		}
		
	}
	
}
