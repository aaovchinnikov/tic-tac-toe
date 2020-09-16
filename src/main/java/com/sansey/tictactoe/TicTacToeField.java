package com.sansey.tictactoe;

import java.io.PrintStream;

/**
 * Field to play classic Tic-tac-toe game.
 * This field has 3x3 cells.
 * This field is backed by 3x3 byte array in memory.
 * @author Alexander Ovchinnikov
 */
public final class TicTacToeField implements Field {
  //FIXME Duplicates constant in ValidatedTicTacToeArray
  /**
   * Size of field array in one dimension.
   */
  private static final int FIELD_SIZE = 3;

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
   * @param matrix - byte array that stores the field
   */
  public TicTacToeField(final ByteMatrix matrix) {
    this.field = matrix;
  }

  /**
   * Secondary (default) constructor.
   */
  public TicTacToeField() {
    this(
        new SimpleByteMatrix(
            new byte[FIELD_SIZE][FIELD_SIZE]
        )
    );
  }

  @Override
  public void printTo(final PrintStream out) {
    final byte[][] cache = this.field.matrix();
    out.println("  1 2 3");
    for (int i = 0; i < FIELD_SIZE; i++) {
      out.print(i + 1);
      for (int j = 0; j < FIELD_SIZE; j++) {
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
