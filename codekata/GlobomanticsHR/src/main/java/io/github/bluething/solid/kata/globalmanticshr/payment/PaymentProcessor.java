package io.github.bluething.solid.kata.globalmanticshr.payment;

import io.github.bluething.solid.kata.globalmanticshr.notification.EmailSender;
import io.github.bluething.solid.kata.globalmanticshr.persistence.EmployeeFileRepository;
import io.github.bluething.solid.kata.globalmanticshr.persistence.EmployeeFileSerializer;
import io.github.bluething.solid.kata.globalmanticshr.personel.Employee;

import java.util.List;

public class PaymentProcessor {
    private final EmployeeFileRepository employeeRepository;

    public PaymentProcessor() {
        EmployeeFileSerializer fileSerializer = new EmployeeFileSerializer();
        this.employeeRepository = new EmployeeFileRepository(fileSerializer);
    }

    public int sendPayment() {
        List<Employee> employees = this.employeeRepository.findAll();
        int totalPayment = 0;

        for (Employee employee : employees) {
            totalPayment += employee.getMonthlyIncome();
            EmailSender.notify(employee);
        }

        return totalPayment;
    }

}
