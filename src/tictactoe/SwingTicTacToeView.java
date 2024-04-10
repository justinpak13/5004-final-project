package tictactoe;

import javax.swing.*;
import java.awt.*;

public class SwingTicTacToeView extends JFrame implements TicTacToeView {

  public SwingTicTacToeView(String title){
    super(title);

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    setSize(screenSize);
    this.setMinimumSize(screenSize);
    setLocation(400, 200);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    this.setLayout(new FlowLayout());

    //JLabel display = new JLabel("test for display");

    JPanel panel = new JPanel();
    panel.setMinimumSize(new Dimension(300, 300));
    panel.setBackground(Color.BLUE);
    this.add(panel);
    //this.add(display);


    pack();
    double width = this.getContentPane().getSize().getWidth();
    double height = this.getContentPane().getSize().getHeight();

    setVisible(true);
  }
}
