package com.sansey.tictactoe.checks;

import com.sansey.tictactoe.Check;
import com.sansey.tictactoe.IntMatrix;

/**
 * Checks that any column in provided matrix
 * has all its cells with provided value.
 * Doesn't validate provided matrix to has at least one row.
 * Use {@link NonZeroRowsMatrix} validating decorator for this purpose.
 * @author Alexander Ovchinnikov
 */
public class AnyColumnHasAllCellsWithValue implements Check {
  /**
   * Matrix to check.
   */
  private final IntMatrix matrix;

  /**
   * Value to check for.
   */
  private final int value;

  /**
   * Main constructor.
   * @param mtrx - integer matrix to check
   * @param v - integer value to check
   */
  public AnyColumnHasAllCellsWithValue(final IntMatrix mtrx, final int v) {
    this.matrix = mtrx;
    this.value = v;
  }

  /**
   * Checks that any row in provided matrix
   * has all its cells with provided value.
   * @return <code>true</code> if any row in provided matrix
   *     has all its cells with provided value,
   *     otherwise - <code>false</code>
   */
  @Override
  public boolean result() throws Exception {
    try {
      boolean passes;
      for (int j = 0; j < this.matrix.columns(); j++) {
        passes = true;
        for (int i = 0; passes && i < this.matrix.rows(); i++) {
          if (this.matrix.matrix()[i][j] != this.value) {
            passes = false;
          }
        }
        if (passes) {
          return passes;
        }
      }
      return false;
    } catch (Exception e) {
      throw new Exception(
          "Can't determite result of the check for provided matrix",
          e
      );
    }
  }
}
