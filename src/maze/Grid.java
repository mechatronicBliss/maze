package maze;

import java.util.Stack;

public interface Grid {
	public int getSize();
	public Tile getSource();
	public Tile getDestination();
	public boolean isValidMove(Tile tile, Integer direction);
	public Tile getNeighbour(Tile tile, Integer direction);
	public Stack<Tile> getHelp(Tile current);
}
