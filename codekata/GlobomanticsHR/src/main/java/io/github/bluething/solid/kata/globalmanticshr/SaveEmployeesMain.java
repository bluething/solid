package io.github.bluething.solid.kata.globalmanticshr;

import io.github.bluething.solid.kata.globalmanticshr.persistence.EmployeeRepository;

import java.util.List;

public class SaveEmployeesMain {
    public static void main(String[] args) {
        EmployeeRepository repository = new EmployeeRepository();
        List<Employee> employees = repository.findAll();

        for (Employee employee : employees) {
            Employee.save(employee);
        }
    }
}
