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
  private final IntMatrix field;

  /**
   * Main constructor.
   * Doesn't validate provided array for size and content correctness.
   * Use {@link ValidatedTicTacToeArray} to validate passed byte array.
   * @param matrix - byte array that stores the field
   */
  public TicTacToeField(final IntMatrix matrix) {
    this.field = matrix;
  }

  /**
   * Returns new TicTacToeField with cell at provided coordinates
   * set to provided value. Doesn't modify original TicTacToeField.
   * @param value - {@link IntValueAt} for cell
   * @return new TicTacToeField with cell set to provided value
   * @throws Exception if specified cell is not empty
   */
  public Field withValueAt(final IntValueAt value) throws Exception {
    if (field.matrix()[value.row()][value.column()] != 0) {
      throw new Exception("Field at specified coordinates ["
          + value.row()
          + "]["
          + value.column()
          + "] is not empty."
      );
    }
    int[][] array = Arrays.copyOf(
        this.field.matrix(),
        this.field.matrix().length
    );
    for (int i = 0; i < array.length; i++) {
      array[i] = Arrays.copyOf(
          this.field.matrix()[i],
          this.field.matrix()[i].length
      );
    }
    array[value.row()][value.column()] = value.value();
    return new TicTacToeField(
        new SimpleIntMatrix(
            array
        )
    );
  }

  /**
   * Prints game field to provided {@link PrintStream}.
   * @throws Exception if backing array is invalid
   */
  @Override
  public void printTo(final PrintStream out) throws Exception {
    // FIXME Checkstyle workaround to hide internal knowledge that field is 3x3
    try {
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
            throw new Exception(
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
    } catch (Exception e) {
      throw new Exception(
          "Can't print invalid Tic-tac-toe field",
          e
      );
    }
  }
}
