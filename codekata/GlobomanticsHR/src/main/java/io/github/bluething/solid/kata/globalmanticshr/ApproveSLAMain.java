package io.github.bluething.solid.kata.globalmanticshr;

import io.github.bluething.solid.kata.globalmanticshr.logging.ConsoleLogger;
import io.github.bluething.solid.kata.globalmanticshr.persistence.EmployeeFileSerializer;
import io.github.bluething.solid.kata.globalmanticshr.persistence.EmployeeRepository;
import io.github.bluething.solid.kata.globalmanticshr.personel.Employee;
import io.github.bluething.solid.kata.globalmanticshr.personel.ServiceLicenseAgreement;
import io.github.bluething.solid.kata.globalmanticshr.personel.SubContractor;

import java.util.List;

public class ApproveSLAMain {
    public static void main(String[] args) {

        ConsoleLogger logger = new ConsoleLogger();
        EmployeeFileSerializer fileSerializer = new EmployeeFileSerializer();
        EmployeeRepository repository = new EmployeeRepository(fileSerializer);

        int minTimeOffPercent = 98;
        int maxResolutionDays = 2;
        ServiceLicenseAgreement sla = new ServiceLicenseAgreement(minTimeOffPercent, maxResolutionDays);

        List<Employee> employees = repository.findAll();

        for (Employee employee : employees) {
            if (employee instanceof SubContractor) {
                SubContractor subContractor = (SubContractor) employee;
                subContractor.approveSLA(sla);
            }
        }
    }
}
