package com.sansey.tictactoe.main;

import com.sansey.tictactoe.checks.AnyColumnHasAllCellsWithValue;
import com.sansey.tictactoe.checks.AnyRowHasAllCellsWithValue;
import com.sansey.tictactoe.checks.FalseCheck;
import com.sansey.tictactoe.checks.MainDiagonalHasAllCellsWithValue;
import com.sansey.tictactoe.checks.SecondaryDiagonalHasAllCellsWithValue;
import com.sansey.tictactoe.factories.ConsoleCrossesNaughtsTurnFactory;
import com.sansey.tictactoe.fields.TicTacToeField;
import com.sansey.tictactoe.games.ConsoleTicTacToe;
import com.sansey.tictactoe.ints.NaturalInt;
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
        ),
        new AnyRowHasAllCellsWithValue(
          new AnyColumnHasAllCellsWithValue(
            new MainDiagonalHasAllCellsWithValue(
              new SecondaryDiagonalHasAllCellsWithValue(
                new FalseCheck()
              )
            )
          )
        )
      ),
      new ConsoleCrossesNaughtsTurnFactory()
    ).start();
  }
}
