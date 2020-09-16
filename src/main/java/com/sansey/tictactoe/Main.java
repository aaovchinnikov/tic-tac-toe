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
    byte[][] array = new byte[3][3];
    new TicTacToeField(array).printTo(System.out);
    System.out.println();
    array[0][0] = 1;
    new TicTacToeField(array).printTo(System.out);
    System.out.println();
    array[0][1] = 2;
    new TicTacToeField(array).printTo(System.out);
    System.out.println();
  }
}
