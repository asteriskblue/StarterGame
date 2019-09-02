import java.awt.Color;

public class computer extends object{
	
	int tx = 0;
	int ty = 0;
	
	
	public computer(int x, int y, int w, int h, Color c) {
		super(x, y, w, h, c);
	}
	
	public void move() {
		// if treasure is to the right, move right
		if(tx > x) dx = 2;
		// if treasure is to the left, move left
		else if(tx < x) dx = -2;
		// if treasure is directly above/below, don't move
		else dx = 0;
			
		// same thing but for vertical movement
		if(ty > y) dy = 2;
		else if(ty < y) dy = -2;
		else dy = 0;
			
		// remember, the old move method adds dx and dy to the current coordinates
		// we just set the dx and dy and the computer moves just like a player would
		super.move();
	}

}
