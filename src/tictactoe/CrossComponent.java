package tictactoe;

import java.awt.*;

import javax.swing.*;

public class CrossComponent  extends JComponent {
  int x,y;

  CrossComponent(int x, int y){
    this.x = x;
    this.y =y;
  }

  @Override
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;

    Color c = new Color(10,10,255);
    g2d.setColor(c);
    g2d.setStroke(new BasicStroke(8));



    g2d.drawLine(x - (int)(getWidth()*0.10),y - (int)(getHeight()*0.10), x + (int)(getWidth()*0.10),y + (int)(getHeight()*0.10) );
    g2d.drawLine(x + (int)(getWidth()*0.10),y - (int)(getHeight()*0.10), x - (int)(getWidth()*0.10),y + (int)(getHeight()*0.10) );

  }
}

