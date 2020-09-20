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
   * Returns true if the game has finished and X-es have won.
   * @return <code>true</code> if the game finished and X-es have won,
   *     <code>false</code> - if game has not finished yet or O-es have won or
   *     it's standoff
   * @throws Exception if result can't be determined for any reason
   */
  boolean crossesWon() throws Exception;

  /**
   * Returns true if the game finished and O-es have won.
   * @return <code>true</code> if the game finished and O-es have won,
   *     <code>false</code> - if game has not finished yet or X-es have won or
   *     it's standoff
   * @throws Exception if result can't be determined for any reason
   */
  boolean nougthsWon() throws Exception;

  /**
   * Returns true if the game has finished and it's standoff.
   * @return <code>true</code> if the game has finished and it's standoff,
   *     <code>false</code> - if game has not finished yet or X-es have won or
   *     O-es have won
   * @throws Exception if result can't be determined for any reason
   */
  boolean standoff() throws Exception;

  /**
   * Prints game field to provided {@link PrintStream}.
   * @param out - {@link PrintStream} to print game field to.
   * @throws Exception if field can't be printed for any reason
   */
  void printTo(PrintStream out) throws Exception;
}
