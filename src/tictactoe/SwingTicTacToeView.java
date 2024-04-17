package tictactoe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * Main view class for tic tac toe.
 */
public class SwingTicTacToeView extends JFrame implements TicTacToeView{

  private final Panel panel;
  private final JLabel label;
  private TicTacToeController controller;
  private Player[][] board;


  /**
   * Constructor for the tic tac toe view class.
   * @param title the title of the jframe
   */
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

  /**
   * Connects the view to the controller.
   * @param controller the controller class.
   */
  public void addController(TicTacToeController controller) {
    this.controller = controller;
  }

  /**
   * Displays which player turn it is.
   * @param currentPlayer the current player turn
   */
  public void requestTurn(Player currentPlayer) {
    if (currentPlayer == Player.X) {
      label.setText("Turn: X");
    } else {
      label.setText("Turn: O");
    }
  }

  /**
   * Sends the coordinate to the controller.
   * @param coordinate the section of the panel clicked.
   */
  public void sendInput(int coordinate) {
    controller.getInput(coordinate);
  }

  public void updateBoard(Player[][] board){
    this.board = board;
    this.panel.repaint();
  }
  public Player[][] getBoard(){
    return this.board;

  }

  /**
   * draws the corresponding mark in the coordinate position.
   * @param player current player
   * @param row the row
   * @param column the column
   */
  public void drawMark(Player player, int row, int column) {
    //if (player == Player.X) {
    //  this.panel.drawCross(row, column);
    //} else {
    //  this.panel.drawCircle(row, column);
    //}
  }

  /**
   * Displays message for IllegalArugmentExceptions.
   * @param e Illegal argument error
   */
  @Override
  public void displayError(IllegalArgumentException e) {
    label.setText(e.getMessage());
  }

  /**
   * Displays message for IllegalStateExceptions.
   * @param e Illegal state error
   */
  @Override
  public void displayError(IllegalStateException e) {
    label.setText(e.getMessage());
  }

  /**
   * Displays the winner.
   * @param winner the winning player
   */
  public void displayWinner(Player winner) {
    if (winner == Player.X) {
      label.setText("GAME OVER! Winner is X");
    } else {
      label.setText("GAME OVER! Winner is O");
    }
  }

  /**
   * Displays message given a tie.
   */
  public void displayTie() {
    label.setText("TIE GAME!");
  }
}
