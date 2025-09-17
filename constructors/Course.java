public class Course {
    String courseName;
    int duration; 
    double fee;
    static String instituteName;

    public Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    void displayCourseDetails() {
        System.out.println("Course: " + courseName + ", Duration: " + duration + " weeks, Fee: $" + fee + ", Institute: " + instituteName);
    }

    static void updateInstituteName(String name) {
        instituteName = name;
    }

    public static void main(String[] args) {
        Course.updateInstituteName("Tech Academy");

        Course c1 = new Course("Java Programming", 8, 400);
        Course c2 = new Course("Python Programming", 6, 350);

        c1.displayCourseDetails();
        c2.displayCourseDetails();

        Course.updateInstituteName("Global Tech Institute");

        c1.displayCourseDetails();
        c2.displayCourseDetails();
    }
}
