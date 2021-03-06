package maze;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

/**
 * @author Simon Rob, Simon Briggs, Jason Le, Raveen de
 *
 */

/**
 * Maze UI is the representation of the maze 
 *
 */

public class MazeUi extends JPanel {
    private Maze m;
    private int playerX;
    private int playerY;
    private int size;
    private int collectables;
    private GameInterface gameController;
    private ArrayList<ArrayList<Box>> boxes;
    private boolean usingCollectables;
    private Images imgs;
    private boolean instructions;
    
    /**
     * The maze UI sets up the maze, given the back end
     * representation of the maze. 
     * @param size the size of the maze
     * @param m the backend maze itself
     * @param gameController the game interace 
     * @param usingCollectables a boolean whether or not the user wanted collectables
     * @param imgs a class in which contains all the images 
     */
	public MazeUi(int size, Maze m, GameInterface gameController, boolean usingCollectables, Images imgs) {
        this.imgs = imgs;
        collectables = 0;
        this.m = m;
        this.instructions = true;
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		this.boxes = new ArrayList<ArrayList<Box>>();
        this.size = size;
        c.ipadx = 0;
        c.ipady = 0;
        c.weightx = 0;
        c.weighty = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridy = 0;
        this.playerX = 0;
        this.playerY = 0;
        this.gameController = gameController;
        this.usingCollectables = usingCollectables;
        //creating new player
        m.getGrid().getTiles().get(0).get(0).setPlayer(true);
        
        for(int i = 0; i < size; i++) {
            boxes.add(i, new ArrayList<Box>());
        }
        for(int i = size-1; i > -1; i--) {
        	
        	for(int j = 0; j < size; j++) {
                c.gridx = j;
                
                Tile t = m.getGrid().getTiles().get(j).get(i);
        		Box b = new Box(size, t.hasWall(Tile.WEST), t.hasWall(Tile.EAST), t.hasWall(Tile.NORTH), t.hasWall(Tile.SOUTH), imgs);
        		this.add(b,c);
                boxes.get(i).add(b);
        	}
            c.gridy++;
        }
        int k = 0;
        if(usingCollectables) {
            while(k < size) {
                int x = (int) Math.floor(Math.random()*size);
                int y = (int) Math.floor(Math.random()*size);
                if(!boxes.get(x).get(y).isCollectable() && !(y == size-1 && x == size -1)) {
                    boxes.get(x).get(y).setCollectable(true);
                    k++;
                }
            }
        }
        else {
            boxes.get(size-1).get(size-1).activateWinningBox();
        }
        JButton exit = new JButton("Exit");
        exit.setActionCommand("exit");
        exit.addActionListener(gameController);
        exit.setOpaque(false);
        c.gridy = 0;
        c.gridx = size;
        c.gridheight = 2;
        this.add(exit, c);
        boxes.get(playerY).get(playerX).activate();
        this.validate();
        this.repaint();
       
	}
	
	/**
	 * move updates the player movements and repaints them.
	 * Additionally move also checks if the user is in the 
	 * winning games state, which is the right hand corner tile.
	 * If collectables is active the willing game state is 
	 * when all collectables are collected and the user finishes on
	 * the final tile
	 * @param direction of the playermovement as a int
	 */
    public void move(int direction) {
        Box b = boxes.get(playerY).get(playerX);
        b.deactivate();
        if(direction == Tile.NORTH) {
            playerY++;
        }
        else if(direction == Tile.SOUTH) {
            playerY--;
        }
        else if(direction == Tile.EAST) {
            playerX++;
        }
        else if(direction == Tile.WEST) {
            playerX--;
        }
        if(playerX == size -1 && playerY == size -1 && usingCollectables){
        	
        	if(collectables == size) {
        		JOptionPane.showMessageDialog(null, gameController.getVictoryMessage());
        		gameController.restart();
        	} else {
        		JOptionPane.showMessageDialog(null, "Please collect all the collectables.");
        	}
        }
        else if(playerX == size -1 && playerY == size -1 && !usingCollectables) {
            JOptionPane.showMessageDialog(null, gameController.getVictoryMessage());
            gameController.restart();
        }
        b = boxes.get(playerY).get(playerX);
        b.activate();
        if(b.isCollectable()) {
            collectables++;
            if(collectables == size) {
                boxes.get(size-1).get(size-1).activateWinningBox();
            }
            b.setCollectable(false);
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(imgs.getFrameBackground(), 0, 0, 1400, 1000, null);
    }
}
