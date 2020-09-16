package com.sansey.tictactoe;

import java.io.PrintStream;

public final class TicTacToeField implements Field {

  @Override
  public void printTo(final PrintStream out) {
    out.println("Field");
  }
}
