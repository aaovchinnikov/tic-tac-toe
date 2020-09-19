package com.sansey.tictactoe;

/**
 * Natural integer decorator.
 * Natural numbers set in {1, 2, 3 ...}.
 * @author Alexander Ovchinnikov
 */
public class NaturalInt implements Int {
  /**
   * Decorated integer value.
   */
  private final int value;

  /**
   * Main constructor.
   * @param i - decorated int value
   */
  public NaturalInt(final int i) {
    this.value = i;
  }

  /**
   * Returns natual int value.
   * @return natural int value
   */
  @Override
  public int value() throws Exception {
    if (this.value <= 0) {
      throw new Exception("Provided integer is not natural.");
    }
    return this.value;
  }
}
