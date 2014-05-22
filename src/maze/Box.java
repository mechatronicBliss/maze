package maze;

import javax.swing.*;
import java.awt.*;

public class Box extends JComponent {
	private boolean left;
	private boolean right;
	private boolean top;
	private boolean bottom;
    private boolean hasCharacter;
	public Box(boolean left, boolean right, boolean top, boolean bottom) {
		this.top =top;
		this.bottom = bottom;
		this.left = left;
		this.right = right;
        this.hasCharacter = false;
		setVisible(true);
        setPreferredSize(new Dimension(20,20));
	}

    public boolean isPopulated() {
        return hasCharacter;
    }

    public void setPopulation(boolean isPopulated) {
        this.hasCharacter = isPopulated;
        repaint();
    }
	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		if(left) {
			g2d.drawLine(0, 0, 0, 19);
		}
		if(top) {
			g2d.drawLine(0, 0, 19, 0);
		}
		
		if(bottom) {
			g2d.drawLine(0, 19, 19, 19);
		}
		if(right) {
			g2d.drawLine(19, 0, 19, 19);
		}
        if(hasCharacter) {
            g2d.drawOval(10, 10, 3, 3);
        }
		
	}
}
