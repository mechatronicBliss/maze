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
        c.gridy = 0;
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
        /*private static void mTestv3(ArrayList<ArrayList<Tile>> maze) {

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
        } */
        this.validate();
        this.repaint();
	}
}
