package jdbc;

public class Query {
 protected static String createDB = "CREATE DATABASE Registration_DB";
 protected static String creteTable = "CREATE TABLE student (rollNo VARCHAR(20) NOT NULL, name VARCHAR(30) NOT NULL, course VARCHAR(30) NOT NULL, semester VARCHAR(20) NOT NULL, fatherName VARCHAR(30) NOT NULL, motherName VARCHAR(30), mobNo VARCHAR(15), emailId VARCHAR(30), dob VARCHAR(20), gender VARCHAR(10), address VARCHAR(100), password VARCHAR(30), date DATE, status BIT, PRIMARY KEY (rollNo))";
 protected static String insert     = "INSERT INTO student VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NOW(), ?)";
 protected static String read       = "SELECT * FROM student";
 protected static String readSp     = "SELECT * FROM student where rollNo = ? ";
 protected static String readPs     = "SELECT password FROM student where rollNo = ?";
 protected static String update = "UPDATE student SET ? = ? where rollNo = ?";
 protected static String delete     = "DELETE FROM student where rollNo = ?";   
 protected static String date   = "SELECT CURDATE";
}

