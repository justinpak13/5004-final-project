package tictactoe;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

public class CircleComponent extends JComponent {
  int xcoord;
  int ycoord;

  CircleComponent(int x, int y) {
    this.xcoord = x;
    this.ycoord = y;
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;

    Color c = new Color(255, 10, 10);
    g2d.setColor(c);
    g2d.setStroke(new BasicStroke(8));



    g2d.drawOval(xcoord, ycoord, (int) (getWidth() * 0.20), (int) (getHeight() * 0.20));

  }
}
