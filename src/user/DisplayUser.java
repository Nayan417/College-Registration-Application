package user;

import java.awt.*;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.awt.Color;

import javax.swing.*;

//import admin.Admin;
//import admin.Admin.Display;
import jdbc.DAO;
import jdbc.Home;
//User defined package for JDBC
import jdbc.Student;
import jdbc.AdminPr.LogoAdm;

public class DisplayUser extends JFrame implements ActionListener {

  // Variable declaration
  public JPanel headingPanel, formPanel, buttonPanel;
  public Container cn;
  JLabel heading, nameLab, rollNoLab, DOBLab, fatherNameLab, motherNameLab, mobNoLab, emailLab, genderLab, addressLab, msgLab,
      courseLab, semesterLab, passwordLab, cofPasswordLab, mes;
  JTextField name, rollNo, fatherName, motherName, mobNo, email, cofPassword, course, semester, dob, address, gender;
  JPasswordField password;
  JCheckBox terms;
  JRadioButton male, female;
  JButton printBtn, homeBtn;
  GridBagLayout gb;
  GridBagConstraints gc;
  int fieldWidth = 15, fieldHeight = 10, textSize = 12;

  Student student;

  public DisplayUser(String studentId) {
    init();
    System.out.println(studentId);

    this.rollNo.setText(studentId);
    // this.password.setText(pass);
    // this.cofPassword.setText(pass);

    // Gridbag layout
    GridBagLayout gb = new GridBagLayout();
    GridBagConstraints gc = new GridBagConstraints();
    formPanel.setLayout(gb);

    // Data Fetching from database
    try {
      student = DAO.readSpData(studentId);
      if (student == null) {
        System.out.println("Record doesn't exit!");
        mes.setText("Record doesn't exit!");
      }
    else {
    name.setText(student.getName());
    course.setText(student.getCourse());
    semester.setText(student.getSemester());
    fatherName.setText(student.getFatherName());
    motherName.setText(student.getMotherName());
    mobNo.setText(student.getMobNo());
    email.setText(student.getEmailId());
    address.setText(student.getAddress());
    dob.setText(student.getDob());
    gender.setText(student.getGender());

    terms.doClick();
    // Making all the file non-ediatable
    gc.insets = new Insets(40, 0, 10, 0);
    gc.gridx = 1;    gc.gridy = 0;
    // formPanel.add(heading, gc);
    JLabel p = new JLabel("C.I.T");
    headingPanel = new JPanel();
    headingPanel.setBackground(Color.green);
    headingPanel.add(p);
   // formPanel.add(headingPanel);
    
    name.setEditable(false);
    
    gc.insets = new Insets(17, 10, 17, 10);
    gc.gridx = 0;    gc.gridy +=2;
    formPanel.add(nameLab, gc);
    gc.gridx++;
    formPanel.add(name, gc);
    gc.gridx++;
    //gc.insets = new Insets(5, 10, 5, 10);
    formPanel.add(rollNoLab, gc);
    gc.gridx++;
    formPanel.add(rollNo, gc);
    rollNo.setEditable(false);

    gc.gridy++;
    gc.gridx = 0;
    formPanel.add(courseLab, gc);
    gc.gridx++;
    formPanel.add(course, gc);
    gc.gridx++;
    formPanel.add(semesterLab, gc);
    gc.gridx++;
    formPanel.add(semester, gc);

    gc.gridy++;
    gc.gridx = 0;
    formPanel.add(fatherNameLab, gc);
    gc.gridx++;
    formPanel.add(fatherName, gc);

    gc.gridx++;
    formPanel.add(motherNameLab, gc);
    gc.gridx++;
    formPanel.add(motherName, gc);

    gc.gridy++;
    gc.gridx = 0;
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
    gc.gridx++;
    formPanel.add(dob, gc);

    gc.gridy++;
    gc.gridx = 0;
    formPanel.add(genderLab, gc);
    gc.gridx++;
    formPanel.add(gender, gc);

/*
    gc.gridy++;
    gc.gridx = 0;
    formPanel.add(passwordLab, gc);
    gc.gridx++;
    formPanel.add(password, gc);
    gc.gridx++;
*/
    gc.gridy++;
    gc.gridx = 0;
    formPanel.add(addressLab, gc);
    gc.gridx++;
    formPanel.add(address, gc);

    gc.gridy++; gc.gridx = 0;
    formPanel.add(terms,gc);
    gc.gridx++;
    formPanel.add(mes, gc);

    gc.gridy += 1;
    gc.gridx = 0;
    printBtn.addActionListener(this);
    
    gc.gridx++;
    //cn.add(editBtn);
    homeBtn.addActionListener(this);
    
    gc.gridx = 1;
    gc.gridy += 1;
    formPanel.add(msgLab, gc);
    
     gc.insets = new Insets(0, 0, 150,15);
     gc.gridx = 0; gc.gridy = 0;
     buttonPanel.add(printBtn, gc); gc.gridx++;
     buttonPanel.add(homeBtn, gc);

  /// formPanel.setBackground(Color.YELLOW);
   buttonPanel.setBackground(Color.RED);

    // headingPanel.add(heading);
    cn.add(formPanel,   BorderLayout.WEST);
    cn.add(buttonPanel, BorderLayout.SOUTH);

    // formPanel.setVisible(false);
    this.setVisible(true);
  }
}
    catch (Exception e) {
      System.out.println(e);
    }
    /// *
  }

  // Initialize variable
  void init() {
    setTitle("Display Form");
    setLocationRelativeTo(null);
    this.setSize(1800, 1000);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    formPanel = new JPanel();
    buttonPanel = new JPanel();
    gb = new GridBagLayout();
    gc = new GridBagConstraints();
    this.setBackground((Color.decode("#f0e9e9")));
    cn = getContentPane();
    cn.setLayout(new BorderLayout());
    buttonPanel.setLayout(new GridBagLayout());
    cn.setBackground((Color.decode("#f0e9e9")));

    formPanel.setSize(new Dimension(1800, 1000));
    buttonPanel.setPreferredSize(new Dimension(400, 200));
    buttonPanel.setBackground(Color.MAGENTA);
    
    heading = new JLabel("Cambridge Instutite of Technology");
    heading.setFont(new Font("Serif", Font.BOLD, textSize));
    
    heading.setForeground(Color.red);
    // Taking Name from user
    nameLab = new JLabel("Name * ");
    nameLab.setFont(new Font("Serif", Font.BOLD, textSize));
    name = new JTextField(fieldWidth);
    name.setFont(new Font("Serif", Font.BOLD, textSize));

    // Taking Roll_No from user
    rollNoLab = new JLabel("Roll No * ");
    rollNoLab.setFont(new Font("Serif", Font.BOLD, textSize));
    rollNo = new JTextField(fieldWidth);
    rollNo.setFont(new Font("Serif", Font.BOLD, textSize));

    // Taking course
    courseLab = new JLabel("Course * ");
    courseLab.setFont(new Font("Serif", Font.BOLD, textSize));
    course = new JTextField(fieldWidth);
    course.setEditable(false);
    course.setFont(new Font("Serif", Font.BOLD, textSize));

    // Taking semester
    semesterLab = new JLabel("Semester * ");
    semesterLab.setFont(new Font("Serif", Font.BOLD, textSize));
    semester = new JTextField(fieldWidth);
    semester.setEditable(false);
    semester.setFont(new Font("Serif", Font.BOLD, textSize));

    // Taking Father's details
    fatherNameLab = new JLabel("Father's Name * ");
    fatherNameLab.setFont(new Font("Serif", Font.BOLD, textSize));
    fatherName = new JTextField(fieldWidth);
    fatherName.setFont(new Font("Serif", Font.BOLD, textSize));
    fatherName.setEditable(false);

    // Taking Mother's details
    motherNameLab = new JLabel("Mother's Name ");
    motherNameLab.setFont(new Font("Serif", Font.BOLD, textSize));
    motherName = new JTextField(fieldWidth);
    motherName.setFont(new Font("Serif", Font.BOLD, textSize));
    motherName.setEditable(false);

    // Taking Mobile No
    mobNoLab = new JLabel("Mobile No * ");
    mobNoLab.setFont(new Font("Serif", Font.BOLD, textSize));
    mobNo = new JTextField(fieldWidth);
    mobNo.setFont(new Font("Serif", Font.BOLD, textSize));
    mobNo.setEditable(false);

    // Taking email_id
    emailLab = new JLabel("Email Id * ");
    emailLab.setFont(new Font("Serif", Font.BOLD, textSize));
    email = new JTextField(fieldWidth);
    email.setFont(new Font("Serif", Font.BOLD, textSize));
    email.setEditable(false);

    // Taking DOB from user
    DOBLab = new JLabel("DOB * ");
    DOBLab.setFont(new Font("Serif", Font.BOLD, textSize));
    dob = new JTextField(fieldWidth);
    dob.setFont(new Font("Serif", Font.BOLD, textSize));
    dob.setEditable(false);

    // Taking Gender
    genderLab = new JLabel("Gender ");
    genderLab.setFont(new Font("Serif", Font.BOLD, textSize));
    gender = new JTextField(fieldWidth);
    gender.setEditable(false);
    gender.setFont(new Font("Serif", Font.BOLD, textSize));
    /*
    // Taking Password
    passwordLab = new JLabel("Password * ");
    passwordLab.setFont(new Font("Serif", Font.BOLD, textSize));
    password = new JPasswordField(fieldWidth);
*/
    // Taking Address
    addressLab = new JLabel("Address");
    addressLab.setFont(new Font("Serif", Font.BOLD, textSize));
    address = new JTextField(fieldWidth);
    address.setFont(new Font("Serif", Font.BOLD, textSize));
    
    terms = new JCheckBox();
    mes = new JLabel("Accepted Terms and conditions!");    

    // Submit Button
    printBtn = new JButton("Print");

    homeBtn = new JButton("Home");

    msgLab = new JLabel("");
    // cn.add(formPanel, BorderLayout.NORTH);
    this.setVisible(true);
  }

  public void actionPerformed(ActionEvent ae) {
    String clickedBtn = ae.getActionCommand();

    // For printing
    if (clickedBtn.equals("Print")){
    Toolkit tkp = formPanel.getToolkit();
    PrintJob pjp = tkp.getPrintJob(this, null, null);
    Graphics g = pjp.getGraphics();
    formPanel.print(g);
    g.dispose();
    pjp.end();
    } 
    // For Editing 
    else {
      new Home();
      dispose();
    }

  }

  public static void main(String[] args) {
    new DisplayUser("19");
  }

}
