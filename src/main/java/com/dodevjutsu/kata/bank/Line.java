package com.dodevjutsu.kata.bank;

public class Line {
    private final Date date;
    private final Amount amount;
    private final Balance balance;

    public Line (final Date date, final Amount amount, final Balance balance) {
        this.date = date;
        this.amount = amount;
        this.balance = balance;
    }

    public String format (final Format format) {
        return format.format(this);
    }

    public Date date () {
        return date;
    }

    public Amount amount () {
        return amount;
    }

    public Balance balance () {
        return balance;
    }
}
