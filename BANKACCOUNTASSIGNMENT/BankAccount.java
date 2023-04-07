package BANKACCOUNTASSIGNMENT;
public class BankAccount{
    private final int accountNumberLength = 16;
    private String accountNumber = "";
    private double accountBalance; 
    private String userID;
    private String password; 
    final String acNumberChars = "1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    final char acNumberCharArr[] = acNumberChars.toCharArray();

    public BankAccount(double accountBalance, String userID, String password){
        this.accountNumber = generateBankNumber(); 
        this.accountBalance = accountBalance;
        this.userID = userID;
        this.password = password;
    }
    
    public String generateBankNumber(){
        for(int i = 0;i<accountNumberLength;i++){
            accountNumber+=acNumberCharArr[(int)(Math.random()*(acNumberChars.length()-1)+0)];
        }
        return accountNumber;
    }

    public String getBankNumber(){
        return accountNumber;
    }


    public void deposit(double deposit){
        accountBalance+=deposit;
    }

    public void withdraw(double withdraw){
        accountBalance-=withdraw;
    }

    public void displayUserInfo(){
        System.out.println("user account balance:"+accountBalance);
    }

}