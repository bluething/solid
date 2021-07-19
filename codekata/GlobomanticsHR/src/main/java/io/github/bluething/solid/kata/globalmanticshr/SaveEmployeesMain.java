package io.github.bluething.solid.kata.globalmanticshr;

import io.github.bluething.solid.kata.globalmanticshr.logging.ConsoleLogger;
import io.github.bluething.solid.kata.globalmanticshr.personel.Employee;
import io.github.bluething.solid.kata.globalmanticshr.persistence.EmployeeFileSerializer;
import io.github.bluething.solid.kata.globalmanticshr.persistence.EmployeeRepository;

import java.io.IOException;
import java.util.List;

public class SaveEmployeesMain {
    public static void main(String[] args) {
        ConsoleLogger logger = new ConsoleLogger();

        EmployeeFileSerializer serializer = new EmployeeFileSerializer();
        EmployeeRepository repository = new EmployeeRepository(serializer);

        List<Employee> employees = repository.findAll();

        for (Employee employee : employees) {
            try {
                repository.save(employee);
                logger.writeInfo("Saved employee " + employee.toString());
            } catch (IOException e) {
                logger.writeError("Error saving employee", e);
            }
        }
    }
}
