import java.util.*;





public class Campusenrollment_manager{

    // TreeMap to store student records with ID as the key (maintains order by ID)
    private Map<String, Student> studentRecords;

    public Campusenrollment_manager() {
        studentRecords = new TreeMap<>();
    }

    // Method to register a new student
    public void registerStudent(String studentID, String fullName, int score) {
        if (studentRecords.containsKey(studentID)) {
            System.out.println("Error: Student ID already exists in the system.");
        } else {
            studentRecords.put(studentID, new Student(studentID, fullName, score));
            System.out.println("Record for " + fullName + " has been successfully added.");
        }
    }

    // Method to list all students
    public void listAllStudents() {
        if (studentRecords.isEmpty()) {
            System.out.println("No student records available.");
        } else {
            System.out.println("\nAll Student Records:");
            for (Student student : studentRecords.values()) {
                System.out.println(student);
            }
        }
    }

    // Method to update student details
    public void modifyStudent(String studentID, String updatedName, int updatedScore) {
        if (studentRecords.containsKey(studentID)) {
            Student student = studentRecords.get(studentID);
            student.setName(updatedName);
            student.setMarks(updatedScore);
            System.out.println("Details for Student ID " + studentID + " have been updated.");
        } else {
            System.out.println("Error: Student ID not found in the system.");
        }
    }

    // Method to remove a student
    public void removeStudent(String studentID) {
        if (studentRecords.remove(studentID) != null) {
            System.out.println("Student record with ID " + studentID + " has been deleted.");
        } else {
            System.out.println("Error: Student ID not found in the system.");
        }
    }

    // Method to sort and display students by scores
    public void sortStudentsByScores() {
        List<Student> sortedList = new ArrayList<>(studentRecords.values());
        sortedList.sort(Comparator.comparingInt(Student::getMarks).reversed());

        System.out.println("\nStudents Sorted by Scores:");
        for (Student student : sortedList) {
            System.out.println(student);
        }
    }

    // Method to sort and display students by names
    public void sortStudentsByNames() {
        List<Student> sortedList = new ArrayList<>(studentRecords.values());
        sortedList.sort(Comparator.comparing(Student::getName));

        System.out.println("\nStudents Sorted by Names:");
        for (Student student : sortedList) {
            System.out.println(student);
        }
    }

    // Menu-driven interface
    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Campus Enrollment System Menu ---");
            System.out.println("1. Register Student");
            System.out.println("2. List All Students");
            System.out.println("3. Modify Student Details");
            System.out.println("4. Remove Student");
            System.out.println("5. Sort Students by Scores");
            System.out.println("6. Sort Students by Names");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    String studentID = scanner.nextLine();
                    System.out.print("Enter Full Name: ");
                    String fullName = scanner.nextLine();
                    System.out.print("Enter Score: ");
                    int score = scanner.nextInt();
                    registerStudent(studentID, fullName, score);
                    break;
                case 2:
                    listAllStudents();
                    break;
                case 3:
                    System.out.print("Enter Student ID to Modify: ");
                    studentID = scanner.nextLine();
                    System.out.print("Enter Updated Name: ");
                    fullName = scanner.nextLine();
                    System.out.print("Enter Updated Score: ");
                    score = scanner.nextInt();
                    modifyStudent(studentID, fullName, score);
                    break;
                case 4:
                    System.out.print("Enter Student ID to Remove: ");
                    studentID = scanner.nextLine();
                    removeStudent(studentID);
                    break;
                case 5:
                    sortStudentsByScores();
                    break;
                case 6:
                    sortStudentsByNames();
                    break;
                case 7:
                    System.out.println("Exiting system. Thank you for using the Campus Enrollment System.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        Campusenrollment_manager cem = new Campusenrollment_manager();
        cem.displayMenu();
    }
}

// Student class to store individual student details
class Student {
    private String id;
    private String name;
    private int marks;

    public Student(String id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student ID: " + id + ", Name: " + name + ", Score: " + marks;
    }
}


