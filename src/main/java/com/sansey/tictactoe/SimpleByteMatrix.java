package com.sansey.tictactoe;

public final class SimpleByteMatrix implements ByteMatrix {
  /**
   * Decorated byte array.
   */
  private final byte[][] array;

  /**
   * Main constructor.
   * @param arr - byte array to be decorated.
   */
  public SimpleByteMatrix(final byte[][] arr) {
    this.array = arr;
  }

  @Override
  public byte[][] matrix() {
    return this.array;
  }
}
