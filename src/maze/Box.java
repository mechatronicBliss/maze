package maze;

import javax.swing.*;
import java.awt.*;

public class Box extends JComponent {
	private boolean left;
	private boolean right;
	private boolean top;
	private boolean bottom;
	private Image player;
    private boolean active;
    private boolean isFinal;
    
	public Box(boolean left, boolean right, boolean top, boolean bottom, Image player, boolean isFinal) {
		this.top =top;
		this.bottom = bottom;
		this.left = left;
		this.right = right;
		this.player = player;
        this.active = false;
        this.isFinal = isFinal;
        
		setVisible(true);
        setPreferredSize(new Dimension(20,20));
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
		
		if(isFinal){
			g2d.setColor(Color.RED);
			g2d.fillRect(0, 0, 20, 20);
		}
		if(active){
			//g2d.drawOval(0, 0, 15, 19);
			//g2d.setColor(Color.BLUE);
			//g2d.fillOval(0, 0, 15, 19);
			System.out.println(" enters player loop");
			boolean character = g2d.drawImage(player, 0, 0, 19, 19, null);
			System.out.println(character);
		}
	}
    public void activate() {
        this.active = true;
        repaint();
    }
    public void deactivate() {
        this.active = false;
        repaint();
    }
}
