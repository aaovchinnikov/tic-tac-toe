package com.sansey.tictactoe.turns;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ConsoleNaughtsTurnTest {

  @Test
  void test() {
    assertNull(new ConsoleNaughtsTurn().result());
  }
}
