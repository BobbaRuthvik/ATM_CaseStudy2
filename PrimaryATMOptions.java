package com.com_spidey;

import java.util.Scanner;

interface PrimaryATMOptions {
    void banking();
    void balanceINQ();
    void transfer();
    void pinGeneration();
}

class Banking implements PrimaryATMOptions {
    private int TotalBalance = 200000;
    private String pin;
    Security db = new Security();
    Scanner input = new Scanner(System.in);
    public void banking() {
        if (entryStatements() == 1) {
            System.out.println("1. FROM CURRENT");
            System.out.println("2. FROM SAVING");
            int postSecondaryOption = input.nextInt();
            System.out.print("Please enter amount: ");
            int amount = input.nextInt();
            System.out.println("1. YES");
            System.out.println("2. NO");
            int finalConformation = input.nextInt();
            if (finalConformation == 1) {
                for (int i = 0; i < 100; i++) {
                    if (Screen.pinNumber[i] == Integer.parseInt(pin)) {
                        if(Screen.accountType[i]==postSecondaryOption){
                            float remainingAmount = Screen.balance[i] - amount;
                            if (amount <= 40000) {
                                if (TotalBalance > amount) {
                                    if (remainingAmount >= 0) {
                                        System.out.println("Remaining balance: ");
                                        Screen.balance[i] = remainingAmount;
                                        System.out.println(Screen.balance[i]);
                                        System.out.println("TRANSACTION COMPLETE.");
                                        TotalBalance = TotalBalance - amount;
                                    } else {
                                        System.out.println("INSUFFICIENT BALANCE.");
                                        System.out.println("TRANSACTION FAILED.");
                                    }
                                    System.out.println();
                                } else {
                                    System.out.println("INSUFFICIENT CASH IN ATM, PLEASE COME AGAIN SOME OTHER TIME.");
                                }
                            }
                            else {
                                System.out.println("EXCEEDING TRANSACTION LIMIT(<= 40000)");
                                System.out.println();
                            }
                        }
                        else {
                            System.out.println("INVALID ACCOUNT TYPE.");
                            System.out.println();
                        }
                    }
                }
            }
            else
                System.out.println("THANK YOU FOR OPTING ABC BANK.");
        }
    }
    public void balanceINQ(){
        if(entryStatements()==1){
            System.out.println("1. CREDIT");
            System.out.println("2. SAVINGS");
            int typeOfAccount = input.nextInt();
            for (int i = 0; i < 100; i++) {
                if (Screen.pinNumber[i] == Integer.parseInt(pin)) {
                    if (Screen.accountType[i] == typeOfAccount) {
                        System.out.println("AVAILABLE BALANCE: " + Screen.balance[i]);
                    }
                    else{
                        System.out.println("INVALID ACCOUNT TYPE.");
                        System.out.println();
                    }
                    break;
                }
            }
        }
    }
    public void transfer(){
        if(entryStatements()==1){
            System.out.println("1. CREDIT");
            System.out.println("2. SAVINGS");
            int typeOfAccount = input.nextInt();
            for (int i = 0; i < 100; i++) {
                if (Screen.pinNumber[i] == Integer.parseInt(pin)) {
                    if (Screen.accountType[i] == typeOfAccount) {
                        System.out.println("ENTER ACCOUNT NUMBER TO TRANSFER");
                        int accountNumber1 = input.nextInt();
                        System.out.println("RE-ENTER ACCOUNT NUMBER TO TRANSFER");
                        int accountNumber2 = input.nextInt();
                        if (accountNumber1 == accountNumber2) {
                            for(int j=0; j<100; j++){
                                if(Screen.accountNumber[j]==accountNumber1){
                                    if(Screen.accountType[i]==Screen.accountType[j]){
                                        System.out.print("ENTER AMOUNT TO TRANSFER: ");
                                        int transferAmount = input.nextInt();
                                        float isSufficientBalance = Screen.balance[i]-transferAmount;
                                        if(isSufficientBalance>=0){
                                            Screen.balance[j]=Screen.balance[j]+transferAmount;
                                            Screen.balance[i]=Screen.balance[i]-transferAmount;
                                            System.out.println("TRANSFER SUCCESSFUL");
                                        }
                                        else {
                                            System.out.println("BALANCE INSUFFICIENT");
                                            System.out.println("TRANSFER FAILED");
                                        }
                                    }
                                    else {
                                        System.out.println("RECEIVER MUST HAVE SAME ACCOUNT TYPE");
                                        System.out.println();
                                        break;
                                    }
                                }
                                else {
                                    continue;
                                }
                            }
                        }
                        else {
                            System.out.println("PLEASE ENTER SAME ACCOUNT NUMBER");
                            System.out.println();
                            break;
                        }
                    }
                    else{
                        System.out.println("INVALID ACCOUNT TYPE CHOSEN");
                        System.out.println();
                    }
                    break;
                }
            }
        }
    }
    public void pinGeneration(){
        System.out.print("ENTER ACCOUNT NUMBER: ");
        int accountNumber = input.nextInt();
        for(int i=0; i<100; i++){
            if(accountNumber==Screen.accountNumber[i]){
                if(Screen.pinNumber[i]==0){
                    System.out.println("Dear Customer, ABC Bank appreciates, you for the Green Initiative. PIN shall be delivered to your registered mobile number.");
                    System.out.println("1. CONFIRM");
                    System.out.println("2. CANCEL");
                    int optionOpted = input.nextInt();
                    if (optionOpted==1){
                        int randomPIN = (int)Math.floor(Math.random()*10000);
                        Screen.pinNumber[i]=randomPIN;
                        System.out.println();
                        System.out.println("PIN generation is successful");
                        System.out.println("You will receive you PIN shortly through registered mobile number.");
                        System.out.println();
                        System.out.println("Please change your PIN without which you will not be allowed to do any transaction.");
                        System.out.println();
                        System.out.println("/**** MOBILE INTERFACE ****/");
                        System.out.println("ABC Banks PIN Changed to "+Screen.pinNumber[i]+" for Account Number "+Screen.accountNumber[i]+ ".");
                        System.out.println();
                    }
                    else{
                        System.out.println("THANK YOU FOR OPTING ABC BANK.");         // check its functioning
                        break;
                    }
                }
                else if(Screen.accountNumber[i]==accountNumber){
                    System.out.println("Dear Customer, Would you like to change your PIN? PIN shall be delivered to your registered mobile number.");
                    System.out.println("1. CONFIRM");
                    System.out.println("2. CANCEL");
                    int optionOpted = input.nextInt();
                    if (optionOpted==1){
                        System.out.print("Enter new PIN: ");
                        int PINchanged = input.nextInt();
                        System.out.print("Re-enter new PIN: ");
                        int PINchanged1 = input.nextInt();
                        if(PINchanged==PINchanged1){
                            Screen.pinNumber[i]=PINchanged;
                            System.out.println();
                            System.out.println("PIN generation is successful");
                            System.out.println("You will receive you PIN shortly through registered mobile number.");
                            System.out.println();
                            System.out.println("/**** MOBILE INTERFACE ****/");
                            System.out.println("ABC Banks PIN Changed to "+Screen.pinNumber[i]+" for Account Number "+Screen.accountNumber[i]+ ".");
                            System.out.println();
                        }
                    }
                }
            }
        }
    }
    private int entryStatements(){
        while (true){
            System.out.println("ENTER ANY NUMBER BETWEEN 10 AND 99");
            System.out.println("For eg. \"25\"");
            int checkNumber = input.nextInt();
            if(checkNumber>=10&&checkNumber<=99){
                break;
            }
            else {
                System.out.println();
                System.out.println("PLEASE ENSURE THE NUMBER IS FROM 10 TO 99");
                System.out.println();
            }
        }
        int getUserConformation;
        while (true){
            System.out.println("IS THE NUMBER DISPLAYED ON THE SCREEN ?");
            System.out.println("1. YES");
            System.out.println("2. NO");
            getUserConformation = input.nextInt();
            if(getUserConformation==1||getUserConformation==2)
                break;
            else{
                System.out.println();
                System.out.println("PLEASE SELECT EITHER 1 OR 2");
                System.out.println();
            }
        }
        if (getUserConformation == 1) {
            System.out.println("ABC Bank");
            System.out.print("Please enter your PIN: ");
            pin = input.next();
            return db.validate(pin);
        }
        else{
            System.out.println("ATM MACHINE IS NOT WORKING, PLEASE COME AGAIN LATER.");
            System.out.println();
        }
        return 0;
    }
}
