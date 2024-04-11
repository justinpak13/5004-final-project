package tictactoe;

public interface TicTacToeView {
  public void requestTurn(Player player);

  public void addController(TicTacToeController controller);

  void drawMark(Player turn, int row, int column);

  void displayError(IllegalArgumentException e);

  void displayError(IllegalStateException e);

  void displayTie();

  void displayWinner(Player winner);

}
