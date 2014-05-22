package maze;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MazeUi extends JPanel {
    private Maze m;
    private Boolean player;
    
	public MazeUi(int size, Maze m) {
        this.m = m;
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
        c.ipadx = 0;
        c.ipady = 0;
        c.weightx = 0;
        c.weighty = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridy = 0;
        
        //creating new player
        m.getGrid().getTiles().get(0).get(0).setPlayer(true);
        
        
        for(int i = size-1; i > -1; i--) {
            boolean bottom = false;
            if(i == 0) {
                bottom = true;
                
            }
        	for(int j = 0; j < size; j++) {
                c.gridx = j;
                boolean end = false;
                if(j == size - 1) {
                    end = true;
                }
                
                Tile t = m.getGrid().getTiles().get(j).get(i);
        		JComponent b = new Box(t.hasWall(t.WEST), end, t.hasWall(t.NORTH), bottom);
        		this.add(b,c);
        	}
            c.gridy++;
        }
        this.validate();
        this.repaint();
	}
}
