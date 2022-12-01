import java.util.HashMap;

public class Index {
  HashMap<String, Account> accounts = new HashMap<String, Account>();
  public Index() {
    accounts.put("leo", new Account("leo","password123",1000));
    accounts.put("gliggy", new Account("gliggy","duckduck",500));
    accounts.put("paul", new Account("paul","secret",50));
  }
  public void signup(String username, String password, double balance) {
    Account account = new Account(username,password,balance);
    accounts.put("new", account);
  }
  public Account getAccount(String username) {
    return accounts.get(username);
  }
}

//for (rows in db) {accounts.put(key, new Account(username,password,balance))} 
/*
 * Account leo = new Account("leo","password123",1000);
 * Account gliggy = new Account("gliggy","duckduck",500);
 */