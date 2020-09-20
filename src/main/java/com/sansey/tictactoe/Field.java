package com.sansey.tictactoe;

import java.io.PrintStream;

/**
 * Represents Tic-tac-toe game field.
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
   * Returns true if the game has finished and provided values have won.
   * @param value - the value to check for the winning
   * @return <code>true</code> if the game finished and
   *     provided values have won, otherwise - <code>false</code>
   * @throws Exception if result can't be determined for any reason
   */
  boolean valueWon(int value) throws Exception;

  /**
   * Returns true if field is full of values and
   * have no more empty cells.
   * @return <code>true</code> if field is full of non-zero values and
   *     have no more empty cells, otherwise - <code>false</code>
   * @throws Exception if field can't be checked for any reason
   */
  boolean full() throws Exception;

  /**
   * Prints game field to provided {@link PrintStream}.
   * @param out - {@link PrintStream} to print game field to.
   * @throws Exception if field can't be printed for any reason
   */
  void printTo(PrintStream out) throws Exception;
}
