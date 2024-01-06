import java.io.*;
import java.util.*;
               
public class Bank {


    private ArrayList<Integer> sortAccountsByAcctNum (ArrayList<String> data) {
        ArrayList<Integer> acctNumbers = new ArrayList<Integer>();
        Account acct = new Account();
    
        for(int i = 0; i < data.size(); i++) {
            String input = data.get(i);
            int acctNumber= acct.AcctNumber(input);  
            acctNumbers.add(acctNumber);
        }
        return (acctNumbers);
    }
    
    private static ArrayList<Integer>  sortAccountsBySSN (ArrayList<String> data) {
        ArrayList<Integer> socials = new ArrayList<Integer>();
        Account acct = new Account();
    
        for(int i = 0; i < data.size(); i++) {
            String input = data.get(i);
            int ssn = acct.SSN(input);  
            socials.add(ssn);
        }
        return(socials);
    }
    
    private static ArrayList<String> sortAccountsByName (ArrayList<String> data) {
        ArrayList<String> names = new ArrayList<String>();
        Account acct = new Account();
    
        for(int i = 0; i < data.size(); i++) {
            String input = data.get(i);
            String name = acct.Name(input);  
            names.add(name);
        }
        return(names);
    }
    
    private static ArrayList<Double> sortAccountsByBalance(ArrayList<String> data) {
        ArrayList<Double> balances = new ArrayList<Double>();
        Account acct = new Account();
    
        for(int i = 0; i < data.size(); i++) {
            String input = data.get(i);
            Double balance = acct.getBalance(input);  
            balances.add(balance);
        }
        return(balances);
    }
    
    public ArrayList<Integer> acctNumQuickSortKey(ArrayList<String> data) {
        ArrayList<Integer> acctNumQuickSortKey = sortAccountsByAcctNum(data);
        return (acctNumQuickSortKey);
    }
    
    public ArrayList<Integer>  acctNumBubbleSortKey (ArrayList<String> data) {
        ArrayList<Integer> acctNumBubbleSortKey = sortAccountsByAcctNum(data);
      return (acctNumBubbleSortKey);
    }
    public ArrayList<Integer>  acctNumInsertionSortKey (ArrayList<String> data) {
        ArrayList<Integer> acctNumInsertionSortKey = sortAccountsByAcctNum(data);
        return (acctNumInsertionSortKey);
    }
    public ArrayList<Integer>  ssnQuickSortKey (ArrayList<String> data) {
        ArrayList<Integer> ssnQuickSortKey = sortAccountsBySSN(data);
        return(ssnQuickSortKey);
    }
    public ArrayList<Integer>  ssnBubbleSortKey (ArrayList<String> data) {
        ArrayList<Integer> ssnBubbleSortKey = sortAccountsBySSN(data);
        return(ssnBubbleSortKey);
    }
    public ArrayList<Integer>  ssnInsertionSortKey (ArrayList<String> data) {
        ArrayList<Integer> ssnInsertionSortKey = sortAccountsBySSN(data);
        return(ssnInsertionSortKey);
    }
    public static ArrayList<String> nameQuickSortKey (ArrayList<String> data) {
        ArrayList<String> nameQuickSortKey = sortAccountsByName(data);
        return(nameQuickSortKey);
    }
    public static ArrayList<String> nameBubbleSortKey (ArrayList<String> data) {
        ArrayList<String> nameBubbleSortKey = sortAccountsByName(data);
        return(nameBubbleSortKey);
    }
    public static ArrayList<String> nameInsertionSortKey (ArrayList<String> data) {
        ArrayList<String> nameInsertionSortKey = sortAccountsByName(data);
        return(nameInsertionSortKey);
    }
    public static ArrayList<Double> balanceQuickSortKey (ArrayList<String> data) {
        ArrayList<Double> balanceQuickSortKey = sortAccountsByBalance(data);
        return(balanceQuickSortKey);
    }
    public static ArrayList<Double> balanceBubbleSortKey(ArrayList<String> data) {
        ArrayList<Double> balanceBubbleSortKey = sortAccountsByBalance(data);
        return(balanceBubbleSortKey);
    }
    public static ArrayList<Double> balanceInsertionSortKey(ArrayList<String> data) {
        ArrayList<Double> balanceInsertionSortKey = sortAccountsByBalance(data);
        return(balanceInsertionSortKey);
    } 
    
 
    

    
    
    /*
    
    */
    public static String insertionSortInt (ArrayList<Integer> a) {
        int temp;
        int cand;
          for(int pos = 1; pos < a.size(); pos++) {
              temp = a.get(pos);
              cand = pos;
              while (cand > 0 && a.get(cand - 1) > temp) {
                  a.set(cand, a.get(cand - 1));
                  cand--;
              }
              a.set(cand, temp);
          }
          String sortType = "Insertion Sort: ";
          return (sortType);
    }
    
    /*
    
    */
    public static String insertionSortDouble (ArrayList<Double> a) {
        Double temp;
        int cand;
          for(int pos = 1; pos < a.size(); pos++) {
              temp = a.get(pos);
              cand = pos;
              while (cand > 0 && a.get(cand -1).compareTo(temp) > 0) {
                  a.set(cand, a.get(cand - 1));
                  cand--;
              }
              a.set(cand, temp);
          }
          String sortType = "Insertion Sort: ";
          return (sortType); 
    }
    
    /*
    
    */
    public static String insertionSortStrings (ArrayList<String> a) {
        String temp;
        int cand;
          for(int pos = 1; pos < a.size(); pos++) {
              temp = a.get(pos);
              cand = pos;
              while (cand > 0 && a.get(cand -1).compareTo(temp) > 0) {
                  a.set(cand, a.get(cand - 1));
                  cand--;
              }
              a.set(cand, temp);
          }
          String sortType = "Insertion Sort: ";
          return (sortType);
      }
    


//initialize the accounts
public ArrayList<String> accts (Scanner sc) {
        ArrayList<String> data = new ArrayList<String>() ;
            while(sc.hasNextLine()){
                String details = sc.nextLine();

                // hasNext to add each detail to the account if statements for 
                data.add(details);
                }

    return(data);
    }

//search accounts in Bank ArrayList using an int key, which could be either SSN (subs[2]) or Account Number (subs[3])
public int findAcct(ArrayList<String> data, int key){
    int index = -1;
    int count = 0;
    for (int i = 0; i < data.size(); i++) {
                
                String details = data.get(i);
                String[] subs = details.split(" ", 0);
                String keyString = Integer.toString(key);
              
                for (int j = 0; j < subs.length; j++) {
                    if(subs[j].equals(keyString)){ 
                        index = i;   
                    }
                }
    }
    return(index);
}  

public int findAcctByString(ArrayList<String> data, String key){
    int index = -1;
    int count = 0;
 for(int i = 0; i < data.size(); i++) {               
                String details = data.get(i);
                String[] subs = details.split(" ", 0);
                String keyString = (subs[0] + " " + subs[1]);
                
                if (keyString.equals(key)){
                    index = i;
                    break;
                }                        
    }
    return(index);
}  

public int findAcctByDouble(ArrayList<String> data, String key){
    int index = -1;
    int count = 0;
 for(int i = 0; i < data.size(); i++) {               
                String details = data.get(i);
                String[] subs = details.split(" ", 0);
                String keyString = subs[5];
               // System.out.println(keyString);
                if (keyString.equals(key)){
                    index = i;
                    break;
                }                        
    }
    return(index);
}  

public static ArrayList<String> accountInfo(Bank bank, PrintWriter outFile, ArrayList<String> a, Scanner keyboard) {
    String selection = "'Account Info'";
    System.out.println("You have selected: "+ selection+"\nPlease enter your Social Security number (SSN): ");
    int ssn = keyboard.nextInt();    
    ArrayList<String> accounts = new ArrayList<String>();
   
    int index = bank.findAcct(a, ssn);
    
    if (index == -1) {
        outFile.println("The SSN " + ssn +  " was not found, please check the number and try again.");
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



public int getNumAccts(ArrayList<String> data, int key){
       int numAccts = 0;
       for (int i = 0; i < data.size(); i++) {
            String details = data.get(i);
            String[] subs = details.split(" ", 0);
            String keyString = Integer.toString(key);
                if(subs[2].equals(keyString) || subs[3].equals(keyString)){
                    numAccts++;
                }
        }
return(numAccts);
}


    
/*
public Account getAcct(ArrayList<String> data, int SSN) {
            for (int i = 0; i < data.size(); i++) {
                String details = data.get(i);
                String[] subs = details.split(" ", 0);
                String social = Integer.parseInt(SSN);
                String[] fullAccounts = new String[];
                private int acctCount;
                    if(subs[2].equals(social)){
                        fullAccounts[acctCount];
                        acctCount++;
                    }
            for(int i = 0; i < fullAccounts.length; i++) {
                System.out.println(fullAccounts[i]);
            }        
            }
    
    }
*/

public static Double totalAmountInSavingsAccts(ArrayList<String> data) {
   Double savings = 0.0;
            for (int i = 0; i < data.size(); i++) {
                String details = data.get(i);
                String[] subs = details.split(" ", 0);
           if(subs[4].equals("Savings")){
           savings += Double.parseDouble(subs[5]);
}
                }
    return(savings);
    }
  
     public static Double totalAmountInCheckingAccts(ArrayList<String> data) {
   Double checking = 0.0;
            for (int i = 0; i < data.size(); i++) {
                String details = data.get(i);
                String[] subs = details.split(" ", 0);
           if(subs[4].equals("Checking")){
           checking += Double.parseDouble(subs[5]);
}
                }
    return(checking);
    }

public static Double totalAmountInCDAccts(ArrayList<String> data) {
   Double cd = 0.0;
            for (int i = 0; i < data.size(); i++) {
                String details = data.get(i);
                String[] subs = details.split(" ", 0);
           if(subs[4].equals("CD")){
           cd += Double.parseDouble(subs[5]);
}
                }
    return(cd);
    }

public static Double totalAmountInAllAccts(ArrayList<String> data) {
   Double sum = 0.0;
            for (int i = 0; i < data.size(); i++) {
                String details = data.get(i);
                String[] subs = details.split(" ", 0);
          
           sum += Double.parseDouble(subs[5]);
                }
    return(sum);
    }

}




