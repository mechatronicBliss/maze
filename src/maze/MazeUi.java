package maze;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MazeUi extends JPanel {
    private Maze m;
	public MazeUi(int size, Maze m) {
        this.m = m;
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
        c.ipadx = 0;
        c.ipady = 0;
        c.weightx = 0;
        c.weighty = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        
        
        for(int i = 0; i < size; i++) {
        	c.gridx = i;
        	for(int j = 0; j < size; j++) {
                c.gridy = j;
                Tile t = m.getGrid().getTiles().get(i).get(j);
        		JComponent b = new Box(t.hasWall(t.WEST), t.hasWall(t.EAST), t.hasWall(t.NORTH), t.hasWall(t.SOUTH));
        		this.add(b,c);
        	}
        }
        c.gridy = 0;
        this.validate();
        this.repaint();
	}
}
