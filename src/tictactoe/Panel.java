package tictactoe;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class Panel extends JPanel implements MouseListener {

  SwingTicTacToeView view;
  public Panel(SwingTicTacToeView swingTicTacToeView){
    super.addMouseListener(this);
    this.view = swingTicTacToeView;
  }


  public void paint (Graphics g){
    double topMargin = 0.15;
    double bottomMargin = 0.85;

    Graphics2D g2d = (Graphics2D) g;
    g2d.setStroke(new BasicStroke(10));
    g2d.drawLine((int) (getWidth() * 0.33), (int)(getHeight() * topMargin), (int)(getWidth()*0.33), (int)(getHeight() * bottomMargin));
    g2d.drawLine((int) (getWidth() * 0.66), (int)(getHeight() * topMargin), (int)(getWidth()*0.66), (int)(getHeight() * bottomMargin));
    g2d.drawLine((int) (getWidth()* topMargin),(int) (getHeight() * 0.33), (int) (getWidth()* bottomMargin), (int)(getHeight()*0.33) );
    g2d.drawLine((int) (getWidth()* topMargin),(int) (getHeight() * 0.66), (int) (getWidth()* bottomMargin), (int)(getHeight()*0.66));
  }



  @Override
  public void mouseClicked(MouseEvent e) {
    System.out.println(e.getX());
    System.out.println(e.getY());

    RectangleComponent rc = new RectangleComponent(e.getX(), e.getY());
    view.add(rc);
    view.revalidate();
    view.repaint();


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
