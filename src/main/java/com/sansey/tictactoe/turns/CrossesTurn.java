package com.sansey.tictactoe.turns;

import com.sansey.tictactoe.Field;
import com.sansey.tictactoe.Turn;
import com.sansey.tictactoe.TurnResult;

public final class CrossesTurn implements Turn{
  /**
   * Initial {@link Field} for the turn.
   */
  private final Field field;
  
  /**
   * Main constructor.
   * @param fld - {@link Field} for the turn
   */
  public CrossesTurn(Field fld) {
    this.field = fld;
  }

  @Override
  public TurnResult result() {
    // TODO Auto-generated method stub
    /*
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
     * 
     * 
     */
    return null;
  }

}
