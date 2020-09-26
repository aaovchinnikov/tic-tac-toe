package com.sansey.tictactoe.views;

import com.sansey.tictactoe.View;

public final class CrossView implements View<Integer, String> {
  private final int code;
  private final View<Integer, String> next;
  
  /**
   * Main constructor.
   * @param code - integer code for crosses
   * @param origin
   */
  public CrossView(int code, View<Integer, String> next) {
    this.code = code;
    this.next = next;
  }

  @Override
  public String view(Integer model) throws Exception {
    if (code == model.intValue()) {
      return "X";
    }
    return next.view(model);
  }
}
