package com.sansey.tictactoe;

/**
 * Represents function that transforms entity &lt;M&gt; into
 * its presentation form &lt;V&gt;, also knows as "view".
 * May be used for complex transformations organized as
 * Chain of responsibility pattern.
 * @author Alexander Ovchinnikov
 * @param <M> - model entity class
 * @param <V> - visual representation class
 */
public interface View<M, V> {
  /**
   * Return "view" for provided "model".
   * @param model - entity for which its visual representation needed 
   * @return "view" for provided "model"
   */
  V view(M model) throws Exception;
}
