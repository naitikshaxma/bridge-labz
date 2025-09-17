import java.util.ArrayList;
import java.util.List;

class Employee {
    private String name;
    private String role;

    public Employee(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }
}

class Department {
    private String deptName;
    private List<Employee> employees;

    public Department(String deptName) {
        this.deptName = deptName;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(String name, String role) {
        employees.add(new Employee(name, role));
    }

    public void showDepartmentDetails() {
        System.out.println("Department: " + deptName);
        if (employees.isEmpty()) {
            System.out.println("  No employees");
        } else {
            for (Employee e : employees) {
                System.out.println("  " + e.getName() + " - " + e.getRole());
            }
        }
        System.out.println();
    }

    public void clearEmployees() {
        employees.clear();
    }
}

class Company {
    private String companyName;
    private List<Department> departments;

    public Company(String companyName) {
        this.companyName = companyName;
        this.departments = new ArrayList<>();
    }

    public Department addDepartment(String name) {
        Department d = new Department(name);
        departments.add(d);
        return d;
    }

    public void showCompanyDetails() {
        System.out.println("Company: " + companyName);
        for (Department d : departments) {
            d.showDepartmentDetails();
        }
    }

    public void closeCompany() {
        for (Department d : departments) {
            d.clearEmployees();
        }
        departments.clear();
        System.out.println("Company " + companyName + " and all its departments are closed.");
    }
}

public class Main {
    public static void main(String[] args) {
        Company c = new Company("Tech Solutions");

        Department hr = c.addDepartment("HR");
        hr.addEmployee("Alice", "Recruiter");
        hr.addEmployee("Bob", "HR Manager");

        Department it = c.addDepartment("IT");
        it.addEmployee("Charlie", "Developer");
        it.addEmployee("Diana", "Tester");

        c.showCompanyDetails();

        c.closeCompany();
    }
}
