package com.sansey.tictactoe;

/**
 * Represents two-dimensional array of integers.
 * @author Alexander Ovchinnikov
 */
public interface IntMatrix {
  /**
   * Returns two-dimensional array of integers.
   * @return two-dimensional array of integers
   * @throws Exception if matrix can't be returned for any reason
   */
  int[][] matrix() throws Exception;
}
