package io.github.bluething.solid.kata.globalmanticshr.taxes;

import io.github.bluething.solid.kata.globalmanticshr.personel.Employee;

public class InternTaxCalculator implements TaxCalculator {
    private final int INCOME_TAX_PERCENTAGE = 16;

    @Override
    public double calculate(Employee employee) {
        int monthlyIncome = employee.getMonthlyIncome();
        if (monthlyIncome < 350) {
            return 0;
        } else {
            return (monthlyIncome * INCOME_TAX_PERCENTAGE) / 100;
        }
    }
}
