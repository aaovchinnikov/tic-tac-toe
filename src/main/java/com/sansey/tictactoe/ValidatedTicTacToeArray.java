package com.sansey.tictactoe;

/**
 * Validating decorator for {@link IntMatrix} that checks provided
 * integers array to be suitable for backing {@link TicTacToeField}.
 * Valid dimension {@link #size} is provided at constructor.
 * Suitable array is [{@link #size}]x[{@link #size}] (e.g. 3x3)
 * and has only values 0, 1, 2.
 * @author Alexander Ovchinnikov
 */
public final class ValidatedTicTacToeArray implements IntMatrix {
  /**
   * Integers array that stores the Tic-tac-toe field.
   * Empty cells are represented by value 0 in array item.
   * X's are represented by value 1 in array item.
   * O's are represented by value 2 in array item.
   */
  private final int[][] array;

  /**
   * Valid size of field.
   */
  private final NaturalInt size;

  /**
   * Main constructor.
   * @param arr - integers array that stores the Tic-tac-toe field.
   * @param s - valid size of field
   */
  public ValidatedTicTacToeArray(final int[][] arr, final NaturalInt s) {
    this.array = arr;
    this.size = s;
  }

  /**
   * Validates decorated byte[][] array to be 3x3 in size and
   * to have only values 0, 1, 2, then returns it.
   */
  @Override
  public int[][] matrix() throws Exception {
    if (this.array.length != this.size.value()) {
      throw new Exception(
          "Provided array should be "
              + this.size.value()
              + "x"
              + this.size.value()
              + " in size, but instead has rows: "
              + this.array.length
      );
    }
    if (this.array[0].length != this.size.value()) {
      throw new Exception(
          "Provided array should be "
              + this.size.value()
              + "x"
              + this.size.value()
              + " in size, but instead has columns: "
              + this.array[0].length
      );
    }
    for (int i = 0; i < this.size.value(); i++) {
      for (int j = 0; j < this.size.value(); j++) {
        if (
            this.array[i][j] != 0
            && this.array[i][j] != 1
            && this.array[i][j] != 2
        ) {
          throw new Exception(
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
