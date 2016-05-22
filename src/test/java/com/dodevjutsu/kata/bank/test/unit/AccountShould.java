package com.dodevjutsu.kata.bank.test.unit;

import com.dodevjutsu.kata.bank.Account;
import com.dodevjutsu.kata.bank.Activities;
import com.dodevjutsu.kata.bank.Console;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

public class AccountShould {

	private Mockery context;
	private Account account;
	private Activities activities;
	private Console console;

	@Before
	public void setUp () {
		context = new Mockery();
		activities = context.mock(Activities.class);
		console = context.mock(Console.class);
		account = new Account(console, activities);
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


}
