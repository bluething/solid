package io.github.bluething.solid.kata.globalmanticshr.persistence;

import io.github.bluething.solid.kata.globalmanticshr.personel.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class EmployeeRepository {

    private final EmployeeFileSerializer serializer;

    public EmployeeRepository(EmployeeFileSerializer employeeFileSerializer) {
        this.serializer = employeeFileSerializer;
    }

    public List<Employee> findAll() {
        Employee anna = new FullTimeEmployee("Anna Smith", 2000);
        Employee billy = new FullTimeEmployee("Billy Leech", 920);

        Employee steve = new PartTimeEmployee("Steve Jones", 800);
        Employee magda = new PartTimeEmployee("Magda Iovan", 920);

        Employee john = new Intern("John Lee", 300, 10);
        Employee catherine = new Intern("Catherine Allison", 500, 15);

        return Arrays.asList(anna, billy, steve, magda, john, catherine);
    }

    public void save(Employee employee) throws IOException {
        String serializeString = serializer.serialize(employee);
        // 2 file access
        Path path = Paths.get(employee.getFullName()
                .replace(" ","_") + ".rec");
        Files.write(path, serializeString.getBytes());
    }
}
