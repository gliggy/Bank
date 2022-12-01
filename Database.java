import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class Database {
  public Database() {

  }
  public void createDB()
  {
    Connection connection = null;
    try {
      // create a database connection
      connection = DriverManager.getConnection("jdbc:sqlite:accounts.db");
      Statement statement = connection.createStatement();
      //statement.executeUpdate("drop table if exists accounts");
      statement.executeUpdate("create table if not exists accounts (username string unique, password string, balance double)");//key string unique, 
      statement.executeUpdate("insert into accounts values('leo', 'password123',1000.0)");
      statement.executeUpdate("insert into accounts values('gliggy','duckduck',500.0)");
      PreparedStatement pstatement = connection.prepareStatement("select * from accounts where username = ?");
      pstatement.setString(1, "paul");
      ResultSet rs = pstatement.executeQuery();
      while(rs.next())
      {
        // read the result set
        System.out.println("username = " + rs.getString("username"));
        System.out.println("password = " + rs.getString("password"));
        System.out.println("balance = " + rs.getDouble("balance"));
      }
    } catch(SQLException e) {
      // if the error message is "out of memory",
      // it probably means no database file is found
      System.err.println(e.getMessage());
    } finally {
      try {
        if(connection != null)
          connection.close();
      } catch(SQLException e) {
        // connection close failed.
        System.err.println(e.getMessage());
      }
    }
  }
}
