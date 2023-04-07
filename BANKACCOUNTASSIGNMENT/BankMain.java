package BANKACCOUNTASSIGNMENT;

import java.util.ArrayList;
import java.util.Scanner;

public class BankMain {
  public static void main(String[]args){
    Scanner ui = new Scanner(System.in);
    int loggedInAccount;
    while(true){
      loggedInAccount = 0;
      System.out.println("Welcome to the Bank!");
      System.out.println("Press 1 to sign in to an existing account, press 2 to sign up for a new account, or press 3 to exit page:");
      int userStartChoice = errorCheckStartUpPage(ui);
          
      if(userStartChoice==1){
        System.out.println("Please input your user accountID");
        String loginID = ui.nextLine();
        System.out.println("Please input your password");
        String loginPW = ui.nextLine();
        boolean validLogin = true;
        for(int i = 0;i<BankDatabase.userAccounts.size();i++){
          if(!(BankDatabase.userAccounts.get(i).getUserID().equals(loginID)||BankDatabase.userAccounts.get(i).getUserPW().equals(loginPW))){
            validLogin = false;
          }
        }
        for(int i = 0;i<BankDatabase.userAccounts.size();i++){
          if(BankDatabase.userAccounts.get(i).getUserID().equals(loginID)){
            loggedInAccount = i;
          }
        }
        if(validLogin){
          System.out.println("You have successfully logged in! Feel free to explore!");
            break;
        }else{
          System.out.println("Login failed, try again");
        }

        }else if(userStartChoice ==2){
          System.out.println("Please input your first name:");
          String userfName = ui.nextLine();
          System.out.println("Please input your last name:");
          String userLName = ui.nextLine();
          System.out.println("Please input the month of your birthday as a number");
          int userMonth = errorCheck(ui);
          System.out.println("Please input the date of your birthday");
          int userDate = errorCheck(ui);
          System.out.println("Please input the year of your birthday");
          int userYear = errorCheck(ui);
          System.out.println("Please input your phone number");
          String userPhoneNumber = ui.nextLine();
          System.out.println("Please create a password:");
          String userPassword = ui.nextLine();
          System.out.println("Please input your email:");
          String userEmail = ui.nextLine();
          UserAccount userAccount = new UserAccount(userfName,userLName,userMonth, userYear, userDate, userPhoneNumber, userEmail, userPassword); 
          BankDatabase.updateBankDatabase(userAccount, true);
          loggedInAccount = BankDatabase.userAccounts.size()-1;
          System.out.println("You have successfully created an account at our bank! Feel free to explore the menu!");
          break;
          
          }else{
            break;
          }

          while(true){
            System.out.println("Press 1 to display user info");
            System.out.println("Press 2 to change user info");
            System.out.println("Press 3 to create a bank account");
            System.out.println(("Press 4 to display bank accounts"));
            System.out.println("Press 5 to access bank accounts");
            System.out.println("Press 6 to delete user account");
            System.out.println("Press 7 to log out");
            int userChoice = errorCheckMenu(ui); 
            
            if(userChoice==1){
              BankDatabase.userAccounts.get(loggedInAccount).displayUserInfo();
            
            }else if(userChoice==2){
              System.out.println("Do you want to change 1.) first name, 2.) last name, 3.) phone number, 4.) email, or 5.) password");
              int userOtherChoice = errorCheckChangeMenu(ui);
              if(userOtherChoice==1){
                System.out.println("What do you want to change your first name to?");
                String newfName = ui.nextLine();
                BankDatabase.userAccounts.get(loggedInAccount).changeFName(newfName);
              }else if(userOtherChoice == 2){
                System.out.println("What do you want to change your last name to?");
                String newlName = ui.nextLine();
                BankDatabase.userAccounts.get(loggedInAccount).changeLName(newlName);
              }else if(userOtherChoice ==3){
                System.out.println("What do you want to change your phone number to?");
                String newPNum = ui.nextLine();
                BankDatabase.userAccounts.get(loggedInAccount).changePhonenumber(newPNum);
              }else if(userOtherChoice == 4){
                System.out.println("What do you want to change your email to?");
                String newEmail = ui.nextLine();
                BankDatabase.userAccounts.get(loggedInAccount).changeEmail(newEmail);
              }else{
                System.out.println("What do you want to change your password to?");
                String newPassword = ui.nextLine();
                BankDatabase.userAccounts.get(loggedInAccount).changePassword(newPassword);
              }
  
            }else if(userChoice==3){
              System.out.println("How much money do you want to put in?");
              double userInitBal = moneyCheck(ui);
              BankAccount userBankAccount = new BankAccount(userInitBal,BankDatabase.userAccounts.get(loggedInAccount).getUserID(),BankDatabase.userAccounts.get(loggedInAccount).getUserPW());
              BankDatabase.userAccounts.get(loggedInAccount).getBankAccounts().add(userBankAccount);
            
            }else if(userChoice==4){
              BankDatabase.userAccounts.get(loggedInAccount).displayBankAccounts(BankDatabase.userAccounts.get(loggedInAccount).getBankAccounts());
            
            }else if(userChoice==5){
              System.out.println("Please choose a bank account to access:");
              String userBankChoice = errorCheckBankChoice(ui, BankDatabase.userAccounts.get(loggedInAccount).getBankAccounts());
              int userBankAccountChoice = 0;
              for(int i = 0; i<BankDatabase.userAccounts.get(loggedInAccount).getBankAccounts().size();i++){
                if(BankDatabase.userAccounts.get(loggedInAccount).getBankAccounts().get(i).getBankNumber().equals(userBankChoice)){
                  userBankAccountChoice+=i;
                }
              }
              while(true){
                System.out.println("Do you want to 1.) deposit money into the bank account, 2.) withdraw money from the bank account, 3.) see account information, 4.) remove the account, or 5.) exit menu");
                int userBankChoiceMenu = errorCheckBankMenu(ui);
                if(userBankChoiceMenu==1){
                  System.out.println("How much money do you want to deposit?");
                  double deposit = moneyCheck(ui);
                  BankDatabase.userAccounts.get(loggedInAccount).getBankAccounts().get(userBankAccountChoice).deposit(deposit);
                }else if(userBankChoiceMenu==2){
                  System.out.println("How much money do you want to withdraw?");
                  double withdraw = moneyCheck(ui);
                  BankDatabase.userAccounts.get(loggedInAccount).getBankAccounts().get(userBankAccountChoice).withdraw(withdraw);
                }else if(userBankChoiceMenu==3){
                  BankDatabase.userAccounts.get(loggedInAccount).getBankAccounts().get(userBankAccountChoice).displayUserInfo();
                  BankDatabase.userAccounts.get(loggedInAccount).displayUserInfo();
                }else if(userBankChoiceMenu==4){
                  BankDatabase.userAccounts.get(loggedInAccount).getBankAccounts().remove(userBankAccountChoice);
                }else{
                  break;
                }
              }
  
            }else if(userChoice ==6){
              BankDatabase.userAccounts.remove(loggedInAccount);
            
            }else{
              break;
            } 
          }
        }   
    }
    
    public static String errorCheckBankChoice(Scanner ui, ArrayList<BankAccount> bankAccounts){
      int matchingAccNum =0;
      for(int i = 0;i<bankAccounts.size();i++){
        if(bankAccounts.get(i).getBankNumber().equals(ui.nextLine())){
          matchingAccNum++;
        }
      }
      while(!ui.hasNextLine()||matchingAccNum==0){
        System.out.println("Bank account does not exist, please try again:");
        ui.next();
      }
      String errorCheckedInput = ui.nextLine();
      return errorCheckedInput;
    }

    public static int errorCheckStartUpPage(Scanner ui) {
        while (!ui.hasNextInt()||ui.nextInt()<1||ui.nextInt()>3) {
          System.out.println("Invalid input. Please try again:");
          ui.next();
        }
        int errorCheckedInput = ui.nextInt();
        return errorCheckedInput;
      }
      public static int errorCheckMenu(Scanner ui) {
        while (!ui.hasNextInt()||ui.nextInt()<1||ui.nextInt()>5) {
          System.out.println("Invalid input. Please try again:");
          ui.next();
        }
        int errorCheckedInput = ui.nextInt();
        return errorCheckedInput;
      }

      public static int errorCheckBankMenu(Scanner ui) {
        while (!ui.hasNextInt()||ui.nextInt()<1||ui.nextInt()>4) {
          System.out.println("Invalid input. Please try again:");
          ui.next();
        }
        int errorCheckedInput = ui.nextInt();
        return errorCheckedInput;
      }

      public static int errorCheckChangeMenu(Scanner ui) {
        while (!ui.hasNextInt()||ui.nextInt()<1||ui.nextInt()>6) {
          System.out.println("Invalid input. Please try again:");
          ui.next();
        }
        int errorCheckedInput = ui.nextInt();
        return errorCheckedInput;
      }

      /*public static int errorCheckPhonenumber(Scanner ui) {
        String charLib = "1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int nonLetterOrNum = 0;
        
        for(int i = 0;i<ui.nextLine().length();i++){
          if(charLib.contains(ui.nextLine().charAt(i))){

          }
        }
        while (!ui.hasNextInt()||Integer.toString(ui.nextInt()).length()!=8) {
          System.out.println("Invalid phone number. Please try again:");
          ui.next();
        }
        int errorCheckedInput = ui.nextInt();
        return errorCheckedInput;
      }*/

      public static int errorCheck(Scanner ui){
        while (!ui.hasNextInt()) {
            System.out.println("Invalid input. Please try again:");
            ui.next();
          }
          int errorCheckedInput = ui.nextInt();
          return errorCheckedInput;
      }

      public static double moneyCheck(Scanner ui){
        while (!ui.hasNextDouble()) {
          System.out.println("Invalid input. Please try again:");
          ui.next();
        }
        double errorCheckedInput = ui.nextDouble();
        return errorCheckedInput;
      }
}
