package com.sansey.tictactoe;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.sansey.tictactoe.values.SimpleIntValueAt;

class SimpleIntValueAtTest {

  @Test
  void testValue() throws Exception {
    final int v = 1;
    IntValueAt value =  new SimpleIntValueAt(v, 2, 3);
    assertEquals(v, value.value());
  }
  
  @Test
  void testRow() throws Exception {
    final int r = 1;
    IntValueAt value =  new SimpleIntValueAt(1, r, 3);
    assertEquals(r, value.row());
  }

  @Test
  void testColumn() throws Exception {
    final int c = 1;
    IntValueAt value =  new SimpleIntValueAt(1, 2, c);
    assertEquals(c, value.column());
  }
}
