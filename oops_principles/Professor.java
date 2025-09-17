import java.util.ArrayList;
import java.util.List;

class Professor {
    private String name;
    private List<Course> courses;

    public Professor(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void assignCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
            course.setProfessor(this);
            System.out.println(name + " assigned to teach " + course.getTitle());
        }
    }

    public void showCourses() {
        System.out.println("Courses taught by " + name + ":");
        if (courses.isEmpty()) {
            System.out.println("  None");
        } else {
            for (Course c : courses) System.out.println("  " + c.getTitle());
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

    public void enrollCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
            course.addStudent(this);
            System.out.println(name + " enrolled in " + course.getTitle());
        }
    }

    public void showCourses() {
        System.out.println("Courses of " + name + ":");
        if (courses.isEmpty()) {
            System.out.println("  None");
        } else {
            for (Course c : courses) System.out.println("  " + c.getTitle());
        }
        System.out.println();
    }
}

class Course {
    private String title;
    private Professor professor;
    private List<Student> students;

    public Course(String title) {
        this.title = title;
        this.students = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public void addStudent(Student s) {
        if (!students.contains(s)) {
            students.add(s);
        }
    }

    public void showDetails() {
        System.out.println("Course: " + title);
        System.out.println("Professor: " + (professor != null ? professor.getName() : "Not assigned"));
        System.out.println("Students:");
        if (students.isEmpty()) {
            System.out.println("  None");
        } else {
            for (Student s : students) System.out.println("  " + s.getName());
        }
        System.out.println();
    }
}

class University {
    private String name;
    private List<Student> students;
    private List<Professor> professors;
    private List<Course> courses;

    public University(String name) {
        this.name = name;
        this.students = new ArrayList<>();
        this.professors = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

    public void addStudent(Student s) {
        students.add(s);
    }

    public void addProfessor(Professor p) {
        professors.add(p);
    }

    public void addCourse(Course c) {
        courses.add(c);
    }

    public void showUniversityDetails() {
        System.out.println("University: " + name);
        System.out.println("Students: " + students.size());
        System.out.println("Professors: " + professors.size());
        System.out.println("Courses: " + courses.size());
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        University uni = new University("Global Tech University");

        Student s1 = new Student("Alice");
        Student s2 = new Student("Bob");

        Professor p1 = new Professor("Dr. Smith");
        Professor p2 = new Professor("Dr. Johnson");

        Course c1 = new Course("Data Structures");
        Course c2 = new Course("Operating Systems");

        uni.addStudent(s1);
        uni.addStudent(s2);
        uni.addProfessor(p1);
        uni.addProfessor(p2);
        uni.addCourse(c1);
        uni.addCourse(c2);

        uni.showUniversityDetails();

        p1.assignCourse(c1);
        p2.assignCourse(c2);

        s1.enrollCourse(c1);
        s1.enrollCourse(c2);
        s2.enrollCourse(c2);

        c1.showDetails();
        c2.showDetails();

        s1.showCourses();
        s2.showCourses();
        p1.showCourses();
        p2.showCourses();
    }
}
