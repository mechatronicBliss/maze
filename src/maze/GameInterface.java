package maze;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class GameInterface extends JComponent implements ActionListener{
	private int size;
	private double p;
	private GameState gameState;
	private JFrame gameFrame;
    private JPanel menuPanel;
    private MazeUi m;
    private int theme;
    private JPanel sideBar;
    
    private boolean useCollectables;
	public GameInterface() {
		size = 10;
		p = 0.25;
        gameFrame = new JFrame();
		displayMenu();
        this.useCollectables = false;
        this.theme = 1;
	}
	private void displayMenu() {
        this.theme = 1;
        this.size = 10;
        this.p = 0.25;
        this.useCollectables = false;
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setBounds(100, 100, 600, 600);
		//make some buttons
		JButton startButton = new JButton("Start");
		startButton.setActionCommand("start");
		startButton.addActionListener(this);
		startButton.setFont(new Font("Arial", Font.BOLD, 20));
		
		JButton instructions = new JButton("Instructions");
		instructions.setActionCommand("showInstructions");
		instructions.addActionListener(this);
		instructions.setFont(new Font("Arial", Font.BOLD, 20));
		
		//JButton custom = new JButton("custom");
		
		//radio buttons 
		JRadioButton easy = new JRadioButton("Easy");
		easy.setActionCommand("e");
		easy.setSelected(true);
		easy.setForeground(Color.yellow);
		easy.addActionListener(this);
		JRadioButton medium = new JRadioButton("Medium");
		medium.setActionCommand("m");
		medium.setForeground(Color.yellow);
		medium.addActionListener(this);
		JRadioButton hard = new JRadioButton("Hard");
		hard.setActionCommand("h");
		hard.setForeground(Color.yellow);
		hard.addActionListener(this);

		//group the radios
		ButtonGroup group = new ButtonGroup();
		group.add(easy);
		group.add(medium);
		group.add(hard);
		
		menuPanel = new JPanel(new GridBagLayout());
        menuPanel.setBackground(Color.BLACK);
		GridBagConstraints c = new GridBagConstraints();
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
        menuPanel.add(instructions, c);
		
		c.gridx = 1;
		c.gridy = 5;
        menuPanel.add(startButton, c);
		
		//c.gridx = 2;
       // menuPanel.add(custom, c);
		
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
        collectables.setForeground(Color.yellow);
        menuPanel.add(collectables, c);
       
        c.gridx = 1;
        c.gridy = 1;
        JRadioButton themeOne = new JRadioButton("Theme 1");
        themeOne.setActionCommand("theme1");
        themeOne.setSelected(true);
        themeOne.addActionListener(this);
        themeOne.setForeground(Color.yellow);
        JRadioButton themeTwo = new JRadioButton("Theme 2");
        themeTwo.setActionCommand("theme2");
        themeTwo.addActionListener(this);
        themeTwo.setForeground(Color.yellow);
        JRadioButton themeThree = new JRadioButton("Theme 3");
        themeThree.setActionCommand("theme3");
        themeThree.addActionListener(this);
        themeThree.setForeground(Color.yellow);
        JRadioButton themeFour = new JRadioButton("Theme 4");
        themeFour.setActionCommand("theme4");
        themeFour.setForeground(Color.yellow);
        themeFour.addActionListener(this);
        
        ButtonGroup themes = new ButtonGroup();
        themes.add(themeOne);
        themes.add(themeTwo);
        themes.add(themeThree);
        themes.add(themeFour);
        menuPanel.add(themeOne, c);
        c.gridy = 2;
        menuPanel.add(themeTwo, c);
        c.gridy = 3;
        menuPanel.add(themeThree, c);
        c.gridy = 4;
        menuPanel.add(themeFour, c);
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
        else if(e.getActionCommand().equals("theme1")) {
            theme = 1;
        }
        else if(e.getActionCommand().equals("theme2")) {
            theme = 2;
        }
        else if(e.getActionCommand().equals("theme3")) {
            theme = 3;
        }
        else if(e.getActionCommand().equals("theme4")) {
            theme = 4;
        }
	}
	public int getDifficulty() {
		return size;
	}
	private void startGame() {
        gameFrame.remove(menuPanel);
        gameState = new GameState(size, p);
        Images imgs = new Images(theme);
		gameFrame.setBounds(10, 0, 1400, 1000);
        m = new MazeUi(size, gameState.getMaze(), this, useCollectables, imgs);
        KeyListenerMaze k =  new KeyListenerMaze(gameState, m);
        gameFrame.addKeyListener(k);
		gameFrame.add(m, BorderLayout.CENTER);
        gameFrame.requestFocusInWindow();
	}
    public void restart() {
        gameFrame.setVisible(false);
        gameFrame = new JFrame();
        displayMenu();
    }
    private void openCustom() {

    }
    
}
