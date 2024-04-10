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
import java.text.AttributedCharacterIterator;
import java.util.Map;

public class SwingTicTacToeView extends JFrame implements TicTacToeView {

  Panel panel;
  public SwingTicTacToeView(String title){
    super(title);
    panel = new Panel(this);

    Dimension screenSize = this.getContentPane().getSize();
    setSize(screenSize);
    this.setMinimumSize(screenSize);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    this.add(panel);
    this.pack();

    setVisible(true);
  }

}
