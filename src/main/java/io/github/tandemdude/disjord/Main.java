package io.github.tandemdude.disjord;

import io.github.tandemdude.disjord.impl.Bot;

public class Main {
    public static void main(String[] args) {
        Bot bot = new Bot(System.getenv("TOKEN"));
        bot.run();
    }
}
