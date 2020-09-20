package com.sansey.tictactoe.checks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import com.sansey.tictactoe.matrices.EqualSizedMatrix;
import com.sansey.tictactoe.matrices.SimpleIntMatrix;


class SecondaryDiagonalHasAllCellsWithValueTest {
  @Test
  void passesCheck() throws Exception {
    final int[][] matrix = new int[][] {
      {1, 2}, 
      {2, 1}
    };
    assertTrue(
        new SecondaryDiagonalHasAllCellsWithValue(
            new SimpleIntMatrix(matrix),
            2
        ).result()
    );
  }
  
  @Test
  void moreRowsThanColumns() throws Exception {
    final int[][] matrix = new int[][] {
      {1, 2}, 
      {2, 1},
      {3, 4}
    };
    assertTrue(
        new SecondaryDiagonalHasAllCellsWithValue(
            new SimpleIntMatrix(matrix),
            2
        ).result()
    );
  }

  @Test
  void failsCheck() throws Exception {
    final int[][] matrix = new int[][] {
      {1, 2}, 
      {1, 2}
    };
    assertFalse(
        new SecondaryDiagonalHasAllCellsWithValue(
            new SimpleIntMatrix(matrix),
            1
        ).result()
    );
  }
  
  @Test
  void exceptionDuringCheck() throws Exception {
    Exception e = assertThrows(Exception.class, new Executable() {
      @Override
      public void execute() throws Throwable {
        final int[][] matrix = new int[][] {
          {2}, 
          {1}
        };
        new SecondaryDiagonalHasAllCellsWithValue(
            new EqualSizedMatrix(
                new SimpleIntMatrix(matrix)
            ),
            1
        ).result();
      }
    });
    assertEquals("Can't determite result of the check for provided matrix", e.getMessage());
  }
}
