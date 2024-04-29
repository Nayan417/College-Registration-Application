package jdbc.Admin;

import java.util.ArrayList;
import java.sql.Date;
import java.util.Scanner;

public class Admin {
 static Scanner input = new Scanner(System.in);

 String id;
 String name;
 String fatherName;
 String mobNo;
 String emailId;
 String dob;
 String gender;
 String address;
 String type;
 String password;
 static Date RegDate;
 int status;

    // Taking Data_Of_Birth
 static String days[] = { "dd", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15",
            "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
 static String months[] = { "mm", "jen", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
 static String years[] = {
            "yy", "2024", "2023", "2022", "2021", "2020", "2019", "2018", "2017", "2016", "2015", "2014",
            "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000",
            "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988",
            "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975"
    };

  static String types[] = {"Primary", "Secondar"};  
 
 // Parameterized Constructor
 public Admin(String id, String name, String fatherName, String mobNo,
 String emailId, String dob, String gender, String address, String type, String password, int status) {
  
  this.id = id;
  this.name = name;
  this.fatherName = fatherName;
  this.mobNo = mobNo;
  this.emailId = emailId;
  this.dob = dob;
  this.gender = gender;
  this.address = address; 
  this.type = type; 
  this.password = password;
  this.status = status;
 }

 // Get data member
 public String getId() {return this.id;}
 public String getName() {return this.name;}
 public String getMobNo() {return this.mobNo;}
 public String getFatherName() {return this.fatherName;}
 public String getEmailId() {return this.emailId;}
 public String getDob() {return this.dob;}
 public String getGender() {return this.gender;}
 public String getAddress() {return this.address;}
 public String getType() {return this.type;}
 public String getPassword() {return this.password;}
 public Date getRegDate() {return this.RegDate;}
 public int getStatus() {return this.status;}

 // static method
 static public String[] getYears() {return years;}
 static public String[] getMonths() {return months;}
 static public String[] getDays() {return days;}
 static public String[] getTypes() {return types;}

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