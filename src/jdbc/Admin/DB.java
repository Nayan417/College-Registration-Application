package jdbc.Admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
 static Connection conn = null;
 static String DBName = "Admin_DB";

 // DataBase creation
 public static void createDataBase() throws SQLException {
  try {
   String url = "jdbc:mysql://localhost:3306";
   String user = "root";
   String password = "Nayanm@2002";

   conn = DriverManager.getConnection(url, user, password);

   Statement stm = conn.createStatement();
   stm.execute(AQuery.createAdmDB);

   System.out.println("Database Connected Successfully!");
  } catch (Exception e) {
   System.out.println(e);
  }

 }

 // DataBase connection
 public static Connection connect() {
  try {
   String url = "jdbc:mysql://localhost:3306/";
   String user = "root";
   String password = "Nayanm@2002";
   conn = DriverManager.getConnection(url+DBName, user, password);
   System.out.println("Database Connected Successfully!");
  } catch (Exception e) {
   System.out.println(e);
  }
  return conn;
 }

}
