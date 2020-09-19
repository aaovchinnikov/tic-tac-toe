package com.sansey.tictactoe;

/**
 * Validating decorator for {@link IntMatrix} that checks provided
 * integers array to be suitable for backing {@link TicTacToeField}.
 * Suitable byte array is 3x3 in size and has only values 0, 1, 2.
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
   * Main constructor.
   * @param arr - integers array that stores the Tic-tac-toe field.
   */
  public ValidatedTicTacToeArray(final int[][] arr) {
    this.array = arr;
  }

  /**
   * Validates decorated byte[][] array to be 3x3 in size and
   * to have only values 0, 1, 2, then returns it.
   */
  @Override
  public int[][] matrix() throws Exception {
    // FIXME Checkstyle workaround to hide internal knowledge that field is 3x3
    final int rows = 3;
    final int columns = 3;
    if (this.array.length != rows) {
      throw new Exception(
          "Provided array should be "
              + rows
              + "x"
              + columns
              + " in size, but instead has rows: "
              + this.array.length
      );
    }
    if (this.array[0].length != columns) {
      throw new Exception(
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
