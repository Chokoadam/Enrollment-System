//Adam Vasquez
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        EnrollmentSystem enrollmentSystem = new EnrollmentSystem(); //Initializes EnrollmentStudent object
        Scanner scanner = new Scanner(System.in); //Scanner to read user input
        boolean isAdmin = false; //To check if administrator
        int studentId = 0; // Initialize studentId variable

        while (true) { //Asks if user is admin, student, or if they want to exit
            if (!isAdmin) {
                System.out.println("Are you a student or an administrator?");
                System.out.println("[1] Student");
                System.out.println("[2] Administrator");
                System.out.println("[3] Exit");
            } else {
                System.out.println("Are you a student or an administrator?");
                System.out.println("[1] Administrator");
                System.out.println("[2] Student");
                System.out.println("[3] Exit");
            }

            int userType = scanner.nextInt(); //Takes in user response
            scanner.nextLine(); 

            if (userType == 1) { //Sets mode to student
                isAdmin = !isAdmin; 
            } else if (userType == 2) { //Sets mode to administrator
                isAdmin = !isAdmin;
            }
            else if (userType == 3) { //Exits the program
                	isAdmin = !isAdmin;
                	System.out.println("Have a good rest of your day!");
                	System.exit(0);
                	scanner.close();
                }
             else {
                System.out.println("Invalid user response."); //If response was invalid
                continue;
            }

            while (true) {
                if (!isAdmin) { //Student: Gives options to register themeselves, enroll and drop from a course, display their details, display course details, and to go back 
                    System.out.println("Choose an option:");
                    System.out.println("1. Register as a student");
                    System.out.println("2. Enroll in a course");
                    System.out.println("3. Drop from a course");
                    System.out.println("4. Display Student Details");
                    System.out.println("5. Display Course Details");
                    System.out.println("0. Go Back");
                } else {
                    System.out.println("Choose an option:"); // Administrator: Gives option to add, remove, and modify a course, display student and course details, display enrollemnt status and course scheduling as well as go back
                    System.out.println("1. Add Course");
                    System.out.println("2. Remove Course");
                    System.out.println("3. Modify Course");
                    System.out.println("4. Display Student Details");
                    System.out.println("5. Display Course Details");
                    System.out.println("6. Display Enrollment Status");
                    System.out.println("7. Display Course Scheduling");
                    System.out.println("0. Go Back");
                }

                int choice = scanner.nextInt(); //Takes in user input
                scanner.nextLine(); 

                if (!isAdmin) {
                    // Student cases based on what they input
                    switch (choice) {
                        case 1: //Registers student by asking for their ID, name, age, and major
                            System.out.println("Enter student ID:");
                            studentId = scanner.nextInt(); 
                            scanner.nextLine();
                            System.out.println("Enter name:");
                            String name = scanner.nextLine();
                            System.out.println("Enter age:");
                            int age = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Enter major:");
                            String major = scanner.nextLine();
                            enrollmentSystem.addStudent(new Student(studentId, name, age, major));
                            break;
                        case 2: //Asks the student which course they wish to enroll, if valid, enrolls them into the course
                            System.out.println("Enter course ID to enroll:");
                            int courseIdToEnroll = scanner.nextInt();
                            scanner.nextLine();
                            enrollmentSystem.enrollStudentCourse(studentId, courseIdToEnroll);
                            break;
                        case 3: //Asks the student which course they wish to drop, if valid, drops them from the course
                            System.out.println("Enter course ID to drop:");
                            int courseIdToDrop = scanner.nextInt();
                            scanner.nextLine();
                            enrollmentSystem.dropStudentCourse(studentId, courseIdToDrop);
                            break;
                        case 4: //Asks the student the student ID of the student to display details of
                            System.out.println("Enter student ID to display details:");
                            int studentIdToDisplay = scanner.nextInt();
                            scanner.nextLine();
                            enrollmentSystem.displayStudentDetails(studentIdToDisplay);
                            break;
                        case 5: //Asks the student the course ID to display details of
                            System.out.println("Enter course ID to display details:");
                            int courseIdToDisplay = scanner.nextInt();
                            scanner.nextLine();
                            enrollmentSystem.displayCourseDetails(courseIdToDisplay);
                            break;
                        case 0:
                            break;
                        default: //If the student inputted an invalid choice
                            System.out.println("Invalid choice. Please choose again.");
                    }
                } else {
                    // Administrator cases based on what they input
                    switch (choice) {
                        case 1: //Allows the admin to add a course, asks them the course ID, course name, instructor for the course, and capacity of the course
                            System.out.println("Enter course ID:");
                            int courseId = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Enter course name:");
                            String courseName = scanner.nextLine();
                            System.out.println("Enter instructor for the course:");
                            String instructor = scanner.nextLine();
                            System.out.println("Enter capacity for the course:");
                            int capacity = scanner.nextInt();
                            scanner.nextLine();
                            enrollmentSystem.addCourse(new Course(courseId, courseName, instructor, capacity));
                            break;
                        case 2: //Allows the admin to remove a course by specifying the course ID of the course they wish to remove
                            System.out.println("Enter Course ID to remove:");
                            int courseIdToRemove = scanner.nextInt();
                            scanner.nextLine();
                            enrollmentSystem.removeCourse(courseIdToRemove);
                            break;
                        case 3: //Allows the admin to modify a course by specifying the course ID. The admin gets to change the course name, instructor, and capacity of the course
                            System.out.println("Enter course ID to modify:");
                            int courseIdToModify = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Enter new course name:");
                            String newCourseName = scanner.nextLine();
                            System.out.println("Enter new instructor:");
                            String newInstructor = scanner.nextLine();
                            System.out.println("Enter new capacity:");
                            int newCapacity = scanner.nextInt();
                            scanner.nextLine();
                            enrollmentSystem.modifyCourse(courseIdToModify, newCourseName, newInstructor, newCapacity);
                            break;
                        case 4: //Displays student details of the student ID the admin inputs
                            System.out.println("Enter student ID to display details:");
                            int studentIdToDisplay = scanner.nextInt();
                            scanner.nextLine();
                            enrollmentSystem.displayStudentDetails(studentIdToDisplay);
                            break;
                        case 5: //Displays course details of the course ID the admin inputs
                            System.out.println("Enter course ID to display details:");
                            int courseIdToDisplay = scanner.nextInt();
                            scanner.nextLine();
                            enrollmentSystem.displayCourseDetails(courseIdToDisplay);
                            break;
                        case 6: //Displays enrollment status of the course ID the admin inputs
                            System.out.println("Enter course ID to display enrollment status:");
                            int courseIdForEnrollmentStatus = scanner.nextInt();
                            scanner.nextLine();
                            enrollmentSystem.displayEnrollmentStatus(courseIdForEnrollmentStatus);
                            break;
                        case 7: //Displays course scheduling
                            enrollmentSystem.displayCourseScheduling();
                            break;
                        case 0:
                            break;
                        default: //If the admin makes an invalid input
                            System.out.println("Invalid choice. Please choose again.");
                    }
                }

                if (choice == 0) {
                    break; // Exit the inner loop to go back to starting menu
                }
            }
        }
    }
}
