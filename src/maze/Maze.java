package maze;

import java.awt.Image;
import java.util.Stack;

import javax.swing.ImageIcon;

/**
 * A maze, storing the internal representation of the maze game
 */
public class Maze {
	private Tile characterLocation;
	private Grid grid;
	
	/**
	 * Constructs a new maze of the specified size and difficulty
	 * @param size grid size
	 * @param p difficulty parameter
	 */
	public Maze(int size, double p) {
		this.grid = new RectangularGrid(size, p);
		this.characterLocation = grid.getSource();
		
	}
	
	/**
	 * Retrieves the start position
	 * @return start position
	 */
	public Tile StartPos(){
		Tile t = grid.getTiles().get(0).get(0);
		return t;
	}
	
	/**
	 * Retrieves the underlying grid
	 * @return grid
	 */
	public Grid getGrid() {
		return grid;
	}
	
	/**
	 * Checks whether a move can be made in the specified direction
	 * @param dir direction
	 * @return whether or not the move can be made
	 */
	public boolean isValidMove(Integer dir) {
		return characterLocation.canMove(dir);
	}
	
	/**
	 * Performs a move
	 * @precondition move is valid
	 * @param dir direction
	 */
	public void makeMove(Integer dir) {
		characterLocation = grid.getNeighbour(characterLocation,dir);
	}

	/**
	 * Retrieves a stack of tiles, which when traversed in order form a shortest path to the goal
	 * @return solution
	 */
	public Stack<Tile> getHelp() {
		return grid.getHelp(characterLocation);
	}
}
