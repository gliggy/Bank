import java.util.HashMap;

public class Index {
  HashMap<String, Account> accounts = new HashMap<String, Account>();
  public Index() {
  }
  public void signup(String username, String password, double balance) {
    Account account = new Account(username,password,balance);
    accounts.put(username, account);
  }
  public Account getAccount(String username) {
    return accounts.get(username);
  }
}
