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
   * Main constructor.
   * @param stream - {@link PrintStream} where to print console output
   */
  public ConsoleTicTacToe(final PrintStream stream) {
    this.out = stream;
  }


  @Override
  public void start() {
    this.out.println("Tic-tac-toe game started!");
  }
}
