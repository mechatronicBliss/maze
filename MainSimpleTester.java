package temp;



import java.util.ArrayList;
import java.util.Scanner;

public class MainSimpleTester {

	public static void main (String args[]) {
		
		MazeGen sys = new MazeGen();
		
		
	    @SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
	    System.out.println("Please enter mazer size");
	    int size = sc.nextInt();
		
		mTestv2(sys.generate(size));
		
		//gTest();
		
		

	}
	
	
	private static void mTestv2(ArrayList<ArrayList<Tile>> maze) {
		int size = maze.size();
		Tile tmp = null;
		
		for (int i = size -1; i > -1; i--) {
			for (int j = 0; j < size; j++) {
				tmp = maze.get(i).get(j);
				System.out.println("cell " +tmp.getIndex());
				System.out.println("northWall = " +tmp.canMove("north"));
				System.out.println("eastWall = " +tmp.canMove("east"));
				System.out.println("southWall = " +tmp.canMove("south"));
				System.out.println("westWall = " +tmp.canMove("west") +'\n');
				
			}			
		}		
	}
	
	
	
	
	
	
	@SuppressWarnings("unused")
	private static void mTest(ArrayList<ArrayList<Tile>> maze) {
		
		int foo = 3, bar = 4;
		System.out.println(foo +", " +bar +" can move north = " +maze.get(foo).get(bar).canMove("north"));
		System.out.println(foo +", " +bar +" can move east = " +maze.get(foo).get(bar).canMove("east"));
		System.out.println(foo +", " +bar +" can move south = " +maze.get(foo).get(bar).canMove("south"));
		System.out.println(foo +", " +bar +" can move west = " +maze.get(foo).get(bar).canMove("west"));
		
		
		//for each row, starting top to bottom
		int size = maze.size();
		
		for (int i = size -1; i > -1; i--) {
			//System.out.print('|');
			for (int j = 0; j < size -1; j++) {
				//System.out.println("i = " +i +" j = " +j);
				if (!maze.get(j).get(i).canMove("north")) {
					System.out.print("*----");
				} else {
					System.out.print("     ");
				}
			}
			System.out.print('\n');
			
			System.out.print('|');
			for (int j = 0; j < size; j++) {
				if (!maze.get(j).get(i).canMove("east")) {
					System.out.print("&   ");
				} else {
					System.out.print("|  ");
				}
			}
			System.out.print('\n');
		}
		for (int j = 0; j < (size -1); j++) {
			System.out.print("------");
		}
	}


	@SuppressWarnings("unused")
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
