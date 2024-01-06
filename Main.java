import java.io.*;
import java.util.*;
import java.text.*;


/*

*/
public class Main {


/*
The main method initializes scanners for input and output, then created different ArrayLists needed to initialize and carry / update the account data from the files. Instances of the Bank and Account class are created, and then the program prints out the initial account info for all accounts to the "prgmOutput.txt" file.

Then the method initalizes a keyboard input, prints the menu to the console, and selects which methods to use based on user input.

*/
	public static void main(String [] args) throws ParseException {      
        Scanner acctScan = null;
        PrintWriter transOut = null;
        PrintWriter pgmOutput = null;
       
           try {
                acctScan = new Scanner(new File("initAccounts.txt"));
                transOut = new PrintWriter(new FileWriter("myTestCases.txt"));
                pgmOutput = new PrintWriter(new FileWriter("prgmOutput.txt"));
            }
            catch(FileNotFoundException e) {
                System.out.println("Could not find file.");
            }
            catch(IOException ex){
                System.out.println("Could not find file. IO Exception."); 
            }
            
            Bank bank = new Bank(); 
            Account acct = new Account();
            ArrayList<String> initData = readAccts(bank, acctScan);  
            ArrayList<String> data = new ArrayList<>();
            ArrayList<String> transactionHistory = new ArrayList<>();
            ArrayList<Integer> sortKeyInt = new ArrayList<Integer>();
            ArrayList<String> sortKeyString = new ArrayList<String>();
            ArrayList<Double> sortKeyDouble = new ArrayList<Double>();

            SortingAlgos<Integer> sortInt = new SortingAlgos<Integer>();
            SortingAlgos<String> sortString = new SortingAlgos<String>();
            SortingAlgos<Double> sortDouble = new SortingAlgos<Double>();
           

            for(int i = 0; i < initData.size(); i++) {
                String input = initData.get(i);
                data.add(input);
            } 
 
            pgmOutput.println("Initial Account Info: \n");
            printAccts(bank, data, pgmOutput);

            /*
The initial database of Accounts should also be printed as follows:
a.1) sorted by account number (using a Generic QuickSort Algorithm - using sort key acctNumQuickSortKey)
a.2) sorted by account number (using a Generic Bubble Sort Algorithm - using sort key acctNumBubbleSortKey)
a.3) sorted by account number (using a Generic Insertion Sort Algorithm - sort key acctNumInsertionSortKey)
b.1) sorted by SSN (using a Generic QuickSort Algorithm - using sort key ssnQuickSortKey)
b.2) sorted by SSN (using a Generic Bubble Sort Algorithm - using sort key ssnBubbleSortKey)
b.3) sorted by SSN (using a Generic Insertion Sort Algorithm - using sort key ssnInsertionSortKey)
c.1) sorted by Name (using a Generic QuickSort Algorithm - using sort key nameQuickSortKey)
c.2) sorted by Name (using a Generic Bubble Sort Algorithm - using sort key nameBubbleSortKey)
c.3) sorted by Name (using a Generic Insertion Sort Algorithm - using sort key nameInsertionSortKey)
d.1) sorted by Balance (using a Generic QuickSort Algorithm - using sort key balanceQuickSortKey)
d.2) sorted by Balance (using a Generic Bubble Sort Algorithm - using sort key balanceBubbleSortKey)
d.3) sorted by Balance (using a Generic Insertion Sort Algorithm - using sort key balanceInsertionSortKey)
*/
String sortType;
pgmOutput.println("\nUnsorted Accounts: \n");
printAccts(bank, data, pgmOutput);
data = acct.Status(bank, pgmOutput, data);
 
sortKeyInt = bank.acctNumQuickSortKey(initData);
pgmOutput.println("\nSorted by Account Number-----");
sortType = "Quick Sort: ";
sortInt.quickSort(sortKeyInt, 0, (sortKeyInt.size() - 1)); // QuickSort the array of Sort Keys 
printAcctsByAcctNumSortKey(bank, sortKeyInt, data, pgmOutput, sortType);

sortKeyInt = bank.acctNumBubbleSortKey(initData);
sortType = "Bubble Sort: ";
sortInt.bubbleSort(sortKeyInt);
printAcctsByAcctNumSortKey(bank, sortKeyInt, data, pgmOutput, sortType);

sortKeyInt = bank.acctNumInsertionSortKey(initData);
sortType = "Insertion Sort: ";
sortInt.insertionSort(sortKeyInt);
printAcctsByAcctNumSortKey(bank, sortKeyInt, data, pgmOutput, sortType);

pgmOutput.println("\nSorted by Social Security Number-----");
sortKeyInt = bank.ssnQuickSortKey(initData);
sortType = "Quick Sort: ";
sortInt.quickSort(sortKeyInt, 0, (sortKeyInt.size() - 1));
printAcctsBySSNSortKey(bank, sortKeyInt, data, pgmOutput, sortType);

sortKeyInt = bank.ssnQuickSortKey(initData);
sortType = "Bubble Sort: ";
sortInt.bubbleSort(sortKeyInt);
printAcctsBySSNSortKey(bank, sortKeyInt, data, pgmOutput, sortType);

sortKeyInt = bank.ssnInsertionSortKey(initData);
sortType = "Insertion Sort: ";
sortInt.insertionSort(sortKeyInt);
printAcctsBySSNSortKey(bank, sortKeyInt, data, pgmOutput, sortType);

pgmOutput.println("\nSorted Alphabetically by Name-----");
sortKeyString = bank.nameQuickSortKey(initData);
sortType = "Quick Sort: ";
sortString.quickSort(sortKeyString, 0, (sortKeyString.size() - 1));
printAcctsByNameSortKey(bank, sortKeyString, data, pgmOutput, sortType);

sortKeyString = bank.nameBubbleSortKey(initData);
sortType = "Bubble Sort: ";
sortString.bubbleSort(sortKeyString);
printAcctsByNameSortKey(bank, sortKeyString, data, pgmOutput, sortType);

sortKeyString = bank.nameInsertionSortKey(initData);
sortType = "Insertion Sort: ";
sortString.insertionSort(sortKeyString);
printAcctsByNameSortKey(bank, sortKeyString, data, pgmOutput, sortType);

pgmOutput.println("\nSorted by Account Balance-----");
sortKeyDouble = bank.balanceQuickSortKey(initData);
sortType = "Quick Sort: ";
sortDouble.quickSort(sortKeyDouble, 0, sortKeyDouble.size() - 1);
printAcctsByBalanceSortKey(bank, sortKeyDouble, data, pgmOutput, sortType);

sortKeyDouble = bank.balanceBubbleSortKey(initData);
sortType = "Bubble Sort: ";
sortDouble.bubbleSort(sortKeyDouble);
printAcctsByBalanceSortKey(bank, sortKeyDouble, data, pgmOutput, sortType);

sortKeyDouble = bank.balanceInsertionSortKey(initData);
sortType = "Insertion Sort: ";
sortDouble.insertionSort(sortKeyDouble);
printAcctsByBalanceSortKey(bank, sortKeyDouble, data, pgmOutput, sortType);

pgmOutput.println("\n");

            


//Implement a keyboard for menu iput, print the menu and run desired methods based on user input
    Scanner keyboard = new Scanner(System.in);
    menu();
    String selection = keyboard.nextLine();
    boolean menuContinue = true;

    while(menuContinue) { //menu options call various methods based on user selection
 

        if (selection.equals("B") || selection.equals("b")){ 
            balance(bank, transOut, data, transactionHistory, keyboard);
            menu();     
        }

        if (selection.equals("D") || selection.equals("d")){
            deposit(bank, transOut, transactionHistory, data, keyboard);   
            menu();
        }

        if (selection.equals("W") || selection.equals("w")){         
            withdrawal(bank, transOut, data, transactionHistory, keyboard); 
            menu();
        }

        if (selection.equals("C") || selection.equals("c")){
            clearCheck(bank, transOut, data, keyboard);
            menu();
        }
        
        if (selection.equals("I") || selection.equals("i")){
            accountInfo(bank, transOut, data, keyboard);
            menu();
        }

        if (selection.equals("H") || selection.equals("h")){          
            acctInfoHistory(bank, data, transactionHistory, keyboard, transOut);
            menu();
        }

        if (selection.equals("N") || selection.equals("n")){       
            String newAcctInfo = newAcct(bank, transOut, data, keyboard);
            menu();
        }

        if (selection.equals("X") || selection.equals("x")){
            deleteAcct(bank, transOut, data, keyboard);
            menu();
        }

        if (selection.equals("S") || selection.equals("s")){
            closeAcct(bank, transOut, data, transactionHistory, keyboard); 
            menu();
        }

        if (selection.equals("R") || selection.equals("r")){
            reopenAcct(bank, transOut, data, transactionHistory, keyboard);
            menu();
        }  

        if (selection.equals("q") || selection.equals("q")) {
            pgmOutput.println("\nFinal Accounts: \n");
            printAccts(bank, data, pgmOutput);
            for(int i = 0; i<data.size();i++){
            }
            transOut.close();
            pgmOutput.close();
            menuContinue = false;
            break;
        }
          
        
        selection = keyboard.nextLine(); 

        
    }

    
}

/*
This method reads in and loads the initial database of accounts from an input file.
The data format contained in the input file is:
fisrtName lastName SSN acctNum acctType balance maturityDate(for CD accounts)
*/
public static ArrayList<String> readAccts (Bank bank, Scanner sc) {
     //call a method to retrieve an ArrayList of Accounts currently active or closed.
    ArrayList<String> a = bank.accts(sc); 
    return (a);
}

/*
This method prints an unsorted, neatly formatted table (with column headings) of the complete account information for every
active account. The column headings should include: Last Name, First Name, SSN, Account Number, Account Type,
Account Status (open or closed), Balance (with a precision of 2), Maturity Date (used for CD accounts).
*/
public static void printAccts (Bank bank, ArrayList<String> a, PrintWriter pgmOutput) {
    Account acct = new Account();
    a = acct.Status(bank, pgmOutput, a);
    pgmOutput.printf("%-10s%-10s%-15s%-20s%-18s%-13s%-19s%-19s\n", "First", "Last", "SSN", "Account Number", "Account Type", "Balance","Maturity Date", "Account Status");
        for (int i = 0; i < a.size(); i++){
            String line = a.get(i);
            String[] subs = line.split(" ", 0);
        if(subs.length == 7) {
            pgmOutput.printf("%-10s%-10s%-15s%-20s%-18s%-13.2f%-19s%-19s\n", subs[0], subs[1], subs[2], subs[3], subs[4], Double.parseDouble(subs[5]), "N/A", subs[6]);
        }
        else {
            pgmOutput.printf("%-10s%-10s%-15s%-20s%-18s%-13.2f%-19s%-19s\n", subs[0], subs[1], subs[2], subs[3], subs[4], Double.parseDouble(subs[5]), subs[6], subs[7]);
        }
            
        }     
}  



public static void printAcctsByAcctNumSortKey (Bank bank, ArrayList<Integer> a, ArrayList<String> b, PrintWriter pgmOutput, String sortType) {
    pgmOutput.println("\n" + sortType);
    ArrayList<String> printSort = new ArrayList<String>();
for (int i = 0; i < a.size(); i++) { // Print the quick sorted array of Sort Keys
   int acctNumber = a.get(i);
   int index = bank.findAcct(b, acctNumber);
   printSort.add(b.get(index));  
}
    printAccts(bank, printSort, pgmOutput);
}

public static void printAcctsBySSNSortKey (Bank bank, ArrayList<Integer> a, ArrayList<String> b, PrintWriter pgmOutput, String sortType) {
    pgmOutput.println("\n" + sortType);
    ArrayList<String> c = new ArrayList<String>();
    for (int i = 0; i < b.size(); i++){
        c.add(b.get(i));
    }
    ArrayList<String> printSort = new ArrayList<String>();
for (int i = 0; i < a.size(); i++) { // Print the quick sorted array of Sort Keys
   int acctNumber = a.get(i);
   int index = bank.findAcct(c, acctNumber);
   printSort.add(c.get(index));  
   c.remove(index);
}
printAccts(bank, printSort, pgmOutput);
}

public static void printAcctsByBalanceSortKey(Bank bank, ArrayList<Double> a, ArrayList<String> b, PrintWriter pgmOutput, String sortType) {
    pgmOutput.println("\n" + sortType);
ArrayList<String> printSort = new ArrayList<String>();
for (int i = 0; i < a.size(); i++) { // Print the quick sorted array of Sort Keys
   String balance = String.valueOf(String.format("%.2f", a.get(i)));
   int index = bank.findAcctByDouble(b, balance);
   printSort.add(b.get(index));  
}
printAccts(bank, printSort, pgmOutput);
}


public static void printAcctsByNameSortKey(Bank bank, ArrayList<String> a, ArrayList<String> b, PrintWriter pgmOutput, String sortType) {
    pgmOutput.println("\n" + sortType);
    ArrayList<String> c = new ArrayList<String>();
    for (int i = 0; i < b.size(); i++){
        c.add(b.get(i));
    }
    for (int i = 0; i <a.size(); i++) {
       String key = a.get(i);
       int index = bank.findAcctByString(c, key);
       a.set(i, c.get(index));
       c.remove(index);
    }
    printAccts(bank, a, pgmOutput);
}


//This method only displays the menu. The main program then prompts the user for a selection
public static void menu() {
         System.out.println("\n\nSelect one of the following:\n\tW - Withdrawal\n\tD - Deposit \n\tC - Clear Check\n\tN - New account \n\tB - Balance\n\tI - Account Info (without transaction history)\n\tH - Account Info plus Account Transaction History\n\tS - Close Account (close (shut), but do not delete the account)\n\tR - Reopen a closed account\n\tX - Delete Account (close and delete the account from the database))\n\tQ - Quit");
}

/*
This method prompts the user for an account number. If the account does not exist, it prints an error message. Otherwise, it prints
the account balance. 
*/
public static void balance(Bank bank, PrintWriter outFile, ArrayList<String> a, ArrayList<String> transactionHistory, Scanner keyboard) {
    

    String selection = "'Balance Inquiry'";
    
    System.out.println("You have selected: "+ selection+"\nPlease enter the account number: ");
    int acctNumber = keyboard.nextInt();

    int index = bank.findAcct(a, acctNumber);
        if(index < 0){
            outFile.println("Balance Inquiry Error: Account " + acctNumber + " does not exist\n");   
        }
        else {
            String account = a.get(index);
            Account acct = new Account();
            boolean status = acct.getStatus(account);
            if (status){
            Double balance = acct.getBalance(account);
        String terms = acct.getTermsOfCD(account);

            Calendar transaction = Calendar.getInstance();
 
            Date date =  transaction.getTime();
            TransactionTicket transactionTicket = new TransactionTicket(date, selection, acctNumber, balance, terms);

            acct.getBalanceTransaction(transactionTicket, transactionHistory, account, outFile);

   
            }
            else {
                outFile.println("The account is closed. You cannot perform transactions on a closed account.\n");
            }
        }
}  

/*
This method prompts the user for the account number. If the account does not exist, it prints an error message. Otherwise, it asks
the user for the amount of the deposit.
*/
public static void deposit(Bank bank, PrintWriter outFile, ArrayList<String> transactionHistory, ArrayList<String> a, Scanner keyboard) throws ParseException {
   
   
    String selection = "'Deposit'";
    System.out.println("You have selected: "+ selection+"\nPlease enter the account number: ");
    
    int acctNumber = keyboard.nextInt();
    System.out.println("Please enter the deposit amount: ");
    Double deposit = keyboard.nextDouble();
    int index = bank.findAcct(a, acctNumber);
    if(index < 0){
        outFile.println("Deposit Error: Account " + acctNumber + " does not exist\n");   
    }
    else {
    String account = a.get(index);
    Account acct = new Account();
    boolean status = acct.getStatus(account);
    if (status){
    Double balance = acct.getBalance(account);

    String terms = acct.getTermsOfCD(account);

    Calendar transaction = Calendar.getInstance();

    Date date =  transaction.getTime();
    TransactionTicket transactionTicket = new TransactionTicket(date, selection, acctNumber, deposit, terms);
    

boolean flag = true;
    if (deposit > 0){
        acct.makeDeposit(transactionTicket, transactionHistory, account, flag, outFile);
        Double newBalance = balance + deposit;
       

        if(!acct.AccountType(account).equals("CD")){
            a.remove(index);
            a.add(acct.Name(account) + " " + acct.SSN(account) + " " + acct.AcctNumber(account) + " " + acct.AccountType(account) + " " + newBalance);
        }
        else{
            CDAccount cd = new CDAccount();
            boolean checkDate = cd.checkMaturityDate(acct.getTermsOfCD(account), outFile);
            if (checkDate) {
            System.out.println("Please enter the new terms of CD Account in months (enter '6' for 6 months - choosing either 6, 12, 18, or 24 months): ");
            int maturity = keyboard.nextInt();
            CDAccount accountCD = new CDAccount();
            String newMaturity = accountCD.maturityDate(maturity);
            a.remove(index);
            a.add(acct.Name(account) + " " + acct.SSN(account) + " " + acct.AcctNumber(account) + " " + acct.AccountType(account) + " " + newBalance + " " + newMaturity);
            }
        }

    }
    else{
        flag = false;
        acct.makeDeposit(transactionTicket, transactionHistory, account, flag, outFile);
    }
}
else {
    outFile.println("The account is closed. You cannot perform transactions on a closed account.\n");
}
} 
}

/*
This method prompts the user for the account number. If the account does not exist, it prints an error message. Otherwise, it asks
the user for the amount of the withdrawal. If the account does not contain sufficient funds, it prints an error message and does not
perform the transaction.
*/
public static void withdrawal(Bank bank, PrintWriter outFile, ArrayList<String> a, ArrayList<String> transactionHistory, Scanner keyboard) throws ParseException {
   
    String selection = "'Withdrawal'";
    System.out.println("You have selected: "+ selection+"\nPlease enter the account number: ");
    int acctNumber = keyboard.nextInt();
    System.out.println("Please enter the withdrawal amount: ");
    Double withdrawal = keyboard.nextDouble();
  
    int index = bank.findAcct(a, acctNumber);
    if(index < 0){
        outFile.println("Withdrawal Error: Account " + acctNumber + " does not exist\n");   
    }
    else {
    String account = a.get(index);
    Account acct = new Account();
    boolean status = acct.getStatus(account);
    if (status){
    Double balance = acct.getBalance(account);   
    
    String terms = acct.getTermsOfCD(account);

    Calendar transaction = Calendar.getInstance();
    Date date =  transaction.getTime();
    TransactionTicket transactionTicket = new TransactionTicket(date, selection, acctNumber, withdrawal * - 1, terms);
    
 boolean flag = true;

  
 if (withdrawal > 0) {
    acct.makeWithdrawal(transactionTicket, transactionHistory, account, flag, outFile);

        if (balance - withdrawal >= 0) {


            Double newBalance = balance - withdrawal;
            if(!acct.AccountType(account).equals("CD")){
                a.remove(index);
                a.add(acct.Name(account) + " " + acct.SSN(account) + " " + acct.AcctNumber(account) + " " + acct.AccountType(account) + " " + newBalance);
            }
            if(acct.AccountType(account).equals("CD")) {
                CDAccount cd = new CDAccount();
                boolean checkDate = cd.checkMaturityDate(acct.getTermsOfCD(account), outFile);
                if (checkDate) {
                    
                    System.out.println("Please enter the new terms of CD Account in months (enter '6' for 6 months - choosing either 6, 12, 18, or 24 months): ");
                    int maturity = keyboard.nextInt();
                    CDAccount accountCD = new CDAccount();
                    String newMaturity = accountCD.maturityDate(maturity);
                    a.add(acct.Name(account) + " " + acct.SSN(account) + " " + acct.AcctNumber(account) + " " + acct.AccountType(account) + " " + newBalance + " " + newMaturity);
                    a.remove(index);
                }  
            }
        }
    }
    else {
        flag = false;
        acct.makeWithdrawal(transactionTicket, transactionHistory, account, flag, outFile);
    }
  
}
else {
    outFile.println("The account is closed. You cannot perform transactions on a closed account.\n");
}
    }
    
}

/*
This method prompts the user for the account number. If the account does not exist, it prints an error message. Otherwise, it asks
the user for the date and the amount of the check. If the check is invalid it prints an error message and does not perform the
transaction. 
*/
public static void clearCheck(Bank bank, PrintWriter outFile, ArrayList<String> a, Scanner keyboard) throws ParseException {
    String selection = "'Clear Check'";
    System.out.println("You have selected: "+ selection+"\nPlease enter the account number: ");
    int acctNumber = keyboard.nextInt();
    System.out.println("Please enter the check amount: ");
    Double withdrawal = keyboard.nextDouble() * - 1;
    
    int index = bank.findAcct(a, acctNumber);
    outFile.println("Transaction Type: Clear Check");
    outFile.println("Account Number: " + acctNumber);


    if (index == -1) {
        outFile.println("Clear Check Error: Account " + acctNumber + " does not exist\n");
    }
    else{
        boolean validDate = checkDate(outFile);
        if(validDate){
            String account = a.get(index);
            Account acct = new Account();
            boolean status = acct.getStatus(account);
            if (status){
            Double balance = acct.getBalance(account);
            String acctType = acct.AccountType(account);
            if (acctType.equals("Checking")){
                outFile.println("Current Balance: " + balance);
                outFile.println("Amount to Withdraw: $" + withdrawal);
            if (withdrawal < 0) {    
                if (balance > withdrawal){
                    balance = balance - withdrawal;
                    a.remove(index);
                    a.add(acct.Name(account) + " " + acct.SSN(account) + " " + acct.AcctNumber(account) + " " + acct.AccountType(account) + " " + balance);
                    outFile.println("New balance: $" + String.format("%.2f", balance) + "\n");
                }
                else  {
                    outFile.println("Insufficient Funds Available - Bounce Fee Charged\n");
                    balance = balance - 2.50;
                    a.remove(index);
                    a.add(acct.Name(account) + " " + acct.SSN(account) + " " + acct.AcctNumber(account) + " " + acct.AccountType(account) + " " + balance);
                    outFile.println("New balance: $" + String.format("%.2f", balance) + "\n");
                }
            }
            else {
                outFile.println("Error: Invalid Withdrawal Amount - Transaction voided.\n");
            }
        }
            else {
                outFile.println("You can only clear a check from a checking account.\n");   
            }
        } 
        else {
            outFile.println("The account is closed. You cannot perform transactions on a closed account.\n");
        }  
    }
    }
}

/*
checkDate() method is for Checking accounts clearing checks. 
It checks to make sure the date is not post-dated (in the future), or more than 6 months old.
*/
public static boolean checkDate(PrintWriter outFile) throws ParseException{
    Boolean date = true;
    Boolean flag = true;
    while(flag) { 
    int monthDifference = -1;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Please enter the date of the check in 'yyyy-MM-dd' format:");
    Date checkDate = sdf.parse(keyboard.nextLine());
    Calendar c = Calendar.getInstance();
    Calendar c2 = Calendar.getInstance();
    c2.setTime(checkDate);
        if(c2.after(c)) {
            outFile.println("Error: No post-dated checks may be cleared.\n");
            date = false;
            flag = false;
        }
        else {
            int yearDifference = c.get(Calendar.YEAR);
            yearDifference = yearDifference - (c2.get(Calendar.YEAR)); 
            if (yearDifference >= 1) {
                outFile.println("Error: You may only clear a check if the date on the check is no more than six months ago.\n");
                date = false;
                flag = false;
            }
        }
        int cMonth = (c.get(Calendar.MONTH)) + 1;
        int c2Month = (c2.get(Calendar.MONTH)) + 1;
        if (cMonth >= c2Month){
            monthDifference = cMonth - c2Month;
        }
        else if (cMonth < c2Month){
            monthDifference = 12 - c2Month;
            monthDifference = monthDifference + cMonth; 
        }        
        if(monthDifference > 6) {
            outFile.println("Error: You may only clear a check if the date on the check is no more than six months ago.\n");
            date = false;
            flag = false;
        }
        else if(monthDifference == 6 && (c.get(Calendar.DAY_OF_MONTH) >= c2.get(Calendar.DAY_OF_MONTH))) {  
            outFile.println("Error: You may only clear a check if the date on the check is no more than six months ago.\n");
            date = false;
            flag = false;
        }
        else {
            flag = false;   
        }     
    } //while(date)
    return (date);
} //checkDate()

/*
public static void accountInfo(Bank bank, PrintWriter outFile, Scanner inFile)
This method prompts the user for a social security number (SSN). If no account exists for this SSN, it prints an error message.
Otherwise, it prints the complete account information for all of the accounts with this SSN.
*/
public static ArrayList<String> accountInfo(Bank bank, PrintWriter outFile, ArrayList<String> a, Scanner keyboard) {
    String selection = "'Account Info'";
    System.out.println("You have selected: "+ selection+"\nPlease enter your Social Security number (SSN): ");
    int ssn = keyboard.nextInt();    
    ArrayList<String> accounts = new ArrayList<String>();
   
    int index = bank.findAcct(a, ssn);
    
    if (index == -1) {
        outFile.println("Account Information Error: The SSN " + ssn +  " was not found, please check the number and try again.");
    }
    else {
        for (int i = 0; i < a.size(); i++){
            String data = a.get(i);
            String[] subs = data.split(" ", 0);
            int social = Integer.parseInt(subs[2]);
            if (ssn == social) {
                accounts.add(data);
            }
        }
        outFile.println("Account(s) found: ");
        for (int i = 0; i < accounts.size(); i++){
            outFile.println(i+1 + ". " + accounts.get(i));
        }
    }
    outFile.println("\n");
    return(accounts);
}  

/*
public static void accountInfoWithTransactionHistory (Bank bank,
PrintWriter outFile, Scanner inFile)
This method prompts the user for a social security number (SSN). If no account exists for this SSN, it prints an error message.
Otherwise, it prints the complete account information and transaction history for all of the accounts with this SSN.    
*/
public static void acctInfoHistory(Bank bank, ArrayList<String> a, ArrayList<String> transactionHistory, Scanner keyboard, PrintWriter outFile) {

    String selection = "'Account History'";
    System.out.println("You have selected: "+ selection+ "\nPlease enter the Social Security number: ");
    int social = keyboard.nextInt();

    Account acct = new Account();
    String data = "data";
    int count = 0;
    int index = bank.findAcct(a, social);
   
   

    if (index == -1) {
        outFile.println("Account History Error: The account was not found, please check the number and try again.");
    }

    else {
        String account = a.get(index);
        outFile.println("_________________________________________________\n" + acct.Name(account) +"'s Account(s) History: \n");
        for (int i = 0; i < transactionHistory.size(); i++) {
            data = transactionHistory.get(i);
          
            String[] subs = data.split("\\r?\\n");
            if (subs[0].equals(Integer.toString(social))) {
                for (int j = 1; j < subs.length; j++) {
                   outFile.println(subs[j]);
                    count++;
                }
                outFile.println();
            }
        }
        if (count == 0) {
            outFile.println("No Account History found.");
            
        }
        outFile.println("_________________________________________________");
    }
}


/*
This method prompts the user for a new account number. If the account already exists, it prints an error message. Otherwise, it
adds the account to the database. The method then prompts the user to enter the new depositor’s first name, last name,
social security number, the account type (Checking, Savings, or CD), and the initial opening deposit.

@param Bank bank, Printwriter outFile, Scanner inFile
*/
public static String newAcct(Bank bank, PrintWriter outFile, ArrayList<String> a, Scanner keyboard){
    String selection = "'New account'";
    System.out.println("You have selected: "+ selection+"\nPlease enter the New Account Number: ");
    int acctNumber = keyboard.nextInt();
    
    
    String newAccount = "new";
    int index = bank.findAcct(a, acctNumber);
    if (index != -1) {
        outFile.println("New Account Error: The account number " + acctNumber +" already exists, please try again.");
    }
    else{
        Scanner key = new Scanner(System.in);
        System.out.println("Please enter the new depositor's first name: ");
        String first = key.nextLine();
        System.out.println("Please enter the new depositor's last name: ");
        String last = key.nextLine();
        System.out.println("Social Security Number (SSN): ");
        String ssn = key.nextLine();
        System.out.println("Account Type ('Checking', 'Savings', or 'CD'): ");
        String acctType = key.nextLine();
        String maturity = "N/A";
        if(acctType.equals("CD")) {
            System.out.println("Enter Maturity date in 'MM/dd/yyyy' format");
            maturity = key.nextLine();
        }
        System.out.println("Initial deposit amount: ");
        Double deposit = key.nextDouble();
     
       newAccount = (first + " " + last + " " + ssn + " " + acctNumber + " " + acctType + " " + deposit + " " + maturity);
       outFile.println("New Account created: " + newAccount + "\n");
       a.add(newAccount);
    }
return(newAccount);  
}

/*
This method prompts the user for an account number. If the account does not exist, or if the account exists but has a non-zero
balance, it prints an error message. Otherwise, it closes and deletes the account. It returns the new number of accounts.
*/
public static int deleteAcct(Bank bank, PrintWriter outFile, ArrayList<String> a, Scanner keyboard) {
    String selection = "'Delete Account'";
    System.out.println("You have selected: "+ selection+"\nPlease enter the account number: ");
    int acctNumber = keyboard.nextInt();

    int index = bank.findAcct(a, acctNumber);
    if (index == -1) {
        outFile.println("Delete Account Error: The account was not found, please check the number and try again.");
    }
    else {
        String account = a.get(index);
        Account acct = new Account();
        Double balance = acct.getBalance(account);
        if(balance > 0) {
            outFile.println("The account has a non-zero balance. Please withdraw the balance before deleting the account.");
        }
        else if(balance == 0){
            a.remove(index);
            outFile.println("Account " + acctNumber + " was deleted.\n");
        }      
    } 
    return(a.size());  
}

/*
This method prompts the user for an account number. If the account does not exist, it prints an error message. Otherwise, it
closes the account. No transactions are allowed on a closed account.
*/

public static int closeAcct (Bank bank, PrintWriter outFile, ArrayList<String> a, ArrayList<String> transactionHistory, Scanner keyboard) {

    String selection = "'Close Account'";
    System.out.println("You have selected: "+ selection+"\nPlease enter the account number: ");
    int acctNumber = keyboard.nextInt();
    int index = bank.findAcct(a, acctNumber);
    int flag = -1;
    if (index == -1) {
        outFile.println("Close Account Error: The account was not found, please check the number and try again.\n");
    }
    else {
        flag++; 
        
    String account = a.get(index);
    Account acct = new Account();

    boolean status = acct.getStatus(account);
    if (status){
    Double zeroBalance = acct.getBalance(account);
    account = acct.updateStatus(bank, outFile, account, flag);
    a.remove(a.get(index));
    a.add(account);
    
    String terms = acct.getTermsOfCD(account);

    Calendar transaction = Calendar.getInstance();
    Date date =  transaction.getTime();
    TransactionTicket transactionTicket = new TransactionTicket(date, selection, acctNumber, zeroBalance, terms);
    acct.closeAcct(transactionTicket, transactionHistory, account, outFile);
    }
    else {
        outFile.println("The account is already closed. You cannot perform transactions on a closed account.\n");
    }
}
    return(flag);
} 

/*
This method prompts the user for an account number. If the account does not exist, it prints an error message. Otherwise, it
reopens (or leaves open) the account. Transactions are once again allowed on a reopened account.
*/

public static int reopenAcct(Bank bank, PrintWriter outFile, ArrayList<String> a, ArrayList<String> transactionHistory, Scanner keyboard) {
    String selection = "'Reopen Account'";
    System.out.println("You have selected to: "+ selection+"\nPlease enter the account number: ");
    int acctNumber = keyboard.nextInt();
    int index = bank.findAcct(a, acctNumber);
    int flag = 0;
    if (index == -1) {
        outFile.println("Reopen account error: The account was not found, please check the number and try again.\n");
    }
    else {
        flag = -1; 
            
    String account = a.get(index);
    Account acct = new Account();
    boolean status = acct.getStatus(account);
    if (!status){
    Double startBalance = acct.getBalance(account);
    account = acct.updateStatus(bank, outFile, account, flag);
    a.remove(a.get(index));
    a.add(account);

    String terms = acct.getTermsOfCD(account);

    Calendar transaction = Calendar.getInstance();
    Date date =  transaction.getTime();
    TransactionTicket transactionTicket = new TransactionTicket(date, selection, acctNumber, startBalance, terms);
    acct.reopenAcct(transactionTicket, transactionHistory, account, outFile);
    }
    else {
        outFile.println("The account is already opened. You cannot reopen an account with an already open status.\n");
    }
    
} 
return(flag);
}


}