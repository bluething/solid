package io.github.bluething.solid.kata.bank;

public interface TransactionRepository {
    public void add(Transaction transaction);
    public List<Transaction> getAllTransaction();
}
