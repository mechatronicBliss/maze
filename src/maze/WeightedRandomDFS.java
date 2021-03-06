package maze;

import java.util.ArrayList;

/**
 * A rectangular grid generator that may be parametrised to form longer straight corridors or have more branching as desired.
 */
public class WeightedRandomDFS implements RectangularGridGenerator {

	private int size;
	private double difficulty;
	private static final double EPS = 1e-6;
	
	/**
	 * Constructs a new WeightedRandomDFS object to generate mazes of a specified size and difficulty
	 * @param size required size
	 * @param difficulty parameter
	 */
	public WeightedRandomDFS(int size, double difficulty) {
		this.size = size;
		this.difficulty = difficulty;
	}
	
	/**
	 * Removes walls from a grid of fully walled tiles to form a maze.
	 * @return maze
	 */
	public ArrayList<ArrayList<Tile>> generate() {
		ArrayList<ArrayList<Boolean>> seen = new ArrayList<ArrayList<Boolean>>();
		ArrayList<ArrayList<Tile>> maze = new ArrayList<ArrayList<Tile>>();
		for (int i = 0; i < size; i++) {
			maze.add(new ArrayList<Tile>());
			for (int j = 0; j < size; j++) {
				maze.get(i).add(new Tile((size-1-i)*size+j)); // index x-y
			}
			seen.add(new ArrayList<Boolean>());
			for (int j = 0; j < size; j++) {
				seen.get(i).add(new Boolean(false));
			}
		}

		seen.get(0).set(0,true);
		Tile tile = maze.get(0).get(0);
		weightedRandomDFS(maze,seen,tile,null);
		
		return maze;
	}

	/**
	 * Performs a random DFS, weighted to favour the last move for longer corridors, or against it for greater branching
	 * @param maze 2D array of tiles
	 * @param seen tiles already expanded
	 * @param tile current tile
	 * @param lastDir direction of last move
	 */
	private void weightedRandomDFS(ArrayList<ArrayList<Tile>> maze, ArrayList<ArrayList<Boolean>> seen, Tile tile, Integer lastDir) {
		double pN = 0, pE = 0, pS = 0, pW = 0;
		int index = tile.getIndex();
		int x = index/size, y = index%size;
		seen.get(x).set(y,true);
		
		// check possible moves
		if (y != size - 1 && !seen.get(x).get(y+1)) {
			pN = 1;
			if (lastDir == Tile.NORTH) {
				pN += difficulty;
			}
		}
		if (x != size - 1 && !seen.get(x+1).get(y)) {
			pE = 1;
			if (lastDir == Tile.EAST) {
				pE += difficulty;
			}
		}
		if (y != 0 && !seen.get(x).get(y-1)) {
			pS = 1;
			if (lastDir == Tile.SOUTH) {
				pS += difficulty;
			}
		}
		if (x != 0 && !seen.get(x-1).get(y)) {
			pW = 1;
			if (lastDir == Tile.WEST) {
				pW += difficulty;
			}
		}
		
		// repeat until all possible moves made
		while (pN + pE + pS + pW > EPS) {
			// normalise
			double total = pN + pE + pS + pW;
			pN /= total;
			pE /= total;
			pS /= total;
			pW /= total;
			
			// make move from a sample of this probability distribution
			double sample = Math.random();
			if (sample < pN) {
				removeWall(maze.get(x).get(y),maze.get(x).get(y+1));
				weightedRandomDFS(maze,seen,maze.get(x).get(y+1),Tile.NORTH);
				pN = 0;
			} else if (sample < pN + pE) {
				removeWall(maze.get(x).get(y),maze.get(x+1).get(y));
				weightedRandomDFS(maze,seen,maze.get(x+1).get(y),Tile.EAST);
				pE = 0;
			} else if (sample < pN + pE + pS) {
				removeWall(maze.get(x).get(y),maze.get(x).get(y-1));
				weightedRandomDFS(maze,seen,maze.get(x).get(y-1),Tile.SOUTH);
				pS = 0;
			} else {
				removeWall(maze.get(x).get(y),maze.get(x-1).get(y));
				weightedRandomDFS(maze,seen,maze.get(x-1).get(y),Tile.WEST);				
				pW = 0;
			}
		}
	}

	
	/**removes the walls between 2 Tiles
	 * @precondition tiles a and b adjacent
	 * @param a
	 * @param b
	 */
	private void removeWall(Tile a, Tile b) {
		
		int ai = a.getIndex(), bi = b.getIndex();
		//System.out.println("remove wall between " +a.getIndex() +" and " +b.getIndex());
		if (ai - bi == size) {
			//n is above temp
			a.removeWall(Tile.WEST);
			b.removeWall(Tile.EAST);
		} else if (ai - bi == -size) {
			//n is below temp
			a.removeWall(Tile.EAST);
			b.removeWall(Tile.WEST);
		} else if (ai - bi == 1) {
			//n is to the right
			a.removeWall(Tile.SOUTH);
			b.removeWall(Tile.NORTH);
		} else if (ai - bi == -1) {
			//n is to the left
			a.removeWall(Tile.NORTH);
			b.removeWall(Tile.SOUTH);
		} else {
			System.out.println("di problem");
		}
	}	
}
