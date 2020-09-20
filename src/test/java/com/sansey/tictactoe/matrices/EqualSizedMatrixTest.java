package com.sansey.tictactoe.matrices;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class EqualSizedMatrixTest {

  @Test
  void zeroSizeMitrix() {
    Exception e = assertThrows(ArrayIndexOutOfBoundsException.class, new Executable() {
      @Override
      public void execute() throws Throwable {
        final int size = 0;
        final int[][] array = new int[size][size];
        assertEquals(
            array,
            new EqualSizedMatrix(
                new SimpleIntMatrix(array)
            ).matrix()
        );
      }
    });
    assertEquals("Index 0 out of bounds for length 0", e.getMessage());
  }

  @Test
  void validMitrix() throws Exception {
    final int size = 1;
    final int[][] array = new int[size][size];
    assertEquals(
        array,
        new EqualSizedMatrix(
            new SimpleIntMatrix(array)
        ).matrix()
    );
  }
  
  @Test
  void unequalSizedMitrix() {
    Exception e = assertThrows(Exception.class, new Executable() {
      @Override
      public void execute() throws Throwable {
        final int rows = 1;
        final int columns = 2;
        final int[][] array = new int[rows][columns];
        assertEquals(
            array,
            new EqualSizedMatrix(
                new SimpleIntMatrix(array)
            ).matrix()
        );
      }
    });
    assertEquals("Matrix should have dimensions of equal sizes", e.getMessage());
  }
  
  @Test
  void rowCount() throws Exception {
    final int size = 3;
    final int[][] array = new int[size][size];
    assertEquals(
        size,
        new EqualSizedMatrix(
            new SimpleIntMatrix(array)
        ).rows()
    );
  }
  
  @Test
  void columnCount() throws Exception {
    final int size = 3;
    final int[][] array = new int[size][size];
    assertEquals(
        size,
        new EqualSizedMatrix(
            new SimpleIntMatrix(array)
        ).columns()
    );
  }
}
