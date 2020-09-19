package com.sansey.tictactoe;

public final class SimpleIntMatrix implements IntMatrix {
  /**
   * Decorated integers array.
   */
  private final int[][] array;

  /**
   * Main constructor.
   * @param arr - integers array to be decorated.
   */
  public SimpleIntMatrix(final int[][] arr) {
    this.array = arr;
  }

  @Override
  public int[][] matrix() {
    return this.array;
  }
}
