import java.util.Scanner;
public class quadraticEquation{
    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);

        System.out.println("Enter a:");
        int a = sc.nextInt();

        System.out.println("Enter b:");
        int b = sc.nextInt();

        System.out.println("Enter c:");
        int c = sc.nextInt();

        double dis = ((b*b)-(4*a*c));

        if (dis>0){
            System.out.println("Roots are real and distinct:");
            double x = (-b + Math.sqrt(dis))/(2*a);
            double y = (-b - Math.sqrt(dis))/(2*a);
            System.out.println("Roots are " +x+ "and " +y);
        }

        else if ( dis==0){
            System.out.println("Roots are real and equal.");
            double x = (-b)/(2*a);
            System.out.println("Root of the equation is "+x);
         }

         else{
            System.out.println("Roots are imaginary");
        }

        sc.close();
    }
}