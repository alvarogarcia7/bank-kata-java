package com.dodevjutsu.kata.bank.test.unit;

import com.dodevjutsu.kata.bank.Console;
import com.dodevjutsu.kata.bank.ConsoleLinePrinter;
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

}
