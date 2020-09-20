package com.sansey.tictactoe.checks;

import com.sansey.tictactoe.Check;
import com.sansey.tictactoe.IntMatrix;

/**
 * Checks that secondary diagonal in provided matrix
 * has all its cells with provided value.
 * @author Alexander Ovchinnikov
 */
public class SecondaryDiagonalHasAllCellsWithValue implements Check {
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
  public SecondaryDiagonalHasAllCellsWithValue(
      final IntMatrix mtrx,
      final int v
  ) {
    this.matrix = mtrx;
    this.value = v;
  }

  /**
   * Checks that secondary diagonal in provided matrix
   * has all its cells with provided value.
   * @return <code>true</code> if main diagonal in provided matrix
   *     has all its cells with provided value,
   *     otherwise - <code>false</code>
   */
  @Override
  public boolean result() throws Exception {
    try {
      boolean passes = true;
      for (int i = 0, j = this.matrix.columns() - 1; passes
          && i < this.matrix.rows() && j >= 0; i++, j--
      ) {
        if (this.matrix.matrix()[i][j] != this.value) {
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
