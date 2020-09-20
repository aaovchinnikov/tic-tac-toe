package com.sansey.tictactoe.matrices;

import com.sansey.tictactoe.IntMatrix;
import com.sansey.tictactoe.ints.NaturalInt;

/**
 * Validating decorator for {@link IntMatrix} that checks provided
 * integers array to be suitable for backing {@link TicTacToeField}.
 * Valid dimension {@link #size} is provided at constructor.
 * Suitable array is [{@link #size}]x[{@link #size}] (e.g. 3x3)
 * and has only values 0, 1, 2.
 * @author Alexander Ovchinnikov
 */
public final class ValidatedFieldArray implements IntMatrix {
  /**
   * Integers array that stores the Tic-tac-toe field.
   * Empty cells are represented by value 0 in array item.
   * X's are represented by value 1 in array item.
   * O's are represented by value 2 in array item.
   */
  private final IntMatrix origin;

  /**
   * Valid size of field.
   */
  private final NaturalInt size;

  /**
   * Main constructor.
   * @param mtrx - integers array that stores the Tic-tac-toe field.
   * @param s - valid size of field
   */
  public ValidatedFieldArray(final IntMatrix mtrx, final NaturalInt s) {
    this.origin = mtrx;
    this.size = s;
  }

  /**
   * Validates decorated byte[][] array to be 3x3 in size and
   * to have only values 0, 1, 2, then returns it.
   */
  @Override
  public int[][] matrix() throws Exception {
    if (this.origin.rows() != this.size.value()) {
      throw new Exception(
          "Provided array should be "
              + this.size.value()
              + "x"
              + this.size.value()
              + " in size, but instead has rows: "
              + this.origin.rows()
      );
    }
    if (this.origin.columns() != this.size.value()) {
      throw new Exception(
          "Provided array should be "
              + this.size.value()
              + "x"
              + this.size.value()
              + " in size, but instead has columns: "
              + this.origin.columns()
      );
    }
    for (int i = 0; i < this.size.value(); i++) {
      for (int j = 0; j < this.size.value(); j++) {
        if (
            this.origin.matrix()[i][j] != 0
            && this.origin.matrix()[i][j] != 1
            && this.origin.matrix()[i][j] != 2
        ) {
          throw new Exception(
              "Invalid value "
                  + this.origin.matrix()[i][j]
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
