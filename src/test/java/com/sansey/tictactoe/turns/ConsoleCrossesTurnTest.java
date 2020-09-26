package com.sansey.tictactoe.turns;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ConsoleCrossesTurnTest {

  @Test
  void returnNull() {
    assertNull(new ConsoleCrossesTurn().result());
  }
}
