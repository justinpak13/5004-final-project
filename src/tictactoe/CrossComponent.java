package tictactoe;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

/**
 * Class used to represent the X player.
 */
public class CrossComponent  extends JComponent {
  private final int xcoord;
  private final int ycoord;

  /**
   * Constructor for the cross class.
   * @param x the x coordinate
   * @param y the y coordinate
   */
  public CrossComponent(int x, int y) {
    this.xcoord = x;
    this.ycoord = y;
  }

  /**
   * Overridden paint component method.
   * @param g the <code>Graphics</code> object to protect
   */
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;

    Color c = new Color(10, 10, 255);
    g2d.setColor(c);
    g2d.setStroke(new BasicStroke(8));



    g2d.drawLine(xcoord - (int) (getWidth() * 0.10), ycoord - (int) (getHeight() * 0.10),
            xcoord + (int) (getWidth() * 0.10), ycoord + (int) (getHeight() * 0.10));
    g2d.drawLine(xcoord + (int) (getWidth() * 0.10), ycoord - (int) (getHeight() * 0.10),
            xcoord - (int) (getWidth() * 0.10), ycoord + (int) (getHeight() * 0.10));
  }
}

