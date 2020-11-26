package com.sansey.tictactoe.factories;

import com.sansey.tictactoe.Field;
import com.sansey.tictactoe.Turn;
import com.sansey.tictactoe.TurnFactory;

/**
 * Decorator that implements round-robin switching over provided factories.
 * Not thread-safe. Use {@link SyncronizedTurnFactory} decorator for thread-safe behavior.
 * @author a18555976
 */
public final class RoundRobinTurnFactory implements TurnFactory {
  private final TurnFactory[] factories;
  private int index = 0;
  
  public RoundRobinTurnFactory(TurnFactory ... factories ) {
    this.factories = factories;
  }

  @Override
  public Turn nextTurn(Field f) throws Exception {
    TurnFactory factory = this.factories[this.index];
    this.index = (this.index + 1) % this.factories.length;
    return factory.nextTurn(f);
  }
}
