package DesignPatterns.Structural.Composite.example2;

import java.util.ArrayList;
import java.util.List;

// Composite: Manager
class Manager implements Employee {
    private String name;
    private List<Employee> subordinates = new ArrayList<>();

    public Manager(String name) {
        this.name = name;
    }

    public void addEmployee(Employee employee) {
        subordinates.add(employee);
    }

    public void removeEmployee(Employee employee) {
        subordinates.remove(employee);
    }

    @Override
    public void showDetails() {
        System.out.println("Manager: " + name);
        for (Employee employee : subordinates) {
            employee.showDetails();
        }
    }
}