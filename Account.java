import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;


public class Account {
	private double balance;
  private String username;
  private String password;
  
  // Read all lines from source file
  final Path source = Paths.get("/path/to/source.txt");
  final List<String> lines = Files.readAllLines(source, StandardCharsets.UTF_8);

  public Account(String username, String password, double balance) {
    this.username = username;
    this.password = password;
    this.balance = balance;
  }
  public double getAmount() {
    double amount = 0;
    Scanner scanner = new Scanner(System.in);
    boolean inputting = true;
    while (inputting) {
      //ask for username and password
      try {
        System.out.print("amount: ");
        amount = Double.parseDouble(scanner.nextLine());
        inputting = false;
      } catch (Exception e) {
        System.out.println("not a valid value, try again.");
      }
    }
    scanner = null;
    return amount;
  }
  
  public void deposit () {
    double amount = getAmount();
    balance += amount;
    System.out.println("your new balance is " + balance);
  }
  public void withdraw () {
    double amount = getAmount();
    if (amount <= balance) {
      balance -= amount;
      System.out.println("your new balance is " + balance);
    } else {
      System.out.println("sum requested too large.");
    }
  }
  public double getBalance() {
      return balance;
  }
  public String getUsername() {
    return username;
  }
  public String getPassword() {
    return password;
  }
  public boolean login(String username, String password) {
    if (this.username.equals(username) && this.password.equals(password)) {
      return true;
    }
    return false;
  }
  public void editFile(String key,String uname, String pswd, double blnc) {

  }
  public void saveAccount(Index index) {
    System.out.println("saving...");
    //if key is in db, change password or balance for that user;
    //else create new user with account.getUsername;
    if (!(index.getAccount(username) == null)) {
      editFile(username,username,password,balance);
    } else {
      editFile("new",username,password,balance);
    }
  }
}

}
