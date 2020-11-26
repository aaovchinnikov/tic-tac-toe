package com.sansey.tictactoe.main;

import com.sansey.tictactoe.checks.AnyColumnHasAllCellsWithValue;
import com.sansey.tictactoe.checks.AnyRowHasAllCellsWithValue;
import com.sansey.tictactoe.checks.FalseCheck;
import com.sansey.tictactoe.checks.MainDiagonalHasAllCellsWithValue;
import com.sansey.tictactoe.checks.SecondaryDiagonalHasAllCellsWithValue;
import com.sansey.tictactoe.factories.CrossesTurnFactory;
import com.sansey.tictactoe.factories.NaughtsTurnFactory;
import com.sansey.tictactoe.factories.RoundRobinTurnFactory;
import com.sansey.tictactoe.factories.SyncronizedTurnFactory;
import com.sansey.tictactoe.fields.TicTacToeField;
import com.sansey.tictactoe.games.TurnBasedGame;
import com.sansey.tictactoe.ints.NaturalInt;
import com.sansey.tictactoe.matrices.SimpleIntMatrix;
import com.sansey.tictactoe.matrices.ValidatedFieldArray;
import com.sansey.tictactoe.outputs.StringBuilderPrintedOutput;
import com.sansey.tictactoe.views.CrossView;
import com.sansey.tictactoe.views.EmptyCellView;
import com.sansey.tictactoe.views.NaughtView;
import com.sansey.tictactoe.views.UnknownView;

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
    final int empty = 0;
    final int crosses = 1;
    final int naughts = 2;
    final int size = 3;
    new TurnBasedGame(
      new TicTacToeField(
        new ValidatedFieldArray(
          new SimpleIntMatrix(
            new int[size][size]
          ),
          new NaturalInt(size)
        ),
        new EmptyCellView(
          empty,
          new CrossView(
            crosses, 
            new NaughtView(
              naughts,
              new UnknownView()
            )
          )
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
      new SyncronizedTurnFactory(
        new RoundRobinTurnFactory(
            new CrossesTurnFactory(),
            new NaughtsTurnFactory()
        )
      ), 
      new StringBuilderPrintedOutput(
        new StringBuilder(),
        System.out
      )
    ).start();
  }
}
