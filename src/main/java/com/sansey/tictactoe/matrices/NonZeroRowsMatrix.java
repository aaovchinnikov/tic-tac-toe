package com.sansey.tictactoe.matrices;

import com.sansey.tictactoe.IntMatrix;

/**
 * Validating decorator that checks decorated martix
 * to has at least 1 row.
 * @author Alexander Ovchinnikov
 */
public final class NonZeroRowsMatrix implements IntMatrix {
  /**
   * Decorated {@link IntMatrix}.
   */
  private final IntMatrix origin;

  /**
   * Main constructor.
   * @param matrix - decorated {@link IntMatrix}
   */
  public NonZeroRowsMatrix(final IntMatrix matrix) {
    this.origin = matrix;
  }

  /**
   * Checks decorated martix to has at least 1 row then
   * returns the decorated {@link #matrix()}.
   * @return the decorated {@link #matrix()}
   * @throws Exception if decorated martix has zero rows
   *     or decorated matrix has thrown an exception
   */
  @Override
  public int[][] matrix() throws Exception {
    if (this.origin.matrix().length == 0) {
      throw new Exception("Matrix should have at least one row");
    }
    return this.origin.matrix();
  }

  @Override
  public int rows() throws Exception {
    return this.matrix().length;
  }

  @Override
  public int columns() throws Exception {
    return this.matrix()[0].length;
  }
}
