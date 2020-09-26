package com.sansey.tictactoe;

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
   */
  boolean endGame();

  /**
   * Returns {@link Field} that is result of the game turn.
   * @return {@link Field} that is result of the game turn
   */
  Field field();

  /**
   * Prints the {@link TurnResult} to provided {@link Output}.
   * @param output - the {@link Output} to print to
   */
  void printTo(Output output);

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
    public void printTo(final Output output) {
      // Does nothing
    }
  }
}
