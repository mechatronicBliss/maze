package maze;

import javax.swing.*;
import java.awt.*;

public class Box extends JComponent {
	private boolean left;
	private boolean right;
	private boolean top;
	private boolean bottom;
	public Box(boolean left, boolean right, boolean top, boolean bottom) {
		this.top =top;
		this.bottom = bottom;
		this.left = left;
		this.right = right;
		setVisible(true);
        setPreferredSize(new Dimension(50,50));
	}
	
	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		if(left) {
			g2d.drawLine(0, 0, 0, 49);
		}
		if(top) {
			g2d.drawLine(0, 0, 49, 0);
		}
		
		if(bottom) {
			g2d.drawLine(0, 49, 49, 49);
		}
		if(right) {
			g2d.drawLine(49, 0, 49, 49);
		}
		
	}
}
