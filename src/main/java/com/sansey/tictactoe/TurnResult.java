package com.sansey.tictactoe;

import java.io.PrintStream;

/**
 * Represents a resulting state of the game after the {@link Turn}.
 * @author Alexander Ovchinnikov
 */
public interface TurnResult {
  /**
   * Returns <code>true</code> if it is the end of the game -
   * the turn is the last and no more turns may be done,
   * otherwise - <code>false</code>.
   * @return <code>true</code> if the turn is last,
   *     otherwise - <code>false</code>.
   * @throws Exception if result can't be determined for any reason
   */
  boolean endGame() throws Exception;

  /**
   * Returns {@link Field} that is result of the game turn.
   * @return {@link Field} that is result of the game turn
   */
  Field field();

  /**
   * Prints the {@link TurnResult} to provided {@link Output}.
   * @param output - the {@link Output} to print to
   * @throws Exception if the {@link TurnResult} can't be printed for any reason
   */
  void printTo(PrintStream out) throws Exception;

  /**
   * Fake implementation that does nothing. may be used in unit tests that need
   * fake {@link TurnResult} as an argument but don't use its methods.
   * Also useful as NullObject pattern.
   * @author Alexander Ovchinnikov
   */
  final class Fake implements TurnResult {

    @Override
    public boolean endGame() {
      return false;
    }

    @Override
    public Field field() {
      return null;
    }

    @Override
    public void printTo(final PrintStream out) {
      // Does nothing
    }
  }
}
