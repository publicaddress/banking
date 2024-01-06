import java.io.*;
import java.util.*;


public class Account {

    /*
    MISSING: 
    public ArrayList<TransactionReceipt> getTransactionHistory(TransactionTicket...)
    public void addTransaction(TransactionReceipt...)
    */
     
     String accountType;
     boolean accountStatus;


//creates a transaction receipt for balance transactions, and adds the receipt to transactionHistory ArrayList
public TransactionReceipt getBalanceTransaction(TransactionTicket t, ArrayList<String> transactionHistory, String data, PrintWriter outFile) {
    TransactionReceipt receipt = new TransactionReceipt();
    
    String newReceipt = (SSN(data) + "\n" + t.getDateOfTransaction() + "\nTransaction Type: Balance Inquiry\nAccount Number: " + t.getAcctNumber() + "\nCurrent Balance: $" + receipt.getPreTransactionBalance(data) + "\n");
    transactionHistory.add(newReceipt);

    newReceipt = (t.getDateOfTransaction() + "\nTransaction Type: Balance Inquiry\nAccount Number: " + t.getAcctNumber() + "\nCurrent Balance: $" + receipt.getPreTransactionBalance(data) + "\n");
    outFile.println(newReceipt);

    return (receipt);
}

//creates a transaction receipt for deposits and adds the receipt to transactionHistory ArrayList
public TransactionReceipt makeDeposit(TransactionTicket t, ArrayList<String> transactionHistory, String data, boolean flag, PrintWriter outFile) {
   String newReceipt; 
    TransactionReceipt receipt = new TransactionReceipt();
    
    if (flag) {
    newReceipt = (SSN(data) + "\n" + t.getDateOfTransaction() + "\nTransaction Type: Deposit\nAccount Number: " + t.getAcctNumber() + "\nCurrent Balance: $" + receipt.getPreTransactionBalance(data) + "\nAmount to Deposit: $" + t.getTransactionAmount() + "\nNew Balance: $" + receipt.getPostTransactionBalance(receipt.getPreTransactionBalance(data), t.getTransactionAmount()) + "\n");
    transactionHistory.add(newReceipt);

    newReceipt = (t.getDateOfTransaction() + "\nTransaction Type: Deposit\nAccount Number: " + t.getAcctNumber() + "\nCurrent Balance: $" + receipt.getPreTransactionBalance(data) + "\nAmount to Deposit: $" + t.getTransactionAmount() + "\nNew Balance: $" + receipt.getPostTransactionBalance(receipt.getPreTransactionBalance(data), t.getTransactionAmount()) + "\n");
    outFile.println(newReceipt);
    }
    else {
        newReceipt = (SSN(data) + "\n" + t.getDateOfTransaction() + "\nTransaction Type: Deposit\nAccount Number: " + t.getAcctNumber() + "\nCurrent Balance: $" + receipt.getPreTransactionBalance(data) + "\nAmount to Deposit: $" + t.getTransactionAmount() + "\nError: Invalid Deposit Amount. Transaction voided.\n");
        transactionHistory.add(newReceipt);
    
        newReceipt = (t.getDateOfTransaction() + "\nTransaction Type: Deposit\nAccount Number: " + t.getAcctNumber() + "\nCurrent Balance: $" + receipt.getPreTransactionBalance(data) + "\nAmount to Deposit: $" + t.getTransactionAmount() + "\nError: Invalid Deposit Amount. Transaction voided.\n");
        outFile.println(newReceipt); 
    }
    return (receipt);
}

//creates a transaction receipt for withdrawals and adds the receipt to transactionHistory ArrayList
public TransactionReceipt makeWithdrawal(TransactionTicket t, ArrayList<String> transactionHistory, String data, boolean flag, PrintWriter outFile) {
String newReceipt;
    TransactionReceipt receipt = new TransactionReceipt();
    
 if (flag) {   
    newReceipt = (SSN(data) + "\n" + t.getDateOfTransaction() + "\nTransaction Type: Withdrawal\nAccount Number: " + t.getAcctNumber() + "\nCurrent Balance: $" + receipt.getPreTransactionBalance(data) + "\nAmount to Withdraw: $" + t.getTransactionAmount() + "\nNew Balance: $" + receipt.getPostTransactionBalance(receipt.getPreTransactionBalance(data), t.getTransactionAmount()) + "\n");
    transactionHistory.add(newReceipt);

    newReceipt = (t.getDateOfTransaction() + "\nTransaction Type: Withdrawal\nAccount Number: " + t.getAcctNumber() + "\nCurrent Balance: $" + receipt.getPreTransactionBalance(data) + "\nAmount to Withdraw: $" + t.getTransactionAmount() + "\nNew Balance: $" + receipt.getPostTransactionBalance(receipt.getPreTransactionBalance(data), t.getTransactionAmount()) + "\n");
    outFile.println(newReceipt);
 }
 else {
    newReceipt = (SSN(data) + "\n" + t.getDateOfTransaction() + "\nTransaction Type: Withdrawal\nAccount Number: " + t.getAcctNumber() + "\nCurrent Balance: $" + receipt.getPreTransactionBalance(data) + "\nAmount to Withdraw: $" + t.getTransactionAmount() * - 1 + "\nError: Invalid Withdrawal Amount - Transaction voided\n");
    transactionHistory.add(newReceipt);

    newReceipt = (t.getDateOfTransaction() + "\nTransaction Type: Withdrawal\nAccount Number: " + t.getAcctNumber() + "\nCurrent Balance: $" + receipt.getPreTransactionBalance(data) + "\nAmount to Withdraw: $" + t.getTransactionAmount() * - 1 + "\nError: Invalid Withdrawal Amount - Transaction voided\n");
    outFile.println(newReceipt);
 }
    return (receipt);
}

//creates a transaction receipt for check clears and adds the receipt to transactionHistory ArrayList
public TransactionReceipt clearCheck(TransactionTicket t, ArrayList<String> transactionHistory, String data, boolean flag, PrintWriter outFile) {
    String newReceipt;
    TransactionReceipt receipt = new TransactionReceipt();
    
 if (flag) {   
    newReceipt = (SSN(data) + "\n" + t.getDateOfTransaction() + "\nTransaction Type: Withdrawal\nAccount Number: " + t.getAcctNumber() + "\nCurrent Balance: $" + receipt.getPreTransactionBalance(data) + "\nAmount to Withdraw: $" + t.getTransactionAmount() + "\nNew Balance: $" + receipt.getPostTransactionBalance(receipt.getPreTransactionBalance(data), t.getTransactionAmount()) + "\n");
    transactionHistory.add(newReceipt);

    newReceipt = (t.getDateOfTransaction() + "\nTransaction Type: Withdrawal\nAccount Number: " + t.getAcctNumber() + "\nCurrent Balance: $" + receipt.getPreTransactionBalance(data) + "\nAmount to Withdraw: $" + t.getTransactionAmount() + "\nNew Balance: $" + receipt.getPostTransactionBalance(receipt.getPreTransactionBalance(data), t.getTransactionAmount()) + "\n");
    outFile.println(newReceipt);
 }
 else {
    newReceipt = (SSN(data) + "\n" + t.getDateOfTransaction() + "\nTransaction Type: Withdrawal\nAccount Number: " + t.getAcctNumber() + "\nCurrent Balance: $" + receipt.getPreTransactionBalance(data) + "\nAmount to Withdraw: $" + t.getTransactionAmount() * - 1 + "\nError: Invalid Deposit Amount - Transaction voided\n");
    transactionHistory.add(newReceipt);

    newReceipt = (t.getDateOfTransaction() + "\nTransaction Type: Withdrawal\nAccount Number: " + t.getAcctNumber() + "\nCurrent Balance: $" + receipt.getPreTransactionBalance(data) + "\nAmount to Withdraw: $" + t.getTransactionAmount() * - 1 + "\nError: Invalid Deposit Amount - Transaction voided\n");
    outFile.println(newReceipt);
 }
    return (receipt);
}

//creates a transaction receipt for closing of account, and adds that receipt to the transactionHistory ArrayList
public TransactionReceipt closeAcct(TransactionTicket t, ArrayList<String> transactionHistory, String data, PrintWriter outFile) {

    TransactionReceipt receipt = new TransactionReceipt();
    
    String newReceipt = (SSN(data) + "\n" + t.getDateOfTransaction() + "\nTransaction Type: Close Account\nAccount Number: " + t.getAcctNumber() + "\nEnding Balance: $" + receipt.getPreTransactionBalance(data) + "\n");
    transactionHistory.add(newReceipt);

    newReceipt = (t.getDateOfTransaction() + "\nTransaction Type: Close Account\nAccount Number: " + t.getAcctNumber() + "\nEnding Balance: $" + receipt.getPreTransactionBalance(data) + "\n");
    outFile.println(newReceipt);

    return (receipt);
}

//creates a transaction receipt for reopening of account, and adds that receipt to the transactionHistory ArrayList
public TransactionReceipt reopenAcct(TransactionTicket t, ArrayList<String> transactionHistory, String data, PrintWriter outFile) {
    TransactionReceipt receipt = new TransactionReceipt();
    
    String newReceipt = (SSN(data) + "\n" + t.getDateOfTransaction() + "\nTransaction Type: Reopen Account\nAccount Number: " + t.getAcctNumber() + "\nInitial Balance: $" + receipt.getPreTransactionBalance(data) + "\n");
    transactionHistory.add(newReceipt);

    newReceipt = (t.getDateOfTransaction() + "\nTransaction Type: Reopen Account\nAccount Number: " + t.getAcctNumber() + "\nInitial Balance: $" + receipt.getPreTransactionBalance(data) + "\n");
    outFile.println(newReceipt);

    return (receipt);
}

//formats all account info from methods below
     public static String getAccount(String data) {
        String account = (Name(data) + " " + SSN(data) + " " + AcctNumber(data) + " " + AccountType(data) 
            + " " + getBalance(data));

        return(account);
     }

//gets the Name from an account line from database  
    public static String Name (String data) {   
        String[] subs = data.split(" ", 0);
        String name = (subs[0] + " " + subs[1]);
        return(name);
    }

//gets the SSN from an account line from database 
    public static int SSN (String data) {
        String[] subs = data.split(" ", 0);
        int SSN = Integer.parseInt(subs[2]);

        return(SSN);
    }

//returns the account number from an account line from database
    public static int AcctNumber (String data) {
        String[] subs = data.split(" ", 0);
        int accountNumber = Integer.parseInt(subs[3]);

        return(accountNumber);
    }

//returns the account type from an account line from database
     public static String AccountType (String data) {
        String[] subs = data.split(" ", 0);
        String accountType = (subs[4]);

        return(accountType);
    }
 
//returns the balance from the account line from database
     public static Double getBalance (String data) {
        String[] subs = data.split(" ", 0);
        Double accountBalance = Double.parseDouble(subs[5]);

        return(accountBalance);
    }

//gets the terms of CD account from the account line from database, if none exist - it returns "N/A"
    public static String getTermsOfCD (String data) {
        String[] subs = data.split(" ", 0);
        String terms;
        if(subs.length > 6) {
           terms = (subs[6]);
        }
        else {
            terms = "N/A";
        }
        return(terms);
    }

 

//gets the final status of all accounts (OPEN or CLOSED)
public static ArrayList<String> Status (Bank bank, PrintWriter outFile, ArrayList<String> a) {
          ArrayList<String> updatedArray = new ArrayList<String>(); 
        for (int i = 0; i < a.size(); i++){
            String data = a.get(i);
            String[] subs = data.split(" ", 0);
            String accountType = subs[4];
            if (accountType.equals("CD")) {
                     if (subs.length == 8) { 
                        updatedArray.add(data);
                    }   
                    else if (subs.length == 7){
                        data = (data + " OPEN");
                        updatedArray.add(data);             
                    }
            }
            else if (accountType.equals("Savings") || accountType.equals("Checking")) {
                    if (subs.length == 7) { 
                        updatedArray.add(data);
                    }
                    else if (subs.length == 6) {
                        data = (data + " OPEN");
                        updatedArray.add(data);             
                    }
            }
    }
    return(updatedArray);
}

//updates the status of an account after closing or opening
public static String updateStatus (Bank bank, PrintWriter outFile, String data, int flag) {
        String account = getAccount(data);
        
            if (flag == -1) {
                account = (account + " OPEN"); 
            }

            else if (flag == 0) {
                account = (account + " CLOSED");
         
            }
            return(account);
        }
        
//getStatus() sends a boolean flag to the main program to see if account is opened or closed, if the account is closed, no transactions will be allowed
public static boolean getStatus (String account) {
    boolean flag = true;
    String[] subs = account.split(" ", 0);
    int end = subs.length - 1;
    String status = subs[end];
    if(status.equals("CLOSED")){
        flag = false;
    }
    return(flag);
}   
}