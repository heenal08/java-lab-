import CIE.*;
import SEE.*;
import java.util.Scanner;

public class FinalMarks {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            System.out.println("\nEnter details of Student " + (i + 1));

            System.out.print("USN: ");
            String usn = sc.next();

            System.out.print("Name: ");
            String name = sc.next();

            System.out.print("Semester: ");
            int sem = sc.nextInt();

            External student = new External(usn, name, sem);
            Internals internal = new Internals();

            int[] im = new int[5];
            int[] em = new int[5];

            System.out.println("Enter Internal Marks (5 subjects):");
            for (int j = 0; j < 5; j++) {
                im[j] = sc.nextInt();
            }

            System.out.println("Enter SEE Marks (5 subjects):");
            for (int j = 0; j < 5; j++) {
                em[j] = sc.nextInt();
            }

            internal.setInternals(im);
            student.setSEE(em);

            System.out.println("\nFinal Marks:");
            for (int j = 0; j < 5; j++) {
                int finalMarks = internal.internalMarks[j] + student.seeMarks[j];
                System.out.println("Subject " + (j + 1) + " = " + finalMarks);
            }
        }

        sc.close();
    }
}
