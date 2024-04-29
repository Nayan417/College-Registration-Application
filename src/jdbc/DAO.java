package jdbc;

import java.sql.Statement;
import java.util.ArrayList;

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
  public static boolean insertData(Student newStudent) throws SQLException {
    conn = DB.connect();

    System.out.println("Data inserting!");

    String query = Query.insert;
    // 3. Create statement
    PreparedStatement pstm = conn.prepareStatement(query);
    // Set the Vlaues manually
    pstm.setString(1, newStudent.rollNo);
    pstm.setString(2, newStudent.name);
    pstm.setString(3, newStudent.course);
    pstm.setString(4, newStudent.session);
    pstm.setString(5, newStudent.branch);
    pstm.setString(6, newStudent.semester);
    pstm.setString(7, newStudent.fatherName);
    pstm.setString(8, newStudent.motherName);
    pstm.setString(9, newStudent.mobNo);
    pstm.setString(10, newStudent.emailId);
    pstm.setString(11, newStudent.dob);
    pstm.setString(12, newStudent.gender);
    pstm.setString(13, newStudent.password);
    pstm.setString(14, newStudent.address);
    pstm.setInt(15, newStudent.status);
    // pstm.setDate(14, newStudent.RegDate);

    // 4. Execute query
     pstm.executeUpdate();

    System.out.println("Data inserted successfully!");
    return true;
  }

  // Read All Data from Database
  public static ArrayList<Student> readData() throws SQLException {
    Connection conn = DB.connect();
    String query = Query.read;
    // 2. Create statement
    Statement smt = conn.createStatement();
    // 3. Execute query
    ResultSet rs = smt.executeQuery(query);
    // System.out.println("read "+rs.next());

    ArrayList<Student> students = new ArrayList<>();
    while (rs.next()) {
      Student student = new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
          rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11),
          rs.getString(12), rs.getString(13), rs.getString(14), rs.getInt(16));
      Date date = rs.getDate(15);
      student.RegDate = date;
      // Adding data in list
      students.add(student);
    }
    return students;
  }

  // Read data course wise
  public static ArrayList<Student> readCourse(String course) throws SQLException {
    Connection conn = DB.connect();
    String query = Query.readCourse;

    // 2. Create statement
    PreparedStatement psmt = conn.prepareStatement(query);
    psmt.setString(1, course);

    // 3. Execute query
    ResultSet rs = psmt.executeQuery();

    ArrayList<Student> students = new ArrayList<>();
    while (rs.next()) {
      System.out.println("Report is showing!");
      Student student = new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
          rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11),
          rs.getString(12), rs.getString(13), rs.getString(14), rs.getInt(16));
      Date date = rs.getDate(15);
      student.RegDate = date;
      // Adding data in list
      students.add(student);
    }
    return students.size() > 0 ? students : null;
  }

  // Read data branch wise
  public static ArrayList<Student> readBranch(String branch) throws SQLException {
    Connection conn = DB.connect();
    String query = Query.readBranch;

    // 2. Create statement
    PreparedStatement psmt = conn.prepareStatement(query);
    psmt.setString(1, branch);

    // 3. Execute query
    ResultSet rs = psmt.executeQuery();

    ArrayList<Student> students = new ArrayList<>();
    while (rs.next()) {
      System.out.println("Report is showing!");
      Student student = new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
          rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11),
          rs.getString(12), rs.getString(13), rs.getString(14), rs.getInt(16));
      Date date = rs.getDate(15);
      student.RegDate = date;
      // Adding data in list
      students.add(student);
      System.out.println("Name " + rs.getString(1));
    }
    return students;
  }

  // Read data session wise
  public static ArrayList<Student> readSession(String session) throws SQLException {
    Connection cn = DB.connect();
    String query = Query.readSession;
    PreparedStatement pstm = cn.prepareStatement(query);
    pstm.setString(1, session);

    ResultSet rs = pstm.executeQuery();

    ArrayList<Student> students = new ArrayList<>();
    // Data is printing
    while (rs.next()) {
      System.out.println("Report is showing!");
      Student student = new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
          rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11),
          rs.getString(12), rs.getString(13), rs.getString(14), rs.getInt(16));
      Date date = rs.getDate(15);
      student.RegDate = date;
      // Adding data in list
      students.add(student);
      System.out.println("Name " + rs.getString(1));
    }
    return students;
  }

  // Read data semester wise
  public static ArrayList<Student> readSemester(String semester) throws SQLException {
    // Data base connection
    Connection cn = DB.connect();
    String query = Query.readSemester;
    PreparedStatement pstm = cn.prepareStatement(query);
    pstm.setString(1, semester);
    ResultSet rs = pstm.executeQuery();

    // Fatching data
    ArrayList<Student> students = new ArrayList<>();
    while (rs.next()) {
      System.out.println("Report is showing!");
      Student student = new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
          rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11),
          rs.getString(12), rs.getString(13), rs.getString(14), rs.getInt(16));
      Date date = rs.getDate(15);
      student.RegDate = date;
      // Adding data in list
      students.add(student);
    }
    return students;
  }

  // Read data course and session wise
  public static ArrayList<Student> readCourseSession(String course, String session) throws SQLException {
    // Data base connection
    Connection cn = DB.connect();

    String query = Query.readCourseSesssion;
    PreparedStatement pstm = cn.prepareStatement(query);
    pstm.setString(1, course);
    pstm.setString(2, session);

    ResultSet rs = pstm.executeQuery();
    // Fatching data
    ArrayList<Student> students = new ArrayList<>();
    while (rs.next()) {
      System.out.println("Report is showing!");
      Student student = new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
          rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11),
          rs.getString(12), rs.getString(13), rs.getString(14), rs.getInt(16));
      Date date = rs.getDate(15);
      student.RegDate = date;
      // Adding data in list
      students.add(student);
    }
    return students;
  }

  // Read data course and semester wise
  public static ArrayList<Student> readCourseSemester(String course, String semester) throws SQLException {
    // Data base connection
    Connection cn = DB.connect();

    String query = Query.readCourseSemester;
    PreparedStatement pstm = cn.prepareStatement(query);
    pstm.setString(1, course);
    pstm.setString(2, semester);

    ResultSet rs = pstm.executeQuery();
    // Fatching data
    ArrayList<Student> students = new ArrayList<>();
    while (rs.next()) {
      System.out.println("Report is showing!");
      Student student = new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
          rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11),
          rs.getString(12), rs.getString(13), rs.getString(14), rs.getInt(16));
      Date date = rs.getDate(15);
      student.RegDate = date;
      // Adding data in list
      students.add(student);
    }
    return students;
  }

  // Read data course and branch wise
  public static ArrayList<Student> readCourseBranch(String course, String branch) throws SQLException {
    // Data base connection
    Connection cn = DB.connect();

    String query = Query.readCourseBranch;
    PreparedStatement pstm = cn.prepareStatement(query);
    pstm.setString(1, course);
    pstm.setString(2, branch);

    ResultSet rs = pstm.executeQuery();
    // Fatching data
    ArrayList<Student> students = new ArrayList<>();
    while (rs.next()) {
      System.out.println("Report is showing!");
      Student student = new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
          rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11),
          rs.getString(12), rs.getString(13), rs.getString(14), rs.getInt(16));
      Date date = rs.getDate(15);
      student.RegDate = date;
      // Adding data in list
      students.add(student);
    }
    return students;
  }

  // Read data session and semester wise
  public static ArrayList<Student> readSessionSemester(String session, String semester) throws SQLException {
    // Data base connection
    Connection cn = DB.connect();

    String query = Query.readSesssionSemester;
    PreparedStatement pstm = cn.prepareStatement(query);
    pstm.setString(1, session);
    pstm.setString(2, semester);

    ResultSet rs = pstm.executeQuery();
    // Fatching data
    ArrayList<Student> students = new ArrayList<>();
    while (rs.next()) {
      System.out.println("Report is showing!");
      Student student = new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
          rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11),
          rs.getString(12), rs.getString(13), rs.getString(14), rs.getInt(16));
      Date date = rs.getDate(15);
      student.RegDate = date;
      // Adding data in list
      students.add(student);
    }
    // Empty record
    if (students.size() == 0) {
      System.out.println("Record is empty!");
      return null;
    }
    return students;
  }

  // Read data session and branch wise
  public static ArrayList<Student> readSessionBranch(String session, String branch) throws SQLException {
    // Data base connection
    Connection cn = DB.connect();

    String query = Query.readSesssionBranch;
    PreparedStatement pstm = cn.prepareStatement(query);
    pstm.setString(1, session);
    pstm.setString(2, branch);

    ResultSet rs = pstm.executeQuery();
    // Fatching data
    ArrayList<Student> students = new ArrayList<>();
    while (rs.next()) {
      System.out.println("Report is showing!");
      Student student = new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
          rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11),
          rs.getString(12), rs.getString(13), rs.getString(14), rs.getInt(16));
      Date date = rs.getDate(15);
      student.RegDate = date;
      // Adding data in list
      students.add(student);
    }
    return students;
  }

  // Read data semester and branch wise
  public static ArrayList<Student> readSemesterBranch(String semester, String branch) throws SQLException {
    // Data base connection
    Connection cn = DB.connect();

    String query = Query.readSemesterBranch;
    PreparedStatement pstm = cn.prepareStatement(query);
    pstm.setString(1, semester);
    pstm.setString(2, branch);

    ResultSet rs = pstm.executeQuery();
    // Fatching data
    ArrayList<Student> students = new ArrayList<>();
    while (rs.next()) {
      System.out.println("Report is showing!");
      Student student = new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
          rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11),
          rs.getString(12), rs.getString(13), rs.getString(14), rs.getInt(16));
      Date date = rs.getDate(15);
      student.RegDate = date;
      // Adding data in list
      students.add(student);
    }
    return students;
  }

  // Read data course, session and semester wise
  public static ArrayList<Student> readCourseSessionSemester(String course, String session, String semester)
      throws SQLException {

    // Data base connection
    Connection cn = DB.connect();

    String query = Query.readCouSesSememster;
    PreparedStatement pstm = cn.prepareStatement(query);
    pstm.setString(1, course);
    pstm.setString(2, session);
    pstm.setString(3, semester);

    ResultSet rs = pstm.executeQuery();
    // Fatching data
    ArrayList<Student> students = new ArrayList<>();
    while (rs.next()) {
      System.out.println("Report is showing!");
      Student student = new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
          rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11),
          rs.getString(12), rs.getString(13), rs.getString(14), rs.getInt(16));
      Date date = rs.getDate(15);
      student.RegDate = date;
      // Adding data in list
      students.add(student);
    }
    return students;
  }

  // Read data course, session and branch wise
  public static ArrayList<Student> readCourseSessionBranch(String course, String session, String branch)
      throws SQLException {
    // Data base connection
    Connection cn = DB.connect();

    String query = Query.readCouSesBranch;
    PreparedStatement pstm = cn.prepareStatement(query);
    pstm.setString(1, course);
    pstm.setString(2, session);
    pstm.setString(3, branch);

    ResultSet rs = pstm.executeQuery();
    // Fatching data
    ArrayList<Student> students = new ArrayList<>();
    while (rs.next()) {
      System.out.println("Report is showing!");
      Student student = new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
          rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11),
          rs.getString(12), rs.getString(13), rs.getString(14), rs.getInt(16));
      Date date = rs.getDate(15);
      student.RegDate = date;
      // Adding data in list
      students.add(student);
    }
    return students.size() > 0 ? students : null;
  }

  // Read data session, semester and branch wise
  public static ArrayList<Student> readSesSemBranch(String session, String semester, String branch)
      throws SQLException {
    // Data base connection
    Connection cn = DB.connect();

    String query = Query.readSesSemBranch;
    PreparedStatement pstm = cn.prepareStatement(query);
    pstm.setString(1, session);
    pstm.setString(2, semester);
    pstm.setString(3, branch);

    ResultSet rs = pstm.executeQuery();
    // Fatching data
    ArrayList<Student> students = new ArrayList<>();
    while (rs.next()) {
      System.out.println("Report is showing!");
      Student student = new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
          rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11),
          rs.getString(12), rs.getString(13), rs.getString(14), rs.getInt(16));
      Date date = rs.getDate(15);
      student.RegDate = date;
      // Adding data in list
      students.add(student);
    }
    return students;
  }

  // Read data course, session ,semester and branch wise
  public static ArrayList<Student> readCouSesSemBranch(String course, String session, String semester, String branch)
      throws SQLException {
    // Data base connection
    Connection cn = DB.connect();

    String query = Query.readCouSesSemBranch;
    PreparedStatement pstm = cn.prepareStatement(query);
    pstm.setString(1, course);
    pstm.setString(2, session);
    pstm.setString(3, semester);
    pstm.setString(4, branch);

    ResultSet rs = pstm.executeQuery();
    // Fatching data
    ArrayList<Student> students = new ArrayList<>();
    while (rs.next()) {
      System.out.println("Report is showing!");
      Student student = new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
          rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11),
          rs.getString(12), rs.getString(13), rs.getString(14), rs.getInt(16));
      Date date = rs.getDate(15);
      student.RegDate = date;
      // Adding data in list
      students.add(student);
    }
    return students;
  }

  // Read Password
  public static String readPassword(String rollNo) throws SQLException {
    Connection conn = DB.connect();
    // System.out.println("Password is reading!");
    String query = Query.readPs;
    PreparedStatement pstm = conn.prepareStatement(query);
    pstm.setString(1, rollNo);
    ResultSet rs = pstm.executeQuery();
    if (!rs.next())
      return null;
    return rs.getString(1);
  }

  // Read Specific Data without password
  public static Student readSpData(String rollNo) throws SQLException {
    return readSpData(rollNo, readPassword(rollNo));
  }

  // Read Specific Data from Database
  public static Student readSpData(String rollNo, String password) throws SQLException {
    Connection conn = DB.connect();
    // 2. Create statement

    String query1 = Query.readSp;
    PreparedStatement pstm = conn.prepareStatement(query1);
    pstm.setString(1, rollNo);
    ResultSet rs = pstm.executeQuery();
    if (!rs.next()) {
      // System.out.println("no data");
      return null;
    }

    // Feteching student data from data base
    Student student = new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
        rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11),
        rs.getString(12), rs.getString(13), rs.getString(14), rs.getInt(16));
    Date date = rs.getDate(15);
    student.RegDate = date;
    return student;
  }

  // Update Data
  public static void updateData(String id, String oldData, String newData) throws SQLException {
    Connection conn = DB.connect();
    String query = null;
    if (oldData.equals("Name")) {
      query = Query.updateName;
    } else if (oldData.equals("Course")) {
      query = Query.updateCourse;
    } else {
      query = Query.updateEmail;
    }

    PreparedStatement pstm = conn.prepareStatement(query);
    // Update
    // pstm.setString(1, oldData);
    pstm.setString(1, newData);
    pstm.setString(2, id);
    pstm.executeUpdate();

    System.out.println("Data Updated successfully!");
  }

  // Delete Data
  public static int deleteData(String rollNo) throws SQLException {
    Connection conn = DB.connect();
    String query = Query.delete;
    // Create Statement
    PreparedStatement pstm = conn.prepareStatement(query);
    pstm.setString(1, rollNo);
    int count = pstm.executeUpdate();
    System.out.println(count);
    return count;
    // System.out.println("Data Deleted successfully!");

  }

}
