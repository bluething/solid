package io.github.bluething.solid.kata.globalmanticshr;

import io.github.bluething.solid.kata.globalmanticshr.logging.ConsoleLogger;
import io.github.bluething.solid.kata.globalmanticshr.persistence.EmployeeFileRepository;
import io.github.bluething.solid.kata.globalmanticshr.persistence.EmployeeFileSerializer;
import io.github.bluething.solid.kata.globalmanticshr.persistence.EmployeeRepository;
import io.github.bluething.solid.kata.globalmanticshr.personel.Employee;
import io.github.bluething.solid.kata.globalmanticshr.personel.FullTimeEmployee;

import java.util.List;

public class NatHolidayEmployeeTimeOffMain {
    public static void main(String[] args) {
        ConsoleLogger logger = new ConsoleLogger();
        EmployeeFileSerializer fileSerializer = new EmployeeFileSerializer();
        EmployeeRepository repository = new EmployeeFileRepository(fileSerializer);

        List<Employee> employees = repository.findAll();
        Employee manager = new FullTimeEmployee("Steve Jackson", 5000);

        for (Employee employee : employees) {
            employee.requestTimeOff(1, manager);
        }
    }
}
