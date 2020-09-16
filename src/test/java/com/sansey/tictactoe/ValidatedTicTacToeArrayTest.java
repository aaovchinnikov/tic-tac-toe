package com.sansey.tictactoe;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class ValidatedTicTacToeArrayTest {

  @Test
  void testValidArray() {
    final byte[][] array = new byte[3][3];
    assertEquals(array, new ValidatedTicTacToeArray(array).matrix());
  }
  
  @Test
  void testWrongRowsCountArray() {
    assertThrows(IllegalArgumentException.class, new Executable() {
      @Override
      public void execute() throws Throwable {
        final byte[][] array = new byte[0][3];
        new ValidatedTicTacToeArray(array).matrix();
      }
    });
  }
  
  @Test
  void testWrongColumnsCountArray() {
    assertThrows(IllegalArgumentException.class, new Executable() {
      @Override
      public void execute() throws Throwable {
        final byte[][] array = new byte[3][0];
        new ValidatedTicTacToeArray(array).matrix();
      }
    });
  }
  
  @Test
  void testWrongValuesArray() {
    assertThrows(IllegalArgumentException.class, new Executable() {
      @Override
      public void execute() throws Throwable {
        final byte[][] array = new byte[3][3];
        array[0][0] = -1;
        new ValidatedTicTacToeArray(array).matrix();
      }
    });
  }
  
}
