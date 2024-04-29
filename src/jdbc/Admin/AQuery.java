package jdbc.Admin;

public class AQuery {

 // Query for Admin DataBase
 protected static String createAdmDB = "CREATE DATABASE Admin_DB";
 protected static String creteAdmTable = "CREATE TABLE admin (id int(10) NOT NULL, name VARCHAR(30) NOT NULL, fatherName VARCHAR(30) NOT NULL, mobNo VARCHAR(15), emailId VARCHAR(30), dob VARCHAR(20), gender VARCHAR(10), address VARCHAR(100), type VARCHAR(50), password varchar(20), date DATE, status BIT, PRIMARY KEY (id))";
 protected static String insertAdm     = "INSERT INTO admin VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NOW(), ?)";
 protected static String readAdm      = "SELECT * FROM admin";
 protected static String readSpAdm      = "SELECT * FROM admin WHERE id = ?";
 protected static String readAdminId      = "SELECT name FROM admin WHERE id = ?";
 protected static String readPs      = "SELECT password FROM admin WHERE id = ?";
 protected static String readType      = "SELECT type FROM admin WHERE id = ?";
 protected static String updateAdm = "UPDATE admin SET name = ? where rollNo = ?";
 protected static String deleteAdm     = "DELETE FROM admin where id = ?";   
 protected static String dateAdm   = "SELECT CURDATE";
}

