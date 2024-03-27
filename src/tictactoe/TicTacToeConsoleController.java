package tictactoe;
import java.io.IOException;
import java.util.Scanner;

public class TicTacToeConsoleController implements TicTacToeController{
  Readable input;
  Appendable output;
  Scanner scanner;

  public TicTacToeConsoleController(Readable input, Appendable output){
    this.input = input;
    this.output = output;
    this.scanner = new Scanner(this.input);

  }
  @Override
  public void playGame(TicTacToe m) {
    while (true){
      System.out.println("Please enter your move");
      String userInput = this.scanner.nextLine();
      output.append(userInput);
      System.out.println(output);


    }

  }
}
