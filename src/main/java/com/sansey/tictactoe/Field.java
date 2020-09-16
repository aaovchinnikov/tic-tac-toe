package com.sansey.tictactoe;

import java.io.PrintStream;

/**
 * Represents game field that can print itself to provided {@link PrintStream}.
 * @author Alexander Ovchinnikov
 */
public interface Field {
  /**
   * Prints game field to provided {@link PrintStream}.
   * @param out - {@link PrintStream} to print game field to.
   */
  void printTo(PrintStream out);
}
