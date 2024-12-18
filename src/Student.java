import java.util.*;

public class Student {
    private String name;
    private String id;
    private List<Course> enrolledCourses;
    private Map<Course, Double> grades;

    public Student(String name, String id) {
        this.name = name;
        this.id = id;
        this.enrolledCourses = new ArrayList<>();
        this.grades = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void enrollInCourse(Course course) {
        if (!enrolledCourses.contains(course)) {
            enrolledCourses.add(course);
            course.incrementEnrollment();
        }
    }

    public void assignGrade(Course course, double grade) {
        if (enrolledCourses.contains(course)) {
            grades.put(course, grade);
        } else {
            throw new IllegalArgumentException("Student is not enrolled in this course.");
        }
    }

    public Double getGrade(Course course) {
        return grades.get(course);
    }
}
