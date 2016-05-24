package com.dodevjutsu.kata.bank;

public class Account {
	private Activities activities;
	private StatementPrinter statementPrinter;

	public Account (final Console console) {
	}

	public Account (final Console console, final Clock clock) {
	}

	public Account (final Activities activities, final StatementPrinter statementPrinter) {
		this.activities = activities;
		this.statementPrinter = statementPrinter;
	}

	public void printStatement () {
		activities.createStatement();
	}

	public void deposit (final int amount) {
		activities.save(amount);

	}

	public void withdraw (final int amount) {
		activities.save(-amount);
	}
}
