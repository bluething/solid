package io.github.bluething.solid.kata.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.ArgumentMatchers.refEq;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AccountTests {

    private static final int POSITIVE_AMOUNT = 1000;
    private static final int NEGATIVE_AMOUNT = -POSITIVE_AMOUNT;
    private static final LocalDate TODAY = LocalDate.now();
    private static final List<Transaction> transactions = Arrays.asList(
            new Transaction(TODAY, 1000),
            new Transaction(TODAY, -500),
            new Transaction(TODAY, 200)
    );

    @Mock
    private TransactionRepository transactionRepository;
    @Mock
    private Printer printer;
    private Account account;

    @BeforeEach
    private void setup() {
        account = new Account(transactionRepository, printer);
    }

    @Test
    public void accountWithZeroBalanceDepositWithPositiveValueBalanceAddedWithDepositValue() {
        account.deposit(POSITIVE_AMOUNT);
        verify(transactionRepository).add(refEq(new Transaction(TODAY, POSITIVE_AMOUNT)));
    }

    @Test
    public void accountWithZeroBalanceWithdrawBalanceSubtractedWithWithdrawValue() {
        account.withdraw(POSITIVE_AMOUNT);
        verify(transactionRepository).add(refEq(new Transaction(TODAY, NEGATIVE_AMOUNT)));
    }

    @Test
    public void accountPrintAllTransactionShowAllTransactionInOrder() {
        given(transactionRepository.getAllTransaction()).willReturn(transactions);

        account.printStatement();

        InOrder inOrder = inOrder(printer);
        inOrder.verify(printer).printLine("DATE | AMOUNT | BALANCE");
        inOrder.verify(printer).printLine(TODAY + " | 200.00 | 700.00");
        inOrder.verify(printer).printLine(TODAY + " | -500.00 | 500.00");
        inOrder.verify(printer).printLine(TODAY + " | 1000.00 | 1000.00");
    }

}