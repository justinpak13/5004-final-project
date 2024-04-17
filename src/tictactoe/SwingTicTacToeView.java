package tictactoe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * Main view class for tic-tac-toe.
 */
public class SwingTicTacToeView extends JFrame implements TicTacToeView, KeyListener {

  private final Panel panel;
  private final JLabel label;
  private TicTacToeController controller;
  private Player[][] board;


  /**
   * Constructor for the tic-tac-toe view class.
   * @param title the title of the JFrame
   */
  public SwingTicTacToeView(String title) {
    super(title);

    // sets up the frame
    setMinimumSize(new Dimension(500, 500));
    setSize(new Dimension(500, 900));
    getContentPane().setBackground(new Color(180, 190, 254));
    setLayout(new BorderLayout());

    // setting up the panel
    panel = new Panel(this);
    panel.setPreferredSize(new Dimension(500, 500));

    // setting up the labels
    label = new JLabel("", SwingConstants.CENTER);
    label.setFont(new Font("Serif", Font.PLAIN, 50));

    JLabel newLabel = new JLabel("Press esc at any time to reset");

    Dimension screenSize = this.getContentPane().getSize();
    setSize(screenSize);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    this.add(label,  BorderLayout.PAGE_START);
    this.add(panel, BorderLayout.CENTER);
    this.add(newLabel, BorderLayout.PAGE_END);

    this.addKeyListener(this);

    this.pack();
    this.setLocationRelativeTo(null);

    this.setVisible(true);
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

  /**
   * Function used to get a representation of the board from the controller.
   * @param board 2d array representation of board.
   */
  public void updateBoard(Player[][] board) {
    this.board = board;
    this.panel.repaint();
  }

  /**
   * Used to send over the representation of the board to the panel.
   * @return 2d array representation of board.
   */
  public Player[][] getBoard() {
    return this.board;

  }

  /**
   * Displays message for IllegalArgumentExceptions.
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


  @Override
  public void keyPressed(KeyEvent e) {
    if (e.getExtendedKeyCode() == 27) {
      this.controller.reset();
      this.panel.repaint();

    }

  }

  @Override
  public void keyReleased(KeyEvent e) {

  }

  @Override
  public void keyTyped(KeyEvent e) {

  }
}
