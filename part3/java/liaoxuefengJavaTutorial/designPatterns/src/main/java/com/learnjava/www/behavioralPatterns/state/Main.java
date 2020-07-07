package com.learnjava.www.behavioralPatterns.state;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BotContext bot = new BotContext();
        for (;;) {
            System.out.print("> ");
            String input = scanner.nextLine();
            String output = bot.chat(input);
            System.out.println(output.isEmpty() ? "(no reply)" : "< " + output);
        }
    }
}
