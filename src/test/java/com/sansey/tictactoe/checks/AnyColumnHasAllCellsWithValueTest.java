package com.sansey.tictactoe.checks;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import com.sansey.tictactoe.matrices.EqualSizedMatrix;
import com.sansey.tictactoe.matrices.SimpleIntMatrix;

class AnyColumnHasAllCellsWithValueTest {
  @Test
  void passesCheck() throws Exception {
    final int[][] matrix = new int[][] {
      {2, 1}, 
      {1, 1}
    };
    assertTrue(
        new AnyColumnHasAllCellsWithValue(
            new SimpleIntMatrix(matrix),
            1
        ).result()
    );
  }

  @Test
  void failsCheck() throws Exception {
    final int[][] matrix = new int[][] {
      {2, 1}, 
      {1, 2}
    };
    assertFalse(
        new AnyColumnHasAllCellsWithValue(
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
        new AnyColumnHasAllCellsWithValue(
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
