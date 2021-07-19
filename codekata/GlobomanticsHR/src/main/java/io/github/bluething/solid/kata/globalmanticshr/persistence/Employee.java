package io.github.bluething.solid.kata.globalmanticshr.persistence;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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

    // 5 This class is business entity, not as a repository
    public static void save(Employee employee) {
        try {
            // 1 serialization
            StringBuilder sb = new StringBuilder();
            sb.append("### EMPLOYEE RECORD ####");
            sb.append(System.lineSeparator());
            sb.append("NAME: ");
            sb.append(employee.firstName + " " + employee.lastName);
            sb.append(System.lineSeparator());
            sb.append("POSITION: ");
            sb.append(employee.getClass().getTypeName());
            sb.append(System.lineSeparator());
            sb.append("EMAIL: ");
            sb.append(employee.getEmail());
            sb.append(System.lineSeparator());
            sb.append("MONTHLY WAGE: ");
            sb.append(employee.monthlyIncome);
            sb.append(System.lineSeparator());

            // 2 file access
            Path path = Paths.get(employee.getFullName()
                    .replace(" ","_") + ".rec");
            Files.write(path, sb.toString().getBytes());

            // 3 logging
            System.out.println("Saved employee " + employee.toString());
            // 4 exception handling
        } catch (IOException e){
            // 3
            System.out.println("ERROR: Could not save employee. " + e);
        }
    }
    public String getEmail() {
        return this.firstName + "." +
                this.lastName +
                "@globomanticshr.com";
    }
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
}
