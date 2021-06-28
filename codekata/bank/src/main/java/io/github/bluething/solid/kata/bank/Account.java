package io.github.bluething.solid.kata.bank;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.stream.Collectors.toCollection;

public class Account {
    private static final String STATEMENT_HEADER = "DATE | AMOUNT | BALANCE";
    private static final String DATE_FORMAT = "dd/MM/yyyy";
    private static final String AMOUNT_FORMAT = "#.00";

    private TransactionRepository transactionRepository;
    private Printer printer;

    public Account (TransactionRepository transactionRepository, Printer printer) {
        this.transactionRepository = transactionRepository;
        this.printer = printer;
    }

    public void deposit(int amount) {
        transactionRepository.add(new Transaction(LocalDate.now(), amount));
    }

    public void withdraw(int amount) {
        transactionRepository.add(new Transaction(LocalDate.now(), -amount));
    }

    public void printStatement() {
        printer.printLine(STATEMENT_HEADER);

        List<Transaction> transactions = transactionRepository.getAllTransaction();
        final AtomicInteger balance = new AtomicInteger(0);
        transactions.stream()
                .map(transaction -> statementLine(transaction, balance.addAndGet(transaction.getAmount())))
                .collect(toCollection(LinkedList::new))
                .descendingIterator()
                .forEachRemaining(this.printer::printLine);
    }
    private String statementLine(Transaction transaction, int balance) {
        return MessageFormat.format("{0} | {1} | {2}", transaction.getDate(), formatNumber(transaction.getAmount()), formatNumber(balance));
    }
    private String formatNumber(int amount) {
        DecimalFormat decimalFormat = new DecimalFormat(AMOUNT_FORMAT, DecimalFormatSymbols.getInstance(Locale.US));
        return decimalFormat.format(amount);
    }
}
