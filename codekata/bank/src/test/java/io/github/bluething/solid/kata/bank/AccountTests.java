package io.github.bluething.solid.kata.bank;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.refEq;
import static org.mockito.Mockito.verify;

public class AccountTests {

    private static final int POSITIVE_AMOUNT = 1000;
    private static final int NEGATIVE_AMOUNT = -POSITIVE_AMOUNT;
    private static final LocalDate TODAY = LocalDate.now();

    @Mock
    private TransactionRepository transactionRepository;
    private Account account;

    @Test
    public void amountWithZeroBalanceDepositWithPositiveValueBalanceAddedWithDepositValue() {
        account.deposit(POSITIVE_AMOUNT);
        verify(transactionRepository).add(refEq(new Transaction(TODAY, POSITIVE_AMOUNT)));
    }

}