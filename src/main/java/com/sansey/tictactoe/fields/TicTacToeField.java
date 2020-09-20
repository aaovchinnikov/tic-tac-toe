package com.sansey.tictactoe.fields;

import com.sansey.tictactoe.Check;
import com.sansey.tictactoe.Field;
import com.sansey.tictactoe.IntMatrix;
import com.sansey.tictactoe.IntValueAt;
import com.sansey.tictactoe.matrices.SimpleIntMatrix;
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
   * X-es are represented by value 1 in array item.
   * O-es are represented by value 2 in array item.
   */
  private final IntMatrix field;

  /**
   * Chained {@link Check} used to check field values for winning.
   */
  private final Check check;

  /**
   * Main constructor.
   * Doesn't validate provided array for size and content correctness.
   * Use {@link ValidatedFieldArray} to validate passed byte array.
   * @param matrix - {@link IntMatrix} that stores the field
   * @param chk - chained rules to check value for winning
   */
  public TicTacToeField(final IntMatrix matrix, final Check chk) {
    this.field = matrix;
    this.check = chk;
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
      throw new Exception(
          "Field at specified coordinates ["
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
        ),
        this.check
    );
  }

  /**
   * Returns true if the game has finished and provided values have won.
   * @param value - the value to check for the winning
   * @return <code>true</code> if the game finished and
   *     provided values have won, otherwise - <code>false</code>
   * @throws Exception if result can't be determined for any reason
   */
  public boolean valueWon(final int value) throws Exception {
    return this.check.result(field, value);
  }

  /**
   * Returns true if field is full of values and
   * have no more empty cells.
   * @return <code>true</code> if field is full of non-zero values and
   *     have no more empty cells, otherwise - <code>false</code>
   * @throws Exception if field can't be checked for any reason
   */
  @Override
  public boolean full() throws Exception {
    for (int i = 0; i < this.field.rows(); i++) {
      for (int j = 0; j < this.field.columns(); j++) {
        if (this.field.matrix()[i][j] == 0) {
          return false;
        }
      }
    }
    return true;
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
      out.println("  0 1 2");
      for (int i = 0; i < rows; i++) {
        out.print(i);
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
