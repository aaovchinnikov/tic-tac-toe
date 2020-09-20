package com.sansey.tictactoe;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import com.sansey.tictactoe.ints.NaturalInt;
import com.sansey.tictactoe.values.SimpleIntValueAt;
import com.sansey.tictactoe.values.ValidatedFieldValue;

class ValidatedFieldValueTest {

  @Test
  void valueOfZero() throws Exception {
    final int v = 0;
    assertEquals(
        v,
        new ValidatedFieldValue(
            new SimpleIntValueAt(v, 0, 0),
            new NaturalInt(1)
        ).value()
    );
  }

  @Test
  void valueOfOne() throws Exception {
    final int v = 1;
    assertEquals(
        v,
        new ValidatedFieldValue(
            new SimpleIntValueAt(v, 0, 0),
            new NaturalInt(1)
        ).value()
    );
  }
  
  @Test
  void valueOfTwo() throws Exception {
    final int v = 2;
    assertEquals(
        v,
        new ValidatedFieldValue(
            new SimpleIntValueAt(v, 0, 0),
            new NaturalInt(1)
        ).value()
    );
  }

  @Test
  void invalidValue() {
    final int v = 3;
    Exception e = assertThrows(Exception.class, new Executable() {
      @Override
      public void execute() throws Throwable {
        new ValidatedFieldValue(
            new SimpleIntValueAt(v, 0, 0),
            new NaturalInt(1)
        ).value();
      }
    });
    assertEquals(
        "Provided value "
            + v
            + "is not valid. Allowed values are 0 or 1 or 2.",
        e.getMessage()
    );
  }
  
  @Test
  void validRowIndex() throws Exception {
    final int row = 1;
    assertEquals(
        row,
        new ValidatedFieldValue(
            new SimpleIntValueAt(0, row, 0),
            new NaturalInt(2)
        ).row()
    );
  }
  
  @Test
  void negativeRowIndex() {
    final int row = -1;
    Exception e = assertThrows(Exception.class, new Executable() {
      @Override
      public void execute() throws Throwable {
        new ValidatedFieldValue(
            new SimpleIntValueAt(0, row, 0),
            new NaturalInt(1)
        ).row();
      }
    });
    assertEquals(
        "Provided row coordinate "
            + row
            + " is negative. Only natural values are allowed.",
        e.getMessage()
    );
  }
  
  @Test
  void rowIndexMoreThanSize() {
    final int row = 1;
    final int size = 1;
    Exception e = assertThrows(Exception.class, new Executable() {
      @Override
      public void execute() throws Throwable {
        new ValidatedFieldValue(
            new SimpleIntValueAt(0, row, 0),
            new NaturalInt(size)
        ).row();
      }
    });
    assertEquals(
        "Provided row coordinate "
            + row
            + " is out of "
            + size
            + "x"
            + size
            + " field",
        e.getMessage()
    );
  }
  
  @Test
  void validColumnIndex() throws Exception {
    final int column = 1;
    assertEquals(
        column,
        new ValidatedFieldValue(
            new SimpleIntValueAt(0, 0, column),
            new NaturalInt(2)
        ).column()
    );
  }
  
  @Test
  void negativeColumnIndex() {
    final int column = -1;
    Exception e = assertThrows(Exception.class, new Executable() {
      @Override
      public void execute() throws Throwable {
        new ValidatedFieldValue(
            new SimpleIntValueAt(0, 0, column),
            new NaturalInt(1)
        ).column();
      }
    });
    assertEquals(
        "Provided column coordinate "
            + column
            + " is negative. Only natural values are allowed.",
        e.getMessage()
    );
  }
  
  @Test
  void columnIndexMoreThanSize() {
    final int column = 1;
    final int size = 1;
    Exception e = assertThrows(Exception.class, new Executable() {
      @Override
      public void execute() throws Throwable {
        new ValidatedFieldValue(
            new SimpleIntValueAt(0, 0, column),
            new NaturalInt(size)
        ).column();
      }
    });
    assertEquals(
        "Provided column coordinate "
            + column
            + " is out of "
            + size
            + "x"
            + size
            + " field",
        e.getMessage()
    );
  }
}
