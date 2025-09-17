class Student {
    public int rollNumber;
    protected String name;
    private double cgpa;

    public Student(int rollNumber, String name, double cgpa) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.cgpa = cgpa;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    public void displayStudentDetails() {
        System.out.println("Roll Number: " + rollNumber + ", Name: " + name + ", CGPA: " + cgpa);
    }
}

class PostgraduateStudent extends Student {
    String specialization;

    public PostgraduateStudent(int rollNumber, String name, double cgpa, String specialization) {
        super(rollNumber, name, cgpa);
        this.specialization = specialization;
    }

    public void displayPostgraduateDetails() {
        System.out.println("Roll Number: " + rollNumber + ", Name: " + name + ", Specialization: " + specialization + ", CGPA: " + getCgpa());
    }
}

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student(101, "Alice", 3.8);
        s1.displayStudentDetails();
        s1.setCgpa(3.9);
        System.out.println("Updated CGPA: " + s1.getCgpa());

        PostgraduateStudent p1 = new PostgraduateStudent(201, "Bob", 3.7, "Data Science");
        p1.displayPostgraduateDetails();
    }
}
