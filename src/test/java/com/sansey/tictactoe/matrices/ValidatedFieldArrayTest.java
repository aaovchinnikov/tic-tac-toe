package com.sansey.tictactoe.matrices;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import com.sansey.tictactoe.NaturalInt;

class ValidatedFieldArrayTest {

  @Test
  void arrayWithZeros() throws Exception {
    final int[][] array = new int[3][3];
    assertEquals(
        array,
        new ValidatedFieldArray(
            new SimpleIntMatrix(array),
            new NaturalInt(3)
        ).matrix()
    );
  }
  
  @Test
  void arrayWithOnes() throws Exception {
    final int[][] array = new int[3][3];
    for(int i = 0; i < 3; i++) {
      for(int j = 0; j < 3; j++) {
        array[i][j] = 1;
      }
    }
    assertEquals(
        array,
        new ValidatedFieldArray(
            new SimpleIntMatrix(array),
            new NaturalInt(3)
        ).matrix()
    );
  }
  
  @Test
  void arrayWithTwos() throws Exception {
    final int[][] array = new int[3][3];
    for(int i = 0; i < 3; i++) {
      for(int j = 0; j < 3; j++) {
        array[i][j] = 2;
      }
    }
    assertEquals(
        array,
        new ValidatedFieldArray(
            new SimpleIntMatrix(array),
            new NaturalInt(3)
        ).matrix()
    );
  }
  
  @Test
  void wrongRowsCountArray() {
    Exception e = assertThrows(Exception.class, new Executable() {
      @Override
      public void execute() throws Throwable {
        final int[][] array = new int[0][3];
        new ValidatedFieldArray(
            new SimpleIntMatrix(array),
            new NaturalInt(3)
        ).matrix();
      }
    });
    assertEquals("Provided array should be 3x3 in size, but instead has rows: 0", e.getMessage());
  }
  
  @Test
  void wrongColumnsCountArray() {
    Exception e = assertThrows(Exception.class, new Executable() {
      @Override
      public void execute() throws Throwable {
        final int[][] array = new int[3][0];
        new ValidatedFieldArray(
            new SimpleIntMatrix(array),
            new NaturalInt(3)
        ).matrix();
      }
    });
    assertEquals("Provided array should be 3x3 in size, but instead has columns: 0", e.getMessage());
  }
  
  @Test
  void wrongValuesArray() {
    Exception e = assertThrows(Exception.class, new Executable() {
      @Override
      public void execute() throws Throwable {
        final int[][] array = new int[3][3];
        array[0][0] = -1;
        new ValidatedFieldArray(
            new SimpleIntMatrix(array),
            new NaturalInt(3)
        ).matrix();
      }
    });
    assertEquals("Invalid value -1 in provided array at element with index [0][0]. Should be 0 or 1 or 2.", e.getMessage());
  }
  
  @Test
  void validRows() throws Exception {
    final int size = 3;
    final int[][] array = new int[size][size];
    assertEquals(
        size,
        new ValidatedFieldArray(
            new SimpleIntMatrix(array),
            new NaturalInt(3)
        ).rows()
    );
  }
  
  @Test
  void validColumns() throws Exception {
    final int size = 3;
    final int[][] array = new int[size][size];
    assertEquals(
        size,
        new ValidatedFieldArray(
            new SimpleIntMatrix(array),
            new NaturalInt(3)
        ).columns()
    );
  }
}
