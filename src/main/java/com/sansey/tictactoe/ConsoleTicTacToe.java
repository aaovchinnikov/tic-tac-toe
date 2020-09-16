package com.sansey.tictactoe;

import java.io.PrintStream;

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
   * Main constructor.
   * @param stream - {@link PrintStream} where to print console output
   * @param f - {@link Field} to play on
   */
  public ConsoleTicTacToe(final PrintStream stream, final Field f) {
    this.out = stream;
    this.field = f;
  }

  @Override
  public void start() {
    this.out.println("Tic-tac-toe game started!");
    this.field.printTo(out);
  }
}
