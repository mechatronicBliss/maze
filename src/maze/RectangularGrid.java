package maze;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

/**
 * A rectangular grid of tiles.
 */
public class RectangularGrid implements Grid {
	private int size;
	private ArrayList< ArrayList<Tile> > tiles;
	
	/**
	 * Constructs a new rectangular grid of a specified size and difficulty
	 * @param size required size
	 * @param p difficulty parameter
	 */
	public RectangularGrid(int size, double p) {
		this.size = size;
		// generate grid using Strategy design pattern
		RectangularGridGenerator generator = new RandomDFS(size, p);
		this.tiles = generator.generate();
	}
	
	/**
	 * Retrieves the 2D array of tiles
	 * @return tile array
	 */
	public ArrayList<ArrayList<Tile>> getTiles() {
		return tiles;
	}
	
	/**
	 * Retrieves the size
	 * @return size
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * Checks if a move from a specified tile in a certain direction is valid
	 * @precondition direction is either Tile.NORTH, Tile.EAST, Tile.SOUTH or Tile.WEST
	 * @param tile current tile
	 * @param direction intended move direction
	 * @return whether or not the move is possible
	 */
	public boolean isValidMove(Tile tile, Integer direction) {
		return tile.canMove(direction);
	}
	
	/**
	 * Retrieve start position
	 * @return start position
	 */
	public Tile getSource() {
		return tiles.get(0).get(0);
	}

	/**
	 * Retrieve finish position
	 * @return finish position
	 */
	public Tile getDestination() {
		return tiles.get(size-1).get(size-1);
	}
	
	/**
	 * Retrieve the neighbour of a specified tile in a certain direction, ignoring walls
	 * @param tile current tile
	 * @param direction direction
	 * @return neighbouring tile, or null if none exists
	 */
	public Tile getNeighbour(Tile tile, Integer direction) {
		Tile ret = null;
		int index = tile.getIndex();
		int x = index/size;
		int y = index%size;
		if (direction.equals(Tile.NORTH) && y < size-1) {
			ret = tiles.get(x).get(y+1);
		} else if (direction.equals(Tile.SOUTH) && y > 0) {
			ret = tiles.get(x).get(y-1);
		} else if (direction.equals(Tile.EAST) && x < size-1) {
			ret = tiles.get(x+1).get(y);
		} else if (direction.equals(Tile.WEST) && x > 0) {
			ret = tiles.get(x-1).get(y);
		}
		return ret;
	}
	
	/**
	 * Performs a BFS to find the shortest path to the goal
	 * @param current current tile
	 * @return sequence of tiles to traverse to reach the goal
	 */
	public Stack<Tile> getHelp(Tile current) {
		
		Tile goal = getDestination();
		Queue<Tile> toVisit = new LinkedList<Tile>();
		List<Tile> seen = new ArrayList<Tile>();
		Map<Tile, Tile> parents = new HashMap<Tile, Tile>();
		Stack<Tile> moves = new Stack<Tile>();

		toVisit.add(current);
		parents.put(current, null);
		Tile tmp = null;
		
		boolean found = false;
		
		while (!toVisit.isEmpty() && !found) {
			Tile tile = toVisit.poll();
			seen.add(tile);
		
			if (tile.equals(goal)) {
				// if we have reached the goal, form the stack of parents from the BFS tree
				found = true;
				while (parents.get(tile) != null) {
					tmp = parents.get(tile);
					moves.push(tmp);
					tile = tmp;
				}
			} else {
				// otherwise try moving in each direction
				if (tile.canMove(Tile.NORTH)) {
					tmp = getNeighbour(tile, Tile.NORTH);
					if (!seen.contains(tmp)) {
						parents.put(tmp, tile);
						toVisit.add(tmp);
					}
				}
				if (tile.canMove(Tile.EAST)) {
					tmp = getNeighbour(tile, Tile.EAST);
					if (!seen.contains(tmp)) {
						parents.put(tmp, tile);
						toVisit.add(tmp);
					}
				}
				if (tile.canMove(Tile.SOUTH)) {
					tmp = getNeighbour(tile, Tile.SOUTH);
					if (!seen.contains(tmp)) {
						parents.put(tmp, tile);
						toVisit.add(tmp);
					}
				}
				if (tile.canMove(Tile.WEST)) {
					tmp = getNeighbour(tile, Tile.WEST);
					if (!seen.contains(tmp)) {
						parents.put(tmp, tile);
						toVisit.add(tmp);
					}
				}
			}			
		}
		
		return moves;
	}
}
