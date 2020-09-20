package com.sansey.tictactoe.matrices;

import com.sansey.tictactoe.IntMatrix;

public final class SimpleIntMatrix implements IntMatrix {
  /**
   * Decorated integers array.
   */
  private final int[][] matrix;

  /**
   * Main constructor.
   * @param arr - integers array to be decorated.
   */
  public SimpleIntMatrix(final int[][] arr) {
    this.matrix = arr;
  }

  @Override
  public int[][] matrix() {
    return this.matrix;
  }

  @Override
  public int rows() throws Exception {
    return this.matrix.length;
  }

  @Override
  public int columns() throws Exception {
    return this.matrix[0].length;
  }
}
