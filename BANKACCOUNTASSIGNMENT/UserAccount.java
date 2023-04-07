package BANKACCOUNTASSIGNMENT;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
public class UserAccount{
    private final int userIDLength = 8;
    private String fName;
    private String lName; 
    private String accountID; 
    private int userAge; 
    private int bdMonth;
    private int bdYear;
    private int bdDate; 
    private String phoneNumber; 
    private String email;
    private String password;
    private ArrayList<BankAccount> bankAccounts;

    final String idGenLib = "1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    final char idGenLibArr[] = idGenLib.toCharArray();
    
    
    public UserAccount(String fName, String lName, int bdMonth, int bdYear, int bdDate, String phoneNumber, String email, String password){
        this.fName = fName;
        this.lName = lName;
        accountID = "";
        accountID = idGenerator();
        this.bdMonth = bdMonth;
        this.bdYear = bdYear;
        this.bdDate = bdDate;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password; 
        bankAccounts = new ArrayList<BankAccount>();
    }

    public String idGenerator(){
        for(int i = 0;i<userIDLength;i++){
            accountID+=idGenLibArr[(int)(Math.random()*(idGenLib.length()-1)+0)];
        }
        return accountID;
    }

    public void displayBankAccounts(ArrayList<BankAccount> bankAccounts){
        for(int i = 0; i<bankAccounts.size();i++){
            System.out.println((i+1)+".)"+ "bank account number"+bankAccounts.get(i).getBankNumber());
        }
    }
    public ArrayList<BankAccount>getBankAccounts(){
        return bankAccounts; 
    }

    public String getUserID(){
        return accountID;
    }

    public String getUserPW(){
        return password;
    }
    
    public int ageCalc(){
        LocalDate currentDate = LocalDate.now();
        LocalDate dateOfBirth = LocalDate.of(bdYear, bdMonth, bdDate);
        userAge = (int)(Period.between(dateOfBirth, currentDate).getYears());
        return userAge;
    }

    public void changeFName(String newFName){
        this.fName = newFName;
    }
    public void changeLName(String newLName){
        this.lName = newLName;
    }
    public void changePassword(String newPassword){
        this.password = newPassword;
    }
    public void changePhonenumber(String newPhonenumber){
        this.phoneNumber = newPhonenumber;
    }
    public void changeEmail(String newEmail){
        this.email = newEmail;
    }

    public void displayUserInfo(){
        System.out.println("first name:"+fName);
        System.out.println("last name:"+lName);
        System.out.println("user age:"+userAge);
        System.out.println(("accountID:"+ accountID));
        System.out.println("password:"+password);
        System.out.println("phone number:"+phoneNumber);
        System.out.println("email:"+email);
    }
    
    }

