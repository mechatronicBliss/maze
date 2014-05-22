package maze;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class RectangularGrid implements Grid {
	private int size;
	private ArrayList< ArrayList<Tile> > tiles;
	
	public RectangularGrid(int size) {
		this.size = size;
		RectangularGridGenerator generator = new RandomDFS();
		this.tiles = generator.generate(size);
	}
	
	public ArrayList<ArrayList<Tile>> getTiles() {
		return tiles;
	}
	
	public int getSize() {
		return size;
	}
	
	public boolean isValidMove(Tile tile, Integer direction) {
		return tile.canMove(direction);
	}
	
	public Tile getSource() {
		return tiles.get(0).get(0);
	}

	public Tile getDestination() {
		return tiles.get(size-1).get(size-1);
	}
	
	/**
	 * @param tile
	 * @param direction
	 * @return
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
	
	/**does a BFS to find the goal
	 * and returns the path as a stack<Tile>
	 * 
	 * @param grid
	 * @param start
	 * @param goal
	 * @return
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
				found = true;
				while (parents.get(tile) != null) {
					tmp = parents.get(tile);
					moves.push(tmp);
					tile = tmp;
				}
			} else {
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
