package com.sansey.tictactoe;

import java.io.PrintStream;
import java.util.Arrays;

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

  // FIXME javadoc from another method
  /**
   * Checks whether cell with coordinates [row][column] on the field is empty,
   * so is writable.
   * @param value - {@link ByteValueAt} for cell
   * @return <code>true</code> if cell empty and writable,
   *     <code>false</code> - otherwise
   * @throws Exception if cell coordinates are not valid: negative or
   *     out of the field
   */
  public Field withValueAt(
      final ByteValueAt value
  ) throws Exception {
    if (field.matrix()[value.row()][value.column()] != 0) {
      throw new Exception("Field at specified coordinates ["
          + value.row()
          + "]["
          + value.column()
          + "] is not empty."
      );
    }
    // TODO check this copying with tests
    byte[][] array = Arrays.copyOf(
        this.field.matrix(),
        this.field.matrix().length
    );
    array[value.row()][value.column()] = value.value();
    return new TicTacToeField(
        new SimpleByteMatrix(
            array
        )
    );
  }

  /**
   * Prints game field to provided {@link PrintStream}.
   * @throws IllegalStateException if backing array
   *     has value other than 0 or 1 or 2.
   */
  @Override
  public void printTo(final PrintStream out) {
    // FIXME workaround to hide internal knowledge that field is 3x3
    final int rows = 3;
    final int columns = 3;
    out.println("  1 2 3");
    for (int i = 0; i < rows; i++) {
      out.print(i + 1);
      for (int j = 0; j < columns; j++) {
        out.print(' ');
        if (this.field.matrix()[i][j] == 0) {
          out.print('_');
        } else if (this.field.matrix()[i][j] == 1) {
          out.print('X');
        } else if (this.field.matrix()[i][j] == 2) {
          out.print('O');
        } else {
          throw new IllegalStateException(
              "Invalid value "
                  + this.field.matrix()[i][j]
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
