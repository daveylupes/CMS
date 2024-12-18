public class Course {
    private final String courseCode;
    private final String name;
    private final int maxCapacity;
    private int enrolledStudents;

    private static int totalEnrolledStudents = 0;

    public Course(String courseCode, String name, int maxCapacity) {
        this.courseCode = courseCode;
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.enrolledStudents = 0;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getName() {
        return name;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public int getEnrolledStudents() {
        return enrolledStudents;
    }

    public void incrementEnrollment() {
        if (enrolledStudents < maxCapacity) {
            enrolledStudents++;
            totalEnrolledStudents++;
        } else {
            throw new IllegalStateException("Course has reached maximum capacity.");
        }
    }

    public static int getTotalEnrolledStudents() {
        return totalEnrolledStudents;
    }
}
