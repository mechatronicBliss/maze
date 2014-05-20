package maze;

import java.util.ArrayList;

public class SimpleGraphImp<E> implements SimpleGraph<E> {

	private ArrayList<ArrayList<E>> connections;
	private ArrayList<E> nodes;
	
	public SimpleGraphImp() {
		connections = new ArrayList<ArrayList<E>>();
		nodes = new ArrayList<E>();
	}
	
	public void addNode(E e) {
		nodes.add(e);
		connections.add(new ArrayList<E>());
	}

	public void addLink(E e1, E e2) {
		int i = nodes.indexOf(e1);
		connections.get(i).add(e2);
		i = nodes.indexOf(e2);
		connections.get(i).add(e1);
	}

	public E getMysteryNode() {
		E ret = null;
		if (!nodes.isEmpty()) {
			int min = 0;
			int max = nodes.size();
			
			ret = nodes.get( (min + (int)(Math.random() * ((max - min) + 1))) % max );
		}
		
		return ret;
		
	}
	
	public ArrayList<E> getConnected(E e) {
		ArrayList<E> result = new ArrayList<E>();
		result.addAll(connections.get(nodes.indexOf(e)));
		
		return result;
	}

	public boolean isConnected(E e1, E e2) { 
        return connections.get(nodes.indexOf(e1)).contains(e2); 
    } 
}
