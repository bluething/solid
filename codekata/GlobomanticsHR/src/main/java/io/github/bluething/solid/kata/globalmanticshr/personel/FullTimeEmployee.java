package io.github.bluething.solid.kata.globalmanticshr.personel;

public class FullTimeEmployee extends Employee {
    public FullTimeEmployee(String fullName, int monthlyIncome) {
        super(fullName, monthlyIncome);
        this.setNbHoursPerWeek(40);
    }

    @Override
    public void requestTimeOff(int nbDays, Employee manager) {
        System.out.println("Time off request for full time employee " + this.getFullName() +
                "; Nb days " + nbDays +
                "; Requested from " + manager.getFullName());
    }
}
