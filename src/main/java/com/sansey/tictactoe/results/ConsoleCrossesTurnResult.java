package com.sansey.tictactoe.results;

import java.io.PrintStream;

import com.sansey.tictactoe.Field;
import com.sansey.tictactoe.TurnResult;

public final class ConsoleCrossesTurnResult implements TurnResult {
  private final int code;
  private final TurnResult origin;

  /**
   * The resulting {@link Field} after the turn.
   */
  private final Field field;

  /**
   * Main constructor.
   * @param field
   */
  public ConsoleCrossesTurnResult(int code, Field field, TurnResult origin) {
    this.code = code;
    this.field = field;
    this.origin = origin;
  }

  @Override
  public boolean endGame() throws Exception {
    return this.field.valueWon(this.code) || this.origin.endGame();
  }

  @Override
  public Field field() {
    return this.origin.field();
  }

  @Override
  public void printTo(final PrintStream out) throws Exception {
    out.print("Crosses finished their turn. ");
    if (this.field.valueWon(this.code)) {
      out.println("Crosses won.");
    } else {
      this.origin.printTo(out);
    }
  }
}
