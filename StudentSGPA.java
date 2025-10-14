//name - heenal tater, usn - 1BF24CS120
import java.util.Scanner;
class Student {
    String usn;
    String name;
    int[] credits;
    int[] marks;
    int numSub;

    void acceptDetails() 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter USN: ");
        usn = sc.nextLine();
        System.out.print("Enter Name: ");
        name = sc.nextLine();
        System.out.print("Enter number of subjects: ");
        numSub = sc.nextInt();
        credits = new int[numSub];
        marks = new int[numSub];
        for (int i = 0; i < numSub; i++) {
            System.out.print("Enter credits for subject " + (i + 1) + ": ");
            credits[i] = sc.nextInt();
            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
        }
    }
    double calculateSGPA() 
    {
        int totalCredits = 0;
        double weightedSum = 0.0;
        for (int i = 0; i < numSub; i++) 
        {
            int gradePoint = getGradePoint(marks[i]);
            weightedSum += gradePoint * credits[i];
            totalCredits += credits[i];
        }
        return weightedSum / totalCredits;
    }
    int getGradePoint(int marks)
    {
        if (marks >= 90)
        return 10;
        else if (marks >= 80)
        return 9;
        else if (marks >= 70)
        return 8;
        else if (marks >= 60)
        return 7;
        else if (marks >= 50)
        return 6;
        else if (marks >= 45)
        return 5;
        else if (marks >= 40)
        return 4;
        else
        return 0; 
    }
    void displayDetails()
    {
        System.out.println("USN: " + usn);
        System.out.println("Name: " + name);
        for (int i = 0; i < numSub; i++)
        {
            System.out.println("Subject " + (i + 1) + " -> Marks: " + marks[i] + ", Credits: "+ credits[i]);
        }
        double sgpa = calculateSGPA();
        System.out.printf("SGPA: %.2f\n", sgpa);
    }
}
public class StudentSGPA{
    public static void main(String[] args) {
        Student s = new Student();
        s.acceptDetails();
        s.displayDetails();
    }
}