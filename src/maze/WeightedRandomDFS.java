package maze;

import java.util.ArrayList;

public class WeightedRandomDFS implements RectangularGridGenerator {

	private int size;
	private double difficulty;
	
	public WeightedRandomDFS(int size, double difficulty) {
		this.size = size;
		this.difficulty = difficulty;
	}
	
	public ArrayList<ArrayList<Tile>> generate() {
		ArrayList<ArrayList<Boolean>> seen = new ArrayList<ArrayList<Boolean>>(size);
		ArrayList<ArrayList<Tile>> maze = new ArrayList<ArrayList<Tile>>(size);
		for (int i = 0; i < size; i++) {
			maze.set(i,new ArrayList<Tile>(size));
			for (int j = 0; j < size; j++) {
				maze.get(i).set(j, new Tile((size-1-i)*size+j)); // index x-y, change to i*size+j for i-j
			}
			seen.set(i,new ArrayList<Boolean>(size));
		}

		// TODO change if start to be changed
		seen.get(0).set(0,true);
		Tile tile = maze.get(0).get(0);
		weightedRandomDFS(maze,seen,tile,null);
		
		return maze;
	}

	private void weightedRandomDFS(ArrayList<ArrayList<Tile>> maze, ArrayList<ArrayList<Boolean>> seen, Tile tile, Integer lastDir) {
		double pN = 0, pE = 0, pS = 0, pW = 0;
		int index = tile.getIndex();
		int x = index/size, y = index%size;
		seen.get(x).set(y,true);
		if (y != size - 1 && !seen.get(x).get(y+1)) {
			pN = 1;
		}
		if (x != size - 1 && !seen.get(x+1).get(y)) {
			pE = 1;
		}
		if (y != 0 && !seen.get(x).get(y-1)) {
			pS = 1;
		}
		if (x != 0 && !seen.get(x-1).get(y)) {
			pW = 1;
		}
		while (pN + pE + pS + pW > 1e-6) {
			double total = pN + pE + pS + pW;
			pN /= total;
			pE /= total;
			pS /= total;
			pW /= total;
			double sample = Math.random();
			if (sample < pN) {
				weightedRandomDFS(maze,seen,maze.get(x).get(y+1),Tile.NORTH);
				pN = 0;
			} else if (sample < pN + pE) {
				weightedRandomDFS(maze,seen,maze.get(x+1).get(y),Tile.NORTH);
				pE = 0;
			} else if (sample < pN + pE + pS) {
				weightedRandomDFS(maze,seen,maze.get(x).get(y-1),Tile.NORTH);
				pS = 0;
			} else {
				weightedRandomDFS(maze,seen,maze.get(x-1).get(y),Tile.NORTH);				
				pW = 0;
			}
		}
	}

	
	/**removes the walls between 2 Tiles (assumes its given adjacent Tiles!!!)
	 * 
	 * @param size
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
