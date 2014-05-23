package maze;

import java.awt.KeyEventDispatcher;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyListenerMaze implements KeyListener, KeyEventDispatcher{
	
	private GameState current;
    private MazeUi m;
	
	public KeyListenerMaze(GameState current, MazeUi m){
		this.current = current;
        this.m = m;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int action = e.getKeyCode();
		
		if (action == KeyEvent.VK_DOWN || action == KeyEvent.VK_S ){
			current.processMoveRequest(Tile.SOUTH);
            m.move(Tile.SOUTH);
			System.out.println("key listener detected south");
		} if(action == KeyEvent.VK_UP || action == KeyEvent.VK_W){
			current.processMoveRequest(Tile.NORTH);
            m.move(Tile.NORTH);
			System.out.println("key listener detected north");
		} if(action == KeyEvent.VK_LEFT || action == KeyEvent.VK_A){
			current.processMoveRequest(Tile.WEST);
            m.move(Tile.WEST);
			System.out.println("key listener detected west");
		} if(action == KeyEvent.VK_RIGHT || action == KeyEvent.VK_D){
			current.processMoveRequest(Tile.EAST);
            m.move(Tile.EAST);
			System.out.println("key listener detected east");
		}
	
		
	}

	//does not need to do anything
	@Override
	public void keyReleased(KeyEvent arg0) {}

	//does not type anything
	@Override
	public void keyTyped(KeyEvent arg0) {}

	@Override
	public boolean dispatchKeyEvent(KeyEvent arg0) {
		// TODO Auto-generated method stub
		return false;
	}

}
