package com.sansey.tictactoe;

/**
 * Represents two-dimensional array of bytes.
 * @author Alexander Ovchinnikov
 */
public interface ByteMatrix {
  /**
   * Returns two-dimensional array of bytes.
   * @return two-dimensional array of bytes
   * @throws Exception if matrix can't be returned for any reason
   */
  byte[][] matrix() throws Exception;
}
