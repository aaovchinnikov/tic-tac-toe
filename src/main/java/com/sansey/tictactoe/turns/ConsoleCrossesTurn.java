package com.sansey.tictactoe.turns;

import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.sansey.tictactoe.Field;
import com.sansey.tictactoe.Turn;
import com.sansey.tictactoe.TurnResult;
import com.sansey.tictactoe.ints.NaturalInt;
import com.sansey.tictactoe.results.ConsoleCrossesTurnResult;
import com.sansey.tictactoe.values.SimpleIntValueAt;
import com.sansey.tictactoe.values.ValidatedFieldValue;

public final class ConsoleCrossesTurn implements Turn {
  /**
   * Initial {@link Field} for the turn.
   */
  private final Field field;

  /**
   * {@link Scanner} to read the input from.
   */
  private final Scanner scanner;

  /**
   * {@link PrintStream} where to print the output.
   */
  private final PrintStream out;
  
  /**
   * Main constructor.
   * @param fld - {@link Field} for the turn
   * @param scnr - {@link Scanner} to read the input from
   * @param stream - {@link PrintStream} where to print the output
   */
  public ConsoleCrossesTurn(final Field fld, Scanner scnr, PrintStream stream) {
    this.field = fld;
    this.scanner = scnr;
    this.out = stream;
  }

  @Override
  public TurnResult result() {
    // FIXME get rid of knowledge of field size.
    final int size = 3;
    while (true) {
      this.out.print("X's turn. Type cell coordinates - row and "
          + "column (e.g.: 0 2) - and press \'Enter\'-key: ");
      try {
        final Scanner input = new Scanner(this.scanner.nextLine());
        final int row = input.nextInt();
        final int column = input.nextInt();
        this.out.println("Row is " + row);
        this.out.println("Columnt is " + column);
        final Field fld = this.field.withValueAt(
            new ValidatedFieldValue(
                new SimpleIntValueAt(1, row, column),
                new NaturalInt(size)
            )
        );
        return new ConsoleCrossesTurnResult(code, fld);
      } catch (InputMismatchException ime) {
        this.out.println("Input is not an integer coordinates.");
      } catch (NoSuchElementException nse) {
        this.out.println(
            "Input should contain two coordinates but only one entered."
        );
      } catch (Exception e) {
        this.out.println(e.getMessage());
      }
    }
  }
}
