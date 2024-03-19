package jdbc;

import java.sql.Statement;
import java.util.ArrayList;

import admin.Admin.Update;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
 static Connection conn = null;

 // Create Table
 public static void createTable() throws SQLException {
  // Connection establishement
  conn = DB.connect();
  String query = Query.creteTable;

  // 3 Statement create
  Statement stm = conn.createStatement();

  // 4 Execute query
  stm.execute(query);

  System.out.println("Table created successfully!");

 }

 // Insert Data
 public static void insertData(Student newStudent) throws SQLException {
  conn = DB.connect();
  String query = Query.insert;
  // 3. Create statement
  PreparedStatement pstm = conn.prepareStatement(query);
  // Set the Vlaues manually
  pstm.setString(1, newStudent.rollNo);
  pstm.setString(2, newStudent.name);
  pstm.setString(3, newStudent.course);
  pstm.setString(4, newStudent.semester);
  pstm.setString(5, newStudent.fatherName);
  pstm.setString(6, newStudent.motherName);
  pstm.setString(7, newStudent.mobNo);
  pstm.setString(8, newStudent.emailId);
  pstm.setString(9, newStudent.dob);
  pstm.setString(10,newStudent.gender);
  pstm.setString(11, newStudent.password);
  pstm.setString(12, newStudent.address);
  pstm.setInt(13,    newStudent.status);
  // pstm.setDate(14,   newStudent.RegDate);

  // 4. Execute query
  pstm.executeUpdate();

  System.out.println("Data inserted successfully!");

 }

 // Read All Data from Database
 public static ArrayList<Student> readData() throws SQLException {
  Connection conn = DB.connect();
  String query = Query.read;
  // 2. Create statement
  Statement smt = conn.createStatement();
  // 3. Execute query
  ResultSet rs = smt.executeQuery(query);

  ArrayList<Student> students = new ArrayList<>();
  while (rs.next()) {
   Student student = new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
     rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getInt(14));
     Date date = rs.getDate(13);
     student.RegDate = date;
     // Adding data in list
     students.add(student);
   /* Display Data */
   /*
    * System.out.println(rs.getString(1) +" \t"+
    * rs.getString(2)+"\t"+
    * rs.getString(3));
    */
  }
  return students;
 }

 // Read Password
 public static String readPassword(String rollNo) throws SQLException {
  Connection conn = DB.connect();
  String query = Query.readPs;
  PreparedStatement pstm = conn.prepareStatement(query);
  pstm.setString(1, rollNo);
  ResultSet rs = pstm.executeQuery();
  rs.next();
  return rs.getString(1);
}

 // Read Specific Data from Database
 public static Student readSpData(String rollNo, String password) throws SQLException {
    Connection conn = DB.connect();
    // 2. Create statement
    String query1 = Query.readSp;
    PreparedStatement pstm = conn.prepareStatement(query1);
    pstm.setString(1, rollNo);
    ResultSet rs = pstm.executeQuery();
    rs.next();
    // Feteching student data from data base
    Student student = new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
    rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11),rs.getString(12), rs.getInt(14));
    Date date = rs.getDate(13);
    student.RegDate = date;
    return student;
 }
 // Update Data
 public static void updateData(String id, String oldData, String newData) throws SQLException {
  Connection conn = DB.connect();
  String query = Query.update;
  PreparedStatement pstm = conn.prepareStatement(query);
  // Update
  pstm.setString(1, oldData);
  pstm.setString(2, newData);
  pstm.setString(3, id);
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

}
