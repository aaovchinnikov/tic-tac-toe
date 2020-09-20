package com.sansey.tictactoe.checks;

import com.sansey.tictactoe.Check;
import com.sansey.tictactoe.IntMatrix;

/**
 * Checks that main diagonal in provided matrix
 * has all its cells with provided value.
 * Doesn't validate provided matrix
 * to be equal-sized and to has at least one row.
 * Use {@link NonZeroRowsMatrix} and {@link EqualSizedMatrix}
 * validating decorators for this purpose.
 * @author Alexander Ovchinnikov
 */
public class MainDiagonalHasAllCellsWithValue implements Check {
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
  public MainDiagonalHasAllCellsWithValue(final IntMatrix mtrx, final int v) {
    this.matrix = mtrx;
    this.value = v;
  }

  /**
   * Checks that main diagonal in provided matrix
   * has all its cells with provided value.
   * @return <code>true</code> if main diagonal in provided matrix
   *     has all its cells with provided value,
   *     otherwise - <code>false</code>
   */
  @Override
  public boolean result() throws Exception {
    try {
      boolean passes = true;
      for (int i = 0; passes && i < this.matrix.rows()
          && i < this.matrix.columns(); i++
      ) {
        if (this.matrix.matrix()[i][i] != this.value) {
          passes = false;
        }
      }
      if (passes) {
        return passes;
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
