import static org.junit.Assert.assertEquals;

import java.io.StringReader;
import java.util.Arrays;
import org.junit.Test;
import tictactoe.FailingAppendable;
import tictactoe.Player;
import tictactoe.TicTacToe;
import tictactoe.TicTacToeConsoleController;
import tictactoe.TicTacToeController;
import tictactoe.TicTacToeModel;

/**
 * Test cases for the tic tac toe controller, using mocks for readable and appendable.
 */
public class TicTacToeControllerTest {

  // ADDITIONAL TEST CASES TO IMPLEMENT:
  // Play game to completion, where there is a winner
  // Input where the q comes instead of an integer for the row
  // Input where the q comes instead of an integer for the column
  // Input where non-integer garbage comes instead of an integer for the row
  // Input where non-integer garbage comes instead of an integer for the column
  // Input where the move is integers, but outside the bounds of the board
  // Input where the move is integers, but invalid because the cell is occupied
  // Multiple invalid moves in a row of various kinds
  // Input including valid moves interspersed with invalid moves, game is played to completion
  // What happens when the input ends "abruptly" -- no more input, but not quit, and game not over
  // THIS IS NOT AN EXHAUSTIVE LIST

  @Test
  public void testSingleValidMove() {
    TicTacToe m = new TicTacToeModel();
    StringBuilder gameLog = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(new StringReader("2 2 q"), gameLog);
    c.playGame(m);
    assertEquals("   |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "Enter a move for X:\n"
        + "   |   |  \n"
        + "-----------\n"
        + "   | X |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "Enter a move for O:\n"
        + "Game quit! Ending game state:\n"
        + "   |   |  \n"
        + "-----------\n"
        + "   | X |  \n"
        + "-----------\n"
        + "   |   |  \n", gameLog.toString());
  }

  @Test
  public void testBogusInputAsRow() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("!#$ 2 q");
    StringBuilder gameLog = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
    // split the output into an array of lines
    String[] lines = gameLog.toString().split("\n");
    // check that it's the correct number of lines
    assertEquals(13, lines.length);
    // check that the last 6 lines are correct
    String lastMsg = String.join("\n",
        Arrays.copyOfRange(lines, lines.length - 6, lines.length));
    assertEquals("Game quit! Ending game state:\n"
        + "   |   |  \n"
        + "-----------\n"
        + "   |   |  \n"
        + "-----------\n"
        + "   |   |  ", lastMsg);
    // note no trailing \n here, because of the earlier split
  }

  @Test
  public void testTieGame() {
    TicTacToe m = new TicTacToeModel();
    // note the entire sequence of user inputs for the entire game is in this one string:
    StringReader input = new StringReader("2 2 1 1 3 3 1 2 1 3 2 3 2 1 3 1 3 2");
    StringBuilder gameLog = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
    String[] lines = gameLog.toString().split("\n");
    assertEquals(60, lines.length);
    assertEquals("Game is over! Tie game.", lines[lines.length - 1]);
  }

  @Test(expected = IllegalStateException.class)
  public void testFailingAppendable() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("2 2 1 1 3 3 1 2 1 3 2 3 2 1 3 1 3 2");
    Appendable gameLog = new FailingAppendable();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
  }

  // Play game to completion, where there is a winner
  @Test
  public void testWinnerX() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("2 2 1 1 2 1 1 2 2 3");
    StringBuilder gameLog = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
    assertEquals(m.getWinner(), Player.X);
  }

  @Test
  public void testWinnerO() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("3 3 2 2 1 1 2 1 1 2 2 3");
    StringBuilder gameLog = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
    assertEquals(m.getWinner(), Player.O);
  }

  // Input where the q comes instead of an integer for the row
  @Test
  public void testQuitRow() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("3 3 2 2 q 4");
    StringBuilder gameLog = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
    String[] lines = gameLog.toString().split("\n");
    assertEquals(24, lines.length);
    assertEquals("Game quit! Ending game state:", lines[lines.length - 6]);
  }

  // Input where the q comes instead of an integer for the column
  @Test
  public void testQuitColumn() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("3 3 2 2 3 Q");
    StringBuilder gameLog = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
    String[] lines = gameLog.toString().split("\n");
    assertEquals(24, lines.length);
    assertEquals("Game quit! Ending game state:", lines[lines.length - 6]);
  }

  // Input where non-integer garbage comes instead of an integer for the row
  @Test
  public void garbageRow() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("adsf 3 3 3 q");
    StringBuilder gameLog = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
    String[] lines = gameLog.toString().split("\n");
    assertEquals(19, lines.length);
    assertEquals("java.lang.IllegalArgumentException: Not a valid number: adsf 3",
            lines[lines.length - 13]);
  }

  // Input where non-integer garbage comes instead of an integer for the column
  @Test
  public void garbageColumn() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("3 asdf 3 3 q");
    StringBuilder gameLog = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
    String[] lines = gameLog.toString().split("\n");
    assertEquals(19, lines.length);
    assertEquals("java.lang.IllegalArgumentException: Not a valid number: 3 asdf",
            lines[lines.length - 13]);
  }

  // Input where the move is integers, but outside the bounds of the board

  @Test
  public void outOfBounds() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("3 4 3 3 q");
    StringBuilder gameLog = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
    String[] lines = gameLog.toString().split("\n");
    assertEquals(19, lines.length);
    assertEquals("java.lang.IllegalArgumentException: Not a valid move out of range: 3 4",
            lines[lines.length - 13]);
  }

  @Test
  public void outOfBoundsNegative() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("3 0 3 3 q");
    StringBuilder gameLog = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
    String[] lines = gameLog.toString().split("\n");
    assertEquals(19, lines.length);
    assertEquals("java.lang.IllegalArgumentException: Not a valid move out of range: 3 0",
            lines[lines.length - 13]);
  }
  // Input where the move is integers, but invalid because the cell is occupied

  @Test
  public void testOccupied() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("3 1 3 1 q");
    StringBuilder gameLog = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
    String[] lines = gameLog.toString().split("\n");
    assertEquals(19, lines.length);
    assertEquals("java.lang.IllegalArgumentException: Already Occupied", lines[lines.length - 7]);
  }

  // Multiple invalid moves in a row of various kinds

  @Test
  public void multipleInvalidMoves() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("sdaf 2 2 1 903 3 sd 3 q");
    StringBuilder gameLog = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
    String[] lines = gameLog.toString().split("\n");
    assertEquals(21, lines.length);
  }
  // Input including valid moves interspersed with invalid moves, game is played to completion

  @Test
  public void multipleInvalidMovesCompleted() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("1 1 1 2 sdaf 2 2 1 903 3 sd 3 1 2 1 3 2"
            + " 2 3 1 1 3 3 1 1 3 3 2 3 3 2 3");
    StringBuilder gameLog = new StringBuilder();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
    String[] lines = gameLog.toString().split("\n");
    assertEquals("Game is over! X wins! ", lines[lines.length - 1]);
  }

}
