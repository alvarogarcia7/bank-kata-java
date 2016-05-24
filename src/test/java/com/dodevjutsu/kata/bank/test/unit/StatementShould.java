package com.dodevjutsu.kata.bank.test.unit;

import com.dodevjutsu.kata.bank.Amount;
import com.dodevjutsu.kata.bank.Balance;
import com.dodevjutsu.kata.bank.Console;
import com.dodevjutsu.kata.bank.Date;
import com.dodevjutsu.kata.bank.Line;
import com.dodevjutsu.kata.bank.Statement;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

public class StatementShould {

    private Mockery context;
    private Console console;

    @Before
    public void setUp () {
        context = new Mockery();
        console = context.mock(Console.class);
    }

    @Test
    public void print_a_statement_with_a_single_activity () {

        final Statement statement = new Statement(
                new Line(new Date("10/01/2012"), new Amount(1000), new Balance(1000)),
                new Line(new Date("13/01/2012"), new Amount(2000), new Balance(3000)),
                new Line(new Date("14/01/2012"), new Amount(500), new Balance(2500)));

        context.checking(new Expectations() {{
            oneOf(console).print("date || credit || debit || balance");
            oneOf(console).print("14/01/2012 || || 500.00 || 2500.00");
            oneOf(console).print("13/01/2012 || 2000.00 || || 3000.00");
            oneOf(console).print("10/01/2012 || 1000.00 || || 1000.00");
        }});

        statement.printOn(console);

        context.assertIsSatisfied();
    }

}
