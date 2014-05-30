package maze;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * 
 * @author Simon Rob, Simon Briggs, Jason Le, Raveen de
 *
 */

/**
 * 
 * Game interface acts as the class that represents the initial
 * game state, which is the set up page.
 * Game interface contains the settings and the themes 
 * in which the user can choose from, and additionally 
 * sets the maze game interface, when the user presses start.
 *
 */
public class GameInterface implements ActionListener{
	private int size;
	private double p;
	private GameState gameState;
	private JFrame gameFrame;
    private JPanel menuPanel;
    private MazeUi m;
    private int theme;
    private JPanel sideBar;
    
    private boolean useCollectables;
    private String victory;
	public GameInterface() {
		size = 10;
		p = 0.25;
        gameFrame = new JFrame();
		displayMenu();
        this.useCollectables = false;
        this.theme = 1;
	}
	/**
	 * The display menu in the initial screen
	 * This is in a done in a grid bag layout
	 */
	private void displayMenu() {
        this.victory = "Much Victory!";
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
		startButton.setFont(new Font("Arial", Font.BOLD, 15));
		
		JButton instructions = new JButton("Instructions");
		instructions.setActionCommand("showInstructions");
		instructions.addActionListener(this);
		instructions.setFont(new Font("Arial", Font.BOLD, 15));
		
		//JButton custom = new JButton("custom");
		
		//radio buttons 
		JRadioButton easy = new JRadioButton("Easy");
		easy.setActionCommand("e");
		easy.setSelected(true);
		easy.setForeground(Color.CYAN);
		easy.addActionListener(this);
		JRadioButton medium = new JRadioButton("Medium");
		medium.setActionCommand("m");
		medium.setForeground(Color.CYAN);
		medium.addActionListener(this);
		JRadioButton hard = new JRadioButton("Hard");
		hard.setActionCommand("h");
		hard.setForeground(Color.CYAN);
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
		c.gridy = 6;
        menuPanel.add(startButton, c);
		
		//c.gridx = 2;
       // menuPanel.add(custom, c);
		
		c.gridx = 0;
		c.gridy = 1;
		JLabel levelLabel = new JLabel();
		levelLabel.setText("Levels");
        levelLabel.setForeground(Color.CYAN);
        menuPanel.add(levelLabel, c);
        c.gridy = 2;
        menuPanel.add(easy, c);
		c.gridy = 3;
        menuPanel.add(medium, c);
		c.gridy = 4;
        menuPanel.add(hard, c);
        
        c.gridx = 2;
        c.gridy = 3;

        JCheckBox collectables = new JCheckBox("Collectables");
        collectables.setActionCommand("collect");
        collectables.addActionListener(this);
        collectables.setForeground(Color.CYAN);
        menuPanel.add(collectables, c);
       
        c.gridx = 1;
        c.gridy = 1;
        JRadioButton themeOne = new JRadioButton("Iron Man");
        themeOne.setActionCommand("theme1");
        themeOne.setSelected(true);
        themeOne.addActionListener(this);
        themeOne.setForeground(Color.CYAN);
        JRadioButton themeTwo = new JRadioButton("Pooh Bear");
        themeTwo.setActionCommand("theme2");
        themeTwo.addActionListener(this);
        themeTwo.setForeground(Color.CYAN);
        JRadioButton themeThree = new JRadioButton("Superman");
        themeThree.setActionCommand("theme3");
        themeThree.addActionListener(this);
        themeThree.setForeground(Color.CYAN);
        JRadioButton themeFour = new JRadioButton("Space");
        themeFour.setActionCommand("theme4");
        themeFour.setForeground(Color.CYAN);
        themeFour.addActionListener(this);
        JLabel themeLabel = new JLabel();
        themeLabel.setText("Themes");
        themeLabel.setForeground(Color.CYAN);
        ButtonGroup themes = new ButtonGroup();
        themes.add(themeOne);
        themes.add(themeTwo);
        themes.add(themeThree);
        themes.add(themeFour);
        menuPanel.add(themeLabel, c);
        c.gridy = 2;
        menuPanel.add(themeOne, c);
        c.gridy = 3;
        menuPanel.add(themeTwo, c);
        c.gridy = 4;
        menuPanel.add(themeThree, c);
        c.gridy = 5;
        menuPanel.add(themeFour, c);
		gameFrame.add(menuPanel);
		gameFrame.setVisible(true);
		
	}
	
	@Override
	 /**
	  * Sets a action command for each button
	  * in the display menu
	  */
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("start")) {
			System.out.println("Loading Game");
            Images im = new Images(theme);
            JOptionPane.showMessageDialog(null, im.getInstructions());
			startGame();
		}
		else if(e.getActionCommand().equals("e")) {
			size = 10;
			p = 0.10;
		}
		else if(e.getActionCommand().equals("m")) {
			size = 15;
			p = 0.05;
		}
		else if(e.getActionCommand().equals("h")) {
			size = 20;
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
            JOptionPane.showMessageDialog(null, "Please choose a level and a theme, then press Start.");
        }
        else if(e.getActionCommand().equals("theme1")) {
            theme = 1;
            this.victory = "Much Victory!";
        }
        else if(e.getActionCommand().equals("theme2")) {
            theme = 2;
            this.victory = "Mmmmm, Honeyyyy!";
        }
        else if(e.getActionCommand().equals("theme3")) {
            theme = 3;
            this.victory = "Up, up and away!";
        }
        else if(e.getActionCommand().equals("theme4")) {
            theme = 4;
            this.victory = "Congratulations! You have escaped.";
        }
	}
	/**
	 * 
	 * @return the size of the maze (as size corresponded to difficulty
	 */
	public int getDifficulty() {
		return size;
	}
	
	/**
	 * The start game method in which takes in the 
	 * conditions the user has choose and implements a
	 * maze gamestate 
	 */
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
	
	/**
	 * This method is for the victory gamestate
	 * the method allows the user to return from the 
	 * maze gamestate to the initial gamestate
	 */
    public void restart() {
        gameFrame.setVisible(false);
        gameFrame = new JFrame();
        this.victory = "Much Victory!";
        displayMenu();
    }

    public String getVictoryMessage() {
        return victory;
    }
    
}
