package com.sansey.tictactoe.games;

import com.sansey.tictactoe.Field;
import com.sansey.tictactoe.Game;
import com.sansey.tictactoe.Output;
import com.sansey.tictactoe.Turn;
import com.sansey.tictactoe.TurnFactory;
import com.sansey.tictactoe.TurnResult;

/**
 * Represents a configurable turn-based game that is played on a {@link Field},
 * has a mechanism to determine next turn - a {@link TurnFactory}, 
 * and has an {@link Output} mechanism to present information to user or client.
 * @author Alexander Ovchinnikov
 */
public final class TurnBasedGame implements Game {
  private final Field field;
  private final TurnFactory factory;
  private final Output output;
  
  /**
   * Main constructor.
   * @param fld - a {@link Field} to be played on
   * @param fctry - a {@link TurnFactory} that determines next turn
   * @param out - an {@link Output} mechanism to present information to user or client
   */
  public TurnBasedGame(Field fld, TurnFactory fctry, Output out) {
    this.field = fld;
    this.factory = fctry;
    this.output = out;
  }

  @Override
  public void start() {
    try {
      TurnResult result;
      Field fld = this.field;
      do {
        final Turn turn = this.factory.nextTurn(fld);
        result = turn.result();
        fld = result.field();
        fld.outTo(this.output);
        result.outTo(this.output);
      } while (!result.lastTurn());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
