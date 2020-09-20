package com.sansey.tictactoe.matrices;

import com.sansey.tictactoe.IntMatrix;

/**
 * Validating decorator that checks decorated matrix
 * to has dimensions of equal sizes.
 * Doesn't validate decorated matrix to has at least one row.
 * Use {@link NonZeroRowsMatrix} for this purpose.
 * @author Alexander Ovchinnikov
 */
public final class EqualSizedMatrix implements IntMatrix {
  /**
   * Decorated {@link IntMatrix}.
   */
  private final IntMatrix origin;

  /**
   * Main constructor.
   * @param matrix - decorated {@link IntMatrix}
   */
  public EqualSizedMatrix(final IntMatrix matrix) {
    this.origin = matrix;
  }

  /**
   * Checks decorated matrix to has dimensions of equal sizes,
   * then returns the decorated {@link #matrix()}.
   * @return the decorated {@link #matrix()}
   * @throws Exception if decorated matrix has unequal sizes of dimensions
   *     or decorated matrix has thrown an exception
   */
  @Override
  public int[][] matrix() throws Exception {
    if (this.origin.matrix()[0].length != this.origin.matrix().length) {
      throw new Exception("Matrix should have dimensions of equal sizes");
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
