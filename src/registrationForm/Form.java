package registrationForm;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import admin.Admin;
import admin.Admin.Display;
import jdbc.DAO;
import jdbc.Home;
//User defined package for JDBC
import jdbc.Student;

public class Form {
    MyFrame obj;
    public Form() {
    MyFrame obj = new MyFrame();
    }
    public static void main(String args[]) {
        MyFrame obj = new MyFrame();
    }
}
class MyFrame extends JFrame implements ActionListener {

    JLabel nameLab, rollNoLab, DOBLab, fatherNameLab, motherNameLab, mobNoLab, emailIdLab, genderLab, addressLab, msgLab, courseLab, semesterLab, passwordLab, cofPasswordLab;
    JTextField name, rollNo, fatherName, motherName, mobNo, emailId, password, cofPassword;
    JComboBox course, semester, day, month, year;
    JRadioButton male, female;
    JTextArea address;
    JCheckBox terms;
    JButton button, homeBtn;

 //Taking Data_Of_Birth
   String days[] = {"dd","1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15",
            "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
   String months[] = {"mm","jen", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
   String years[] = {
            "yy", "2024", "2023", "2022", "2021", "2020", "2019", "2018", "2017", "2016", "2015", "2014",
            "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000",
            "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988",
            "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975"
        };
        
   String courses[] = {"course","BTech", "Diploma","MTech"};
   String semesters[] = {"semester","First","Second","Third","Fourth","Fifth","Sixth","Seven","Eight"};
   
   int scwidth = 900, scheight = 1000;

    public MyFrame() {
        // Basic Setup   
        setTitle("Registration Form");
        setSize(scwidth, scheight);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(null);
        c.setBackground((Color.decode("#f0e9e9")));
         
        int leftColmrgn = 20, leftColmrgnInplft = 130, rightColmrgnInplft = 450, rightColmrgnInpRt = 550, topmrgn = 0, textWidth = 165, textHeight = 30;
        
        // Taking Name from user
        nameLab = new JLabel("Name");
        nameLab.setBounds(leftColmrgn, topmrgn+=50, textWidth, textHeight);
        c.add(nameLab);
        name = new JTextField();
        name.setBounds(leftColmrgnInplft, topmrgn, textWidth, textHeight);
        c.add(name);

        // Taking Roll_No from user
        rollNoLab = new JLabel("Roll No");
        rollNoLab.setBounds(rightColmrgnInplft, topmrgn,textWidth, textHeight);
        c.add(rollNoLab);
        rollNo = new JTextField();
        rollNo.setBounds(rightColmrgnInpRt, topmrgn, textWidth, textHeight);
        c.add(rollNo);
        
        // Taking course
        courseLab = new JLabel("Course");
        courseLab.setBounds(leftColmrgn, topmrgn+=50, textWidth, textHeight);
        c.add(courseLab);
        course = new JComboBox(courses);
        course.setBounds(leftColmrgnInplft, topmrgn, textWidth, textHeight);
        c.add(course);

        // Taking semester
        semesterLab = new JLabel("Semester");
        semesterLab.setBounds(rightColmrgnInplft, topmrgn,textWidth, textHeight);
        c.add(semesterLab);
        semester = new JComboBox(semesters);
        semester.setBounds(rightColmrgnInpRt, topmrgn,textWidth, textHeight);
        c.add(semester);

        // Taking Father's details
        fatherNameLab = new JLabel("Father's Name");
        fatherNameLab.setBounds(leftColmrgn, topmrgn+=50, textWidth, textHeight);
        c.add(fatherNameLab);
        fatherName = new JTextField();
        fatherName.setBounds(leftColmrgnInplft, topmrgn, textWidth, textHeight);
        c.add(fatherName);

        // Taking Mother's details
        motherNameLab = new JLabel("Mother's Name");
        motherNameLab.setBounds(rightColmrgnInplft, topmrgn,textWidth, textHeight);
        c.add(motherNameLab);
        motherName = new JTextField();
        motherName.setBounds(rightColmrgnInpRt, topmrgn,textWidth, textHeight);
        c.add(motherName);

        // Taking Mobile No
        mobNoLab = new JLabel("Mobile No");
        mobNoLab.setBounds(leftColmrgn, topmrgn+=50, textWidth, textHeight);
        c.add(mobNoLab);
        mobNo = new JTextField();
        mobNo.setBounds(leftColmrgnInplft, topmrgn, textWidth, textHeight);
        c.add(mobNo);

        //Taking email_id
        emailIdLab = new JLabel("Email Id");
        emailIdLab.setBounds(rightColmrgnInplft, topmrgn, textWidth, textHeight);
        c.add(emailIdLab);
        emailId = new JTextField();
        emailId.setBounds(rightColmrgnInpRt, topmrgn, textWidth, textHeight);
        c.add(emailId);
       
        // Taking DOB from user
        DOBLab = new JLabel("DOB");
        DOBLab.setBounds(leftColmrgn, topmrgn+=50, textWidth, textHeight);
        c.add(DOBLab);
        day = new JComboBox(days);
        month = new JComboBox(months);
        year = new JComboBox(years);
        c.add(day);
        c.add(month);
        c.add(year);

        day.setBounds(leftColmrgnInplft, topmrgn, textWidth-95, textHeight);
        month.setBounds(leftColmrgnInplft+80, topmrgn, textWidth-95, textHeight);
        year.setBounds(leftColmrgnInplft+160, topmrgn, textWidth-90, textHeight);

        // Taking Gender
        genderLab = new JLabel("Gender");
        genderLab.setBounds(leftColmrgn, topmrgn+=50, textWidth, textHeight);
        c.add(genderLab);

        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        male.setBounds(leftColmrgnInplft, topmrgn, textWidth-100, textHeight);
        female.setBounds(leftColmrgnInplft+80, topmrgn, textWidth-75, textHeight);
        c.add(male);
        c.add(female);

        ButtonGroup gen = new ButtonGroup();
        gen.add(male);
        gen.add(female);


        //Taking Password
        passwordLab = new JLabel("Password");
        passwordLab.setBounds(leftColmrgn, topmrgn+=50, textWidth, textHeight);
        c.add(passwordLab);
        password = new JTextField();
        password.setBounds(leftColmrgnInplft, topmrgn, textWidth, textHeight);
        c.add(password);

        //Conform Password
        cofPasswordLab = new JLabel("Conform Password");
        cofPasswordLab.setBounds(rightColmrgnInplft, topmrgn, textWidth, textHeight);
        c.add(cofPasswordLab);
        cofPassword = new JTextField();
        cofPassword.setBounds(rightColmrgnInpRt+20, topmrgn, textWidth, textHeight);
        c.add(cofPassword);
        
        
         // Taking Address
         addressLab = new JLabel("Address");
         addressLab.setBounds(leftColmrgn, topmrgn+=50, textWidth, textHeight);
         c.add(addressLab);
         address = new JTextArea();
         address.setBounds(leftColmrgnInplft, topmrgn, textWidth+50, textHeight+20);
         c.add(address);  

         // Terms and Condition
        terms = new JCheckBox();
        terms.setBounds(leftColmrgn, topmrgn+=70, 20, 20);
        c.add(terms);
        JLabel mes = new JLabel("Accept terms and condition");
        mes.setBounds(leftColmrgn+40, topmrgn, textWidth+100, 20);
        c.add(mes);

        // Submit Button
        button = new JButton("Submit");
        button.setBounds(leftColmrgn, topmrgn+=50, textWidth, textHeight);
        c.add(button);
        homeBtn = new JButton("Home");
        homeBtn.setBounds(leftColmrgnInplft+100, topmrgn,textWidth, textHeight);
        c.add(homeBtn);
        homeBtn.addActionListener(this);
        msgLab = new JLabel("");
        msgLab.setBounds(leftColmrgn, topmrgn+=50, textWidth+300, textHeight);
        c.add(msgLab);

        button.addActionListener(this);
         
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        String selectedBtn = ae.getActionCommand();
        if (selectedBtn.equals("Home")) {
            Home homePage = new Home(); 
            setVisible(false);
        } else{
        if(rollNo.getText().equals("") || name.getText().equals("") || day.getSelectedItem().equals("dd") || month.getSelectedItem().equals("mm") || year.getSelectedItem().equals("yy") ||
         fatherName.getText().equals("") || password.getText().equals("")) {
            msgLab.setText("Please complete the form before submiting!");
        } else if (!password.getText().equals(cofPassword.getText())) {
            msgLab.setText("Password not matched, Enter correct Password!");
        }
       // Verify checkbox is selected or not
        else if (terms.isSelected()) {
            msgLab.setText("Registration Successfull!");
            String temp = male.isSelected() ? "Male" : "Female";
            JLabel gen = new JLabel(temp);

            // Inserting data in database
            String Name = name.getText();
            String RollNo = rollNo.getText();
            String dob =  year.getSelectedItem()+"-" + month.getSelectedItem() + "-" + day.getSelectedItem();
            String Course = (String)course.getSelectedItem();
            String Semester = (String)semester.getSelectedItem();
            String FatherName = fatherName.getText();
            String MotherName = motherName.getText();
            String MobNo = mobNo.getText();
            String Email = emailId.getText();
            String Gender = male.isSelected() ? "Male" : "Female";
            String Address = address.getText();
            String Password = password.getText();
            Student student = new Student(RollNo, Name, Course, Semester, FatherName, MotherName, MobNo, Email, dob, Gender,Password, Address, 1);
            try{
            DAO.insertData(student);
            } catch(Exception e) {
                System.out.println(e);
            }
            Display obj = new Admin().new Display(student);
       
        } else {
            msgLab.setText("You have to accept terms and condition for submiting the form!");
        }
    }
    } 
}

// color (Color.decode("#f0e9e9"))