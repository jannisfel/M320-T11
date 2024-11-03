package D2.src;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// schwarzer diamand heisst nur dass test nur in student

class Test {
    private int points;

    public Test(int points) {
        this.points = points;
    }

    public float calculateGrade() {
        return (float) points * 5 / 100 + 1;
    }

    public int getPoints() {
        return points;
    }
}

class Student {
    private String name;
    private List<Test> tests;

    public Student(String name) {
        this.name = name;
        this.tests = new ArrayList<>();
    }

    public void addTest(Test test) {
        tests.add(test);
    }

    public float getAverage() {
        if (tests.isEmpty())
            return 0;
        float totalGrades = 0;
        for (Test test : tests) {
            totalGrades += test.calculateGrade();
        }
        return totalGrades / tests.size();
    }

    public String getName() {
        return name;
    }
}

class SchoolClass {
    private List<Student> students;

    public SchoolClass() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public float getClassAverage() {
        if (students.isEmpty())
            return 0;
        float totalAverage = 0;
        for (Student student : students) {
            totalAverage += student.getAverage();
        }
        return totalAverage / students.size();
    }

    public void displayGrades() {
        for (Student student : students) {
            System.out.println("Student: " + student.getName() + ", Average Grade: " + student.getAverage());
        }
        System.out.println("Class Average: " + String.format("%.2f", getClassAverage()));
    }
}

public class Main {
    public static void main(String[] args) {
        SchoolClass schoolClass = new SchoolClass();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. Display Grades");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            if (option == 1) {
                System.out.print("Enter student name: ");
                String name = scanner.nextLine();
                Student student = new Student(name);

                while (true) {
                    System.out.print("Enter test points (or -1 to stop): ");
                    int points = scanner.nextInt();
                    if (points == -1) break;
                    student.addTest(new Test(points));
                }

                schoolClass.addStudent(student);
            } else if (option == 2) {
                schoolClass.displayGrades();
            } else if (option == 3) {
                break;
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}