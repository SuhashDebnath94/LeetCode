package DesignPatterns.Structural.Composite.example2;

public class Driver {
    public static void main(String[] args) {
        Employee dev1 = new Developer("Alice", "Frontend Developer");
        Employee dev2 = new Developer("Bob", "Backend Developer");

        Manager manager = new Manager("Charlie");
        manager.addEmployee(dev1);
        manager.addEmployee(dev2);

        Manager generalManager = new Manager("David");
        generalManager.addEmployee(manager);

        System.out.println("Organization hierarchy:");
        generalManager.showDetails();
    }
}
