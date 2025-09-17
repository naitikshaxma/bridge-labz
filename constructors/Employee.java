class Employee {
    public String employeeID;
    protected String department;
    private double salary;

    public void setSalary(double s) {
        salary = s;
    }

    public double getSalary() {
        return salary;
    }

    public void display() {
        System.out.println("Employee ID: " + employeeID + ", Department: " + department + ", Salary: $" + salary);
    }
}

class Manager extends Employee {
    String teamName;

    public void displayManager() {
        System.out.println("Employee ID: " + employeeID + ", Department: " + department + ", Salary: $" + getSalary() + ", Team: " + teamName);
    }
}

public class Main {
    public static void main(String[] args) {
        Employee e = new Employee();
        e.employeeID = "E101";
        e.department = "IT";
        e.setSalary(60000);
        e.display();

        Manager m = new Manager();
        m.employeeID = "M201";
        m.department = "HR";
        m.setSalary(90000);
        m.teamName = "Recruitment";
        m.displayManager();
    }
}
