package com.sansey.tictactoe.checks;

import com.sansey.tictactoe.CellMatrix;
import com.sansey.tictactoe.WinCheck;

/**
 * Check that always returns false.
 * May be used as terminal {@link WinCheck} in chain.
 * @author Alexander Ovchinnikov
 */
public final class FalseCheck implements WinCheck {

  @Override
  public boolean result(CellMatrix matrix, Class<?> clazz) {
    return false;
  }
}
