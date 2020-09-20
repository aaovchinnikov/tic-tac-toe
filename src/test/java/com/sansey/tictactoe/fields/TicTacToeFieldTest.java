package com.sansey.tictactoe.fields;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import com.sansey.tictactoe.checks.AnyColumnHasAllCellsWithValue;
import com.sansey.tictactoe.checks.AnyRowHasAllCellsWithValue;
import com.sansey.tictactoe.checks.FalseCheck;
import com.sansey.tictactoe.checks.MainDiagonalHasAllCellsWithValue;
import com.sansey.tictactoe.checks.SecondaryDiagonalHasAllCellsWithValue;
import com.sansey.tictactoe.matrices.SimpleIntMatrix;
import com.sansey.tictactoe.values.SimpleIntValueAt;

class TicTacToeFieldTest {
  
  @Test
  void addCrossAtZeroZero() throws Exception {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    new TicTacToeField(
        new SimpleIntMatrix(
            new int[3][3]
        ),
        new FalseCheck()
    ).withValueAt(
        new SimpleIntValueAt(1, 0, 0)
    ).printTo(
        new PrintStream(baos)
    );
    assertEquals(
        "  0 1 2" + System.lineSeparator()
            + "0 X _ _" + System.lineSeparator()
            + "1 _ _ _" + System.lineSeparator()
            + "2 _ _ _" + System.lineSeparator(),
        baos.toString(StandardCharsets.UTF_8)
    );
  }

  @Test
  void addCrossAtNonEmptyCell() {
    final int row = 0;
    final int column = 0;
    final int[][] array = new int [3][3];
    array[row][column] = 1;
    Exception e = assertThrows(
        Exception.class,
        new Executable() {
          @Override
          public void execute() throws Throwable {
            new TicTacToeField(
                new SimpleIntMatrix(
                    array
                ),
                new FalseCheck()
            ).withValueAt(
                new SimpleIntValueAt(1, row, column)
            );
          }
        }
    );
    assertEquals(
        "Field at specified coordinates ["
            + row
            + "]["
            + column
            + "] is not empty.",
        e.getMessage()
    );
  }
  
  @Test
  void crossesWonWithRow() throws Exception {
    assertTrue(
      new TicTacToeField(
        new SimpleIntMatrix(
          new int[][] {
            {1, 1, 1},
            {0, 0, 0},
            {0, 0, 0}
          }
        ),
        new AnyRowHasAllCellsWithValue(
          new FalseCheck()
        )
      ).valueWon(1)
    );
  }
  
  @Test
  void crossesWonWithColumn() throws Exception {
    assertTrue(
      new TicTacToeField(
        new SimpleIntMatrix(
          new int[][] {
            {1, 0, 0},
            {1, 0, 0},
            {1, 0, 0}
          }
        ),
        new AnyColumnHasAllCellsWithValue(
          new FalseCheck()
        )
      ).valueWon(1)
    );
  }
  
  @Test
  void crossesWonWithMainDiagonal() throws Exception {
    assertTrue(
      new TicTacToeField(
        new SimpleIntMatrix(
          new int[][] {
            {1, 0, 0},
            {0, 1, 0},
            {0, 0, 1}
          }
        ),
        new MainDiagonalHasAllCellsWithValue(
          new FalseCheck()
        )
      ).valueWon(1)
    );
  }
  
  @Test
  void crossesWonWithSecondaryDiagonal() throws Exception {
    assertTrue(
      new TicTacToeField(
        new SimpleIntMatrix(
          new int[][] {
            {0, 0, 1},
            {0, 1, 0},
            {1, 0, 1}
          }
        ),
        new SecondaryDiagonalHasAllCellsWithValue(
          new FalseCheck()
        )
      ).valueWon(1)
    );
  }
  
  @Test
  void crossesHavNotWon() throws Exception {
    assertFalse(
      new TicTacToeField(
        new SimpleIntMatrix(
          new int[][] {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
          }
        ),
        new AnyRowHasAllCellsWithValue(
          new AnyColumnHasAllCellsWithValue(
            new MainDiagonalHasAllCellsWithValue(
              new SecondaryDiagonalHasAllCellsWithValue(
                new FalseCheck()
              )
            )
          )
        )
      ).valueWon(1)
    );
  }

  @Test
  void fieldFull() throws Exception {
    assertTrue(
      new TicTacToeField(
        new SimpleIntMatrix(
          new int[][] {
            {1, 1},
            {1, 1}
          }
        ),
        new FalseCheck()
      ).full()
    );
  }
  
  @Test
  void fieldNotFull() throws Exception {
    assertFalse(
      new TicTacToeField(
        new SimpleIntMatrix(
          new int[][] {
            {1, 1},
            {1, 0}
          }
        ),
        new FalseCheck()
      ).full()
    );
  }

  @Test
  void printEmptyField() throws Exception {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    new TicTacToeField(
        new SimpleIntMatrix(
            new int[3][3]
        ),
        new FalseCheck()
    ).printTo(
        new PrintStream(baos)
    );
    assertEquals(
        "  0 1 2" + System.lineSeparator()
            + "0 _ _ _" + System.lineSeparator()
            + "1 _ _ _" + System.lineSeparator()
            + "2 _ _ _" + System.lineSeparator(),
        baos.toString(StandardCharsets.UTF_8)
    );
  }

  @Test
  void printFieldWithX() throws Exception {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    int[][] array = new int[3][3];
    array[0][0] = 1;
    new TicTacToeField(
        new SimpleIntMatrix(array),
        new FalseCheck()
    ).printTo(
        new PrintStream(baos)
    );
    assertEquals(
        "  0 1 2" + System.lineSeparator()
            + "0 X _ _" + System.lineSeparator()
            + "1 _ _ _" + System.lineSeparator()
            + "2 _ _ _" + System.lineSeparator(),
        baos.toString(StandardCharsets.UTF_8)
    );
  }
  
  @Test
  void printFieldWithO() throws Exception {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    int[][] array = new int[3][3];
    array[0][0] = 2;
    new TicTacToeField(
        new SimpleIntMatrix(array),
        new FalseCheck()
    ).printTo(
        new PrintStream(baos)
    );
    assertEquals(
        "  0 1 2" + System.lineSeparator()
            + "0 O _ _" + System.lineSeparator()
            + "1 _ _ _" + System.lineSeparator()
            + "2 _ _ _" + System.lineSeparator(),
        baos.toString(StandardCharsets.UTF_8)
    );
  }
  
  @Test
  void printFieldWithInvalidValue() {
    assertThrows(Exception.class, new Executable() {
      @Override
      public void execute() throws Throwable {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int[][] array = new int[3][3];
        array[0][0] = 3;
        new TicTacToeField(
            new SimpleIntMatrix(array),
            new FalseCheck()
        ).printTo(
            new PrintStream(baos)
        );
      }
    });
  }
}
