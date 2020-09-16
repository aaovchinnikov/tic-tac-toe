package com.sansey.tictactoe;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.Test;

class ConsoleTicTacToeTest {

  @Test
  void testStart() {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    new ConsoleTicTacToe(
      new PrintStream(baos)
    ).start();
    assertEquals(
        "Tic-tac-toe game started!" + System.lineSeparator(),
        baos.toString(StandardCharsets.UTF_8)
    );
  }
}
