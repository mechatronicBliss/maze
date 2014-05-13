package maze;

import java.util.ArrayList;
import java.util.HashMap;

public class RectangularGrid implements Grid {
	private int size;
	private ArrayList< ArrayList<Tile> > tiles;
	
	public RectangularGrid(int size) {
		this.size = size;
		RectangularGridGenerator generator = new RandomDFS(size);
		this.tiles = generator.generate();
	}
	
	public int getSize() {
		return size;
	}
	
	public boolean isValidMove(Tile tile, int direction) {
		return tile.canMove(direction);
	}
}
