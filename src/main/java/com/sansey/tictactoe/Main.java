package com.sansey.tictactoe;

import com.sansey.tictactoe.matrices.SimpleIntMatrix;
import com.sansey.tictactoe.matrices.ValidatedFieldArray;
import java.util.Scanner;

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
    final int size = 3;
    new ConsoleTicTacToe(
        new Scanner(System.in),
        System.out,
        new TicTacToeField(
            new ValidatedFieldArray(
                new SimpleIntMatrix(
                    new int[size][size]
                ),
                new NaturalInt(size)
            )
        )
    ).start();
  }
}
