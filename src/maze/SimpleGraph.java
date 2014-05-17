package temp;

import java.util.ArrayList;

public interface SimpleGraph<E> {

	public void addNode(E e);
	
	public void addLink(E e1, E e2);
	
	public E getMysteryNode();
	
	public ArrayList<E> getConnected(E e);
	
}
