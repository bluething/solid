package io.github.bluething.solid.kata.globalmanticshr.documents;

import io.github.bluething.solid.kata.globalmanticshr.personel.Employee;

import java.time.Month;

public class PaySlip implements ExportableText {

    private final String employeeName;
    private final int monthlyIncome;
    private final Month month;

    public PaySlip(Employee employee, Month month) {
        this.employeeName = employee.getFullName();
        this.monthlyIncome = employee.getMonthlyIncome();
        this.month = month;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public int getMonthlyIncome() {
        return monthlyIncome;
    }

    public Month getMonth() {
        return month;
    }

    @Override
    public String toTxt() {
        StringBuilder sb = new StringBuilder();
        sb.append("MONTH: ").append(this.month);
        sb.append(System.lineSeparator());
        sb.append("NAME: ").append(this.employeeName);
        sb.append(System.lineSeparator());
        sb.append("INCOME: ").append(this.monthlyIncome);
        sb.append(System.lineSeparator());

        return sb.toString();
    }
}
