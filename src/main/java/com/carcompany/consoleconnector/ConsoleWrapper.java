package com.carcompany.consoleconnector;

import java.io.Console;
import java.util.Arrays;
import java.util.Scanner;

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

    public String getInput() {
        System.out.print("Slotos@CarCompany 🚙 % ");
        return console.readLine();
    }

    public String ask4Input(String question) {
        System.out.print(question + ": ");
        return console.readLine();
    }

    public String ask4Password(String question) {
        char[] password = console.readPassword(question + ": ");
        return new String(password);
    }

}
