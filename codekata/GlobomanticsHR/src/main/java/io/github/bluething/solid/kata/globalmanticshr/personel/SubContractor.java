package io.github.bluething.solid.kata.globalmanticshr.personel;

public class SubContractor extends Employee {
    public SubContractor(String fullName, int monthlyIncome) {
        super(fullName, monthlyIncome);
    }

    @Override
    public void requestTimeOff(int nbDays, Employee manager) {
        throw new RuntimeException("Not implemented");
    }

    public boolean approveSLA(ServiceLicenseAgreement sla) {
        // Business logic for approving a service license agreement for a subcontractor
        boolean result = false;
        if (sla.getMinUptimePercent() >= 98
                && sla.getProblemResolutionTimeDays() <= 2) {
            result=  true;
        }

        System.out.println("SLA approval for " + this.getFullName() + ": " + result);
        return result;
    }
}
