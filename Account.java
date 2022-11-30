import java.util.Scanner;

public class Account {
	private double balance;
  private String username;
  private String password;
  
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
    return amount;
  }
  
  public void deposit () {
    double amount = getAmount();
    balance += amount;
    System.out.println("your new balance is " + balance);
  }
  public void withdraw () {
    double amount = getAmount();
    balance -= amount;
    System.out.println("your new balance is " + balance);
  }
  public double getBalance() {
      return balance;
  }
  public String getUsername() {
    return this.username;
  }
  public boolean login(String username, String password) {
    if (this.username.equals(username) && this.password.equals(password)) {
      return true;
    }
    return false;
  }
}
