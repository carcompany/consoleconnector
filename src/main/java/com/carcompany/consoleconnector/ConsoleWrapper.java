package com.carcompany.consoleconnector;

import java.io.Console;

public class ConsoleWrapper {

    private static ConsoleWrapper consoleWrapper;

    private Console console;

    public ConsoleWrapper() {
        this.console = System.console();
    }

    public static ConsoleWrapper getInstance() {
        if (consoleWrapper == null)
            consoleWrapper = new ConsoleWrapper();
        return consoleWrapper;
    }

    public String ask4Input(String question) {
        System.out.print("\033[0;32m" + question + ": \033[0m");
        return console.readLine();
    }

    public String ask4Password(String question) {
        char[] password = console.readPassword("\033[34m" + question + ": \033[0m");
        return new String(password);
    }

}
