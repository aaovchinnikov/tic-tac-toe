package com.sansey.tictactoe;

/**
 * Abstract factory that returns instances of {@link Turn}
 * for provided {@link Field}.
 * @author Alexander Ovchinnikov
 */
public interface TurnFactory {
  /**
   * Return instance of {@link Turn} for provided {@link Field}.
   * @param f - {@link Field} for performing the turn
   * @return instance of {@link Turn} for provided {@link Field}
   */
  Turn createTurn(Field f) throws Exception;
}
