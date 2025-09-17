import java.util.ArrayList;
import java.util.List;

class Faculty {
    private String name;
    private String specialization;

    public Faculty(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }
}

class Department {
    private String deptName;

    public Department(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptName() {
        return deptName;
    }
}

class University {
    private String universityName;
    private List<Department> departments;
    private List<Faculty> faculties;

    public University(String universityName) {
        this.universityName = universityName;
        this.departments = new ArrayList<>();
        this.faculties = new ArrayList<>();
    }

    public Department addDepartment(String name) {
        Department d = new Department(name);
        departments.add(d);
        return d;
    }

    public void addFaculty(Faculty f) {
        faculties.add(f);
    }

    public void showDetails() {
        System.out.println("University: " + universityName);
        System.out.println("Departments:");
        if (departments.isEmpty()) System.out.println("  None");
        else for (Department d : departments) System.out.println("  " + d.getDeptName());
        System.out.println("Faculties:");
        if (faculties.isEmpty()) System.out.println("  None");
        else for (Faculty f : faculties)
            System.out.println("  " + f.getName() + " (" + f.getSpecialization() + ")");
        System.out.println();
    }

    public void closeUniversity() {
        departments.clear();
        System.out.println("University " + universityName + " closed. All its departments deleted.");
    }
}

public class Main {
    public static void main(String[] args) {
        University u = new University("Sunrise University");

        Department cs = u.addDepartment("Computer Science");
        Department math = u.addDepartment("Mathematics");

        Faculty f1 = new Faculty("Alice", "AI");
        Faculty f2 = new Faculty("Bob", "Algebra");

        u.addFaculty(f1);
        u.addFaculty(f2);

        u.showDetails();

        u.closeUniversity();

        System.out.println("Faculty members can still exist independently:");
        System.out.println(f1.getName() + " - " + f1.getSpecialization());
        System.out.println(f2.getName() + " - " + f2.getSpecialization());
    }
}
