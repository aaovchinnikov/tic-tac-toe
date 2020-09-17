package com.sansey.tictactoe;

import java.io.PrintStream;

/**
 * Field to play classic Tic-tac-toe game.
 * This field has 3x3 cells.
 * This field is backed by 3x3 byte array in memory.
 * @author Alexander Ovchinnikov
 */
public final class TicTacToeField implements Field {
  /**
   * Byte array that stores the field.
   * Empty cells are represented by value 0 in array item.
   * X's are represented by value 1 in array item.
   * O's are represented by value 2 in array item.
   */
  private final ByteMatrix field;

  /**
   * Main constructor.
   * Doesn't validate provided array for size and content correctness.
   * Use {@link ValidatedTicTacToeArray} to validate passed byte array.
   * @param matrix - byte array that stores the field
   */
  public TicTacToeField(final ByteMatrix matrix) {
    this.field = matrix;
  }

  /**
   * Prints game field to provided {@link PrintStream}.
   * @throws IllegalStateException if backing array
   *     has value other than 0 or 1 or 2.
   */
  @Override
  public void printTo(final PrintStream out) {
    final int rows = 3;
    final int columns = 3;
    final byte[][] cache = this.field.matrix();
    out.println("  1 2 3");
    for (int i = 0; i < rows; i++) {
      out.print(i + 1);
      for (int j = 0; j < columns; j++) {
        out.print(' ');
        if (cache[i][j] == 0) {
          out.print('_');
        } else if (cache[i][j] == 1) {
          out.print('X');
        } else if (cache[i][j] == 2) {
          out.print('O');
        } else {
          throw new IllegalStateException(
              "Invalid value "
                  + cache[i][j]
                  + " in field backing array at element with index ["
                  + i
                  + "]["
                  + j
                  + "]."
                  + " Should be 0 or 1 or 2."
          );
        }
      }
      out.println();
    }
  }
}
