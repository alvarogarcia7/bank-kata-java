package com.dodevjutsu.kata.bank.test.unit;

import com.dodevjutsu.kata.bank.Account;
import com.dodevjutsu.kata.bank.Activities;
import com.dodevjutsu.kata.bank.Statement;
import com.dodevjutsu.kata.bank.StatementPrinter;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

public class AccountShould {

	private StatementPrinter statementPrinter;
	private Mockery context;
	private Account account;
	private Activities activities;

	@Before
	public void setUp () {
		context = new Mockery();
		activities = context.mock(Activities.class);
		statementPrinter = context.mock(StatementPrinter.class);
		account = new Account(activities, statementPrinter);
	}

	@Test
	public void withdraw () {

		context.checking(new Expectations() {{
			oneOf(activities).save(-500);
		}});

		account.withdraw(500);

		context.assertIsSatisfied();
	}


	@Test
	public void deposit () {

		context.checking(new Expectations() {{
			oneOf(activities).save(500);
		}});

		account.deposit(500);

		context.assertIsSatisfied();
	}

	@Test
	public void print_statement_with_a_single_transaction () {

		Statement ANY_STATEMENT = new Statement();

		context.checking(new Expectations() {{
			oneOf(activities).createStatement(); will(returnValue(ANY_STATEMENT));
			oneOf(statementPrinter).print(ANY_STATEMENT);
		}});

		account.printStatement();

		context.assertIsSatisfied();
	}


}
