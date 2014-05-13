package maze;

public class Tile {
	private boolean hasNorthWall;
	private boolean hasEastWall;
	private boolean hasSouthWall;
	private boolean hasWestWall;
	
	public static final int NORTH = 0;
	public static final int EAST = 1;
	public static final int SOUTH = 2;
	public static final int WEST = 3;
	
	public Tile(boolean hasNorthWall, boolean hasEastWall, boolean hasSouthWall, boolean hasWestWall) {
		this.hasNorthWall = hasNorthWall;
		this.hasEastWall = hasEastWall;
		this.hasSouthWall = hasSouthWall;
		this.hasWestWall = hasWestWall;
	}
	
	public boolean canMove(int direction) {
		boolean ret = true;
		if (direction == NORTH && hasNorthWall)
			ret = false;
		if (direction == EAST && hasEastWall)
			ret = false;
		if (direction == SOUTH && hasSouthWall)
			ret = false;
		if (direction == WEST && hasWestWall)
			ret = false;
		return ret;
	}
}
