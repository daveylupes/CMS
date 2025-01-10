import java.util.*;

public class AdministratorInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nCourse Enrollment and Grade Management System");
            System.out.println("1. Add Course");
            System.out.println("2. Enroll Student");
            System.out.println("3. Assign Grade");
            System.out.println("4. Calculate Overall Grade");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter course code: ");
                    String courseCode = scanner.nextLine();
                    System.out.print("Enter course name: ");
                    String courseName = scanner.nextLine();
                    System.out.print("Enter maximum capacity: ");
                    int maxCapacity = scanner.nextInt();
                    CourseManagement.addCourse(courseCode, courseName, maxCapacity);
                    System.out.println("Course added successfully.");
                    break;

                case 2:
                    System.out.print("Enter student name: ");
                    String studentName = scanner.nextLine();
                    System.out.print("Enter student ID: ");
                    String studentId = scanner.nextLine();
                    Student student = new Student(studentName, studentId);

                    System.out.print("Enter course code to enroll in: ");
                    courseCode = scanner.nextLine();
                    Course course = CourseManagement.getCourses().stream()
                            .filter(c -> c.getCourseCode().equals(courseCode))
                            .findFirst()
                            .orElse(null);

                    if (course != null) {
                        CourseManagement.enrollStudent(student, course);
                        System.out.println("Student enrolled successfully.");
                    } else {
                        System.out.println("Course not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter student ID: ");
                    studentId = scanner.nextLine();
                    student = new Student("", studentId);

                    System.out.print("Enter course code: ");
                    courseCode = scanner.nextLine();
                    course = CourseManagement.getCourses().stream()
                            .filter(c -> c.getCourseCode().equals(courseCode))
                            .findFirst()
                            .orElse(null);

                    if (course != null) {
                        System.out.print("Enter grade: ");
                        double grade = scanner.nextDouble();
                        CourseManagement.assignGrade(student, course, grade);
                        System.out.println("Grade assigned successfully.");
                    } else {
                        System.out.println("Course not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter student ID: ");
                    studentId = scanner.nextLine();
                    student = new Student("", studentId);

                    try {
                        double overallGrade = CourseManagement.calculateOverallGrade(student);
                        System.out.println("Overall Grade: " + overallGrade);
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5:
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
