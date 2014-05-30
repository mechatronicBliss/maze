package maze;

import javax.swing.*;

import java.awt.*;

/**
 * 
 * @author Simon Rob, Simon Briggs, Jason Le, Raveen de
 *
 */

/**
 * The front end representation of tile
 *
 */
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
    
    /**
     * This class constructs and paints each tile in the
     * maze corresponding to whether they have the 
     * left, right, top and bottom walls there.
     * Additionally it also pains each tile corresponding to
     * the theme the user choose
     * @param size
     * @param left is this wall active
     * @param right is this wall active
     * @param top is this wall active
     * @param bottom is this wall active
     * @param all a class in which contains all the images
     */
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
        if(left && !(all.getTheme() == 4)) {
            g2d.drawImage(wallImage, 0, 0, (pixelSize) / 8, (pixelSize), null);
        }
        if(top && !(all.getTheme() == 4)) {
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
        if(top && all.getTheme() == 4) {
            g2d.drawImage(wallImage, 0, 0, (pixelSize), (pixelSize) / 8, null);
        }
        if(left && all.getTheme() == 4) {
            g2d.drawImage(wallImage, 0, 0, (pixelSize) / 8, (pixelSize), null);
        }
	}
	
	/**
	 * sets the box to have a player inside it
	 */
    public void activate() {
        this.active = true;
        repaint();
    }
    
    /**
     * sets the box to not have a player in it
     */
    public void deactivate() {
        this.active = false;
        repaint();
    }
    /**
     * sets the final box when all collectables have
     * been collected
     */
    public void activateWinningBox() {
        this.isFinal = true;
        repaint();
    }
    
    public boolean isCollectable() {
        return this.hasCollectable;
    }
    /**
     * sets this box to contain a collectable
     * @param hasCollectable does this box have a collectable
     */
    public void setCollectable(boolean hasCollectable) {
        this.hasCollectable = hasCollectable;
        repaint();
    }
}
