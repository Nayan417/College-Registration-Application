package jdbc;

public class Query {
 protected static String createDB = "CREATE DATABASE Registration_DB";
 protected static String creteTable = "CREATE TABLE student (rollNo VARCHAR(20) NOT NULL, name VARCHAR(30) NOT NULL, course VARCHAR(30) NOT NULL, session VARCHAR(30) NOT NULL, branch VARCHAR(30) NOT NULL, semester VARCHAR(20) NOT NULL, fatherName VARCHAR(30) NOT NULL, motherName VARCHAR(30), mobNo VARCHAR(15), emailId VARCHAR(30), dob VARCHAR(20), gender VARCHAR(10), address VARCHAR(100), password VARCHAR(30), date DATE, status BIT, PRIMARY KEY (rollNo))";
 protected static String insert     = "INSERT INTO student VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NOW(), ?)";
 
 //Reading query
 protected static String read       = "SELECT * FROM student";
 protected static String readCourse     = "SELECT * FROM student WHERE course = ? ";
 protected static String readSession     = "SELECT * FROM student WHERE session = ? ";
 protected static String readSemester     = "SELECT * FROM student WHERE semester = ? ";
 protected static String readBranch     = "SELECT * FROM student WHERE branch = ? ";
 
 protected static String readCourseSesssion    = "SELECT * FROM student WHERE course = ? AND session = ?";
 protected static String readCourseSemester    = "SELECT * FROM student WHERE course = ? AND semester = ?";
 protected static String readCourseBranch    = "SELECT * FROM student WHERE course = ? AND branch = ?";
 protected static String readSesssionSemester     = "SELECT * FROM student WHERE session = ? AND semester = ?";
 protected static String readSesssionBranch     = "SELECT * FROM student WHERE session = ? AND branch = ?";
 protected static String readSemesterBranch     = "SELECT * FROM student WHERE semester = ? AND branch = ?";
 
 protected static String readCouSesSememster     = "SELECT * FROM student WHERE course = ? AND session = ? AND semester = ?";
 protected static String readCouSesBranch     = "SELECT * FROM student WHERE course = ? AND session = ? AND branch = ?";
 protected static String readSesSemBranch     = "SELECT * FROM student WHERE session = ? AND semester = ? AND branch = ?";
 
 protected static String readCouSesSemBranch    = "SELECT * FROM student WHERE course = ? AND session = ? AND semester = ? AND branch = ?";
 
 protected static String readSp     = "SELECT * FROM student where rollNo = ? ";
 protected static String readPs     = "SELECT password FROM student where rollNo = ?";
 protected static String delete     = "DELETE FROM student where rollNo = ?";   
 protected static String date       = "SELECT CURDATE";
 // protected static String update = "UPDATE student SET ? = ? where rollNo = ?";

 protected static String updateName =   "UPDATE student SET name = ? where rollNo = ?";
 protected static String updateCourse = "UPDATE student SET course = ? where rollNo = ?";
 protected static String updateSemester = "UPDATE student SET semester = ? where rollNo = ?";
 protected static String updateMobNo =   "UPDATE student SET mobNo = ? where rollNo = ?";
 protected static String updateEmail =   "UPDATE student SET emailId = ? where rollNo = ?";
 protected static String updateGender = "UPDATE student SET gender = ? where rollNo = ?";
 protected static String updateFather = "UPDATE student SET fatherName = ? where rollNo = ?";
 protected static String updateMother = "UPDATE student SET motherName = ? where rollNo = ?";
 protected static String updateAddress = "UPDATE student SET address = ? where rollNo = ?";

}

