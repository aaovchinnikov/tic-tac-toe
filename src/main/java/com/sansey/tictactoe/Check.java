package com.sansey.tictactoe;

/**
 * Represents arbitrary check around {@link IntMatrix} and integer value
 * without any special meaning that has boolean result.
 * May be used for complex checks organized as Chain of responsibility pattern.
 * @author Alexander Ovchinnikov
 */
public interface Check {
  /**
   * Result of the check.
   * @param matrix - {@link IntMatrix} to check
   * @param value - value to check
   * @return <code>true</code> if check passed, otherwise - <code>false</code>.
   * @throws Exception if check result can't be determined for any reason
   */
  boolean result(IntMatrix matrix, int value) throws Exception;
}
