package com.sansey.tictactoe.results;

import com.sansey.tictactoe.Field;
import com.sansey.tictactoe.Output;
import com.sansey.tictactoe.TurnResult;

public final class FigureTurnResult implements TurnResult{
  private final Field field;
  private final Class<?> clazz;
  
  /**
   * @param fld
   * @param clz
   */
  public FigureTurnResult(Field fld, Class<?> clz) {
    this.field = fld;
    this.clazz = clz;
  }

  @Override
  public boolean lastTurn() throws Exception {
    return this.field.figureWon(this.clazz) || this.field.full();
  }

  @Override
  public Field field() {
    // FIXME it's getter. Should be refactored somehow
    return this.field;
  }

  @Override
  public void outTo(Output out) throws Exception {
    if (this.field.figureWon(this.clazz)) {
      out.withBody(
        this.clazz.getName() + " have won!"
      );
    } else if (this.field.full()) {
      out.withBody(
        "It's НИЧЬЯ!!!"
      );
    } else {
      out.withBody(
        this.clazz.getName() + " finished its turn"
      );
    }
    out.flush();
  }
}
