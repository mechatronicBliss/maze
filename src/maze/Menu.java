package maze;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class Menu {
	public Menu() {
		JFrame menuFrame = new JFrame();
		menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuFrame.setBounds(100, 100, 600, 200);
		
		//make some buttons
		JButton startButton = new JButton("Start");
		JButton instructions = new JButton("Instructions");
		JButton custom = new JButton("Custom");
		
		JRadioButton easy = new JRadioButton("Easy");
		JRadioButton medium = new JRadioButton("Medium");
		JRadioButton hard = new JRadioButton("Hard");
		
		//group the radios
		ButtonGroup group = new ButtonGroup();
		group.add(easy);
		group.add(medium);
		group.add(hard);
		
		JPanel buttonPanel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		buttonPanel.add(instructions, c);
		
		c.gridx = 1;
		buttonPanel.add(startButton, c);
		
		c.gridx = 2;
		buttonPanel.add(custom, c);
		
		c.gridx = 1;
		c.gridy = 1;
		buttonPanel.add(easy, c);
		c.gridy = 2;
		buttonPanel.add(medium, c);
		c.gridy = 3;
		buttonPanel.add(hard, c);
		
		menuFrame.getContentPane().add(buttonPanel);
		menuFrame.setVisible(true);
	}
}
