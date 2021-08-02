package io.github.bluething.solid.kata.globalmanticshr.personel;

public abstract class Employee {
    private final String firstName;
    private final String lastName;

    private int monthlyIncome;
    private int nbHoursPerWeek;

    public Employee(String fullName, int monthlyIncome) {
        setMonthlyIncome(monthlyIncome);

        String[] names = fullName.split(" ");
        this.firstName = names[0];
        this.lastName = names[1];
    }

    public void setMonthlyIncome(int monthlyIncome) {
        if(monthlyIncome < 0){
            throw new IllegalArgumentException("Income must be positive");
        }

        this.monthlyIncome = monthlyIncome;
    }

    public String getEmail() {
        return this.firstName + "." +
                this.lastName +
                "@globomanticshr.com";
    }

    public abstract void requestTimeOff(int nbDays, Employee manager);

    public String getFullName(){
        return this.firstName + " " + this.lastName;
    }

    public void setNbHoursPerWeek(int nbHoursPerWeek) {
        if(nbHoursPerWeek <= 0){
            throw new IllegalArgumentException("Income must be positive");
        }

        this.nbHoursPerWeek = nbHoursPerWeek;
    }
    public int getNbHoursPerWeek() {
        return nbHoursPerWeek;
    }

    public int getMonthlyIncome() {
        return monthlyIncome;
    }
}
