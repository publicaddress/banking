import java.io.*;
import java.util.*;
import java.text.*;

public class CDAccount extends Account {

/*
The CDAccount class updates the maturity date of a CD account after any deposit, withdrawal, or check is cleared.
*/
   public static String maturityDate (int plus) {
    Calendar maturity = Calendar.getInstance(); //initialize the calendar with the time of the transaction

    if (plus == 6) {
        maturity.add(maturity.MONTH, 6);
    }
    if (plus == 12) {
        maturity.add(maturity.MONTH, 12);
    }
    if (plus == 18) {
        maturity.add(maturity.MONTH, 18);
    }
    if (plus == 24) {
        maturity.add(maturity.MONTH, 24);
    }

    String maturityDate = ((maturity.get(Calendar.MONTH) + 1) + "/" + maturity.get(Calendar.DATE) + "/" + maturity.get(Calendar.YEAR));
    return(maturityDate);
   } 
   
   public static String getAccount(String data, int plus) {
       String maturityDate = maturityDate(plus);
       String account = (Name(data) + " " + SSN(data) + " " + AcctNumber(data) + " " + AccountType(data) 
       + " " + getBalance(data) + " " + maturityDate);

       return (account);
   }


/*
checkDate() method is for Checking accounts clearing checks. 
It checks to make sure the date is not post-dated (in the future), or more than 6 months old.
*/
public static boolean checkMaturityDate(String date, PrintWriter outFile) throws ParseException{
    boolean permittedDate = true;
   
    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
    Date maturityDate = sdf.parse(date);
    Calendar c = Calendar.getInstance();
    Calendar c2 = Calendar.getInstance();
    c2.setTime(maturityDate);
        if(c2.after(c)) {
            outFile.println("Error: Maturity date has not been reached. Above transaction voided.\n");
            permittedDate = false;
        }
        else {
                permittedDate = true;
        }
    return (permittedDate);
} 

}