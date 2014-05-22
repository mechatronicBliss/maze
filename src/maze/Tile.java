package maze;

import java.util.HashMap;
import java.util.Map;

public class Tile {
	public static final Integer NORTH = 0;
	public static final Integer EAST = 1;
	public static final Integer SOUTH = 2;
	public static final Integer WEST = 3;
	
	private Map<Integer, Boolean> walls;
	private int index;
	private boolean hasPlayer;
	
	public Tile(int index) {
		walls = new HashMap<Integer, Boolean>();
		walls.put(NORTH, true);
		walls.put(EAST, true);
		walls.put(SOUTH, true);
		walls.put(WEST, true);
		this.index = index;
		this.hasPlayer = false;
	}
	
	public void setPlayer(boolean b){
		this.hasPlayer = b;
	}
	
	public boolean hasPlayer(){
		return this.hasPlayer;
	}
	
    public void addWall(Integer dir) { 
        walls.put(dir, true); 
    }

    public void removeWall(Integer dir) {
		walls.put(dir, false);
	}

    public boolean canMove(Integer dir) { 
        return !walls.get(dir); 
    } 
      
    public boolean hasWall(Integer dir) { 
        return walls.get(dir); 
    } 
      
          
    public int getIndex() { 
        return index; 
    } 
}