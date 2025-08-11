import java.util.ArrayList;
import java.util.Scanner;

class Account {
    String name;
    double balance;
    ArrayList<String> history = new ArrayList<>();

    Account(String name, double balance) {
        this.name = name;
        this.balance = balance;
        history.add("Account opened with $" + balance);
    }

    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            history.add("Deposited $" + amount + " | Balance: $" + balance);
            System.out.println("Deposit successful!");
        } else {
            System.out.println("Amount must be positive.");
        }
    }

    void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            history.add("Withdrew $" + amount + " | Balance: $" + balance);
            System.out.println("Withdrawal successful!");
        } else {
            System.out.println("Invalid amount or insufficient funds.");
        }
    }

    void showHistory() {
        System.out.println("\nTransaction History:");
        for (String h : history) {
            System.out.println(h);
        }
    }
}

public class BankAccountSimulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create account
        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter starting balance: ");
        double balance = sc.nextDouble();

        Account acc = new Account(name, balance);

        // Menu
        while (true) {
            System.out.println("\n1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Show History");
            System.out.println("4. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter deposit amount: ");
                double amt = sc.nextDouble();
                acc.deposit(amt);
            } else if (choice == 2) {
                System.out.print("Enter withdrawal amount: ");
                double amt = sc.nextDouble();
                acc.withdraw(amt);
            } else if (choice == 3) {
                acc.showHistory();
            } else if (choice == 4) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}
