import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.Timer;

public class main extends JPanel implements ActionListener {

	private static final long serialVersionUID = 7278894226467689035L;
	private Timer timer;
	private final int DELAY = 10;
	String state;
	
	title t;
	map m;
	map1 m1; 
	map2 m2;

	public main() {
		addKeyListener(new KAdapter());
		addMouseListener(new MAdapter());

		setFocusable(true);
		setBackground(Color.WHITE);

		setFont(new Font("Arial", 0, 16));

		this.timer = new Timer(DELAY, this);
		this.timer.start();

		this.state = "title";
		
		t = new title();
		m = new map();
		m1 = new map1();
		m2 = new map2();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		doDrawing(g);

		Toolkit.getDefaultToolkit().sync();
	}

	private void doDrawing(Graphics g) {
		if(state == "title") t.draw(g);
		if(state == "map") m.draw(g);
		if(state == "map1") m1.draw(g);
		if(state == "map2") m2.draw(g);
	}

	public void actionPerformed(ActionEvent e) {
		
		if(state == "title") t.move();
		if(state == "map") m.move();
		if(state == "map1") m1.move();
		if(state == "map2") m2.move();
		
		repaint();
	}

	private class KAdapter extends KeyAdapter {

		private KAdapter() {
		}

		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			
			if(state == "map") {
				if(key == KeyEvent.VK_W) m.p1.dy = -3;
				if(key == KeyEvent.VK_A) m.p1.dx = -3;
				if(key == KeyEvent.VK_S) m.p1.dy = 3;
				if(key == KeyEvent.VK_D) m.p1.dx = 3;
				
				if(key == KeyEvent.VK_UP) m.p2.dy = -3;
				if(key == KeyEvent.VK_LEFT) m.p2.dx = -3;
				if(key == KeyEvent.VK_DOWN) m.p2.dy = 3;
				if(key == KeyEvent.VK_RIGHT) m.p2.dx = 3;
			}
			
			if(state == "map1") {
				if(key == KeyEvent.VK_W) m1.p1.dy = -3;
				if(key == KeyEvent.VK_A) m1.p1.dx = -3;
				if(key == KeyEvent.VK_S) m1.p1.dy = 3;
				if(key == KeyEvent.VK_D) m1.p1.dx = 3;
				
				if(key == KeyEvent.VK_UP) m1.p2.dy = -3;
				if(key == KeyEvent.VK_LEFT) m1.p2.dx = -3;
				if(key == KeyEvent.VK_DOWN) m1.p2.dy = 3;
				if(key == KeyEvent.VK_RIGHT) m1.p2.dx = 3;
			}
			
			if(state == "map2") {
				if(key == KeyEvent.VK_W) m2.p1.dy = -3;
				if(key == KeyEvent.VK_A) m2.p1.dx = -3;
				if(key == KeyEvent.VK_S) m2.p1.dy = 3;
				if(key == KeyEvent.VK_D) m2.p1.dx = 3;
				
				if(key == KeyEvent.VK_UP) m2.c.dy = -3;
				if(key == KeyEvent.VK_LEFT) m2.c.dx = -3;
				if(key == KeyEvent.VK_DOWN) m2.c.dy = 3;
				if(key == KeyEvent.VK_RIGHT) m2.c.dx = 3;
			}
			
		}

		public void keyReleased(KeyEvent e) {
			int key = e.getKeyCode();
			
			if(state == "title") {
				if(key == KeyEvent.VK_SPACE) state = "map";
				if(key == KeyEvent.VK_SHIFT) state = "map1";
				if(key == KeyEvent.VK_Z) state = "map2";
			}
			
			if(state == "map") {
				if(key == KeyEvent.VK_R) state = "title";
				
				if(key == KeyEvent.VK_W) m.p1.dy = 0;
				if(key == KeyEvent.VK_A) m.p1.dx = 0;
				if(key == KeyEvent.VK_S) m.p1.dy = 0;
				if(key == KeyEvent.VK_D) m.p1.dx = 0;
				
				if(key == KeyEvent.VK_UP) m.p2.dy = 0;
				if(key == KeyEvent.VK_LEFT) m.p2.dx = 0;
				if(key == KeyEvent.VK_DOWN) m.p2.dy = 0;
				if(key == KeyEvent.VK_RIGHT) m.p2.dx = 0;
			}
			
			if(state == "map1") {
				if(key == KeyEvent.VK_R) state = "title";
				
				if(key == KeyEvent.VK_W) m1.p1.dy = 0;
				if(key == KeyEvent.VK_A) m1.p1.dx = 0;
				if(key == KeyEvent.VK_S) m1.p1.dy = 0;
				if(key == KeyEvent.VK_D) m1.p1.dx = 0;
				
				if(key == KeyEvent.VK_UP) m1.p2.dy = 0;
				if(key == KeyEvent.VK_LEFT) m1.p2.dx = 0;
				if(key == KeyEvent.VK_DOWN) m1.p2.dy = 0;
				if(key == KeyEvent.VK_RIGHT) m1.p2.dx = 0;
			}
			
			if(state == "map2") {
				if(key == KeyEvent.VK_R) state = "title";
				
				if(key == KeyEvent.VK_W) m2.p1.dy = 0;
				if(key == KeyEvent.VK_A) m2.p1.dx = 0;
				if(key == KeyEvent.VK_S) m2.p1.dy = 0;
				if(key == KeyEvent.VK_D) m2.p1.dx = 0;
				
				if(key == KeyEvent.VK_UP) m2.c.dy = 0;
				if(key == KeyEvent.VK_LEFT) m2.c.dx = 0;
				if(key == KeyEvent.VK_DOWN) m2.c.dy = 0;
				if(key == KeyEvent.VK_RIGHT) m2.c.dx = 0;
			}
			
		}
	}

	private class MAdapter extends MouseAdapter {

		private MAdapter() {
		}

		public void mousePressed(MouseEvent e) {
			int mx = e.getX();
			int my = e.getY();

			Rectangle mr = new Rectangle(mx, my, 1, 1);
		}

		public void mouseReleased(MouseEvent e) {
			int mx = e.getX();
			int my = e.getY();

			Rectangle mr = new Rectangle(mx, my, 1, 1);
		}
	}
}
