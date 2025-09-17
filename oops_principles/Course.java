import java.util.ArrayList;
import java.util.List;

class Course {
    private String courseName;
    private List<Student> students;

    public Course(String courseName) {
        this.courseName = courseName;
        this.students = new ArrayList<>();
    }

    public String getCourseName() {
        return courseName;
    }

    public void enrollStudent(Student s) {
        if (!students.contains(s)) {
            students.add(s);
            s.addCourse(this);
        }
    }

    public void showEnrolledStudents() {
        System.out.println("Students in " + courseName + ":");
        if (students.isEmpty()) {
            System.out.println("  No students enrolled.");
        } else {
            for (Student s : students) {
                System.out.println("  " + s.getName());
            }
        }
        System.out.println();
    }
}

class Student {
    private String name;
    private List<Course> courses;

    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addCourse(Course c) {
        if (!courses.contains(c)) {
            courses.add(c);
        }
    }

    public void enrollInCourse(Course c) {
        c.enrollStudent(this);
    }

    public void showCourses() {
        System.out.println("Courses for " + name + ":");
        if (courses.isEmpty()) {
            System.out.println("  Not enrolled in any courses.");
        } else {
            for (Course c : courses) {
                System.out.println("  " + c.getCourseName());
            }
        }
        System.out.println();
    }
}

class School {
    private String schoolName;
    private List<Student> students;

    public School(String schoolName) {
        this.schoolName = schoolName;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student s) {
        students.add(s);
    }

    public void showStudents() {
        System.out.println("Students in " + schoolName + ":");
        if (students.isEmpty()) {
            System.out.println("  No students in this school.");
        } else {
            for (Student s : students) {
                System.out.println("  " + s.getName());
            }
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        School school = new School("Green Valley High");

        Student s1 = new Student("Alice");
        Student s2 = new Student("Bob");
        Student s3 = new Student("Charlie");

        school.addStudent(s1);
        school.addStudent(s2);
        school.addStudent(s3);

        Course math = new Course("Mathematics");
        Course science = new Course("Science");
        Course history = new Course("History");

        s1.enrollInCourse(math);
        s1.enrollInCourse(science);

        s2.enrollInCourse(math);
        s2.enrollInCourse(history);

        s3.enrollInCourse(science);

        school.showStudents();

        s1.showCourses();
        s2.showCourses();
        s3.showCourses();

        math.showEnrolledStudents();
        science.showEnrolledStudents();
        history.showEnrolledStudents();
    }
}
