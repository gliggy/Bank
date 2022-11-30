public class Account {
	private double balance;
  private String username;
  private String password;
  
  public Account(String username, String password, double balance) {
    this.username = username;
    this.password = password;
    this.balance = balance;
  }
  
  public void deposit (double amount) {
    balance += amount;
    System.out.println("your new balance is " + balance);
  }
  public void withdraw (double amount) {
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
