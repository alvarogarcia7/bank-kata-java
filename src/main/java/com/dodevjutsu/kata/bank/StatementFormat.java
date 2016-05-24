package com.dodevjutsu.kata.bank;

public class StatementFormat implements Format {

    public static final String DECIMALS = ".00";

    @Override
    public String format (final Line line) {
        return String.format("%s || %s || %s", format(line.date()), format(line.amount()), format(line.balance()));
    }

    private String format (final Amount amount) {
        final String debit;
        final int value = amount.value();
        String credit;
        // TODO - dispatching based on type via sign in amount
        if (value >= 0) {
            credit = String.valueOf(value) + DECIMALS;
            debit = "";
            return String.format("%s ||%s", credit, debit);
        } else {
            debit = String.valueOf(-value) + DECIMALS;
            credit = "";
            return String.format("%s|| %s", credit, debit);
        }
    }

    private String format (final Date date) {
        return date.formatted();
    }

    private String format (final Balance balance) {
        return String.valueOf(balance.value() + DECIMALS);
    }
}
