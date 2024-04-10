package tictactoe;

public class SwingTicTacToeController implements TicTacToeController {
  private TicTacToe model;
  private TicTacToeView view;

  public SwingTicTacToeController(TicTacToeView view, TicTacToe model){
    this.view = view;
    this.model = model;
  }

  /**
   * Execute a single game of tic tac toe given a tic tac toe Model. When the game is over,
   * the playGame method ends.
   *
   * @param m a non-null tic tac toe Model
   */
  @Override
  public void playGame(TicTacToe m) {

  }
}
