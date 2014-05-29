package maze;

import java.util.Stack;

/**
 * A state of the maze game.
 */
public class GameState {
	private Maze maze;
	//private KeyListenerMaze k; 

	/**
	 * Constructs a new game of the specified size and difficulty
	 * @param size grid size
	 * @param p difficulty parameter
	 */
	public GameState(int size, double p) {
		this.maze = new Maze(size, p);
		//this.k = new KeyListenerMaze(this);
	}
	
	/**
	 * Retrieves the underlying maze
	 * @return maze
	 */
	public Maze getMaze() {
		return maze;
	}
	
	/**
	 * Processes a request to move in a specified direction
	 * @param dir direction
	 * @return whether or not the move was made
	 */
	public boolean processMoveRequest(Integer dir) {
        boolean canMove = false;
        // check if the move can be made, and if so, make the move
        if (maze.isValidMove(dir)) {
			maze.makeMove(dir);
			System.out.println("made move to"+  dir);
            canMove = true;
		} else {
            canMove = false;
		}
		
        return canMove;
	}
	
	/**
	 * Processes a request for a hint, showing the next move
	 */
	public void getHelp() {
		Tile nextTile = maze.getHelp().firstElement();
		// TODO display, e.g. pulse this tile
	}

	/**
	 * Processes a request for help, showing the entire solution
	 */
	public void getSolution() {
		Stack<Tile> solution = maze.getHelp();
		// TODO display
	}
}
