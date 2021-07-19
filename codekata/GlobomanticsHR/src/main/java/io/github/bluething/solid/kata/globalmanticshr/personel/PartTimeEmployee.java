package io.github.bluething.solid.kata.globalmanticshr.personel;

import io.github.bluething.solid.kata.globalmanticshr.persistence.Employee;

public class PartTimeEmployee extends Employee {
    public PartTimeEmployee(String fullName, int monthlyIncome) {
        super(fullName, monthlyIncome);
        this.setNbHoursPerWeek(20);
    }
}
