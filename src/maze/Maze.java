package maze;

import java.util.Stack;

public class Maze {
	private Tile characterLocation;
	private Grid grid;
	
	public Maze(int size) {
		this.grid = new RectangularGrid(size);
		this.characterLocation = grid.getSource();
	}
	
	public Grid getGrid() {
		return grid;
	}
	
	public boolean isValidMove(Integer dir) {
		return characterLocation.canMove(dir);
	}
	
	public void makeMove(Integer dir) {
		characterLocation = grid.getNeighbour(characterLocation,dir);
	}

	public boolean isSolved() {
		return characterLocation.equals(grid.getDestination());
	}
	
	public Stack<Tile> getHelp() {
		return grid.getHelp(characterLocation);
	}
}
