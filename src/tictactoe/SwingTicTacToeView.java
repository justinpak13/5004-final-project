package tictactoe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class SwingTicTacToeView extends JFrame implements TicTacToeView {

  private final Panel panel;
  private final JLabel label;
  private TicTacToeController controller;



  public SwingTicTacToeView(String title) {
    super(title);

    setMinimumSize(new Dimension(500, 500));
    getContentPane().setBackground(new Color(180, 190, 254));
    setLayout(new BorderLayout());

    panel = new Panel(this);
    panel.setPreferredSize(getSize());

    label = new JLabel("", SwingConstants.CENTER);
    label.setFont(new Font("Serif", Font.PLAIN, 50));

    Dimension screenSize = this.getContentPane().getSize();
    setSize(screenSize);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    this.add(label,  BorderLayout.PAGE_START);
    this.add(panel);
    this.pack();

    setVisible(true);
  }

  public void addController(TicTacToeController controller) {
    this.controller = controller;
  }

  public void requestTurn(Player currentPlayer) {
    if (currentPlayer == Player.X) {
      label.setText("Turn: X");
    } else {
      label.setText("Turn: O");
    }
  }

  public void sendInput(int coordinate) {
    controller.getInput(coordinate);
  }

  public void drawMark(Player player, int row, int column) {
    if (player == Player.X) {
      this.panel.drawCross(row, column);
    } else {
      this.panel.drawCircle(row, column);
    }
  }

  @Override
  public void displayError(IllegalArgumentException e) {
    label.setText(e.getMessage());
  }

  @Override
  public void displayError(IllegalStateException e) {
    label.setText(e.getMessage());
  }

  public void displayWinner(Player winner) {
    if (winner == Player.X) {
      label.setText("GAME OVER! Winner is X");
    } else {
      label.setText("GAME OVER! Winner is O");
    }
  }

  public void displayTie() {
    label.setText("TIE GAME!");
  }
}
