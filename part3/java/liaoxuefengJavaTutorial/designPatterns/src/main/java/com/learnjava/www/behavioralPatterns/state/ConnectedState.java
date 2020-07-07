package com.learnjava.www.behavioralPatterns.state;

public class ConnectedState implements State {
    @Override
    public String init() {
        return "Hello, I'm Bob.";
    }

    @Override
    public String reply(String input) {

        if (input.endsWith("?")) {

            return "Yes. " + input.substring(0, input.length() - 1) + "!";

        }

        if (input.endsWith(".")) {

            return input.substring(0, input.length() - 1) + "!";

        }

        return input.substring(0, input.length() - 1) + "?";
    }
}
