package jdbc.Admin;

import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ADAO {
 static Connection conn = null;

 // Create Table
 public static void createTable() throws SQLException {
  // Connection establishement
  conn = DB.connect();
  String query = Query.creteAdmTable;

  // 3 Statement create
  Statement stm = conn.createStatement();

  // 4 Execute query
  stm.execute(query);

  System.out.println("Table created successfully!");

 }

 // Insert Data
 public static void insertAdmData(Admin admin) throws SQLException {
  conn = DB.connect();
  String query = Query.insertAdm;
  // 3. Create statement
  PreparedStatement pstm = conn.prepareStatement(query);
  // Set the Vlaues manually
  pstm.setString(1, admin.id+"");
  pstm.setString(2, admin.name);
  pstm.setString(3, admin.fatherName);
  pstm.setString(4, admin.mobNo);
  pstm.setString(5, admin.emailId);
  pstm.setString(6, admin.dob);
  pstm.setString(7, admin.gender);
  pstm.setString(8, admin.address);
  pstm.setString(9, admin.password);
  pstm.setInt(10, admin.status);
  // 4. Execute query
  pstm.executeUpdate();

  System.out.println("Data inserted successfully!");


 }
/* 
 // Update Data
 public static void updateData(String id, String newData) throws SQLException {
  Connection conn = DB.connect();
  String query = Query.updateName;
  PreparedStatement pstm = conn.prepareStatement(query);
  // Update
  pstm.setString(1, newData);
  pstm.setString(2, id);
  pstm.executeUpdate();

  System.out.println("Data Updated successfully!");
 }


 // Delete Data
 public static void deleteData(String rollNo) throws SQLException {
  Connection conn = DB.connect();
  String query = Query.delete;
  // Create Statement
  PreparedStatement pstm = conn.prepareStatement(query);
  pstm.setString(1,rollNo);
  pstm.executeUpdate();
  
  System.out.println("Data Deleted successfully!");

 }
 */
}
