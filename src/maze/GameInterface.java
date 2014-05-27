package maze;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class GameInterface implements ActionListener{
	private int size;
	private double p;
	private GameState gameState;
	private JFrame gameFrame;
    private JPanel menuPanel;
    private MazeUi m;
    private JPanel sideBar;
    private boolean useCollectables;
	public GameInterface() {
		size = 10;
		p = 0.25;
        gameFrame = new JFrame();
		displayMenu();
        this.useCollectables = false;
	}
	private void displayMenu() {
        this.size = 10;
        this.p = 0.25;
        this.useCollectables = false;
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
		
		c.gridx = 0;
		c.gridy = 1;
        menuPanel.add(easy, c);
		c.gridy = 2;
        menuPanel.add(medium, c);
		c.gridy = 3;
        menuPanel.add(hard, c);
        c.gridx = 2;
        c.gridy = 2;

        JCheckBox collectables = new JCheckBox("Collectables");
        collectables.setActionCommand("collect");
        collectables.addActionListener(this);
        menuPanel.add(collectables, c);
		
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
			size = 10;
			p = 0.25;
		}
		else if(e.getActionCommand().equals("m")) {
			size = 15;
			p = 0.15;
		}
		else if(e.getActionCommand().equals("h")) {
			size = 25;
			p = 0;
		}
		else if(e.getActionCommand().equals("custom")) {
			//open custom screen
		}
        else if(e.getActionCommand().equals("exit")) {
            restart();
        }
        else if(e.getActionCommand().equals("collect")) {
            useCollectables = !useCollectables;
        }
        else if(e.getActionCommand().equals("showInstructions")) {
            JOptionPane.showMessageDialog(null, "YOLO");
        }
	}
	public int getDifficulty() {
		return size;
	}
	private void startGame() {
        gameFrame.remove(menuPanel);
        gameState = new GameState(size, p);

		gameFrame.setBounds(100, 100, 1200, 1000);
        m = new MazeUi(size, gameState.getMaze(), this, useCollectables);
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
