package maze;

public class GameState {
	private Maze maze;
	private HelpGen helper;
	
	public GameState(int size) {
		this.maze = new Maze(size);
		this.helper = new HelpGen();
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
		// TODO retrieve top move from stack
	}
	
	public void getSolution() {
		// TODO use entire stack
	}
}
