package tictactoe;

import java.awt.*;

import javax.swing.*;

public class RectangleComponent extends JComponent {
  int x,y;

  RectangleComponent(int x, int y){
    this.x = x;
    this.y =y;
  }

  @Override
  public void paintComponent(Graphics g){
    super.paintComponent(g);

    Color c = new Color(255, 100,100);
    g.setColor(c);

    g.drawRect(x, y, 50, 50);

  }
}
