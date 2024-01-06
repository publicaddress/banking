import java.io.*;
import java.util.*;
import java.text.*;


/*

*/
public class TransactionReceipt {

    Account account = new Account();
    ArrayList<String> receipts = new ArrayList<>();

//copy of TransactionTicket
public TransactionTicket getTransactionTicket(TransactionTicket t, String data) {
    Double balance = getPreTransactionBalance(data);
    Double postBalance = getPostTransactionBalance(balance, t.getTransactionAmount());
    String receipt = ("Transaction Type: " + t.getTransactionType() + "\nAccount Number: " + t.getAcctNumber() + "\nCurrent Balance: " + balance + "\nAmount of Transaction: " + t.getTransactionAmount() + "\nNew Balance: " + postBalance);
    receipts(data);
    return(t);
}

//stores receipts
public ArrayList<String> receipts (String data) {
    
    receipts.add(data);
    return (receipts);
}

//gets the balance of account prior to transaction
public Double getPreTransactionBalance(String data) {
    Double balance = account.getBalance(data);
    return(balance);
}

//gets the balance of the account after transaction
public Double getPostTransactionBalance(Double balance, Double amt) {
    Double postBalance = balance + amt;
    return(postBalance); 
}

}