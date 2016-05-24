package com.dodevjutsu.kata.bank;

public class Statement {
    private final Line[] lines;
    private Format format = new StatementFormat();

    public Statement (final Line... lines) {
        this.lines = lines;
    }

    public void printOn (final Console console) {
        console.print("date || credit || debit || balance");
        for (int i = lines.length - 1; i >= 0; i--) {
            console.print(format(lines[i]));
        }
    }

    private String format (Line line) {
        return line.format(format);
    }
}
