package com.sansey.tictactoe;

/**
 * Validating decorator for ByteArray that checks provided byte array
 * to be suitable for backing {@link TicTacToeField}.
 * @author Alexander Ovchinnikov
 */
public final class ValidatedTicTacToeArray implements ByteMatrix {
  /**
   * Size of field array in one dimension.
   */
  private static final int FIELD_SIZE = 3;

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
    if (this.array.length != FIELD_SIZE) {
      throw new IllegalArgumentException(
          "Provided array should be 3x3 in size, but instead has rows: "
              + this.array.length
      );
    }
    if (this.array[0].length != FIELD_SIZE) {
      throw new IllegalArgumentException(
          "Provided array should be 3x3 in size, but instead has columns: "
              + this.array[0].length
      );
    }
    for (int i = 0; i < FIELD_SIZE; i++) {
      for (int j = 0; j < FIELD_SIZE; j++) {
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
