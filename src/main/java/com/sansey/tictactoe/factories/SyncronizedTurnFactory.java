package com.sansey.tictactoe.factories;

import com.sansey.tictactoe.Field;
import com.sansey.tictactoe.Turn;
import com.sansey.tictactoe.TurnFactory;

/**
 * Thread-safe decorator for {@link TurnFactory} instances.
 * @author Alexander Ovchinnikov
 */
public final class SyncronizedTurnFactory implements TurnFactory {
  /**
   * Decorated {@link TurnFactory}.
   */
  private final TurnFactory origin;

  /**
   * Main constructor.
   * @param orig - {@link TurnFactory} to be decorated
   */
  public SyncronizedTurnFactory(final TurnFactory orig) {
    this.origin = orig;
  }

  /**
   * Synchronized invocation of
   * decorated {@link TurnFactory#createTurn(Field)}.
   */
  @Override
  public synchronized Turn createTurn(final Field f) throws Exception {
    return this.origin.createTurn(f);
  }
}
