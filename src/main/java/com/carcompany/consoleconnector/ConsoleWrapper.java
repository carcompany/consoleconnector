package com.carcompany.consoleconnector;

import java.util.Scanner;

public class ConsoleWrapper {

    private static ConsoleWrapper consoleWrapper;

    private Scanner console;

    public ConsoleWrapper() {

        this.console = new Scanner(System.in);

    }

    public static ConsoleWrapper getInstance() {
        if (consoleWrapper == null)
            consoleWrapper = new ConsoleWrapper();
        return consoleWrapper;
    }

    public String getInput() {
        System.out.print("Slotos@CarCompany 🚙 % ");
        return console.nextLine();
    }

    public String ask4Input(String question) {

        System.out.println(question);
        return this.getInput();

    }

}
