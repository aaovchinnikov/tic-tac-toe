package com.sansey.tictactoe.views;

import com.sansey.tictactoe.View;

public class EmptyCellView implements View<Integer, String>{
  private final int code;
  private final View<Integer, String> next;
  
  /**
   * Main constructor.
   * @param code - integer code for naughts
   * @param origin
   */
  public EmptyCellView(int code, View<Integer, String> next) {
    this.code = code;
    this.next = next;
  }

  @Override
  public String view(Integer model) throws Exception {
    if (code == model.intValue()) {
      return "_";
    }
    return next.view(model);
  }
}
