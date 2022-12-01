import java.util.Scanner;
import java.util.stream.IntStream;
//the thing that gets user input

public class Main {
  public static int indexOf(char[] arr, char val) {
    return IntStream.range(0, arr.length).filter(i -> arr[i] == val).findFirst().orElse(-1);
  }
  public static int askQuestion(String question, char[] opts) {
    Scanner scanner = new Scanner(System.in);
    int result = -1;
    boolean inputting = true;
    question = question + " [";
    for (int i = 0; i < (opts.length - 1); i++) {
      question += opts[i]+"/";
    }
    question += opts[opts.length - 1]+"]: ";
    while (inputting) {
      System.out.print(question);
      char answer = scanner.nextLine().charAt(0);
      int answerIndex = indexOf(opts, answer);
      if (answerIndex >= 0) {
        result = answerIndex;
        inputting = false;
      } else {
        System.out.println("option not recognized. try again.");
      }
    }
    scanner = null;
    return result;
  }
  public static Account login() {
    Scanner scanner = new Scanner(System.in);
    Index indexClass = new Index();
    Account account = null;
    boolean inputting = true;
    while (inputting) {
      //ask for username and password
      System.out.print("username: ");
      String username = scanner.nextLine();
      System.out.print("password: ");
      String password = scanner.nextLine();
      //ask List for the index of the account with that username
      //int index = Index indexClass = new Index(username,password,1000.0);
      account = indexClass.getAccount(username);
      if (account == null) {
        System.out.println("user does not exist. try again.");
      } else {
        if (account.login(username, password)) {
          System.out.println("login successful for " + account.getUsername());
          inputting = false;
        } else {
          //else do it all over again
          System.out.println("password incorrect. try again.");
        }
      }/* 
        account = indexClass.getAccount(username);
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
      }*/
    }
    scanner = null;
    return account;
  }
  public static Account signup() {
    Scanner scanner = new Scanner(System.in);
    Index indexClass = new Index();
    Account newUser = null;
    //boolean inputting = true;
    System.out.print("new username: ");
    String newUsername = scanner.nextLine();
    System.out.print("new password: ");
    String newPassword = scanner.nextLine();
    indexClass.signup(newUsername, newPassword, 0);
    newUser = indexClass.getAccount(newUsername);
    System.out.println("Account created for user: " + newUser.getUsername());
    scanner = null;
    return newUser;  
}

  public static void main(String[] args) {
    //Database userDB = new Database();
    //userDB.createDB();
    Account user = null;
    char[] yesNo = {'y','n'};
    int hasAccount = askQuestion("Welcome to MHS Bank. Do you have an account?", yesNo);
    if (hasAccount == 0) {
      System.out.println("you have an account!");
      user = login();
    } else {
      System.out.println("create an account:");
      user = signup();
    }
    char[] actions = {'d','w','b','x'};
    boolean session = true;
    while (session) {
      int action = askQuestion("Deposit, Withdraw, get Balance, or eXit?", actions);
      switch(action) {
        case (0):
          user.deposit();
          break;
        case (1):
          user.withdraw();
          break;
        case (2):
          System.out.println(user.getBalance());
          break;
        case (3):
          System.out.println("exiting...");
          session = false;
          break;
        default:
          break;
      }
    }
    char[] exit = {'s','x'};
    int save = askQuestion("Save account or eXit without saving?", exit);
    switch(save) {
      case(0):
        user.saveAccount();
      case (1):
        break;
      default:
        break;
    }
  }
}
