package io.github.bluething.solid.kata.globalmanticshr.personel;

import io.github.bluething.solid.kata.globalmanticshr.persistence.Employee;

public class FullTimeEmployee extends Employee {
    public FullTimeEmployee(String fullName, int monthlyIncome) {
        super(fullName, monthlyIncome);
        this.setNbHoursPerWeek(40);
    }
}
