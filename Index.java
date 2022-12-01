//import java.util.ArrayList;
import java.util.HashMap; // import the HashMap class

public class Index {
  Account leo = new Account("leo","password123",1000);
  Account gliggy = new Account("gliggy","duckduck",500);
  Account paul = new Account("paul","secret",50));
  HashMap<String, Account> accounts = new HashMap<String, Account>();
  //ArrayList<Account> accounts = new ArrayList<Account>();
  //ArrayList<String> usernames = new ArrayList<String>();
  public Index() {
    //for (rows in db) {accounts.put(key, new Account(username,password,balance))} 
    accounts.put("leo", leo);
    accounts.put("gliggy", gliggy);
    accounts.put("paul",paul);
  }
  public void signup(String username, String password, double balance) {
    Account account = new Account(username,password,balance);
    accounts.put("new", account);
  }
  public Account getAccount(String username) {
    return accounts.get(username);
  }
  public void saveAccount(Account account) {
    //if key is in db, change password or balance for that user;
    //else create new user with account.getUsername;
    String keyUsername = newAccount.getUsername;
    String password = newAccount.getPassword;    
    double balance = newAccount.getBalance;
  }
}

/*
 * Account leo = new Account("leo","password123",1000);
 * Account gliggy = new Account("gliggy","duckduck",500);
 */