package temp;


import java.util.HashMap;


public class Tile {
	
	private HashMap<String, Boolean> walls;
	private final int index;
	
	
	public Tile(int i) {
		index = i;
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
		return (!walls.get(dir));
	}
	public int getIndex() {
		return index;
	}
	
	@Override
	public boolean equals(Object x) {
		return (this.index == ((Tile) x).getIndex());
	}
	
}
