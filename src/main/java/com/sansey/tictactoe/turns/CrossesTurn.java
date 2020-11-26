package com.sansey.tictactoe.turns;

import com.sansey.tictactoe.Field;
import com.sansey.tictactoe.Turn;
import com.sansey.tictactoe.TurnResult;

public final class CrossesTurn implements Turn{
  /**
   * Initial {@link Field} for the turn.
   */
  private final Field field;
  
  /**
   * Main constructor.
   * @param fld - {@link Field} for the turn
   */
  public CrossesTurn(Field fld) {
    this.field = fld;
  }

  @Override
  public TurnResult result() {
    // TODO Auto-generated method stub
    return null;
  }

}
