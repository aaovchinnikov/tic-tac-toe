package com.sansey.tictactoe.results;

import com.sansey.tictactoe.Field;
import com.sansey.tictactoe.Output;
import com.sansey.tictactoe.TurnResult;

public final class ConsoleCrossesTurnResult implements TurnResult {
  private static final int CROSSES = 1;

  /**
   * The resulting {@link Field} after the turn.
   */
  private final Field field;

  /**
   * Main constructor.
   * @param field
   */
  public ConsoleCrossesTurnResult(Field field) {
    this.field = field;
  }

  @Override
  public boolean endGame() throws Exception {
    if (
      this.field.valueWon(CROSSES)
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
  public void printTo(Output output) throws Exception {
    System.out.print("Crosses finished their turn. ");
    if (this.field.valueWon(CROSSES)) {
      System.out.println("Crosses won.");
    } else if (this.field.full()) {
      System.out.print("Field is full. It's stalemate.");
    } else {
      System.out.println("Move to nex turn.");
    }
  }
}
