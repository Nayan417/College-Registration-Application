package jdbc.Admin;

import java.util.ArrayList;
import java.sql.Date;
import java.util.Scanner;

public class Admin {
 static Scanner input = new Scanner(System.in);

 int id;
 String name;
 String fatherName;
 String mobNo;
 String emailId;
 String dob;
 String gender;
 String address;
 String password;
 Date RegDate;
 int status;

 public Admin() {
  System.out.print("\nEnter name: ");
  name = input.nextLine();

  System.out.print("\nEnter Father's Name: ");
   fatherName = input.nextLine();

  System.out.print("\nEnter Mobile No: ");
   mobNo = input.nextLine(); 

 }
 
 // Parameterized Constructor
 public Admin(int id, String name, String fatherName, String mobNo,
 String emailId, String dob, String gender, String address, String password, int status) {
  
  this.id = id;
  this.name = name;
  this.fatherName = fatherName;
  this.mobNo = mobNo;
  this.emailId = emailId;
  this.dob = dob;
  this.gender = gender;
  this.address = address; 
  this.password = password;
  this.status = status;
 }

 // Get data member
 public int getId() {return this.id;}
 public String getName() {return this.name;}
 public String getMobNo() {return this.mobNo;}
 public String getFatherName() {return this.fatherName;}
 public String getEmailId() {return this.emailId;}
 public String getDob() {return this.dob;}
 public String getGender() {return this.gender;}
 public String getAddress() {return this.address;}
 public String getPassword() {return this.password;}
 public Date getRegDate() {return this.RegDate;}
 public int getStatus() {return this.status;}

// Displaying data
  public static void displayData(ArrayList<Admin> admins){
  System.out.println("Student Registered details \n");
  System.out.println("RollNo\tName\tCourse\tSemester\tFather's Name\tMotherName+\tMobNo\tEmail+\tDOB\tGender\taddress\tRegDate\tStatus");

  for(Admin admin : admins) {
  //  System.out.println(admin.rollNo +"\t"+admin.name+"\t"+admin.course+"\t"+student.semester+"\t"+ student.fatherName +"\t"+student.motherName+"\t"+
  //        student.mobNo+"\t"+student.emailId+"\t"+student.dob+"\t"+ student.gender+"\t"+student.address+"\t"+student.RegDate+"\t"+student.status);
   
  }
 }
}



/*
 * Student( String rollNo, String name, String course, String semester, String fatherName, String motherName, String mobNo,
 String emailId, String dob, String gender, String address)
 */