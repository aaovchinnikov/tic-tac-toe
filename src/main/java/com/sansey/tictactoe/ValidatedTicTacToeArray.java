package com.sansey.tictactoe;

/**
 * Validating decorator for ByteArray that checks provided byte array
 * to be suitable for backing {@link TicTacToeField}.
 * Suitable byte array is 3x3 and has only values 0, 1, 2.
 * @author Alexander Ovchinnikov
 */
public final class ValidatedTicTacToeArray implements ByteMatrix {
  /**
   * Byte array that stores the Tic-tac-toe field.
   * Empty cells are represented by value 0 in array item.
   * X's are represented by value 1 in array item.
   * O's are represented by value 2 in array item.
   */
  private final byte[][] array;

  /**
   * Main constructor.
   * @param arr - byte array that stores the Tic-tac-toe field.
   */
  public ValidatedTicTacToeArray(final byte[][] arr) {
    this.array = arr;
  }

  @Override
  public byte[][] matrix() {
    final int rows = 3;
    final int columns = 3;
    if (this.array.length != rows) {
      throw new IllegalArgumentException(
          "Provided array should be "
              + rows
              + "x"
              + columns
              + " in size, but instead has rows: "
              + this.array.length
      );
    }
    if (this.array[0].length != columns) {
      throw new IllegalArgumentException(
          "Provided array should be "
              + rows
              + "x"
              + columns
              + " in size, but instead has columns: "
              + this.array[0].length
      );
    }
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        if (this.array[i][j] != 0
            && this.array[i][j] != 1
            && this.array[i][j] != 2
        ) {
          throw new IllegalArgumentException(
              "Invalid value "
                  + this.array[i][j]
                  + " in provided array at element with index ["
                  + i
                  + "]["
                  + j
                  + "]."
                  + " Should be 0 or 1 or 2."
          );
        }
      }
    }
    return this.array;
  }
}
