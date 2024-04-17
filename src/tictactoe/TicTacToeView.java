package tictactoe;

/**
 * Interface for the tic tac toe view.
 */
public interface TicTacToeView {

  /**
   * Displays which player turn it is.
   * @param player the current player turn
   */
  public void requestTurn(Player player);

  /**
   * Connects the view to the controller.
   * @param controller the controller class.
   */
  public void addController(TicTacToeController controller);


  /**
   * Displays message for IllegalArugmentExceptions.
   * @param e Illegal argument error
   */
  void displayError(IllegalArgumentException e);

  /**
   * Displays message for IllegalStateExceptions.
   * @param e Illegal state error
   */
  void displayError(IllegalStateException e);

  /**
   * Displays message given a tie.
   */
  void displayTie();

  /**
   * Displays the winner.
   * @param winner the winning player
   */
  void displayWinner(Player winner);


  /**
   * Function used to get a representation of the board from the controller.
   * @param board 2d array representation of board.
   */
  void updateBoard(Player[][] board);
}
