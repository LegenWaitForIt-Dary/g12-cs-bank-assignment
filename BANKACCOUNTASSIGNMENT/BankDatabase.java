package BANKACCOUNTASSIGNMENT;
import java.util.ArrayList;
public class BankDatabase{
    static ArrayList<UserAccount> userAccounts = new ArrayList<UserAccount>();
    public static void updateBankDatabase(UserAccount userAccount, boolean add){
        if(add){
            userAccounts.add(userAccount);
        }else{
            userAccounts.remove(userAccount);
        }
    }
}