package com.sansey.tictactoe;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class TicTacToeFieldTest {
  
  @Test
  void addCrossAtZeroZero() throws Exception {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    new TicTacToeField(
        new SimpleIntMatrix(
            new int[3][3]
        )
    ).withValueAt(
        new SimpleIntValueAt(1, 0, 0)
    ).printTo(
        new PrintStream(baos)
    );
    assertEquals(
        "  0 1 2" + System.lineSeparator()
            + "0 X _ _" + System.lineSeparator()
            + "1 _ _ _" + System.lineSeparator()
            + "2 _ _ _" + System.lineSeparator(),
        baos.toString(StandardCharsets.UTF_8)
    );
  }

  @Test
  void addCrossAtNonEmptyCell() {
    final int row = 0;
    final int column = 0;
    final int[][] array = new int [3][3];
    array[row][column] = 1;
    Exception e = assertThrows(
        Exception.class,
        new Executable() {
          @Override
          public void execute() throws Throwable {
            new TicTacToeField(
                new SimpleIntMatrix(
                    array
                )
            ).withValueAt(
                new SimpleIntValueAt(1, row, column)
            );
          }
        }
    );
    assertEquals(
        "Field at specified coordinates ["
            + row
            + "]["
            + column
            + "] is not empty.",
        e.getMessage()
    );
  }
  
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
        "  0 1 2" + System.lineSeparator()
            + "0 _ _ _" + System.lineSeparator()
            + "1 _ _ _" + System.lineSeparator()
            + "2 _ _ _" + System.lineSeparator(),
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
        "  0 1 2" + System.lineSeparator()
            + "0 X _ _" + System.lineSeparator()
            + "1 _ _ _" + System.lineSeparator()
            + "2 _ _ _" + System.lineSeparator(),
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
        "  0 1 2" + System.lineSeparator()
            + "0 O _ _" + System.lineSeparator()
            + "1 _ _ _" + System.lineSeparator()
            + "2 _ _ _" + System.lineSeparator(),
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
