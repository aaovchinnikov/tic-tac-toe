package com.sansey.tictactoe;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class TicTacToeFieldTest {

  @Test
  void printEmptyField() throws Exception {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    new TicTacToeField(
        new SimpleIntMatrix(
            new int[3][3]
        )
    ).printTo(
        new PrintStream(baos)
    );
    assertEquals(
        "  1 2 3" + System.lineSeparator()
            + "1 _ _ _" + System.lineSeparator()
            + "2 _ _ _" + System.lineSeparator()
            + "3 _ _ _" + System.lineSeparator(),
        baos.toString(StandardCharsets.UTF_8)
    );
  }

  @Test
  void printFieldWithX() throws Exception {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    int[][] array = new int[3][3];
    array[0][0] = 1;
    new TicTacToeField(
        new SimpleIntMatrix(array)
    ).printTo(
        new PrintStream(baos)
    );
    assertEquals(
        "  1 2 3" + System.lineSeparator()
            + "1 X _ _" + System.lineSeparator()
            + "2 _ _ _" + System.lineSeparator()
            + "3 _ _ _" + System.lineSeparator(),
        baos.toString(StandardCharsets.UTF_8)
    );
  }
  
  @Test
  void printFieldWithO() throws Exception {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    int[][] array = new int[3][3];
    array[0][0] = 2;
    new TicTacToeField(
        new SimpleIntMatrix(array)
    ).printTo(
        new PrintStream(baos)
    );
    assertEquals(
        "  1 2 3" + System.lineSeparator()
            + "1 O _ _" + System.lineSeparator()
            + "2 _ _ _" + System.lineSeparator()
            + "3 _ _ _" + System.lineSeparator(),
        baos.toString(StandardCharsets.UTF_8)
    );
  }
  
  @Test
  void printFieldWithInvalidValue() {
    assertThrows(Exception.class, new Executable() {
      @Override
      public void execute() throws Throwable {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int[][] array = new int[3][3];
        array[0][0] = 3;
        new TicTacToeField(
            new SimpleIntMatrix(array)
        ).printTo(
            new PrintStream(baos)
        );
      }
    });
  }
}
