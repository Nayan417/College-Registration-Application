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
  String query = AQuery.creteAdmTable;

  // 3 Statement create
  Statement stm = conn.createStatement();

  // 4 Execute query
  stm.execute(query);

  System.out.println("Table created successfully!");

 }

 // Insert Data
 public static void insertAdmData(Admin admin) throws SQLException {
  conn = DB.connect();
  String query = AQuery.insertAdm;
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
  pstm.setString(9, admin.type);
  pstm.setString(10, admin.password);
  pstm.setInt(11, admin.status);
  // 4. Execute query
  pstm.executeUpdate();

  System.out.println("Data inserted successfully!");


 }

   // Read All Data from Admin Database
   public static ArrayList<Admin> readData() throws SQLException {
    Connection conn = DB.connect();
    String query = AQuery.readAdm;

    // 2. Create statement
    Statement smt = conn.createStatement();
    // 3. Execute query
    ResultSet rs = smt.executeQuery(query);
    // System.out.println("read "+rs.next());

    ArrayList<Admin> admins = new ArrayList<>();
    
    while (rs.next()) {
      Admin admin = new Admin(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
          rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),rs.getString(10), rs.getInt(12));
      Date date = rs.getDate(11);
      Admin.RegDate = date;

      // Adding data in list
      admins.add(admin);
    }
    return admins;
  }
  
     // Read Specific Data from Admin Database
  public static Admin readSpData(String id) throws SQLException {
    Connection conn = DB.connect();
    String query = AQuery.readSpAdm;

    // 2. Create statement
    PreparedStatement pstm = conn.prepareStatement(query);
    pstm.setString(1, id);
     // 3. Execute query
    ResultSet rs = pstm.executeQuery();
    Admin admin = null;
    while (rs.next()) {
      admin = new Admin(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
          rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),rs.getString(10), rs.getInt(12));
      Date date = rs.getDate(11);
      Admin.RegDate = date;
    }
    return admin;
  }
  
   // Read admin type
   public static String readAdmType(String rollNo) throws SQLException {
    Connection conn = DB.connect();
    // System.out.println("Password is reading!");
    // Check existing of this rollNo
    if (!adminExist(rollNo)) return null;

    String query = AQuery.readType;
    PreparedStatement pstm = conn.prepareStatement(query);
    pstm.setString(1, rollNo);
    ResultSet rs = pstm.executeQuery();
    if (!rs.next())
      return null;
    return rs.getString(1);
  }

     // Read Password
     public static String readPassword(String rollNo) throws SQLException {
      Connection conn = DB.connect();
      // System.out.println("Password is reading!");
      // Check existing of this rollNo
      if (!adminExist(rollNo)) return null;
  
      String query = AQuery.readPs;
      PreparedStatement pstm = conn.prepareStatement(query);
      pstm.setString(1, rollNo);
      ResultSet rs = pstm.executeQuery();
      if (!rs.next())
        return null;
      return rs.getString(1);
    }
  
  // Check either student id exit in the database
  public static boolean adminExist(String id) throws SQLException{
    Connection cn = DB.connect();
    String query = AQuery.readAdminId;
    PreparedStatement pstm = cn.prepareStatement(query);
    pstm.setString(1, id);

    ResultSet rs = pstm.executeQuery();

    if (rs.next()) return true;
    return false;
  }
  
  // Delete Data from database
  public static boolean deleteData(String id) throws SQLException{
    Connection cn = DB.connect();
   if (!adminExist(id)) return false;
    String query = AQuery.deleteAdm;

   PreparedStatement pstm = cn.prepareStatement(query);
   pstm.setString(1,id);

   pstm.executeUpdate();
   return true;
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
