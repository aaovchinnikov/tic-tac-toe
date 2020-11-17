package com.sansey.tictactoe.factories;

import java.io.PrintStream;
import java.util.Scanner;

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
  private final Scanner scanner;
  private final PrintStream out;
  /**
   * Variable field to decide which {@link Turn} implementation to return next.
   */
  private Class<?> next;

  /**
   * Main constructor.
   * @param scanner
   * @param out
   */
  public ConsoleCrossesNaughtsTurnFactory(Scanner scnr, PrintStream stream) {
    this.scanner = scnr;
    this.out = stream;
    this.next = ConsoleCrossesTurn.class;
  }

  @Override
  public Turn nextTurn(final Field field) throws Exception {
    if (this.next == ConsoleCrossesTurn.class) {
      this.next = ConsoleNaughtsTurn.class;
      return new ConsoleCrossesTurn(field, this.scanner, this.out);
    } else {
      this.next = ConsoleCrossesTurn.class;
      return new ConsoleNaughtsTurn();
    }
  }
}
