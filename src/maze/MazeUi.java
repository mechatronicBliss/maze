package maze;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MazeUi extends JPanel {
	public MazeUi(int size) {
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
        c.ipadx = 0;
        c.ipady = 0;
        c.weightx = 0;
        c.weighty = 0;
        c.fill = GridBagConstraints.VERTICAL;
        
        
        for(int i = 0; i < size; i++) {
        	c.gridy = i;
        	for(int j = 0; j < size; j++) {
        		JComponent b = new Box(true, true, true, true);
        		this.add(b,c);
        	}
        }
        this.validate();
        this.repaint();
	}
}
