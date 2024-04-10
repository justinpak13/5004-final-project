package tictactoe;

import javax.swing.*;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ImageObserver;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.RenderableImage;
import java.io.IOException;
import java.text.AttributedCharacterIterator;
import java.util.Map;

public class SwingTicTacToeView extends JFrame implements TicTacToeView {

  private Panel panel;
  private JLabel label;
  private TicTacToeController controller;



  public SwingTicTacToeView(String title){
    super(title);

    this.controller = controller;

    setMinimumSize(new Dimension(500, 500));
    setLayout(new BorderLayout());


    panel = new Panel(this);
    panel.setPreferredSize(getSize());
    panel.setBackground(Color.CYAN);

    label = new JLabel("TEST");
    label.setFont(new Font("Serif", Font.PLAIN, 30));

    Dimension screenSize = this.getContentPane().getSize();
    setSize(screenSize);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    this.add(label,  BorderLayout.PAGE_START);
    this.add(panel);
    this.pack();

    setVisible(true);
  }

  public void addController(TicTacToeController controller){
    this.controller = controller;
  }
  public void requestTurn(Player currentPlayer) {
    if (currentPlayer == Player.X){
      label.setText("Turn: X");
    } else {
      label.setText("Turn: O");
    }
  }

  public void sendInput(int coordinate){
    controller.getInput(coordinate);

  }

}
