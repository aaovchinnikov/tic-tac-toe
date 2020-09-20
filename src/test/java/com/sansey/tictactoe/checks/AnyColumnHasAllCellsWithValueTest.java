package com.sansey.tictactoe.checks;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import com.sansey.tictactoe.matrices.EqualSizedMatrix;
import com.sansey.tictactoe.matrices.SimpleIntMatrix;

class AnyColumnHasAllCellsWithValueTest {
  @Test
  void passesCheck() throws Exception {
    assertTrue(
      new AnyColumnHasAllCellsWithValue(
        new FalseCheck()
      ).result(
        new SimpleIntMatrix(
          new int[][] {
            {2, 1}, 
            {1, 1}
          }
        ),
        1
      )
    );
  }

  @Test
  void failsCheck() throws Exception {
    assertFalse(
      new AnyColumnHasAllCellsWithValue(
        new FalseCheck()
      ).result(
        new SimpleIntMatrix(
          new int[][] {
            {2, 1}, 
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
        new AnyColumnHasAllCellsWithValue(
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
