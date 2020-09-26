package com.sansey.tictactoe.views;

import com.sansey.tictactoe.View;

/**
 * View that always throws {@link Exception} with message
 * "Visual representation of value <code>model</code> is unknown." if reached.
 * May be used as terminal {@link View} in chain.
 * @author Alexander Ovchinnikov
 */
public class UnknownView implements View<Integer, String>{

  @Override
  public String view(Integer model) throws Exception {
    throw new Exception("Visual representation of value " + model + " is unknown.");
  }
}
