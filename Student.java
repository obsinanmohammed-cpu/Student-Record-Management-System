import java.io.Serializable;

public class Student implements Serializable {
    private int id;
    private String name;
    private String department;
    private double gpa;

    public Student(int id, String name, String department, double gpa) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.gpa = gpa;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getGpa() {
        return gpa;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Id: " + id +
                ", Name: " + name +
                ", Department: " + department +
                ", GPA: " + gpa;
    }
}