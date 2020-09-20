package com.sansey.tictactoe.checks;

import com.sansey.tictactoe.Check;
import com.sansey.tictactoe.IntMatrix;

/**
 * Chained {@link Check} that checks that secondary diagonal in
 * provided matrix has all its cells with provided value.
 * If check passes then returns immediately, otherwise calls
 * next {@link Check} in chain.
 * Doesn't validate provided matrix to be equal-sized and
 * to has at least one row.
 * Use {@link NonZeroRowsMatrix} and {@link EqualSizedMatrix}
 * validating decorators for this purpose.
 * @author Alexander Ovchinnikov
 */
public class SecondaryDiagonalHasAllCellsWithValue implements Check {
  /**
   * Next {@link Check} in chain.
   */
  private final Check next;

  /**
   * Main constructor.
   * @param nxt - next {@link Check} in chain
   */
  public SecondaryDiagonalHasAllCellsWithValue(final Check nxt) {
    this.next = nxt;
  }


  /**
   * Checks that secondary diagonal in provided matrix
   * has all its cells with provided value.
   * @param matrix - {@link IntMatrix} to check
   * @param value - value to check for
   * @return <code>true</code> if main diagonal in provided matrix
   *     has all its cells with provided value,
   *     otherwise - <code>false</code>
   */
  @Override
  public boolean result(
      final IntMatrix matrix,
      final int value
  ) throws Exception {
    try {
      boolean passes = true;
      for (int i = 0, j = matrix.columns() - 1; passes
          && i < matrix.rows() && j >= 0; i++, j--
      ) {
        if (matrix.matrix()[i][j] != value) {
          passes = false;
        }
      }
      if (passes) {
        return passes;
      }
      return this.next.result(matrix, value);
    } catch (Exception e) {
      throw new Exception(
          "Can't determite result of the check for provided matrix",
          e
      );
    }
  }
}
