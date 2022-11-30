import java.util.ArrayList;

public class Index {
  Account leo;
  Account gliggy;
  ArrayList<Account> accounts = new ArrayList<Account>();
  ArrayList<String> usernames = new ArrayList<String>();
  public Index() {
    Account leo = new Account("leo","password123",1000);
    Account gliggy = new Account("gliggy","duckduck",500);
    ArrayList<Account> accounts = new ArrayList<Account>();
    ArrayList<String> usernames = new ArrayList<String>();
    usernames.add("leo");
    accounts.add(leo);
    usernames.add("gliggy");
    accounts.add(gliggy);
    
    this.accounts = accounts;
    this.usernames = usernames;
  }
  public int getIndex(String username) {
    return usernames.indexOf(username);
  }
  public Account getAccount(int index) {
    return accounts.get(index);
  }
}

