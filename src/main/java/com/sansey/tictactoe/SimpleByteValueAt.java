package com.sansey.tictactoe;

/**
 * In-memory structure.
 * @author Alexander Ovchinnikov
 */
public final class SimpleByteValueAt implements ByteValueAt {
  /**
   * Byte value for {@link #value()} stored in memory.
   */
  private final byte value;

  /**
   * Row of decorated {@link #value} stored in memory.
   */
  private final int row;

  /**
   * Column of decorated {@link #value} stored in memory.
   */
  private final int column;

  /**
   * Main constructor.
   * @param v - value
   * @param r - row
   * @param c - column
   */
  public SimpleByteValueAt(final byte v, final int r, final int c) {
    this.value = v;
    this.row = r;
    this.column = c;
  }

  @Override
  public byte value() throws Exception {
    return this.value;
  }

  @Override
  public int row() throws Exception {
    return this.row;
  }

  @Override
  public int column() throws Exception {
    return this.column;
  }
}
