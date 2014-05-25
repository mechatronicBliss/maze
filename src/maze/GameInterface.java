package maze;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class GameInterface implements ActionListener{
	private int difficulty;
	private GameState gameState;
	private JFrame gameFrame;
    private JPanel menuPanel;
    private MazeUi m;
    private JPanel sideBar;
	public GameInterface() {
		difficulty = 10;
        gameFrame = new JFrame();
		displayMenu();
	}
	private void displayMenu() {
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setBounds(100, 100, 600, 600);
		
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

        JButton exit = new JButton("Exit");
        exit.setActionCommand("exit");
        exit.addActionListener(this);

        sideBar = new JPanel(new GridBagLayout());
        sideBar.add(exit);
		
		//group the radios
		ButtonGroup group = new ButtonGroup();
		group.add(easy);
		group.add(medium);
		group.add(hard);
		
		menuPanel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
        menuPanel.add(instructions, c);
		
		c.gridx = 1;
        menuPanel.add(startButton, c);
		
		c.gridx = 2;
        menuPanel.add(custom, c);
		
		c.gridx = 1;
		c.gridy = 1;
        menuPanel.add(easy, c);
		c.gridy = 2;
        menuPanel.add(medium, c);
		c.gridy = 3;
        menuPanel.add(hard, c);
		
		gameFrame.add(menuPanel);
		gameFrame.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("start")) {
			System.out.println("Loading Game");
			startGame();
		}
		else if(e.getActionCommand().equals("e")) {
			difficulty = 10;
		}
		else if(e.getActionCommand().equals("m")) {
			difficulty = 15;
		}
		else if(e.getActionCommand().equals("h")) {
			difficulty = 30;
		}
		else if(e.getActionCommand().equals("custom")) {
			difficulty = 40;
			//open custom screen
		}
        else if(e.getActionCommand().equals("exit")) {
            restart();
        }
	}
	public int getDifficulty() {
		return difficulty;
	}
	private void startGame() {
        gameFrame.remove(menuPanel);
        gameState = new GameState(difficulty);

		gameFrame.setBounds(100, 100, 1200, 1000);
        m = new MazeUi(difficulty, gameState.getMaze(), this);
        KeyListenerMaze k =  new KeyListenerMaze(gameState, m);
        gameFrame.addKeyListener(k);
		gameFrame.add(m, BorderLayout.WEST);
        gameFrame.add(sideBar);
        gameFrame.pack();
        gameFrame.requestFocusInWindow();
	}
    public void restart() {
        gameFrame.setVisible(false);
        gameFrame = new JFrame();
        displayMenu();
    }
}
