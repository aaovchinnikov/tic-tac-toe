package com.sansey.tictactoe;

/**
 * Validating decorator for ByteValueAt to be suitable for
 * {@link TicTacToeField}.
 * @author Alexander Ovchinnikov
 */
public class TicTacToeValidatedValue implements ByteValueAt {
  private final ByteValueAt origin;
  
  /**
   * Main constructor.
   * @param b - {@link ByteValueAt} to decorate
   */
  public TicTacToeValidatedValue(final ByteValueAt b) {
    this.origin = b;
  }

  @Override
  public byte value() throws Exception {
    if (this.origin.value() != 0
        || this.origin.value() != 1
        || this.origin.value() != 2
    ) {
      throw new Exception("Provided value "
          + this.origin.value()
          + "is not valid. Allowed values are 0 or 1 or 2."
      );
    }
    return this.origin.value();
  }

  @Override
  public int row() throws Exception {
    if (!(0 <= this.origin.row() && this.origin.row() < 3)) {
      throw new Exception("Provided row coordinate "
          + this.origin.row()
          + " is out of 3x3 field"
      );
    }
    return this.origin.row();
  }

  @Override
  public int column() throws Exception {
    if (!(0 <= this.origin.column() && this.origin.column() < 3)) {
      throw new Exception("Provided column coordinate "
          + this.origin.column()
          + " is out of 3x3 field"
      );
    }
    return this.origin.column();
  }
}
