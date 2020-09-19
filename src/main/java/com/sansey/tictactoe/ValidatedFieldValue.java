package com.sansey.tictactoe;

/**
 * Validating decorator for IntValueAt to be suitable for
 * {@link TicTacToeField}.
 * @author Alexander Ovchinnikov
 */
public final class ValidatedFieldValue implements IntValueAt {
  /**
   * Validated value.
   */
  private final IntValueAt origin;

  /**
   * Size of field, to be suitable for.
   */
  private final NaturalInt size;

  /**
   * Main constructor.
   * @param i - {@link IntValueAt} to decorate
   * @param s - size of field
   */
  public ValidatedFieldValue(final IntValueAt i, final NaturalInt s) {
    this.origin = i;
    this.size = s;
  }

  @Override
  public int value() throws Exception {
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
    if (this.origin.row() < 0) {
      throw new Exception(
          "Provided row coordinate "
              + this.origin.row()
              + " is negative. Only natural values are allowed."
      );
    }
    if (this.origin.row() >= this.size.value()) {
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
    if (this.origin.column() < 0) {
      throw new Exception(
          "Provided column coordinate "
              + this.origin.column()
              + " is negative. Only natural values are allowed."
      );
    }
    if (this.origin.column() >= this.size.value()) {
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
