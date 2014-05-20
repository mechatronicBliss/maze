package maze;

import java.util.HashMap;
import java.util.Map;

public class Tile {
	public static final Integer NORTH = 0;
	public static final Integer EAST = 1;
	public static final Integer SOUTH = 2;
	public static final Integer WEST = 3;
	
	private Map<Integer, Boolean> walls;	
	
	public Tile() {
		walls = new HashMap<Integer, Boolean>();
		walls.put(NORTH, true);
		walls.put(EAST, true);
		walls.put(SOUTH, true);
		walls.put(WEST, true);
	}
	
	public void removeWall(Integer dir) {
		walls.put(dir, false);
	}

	public boolean canMove(Integer dir) {
		return walls.containsKey(dir) && !walls.get(dir);
	}
}
