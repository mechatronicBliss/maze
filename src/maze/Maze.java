package maze;

import java.awt.Image;
import java.util.Stack;

import javax.swing.ImageIcon;

public class Maze {
	private Tile characterLocation;
	private Grid grid;
	
	//the image of player 
	private Image player; 
	//the image of the grass
	private Image mazeBackground;
	//the image of the walls 
	private Image wallImage;
	
	public Maze(int size) {
		this.grid = new RectangularGrid(size);
		this.characterLocation = grid.getSource();
		
		ImageIcon img = new ImageIcon("Superman.png");
		this.player = img.getImage();
		
		img = new ImageIcon("greengrass.JPG");
		this.mazeBackground = img.getImage();
		
		img = new ImageIcon("BrickWall.jpg");
		this.wallImage = img.getImage();
	}
	
	public Image getWallImage(){
		return player;
	}
	
	public Image getPlayer(){
		return player;
	}
	
	public Image getBackground(){
		return mazeBackground;
	}
	
	public Tile StartPos(){
		Tile t = grid.getTiles().get(0).get(0);
		return t;
	}
	
	public Grid getGrid() {
		return grid;
	}
	
	public boolean isValidMove(Integer dir) {
		return characterLocation.canMove(dir);
	}
	
	public void makeMove(Integer dir) {
		characterLocation = grid.getNeighbour(characterLocation,dir);
	}

	public boolean isSolved() {
		return characterLocation.equals(grid.getDestination());
	}
	
	public Stack<Tile> getHelp() {
		return grid.getHelp(characterLocation);
	}
}
