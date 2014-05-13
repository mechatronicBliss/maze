package maze;

import java.util.ArrayList;
import java.util.HashMap;

public class RectangularGrid implements Grid {
	private int size;
	private ArrayList< ArrayList<Tile> > tiles;
	
	public RectangularGrid(int size) {
		this.size = size;
		this.tiles = new ArrayList< ArrayList<Tile> >(size);
		for (int i = 0; i < size; i++) {
			tiles.set(i, new ArrayList<Tile>(size));
			for (int j = 0; j < size; j++) {
				tiles.get(i).set(j, new Tile(new HashMap<Integer,Tile>()));
			}
		}
		// generate grid
	}
	
	public int getSize() {
		return size;
	}
	
	public boolean isValidMove(Tile tile, int direction) {
		return tile.canMove(direction);
	}
}
