package com.sansey.tictactoe.results;

import java.io.PrintStream;

import com.sansey.tictactoe.Field;
import com.sansey.tictactoe.Output;
import com.sansey.tictactoe.TurnResult;

public final class ConsoleCrossesTurnResult implements TurnResult {
  // FIXME get rid of static constants
  private static final int CROSSES = 1;
  
  private final int code;

  /**
   * The resulting {@link Field} after the turn.
   */
  private final Field field;

  /**
   * Main constructor.
   * @param field
   */
  public ConsoleCrossesTurnResult(int code, Field field) {
    this.code = code;
    this.field = field;
  }

  @Override
  public boolean endGame() throws Exception {
    if (
      this.field.valueWon(this.code)
        || this.field.full()
    ) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public Field field() {
    return this.field;
  }

  @Override
  public void printTo(final PrintStream out) throws Exception {
    out.print("Crosses finished their turn. ");
    if (this.field.valueWon(this.code)) {
      out.println("Crosses won.");
    } else if (this.field.full()) {
      out.print("Field is full. It's stalemate.");
    } else {
      out.println("Moving to next turn.");
    }
  }
}
