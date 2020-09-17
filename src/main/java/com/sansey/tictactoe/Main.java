package com.sansey.tictactoe;

public final class Main {
  private Main() {
    // Checkstyle. Utility classes should not have
    // a public or default constructor.
  }

  /**
   * The main() method - starting point of application.
   * @param args - command-line arguments of application
   */
  public static void main(final String[] args) {
    final int rows = 3;
    final int columns = 3;
    new ConsoleTicTacToe(
        System.out,
        new TicTacToeField(
            new ValidatedTicTacToeArray(
                new byte[rows][columns]
            )
        )
    ).start();
  }
}
