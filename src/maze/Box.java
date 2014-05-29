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
	private Image wallImage;
	private Image collectable;
	private Image finalTile;
    private boolean active;
    private boolean isFinal;
    private boolean hasCollectable;
    private Images all;
    int size;
    
    //size of the maze 
    private final int mazeSize = 600;
    private int pixelSize;
    
	public Box(int size, boolean left, boolean right, boolean top, boolean bottom, Images all) {
		this.top =top;
		this.bottom = bottom;
		this.left = left;
		this.right = right;
        this.isFinal= false;
		
        this.hasCollectable = false;
        
        //getting all the images we need
        this.all = all;
        this.player = all.getPlayer();
        this.collectable = all.getCollectables();
		this.mazeBackground = all.getBackground();
		this.wallImage = all.getWallImage();
		this.finalTile = all.getFinalTile();
		
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

		if(isFinal){
			g2d.drawImage(finalTile, 0, 0, (pixelSize), (pixelSize), null);
		}
        if(hasCollectable) {
            boolean character = g2d.drawImage(collectable, 0, 0, (pixelSize) - 3, (pixelSize) - 3, null);
        }
        if(left) {
            g2d.drawImage(wallImage, 0, 0, (pixelSize) / 8, (pixelSize), null);
        }
        if(top) {
            g2d.drawImage(wallImage, 0, 0, (pixelSize), (pixelSize) / 8, null);
        }

        if(bottom) {
            g2d.drawImage(wallImage, 0, (pixelSize) - 2, (pixelSize), (pixelSize) / 3, null);
        }
        if(right) {
            g2d.drawImage(wallImage, (pixelSize) - 3, 0, (pixelSize) / 8, (pixelSize), null);

        }
        if(active){
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
    public void activateWinningBox() {
        this.isFinal = true;
        repaint();
    }
    public boolean isCollectable() {
        return this.hasCollectable;
    }
    public void setCollectable(boolean hasCollectable) {
        this.hasCollectable = hasCollectable;
        repaint();
    }
}
