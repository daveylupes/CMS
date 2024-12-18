import java.util.*;

public class CourseManagement {
    private static final List<Course> courses = new ArrayList<>();
    private static final Map<Student, Map<Course, Double>> studentGrades = new HashMap<>();

    public static void addCourse(String courseCode, String name, int maxCapacity) {
        courses.add(new Course(courseCode, name, maxCapacity));
    }

    public static void enrollStudent(Student student, Course course) {
        student.enrollInCourse(course);
        studentGrades.putIfAbsent(student, new HashMap<>());
    }

    public static void assignGrade(Student student, Course course, double grade) {
        student.assignGrade(course, grade);
        studentGrades.get(student).put(course, grade);
    }

    public static double calculateOverallGrade(Student student) {
        Map<Course, Double> grades = studentGrades.get(student);
        if (grades == null || grades.isEmpty()) {
            throw new IllegalStateException("No grades available for this student.");
        }

        return grades.values().stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
    }

    public static List<Course> getCourses() {
        return courses;
    }
}
