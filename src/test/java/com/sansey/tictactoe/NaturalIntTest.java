package com.sansey.tictactoe;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.function.Executable;

import com.sansey.tictactoe.ints.NaturalInt;

class NaturalIntTest {

  @Test
  void correctNatural() throws Exception {
    NaturalInt i = new NaturalInt(5);
    assertEquals(5, i.value());
  }

  @Test
  void zoreNotNatural() throws Exception {
    final int zero = 0;
    Exception e = assertThrows(Exception.class, new Executable() {
      @Override
      public void execute() throws Throwable {
        NaturalInt i = new NaturalInt(zero);
        assertEquals(zero, i.value());
      }
    });
    assertEquals("Provided integer " + zero + " is not natural.", e.getMessage());
  }
  
  @Test
  void negativeNotNatural() throws Exception {
    final int negative = -1;
    Exception e = assertThrows(Exception.class, new Executable() {
      @Override
      public void execute() throws Throwable {
        NaturalInt i = new NaturalInt(-1);
        assertEquals(-1, i.value());
      }
    });
    assertEquals("Provided integer " + negative + " is not natural.", e.getMessage());
  }
}
