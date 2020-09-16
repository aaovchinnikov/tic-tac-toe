package com.sansey.tictactoe;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.Test;

class TicTacToeFieldTest {

  @Test
  void testPrintTo() {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    new TicTacToeField().printTo(
        new PrintStream(baos)
    );
    assertEquals(
        "Field" + System.lineSeparator(),
        baos.toString(StandardCharsets.UTF_8)
    );
  }

}
