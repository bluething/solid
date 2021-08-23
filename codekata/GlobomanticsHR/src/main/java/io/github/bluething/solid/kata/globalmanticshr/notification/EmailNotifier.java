package io.github.bluething.solid.kata.globalmanticshr.notification;

import io.github.bluething.solid.kata.globalmanticshr.personel.Employee;

public interface EmailNotifier {
    void notify(Employee employee);
}
