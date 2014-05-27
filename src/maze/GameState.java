package maze;

import java.util.Stack;

public class GameState {
	private Maze maze;
	//private KeyListenerMaze k; 
	
	public GameState(int size, double p) {
		this.maze = new Maze(size, p);
		//this.k = new KeyListenerMaze(this);
	}
	
	public Maze getMaze() {
		return maze;
	}
	
	public boolean processMoveRequest(Integer dir) {
        boolean canMove = false;
		if (maze.isValidMove(dir)) {
			maze.makeMove(dir);
			System.out.println("made move to"+  dir);
            canMove = true;
		} else {
			// TODO flag error, e.g. pulse blocking wall (or fail quietly)
            canMove = false;
		}
		
		if (maze.isSolved()) {
			// TODO win screen
		}
        return canMove;
	}
	
	public void getHelp() {
		Tile nextTile = maze.getHelp().firstElement();
		// TODO display, e.g. pulse this tile
	}
	
	public void getSolution() {
		Stack<Tile> solution = maze.getHelp();
		// TODO display
	}
}
