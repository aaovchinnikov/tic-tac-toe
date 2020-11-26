package com.sansey.tictactoe.outputs;

import java.io.PrintStream;

import com.sansey.tictactoe.Output;

public final class StringBuilderPrintedOutput implements Output {
  private final StringBuilder builder;
  private final PrintStream stream;
  
  
  public StringBuilderPrintedOutput(StringBuilder builder, PrintStream stream) {
    this.builder = builder;
    this.stream = stream;
  }

  @Override
  public Output withBody(String body) {
    this.builder.append(body);
    return this;
  }

  @Override
  public void flush() {
    this.stream.print(this.builder.toString());
  }
}
