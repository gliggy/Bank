import java.util.HashMap;

public class Index {
  HashMap<String, Account> accounts = new HashMap<String, Account>();
  public Index() {
    accounts.put("gliggy", new Account("gliggy","duckduck",500.0));
    accounts.put("leo", new Account("leo","password123",1500.0));
    accounts.put("paul", new Account("paul","secret",1050.0));
  }
  public void signup(String username, String password, double balance) {
    Account account = new Account(username,password,balance);
    accounts.put(username, account);
  }
  public Account getAccount(String username) {
    return accounts.get(username);
  }
}
