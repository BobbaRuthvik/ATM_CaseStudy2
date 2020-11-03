package com.com_spidey;

import java.util.Scanner;

class Screen{
    static int customerCount;
    static String[] customerNames = new String[100];
    static int[] accountNumber = new int[100];
    static int[] pinNumber = new int[100];
    static int[] accountType = new int[100];
    static float[] balance = new float[100];
    PrimaryATMOptions op = new Banking();
    Security customer = new Security();
    Scanner input = new Scanner(System.in);
    public void run(){
        customerNames[0] = "BILLY STUMPS";
        accountNumber[0] = 12345;
        pinNumber[0] = 5432;
        accountType[0] = 2;
        balance[0] = 50000;

        customerNames[1] = "BOOM McCONDOR";
        accountNumber[1] = 67890;
        pinNumber[1] = 1023;
        accountType[1] = 2;
        balance[1] = 40000;

        customerNames[2] = "BOBBA RUTHVIK";
        accountNumber[2] = 11111;
        pinNumber[2] = 2222;
        accountType[2] = 1;
        balance[2] = 80000;

        customerNames[3] = "ROCK CALLAHAN";
        accountNumber[3] = 10001;
        pinNumber[3] = 1001;
        accountType[3] = 2;
        balance[3] = 60000;

        customerCount = 4;
        while (true) {
            System.out.println("Enter 1 if you are a customer, 2 for manager system any other to exit");
            int optedOption = input.nextInt();
            int checkAccountNumber;
            if (optedOption == 1) {
                do {
                    System.out.println();
                    System.out.println("Welcome to ABC ATM services");
                    System.out.print("Please enter your account number: ");
                    int accountNumber = input.nextInt();
                    checkAccountNumber = customer.validate(accountNumber);
                } while (checkAccountNumber == 0);
                int optionChoosenByCustomer = 0;
                if (checkAccountNumber == 1) {
                    boolean run2 = true;
                    while (run2) {
                        System.out.println("PLEASE CHOOSE \"BANKING\" FOR CASH \"WITHDRAWALS\"");
                        System.out.println("1. BANKING");
                        System.out.println("2. BALANCE INQ");
                        System.out.println("3. TRANSFER");
                        System.out.println("4. PIN GENERATION");
                        optionChoosenByCustomer = input.nextInt();
                        if (optionChoosenByCustomer > 0 && optionChoosenByCustomer < 5)
                            run2 = false;
                        else
                            System.out.println("Enter input from 1 to 4");
                    }
                    switch (optionChoosenByCustomer) {
                        case 1:
                            op.banking();
                            break;
                        case 2:
                            op.balanceINQ();
                            break;
                        case 3:
                            op.transfer();
                            break;
                        case 4:
                            op.pinGeneration();
                            break;
                        default:
                            System.out.println("Invalid");
                    }
                }
            }
            else if (optedOption == 2) {
                Manager mn = new Manager();
                mn.system();
            }
            else
                break;
        }
    }
}
