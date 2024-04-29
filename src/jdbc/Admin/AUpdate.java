package jdbc.Admin;

import java.awt.*;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.awt.Color;

import javax.swing.*;

import jdbc.DAO;
import jdbc.Home;
//User defined package for JDBC
import jdbc.Student;
import jdbc.AdminPr.LogoAdm;

public class AUpdate extends JFrame implements ActionListener {

  // Variable declaration
  public JPanel formPanel, loginPanel;
  public Container cn;
  JLabel nameLab, idLab, DOBLab, fatherNameLab, mobNoLab, emailLab, genderLab, addressLab, msgLab,
  passwordLab, cofPasswordLab, mes;
JTextField name, id, fatherName, mobNo, email, cofPassword;
JPasswordField password;
JComboBox type, day, month, year;
JRadioButton male, female;
JTextArea address;
JCheckBox terms;
JButton submitBtn, homeBtn, enterBtn;
int fieldWidth = 20, fieldHeight = 10, textSize = 15;

GridBagLayout gb = new GridBagLayout();
GridBagConstraints gc = new GridBagConstraints();

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

String types[] = {"Primary", "Secondar"};


  Admin admin; 
  String studentId;

  public AUpdate() {
    init();
    cn.add(updateLogin(), BorderLayout.NORTH);
    // studentId = "D49";
    // update();
  }

  // Initialize variable
  void init() {
    setTitle("Update Form");
    setLocationRelativeTo(null);
    this.setSize(1000, 900);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    formPanel = new JPanel();
    loginPanel = new JPanel();
    gb = new GridBagLayout();
    gc = new GridBagConstraints();
    this.setBackground((Color.decode("#f0e9e9")));
    cn = getContentPane();
    cn.setLayout(new BorderLayout());
    loginPanel.setLayout(new GridBagLayout());
    cn.setBackground((Color.decode("#f0e9e9")));

    formPanel.setSize(new Dimension(1800, 900));
    loginPanel.setPreferredSize(new Dimension(400, 200));
    loginPanel.setBackground(Color.MAGENTA);
    // Taking Name from user
    nameLab = new JLabel("Name * ");
    nameLab.setFont(new Font("Serif", Font.BOLD, textSize));
    name = new JTextField(fieldWidth);
    name.setBounds(0, 0, 20, 30);

    // Taking Roll_No from user
    idLab = new JLabel("Login Id * ");
    idLab.setFont(new Font("Serif", Font.BOLD, textSize));
    id = new JTextField(fieldWidth);

    // Taking Father's details
    fatherNameLab = new JLabel("Father's Name * ");
    fatherNameLab.setFont(new Font("Serif", Font.BOLD, textSize));

    fatherName = new JTextField(fieldWidth);

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
    
    type = new JComboBox(types);

    // Taking Gender
    genderLab = new JLabel("Gender ");
    genderLab.setFont(new Font("Serif", Font.BOLD, textSize));

    male = new JRadioButton("Male");
    female = new JRadioButton("Female");
    male.setFont(new Font("Serif", Font.BOLD, textSize));
    female.setFont(new Font("Serif", Font.BOLD, textSize));

    ButtonGroup gen = new ButtonGroup();
    gen.add(male);
    gen.add(female);

    // Taking Password
    passwordLab = new JLabel("Password * ");
    passwordLab.setFont(new Font("Serif", Font.BOLD, textSize));
    password = new JPasswordField(fieldWidth);

    // Confirming Password
    cofPasswordLab = new JLabel("Password * ");
    cofPasswordLab.setFont(new Font("Serif", Font.BOLD, textSize));
    cofPassword = new JPasswordField(fieldWidth);

    // Taking Address
    addressLab = new JLabel("Address");
    addressLab.setFont(new Font("Serif", Font.BOLD, textSize));
    address = new JTextArea(3, 30);

    // Submit Button
    submitBtn = new JButton("Submit");

    homeBtn = new JButton("Home");

    msgLab = new JLabel("");
    // cn.add(loginPanel, BorderLayout.NORTH);
    // cn.add(formPanel, BorderLayout.NORTH);
    this.setVisible(true);
  }


  public JPanel update() {
   // init();
   System.out.println(studentId);

    this.id.setText(this.studentId);
     //  this.password.setText(pass);
     //  this.cofPassword.setText(pass);

    // Gridbag layout
    GridBagLayout gb = new GridBagLayout();
    GridBagConstraints gc = new GridBagConstraints();
    formPanel.setLayout(gb);

    // Data Fetching from database
    try {
      admin = ADAO.readSpData(studentId);
    } catch (Exception e) {
      System.out.println(e);
    }
    /// *
    name.setText(admin.getName());
    fatherName.setText(admin.getFatherName());
    mobNo.setText(admin.getMobNo());
    email.setText(admin.getEmailId());
    address.setText(admin.getAddress());
    String dob = admin.getDob();
    year.setSelectedItem(dob.substring(0, 4));
    month.setSelectedItem(dob.substring(5, 8));
    day.setSelectedItem(dob.substring(9, dob.length()));
    if (admin.getGender().equals("Male")) {
      male.doClick();
    } else {
      female.doClick();
    }

    gc.insets = new Insets(30, 20, 5, 0);
    gc.gridx = 0;
    gc.gridy = 0;
    formPanel.add(nameLab, gc);
    gc.gridx++;
    formPanel.add(name, gc);
    gc.gridx++;
    formPanel.add(idLab, gc);
    gc.gridx++;
    formPanel.add(id, gc);
    id.setEditable(false);

    gc.gridy++;    gc.gridx = 0;
    // gc.insets = new Insets(5, 0, 5, 0);
    formPanel.add(fatherNameLab, gc);
    gc.gridx++;
    // gc.insets = new Insets(5, 35, 5, 0);
    formPanel.add(fatherName, gc);

    gc.gridy++;
    gc.gridx = 0;
    // gc.insets = new Insets(20, 40, 5, 10);
    formPanel.add(mobNoLab, gc);
    gc.gridx++;
    formPanel.add(mobNo, gc);

    gc.gridx++;
    formPanel.add(emailLab, gc);
    gc.gridx++;
    formPanel.add(email, gc);

    gc.gridy++;
    gc.gridx = 0;
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

    gc.gridx++;
    formPanel.add(cofPasswordLab, gc);
    gc.gridx++;
    formPanel.add(cofPassword, gc);
    gc.gridx++;

    gc.gridy++;
    gc.gridx = 0;
    formPanel.add(addressLab, gc);
    gc.gridx++;
    formPanel.add(address, gc);

    gc.gridy += 1;
    gc.gridx = 0;
    formPanel.add(submitBtn, gc);
    submitBtn.addActionListener(this);

    gc.gridx++;
    formPanel.add(homeBtn, gc);
    homeBtn.addActionListener(this);

    gc.gridx = 1;
    gc.gridy += 1;
    formPanel.add(msgLab, gc);

    cn.add(formPanel, BorderLayout.NORTH);
    // formPanel.setVisible(false);
    setVisible(true);
    return formPanel;
    
  }

  // Take student as paremeter
  public JPanel update(Admin admin) {
    // init();
    //System.out.println(studentId);
 
     this.id.setText(this.studentId);
      //  this.password.setText(pass);
      //  this.cofPassword.setText(pass);
 
     // Gridbag layout
     GridBagLayout gb = new GridBagLayout();
     GridBagConstraints gc = new GridBagConstraints();
     formPanel.setLayout(gb);
 
     name.setText(admin.getName());
    fatherName.setText(admin.getFatherName());
    mobNo.setText(admin.getMobNo());
    email.setText(admin.getEmailId());
    address.setText(admin.getAddress());
    String dob = admin.getDob();
    year.setSelectedItem(dob.substring(0, 4));
    month.setSelectedItem(dob.substring(5, 8));
    day.setSelectedItem(dob.substring(9, dob.length()));
    if (admin.getGender().equals("Male")) {
      male.doClick();
    } else {
      female.doClick();
    }

     gc.insets = new Insets(30, 20, 5, 0);
     gc.gridx = 0;
     gc.gridy = 0;
     formPanel.add(nameLab, gc);
     gc.gridx++;
     formPanel.add(name, gc);
     gc.gridx++;
     formPanel.add(idLab, gc);
     gc.gridx++;
     formPanel.add(id, gc);
     id.setEditable(false);
 
     gc.gridy++;    gc.gridx = 0;
     // gc.insets = new Insets(5, 0, 5, 0);
     formPanel.add(fatherNameLab, gc);
     gc.gridx++;
     // gc.insets = new Insets(5, 35, 5, 0);
     formPanel.add(fatherName, gc);
 
     gc.gridy++;
     gc.gridx = 0;
     // gc.insets = new Insets(20, 40, 5, 10);
     formPanel.add(mobNoLab, gc);
     gc.gridx++;
     formPanel.add(mobNo, gc);
 
     gc.gridx++;
     formPanel.add(emailLab, gc);
     gc.gridx++;
     formPanel.add(email, gc);
 
     gc.gridy++;
     gc.gridx = 0;
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
 
     gc.gridx++;
     formPanel.add(cofPasswordLab, gc);
     gc.gridx++;
     formPanel.add(cofPassword, gc);
     gc.gridx++;
 
     gc.gridy++;
     gc.gridx = 0;
     formPanel.add(addressLab, gc);
     gc.gridx++;
     formPanel.add(address, gc);
 
     gc.gridy += 1;
     gc.gridx = 0;
     formPanel.add(submitBtn, gc);
     submitBtn.addActionListener(this);
 
     gc.gridx++;
     formPanel.add(homeBtn, gc);
     homeBtn.addActionListener(this);
 
     gc.gridx = 1;
     gc.gridy += 1;
     formPanel.add(msgLab, gc);
 
     cn.add(formPanel, BorderLayout.NORTH);
     // formPanel.setVisible(false);
     setVisible(true);
     return formPanel;
     
   }
 
  public JPanel updateLogin() {
    // loginPanel.setLayout(new GridLayout(2,2));
    // Taking Roll_No from user

    gc.insets = new Insets(10, 10, 20, 10);
    gc.gridx = 0;
    gc.gridy = 0;
    idLab = new JLabel("Enter Login Id");
    idLab.setFont(new Font("Serif", Font.BOLD, 17));
    loginPanel.add(idLab, gc);

    gc.gridx = 2;
    id = new JTextField(10);
    id.setFont(new Font("Serif", Font.BOLD, 17));
    loginPanel.add(id, gc);
    
    gc.gridy += 2; gc.gridx = 0;
    enterBtn = new JButton("Enter");
    loginPanel.add(enterBtn, gc);
    enterBtn.addActionListener(this);
    
    gc.gridx++;
    msgLab.setBackground(Color.red);
    loginPanel.add(msgLab,gc);
    this.setVisible(true);
    cn.add(loginPanel, BorderLayout.NORTH);
    return loginPanel;
  }

  public void actionPerformed(ActionEvent ae) {
    try {
      String selectedBtn = ae.getActionCommand();

      if (selectedBtn.equals("Enter")) {
         studentId = this.id.getText();
         System.out.println("RN " + studentId);
        if (studentId == null || !ADAO.adminExist(studentId)) {
          msgLab.setText("Entered Valid Roll No Or Record Doesn't Exit!");
         // studentId = null;
        } else {
          loginPanel.setVisible(false);
          msgLab.setText("");
          try {
            admin = ADAO.readSpData(studentId);
            if (admin == null) {
              msgLab.setText("Record doesnot exit");
            } else
              update(admin);
          } catch (Exception e) {
            System.out.println(e);
          }
        }
      } else if (selectedBtn.equals("Home")) {
        AdminHome home = new AdminHome();
        System.out.println("Home ");
        // setVisible(false);
      } else {
        String pasString = "";
        for (char ch : password.getPassword())
          pasString += ch;

        if (id.getText().equals("") || name.getText().equals("") || day.getSelectedItem().equals("dd")
            || month.getSelectedItem().equals("mm") || year.getSelectedItem().equals("yy") ||
            fatherName.getText().equals("") || password.getText().equals("")) {
          msgLab.setText("Please complete the form before submiting!");
        } else if (!(pasString.equals(cofPassword.getText()))) {
          msgLab.setText("Password not matched, Enter correct Password!");
          System.out.println(pasString);
          System.out.println(cofPassword.getText().toString());
        } else {
          msgLab.setText("Data Updation Successfull!");
          String temp = male.isSelected() ? "Male" : "Female";
          JLabel gen = new JLabel(temp);

          // Inserting data in database

          String Name = name.getText();
          String Id = id.getText();
          String dob = year.getSelectedItem() + "-" + month.getSelectedItem() + "-" + day.getSelectedItem();
          String FatherName = fatherName.getText();
          String MobNo = mobNo.getText();
          String Email = email.getText();
          String Gender = male.isSelected() ? "Male" : "Female";
          String Address = address.getText();
          String Type = ""+type.getSelectedItem() +" ";
          String Password = cofPassword.getText();

          Admin admin = new Admin(Id, Name, FatherName, MobNo, Email, dob, Gender,Address, Type, Password, 1);
          // Data Insertation

          // Deleted Old data
          boolean status = ADAO.deleteData(studentId);
          // Insert new data
          ADAO.insertAdmData(admin);

        //  Display obj = new Admin().new Display(student);
        }
      }
    } catch (Exception e) {
      System.out.println(e);
    }

  }

  public static void main(String[] args) {
    new AUpdate();
  }

}

