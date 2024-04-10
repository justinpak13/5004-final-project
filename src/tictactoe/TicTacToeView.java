package tictactoe;

public interface TicTacToeView {
  public void requestTurn(Player player);

  public void addController(TicTacToeController controller);
}
