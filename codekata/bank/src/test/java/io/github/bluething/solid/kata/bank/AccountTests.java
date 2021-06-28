package io.github.bluething.solid.kata.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.refEq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AccountTests {

    private static final int POSITIVE_AMOUNT = 1000;
    private static final int NEGATIVE_AMOUNT = -POSITIVE_AMOUNT;
    private static final LocalDate TODAY = LocalDate.now();

    @Mock
    private TransactionRepository transactionRepository;
    private Account account;

    @BeforeEach
    private void setup() {
        account = new Account(transactionRepository);
    }

    @Test
    public void amountWithZeroBalanceDepositWithPositiveValueBalanceAddedWithDepositValue() {
        account.deposit(POSITIVE_AMOUNT);
        verify(transactionRepository).add(refEq(new Transaction(TODAY, POSITIVE_AMOUNT)));
    }

}