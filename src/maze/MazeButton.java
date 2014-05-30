package maze;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
/**
 * Created by SHRobilliard on 30/05/2014.
 */
public class MazeButton extends JButton {
    private int x;
    private int y;
    public MazeButton(String title, int x, int y) {
        super(title);
        setPreferredSize(new Dimension(x, y) );
        this.x = x;
        this.y = y;
    }

    /**
     * Repaints the buttons
     * @param g
     */

    @Override
    public void paint(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor( new Color(7, 153, 173, 255));
        Rectangle2D r = new Rectangle2D.Double(0, 0,x-1,y-1);
        g2d.fill(r);

        g2d.setColor(Color.white);
        g2d.setFont( new Font("Ariel", Font.BOLD, 20));
        int stringLen = (int) g2d.getFontMetrics().getStringBounds(getText(), g2d).getWidth();
        int start = x/2 - stringLen/2;
        g2d.drawString(getText(), start, (int) (y*0.6));

    }
}
