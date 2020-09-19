package com.sansey.tictactoe;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class ValidatedTicTacToeArrayTest {

  @Test
  void testValidArray() throws Exception {
    final byte[][] array = new byte[3][3];
    assertEquals(array, new ValidatedTicTacToeArray(array).matrix());
  }
  
  @Test
  void testWrongRowsCountArray() {
    Exception e = assertThrows(Exception.class, new Executable() {
      @Override
      public void execute() throws Throwable {
        final byte[][] array = new byte[0][3];
        new ValidatedTicTacToeArray(array).matrix();
      }
    });
    assertEquals("Provided array should be 3x3 in size, but instead has rows: 0", e.getMessage());
  }
  
  @Test
  void wrongColumnsCountArray() {
    Exception e = assertThrows(Exception.class, new Executable() {
      @Override
      public void execute() throws Throwable {
        final byte[][] array = new byte[3][0];
        new ValidatedTicTacToeArray(array).matrix();
      }
    });
    assertEquals("Provided array should be 3x3 in size, but instead has columns: 0", e.getMessage());
  }
  
  @Test
  void wrongValuesArray() {
    Exception e = assertThrows(Exception.class, new Executable() {
      @Override
      public void execute() throws Throwable {
        final byte[][] array = new byte[3][3];
        array[0][0] = -1;
        new ValidatedTicTacToeArray(array).matrix();
      }
    });
    assertEquals("Invalid value -1 in provided array at element with index [0][0]. Should be 0 or 1 or 2.", e.getMessage());
  }
  
}
