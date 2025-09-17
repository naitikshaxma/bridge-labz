public class Employee {
    static String companyName = "OpenAI Solutions";
    private static int totalEmployees = 0;

    private String name;
    private final int id;
    private String designation;

    public Employee(String name, int id, String designation) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        totalEmployees++;
    }

    public static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }

    public void displayDetails() {
        if (this instanceof Employee) {
            System.out.println("Company: " + companyName);
            System.out.println("Name: " + name);
            System.out.println("ID: " + id);
            System.out.println("Designation: " + designation);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Employee e1 = new Employee("Alice", 101, "Developer");
        Employee e2 = new Employee("Bob", 102, "Manager");

        if (e1 instanceof Employee) e1.displayDetails();
        if (e2 instanceof Employee) e2.displayDetails();

        Employee.displayTotalEmployees();
    }
}
