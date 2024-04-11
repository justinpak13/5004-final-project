package tictactoe;

public class SwingTicTacToeController implements TicTacToeController {
  private TicTacToe model;
  private TicTacToeView view;
  private boolean gameInProgress;

  public SwingTicTacToeController(TicTacToeView view, TicTacToe model) {
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
    gameInProgress = true;
    this.view.addController(this);
    this.view.requestTurn(m.getTurn());
  }

  public void getInput(int coordinate) {
    inputMove(coordinate);
  }

  private void inputMove(int coordinate) {
    int row;
    int column;

    switch (coordinate) {
      case 1:
        row = 0;
        column = 0;
        break;

      case 2:
        row = 0;
        column = 1;
        break;

      case 3:
        row = 0;
        column = 2;
        break;

      case 4:
        row = 1;
        column = 0;
        break;

      case 5:
        row = 1;
        column = 1;
        break;

      case 6:
        row = 1;
        column = 2;
        break;

      case 7:
        row = 2;
        column = 0;
        break;

      case 8:
        row = 2;
        column = 1;
        break;
      default:
        row = 2;
        column = 2;
    }
    if (gameInProgress) {
      try {
        Player mark = model.getTurn();
        model.move(row, column);
        view.drawMark(mark, row, column);
        if (model.isGameOver()) {
          gameInProgress = false;
          if (model.getWinner() == null) {
            view.displayTie();
          } else {
            view.displayWinner(model.getWinner());
          }

        } else {
          view.requestTurn(model.getTurn());

        }
      } catch (IllegalArgumentException e) {
        view.displayError(e);
      } catch (IllegalStateException e) {
        view.displayError(e);
      }
    }
  }
}
