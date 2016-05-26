package com.dodevjutsu.kata.bank;

public class Statement {
    private final Line[] lines;
    private Format format = new StatementFormat();

    public Statement (final Line... lines) {
        this.lines = lines;
    }

    public void printOn (final LinePrinter linePrinter) {
        linePrinter.printHeader();
        for (int i = lines.length - 1; i >= 0; i--) {
            linePrinter.print(lines[i]);
        }
    }

    private String format (Line line) {
        return line.format(format);
    }
}
