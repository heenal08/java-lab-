import java.util.Scanner;
// User-defined exception
class WrongAge extends Exception {
    public WrongAge(String msg) {
        super(msg);
    }
}
// Base class
class Father {
    int fatherAge;

    Father(int age) throws WrongAge {
        if (age < 0) {
            throw new WrongAge("Father's age cannot be negative");
        }
        fatherAge = age;
    }
}
// Derived class
class Son extends Father {
    int sonAge;
    Son(int fAge, int sAge) throws WrongAge {
        super(fAge);  // call Father constructor
        if (sAge >= fAge) {
            throw new WrongAge("Son's age cannot be greater than or equal to Father's age");
        }
        sonAge = sAge;
    }
}
// Main class
public class InheritanceExceptionDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter Father's age: ");
            int fAge = sc.nextInt();
            System.out.print("Enter Son's age: ");
            int sAge = sc.nextInt();
            Son s = new Son(fAge, sAge);
            System.out.println("Father's Age: " + s.fatherAge);
            System.out.println("Son's Age: " + s.sonAge);
            System.out.println("Object created successfully.");
        } catch (WrongAge e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
        sc.close();
    }
}
