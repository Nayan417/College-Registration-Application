package jdbc;

import java.util.ArrayList;
import java.sql.Date;
import java.util.Scanner;

public class Student {
 static Scanner input = new Scanner(System.in);

 String rollNo;
 String name;
 String course;
 String semester;
 String fatherName;
 String motherName;
 String mobNo;
 String emailId;
 String dob;
 String gender;
 String address;
 String password;
 Date RegDate;
 int status;

 
 public Student() {
  System.out.print("\nEnter Roll No: ");
  rollNo = input.nextLine();

  System.out.print("\nEnter name: ");
  name = input.nextLine();

  System.out.print("\nEnter course: ");
   course = input.nextLine();

  System.out.print("\nEnter semester: ");
   semester = input.nextLine();

  System.out.print("\nEnter Father's Name: ");
   fatherName = input.nextLine();

  System.out.print("\nEnter Mother's Name: ");
   motherName = input.nextLine(); 

  System.out.print("\nEnter Mobile No: ");
   mobNo = input.nextLine(); 

  /*
   *  emailId = input.nextLine();
   *  dob = input.nextLine();
   *  gender = input.nextLine();
   *  address = input.nextLine();
   *  AppDate = input.nextLine();
   *  status = 1;
   */
 }
 
 // Parameterized Constructor
 public Student( String rollNo, String name, String course, String semester, String fatherName, String motherName, String mobNo,
 String emailId, String dob, String gender, String address, String password,  int status) {
  
  this.rollNo = rollNo;
  this.name = name;
  this.course = course;
  this.semester = semester;
  this.fatherName = fatherName;
  this.motherName = motherName;
  this.mobNo = mobNo;
  this.emailId = emailId;
  this.dob = dob;
  this.gender = gender;
  this.address = address;
  this.password = password;
  this.course = course; 
  this.status = status;
 }

 // Get data member
 public String getRollNo() {return this.rollNo;}
 public String getName() {return this.name;}
 public String getCourse() {return this.course;}
 public String getSemester() {return this.semester;}
 public String getMobNo() {return this.mobNo;}
 public String getFatherName() {return this.fatherName;}
 public String getMotherName() {return this.motherName;}
 public String getEmailId() {return this.emailId;}
 public String getDob() {return this.dob;}
 public String getGender() {return this.gender;}
 public String getAddress() {return this.address;}
 public String getPassword() {return this.password;}
 public Date getRegDate() {return this.RegDate;}
 public int getStatus() {return this.status;}

 // Display Data  public static void display(ArrayList<Student> students) {
  public static void displayData(ArrayList<Student> students){
  System.out.println("Student Registered details \n");
  System.out.println("RollNo\tName\tCourse\tSemester\tFather's Name\tMotherName+\tMobNo\tEmail+\tDOB\tGender\taddress\tpassword\tRegDate\tStatus");

  for(Student student : students) {
   System.out.println(student.rollNo +"\t"+student.name+"\t"+student.course+"\t"+student.semester+"\t"+ student.fatherName +"\t"+student.motherName+"\t"+
         student.mobNo+"\t"+student.emailId+"\t"+student.dob+"\t"+ student.gender+"\t"+student.address+"\t"+student.password+"\t"+student.RegDate+"\t"+student.status);
   
  }
 }
}

/*
 * Student( String rollNo, String name, String course, String semester, String fatherName, String motherName, String mobNo,
 String emailId, String dob, String gender, String address)
 */