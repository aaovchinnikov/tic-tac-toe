package com.sansey.tictactoe;

/**
 * Represents some check without any special meaning
 * that has boolean result.
 * @author Alexander Ovchinnikov
 */
public interface Check {
  /**
   * Result of the check.
   * @return <code>true</code> if check passed, otherwise - <code>false</code>.
   * @throws Exception if check result can't be determined for any reason
   */
  boolean result() throws Exception;
}
