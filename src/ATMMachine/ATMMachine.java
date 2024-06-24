package ATMMachine;

import java.util.Scanner;

class ATM
{
    float balance;
    int PIN = 1234;

    public void checkPin()
    {
        System.out.print("Enter your PIN: ");
        Scanner sc = new Scanner(System.in);
        int enterPin = sc.nextInt();

        if (enterPin == PIN)
        {
            menu();
        }
        else {
            System.out.println("Enter the valid PIN");
            checkPin();
        }
    }

    public void menu()
    {
        System.out.println();
        System.out.println("Enter your choice: ");
        System.out.println("1. Check A/C balance");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Deposit Money");
        System.out.println("4. EXIT");

        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();

        if (option == 1)
        {
            checkBalance();
        }
        else if (option == 2)
        {
            withDrawMoney();
        }
        else if (option == 3)
        {
            depositMoney();
        }
        else if (option == 4)
        {
            System.out.println("Thanks for using our service");
            return;
        }
        else{
            System.out.println("Enter the valid option");
        }
    }

    public void checkBalance()
    {
        System.out.println("Balance: " + balance);
        menu();
    }

    public void withDrawMoney()
    {
        System.out.print("Enter the amount: ");
        Scanner sc = new Scanner(System.in);
        int enterAmount = sc.nextInt();

        if (enterAmount > balance)
        {
            System.out.println("Insufficient Balance");
            menu();
        }
        else {
            balance = balance - enterAmount;
            System.out.println("Amount WithDraw Successfully");
            menu();
        }
    }

    public void depositMoney()
    {
        System.out.print("Enter the amount: ");
        Scanner sc = new Scanner(System.in);
        int enterAmount = sc.nextInt();

        balance = balance + enterAmount;
        System.out.println("Amount Deposited Successfully");
        menu();
    }
}

public class ATMMachine
{
    public static void main(String[] args)
    {
        ATM object = new ATM();
        object.checkPin();
    }
}