package com.dodevjutsu.kata.bank.test.unit;

import com.dodevjutsu.kata.bank.Amount;
import com.dodevjutsu.kata.bank.Balance;
import com.dodevjutsu.kata.bank.Console;
import com.dodevjutsu.kata.bank.ConsoleLinePrinter;
import com.dodevjutsu.kata.bank.Date;
import com.dodevjutsu.kata.bank.Line;
import com.dodevjutsu.kata.bank.LinePrinter;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

public class ConsoleLinePrinterShould {

    private Mockery context;
    private LinePrinter linePrinter;
    private Console console;

    @Before
    public void setUp () {
        context = new Mockery();
        console = context.mock(Console.class);
        linePrinter = new ConsoleLinePrinter(console);
    }

    @Test
    public void print_the_header () {
        context.checking(new Expectations() {{
            oneOf(console).print("date || credit || debit || balance");
        }});

        linePrinter.printHeader();

        context.assertIsSatisfied();
    }

    @Test
    public void print_the_a_line() {
        context.checking(new Expectations() {{
            oneOf(console).print("01/04/2000 || || 23.00 || 33.00");
        }});

        linePrinter.print(new Line(new Date("01/04/2000"), new Amount(23), new Balance(33)));

        context.assertIsSatisfied();
    }

}
