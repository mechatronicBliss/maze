package maze;

import javax.swing.*;
import java.awt.*;

public class Box extends JComponent {
	private boolean left;
	private boolean right;
	private boolean top;
	private boolean bottom;
	private Image player;
	private Image mazeBackground;
    private boolean active;
    private boolean isFinal;
    int size;
    
    //size of the maze 
    private final int mazeSize = 600;
    private int pixelSize;
    
	public Box(int size, boolean left, boolean right, boolean top, boolean bottom, 
			Image player, Image mazeBackground, boolean isFinal) {
		this.top =top;
		this.bottom = bottom;
		this.left = left;
		this.right = right;
		this.player = player;
		this.mazeBackground = mazeBackground;
        this.active = false;
        this.isFinal = isFinal;
        
        this.size = size; 
		setVisible(true);
		
		this.pixelSize = mazeSize/size;
        setPreferredSize(new Dimension(pixelSize, pixelSize));
	}
	
	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(mazeBackground, 0, 0, (pixelSize), (pixelSize), null);
		if(left) {
			g2d.drawLine(0, 0, 0, (pixelSize) - 1 );
		}
		if(top) {
			g2d.drawLine(0, 0, (pixelSize) - 1, 0);
		}
		
		if(bottom) {
			g2d.drawLine(0, (pixelSize) - 1, (pixelSize) - 1, (pixelSize) - 1);
		}
		if(right) {
			g2d.drawLine((pixelSize) - 1, 0, (pixelSize) - 1, (pixelSize) - 1);
	
		}
		if(isFinal){
			g2d.setColor(Color.RED);
			g2d.fillRect(0, 0, (pixelSize) - 1, (pixelSize) - 1);
		}
		if(active){
			//g2d.drawOval(0, 0, 15, 19);
			//g2d.setColor(Color.BLUE);
			//g2d.fillOval(0, 0, 15, 19);
			System.out.println(" enters player loop");
			boolean character = g2d.drawImage(player, 0, 0, (pixelSize) - 3, (pixelSize) - 3, null);
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
