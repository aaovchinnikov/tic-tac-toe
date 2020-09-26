package com.sansey.tictactoe.factories;

import com.sansey.tictactoe.Field;
import com.sansey.tictactoe.Turn;
import com.sansey.tictactoe.TurnFactory;
import com.sansey.tictactoe.turns.ConsoleCrossesTurn;
import com.sansey.tictactoe.turns.ConsoleNaughtsTurn;

/**
 * Factory that produces instances of {@link ConsoleCrossesTurn}
 * and {@link ConsoleNaughtsTurn} one by one,
 * starting from {@link ConsoleCrossesTurn}.
 * This implementation it not thread-safe.
 * Use {@link SyncronizedTurnFactory} decorator to have thread-safe behavior.
 * @author Alexander Ovchinnikov
 */
public final class ConsoleCrossesNaughtsTurnFactory implements TurnFactory {
  /**
   * Variable field to decide which {@link Turn} implementation to return next.
   */
  private Class<?> next;

  /**
   * Main constructor.
   */
  public ConsoleCrossesNaughtsTurnFactory() {
    this.next = ConsoleCrossesTurn.class;
  }

  @Override
  public Turn createTurn(final Field f) throws Exception {
    if (this.next == ConsoleCrossesTurn.class) {
      this.next = ConsoleNaughtsTurn.class;
      return new ConsoleCrossesTurn();
    } else {
      this.next = ConsoleCrossesTurn.class;
      return new ConsoleNaughtsTurn();
    }
  }
}
