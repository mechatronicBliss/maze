package temp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class HelpGen {

	public HelpGen() {
	}
	
	
	/**does a BFS to find the goal
	 * and returns the path as a stack<Tile>
	 * 
	 * @param maze
	 * @param start
	 * @param goal
	 * @return
	 */
	public Stack<Tile> getHelp(ArrayList<ArrayList<Tile>> maze, Tile start, Tile goal) {
		
		Queue<Tile> toVisit = new LinkedList<Tile>();
		ArrayList<Tile> seen = new ArrayList<Tile>();
		HashMap<Tile, Tile> parents = new HashMap<Tile, Tile>();
		
		toVisit.add(start);
		parents.put(start, null);
		Tile n = start, tmp = null;
		
		boolean found = false;
		
		while (!toVisit.isEmpty() && !found) {
			n = toVisit.poll();
			seen.add(n);
			
			if (n.equals(goal)) {
				found = true;
			} else {
				if (n.canMove("north")) {
					tmp = getTile("north", n, maze);
					if (!seen.contains(tmp)) {
						parents.put(tmp, n);
						toVisit.add(tmp);
					}
				}
				if (n.canMove("east")) {
					tmp = getTile("east", n, maze);
					if (!seen.contains(tmp)) {
						parents.put(tmp, n);
						toVisit.add(tmp);
					}
				}
				if (n.canMove("south")) {
					tmp = getTile("south", n, maze);
					if (!seen.contains(tmp)) {
						parents.put(tmp, n);
						toVisit.add(tmp);
					}
				}
				if (n.canMove("west")) {
					tmp = getTile("west", n, maze);
					if (!seen.contains(tmp)) {
						parents.put(tmp, n);
						toVisit.add(tmp);
					}
				}
			}			
		}
		
		Stack<Tile> moves = new Stack<Tile>();
		while (parents.get(n) != null) {
			tmp = parents.get(n);
			moves.push(tmp);
			n = tmp;
		}
		
		return moves;
	}

	
	/**returns the tile adjacent to n in direction dir in maze 
	 * sneaky use of index properties YOLO
	 * 
	 * @param dir
	 * @param n
	 * @param maze
	 * @return
	 */
	private Tile getTile(String dir, Tile n, ArrayList<ArrayList<Tile>> maze) {
		Tile ret = null;
		int size = maze.size();
		int x = n.getIndex() / size;
		int y = n.getIndex() % size;
		
		if (dir.equals("north")) {
			ret = maze.get(x).get(y+1);
		} else if (dir.equals("south")) {
			ret = maze.get(x).get(y-1);
		} else if (dir.equals("east")) {
			ret = maze.get(x+1).get(y);
		} else if (dir.equals("west")) {
			ret = maze.get(x-1).get(y);
		}
		
		return ret;
	}
	
	
}
