package maze;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class KeyListenerMaze extends JPanel implements KeyListener{
	
	private GameState current; 
	
	public KeyListenerMaze(GameState current){
		this.current = current;
		addKeyListener(this);
		setFocusable(true);
		//SET TO TRUE IF WE WANT TO USE SHIFT AND TAB	
		setFocusTraversalKeysEnabled(false);
	}
	@Override
	public void keyPressed(KeyEvent e) {
		int action = e.getKeyCode();
		
		// for left, up, right, down 
		//e.g. gamestate is valid move ( tile.NORTH) 
		if (action == KeyEvent.VK_DOWN){
			current.processMoveRequest(Tile.SOUTH);	
		} if(action == KeyEvent.VK_UP){
			current.processMoveRequest(Tile.NORTH);
		} if(action == KeyEvent.VK_LEFT){
			current.processMoveRequest(Tile.WEST);
		} if(action == KeyEvent.VK_RIGHT){
			current.processMoveRequest(Tile.EAST);
		}
		
		//for a s w d keys
		if (action == KeyEvent.VK_S){
			current.processMoveRequest(Tile.SOUTH);
		} if(action == KeyEvent.VK_W){
			current.processMoveRequest(Tile.NORTH);
		} if(action == KeyEvent.VK_A){
			current.processMoveRequest(Tile.WEST);
		} if(action == KeyEvent.VK_D){
			current.processMoveRequest(Tile.EAST);
		}
		
	}

	//does not need to do anything
	@Override
	public void keyReleased(KeyEvent arg0) {}

	//does not type anything
	@Override
	public void keyTyped(KeyEvent arg0) {}

}
