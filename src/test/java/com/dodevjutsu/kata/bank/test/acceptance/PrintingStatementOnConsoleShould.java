package com.dodevjutsu.kata.bank.test.acceptance;

import com.dodevjutsu.kata.bank.Account;
import com.dodevjutsu.kata.bank.Console;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

public class PrintingStatementOnConsoleShould {

	private Mockery context;

	@Before
	public void setUp () {
		context = new Mockery();
	}

	@Test
	public void deposit_and_withdrawal () {

		final Console console = context.mock(Console.class);
		context.checking(new Expectations() {{
			oneOf(console).print("date || credit || debit || balance");
			oneOf(console).print("14/01/2012 || || 500.00 || 2500.00");
			oneOf(console).print("13/01/2012 || 2000.00 || || 3000.00");
			oneOf(console).print("10/01/2012 || 1000.00 || || 1000.00");
		}});

		final Account account = new Account(console);
		account.deposit(1000, "10-01-2012");
		account.deposit(2000, "13-01-2012");
		account.withdrawal(500, "14-01-2012");

		account.printStatement();

		context.assertIsSatisfied();
	}
}
