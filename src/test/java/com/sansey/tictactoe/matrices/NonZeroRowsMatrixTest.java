package com.sansey.tictactoe.matrices;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class NonZeroRowsMatrixTest {

  @Test
  void validMitrix() throws Exception {
    final int size = 3;
    final int[][] array = new int[size][0];
    assertEquals(
        array,
        new NonZeroRowsMatrix(
            new SimpleIntMatrix(array)
        ).matrix()
    );
  }
  
  @Test
  void zeroRowsMitrix() {
    Exception e = assertThrows(Exception.class, new Executable() {
      @Override
      public void execute() throws Throwable {
        final int[][] array = new int[0][3];
        new NonZeroRowsMatrix(
            new SimpleIntMatrix(array)
        ).matrix();
      }
    });
    assertEquals("Matrix should have at least one row", e.getMessage());
  }

  @Test
  void rowCount() throws Exception {
    final int size = 3;
    final int[][] array = new int[size][0];
    assertEquals(
        size,
        new NonZeroRowsMatrix(
            new SimpleIntMatrix(array)
        ).rows()
    );
  }
  
  @Test
  void invalidRowsCount() throws Exception {
    Exception e = assertThrows(Exception.class, new Executable() {
      @Override
      public void execute() throws Throwable {
        final int[][] array = new int[0][3];
        new NonZeroRowsMatrix(
            new SimpleIntMatrix(array)
        ).rows();
      }
    });
    assertEquals("Matrix should have at least one row", e.getMessage());
  }
  
  @Test
  void columnCount() throws Exception {
    final int size = 3;
    final int[][] array = new int[1][size];
    assertEquals(
        size,
        new NonZeroRowsMatrix(
            new SimpleIntMatrix(array)
        ).columns()
    );
  }
}
