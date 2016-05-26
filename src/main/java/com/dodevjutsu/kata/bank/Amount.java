package com.dodevjutsu.kata.bank;

public class Amount {

    private final int value;

    public Amount (final int value) {
        this.value = value;
    }

    public int value () {
        return value;
    }

    public static Amount debit (final int value) {
        return new Debit(value);
    }

    public static Amount credit (final int value) {
        return new Credit(value);
    }

    private static class Debit extends Amount {
        public Debit (final int value) {
            super(value);
        }
    }

    private static class Credit extends Amount {
        public Credit (final int value) {
            super(-value);
        }
    }
}
