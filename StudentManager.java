import java.util.ArrayList;

public class StudentManager {

    private ArrayList<Student> students;
    private FileHandler fileHandler;

    // Constructor
    public StudentManager() {
        students = new ArrayList<>();
        fileHandler = new FileHandler();
    }

    // Add Student
    public void addStudent(Student s) {
        students.add(s);

        // Save in different file formats
        fileHandler.saveText(s);
        fileHandler.saveBinary(s);
        fileHandler.saveObject(s);

        System.out.println("Student added successfully.");
    }

    // Search Student by ID
    public Student searchStudent(int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    // Update Student Information
    public void updateStudent(int id, String name,
            String department, double gpa) {

        Student s = searchStudent(id);

        if (s != null) {
            s.setName(name);
            s.setDepartment(department);
            s.setGpa(gpa);

            System.out.println("Student updated successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    // Delete Student
    public void deleteStudent(int id) {

        Student s = searchStudent(id);

        if (s != null) {
            students.remove(s);
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    // Display All Students
    public void displayStudents() {

        if (students.isEmpty()) {
            System.out.println("No students available.");
        } else {
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }

    // Generate Report
    public void generateReport() {

        if (students.isEmpty()) {
            System.out.println("No records to analyze.");
            return;
        }

        Student highest = students.get(0);
        Student lowest = students.get(0);
        double total = 0;

        for (Student s : students) {

            if (s.getGpa() > highest.getGpa()) {
                highest = s;
            }

            if (s.getGpa() < lowest.getGpa()) {
                lowest = s;
            }

            total += s.getGpa();
        }

        double average = total / students.size();

        System.out.println("\n===== REPORT =====");
        System.out.println("Total Students: " + students.size());
        System.out.println("Highest GPA: " + highest);
        System.out.println("Lowest GPA: " + lowest);
        System.out.println("Average GPA: " + average);
    }

    // Display file information
    public void showFileInformation() {
        System.out.println("\nTEXT FILE");
        fileHandler.fileInfo(new java.io.File("students.txt"));

        System.out.println("\nBINARY FILE");
        fileHandler.fileInfo(new java.io.File("students.dat"));

        System.out.println("\nOBJECT FILE");
        fileHandler.fileInfo(new java.io.File("students.obj"));
    }

    // Create backup
    public void backupRecords() {
        fileHandler.createBackup();
    }
}