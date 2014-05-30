package maze;

import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * 
 * @author Simon Rob, Simon Briggs, Jason Le, Raveen de
 *
 */

/**
 * A class which contains all the images and 
 * what theme the user has choosen
 *
 */
public class Images {
	//the image of player 
		private Image player; 
		//the image of the grass
		private Image mazeBackground;
		//the image of the walls 
		private Image wallImage;
		//the image of the collectables
		private Image collectables; 
		
		private Image finaltile;

        private Image frameBackground;
        
        int theme;
	
    /**
     * Images sets what images are to be returned
     * to Maze UI and Box according to what theme the 
     * user has choosen
     * @param theme what theme the user has choosen
     */
	public Images(int theme){
		this.theme = theme;
      if(theme == 1){
		   ImageIcon img = new ImageIcon("ironManChar.png");
		    this.player = img.getImage();

		    img = new ImageIcon("theme1tile.png");
		    this.mazeBackground = img.getImage();

		    img = new ImageIcon("theme1wall.jpg");
		    this.wallImage = img.getImage();

		    img = new ImageIcon("theme1pickup.png");
		    this.collectables = img.getImage();  
		    
		    img = new ImageIcon("doge.jpg");
		    this.finaltile = img.getImage();

            img = new ImageIcon("ironmansIsAwesome.jpg");
            this.frameBackground = img.getImage();
      } else if(theme == 2){
		    ImageIcon img = new ImageIcon("theme2character.png");
		    this.player = img.getImage();

		    img = new ImageIcon("greengrass.JPG");
		    this.mazeBackground = img.getImage();

		    img = new ImageIcon("brickwall.JPG");
		    this.wallImage = img.getImage();

		    img = new ImageIcon("theme2collectable.png");
		    this.collectables = img.getImage();    
		    
		    img = new ImageIcon("theme2goal.jpg");
		    this.finaltile = img.getImage();

            //img = new ImageIcon(this themes frame background)
		    img = new ImageIcon("theme2wall.jpg");
            this.frameBackground = img.getImage();
      } else if(theme == 3){
		   ImageIcon img = new ImageIcon("Superman.png");
		    this.player = img.getImage();

		    img = new ImageIcon("glassTiles.JPG");
		    this.mazeBackground = img.getImage();

		    img = new ImageIcon("kryptonite.jpg");
		    this.wallImage = img.getImage();

		    img = new ImageIcon("moneybags.JPG");
		    this.collectables = img.getImage();  
		    
		    img = new ImageIcon("greengrass.JPG");
		    this.finaltile = img.getImage();

            img = new ImageIcon("supermanBackground.jpg");
            this.frameBackground = img.getImage();
      } else if(theme == 4){
		   ImageIcon img = new ImageIcon("theme4char.jpg");
		    this.player = img.getImage();

		    img = new ImageIcon("theme4tile.png");
		    this.mazeBackground = img.getImage();

		    img = new ImageIcon("theme4wall.jpg");
		    this.wallImage = img.getImage();

		    img = new ImageIcon("theme4pickup.png");
		    this.collectables = img.getImage();  
		    
		    img = new ImageIcon("theme4goal.jpg");
		    this.finaltile = img.getImage();

          img = new ImageIcon("theme4bg.jpg");
          this.frameBackground = img.getImage();
      }
	}
	
	public Image getPlayer(){
		return this.player;
	}
	public Image getWallImage(){
		return this.wallImage;
	}
	
	public Image getBackground(){
		return this.mazeBackground;
	}
	
	public Image getCollectables(){
		return this.collectables;
	}
	
	public Image getFinalTile(){
		return this.finaltile;
	}

    public Image getFrameBackground() {
        return this.frameBackground;
    }
    
    public int getTheme(){
    	return this.theme;
    }
    
    /**
     * getInstructions returns the instructions in accordance to the themes
     * @return the instructions in accordance to the theme
     */
    public String getInstructions(){
    	String instructions = null;
    	if(theme == 1){
    		instructions = "Help Iron Man find his way out of the maze.\n If there are any batteries, you must power up to get to the finish!";
    	}
    	else if(theme == 2){
    		instructions = "Help Pooh Bear Return Home, if there is honey "
    				+ "collect all of them and then return home";
    	} 
    	else if (theme == 3){
    		instructions = " up the blues";
    	}
    	else{
    		instructions = "The year is 1AD (hexadecimal, of course!), and the Omega II galaxy is doomed.\n" + 
    				"Use the arrow keys or WASD reach the wormhole and escape!\n" + 
    				"If there are any orbs, you must collect them all to reveal the wormhole.";
    	}
    	return instructions;
    	
    }
}
