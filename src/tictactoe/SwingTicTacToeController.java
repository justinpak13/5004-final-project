package tictactoe;

/**
 * Controller class for the swing tictactoe view and model.
 */
public class SwingTicTacToeController implements TicTacToeController {
  private TicTacToe model;
  private TicTacToeView view;
  private boolean gameInProgress;

  /**
   * Constructor for the controller class.
   * @param view the view class.
   * @param model the model class.
   */
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
    this.view.updateBoard(m.getBoard());
    this.view.requestTurn(m.getTurn());
  }

  /**
   * method used to communicate between view and model.
   * @param coordinate the corresponding section of the view clicked.
   */
  public void getInput(int coordinate) {
    inputMove(coordinate);
  }

  /**
   * Helper function that houses the main logic for the game.
   * @param coordinate the corresponding section of the view clicked
   */
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
        view.updateBoard(model.getBoard());
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
