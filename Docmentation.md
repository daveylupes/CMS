**Comprehensive Documentation for the Course Enrollment and Grade Management System**

### Purpose and Usage of Each Class

1. **Student Class**
    - **Purpose:** Manages information about students, including their name, ID, enrolled courses, and grades.
    - **Usage:**
        - Store a student’s personal details.
        - Keep track of courses the student is enrolled in.
        - Assign and retrieve grades for specific courses.
    - **Key Methods:**
        - `getName()` / `setName(String name)`: Get or update the student's name.
        - `getId()` / `setId(String id)`: Get or update the student's ID.
        - `enrollInCourse(Course course)`: Enroll the student in a given course.
        - `assignGrade(Course course, double grade)`: Assign a grade to the student for a specific course.
        - `getGrade(Course course)`: Retrieve the grade for a specific course.

2. **Course Class**
    - **Purpose:** Manages details about courses, including the course code, name, maximum capacity, and number of enrolled students.
    - **Usage:**
        - Store course-specific information.
        - Track enrollment numbers and enforce capacity limits.
        - Provide a static method for tracking total enrolled students across all courses.
    - **Key Methods:**
        - `getCourseCode()`: Retrieve the course code.
        - `getName()`: Retrieve the course name.
        - `getMaxCapacity()`: Retrieve the maximum capacity of the course.
        - `getEnrolledStudents()`: Retrieve the number of enrolled students.
        - `incrementEnrollment()`: Add a student to the course if the capacity allows.
        - `getTotalEnrolledStudents()`: Retrieve the total number of students enrolled across all courses.

3. **CourseManagement Class**
    - **Purpose:** Handles overall management of courses and grades, acting as a bridge between the `Student` and `Course` classes.
    - **Usage:**
        - Store and manage all courses in the system.
        - Allow administrators to enroll students, assign grades, and calculate overall grades.
        - Provide static methods for managing course data and student grades.
    - **Key Methods:**
        - `addCourse(String courseCode, String name, int maxCapacity)`: Create a new course and add it to the list of courses.
        - `enrollStudent(Student student, Course course)`: Enroll a student in a course.
        - `assignGrade(Student student, Course course, double grade)`: Assign a grade to a student for a specific course.
        - `calculateOverallGrade(Student student)`: Calculate the average grade for a student across all their courses.

4. **AdministratorInterface Class**
    - **Purpose:** Provides a command-line interface for administrators to interact with the system.
    - **Usage:**
        - Allows administrators to add courses, enroll students, assign grades, and calculate grades through a simple menu.
        - Handles user input and calls appropriate methods from other classes.

### How Static Methods and Variables Are Used

1. **Static Variables**
    - In the `Course` class:
        - `totalEnrolledStudents` keeps track of the total number of students enrolled in all courses combined.
    - In the `CourseManagement` class:
        - A static list (`courses`) stores all courses in the system.
        - A static map (`studentGrades`) stores the grades for all students, organized by course.

2. **Static Methods**
    - In the `Course` class:
        - `getTotalEnrolledStudents()`: Provides access to the `totalEnrolledStudents` variable.
    - In the `CourseManagement` class:
        - Methods like `addCourse()`, `enrollStudent()`, and `assignGrade()` perform global operations that do not depend on specific instances of `CourseManagement`.

### Instructions for Running the Program

1. **Compiling the Program**
    - Ensure that all `.java` files are in the same directory.
    - Open a terminal or command prompt and navigate to the directory containing the files.
    - Run the following command to compile all files:
      ```sh
      javac *.java
      ```

2. **Running the Program**
    - Run the main program using:
      ```sh
      java AdministratorInterface
      ```

3. **Interacting with the Administrator Interface**
    - The program displays a menu with options:
        1. Add Course
        2. Enroll Student
        3. Assign Grade
        4. Calculate Overall Grade
        5. Exit
    - Choose an option by entering the corresponding number.
    - Follow the prompts to enter required information (e.g., course details, student details, grades).
    - To stop the program, choose the option to exit (5).

4. **Error Handling**
    - If invalid input is provided (e.g., enrolling in a full course or assigning a grade for an un-enrolled course), the program will display an appropriate error message and return to the menu.

### Reference
Eck, D. J. (2019). *Introduction to Programming Using Java Version 9, JavaFX Edition*. Retrieved from https://math.hws.edu/javanotes/

