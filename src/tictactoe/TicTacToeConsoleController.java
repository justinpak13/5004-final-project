package tictactoe;
import java.io.IOException;
import java.util.Scanner;

public class TicTacToeConsoleController implements TicTacToeController{
  private Readable input;
  private Appendable output;
  private Scanner scanner;

  public TicTacToeConsoleController(Readable input, Appendable output) throws IllegalArgumentException{
    if (input == null || output == null){
      throw new IllegalArgumentException("Readable or Appendable is null");

    }
    this.input = input;
    this.output = output;
    this.scanner = new Scanner(this.input);

  }
  @Override
  public void playGame(TicTacToe m) throws IllegalStateException {
    // main game loop
    boolean playGame = true;
    while (playGame){

      displayBoard(m);

      // loop to request a move until player gives valid move
      boolean invalidInput = true;
      requestMove(m.getTurn());
      while (invalidInput){
        try {
          int quitCheck = getMove(m);
          if (quitCheck == -1){
            playGame = false;
            printQuit(m);
            displayBoard(m);
            break;
          }
          invalidInput = false;
        } catch(IllegalArgumentException e) {
          retry(e);
        }
      }

      if (m.isGameOver()){
          displayBoard(m);
          announceWinner(m.getWinner());
          break;
      }
    }
  }

  private void printQuit(TicTacToe m){
    try {
      output.append("Game quit! Ending game state:\n");
    } catch (IOException e){
      throw new IllegalStateException();
    }
  }

  private void announceWinner(Player winningPlayer){
    try {
      output.append("Game is over! ");
      if (winningPlayer == null){
        output.append("Tie game.\n");
      } else if (winningPlayer == Player.X){
        output.append("X wins! \n");
      } else {
        output.append("O wins! \n");
      }
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
  }

  private void displayBoard(TicTacToe m){
    try {
      output.append(m.toString());
      output.append("\n");
    } catch (IOException e){
      throw new IllegalStateException(e);
    }

  }
  private void requestMove(Player currentPlayer){
    try {
      output.append("Enter a move for ");
      if (currentPlayer == Player.X){
        output.append("X:\n");
      } else {
        output.append("O:\n");
      }
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
  }

  private void retry(IllegalArgumentException e){
    try {
      output.append(e.toString());
      output.append("\n");
    } catch (IOException d) {
      throw new IllegalStateException(d);
    }
  }

  private int getMove(TicTacToe m) throws IllegalArgumentException{
    String move1 = scanner.next();
    if (move1.equalsIgnoreCase("Q")){
      return -1;
    }

    String move2 = scanner.next();

    try {
      int row = Integer.parseInt(move1) - 1;
      int column = Integer.parseInt(move2) - 1;

      if (row < 0 || row > 2 || column < 0 || column > 2){
        throw new IllegalArgumentException("Not a valid move out of range: " + move1 + " " + move2);
      }
      m.move(row, column);
      return 0;
    } catch (NumberFormatException e){
      throw new IllegalArgumentException("Not a valid number: " + move1 + " " + move2);
    }
  }
}
