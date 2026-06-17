import java.io.*;
import java.util.*;

public class FileHandler {

    // File names
    private File textFile = new File("students.txt");
    private File binaryFile = new File("students.dat");
    private File objectFile = new File("students.obj");
    private File backupFile = new File("backup.dat");

    // Constructor creates files automatically
    public FileHandler() {
        try {
            textFile.createNewFile();
            binaryFile.createNewFile();
            objectFile.createNewFile();
        } catch (IOException e) {
            System.out.println("Error creating files: " + e.getMessage());
        }
    }

    // Save student using text file
    public void saveText(Student s) {
        try (PrintWriter writer = new PrintWriter(
                new FileWriter(textFile, true))) {

            writer.println(s.getId() + "," +
                    s.getName() + "," +
                    s.getDepartment() + "," +
                    s.getGpa());

        } catch (IOException e) {
            System.out.println("Text file error: " + e.getMessage());
        }
    }

    // Read text file
    public void readText() {
        try (Scanner input = new Scanner(textFile)) {

            while (input.hasNextLine()) {
                System.out.println(input.nextLine());
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    // Save student using binary file
    public void saveBinary(Student s) {
        try (DataOutputStream out = new DataOutputStream(
                new FileOutputStream(binaryFile, true))) {

            out.writeInt(s.getId());
            out.writeUTF(s.getName());
            out.writeUTF(s.getDepartment());
            out.writeDouble(s.getGpa());

        } catch (IOException e) {
            System.out.println("Binary error: " + e.getMessage());
        }
    }

    // Read binary file
    public void readBinary() {
        try (DataInputStream in = new DataInputStream(
                new FileInputStream(binaryFile))) {

            while (true) {
                int id = in.readInt();
                String name = in.readUTF();
                String dep = in.readUTF();
                double gpa = in.readDouble();

                System.out.println(
                        id + " " + name +
                                " " + dep +
                                " GPA: " + gpa);
            }

        } catch (EOFException e) {
            System.out.println("End of binary file.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    // Save object using serialization
    public void saveObject(Student s) {
        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(objectFile))) {

            out.writeObject(s);

        } catch (IOException e) {
            System.out.println("Object error: " + e.getMessage());
        }
    }

    // Read serialized object
    public void readObject() {
        try (ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(objectFile))) {

            Student s = (Student) in.readObject();
            System.out.println(s);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Create backup using buffered streams
    public void createBackup() {
        try (BufferedInputStream in = new BufferedInputStream(
                new FileInputStream(binaryFile));

                BufferedOutputStream out = new BufferedOutputStream(
                        new FileOutputStream(backupFile))) {

            int data;

            while ((data = in.read()) != -1) {
                out.write(data);
            }

            System.out.println("Backup created.");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    // Display file properties
    public void fileInfo(File file) {
        System.out.println("Name: " + file.getName());
        System.out.println("Path: " + file.getAbsolutePath());
        System.out.println("Size: " + file.length() + " bytes");
        System.out.println("Modified: " +
                new Date(file.lastModified()));
    }
}