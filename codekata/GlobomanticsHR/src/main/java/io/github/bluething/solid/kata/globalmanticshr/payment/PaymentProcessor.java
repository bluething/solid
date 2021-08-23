package io.github.bluething.solid.kata.globalmanticshr.payment;

import io.github.bluething.solid.kata.globalmanticshr.notification.Notifier;
import io.github.bluething.solid.kata.globalmanticshr.persistence.EmployeeRepository;
import io.github.bluething.solid.kata.globalmanticshr.personel.Employee;

import java.util.List;

public class PaymentProcessor {
    private final EmployeeRepository employeeRepository;
    private final Notifier notifier;

    public PaymentProcessor(EmployeeRepository employeeRepository, Notifier notifier) {
        this.employeeRepository = employeeRepository;
        this.notifier = notifier;
    }

    public int sendPayment() {
        List<Employee> employees = this.employeeRepository.findAll();
        int totalPayment = 0;

        for (Employee employee : employees) {
            totalPayment += employee.getMonthlyIncome();
            notifier.notify(employee);
        }

        return totalPayment;
    }

}
