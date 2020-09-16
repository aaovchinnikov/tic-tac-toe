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
      new PrintStream(baos),
      new Field() {
        @Override
        public void printTo(PrintStream out) {
          out.println("Field");
        }
      }
    ).start();
    assertEquals(
        "Tic-tac-toe game started!" + System.lineSeparator() + "Field" + System.lineSeparator(),
        baos.toString(StandardCharsets.UTF_8)
    );
  }
}
