package com.sansey.tictactoe;

/**
 * Represents a turn in turn-based game.
 * @author Alexander Ovchinnikov
 */
public interface Turn {
  /**
   * Returns the result of the turn as {@link TurnResult} object.
   * @return the result of the turn
   */
  TurnResult result();
}
