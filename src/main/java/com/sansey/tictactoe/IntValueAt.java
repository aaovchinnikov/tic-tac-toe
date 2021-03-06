package com.sansey.tictactoe;

/**
 * Represents integer value that is placed at coordinates
 * [{@link #row()}][{@link #column()}].
 * @author Alexander Ovchinnikov
 */
public interface IntValueAt {
  /**
   * Integer value that is at coordinates [{@link #row()}][{@link #column()}].
   * @return value
   * @throws Exception if value can't be returned for any reason
   */
  int value() throws Exception;

  /**
   * Row of decorated {@link #value()}.
   * @return row index
   * @throws Exception if row coordinate can't be returned for any reason
   */
  int row() throws Exception;

  /**
   * Column of decorated {@link #value()}.
   * @return column index
   * @throws Exception if column coordinate can't be returned for any reason
   */
  int column() throws Exception;
}
