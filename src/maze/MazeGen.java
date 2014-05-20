package temp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;
import java.util.Stack;

public class MazeGen {

	public MazeGen() {
	}

	/**makes a square maze of size "size"
	 * 
	 * @param size
	 * @return
	 */
	public ArrayList<ArrayList<Tile>> generate(int size) {
		SimpleGraph<Tile> g = new SimpleGraphImp<Tile>();
		Tile tmp = null;
		int index = 0;

		//create tiles in 2d array and add to graph
		ArrayList<ArrayList<Tile>> maze = new ArrayList<ArrayList<Tile>>();
		for (int i = 0; i < size; i++) {
			maze.add(new ArrayList<Tile>());
			
			for (int j = 0; j < size; j++) {
				tmp = new Tile(index);
				index++;
				maze.get(i).add(tmp);
				g.addNode(tmp);
				//vertical connections
				if (j > 0) {
					g.addLink(maze.get(i).get(j-1), tmp);
				}
				//lateral connections
				if (i > 0) {
					g.addLink(maze.get(i-1).get(j), tmp);
				}
			}	
		}
		//remove some walls
		randomDFS(g, maze, size);
		return maze;
	}

	/**random DFS removing walls in between nodes as it traverses (creating maze)
	 * 
	 * @param g
	 * @param maze
	 * @param size
	 */

	private void randomDFS(SimpleGraph<Tile> g, ArrayList<ArrayList<Tile>> maze, int size) {
		
		ArrayList<Tile> seen = new ArrayList<Tile>();
		Stack<Tile> toVisit = new Stack<Tile>();
		HashMap<Tile, Tile> parents = new HashMap<Tile, Tile>();
		ArrayList<Tile> shuffled = new ArrayList<Tile>();
		
		Tile n = g.getMysteryNode();
		toVisit.push(n);

		while (!toVisit.isEmpty()) {
			n = toVisit.pop();
			seen.add(n);
			
			//get connected nodes and shuffle them
			shuffled = g.getConnected(n);
			long seed = System.nanoTime();
			Collections.shuffle(shuffled, new Random(seed));
			Collections.shuffle(shuffled, new Random(seed));
			
			//add to stack & store parents
			for (Tile t : shuffled) {
				if (!seen.contains(t)) {
					parents.put(t, n);
					toVisit.push(t);
				}
			}
			
			//remove the wall between n and its parent
			if (!toVisit.empty()) {
				if (parents.containsKey(n)) {
					removeWall(maze.size(), n, parents.get(n));
				} 
			}
		}
		//for the last Tile
		removeWall(maze.size(), n, parents.get(n));
		
		/*
		//dirty fix for boundaries
		for (int j = 0; j < size; j++) {
			maze.get(j).get(0).addWall("south");
			maze.get(j).get(size -1).addWall("north");
			
			maze.get(0).get(j).addWall("west");
			maze.get(size -1).get(j).addWall("east");
		}
		*/
		
	}

	
	/**removes the walls between 2 Tiles (assumes its given adjacent Tiles!!!)
	 * 
	 * @param size
	 * @param a
	 * @param b
	 */
	private void removeWall(int size, Tile a, Tile b) {

		int ai = a.getIndex(), bi = b.getIndex();
		//System.out.println("remove wall between " +a.getIndex() +" and " +b.getIndex());
		if (ai - bi == size) {
			//n is above temp
			a.removeWall("west");
			b.removeWall("east");
		} else if (ai - bi == -size) {
			//n is below temp
			a.removeWall("east");
			b.removeWall("west");
		} else if (ai - bi == 1) {
			//n is to the right
			a.removeWall("south");
			b.removeWall("north");
		} else if (ai - bi == -1) {
			//n is to the left
			a.removeWall("north");
			b.removeWall("south");
		} else {
			System.out.println("di problem");
		}
	}

	

	public void testRemoveWall() {
		Tile x = new Tile(14), y = new Tile (19);
		removeWall(5, x, y);
		System.out.println(x.getIndex() +"'s walls");
		System.out.println("northWall = " +x.hasWall("north"));
		System.out.println("eastWall = " +x.hasWall("east"));
		System.out.println("southWall = " +x.hasWall("south"));
		System.out.println("westWall = " +x.hasWall("west") +'\n');
		
		System.out.println(y.getIndex() +"'s walls");
		System.out.println("northWall = " +y.hasWall("north"));
		System.out.println("eastWall = " +y.hasWall("east"));
		System.out.println("southWall = " +y.hasWall("south"));
		System.out.println("westWall = " +y.hasWall("west") +'\n');

		Tile z = new Tile(11), q = new Tile(12);
		removeWall(5, z, q);
		System.out.println(z.getIndex() +"'s walls");
		System.out.println("northWall = " +z.hasWall("north"));
		System.out.println("eastWall = " +z.hasWall("east"));
		System.out.println("southWall = " +z.hasWall("south"));
		System.out.println("westWall = " +z.hasWall("west") +'\n');
		
		System.out.println(q.getIndex() +"'s walls");
		System.out.println("northWall = " +q.hasWall("north"));
		System.out.println("eastWall = " +q.hasWall("east"));
		System.out.println("southWall = " +q.hasWall("south"));
		System.out.println("westWall = " +q.hasWall("west") +'\n');
		
	}
	
}