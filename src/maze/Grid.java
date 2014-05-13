package maze;

import java.util.ArrayList;

public class Grid {
	private int size;
	private ArrayList< ArrayList<Tile> > tiles;
	
	public Grid(int size) {
		this.size = size;
		this.tiles = new ArrayList< ArrayList<Tile> >(size);
		for (int i = 0; i < size; i++) {
			tiles.set(i, new ArrayList<Tile>(size));
			for (int j = 0; j < size; j++) {
				tiles.get(i).set(j, new Tile(false, false, false, false));
			}
		}
	}
	
	public int getSize() {
		return size;
	}
	
	public boolean isValidMove(int row, int col, int direction) {
		return tiles.get(row).get(col).canMove(direction);
	}
}
