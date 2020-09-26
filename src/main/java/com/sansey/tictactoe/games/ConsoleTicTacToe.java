package com.sansey.tictactoe.games;

import com.sansey.tictactoe.Field;
import com.sansey.tictactoe.Game;
import com.sansey.tictactoe.Turn;
import com.sansey.tictactoe.TurnFactory;
import com.sansey.tictactoe.TurnResult;
import com.sansey.tictactoe.ints.NaturalInt;
import com.sansey.tictactoe.values.SimpleIntValueAt;
import com.sansey.tictactoe.values.ValidatedFieldValue;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Represents console version of Tic-tac-toe game.
 * @author Alexander Ovchinnikov
 */
public final class ConsoleTicTacToe implements Game {
  /**
   * {@link PrintStream} where to print console output.
   */
  private final PrintStream out;

  /**
   * Initial game {@link Field}.
   */
  private final Field field;

  /**
   * Factory that detaches game process
   * from concrete implementations of {@link Turn}.
   */
  private final TurnFactory factory;

  /**
   * Main constructor.
   * @param input - {@link Scanner} to read the input from
   * @param stream - {@link PrintStream} where to print console output
   * @param f - {@link Field} to play on
   * @param fctry - {@link TurnFactory} that produces
   *     {@link Turn}s for the game
   */
  public ConsoleTicTacToe(
      final PrintStream stream,
      final Field f,
      final TurnFactory fctry
  ) {
    this.out = stream;
    this.field = f;
    this.factory = fctry;
  }

  @Override
  public void start() {
    try {
      Field fld = this.field;
      TurnResult result = new TurnResult.Fake();
      this.out.println("Tic-tac-toe game started!");
      this.field.printTo(out);
      do {
        final Turn turn = this.factory.createTurn(fld);
        result = turn.result();
        fld = result.field();
        fld.printTo(out);
        // result.printTo(Output);
      } while (!result.endGame());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
