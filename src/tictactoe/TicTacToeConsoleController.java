package tictactoe;

import java.io.IOException;
import java.util.Scanner;

/**
 * Controller class that interacts with the model for tic-tac-toe.
 */
public class TicTacToeConsoleController implements TicTacToeController {
  private Readable input;
  private Appendable output;
  private Scanner scanner;

  /**
   * Constructor for the Controller class for tic-tac-toe.
   * @param input the readable input
   * @param output the output to the console
   * @throws IllegalArgumentException given incorrect arguments to readable or appendable
   */
  public TicTacToeConsoleController(Readable input, Appendable output)
          throws IllegalArgumentException {
    if (input == null || output == null) {
      throw new IllegalArgumentException("Readable or Appendable is null");

    }
    this.input = input;
    this.output = output;
    this.scanner = new Scanner(this.input);

  }

  /**
   * Main game loop function.
   * @param m a non-null tic tac toe Model
   * @throws IllegalStateException given any incorrect state of the game.
   */
  @Override
  public void playGame(TicTacToe m) throws IllegalStateException {
    // main game loop
    boolean playGame = true;
    while (playGame) {

      displayBoard(m);

      // loop to request a move until player gives valid move
      boolean invalidInput = true;
      requestMove(m.getTurn());
      while (invalidInput) {
        try {
          int quitCheck = getMove(m);
          if (quitCheck == -1) {
            playGame = false;
            printQuit(m);
            displayBoard(m);
            break;
          }
          invalidInput = false;
        } catch (IllegalArgumentException e) {
          retry(e);
        }
      }

      if (m.isGameOver()) {
        displayBoard(m);
        announceWinner(m.getWinner());
        break;
      }
    }
  }

  @Override
  public void getInput(int coordinate) {

  }

  /**
   * Helper function used to print the quitting statement.
   * @param m the tictactoe model
   */
  private void printQuit(TicTacToe m) {
    try {
      output.append("Game quit! Ending game state:\n");
    } catch (IOException e) {
      throw new IllegalStateException();
    }
  }

  /**
   * Helper function used to state winner if there is one.
   * @param winningPlayer Player enum representing the winning player
   */
  private void announceWinner(Player winningPlayer) {
    try {
      output.append("Game is over! ");
      if (winningPlayer == null) {
        output.append("Tie game.\n");
      } else if (winningPlayer == Player.X) {
        output.append("X wins! \n");
      } else {
        output.append("O wins! \n");
      }
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
  }

  /**
   * Helper function used to print the board state.
   * @param m the tic tac toe model
   */
  private void displayBoard(TicTacToe m) {
    try {
      output.append(m.toString());
      output.append("\n");
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }

  }

  /**
   * Helper function used to request for input.
   * @param currentPlayer Player enum used to determine which player to ask
   */
  private void requestMove(Player currentPlayer) {
    try {
      output.append("Enter a move for ");
      if (currentPlayer == Player.X) {
        output.append("X:\n");
      } else {
        output.append("O:\n");
      }
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
  }

  /**
   * a helper function used to announce an error.
   * @param e the error
   */
  private void retry(IllegalArgumentException e) {
    try {
      output.append(e.toString());
      output.append("\n");
    } catch (IOException d) {
      throw new IllegalStateException(d);
    }
  }

  /**
   * The main function that connects to the model to input a move.
   * @param m the tic tac toe model
   * @return an integer to represent success or failure
   * @throws IllegalArgumentException given an incorrect argument
   */
  private int getMove(TicTacToe m) throws IllegalArgumentException {
    String move1 = scanner.next();
    if ("Q".equalsIgnoreCase(move1)) {
      return -1;
    }

    String move2 = scanner.next();

    if ("Q".equalsIgnoreCase(move2)) {
      return -1;
    }

    try {
      int row = Integer.parseInt(move1) - 1;
      int column = Integer.parseInt(move2) - 1;

      if (row < 0 || row > 2 || column < 0 || column > 2) {
        throw new IllegalArgumentException("Not a valid move out of range: " + move1 + " " + move2);
      }
      m.move(row, column);
      return 0;
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("Not a valid number: " + move1 + " " + move2);
    }
  }
}
