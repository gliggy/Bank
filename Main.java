import java.util.Scanner;
//the thing that gets user input

public class Main {
  public static boolean askQuestion(String question) {
    Scanner scanner = new Scanner(System.in);
    boolean result = false;
    boolean inputting = true;
    while (inputting) {
      System.out.print(question + " [y/n]: ");
      String answer = scanner.nextLine();
      if (answer.equals("y")) {
        result = true;
        inputting = false;
      } else if (answer.equals("n")) {
        result = false;
        inputting = false;
      } else {
        System.out.println("use either 'y' or 'n'");
      }
    }
    return result;
  }
  public static Account login() {
    Scanner scanner = new Scanner(System.in);
    Index indexClass = new Index();
    Account account = new Account("","",0);
    boolean inputting = true;
    while (inputting) {
      //ask for username and password
      System.out.print("username: ");
      String username = scanner.nextLine();
      System.out.print("password: ");
      String password = scanner.nextLine();
      //ask List for the index of the account with that username
      int index = indexClass.getIndex(username);
      if (index >= 0) {
        account = indexClass.getAccount(index);
        //try to login to the account with username and password
        if (account.login(username, password)) {
          System.out.println("login successful for " + account.getUsername());
          inputting = false;
        } else {
          //else do it all over again
          System.out.println("password incorrect. try again.");
        }
      } else {
        System.out.println("user does not exist. try again.");
        //or get an option to create an account!
      }
    }
    return account;
  }
  public static Account signup() {
//    System.out.print("new username: ");
    Account newUser = new Account("new","user",0);
    System.out.println("Account created for user: " + newUser.getUsername());
    return newUser;
  }
  public static void main(String[] args) {
    /*Account leo = new Account("leo","password123",1000);
    ArrayList<Account> accounts = new ArrayList<Account>();
    accounts.add(leo);
    */
    boolean hasAccount = askQuestion("Welcome to MHS Bank. Do you have an account?");
    if (hasAccount) {
      System.out.println("you have an account!");
      Account user = login();
      user.deposit(50);
      user.withdraw(5);
      System.out.println(user.getBalance());
    } else {
      System.out.println("create an account:");
      Account newUser = signup();
      newUser.deposit(50);
      newUser.withdraw(5);
      System.out.println(newUser.getBalance());
    }    
  }
}