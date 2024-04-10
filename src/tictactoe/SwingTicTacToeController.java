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

    // main game loop
    boolean playGame = true;
    this.view.addController(this);
    while (playGame) {

      // loop to request a move until player gives valid move
      boolean invalidInput = true;
      this.view.requestTurn(m.getTurn());

      while (invalidInput) {
        //try {
        //  int quitCheck = getMove(m);
        //  if (quitCheck == -1) {
        //    playGame = false;
        //    printQuit(m);
        //    displayBoard(m);
        //    break;
        //  }
        //  invalidInput = false;
        //} catch (IllegalArgumentException e) {
        //  retry(e);
        //}
      }

      //  if (m.isGameOver()) {
      //    displayBoard(m);
      //    announceWinner(m.getWinner());
      //    break;
      //  }
    }
  }

  public void getInput(int coordinate){
    System.out.println(coordinate);

  }


}
