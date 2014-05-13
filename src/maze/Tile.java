package maze;

import java.util.Map;

public class Tile {
	private Map<Integer,Tile> neighbours;
	
	public Tile(Map<Integer,Tile> neighbours) {
		this.neighbours = neighbours;
	}
	
	public boolean canMove(int direction) {
		boolean ret = false;
		if (neighbours.containsKey(direction)) {
			ret = true;
		}
		return ret;
	}
}