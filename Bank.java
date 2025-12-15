import java.util.Scanner;

// Base class
class Account {
    String name;
    int accNo;
    String accType;
    double balance;

    Account(String name, int accNo, String accType, double balance) {
        this.name = name;
        this.accNo = accNo;
        this.accType = accType;
        this.balance = balance;
    }

    void deposit(double amt) {
        balance += amt;
        System.out.println("Deposit successful.");
    }

    void displayBalance() {
        System.out.println("Current Balance = " + balance);
    }
}

// Savings Account
class SavAcct extends Account {
    double rate = 0.05; // 5% interest

    SavAcct(String name, int accNo, double balance) {
        super(name, accNo, "Savings", balance);
    }

    void computeInterest() {
        double interest = balance * rate;
        balance += interest;
        System.out.println("Interest added: " + interest);
    }

    void withdraw(double amt) {
        if (amt <= balance) {
            balance -= amt;
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}

// Current Account
class CurAcct extends Account {
    double minBalance = 1000;
    double penalty = 100;

    CurAcct(String name, int accNo, double balance) {
        super(name, accNo, "Current", balance);
    }

    void withdraw(double amt) {
        if (amt <= balance) {
            balance -= amt;
            if (balance < minBalance) {
                balance -= penalty;
                System.out.println("Minimum balance not maintained.");
                System.out.println("Penalty imposed: " + penalty);
            }
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}

// Main class
public class Bank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose Account Type");
        System.out.println("1. Savings Account");
        System.out.println("2. Current Account");
        int choice = sc.nextInt();

        System.out.print("Enter Name: ");
        sc.nextLine();
        String name = sc.nextLine();

        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();

        int option;
        if (choice == 1) {
            SavAcct s = new SavAcct(name, accNo, balance);

            do {
                System.out.println("\n1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Compute Interest");
                System.out.println("4. Display Balance");
                System.out.println("5. Exit");
                option = sc.nextInt();

                switch (option) {
                    case 1:
                        System.out.print("Enter amount to deposit: ");
                        s.deposit(sc.nextDouble());
                        break;
                    case 2:
                        System.out.print("Enter amount to withdraw: ");
                        s.withdraw(sc.nextDouble());
                        break;
                    case 3:
                        s.computeInterest();
                        break;
                    case 4:
                        s.displayBalance();
                        break;
                }
            } while (option != 5);
        }
        else {
            CurAcct c = new CurAcct(name, accNo, balance);

            do {
                System.out.println("\n1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Display Balance");
                System.out.println("4. Exit");
                option = sc.nextInt();

                switch (option) {
                    case 1:
                        System.out.print("Enter amount to deposit: ");
                        c.deposit(sc.nextDouble());
                        break;
                    case 2:
                        System.out.print("Enter amount to withdraw: ");
                        c.withdraw(sc.nextDouble());
                        break;
                    case 3:
                        c.displayBalance();
                        break;
                }
            } while (option != 4);
        }

        sc.close();
    }
}
