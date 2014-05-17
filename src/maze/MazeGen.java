package temp;

import java.util.ArrayList;
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
	
		//create tiles in 2d array and add to graph
		ArrayList<ArrayList<Tile>> maze = new ArrayList<ArrayList<Tile>>();
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				tmp = new Tile();
				maze.get(i).add(tmp);
				g.addNode(tmp);
				//vertical connections
				if (j > 0) {
					//TODO check maze.get(i).get(j) return tmp;
					g.addLink(maze.get(i).get(j-1), tmp);
				}
				//lateral connections
				if (i > 0) {
					g.addLink(maze.get(i-1).get(j), tmp);
				}
				
			}	
			maze.add(new ArrayList<Tile>());
		}
		
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
		
		ArrayList<Tile> connected;
		
		Tile n = g.getMysteryNode();
		Tile temp = null;
		
		//TODO remove sneaky early return
		if (n == null) {
			System.out.println("Problem");
			return;
		}
		
		toVisit.push(n);
		//or seen.size() < size, does it matter?
		while (!toVisit.isEmpty()) {
			n = toVisit.pop();
			seen.add(n);					
			
			connected = g.getConnected(n);
			
			//add all the connected nodes
			int i = 0, s = (connected.size());
			while (i < s ) {
				temp = connected.get(i);
				if (!seen.contains(temp)) {
					toVisit.push(temp);
				}
				i++;
			}
			//remove the all between n and temp because moving from n -> temp (cos stack)
			//check for null for the end case
			if (n != null && temp != null) {
				removeWall(maze, n, temp);
			}
			
		}
		
	}

	/**removes the walls between 2 Tiles (assumes its given adjacent Tiles!!!)
	 * 
	 * @param maze
	 * @param n
	 * @param temp
	 */
	private void removeWall(ArrayList<ArrayList<Tile>> maze, Tile n, Tile temp) {
		
		int xn = getX(maze, n), xt = getX(maze, temp);
		int dx = xn - xt;
		int yn = maze.get(xn).indexOf(n), yt = maze.get(xt).indexOf(temp);
		int dy = yn - yt;
		
		//n is to the left of temp
		if (dx == -1) {
			n.removeWall("east");
			temp.removeWall("west");
		//n to the right
		} else if (dx == 1) {
			n.removeWall("west");
			temp.removeWall("east");
		//n is below
		} else if (dy == -1) {
			n.removeWall("north");
			temp.removeWall("south");
		//n is above
		} else if (dy == 1) {
			n.removeWall("south");
			temp.removeWall("north");
		} else {
			System.out.println("we have a dx/dy problem");
		}
		
	}
	
	/**returns X value in maze array
	 * 
	 * @param maze
	 * @param n
	 * @return
	 */
	private int getX(ArrayList<ArrayList<Tile>> maze, Tile n) {
		int x = -1, size = maze.size();
		
		for (int i = 0; i < size; i++) {
			if (maze.get(i).contains(n)) {
				x = i;
				//cheeky, but saves time
				break;
			}
		}
		return x;
	}
	
}