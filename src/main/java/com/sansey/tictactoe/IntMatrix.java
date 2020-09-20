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

  /**
   * Returms amount of rows in matrix.
   * @return amount of rows in matrix
   * @throws Exception if amount of rows in matrix
   *     can't be returned for any reason
   */
  int rows() throws Exception;

  /**
   * Returms amount of columns in matrix.
   * @return amount of columns in matrix
   * @throws Exception if amount of columns in matrix
   *     can't be returned for any reason
   */
  int columns() throws Exception;
}
