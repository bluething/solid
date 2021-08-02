package io.github.bluething.solid.kata.globalmanticshr;

import io.github.bluething.solid.kata.globalmanticshr.logging.ConsoleLogger;
import io.github.bluething.solid.kata.globalmanticshr.persistence.EmployeeFileSerializer;
import io.github.bluething.solid.kata.globalmanticshr.persistence.EmployeeRepository;
import io.github.bluething.solid.kata.globalmanticshr.personel.Employee;
import io.github.bluething.solid.kata.globalmanticshr.personel.ServiceLicenseAgreement;
import io.github.bluething.solid.kata.globalmanticshr.personel.SubContractor;

import java.util.Arrays;
import java.util.List;

public class ApproveSLAMain {
    public static void main(String[] args) {
        // Define SLA
        int minTimeOffPercent = 98;
        int maxResolutionDays = 2;
        ServiceLicenseAgreement companySla = new ServiceLicenseAgreement(
                minTimeOffPercent,
                maxResolutionDays);

        // Get collaborators from their own source
        SubContractor subcontractor1 = new SubContractor(
                "Rebekah Jackson",
                "rebekah-jackson@abc.com",
                3000,
                15);
        SubContractor subcontractor2 = new SubContractor(
                "Harry Fitz",
                "harryfitz@def.com",
                3000, 15);
        List<SubContractor> collaborators = Arrays.asList(subcontractor1, subcontractor2);

        // Check SLA
        for (SubContractor s : collaborators) {
            s.approveSLA(companySla);
        }
    }
}
