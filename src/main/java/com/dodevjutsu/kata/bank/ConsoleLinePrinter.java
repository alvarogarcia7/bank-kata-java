package com.dodevjutsu.kata.bank;

public class ConsoleLinePrinter implements LinePrinter {
    private final Console console;

    public ConsoleLinePrinter (final Console console) {
        this.console = console;
    }

    @Override
    public void printHeader () {
        console.print("date || credit || debit || balance");
    }

    @Override
    public void print (final Line line) {

    }
}
