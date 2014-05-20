package maze;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

@SuppressWarnings("unused")
public class MainSimpleTester {

	public static void main (String args[]) {
		
		MazeGen sys = new MazeGen();
		
	    @SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
	    System.out.println("Please enter maze size;");
	    int size = sc.nextInt();
		
	    ArrayList<ArrayList<Tile>> maze = sys.generate(size);
	    mTestv3(maze);
	    helpTest(maze, size);
	    //indexTest(sys.generate(size));
		//gTest();
	}
	
	
	
	private static void helpTest(ArrayList<ArrayList<Tile>> maze, int size) {
		
	    Tile start = maze.get(0).get(0);
	    Tile goal = maze.get(size -1).get(size-1);
	    Tile temp = null;
	    
	    Stack<Tile> moves = maze.getHelp(maze, start, goal);
	    
	    while (!moves.isEmpty()) {
	    	temp = moves.pop();
	    	System.out.print(temp.getIndex() +", ");
	    }
	    System.out.println();
	}



	
	private static void indexTest(ArrayList<ArrayList<Tile>> maze) {
		int size = maze.size();
		for (int i = size -1; i > -1; i--) {
			for (int j = 0; j < size; j++) {
				System.out.print(maze.get(j).get(i).getIndex() +"  ");
			}
			System.out.println();
		}
	}

	private static void mTestv3(ArrayList<ArrayList<Tile>> maze) {
		
		int size = maze.size();
		for (int i = size -1; i > -1; i--) {
			
			for (int j = 0; j < size; j++) {
				if (maze.get(j).get(i).hasWall(Tile.NORTH)) {
					System.out.print("----");
				} else {
					System.out.print("    ");
				}
			}
			System.out.println();
			for (int j = 0; j < size; j++) {
				if (maze.get(j).get(i).hasWall(Tile.WEST)) {
					System.out.print("|   ");
				} else {
					System.out.print("    ");
				}
			}
			System.out.println("|");
		}
		
		//bottom row
		for (int j = 0; j < size; j++) {
			System.out.print("----");
		}
		System.out.println();		
	}

	private static void gTest() {
		//setup
		SimpleGraph<String> g = new SimpleGraphImp<String>();
		g.addNode("A");
		g.addNode("B");
		g.addNode("C");
		g.addNode("D");
		g.addNode("E");
		g.addNode("F");
		g.addNode("G");
		g.addNode("H");
		
		g.addLink("A", "B");
		g.addLink("A", "C");
		g.addLink("A", "D");
		g.addLink("A", "E");
		g.addLink("A", "F");
		g.addLink("A", "G");
		
		g.addLink("B", "C");
		g.addLink("B", "D");
		g.addLink("B", "G");
		g.addLink("B", "F");
		
		g.addLink("C", "E");
		g.addLink("C", "G");
		
		g.addLink("E", "G");

		//tests
		for (int i = 0; i < 15; i++) {
			System.out.println("Mystery node " +g.getMysteryNode());
		}

		System.out.println("A connected" +g.getConnected("A"));
		System.out.println("  Should be B, C, D, E, F, G\n");
		System.out.println("B connected" +g.getConnected("B"));
		System.out.println("  Should be A, C, D, G, F\n");
		System.out.println("C connected" +g.getConnected("C"));
		System.out.println("  Should be A, B, E, G\n");
		System.out.println("D connected" +g.getConnected("D"));
		System.out.println("  Should be A, B\n");
		System.out.println("E connected" +g.getConnected("E"));
		System.out.println("  Should be A, C, G\n");
		System.out.println("F connected" +g.getConnected("F"));
		System.out.println("  Should be A, B\n");
		System.out.println("G connected" +g.getConnected("G"));
		System.out.println("  Should be A, B, C, E\n");
		System.out.println("H connected" +g.getConnected("H"));
		System.out.println("  Should be empty\n");
		
	}
	
	
}
