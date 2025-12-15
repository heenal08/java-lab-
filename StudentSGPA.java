import java.util.Scanner;

class Student {
    String usn;
    String name;
    int[] credits;
    int[] marks;
    int n;

    // Accept student details
    void accept() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter USN: ");
        usn = sc.nextLine();

        System.out.print("Enter Name: ");
        name = sc.nextLine();

        System.out.print("Enter number of subjects: ");
        n = sc.nextInt();

        credits = new int[n];
        marks = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter credits for subject " + (i + 1) + ": ");
            credits[i] = sc.nextInt();

            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
        }
    }

    // Convert marks to grade points
    int gradePoint(int m) {
        if (m >= 90) return 10;
        else if (m >= 80) return 9;
        else if (m >= 70) return 8;
        else if (m >= 60) return 7;
        else if (m >= 50) return 6;
        else return 0;
    }

    // Calculate SGPA
    double calculateSGPA() {
        int totalCredits = 0;
        int totalPoints = 0;

        for (int i = 0; i < n; i++) {
            totalPoints += credits[i] * gradePoint(marks[i]);
            totalCredits += credits[i];
        }
        return (double) totalPoints / totalCredits;
    }

    // Display details
    void display() {
        System.out.println("\nUSN: " + usn);
        System.out.println("Name: " + name);
        System.out.println("SGPA: " + calculateSGPA());
    }
}

public class StudentSGPA {
    public static void main(String[] args) {
        Student s = new Student();
        s.accept();
        s.display();
    }
}
