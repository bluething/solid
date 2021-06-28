package io.github.bluething.solid.kata.bank;

import java.time.LocalDate;

public class Transaction {

    private final LocalDate date;
    private final int amount;

    public Transaction(LocalDate date, int amount) {
        this.date = date;
        this.amount = amount;
    }
}