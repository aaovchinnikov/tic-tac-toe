package com.sansey.tictactoe.checks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import com.sansey.tictactoe.matrices.EqualSizedMatrix;
import com.sansey.tictactoe.matrices.SimpleIntMatrix;

class MainDiagonalHasAllCellsWithValueTest {
  @Test
  void passesCheck() throws Exception {
    assertTrue(
      new MainDiagonalHasAllCellsWithValue(
        new FalseCheck()
      ).result(
        new SimpleIntMatrix(
          new int[][] {
            {1, 2}, 
            {2, 1}
          }
        ),
        1
      )
    );
  }

  @Test
  void moreRowsThanColumns() throws Exception {
    assertTrue(
      new MainDiagonalHasAllCellsWithValue(
        new FalseCheck()
      ).result(
        new SimpleIntMatrix(
          new int[][] {
            {1, 2}, 
            {2, 1},
            {3, 4}
          }
        ),
        1
      )
    );
  }

  @Test
  void failsCheck() throws Exception {
    assertFalse(
      new MainDiagonalHasAllCellsWithValue(
        new FalseCheck()
      ).result(
        new SimpleIntMatrix(
          new int[][] {
            {1, 1}, 
            {1, 2}
          }
        ),
        1
      )
    );
  }
  
  @Test
  void exceptionDuringCheck() throws Exception {
    Exception e = assertThrows(Exception.class, new Executable() {
      @Override
      public void execute() throws Throwable {
        new MainDiagonalHasAllCellsWithValue(
            new FalseCheck()
        ).result(
          new EqualSizedMatrix(
            new SimpleIntMatrix(
              new int[][] {
                {2}, 
                {1}
              }
            )
          ),
          1
        );
      }
    });
    assertEquals("Can't determite result of the check for provided matrix", e.getMessage());
  }
}
