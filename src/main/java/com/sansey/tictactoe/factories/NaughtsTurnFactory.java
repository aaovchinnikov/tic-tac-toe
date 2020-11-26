package com.sansey.tictactoe.factories;

import com.sansey.tictactoe.Field;
import com.sansey.tictactoe.Turn;
import com.sansey.tictactoe.TurnFactory;
import com.sansey.tictactoe.turns.NaughtsTurn;

public final class NaughtsTurnFactory implements TurnFactory{

  @Override
  public Turn nextTurn(Field f) throws Exception {
    return new NaughtsTurn(f);
  }
}
