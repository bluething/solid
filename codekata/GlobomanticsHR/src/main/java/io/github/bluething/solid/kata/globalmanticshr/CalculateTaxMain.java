package io.github.bluething.solid.kata.globalmanticshr;

import io.github.bluething.solid.kata.globalmanticshr.logging.ConsoleLogger;
import io.github.bluething.solid.kata.globalmanticshr.persistence.EmployeeFileSerializer;
import io.github.bluething.solid.kata.globalmanticshr.persistence.EmployeeRepository;
import io.github.bluething.solid.kata.globalmanticshr.personel.Employee;
import io.github.bluething.solid.kata.globalmanticshr.taxes.TaxCalculator;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class CalculateTaxMain {
    public static void main(String[] args) {
        ConsoleLogger logger = new ConsoleLogger();
        EmployeeFileSerializer fileSerializer = new EmployeeFileSerializer();
        EmployeeRepository repository = new EmployeeRepository(fileSerializer);

        List<Employee> employees = repository.findAll();

        Locale locale = new Locale("en", "US");
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(locale);
        TaxCalculator taxCalculator = new TaxCalculator();

        double totalTax = 0.0;
        double tax = 0.0;
        String formattedTax = "";
        for (Employee employee : employees) {
            tax = taxCalculator.calculate(employee);
            formattedTax = currencyFormat.format(tax);
            logger.writeInfo(employee.getFullName() + " taxes = " + formattedTax);

            totalTax += tax;
        }

        logger.writeInfo("Total taxes = " + currencyFormat.format(totalTax));
    }
}
