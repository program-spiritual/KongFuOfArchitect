package com.learnjava.www.behavioralPatterns.state;

public interface State {
  public String init();

  public String reply(String input);
}
