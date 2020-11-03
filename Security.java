package com.com_spidey;

class Security {
    public int validate(int enteredNumber)
    {
        int i;
        int n = Screen.customerCount;
        for(i=0; i<n; i++){
            if(Screen.accountNumber[i]==enteredNumber){
                System.out.println();
                System.out.println("Hello " + Screen.customerNames[i]);
                break;
            }
        }
        if(i<n){
            return 1;
        }
        else if(i==n){
            System.out.println("Invalid account number, Please try again.");
        }
        return 0;
    }
    public int validate(String enteredPIN){
        int enteredNumberPIN = Integer.parseInt(enteredPIN);
        int i;
        int n = Screen.customerCount;
        for(i=0; i<n; i++){
            if(Screen.pinNumber[i]==enteredNumberPIN){
                System.out.println("ABC Bank");
                break;
            }
        }
        if(i<n){
            return 1;
        }
        else if(i==n){
            System.out.println();
            System.out.println("Invalid PIN, Please try again.");
            System.out.println();
        }
        return 0;
    }
}
