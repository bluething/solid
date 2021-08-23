package io.github.bluething.solid.kata.globalmanticshr;

import io.github.bluething.solid.kata.globalmanticshr.notification.EmailSender;
import io.github.bluething.solid.kata.globalmanticshr.notification.Notifier;
import io.github.bluething.solid.kata.globalmanticshr.payment.PaymentProcessor;
import io.github.bluething.solid.kata.globalmanticshr.persistence.EmployeeFileRepository;
import io.github.bluething.solid.kata.globalmanticshr.persistence.EmployeeFileSerializer;
import io.github.bluething.solid.kata.globalmanticshr.persistence.EmployeeRepository;

public class PayEmployeesMain {
    public static void main(String[] args) {
        EmployeeFileSerializer employeeFileSerializer = new EmployeeFileSerializer();
        EmployeeRepository employeeRepository = new EmployeeFileRepository(employeeFileSerializer);
        Notifier notifier = new EmailSender();
        PaymentProcessor paymentProcessor = new PaymentProcessor(employeeRepository, notifier);

        int totalPayments = paymentProcessor.sendPayment();
        System.out.println("Total payments " + totalPayments);
    }
}
