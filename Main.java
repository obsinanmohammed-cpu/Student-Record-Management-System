import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        int choice;

        do {
            System.out.println("\n===== STUDENT RECORD SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Search Student");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Display All Students");
            System.out.println("6. Generate Report");
            System.out.println("7. Display File Information");
            System.out.println("8. Create Backup");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            choice = input.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter ID: ");
                    int id = input.nextInt();
                    input.nextLine();

                    System.out.print("Enter Name: ");
                    String name = input.nextLine();

                    System.out.print("Enter Department: ");
                    String department = input.nextLine();

                    System.out.print("Enter GPA: ");
                    double gpa = input.nextDouble();

                    Student s = new Student(id, name, department, gpa);
                    manager.addStudent(s);
                    break;

                case 2:
                    System.out.print("Enter Student ID to search: ");
                    id = input.nextInt();

                    Student found = manager.searchStudent(id);

                    if (found != null) {
                        System.out.println("Student Found:");
                        System.out.println(found);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Student ID to update: ");
                    id = input.nextInt();
                    input.nextLine();

                    System.out.print("Enter new Name: ");
                    name = input.nextLine();

                    System.out.print("Enter new Department: ");
                    department = input.nextLine();

                    System.out.print("Enter new GPA: ");
                    gpa = input.nextDouble();

                    manager.updateStudent(id, name, department, gpa);
                    break;

                case 4:
                    System.out.print("Enter Student ID to delete: ");
                    id = input.nextInt();

                    manager.deleteStudent(id);
                    break;

                case 5:
                    manager.displayStudents();
                    break;

                case 6:
                    manager.generateReport();
                    break;

                case 7:
                    manager.showFileInformation();
                    break;

                case 8:
                    manager.backupRecords();
                    break;

                case 9:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 9);

        input.close();
    }
}