package com.dodevjutsu.kata.bank.test.unit;

import com.dodevjutsu.kata.bank.Amount;
import com.dodevjutsu.kata.bank.Balance;
import com.dodevjutsu.kata.bank.Date;
import com.dodevjutsu.kata.bank.Line;
import com.dodevjutsu.kata.bank.LinePrinter;
import com.dodevjutsu.kata.bank.Statement;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

public class StatementShould {

    private Mockery context;
    private LinePrinter linePrinter;

    @Before
    public void setUp () {
        context = new Mockery();
        linePrinter = context.mock(LinePrinter.class);
    }

    @Test
    public void print_a_statement_with_a_single_activity () {

        Line line1 = new Line(new Date("10/01/2012"), new Amount(1000), new Balance(1000));
        Line line2 = new Line(new Date("13/01/2012"), new Amount(2000), new Balance(3000));
        Line line3 = new Line(new Date("14/01/2012"), new Amount(-500), new Balance(2500));
        final Statement statement = new Statement(line1, line2, line3);

        context.checking(new Expectations() {{
            oneOf(linePrinter).printHeader();
            oneOf(linePrinter).print(line1);
            oneOf(linePrinter).print(line2);
            oneOf(linePrinter).print(line3);
        }});

        statement.printOn(linePrinter);

        context.assertIsSatisfied();
    }

}
