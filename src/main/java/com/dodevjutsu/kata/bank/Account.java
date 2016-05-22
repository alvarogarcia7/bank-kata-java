package com.dodevjutsu.kata.bank;

public class Account {
	private Activities activities;

	public Account (final Console console) {
	}

	public Account (final Console console, final Activities activities) {
		this.activities = activities;
	}

	public Account (final Console console, final Clock clock) {
	}

	public void printStatement () {

	}

	public void deposit (final int amount) {

	}

	public void withdraw (final int amount) {
		activities.save(-500);
	}
}
