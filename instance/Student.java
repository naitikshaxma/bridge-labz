public class Student {
    static String universityName = "OpenAI University";
    private static int totalStudents = 0;

    private String name;
    private final int rollNumber;
    private String grade;

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        totalStudents++;
    }

    public static void displayTotalStudents() {
        System.out.println("Total Students: " + totalStudents);
    }

    public void displayDetails() {
        if (this instanceof Student) {
            System.out.println("University: " + universityName);
            System.out.println("Name: " + name);
            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Grade: " + grade);
        }
    }

    public void updateGrade(String newGrade) {
        if (this instanceof Student) {
            grade = newGrade;
            System.out.println("Grade updated to: " + grade);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("Alice", 1, "A");
        Student s2 = new Student("Bob", 2, "B");

        if (s1 instanceof Student) s1.displayDetails();
        if (s2 instanceof Student) s2.displayDetails();

        s2.updateGrade("A+");
        Student.displayTotalStudents();
    }
}
