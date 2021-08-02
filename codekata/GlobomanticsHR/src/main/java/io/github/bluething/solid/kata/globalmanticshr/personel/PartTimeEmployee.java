package io.github.bluething.solid.kata.globalmanticshr.personel;

public class PartTimeEmployee extends Employee {
    public PartTimeEmployee(String fullName, int monthlyIncome) {
        super(fullName, monthlyIncome);
        this.setNbHoursPerWeek(20);
    }

    @Override
    public void requestTimeOff(int nbDays, Employee manager) {
        System.out.println("Time off request for part time employee " + this.getFullName() +
                "; Nb days " + nbDays +
                "; Requested from " + manager.getFullName());
    }
}
