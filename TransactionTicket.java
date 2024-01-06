import java.io.*;
import java.util.*;
import java.time.*;

public class TransactionTicket {
    /*
public Calendar getDateOfTransaction(...)
public String getTransactionType(...)
public double getTransactionAmount(...)
public int gettermOfCD(...)

    */

 private Date transaction;
 private String type;
 private int acctNum;
 private Double amt;
 private String termsOfCD;

 // Parameterized Constructor
 TransactionTicket (Date transaction, String type, int acctNum, Double amt, String termsOfCD) {
     this.transaction = transaction;
     this.type = type;
     this.acctNum = acctNum;
     this.amt = amt;
     this.termsOfCD = termsOfCD;
 }
// Copy Constructor
 TransactionTicket(TransactionTicket t) {
     this.transaction = t.getDateOfTransaction();
     this.type = t.getTransactionType();
     this.acctNum = t.getAcctNumber();
     this.amt = t.getTransactionAmount();
     this.termsOfCD = t.getTermOfCD();
 }

 // getters
   public Date getDateOfTransaction() { 
    Calendar transaction = Calendar.getInstance();
        return(transaction.getTime());
       }  

    public String getTransactionType() {
       return (type); 
    }


    public int getAcctNumber() {
        return(acctNum);
    }

    public Double getTransactionAmount (){      
        return (amt);
    }

    public String getTermOfCD(){
        return(termsOfCD);
    }

}