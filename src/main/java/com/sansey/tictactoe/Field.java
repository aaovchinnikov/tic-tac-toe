package com.sansey.tictactoe;

import java.io.PrintStream;

/**
 * Represents game field that consists of cells.
 * @author Alexander Ovchinnikov
 */
public interface Field {
  /**
   * Returns Field with cell at provided coordinates
   * set to provided value.
   * @param value - {@link IntValueAt} for cell
   * @return Field with cell set to provided value
   * @throws Exception if Field can't be returned for any reason
   */
  Field withValueAt(IntValueAt value) throws Exception;

  /**
   * Prints game field to provided {@link PrintStream}.
   * @param out - {@link PrintStream} to print game field to.
   * @throws Exception if field can't be printed for any reason
   */
  void printTo(PrintStream out) throws Exception;
}
