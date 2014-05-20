package maze;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class Menu implements ActionListener{
	private int difficulty;
	private GameState gameState;
	public Menu() {
		difficulty = 10;
		JFrame menuFrame = new JFrame();
		menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuFrame.setBounds(100, 100, 600, 200);
		
		//make some buttons
		JButton startButton = new JButton("Start");
		startButton.setActionCommand("start");
		startButton.addActionListener(this);
		JButton instructions = new JButton("Instructions");
		instructions.setActionCommand("showInstructions");
		instructions.addActionListener(this);
		JButton custom = new JButton("custom");
		
		JRadioButton easy = new JRadioButton("Easy");
		easy.setActionCommand("e");
		easy.setSelected(true);
		easy.addActionListener(this);
		JRadioButton medium = new JRadioButton("Medium");
		medium.setActionCommand("m");
		medium.addActionListener(this);
		JRadioButton hard = new JRadioButton("Hard");
		hard.setActionCommand("h");
		hard.addActionListener(this);
		
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
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("start")) {
			System.out.println("Loading Game");
		}
		else if(e.getActionCommand().equals("e")) {
			difficulty = 10;
		}
		else if(e.getActionCommand().equals("m")) {
			difficulty = 20;
		}
		else if(e.getActionCommand().equals("h")) {
			difficulty = 30;
		}
		else if(e.getActionCommand().equals("custom")) {
			difficulty = 40;
			//open custom screen
		}
	}
	public int getDifficulty() {
		return difficulty;
	}
	private void startGame() {
		gameState = new GameState(difficulty);
		
	}
}
