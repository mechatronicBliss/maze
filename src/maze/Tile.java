package maze;

import java.util.HashMap;
import java.util.Map;

/**
 * An indexed tile, with walls in up to four compass directions.
 */
public class Tile {
	// public constants representing directions
	public static final Integer NORTH = 0;
	public static final Integer EAST = 1;
	public static final Integer SOUTH = 2;
	public static final Integer WEST = 3;
	
	private Map<Integer, Boolean> walls;
	private int index;
	private boolean hasPlayer;
	
	/**
	 * Constructs a new Tile with full walls and the specified index
	 * @param index required index
	 */
	public Tile(int index) {
		walls = new HashMap<Integer, Boolean>();
		walls.put(NORTH, true);
		walls.put(EAST, true);
		walls.put(SOUTH, true);
		walls.put(WEST, true);
		this.index = index;
		this.hasPlayer = false;
	}
	
	/**
	 * Updates whether or not the tile is occupied by the player.
	 * @param b true if occupied, false if not
	 */
	public void setPlayer(boolean b){
		this.hasPlayer = b;
	}

	/**
	 * Checks whether or not the tile is occupied by the player.
	 * @return true if occupied, false if not
	 */
	public boolean hasPlayer(){
		return this.hasPlayer;
	}
	
	/**
	 * Adds a wall in the specified direction.
	 * @precondition dir is either Tile.NORTH, Tile.EAST, Tile.SOUTH or Tile.WEST
	 * @param dir direction
	 */
    public void addWall(Integer dir) { 
        walls.put(dir, true);
    }

    /**
	 * Removes a wall in the specified direction.
	 * @precondition dir is either Tile.NORTH, Tile.EAST, Tile.SOUTH or Tile.WEST
	 * @param dir direction
     */
    public void removeWall(Integer dir) {
		walls.put(dir, false);
	}

    /**
	 * Checks whether a move can be made in the specified direction.
	 * @precondition dir is either Tile.NORTH, Tile.EAST, Tile.SOUTH or Tile.WEST
	 * @param dir direction
	 */
    public boolean canMove(Integer dir) { 
        return !walls.get(dir); 
    } 
      
    /**
	 * Checks whether a wall exists in the specified direction.
	 * @precondition dir is either Tile.NORTH, Tile.EAST, Tile.SOUTH or Tile.WEST
	 * @param dir direction
	 */
    public boolean hasWall(Integer dir) { 
        return walls.get(dir); 
    } 
      
    /**
     * Retrieves the index of the tile
     * @return index
     */
    public int getIndex() { 
        return index; 
    } 
}