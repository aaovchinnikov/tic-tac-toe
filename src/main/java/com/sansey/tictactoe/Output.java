package com.sansey.tictactoe;

/**
 * Strategy pattern for outputting.
 * @author Alexander Ovchinnikov
 */
public interface Output {
  /**
   * Adds the provided <code>body</code> to content that should be outputted.
   * @param bdy - string body to be added to {@link Output}
   * @return the {@link Output} with <code>body</code>
   *     added to current content for outputting
   * @implNote Signature allows immutable implementations and chained calls.
   */
  Output withBody(String bdy);

  /**
   * Outputs current content of the {@link Output}.
   */
  void flush();
}
