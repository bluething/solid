package io.github.bluething.solid.kata.globalmanticshr;

import io.github.bluething.solid.kata.globalmanticshr.documents.PaySlip;
import io.github.bluething.solid.kata.globalmanticshr.logging.ConsoleLogger;
import io.github.bluething.solid.kata.globalmanticshr.persistence.EmployeeFileSerializer;
import io.github.bluething.solid.kata.globalmanticshr.persistence.EmployeeRepository;
import io.github.bluething.solid.kata.globalmanticshr.personel.Employee;

import java.time.Month;
import java.util.List;

public class ExportPayslipMain {
    public static void main(String[] args) {
        ConsoleLogger logger = new ConsoleLogger();
        EmployeeFileSerializer fileSerializer = new EmployeeFileSerializer();
        EmployeeRepository repository = new EmployeeRepository(fileSerializer);

        List<Employee> employees = repository.findAll();

        for (Employee employee : employees) {
            PaySlip paySlip = new PaySlip(employee, Month.AUGUST);

            String exportedText = paySlip.toTxt().toUpperCase();
            logger.writeInfo(exportedText);
        }
    }
}
