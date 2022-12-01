//import java.util.ArrayList;
import java.util.HashMap; // import the HashMap class

public class Index {
  Account leo = new Account("leo","password123",1000);
  Account gliggy = new Account("gliggy","duckduck",500);
  HashMap<String, Account> accounts = new HashMap<String, Account>();
  //ArrayList<Account> accounts = new ArrayList<Account>();
  //ArrayList<String> usernames = new ArrayList<String>();
  public Index() {
    accounts.put("leo", leo);
    accounts.put("gliggy", gliggy);
  }
  public void signup(String username, String password, double balance) {
    Account account = new Account(username,password,balance);
    accounts.put(username, account);
  }
  public Account getAccount(String username) {
    return accounts.get(username);
  }
}

/*
 * Account leo = new Account("leo","password123",1000);
 * Account gliggy = new Account("gliggy","duckduck",500);
 */