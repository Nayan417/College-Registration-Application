package user;

import java.awt.*;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.awt.Color;


import javax.swing.*;
import javax.swing.border.EmptyBorder;

//import admin.Admin;
//import admin.Admin.Display;
import jdbc.DAO;
import jdbc.Home;
//User defined package for JDBC
import jdbc.Student;
import jdbc.AdminPr.LogoAdm;

public class foclone extends JFrame implements ActionListener{
    public static void main(String[] args) {
        foclone obj = new foclone();
    }

    // Variable declaration
    public JPanel formPanel, headngPanel;
    public Container cn;
    JLabel nameLab, rollNoLab, DOBLab, fatherNameLab, motherNameLab, mobNoLab, emailLab, genderLab, addressLab, msgLab,
            courseLab, sessionLab, branchLab, semesterLab, passwordLab, cofPasswordLab, mes, logo;
    JTextField name, rollNo, fatherName, motherName, mobNo, email, cofPassword;
    JPasswordField password;
    JComboBox course, session, branch, semester, day, month, year;
    JRadioButton male, female;
    JTextArea address;
    JCheckBox terms;
    JButton submit, homeBtn;
    int fieldWidth = 20, fieldHeight = 10, textSize = 15;

    // Taking Data_Of_Birth
    String days[] = { "dd", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15",
            "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
    String months[] = { "mm", "jen", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
    String years[] = {
            "yy", "2024", "2023", "2022", "2021", "2020", "2019", "2018", "2017", "2016", "2015", "2014",
            "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000",
            "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988",
            "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975"
    };

    String courses[] = { "course", "BTech", "Diploma", "MTech" };
    String semesters[] = { "semester", "First", "Second", "Third", "Fourth", "Fifth", "Sixth", "Seven", "Eight" };

    // Initialize variable
    void init() {
        //this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        
        this.setBackground((Color.decode("#f0e9e9")));
         cn = getContentPane();
         cn.setLayout(new BorderLayout());
        formPanel = new JPanel();
        GridBagLayout gb = new GridBagLayout();
        formPanel.setLayout(gb);
        formPanel.setSize(new Dimension(1800, 900));
        headngPanel = new JPanel();
        headngPanel.setBackground(Color.red);
        headngPanel.setSize(new Dimension(300, 50));
        
        logo = new JLabel("");
        logo.setFont(new Font("Serif", Font.BOLD, textSize));
        
        JLabel logo2 = new JLabel("Cambridge Institute of Technology");
        logo2.setFont(new Font("Serif", Font.BOLD, textSize+2));
        logo2.setForeground(Color.BLUE);
        headngPanel.add(logo2);
        
        // headngPanel.setBorder(new EmptyBorder(10, 90, 10, 10));
        cn.add(headngPanel, BorderLayout.BEFORE_FIRST_LINE);
        //formPanel.setBackground(Color.YELLOW);
        
        // Taking Name from user
        nameLab = new JLabel("Name * ");
        nameLab.setFont(new Font("Serif", Font.BOLD, textSize));
        name = new JTextField(fieldWidth);
        name.setBounds(0, 0, 20, 30);

        // Taking Roll_No from user
        rollNoLab = new JLabel("Roll No * ");
        rollNoLab.setFont(new Font("Serif", Font.BOLD, textSize));
        rollNo = new JTextField(fieldWidth);

        // Taking course
        courseLab = new JLabel("Course * ");
        courseLab.setFont(new Font("Serif", Font.BOLD, textSize));
        course = new JComboBox(Student.getCourses());
        course.setFont(new Font("Serif", Font.BOLD, textSize+3));
        // Taking Session
        sessionLab = new JLabel("Session * ");
        sessionLab.setFont(new Font("Serif", Font.BOLD, textSize));
        session = new JComboBox(Student.getSessions());
        session.setFont(new Font("Serif", Font.BOLD, textSize));
        session.setSize(80, 60);

        // Taking Branch
        branchLab = new JLabel("Branch * ");
        branchLab.setFont(new Font("Serif", Font.BOLD, textSize));
        branch = new JComboBox(Student.getBranchs());
        branch.setFont(new Font("Serif", Font.BOLD, textSize));

        // Taking semester
        semesterLab = new JLabel("Semester * ");
        semesterLab.setFont(new Font("Serif", Font.BOLD, textSize));
        semester = new JComboBox(Student.getSemesters());
        semester.setFont(new Font("Serif", Font.BOLD, textSize));

        // Taking Father's details
        fatherNameLab = new JLabel("Father's Name * ");
        fatherNameLab.setFont(new Font("Serif", Font.BOLD, textSize));

        fatherName = new JTextField(fieldWidth);

        // Taking Mother's details
        motherNameLab = new JLabel("Mother's Name ");
        motherNameLab.setFont(new Font("Serif", Font.BOLD, textSize));

        motherName = new JTextField(fieldWidth);

        // Taking Mobile No
        mobNoLab = new JLabel("Mobile No * ");
        mobNoLab.setFont(new Font("Serif", Font.BOLD, textSize));
        mobNo = new JTextField(fieldWidth);

        // Taking email_id
        emailLab = new JLabel("Email Id * ");
        emailLab.setFont(new Font("Serif", Font.BOLD, textSize));
        email = new JTextField(fieldWidth);

        // Taking DOB from user
        DOBLab = new JLabel("DOB * ");
        DOBLab.setFont(new Font("Serif", Font.BOLD, textSize));

        day = new JComboBox(days);
        month = new JComboBox(months);
        year = new JComboBox(years);

        // Taking Gender
        genderLab = new JLabel("Gender ");
        genderLab.setFont(new Font("Serif", Font.BOLD, textSize));

        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        male.setFont(new Font("Serif", Font.BOLD, textSize));
        female.setFont(new Font("Serif", Font.BOLD, textSize));

        ButtonGroup gen = new ButtonGroup();
        gen.add(male);  gen.add(female);

        // Taking Password
        passwordLab = new JLabel("Password * ");
        passwordLab.setFont(new Font("Serif", Font.BOLD, textSize));
        password = new JPasswordField(fieldWidth);

        // Conform Password
        cofPasswordLab = new JLabel("Conform Password ");
        cofPasswordLab.setFont(new Font("Serif", Font.BOLD, textSize));
        cofPassword = new JTextField(fieldWidth);

        // Taking Address
        addressLab = new JLabel("Address");
        addressLab.setFont(new Font("Serif", Font.BOLD, textSize));
        address = new JTextArea(3, 30);

        // Terms and Condition
        terms = new JCheckBox();

        mes = new JLabel("Accept terms and condition !");
        mes.setFont(new Font("Serif", Font.BOLD, textSize));

        // Submit Button
        submit = new JButton("Submit");

        homeBtn = new JButton("Home");

        msgLab = new JLabel("");
    }

    public foclone() {
        init();
        setTitle("Registration Form");
        setLocationRelativeTo(null);
        this.setSize(1000, 900);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // Gridbag layout
        GridBagConstraints gc = new GridBagConstraints();

        gc.insets = new Insets(10, 20, 15, 0);
        gc.gridx = 0;
        gc.gridy = 2;
        formPanel.add(nameLab, gc);
        gc.gridx++;
        formPanel.add(name, gc);
        gc.gridx++;
        formPanel.add(rollNoLab, gc);
        gc.gridx++;
        formPanel.add(rollNo, gc);

        gc.insets = new Insets(20, 20, 5, 0);

        gc.gridy++;   gc.gridx = 0;
        formPanel.add(courseLab, gc);
        gc.gridx++;
        formPanel.add(course, gc);

        gc.gridx++;
        formPanel.add(sessionLab, gc);
        gc.gridx++;
        formPanel.add(session, gc);
        gc.gridx++;

        gc.gridy++;   gc.gridx = 0;
        formPanel.add(branchLab, gc);
        gc.gridx++;
        formPanel.add(branch, gc);

        gc.gridx++;
        formPanel.add(semesterLab, gc);
        gc.gridx++;
        formPanel.add(semester, gc);

        gc.gridy++;
        gc.gridx = 0;
      //  gc.insets = new Insets(5, 0, 5, 0);
        formPanel.add(fatherNameLab, gc);
        gc.gridx++;
      //  gc.insets = new Insets(5, 35, 5, 0);
        formPanel.add(fatherName, gc);

        gc.gridx++;
        formPanel.add(motherNameLab, gc);
        gc.gridx++;
        formPanel.add(motherName, gc);

        gc.gridy++;
        gc.gridx = 0;
      //  gc.insets = new Insets(20, 40, 5, 10);
        formPanel.add(mobNoLab, gc);
        gc.gridx++;
        formPanel.add(mobNo, gc);

        gc.gridx++;
        formPanel.add(emailLab, gc);
        gc.gridx++;
        formPanel.add(email, gc);

        gc.gridy++;
        gc.gridx = 0;
      //  gc.insets = new Insets(5, 0, 5, 10);
        formPanel.add(DOBLab, gc);
        gc.insets = new Insets(5, 0, 5, 0);
        gc.gridx++;
        formPanel.add(day, gc);
        gc.gridx++;
        formPanel.add(month, gc);
        gc.gridx++;
        formPanel.add(year, gc);

        gc.gridy++;
        gc.gridx = 0;
        formPanel.add(genderLab, gc);
        gc.gridx++;
        formPanel.add(male, gc);
        gc.gridx++;
        formPanel.add(female, gc);

        gc.gridy++;
        gc.gridx = 0;
        formPanel.add(passwordLab, gc);
        gc.gridx++;
        formPanel.add(password, gc);

        gc.gridx++;
        formPanel.add(cofPasswordLab, gc);
        gc.gridx++;
        formPanel.add(cofPassword, gc);

        gc.gridy++; gc.gridx = 0;
        formPanel.add(addressLab, gc);
        gc.gridx++;
        formPanel.add(address, gc);
        
        gc.gridy++; gc.gridx = 0;
        formPanel.add(terms,gc);
        gc.gridx++;
        formPanel.add(mes, gc);
 
          gc.gridy += 1; gc.gridx = 0;
          formPanel.add(submit, gc);
          submit.addActionListener(this);

          gc.gridx ++;
          formPanel.add(homeBtn, gc);
          homeBtn.addActionListener(this);

          gc.gridx = 1; gc.gridy += 1;
          formPanel.add(msgLab, gc);

        cn.add(formPanel, BorderLayout.CENTER);
        cn.setVisible(true);
        this.setVisible(false);
      }
      
      public void actionPerformed(ActionEvent ae) {
        String selectedBtn = ae.getActionCommand();
        if (selectedBtn.equals("Home")) {
         // cn.setVisible(false);
          dispose();
            new Home();
        } else {
            String Password = "";
            for (char ch : password.getPassword()) Password += ch;

            if (rollNo.getText().equals("") || name.getText().equals("") || day.getSelectedItem().equals("dd")
                    || month.getSelectedItem().equals("mm") || year.getSelectedItem().equals("yy") ||
                    fatherName.getText().equals("") || password.getText().equals("")) {
                msgLab.setText("Please complete the form before submiting!");
            } 
            else if (!(Password.equals(cofPassword.getText()))) {
                msgLab.setText("Password not matched, Enter correct Password!");
                System.out.println(Password);
                System.out.println(cofPassword.getText().toString());
            }
            // Verify checkbox is selected or not
            else if (!terms.isSelected()) {
                msgLab.setText("You have to accept terms and condition for submiting the form!");
            }
            else {
              msgLab.setText("Registration is under process!");
                String temp = male.isSelected() ? "Male" : "Female";
                JLabel gen = new JLabel(temp);
                // Inserting data in database
                String Name = name.getText();
                String RollNo = rollNo.getText();
                String dob = year.getSelectedItem() + "-" + month.getSelectedItem() + "-" + day.getSelectedItem();
                String Course = (String) course.getSelectedItem();
                String Semester = (String) semester.getSelectedItem();
                String Session = (String) session.getSelectedItem();
                String Branch = (String)branch.getSelectedItem();
                String FatherName = fatherName.getText();
                String MotherName = motherName.getText();
                String MobNo = mobNo.getText();
                String Email = email.getText();
                String Gender = male.isSelected() ? "Male" : "Female";
                String Address = address.getText();
               // String Password = password.getPassword().toString();
                Student student = new Student(RollNo, Name, Course, Session, Branch, Semester, FatherName, MotherName, MobNo, Email, dob,
                        Gender, Password, Address, 1);
                try {
                           // Check either roll No already exist or not
                   if (DAO.readSpData(rollNo.getText()) != null) {
                    msgLab.setText("Entered rollNo already exit, Try for new user");
                   } else {
                    new ConformationForm(student);
                    msgLab.setText("Registration Successfull!");
                    dispose();
                  }
                } catch (Exception e) {
                  msgLab.setText("Registration was unsuccessful! Please try again");
                    System.out.println(e);
                }
             //   Display obj = new Admin().new Display(student);
            }
        }
    }
}