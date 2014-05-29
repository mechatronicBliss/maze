package maze;

import java.util.ArrayList;
import java.util.Stack;

/**
 * A grid of tiles.
 */
public interface Grid {
	/**
	 * Retrieves the size of the grid
	 * @return size
	 */
	public int getSize();
	
	/**
	 * Retrieves the start position
	 * @return start position
	 */
	public Tile getSource();
	
	/**
	 * Retrieves the finish position
	 * @return finish position
	 */
	public Tile getDestination();
	
	/**
	 * Retrieves the underlying 2D array of tiles
	 * @return tile array
	 */
	public ArrayList<ArrayList<Tile>> getTiles();
	
	/**
	 * Checks if a move from a specified tile in a certain direction is valid
	 * @param tile current tile
	 * @param direction intended move direction
	 * @return whether or not the move is possible
	 */
	public boolean isValidMove(Tile tile, Integer direction);

	/**
	 * Retrieve the neighbour of a specified tile in a certain direction, ignoring walls
	 * @param tile current tile
	 * @param direction direction
	 * @return neighbouring tile, or null if none exists
	 */
	public Tile getNeighbour(Tile tile, Integer direction);

	/**
	 * Performs a BFS to find the shortest path to the goal
	 * @param current current tile
	 * @return sequence of tiles to traverse to reach the goal
	 */
	public Stack<Tile> getHelp(Tile current);
}