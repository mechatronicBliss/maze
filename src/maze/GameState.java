package maze;

import java.util.Stack;

public class GameState {
	private Maze maze;
	private KeyListenerMaze k; 
	
	public GameState(int size) {
		this.maze = new Maze(size);
		this.k = new KeyListenerMaze(this);
	}
	
	public Maze getMaze() {
		return maze;
	}
	
	public void processMoveRequest(Integer dir) {
		if (maze.isValidMove(dir)) {
			maze.makeMove(dir);
		} else {
			// TODO flag error, e.g. pulse blocking wall (or fail quietly)
		}
		
		if (maze.isSolved()) {
			// TODO win screen
		}
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
