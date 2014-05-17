package temp;


import java.util.HashMap;


public class Tile {
	
	private HashMap<String, Boolean> walls;
	
	
	public Tile() {
		walls = new HashMap<String, Boolean>();
		walls.put("north", true);
		walls.put("east", true);
		walls.put("south", true);
		walls.put("west", true);
	}
	
	public void removeWall(String s) {
		walls.remove(s);
		walls.put(s, false);
	}

	public boolean canMove(String dir) {
		boolean ret = false;
		if (walls.get(dir)) {
			ret = true;
		}
		return ret;
	}
}
