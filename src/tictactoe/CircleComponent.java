package tictactoe;

import java.awt.*;

import javax.swing.*;

public class CircleComponent extends JComponent {
  int x,y;

  CircleComponent(int x, int y){
    this.x = x;
    this.y =y;
  }

  @Override
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;

    Color c = new Color(255,10,10);
    g2d.setColor(c);
    g2d.setStroke(new BasicStroke(8));



    g2d.drawOval(x, y, (int)(getWidth() * 0.20), (int)(getHeight() * 0.20));

  }
}
