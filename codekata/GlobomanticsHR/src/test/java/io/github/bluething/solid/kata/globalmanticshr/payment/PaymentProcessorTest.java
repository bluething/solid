package io.github.bluething.solid.kata.globalmanticshr.payment;

import io.github.bluething.solid.kata.globalmanticshr.notification.Notifier;
import io.github.bluething.solid.kata.globalmanticshr.persistence.EmployeeRepository;
import io.github.bluething.solid.kata.globalmanticshr.personel.Employee;
import io.github.bluething.solid.kata.globalmanticshr.personel.FullTimeEmployee;
import io.github.bluething.solid.kata.globalmanticshr.personel.Intern;
import io.github.bluething.solid.kata.globalmanticshr.personel.PartTimeEmployee;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PaymentProcessorTest {
    private EmployeeRepository employeeRepository;
    private Notifier notifier;

    @BeforeAll
    public void beforeAll(){
        // Income of all employees is 1700 $
        List<Employee> testEmployees = Arrays.asList(
                new FullTimeEmployee("Anna Smith",1000),
                new PartTimeEmployee("John Doe",500),
                new Intern("Gabriel Ortega", 200, 10)
        );

        employeeRepository = Mockito.mock(EmployeeRepository.class);
        Mockito.when(employeeRepository.findAll())
                .thenReturn(testEmployees);

        notifier = Mockito.mock(Notifier.class);
    }

    @Test
    public void sendPaymentShouldPayAllEmployeeSalaries() {
        PaymentProcessor paymentProcessor = new PaymentProcessor(employeeRepository, notifier);

        int result = paymentProcessor.sendPayment();

        assertEquals(1700, result);
    }
}