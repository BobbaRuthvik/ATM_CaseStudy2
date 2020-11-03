package com.com_spidey;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Manager{

    protected final String password = "abc123";
    Scanner input = new Scanner(System.in);

    FileWriter customerData;

    {
        try {
            customerData = new FileWriter("CustomerData.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            customerData.write("S.no. Customer name    Account number  Account type   Balance");
            customerData.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    void system(){
        System.out.println("/**** MANAGER'S COMPUTER ****/");
        int i ;
        for(i=0; i<5; i++){
            System.out.println("Username: ABC Bank Manager");
            System.out.print("Password: ");
            String passwordCheck = input.next();
            if(passwordCheck.equals(password)){
                System.out.println("Enter 1 to add accounts and 2 to get customer details.");
                int managerOptedOptions = input.nextInt();
                if(managerOptedOptions==1)
                    addAccount();
                else if(managerOptedOptions==2)
                    customerAccountDetails();
                break;
            }
            else
                System.out.println("Try again, " + (4-i) + " chances left.");
        }
        if(i==5)
            System.out.println("Sorry, please try again later.");
    }
    private void addAccount(){
        int n = Screen.customerCount;
        System.out.print("Enter customer's full name: ");
        input.nextLine();
        String name = input.nextLine();
        Screen.customerNames[n]=name;
        System.out.print("Enter customer's account number: ");
        int accountNumber = input.nextInt();
        Screen.accountNumber[n]=accountNumber;
        System.out.println("Enter account type: ");
        System.out.println("1. Current");
        System.out.println("2. Savings");
        int accountType = input.nextInt();
        Screen.accountType[n]=accountType;
        System.out.print("Enter balance: ");
        int balance = input.nextInt();
        Screen.balance[n]=balance;
        Screen.customerCount++;
    }
    private void customerAccountDetails(){
        int n = Screen.customerCount;
        System.out.println();
        System.out.println("Saved in file named CustomerData.txt");
        System.out.println();
        for(int i=0; i<n; i++){
            String r = String.valueOf(Screen.accountNumber[i]);
            String s = String.valueOf(Screen.balance[i]);
            int t = Screen.accountType[i];
            String tp;
            if(t==1)
                tp = "Current";
            else
                tp = "Savings";
            try {
                customerData.append(String.valueOf(i+1));
                customerData.append("     ");
                customerData.append(Screen.customerNames[i]);
                customerData.append("     ");
                customerData.append(r);
                customerData.append("           ");
                customerData.append(tp);
                customerData.append("         ");
                customerData.append(s);
                customerData.append("\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            customerData.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
