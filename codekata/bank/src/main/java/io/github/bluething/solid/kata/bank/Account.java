package io.github.bluething.solid.kata.bank;

import java.time.LocalDate;

public class Account {
    private TransactionRepository transactionRepository;

    public Account (TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public void deposit(int amount) {
        transactionRepository.add(new Transaction(LocalDate.now(), amount));
    }
}
