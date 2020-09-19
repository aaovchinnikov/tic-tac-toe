package com.sansey.tictactoe;

/**
 * Validating decorator for ByteValueAt to be suitable for
 * {@link TicTacToeField}.
 * @author Alexander Ovchinnikov
 */
public final class ValidatedFieldValue implements ByteValueAt {
  /**
   * Validated value.
   */
  private final ByteValueAt origin;

  /**
   * Size of field, to be suitable for.
   */
  private final NaturalInt size;

  /**
   * Main constructor.
   * @param b - {@link ByteValueAt} to decorate
   * @param s - size of field
   */
  public ValidatedFieldValue(final ByteValueAt b, final NaturalInt s) {
    this.origin = b;
    this.size = s;
  }

  @Override
  public byte value() throws Exception {
    if (
        this.origin.value() != 0
        && this.origin.value() != 1
        && this.origin.value() != 2
    ) {
      throw new Exception(
          "Provided value "
          + this.origin.value()
          + "is not valid. Allowed values are 0 or 1 or 2."
      );
    }
    return this.origin.value();
  }

  @Override
  public int row() throws Exception {
    if (
        !(
            0 <= this.origin.row()
            && this.origin.row() < this.size.value()
        )
    ) {
      throw new Exception(
          "Provided row coordinate "
          + this.origin.row()
          + " is out of "
          + this.size.value()
          + "x"
          + this.size.value()
          + " field"
      );
    }
    return this.origin.row();
  }

  @Override
  public int column() throws Exception {
    if (
        !(
            0 <= this.origin.column()
            && this.origin.column() < this.size.value()
        )
    ) {
      throw new Exception(
          "Provided column coordinate "
          + this.origin.column()
          + " is out of "
          + this.size.value()
          + "x"
          + this.size.value()
          + " field"
      );
    }
    return this.origin.column();
  }
}
