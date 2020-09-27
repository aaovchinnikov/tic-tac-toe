package com.sansey.tictactoe.results;

import java.io.PrintStream;

import com.sansey.tictactoe.Field;
import com.sansey.tictactoe.TurnResult;

public final class ConsoleCommonTurnResult implements TurnResult{
  /**
   * The resulting {@link Field} after the turn.
   */
  private final Field field;
  
  /**
   * Main constructor.
   * @param field
   */
  public ConsoleCommonTurnResult(Field field) {
    this.field = field;
  }

  @Override
  public boolean endGame() throws Exception {
    return this.field.full();
  }

  @Override
  public Field field() {
    return this.field;
  }

  @Override
  public void printTo(PrintStream out) throws Exception {
    if (this.field.full()) {
      out.println("Field is full. It's stalemate.");
    } else {
      out.println("Moving to next turn.");
    }
  }
}
