package tictactoe;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

/**
 * Panel class used to hold the main graphics for the game.
 */
public class Panel extends JPanel implements MouseListener {

  SwingTicTacToeView view;

  /**
   * Constructor for the panel class.
   * @param swingTicTacToeView the main view class
   */
  public Panel(SwingTicTacToeView swingTicTacToeView) {
    super.addMouseListener(this);
    this.view = swingTicTacToeView;
  }


  /**
   * The main paint method for the lines.
   * @param g  the <code>Graphics</code> context in which to paint
   */
  public void paint(Graphics g) {
    double topMargin = 0.05;
    double bottomMargin = 0.95;

    Graphics2D g2d = (Graphics2D) g;
    g2d.setStroke(new BasicStroke(10));
    g2d.drawLine((int) (getWidth() * 0.33), (int) (getHeight() * topMargin),
            (int) (getWidth() * 0.33), (int) (getHeight() * bottomMargin));
    g2d.drawLine((int) (getWidth() * 0.66), (int) (getHeight() * topMargin),
            (int) (getWidth() * 0.66), (int) (getHeight() * bottomMargin));
    g2d.drawLine((int) (getWidth() * topMargin), (int) (getHeight() * 0.33),
            (int) (getWidth() * bottomMargin), (int) (getHeight() * 0.33));
    g2d.drawLine((int) (getWidth() * topMargin), (int) (getHeight() * 0.66),
            (int) (getWidth() * bottomMargin), (int) (getHeight() * 0.66));
  }


  /**
   * Helper function to calculate where the user clicked.
   * @param x the x value
   * @param y the y value
   * @return an integer to represent which section of the screen was clicked
   */
  private int calculateCoordinate(int x, int y) {
    int coordinate = 3;
    if (y < (getHeight()) * 0.33) {
      coordinate *= 0;
    } else if (y < (getHeight()) * 0.66) {
      coordinate *= 1;
    } else {
      coordinate *= 2;
    }

    if (x < (getWidth()) * 0.33) {
      coordinate += 1;
    } else if (x < (getWidth()) * 0.66) {
      coordinate += 2;
    } else {
      coordinate += 3;
    }

    return coordinate;

  }

  /**
   * Main drawing function for the O player.
   * @param row which row to draw
   * @param column which column to draw
   */
  public void drawCircle(int row, int column) {

    int x = (int) ((column) * getWidth() * 0.33) + (int) (getWidth() * 0.08);
    int y = (int) ((row) * getHeight() * 0.33) + (int) (getHeight() * 0.08);

    CircleComponent circle = new CircleComponent(x, y);

    view.add(circle);
    view.revalidate();
    view.repaint();
  }

  /**
   * Main drawing function for the X player.
   * @param row which row to draw
   * @param column which column to draw
   */
  public void drawCross(int row, int column) {

    int x = (int) ((column) * getWidth() * 0.33) + (int) (getWidth() * 0.17);
    int y = (int) ((row) * getHeight() * 0.33) + (int) (getHeight() * 0.15);

    CrossComponent circle = new CrossComponent(x, y);

    view.add(circle);
    view.revalidate();
    view.repaint();
  }

  /**
   * Overridden mouse clicked function.
   * @param e the event to be processed
   */
  @Override
  public void mouseClicked(MouseEvent e) {

    int x = e.getX();
    int y = e.getY();

    view.sendInput(calculateCoordinate(x, y));

  }

  @Override
  public void mousePressed(MouseEvent e) {

  }

  @Override
  public void mouseReleased(MouseEvent e) {

  }

  @Override
  public void mouseEntered(MouseEvent e) {

  }

  @Override
  public void mouseExited(MouseEvent e) {

  }
}
