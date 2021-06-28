package io.github.bluething.solid.kata.bank;

import java.util.List;

public interface TransactionRepository {
    void add(Transaction transaction);
    List<Transaction> getAllTransaction();
}
