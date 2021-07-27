package io.github.bluething.solid.kata.globalmanticshr.taxes;

import io.github.bluething.solid.kata.globalmanticshr.personel.Employee;
import io.github.bluething.solid.kata.globalmanticshr.personel.FullTimeEmployee;
import io.github.bluething.solid.kata.globalmanticshr.personel.Intern;
import io.github.bluething.solid.kata.globalmanticshr.personel.PartTimeEmployee;

public class TaxCalculator {
    private final int RETIREMENT_TAX_PERCENTAGE = 10;
    private final int INCOME_TAX_PERCENTAGE = 16;
    private final int BASE_HEALTH_INSURANCE = 100;

    public double calculate(Employee employee) {
        int monthlyIncome = employee.getMonthlyIncome();

        if (employee instanceof FullTimeEmployee) {
            return BASE_HEALTH_INSURANCE +
                    (monthlyIncome * RETIREMENT_TAX_PERCENTAGE) / 100 +
                    (monthlyIncome * INCOME_TAX_PERCENTAGE) / 100;
        }

        if (employee instanceof PartTimeEmployee) {
            return BASE_HEALTH_INSURANCE +
                    (monthlyIncome * 10) / 100 +
                    (monthlyIncome * INCOME_TAX_PERCENTAGE) / 100;
        }

        if (employee instanceof Intern) {
            if (monthlyIncome < 350) {
                return 0;
            } else {
                return (monthlyIncome * INCOME_TAX_PERCENTAGE) / 100;
            }
        }

        return 0;
    }
}
