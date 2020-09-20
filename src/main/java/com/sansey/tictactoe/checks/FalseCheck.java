package com.sansey.tictactoe.checks;

import com.sansey.tictactoe.Check;
import com.sansey.tictactoe.IntMatrix;

/**
 * Check that always returns false.
 * May be used as terminal {@link Check} in chain.
 * @author Alexander Ovchinnikov
 */
public final class FalseCheck implements Check {
  @Override
  public boolean result(
      final IntMatrix matrix,
      final int value
  ) throws Exception {
    return false;
  }
}
