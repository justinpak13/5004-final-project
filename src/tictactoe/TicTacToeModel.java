package tictactoe;

import java.util.Arrays;
import java.util.stream.Collectors;

public class TicTacToeModel implements TicTacToe {
  final int NUMBER_OF_SQUARES = 9;
  private final Player[][] board;
  private Player currentTurn;
  private Player winner;

  private int numberOfSpacesAvailable;
  // add your implementation here

  public TicTacToeModel(){
    this.board = new Player[3][3];
    this.currentTurn = Player.X;
    this.winner = null;
    this.numberOfSpacesAvailable = NUMBER_OF_SQUARES;
  }

  /**
   * Execute a move in the position specified by the given row and column.
   *
   * @param r the row of the intended move
   * @param c the column of the intended move
   * @throws IllegalArgumentException if the space is occupied or the position is otherwise invalid
   * @throws IllegalStateException if the game is over
   */
  //TODO NEED TO IMPLEMENT
  public void move(int r, int c) throws IllegalArgumentException, IllegalStateException{
    if (r > 2 || r < 0 || c > 2 || c < 0){
      throw new IllegalArgumentException("Out of bounds");
    }

    if (this.board[r][c] != null){
      throw new IllegalArgumentException("Already Occupied");
    }

    if (this.isGameOver()){
      throw new IllegalStateException("Game is over");
    }

    // place the space
    this.board[r][c] = this.currentTurn;
    this.numberOfSpacesAvailable -= 1;

    // check for winner and set if needed
    if (this.isGameOver()){
      if (this.getWinner() != null){
        this.winner = this.getWinner();
      }
    }

    if (this.currentTurn.equals(Player.X)){
      this.currentTurn = Player.O;
    } else {
      this.currentTurn = Player.X;

    }
  }

  /**
   * Get the current turn, i.e., the player who will mark on the next call to move().
   *
   * @return the {@link Player} whose turn it is
   */
  public Player getTurn(){
    return this.currentTurn;
  }

  /**
   * Return whether the game is over. The game is over when either the board is full, or
   * one player has won.
   *
   * @return true if the game is over, false otherwise
   */
  public boolean isGameOver(){
    if (this.getWinner() == Player.O || this.getWinner() == Player.X){
      return true;
    }
    if (numberOfSpacesAvailable == 0){
      return true;
    }
    return false;

  }

  /**
   * Return the winner of the game, or {@code null} if there is no winner. If the game is not
   * over, returns {@code null}.
   *
   * @return the winner, or null if there is no winner
   */
  public Player getWinner(){
    // check rows
    for (int i = 0; i < 3; i++) {
      if (this.board[i][0] != null && this.board[i][1] != null && this.board[i][2] != null
              && this.board[i][0].equals(this.board[i][1])
              && this.board[i][1].equals(this.board[i][2])) {
        return this.board[i][0];
      }
    }

      // check columns
      for (int i = 0; i < 3; i++){
        if (this.board[0][i] != null && this.board[1][i] != null && this.board[2][i] != null
                && this.board[0][i].equals(this.board[1][i])
                && this.board[1][i].equals(this.board[2][i])){
          return this.board[0][i];
        }
    }
    // check diagonals
      // top left to bottom right
      if (this.board[0][0] != null && this.board[1][1] != null && this.board[2][2] != null
              && this.board[1][1].equals(this.board[0][0])
              && this.board[2][2].equals(this.board[1][1])){
        return this.board[0][0];
      }

      // top right to bottom left
      if (this.board[0][2] != null && this.board[1][1] != null && this.board[2][0] != null
              && this.board[1][1].equals(this.board[0][2])
              && this.board[0][2].equals(this.board[2][0])){
        return this.board[0][2];
      }

    return null;
  }

  /**
   * Return the current game state, as a 2D array of Player. A {@code null} value in the grid
   * indicates an empty position on the board.
   *
   * @return the current game board
   */
  public Player[][] getBoard(){
    return this.board;
  }

  /**
   * Return the current {@link Player} mark at a given row and column, or {@code null} if the
   * position is empty.
   *
   * @param r the row
   * @param c the column
   * @return the player at the given position, or null if it's empty
   * @throws IllegalArgumentException if the row and column is invalid
   */
  public Player getMarkAt(int r, int c) throws IllegalArgumentException{
    if (r > 2 || r < 0 || c > 2 || c < 0){
      throw new IllegalArgumentException();
    }

    if (this.board[r][c] == null){
      return null;
    } else {
      return this.board[r][c];
    }

  }


  @Override
  public String toString() {
    // Using Java stream API to save code:
    return Arrays.stream(getBoard()).map(
      row -> " " + Arrays.stream(row).map(
        p -> p == null ? " " : p.toString()).collect(Collectors.joining(" | ")))
          .collect(Collectors.joining("\n-----------\n"));
    // This is the equivalent code as above, but using iteration, and still using 
    // the helpful built-in String.join method.
    /**********
    List<String> rows = new ArrayList<>();
    for(Player[] row : getBoard()) {
      List<String> rowStrings = new ArrayList<>();
      for(Player p : row) {
        if(p == null) {
          rowStrings.add(" ");
        } else {
          rowStrings.add(p.toString());
        }
      }
      rows.add(" " + String.join(" | ", rowStrings));
    }
    return String.join("\n-----------\n", rows);
    ************/
  }
}
