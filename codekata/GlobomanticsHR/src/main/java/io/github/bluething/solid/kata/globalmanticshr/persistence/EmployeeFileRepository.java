package io.github.bluething.solid.kata.globalmanticshr.persistence;

import io.github.bluething.solid.kata.globalmanticshr.personel.Employee;
import io.github.bluething.solid.kata.globalmanticshr.personel.FullTimeEmployee;
import io.github.bluething.solid.kata.globalmanticshr.personel.Intern;
import io.github.bluething.solid.kata.globalmanticshr.personel.PartTimeEmployee;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeFileRepository {
    private final EmployeeFileSerializer fileSerializer;
    
    public EmployeeFileRepository(EmployeeFileSerializer fileSerializer) {
        this.fileSerializer = fileSerializer;
    }

    public List<Employee> findAll() {
        List<Employee> employees = new ArrayList<>();

        String path =  this.getClass().getClassLoader()
                .getResource("employees.csv")
                .getPath();

        try (Scanner scanner = new Scanner(new File(path))) {
            // SKip header
            scanner.nextLine();

            // Process content
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Employee employee = createEmployeeFromCsvRecord(line);
                employees.add(employee);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return employees;
    }

    private Employee createEmployeeFromCsvRecord(String line) {
        String[] employeeRecord = line.split(",");
        String name = employeeRecord[0];
        int income = Integer.parseInt(employeeRecord[1]);
        int nbHours = Integer.parseInt(employeeRecord[2]);

        Employee employee;
        if(nbHours == 40){
            employee = new FullTimeEmployee(name,income);
        } else if (nbHours == 20){
            employee = new PartTimeEmployee(name, income);
        } else{
            employee = new Intern(name, income, nbHours);
        }
        return employee;
    }
}