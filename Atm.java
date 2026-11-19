
import java.util.Scanner;

public class Atm{

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int correctPin = 1234;
        int enteredPin;
        int attempts = 0;
        boolean loggedIn = false;

        double balance = 5000;

        String[] history = new String[100];
        int count = 0;

        // PIN authentication
        while (attempts < 3) {

            System.out.print("Enter your PIN: ");
            enteredPin = input.nextInt();

            if (enteredPin == correctPin) {

                loggedIn = true;
                System.out.println("Login successful!");
                break;

            } else {

                attempts++;
                System.out.println("Incorrect PIN!");

                if (attempts < 3) {
                    System.out.println("Attempts remaining: " + (3 - attempts));
                }
            }
        }

        if (loggedIn == true) {

            int choice;

            do {

                System.out.println("\n===== ATM MENU =====");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit Money");
                System.out.println("3. Withdraw Money");
                System.out.println("4. Transaction History");
                System.out.println("5. Exit");

                System.out.print("Enter your choice: ");
                choice = input.nextInt();

                if (choice == 1) {

                    System.out.println("Current balance: " + balance);

                }

                else if (choice == 2) {

                    System.out.print("Enter deposit amount: ");
                    double amount = input.nextDouble();

                    if (amount > 0) {

                        balance = balance + amount;

                        history[count] = "Deposited: " + amount;
                        count++;

                        System.out.println("Deposit successful!");
                        System.out.println("New balance: " + balance);

                    } else {

                        System.out.println("Invalid amount!");

                    }

                }

                else if (choice == 3) {

                    System.out.print("Enter withdrawal amount: ");
                    double amount = input.nextDouble();

                    if (amount > 0 && amount <= balance) {

                        balance = balance - amount;

                        history[count] = "Withdrawn: " + amount;
                        count++;

                        System.out.println("Withdrawal successful!");
                        System.out.println("Remaining balance: " + balance);

                    } else {

                        System.out.println("Insufficient balance or invalid amount!");

                    }

                }

                else if (choice == 4) {

                    System.out.println("\n===== TRANSACTION HISTORY =====");

                    if (count == 0) {

                        System.out.println("No transactions yet.");

                    } else {

                        for (int i = 0; i < count; i++) {

                            System.out.println((i + 1) + ". " + history[i]);

                        }
                    }

                }

                else if (choice == 5) {

                    System.out.println("Thank you for using our ATM!");

                }

                else {

                    System.out.println("Invalid choice! Try again.");

                }

            } while (choice != 5);

        } else {

            System.out.println("Account blocked! Too many incorrect PIN attempts.");

        }

        input.close();
    }
}
