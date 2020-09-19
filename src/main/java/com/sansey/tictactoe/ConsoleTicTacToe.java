package com.sansey.tictactoe;

import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Represents console version of Tic-tac-toe game.
 * @author Alexander Ovchinnikov
 */
public final class ConsoleTicTacToe implements Game {
  /**
   * {@link Scanner} to read the input from.
   */
  private final Scanner scanner;

  /**
   * {@link PrintStream} where to print console output.
   */
  private final PrintStream out;
  /**
   * Initial game {@link Field}.
   */
  private final Field field;

  /**
   * Main constructor.
   * @param input - {@link Scanner} to read the input from
   * @param stream - {@link PrintStream} where to print console output
   * @param f - {@link Field} to play on
   */
  public ConsoleTicTacToe(
      final Scanner input,
      final PrintStream stream,
      final Field f
  ) {
    this.scanner = input;
    this.out = stream;
    this.field = f;
  }

  @Override
  public void start() {
    try {
      // FIXME Checkstyle workaround to hide internal knowledge
      // that field is 3x3
      final int size = 3;
      boolean valid = false;
      Field fld = this.field;
      this.out.println("Tic-tac-toe game started!");
      fld.printTo(out);
      while (!valid) {
        this.out.print("X's turn. Type cell coordinates - row and "
            + "column (e.g.: 1 3) - and press \'Enter\'-key: ");
        try {
          final Scanner input = new Scanner(this.scanner.nextLine());
          final int row = input.nextInt();
          final int column = input.nextInt();
          this.out.println("Row is " + row);
          this.out.println("Columnt is " + column);
          fld = fld.withValueAt(
              new ValidatedFieldValue(
                  new SimpleIntValueAt(1, row, column),
                  new NaturalInt(size)
              )
          );
          valid = true;
          fld.printTo(out);
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
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
