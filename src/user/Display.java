package user;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Label;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;

import jdbc.DAO;
import jdbc.Student;

public class Display extends JFrame {
 JLabel name, rollNo, course, session, branch, semester, fatherName, motherName, mobNo, emailId, DOB, gender, address, regDate, password, status, mesLab;
 JPanel headPanel, dataPanel; 
 GridBagLayout gb;  GridBagConstraints gc;
 public Container cn; 
 ArrayList<JLabel> heading = new ArrayList<>();
 int headtextSize = 15, dataTextSize = 10;
 
 
 public static void main(String[] args) {
    try{
    Display obj = new Display();
 //   obj.displayHeading();
    ArrayList<Student> students = DAO.readData();
    obj.displayData(students);
  } catch(Exception e) {
    System.out.println(e);
  }
 }
 
public Display() {
  this.setTitle("Display Data");
  this.setSize(1200, 1000);
  this.setDefaultCloseOperation(EXIT_ON_CLOSE);
  this.setLocationRelativeTo(null);
  this.setLayout(new BorderLayout());
  cn = getContentPane();
  cn.setLayout(new BorderLayout());
  init();

  dispose();

}

void init() {
  gb = new GridBagLayout();
  gc = new GridBagConstraints();
  headPanel = new JPanel(gb);
  dataPanel = new JPanel(gb);
  gc.insets = new Insets(10, 5, 10, 5);
  //dataPanel.setPreferredSize(new Dimension(1000,400));

  dataPanel.setBackground((Color.decode("#f0e9e9")));
  headPanel.setBackground((Color.decode("#f0e5e7")));

  mesLab = new JLabel();
  mesLab.setFont(new Font("Serif", Font.BOLD, headtextSize+5));
 
  // Taking Name from user
  name = new JLabel("Name  ");
  name.setFont(new Font("Serif", Font.BOLD, headtextSize));

  // Taking Roll_No from user
  rollNo = new JLabel("Roll No  ");
  rollNo.setFont(new Font("Serif", Font.BOLD, headtextSize));

  // Taking course
  course = new JLabel("Course  ");
  course.setFont(new Font("Serif", Font.BOLD, headtextSize));
 
  // Taking session
  session = new JLabel("Session  ");
  course.setFont(new Font("Serif", Font.BOLD, headtextSize));
 
  // Taking branch
  branch = new JLabel("Branch  ");
  course.setFont(new Font("Serif", Font.BOLD, headtextSize));

  // Taking semester
  semester = new JLabel("Semester  ");
  semester.setFont(new Font("Serif", Font.BOLD, headtextSize));

  // Taking Father's details
  fatherName = new JLabel("Father's Name  ");
  fatherName.setFont(new Font("Serif", Font.BOLD, headtextSize));

  // Taking Mother's details
  motherName = new JLabel("Mother's Name ");
  motherName.setFont(new Font("Serif", Font.BOLD, headtextSize));

  // Taking Mobile No
  mobNo = new JLabel("Mobile No  ");
  mobNo.setFont(new Font("Serif", Font.BOLD, headtextSize));

  //Taking email_id
  emailId = new JLabel("Email Id  ");
  emailId.setFont(new Font("Serif", Font.BOLD, headtextSize));
   
  // Taking DOB from user
  DOB = new JLabel("DOB  ");
  DOB.setFont(new Font("Serif", Font.BOLD, headtextSize));

  // Taking Gender
  gender = new JLabel("Gender ");
  gender.setFont(new Font("Serif", Font.BOLD, headtextSize));

  //Taking Password
  password = new JLabel("Password  ");
  password.setFont(new Font("Serif", Font.BOLD, headtextSize));
  
   // Taking Address
   address = new JLabel("Address");
   address.setFont(new Font("Serif", Font.BOLD, headtextSize));
  
   regDate = new JLabel("RegDate");
   regDate.setFont(new Font("Serif", Font.BOLD, headtextSize));

   status = new JLabel("Status");
   status.setFont(new Font("Serif", Font.BOLD, headtextSize));

  // Adding all element in heading
  heading.add(name);
  heading.add(rollNo);
  heading.add(course);
  heading.add(session);
  heading.add(branch);
  heading.add(semester);
  heading.add(fatherName);
  heading.add(motherName);
  heading.add(mobNo);
  heading.add(emailId);
  heading.add(DOB);
  heading.add(gender);
  heading.add(address);
  heading.add(regDate);
  heading.add(password);
  heading.add(status);

}
 
 public JPanel displayHeading() {

 gc.gridx = 0; gc.gridy = 0;
 int i = 0;
 while(i < heading.size()) {
   headPanel.add(heading.get(i++), gc);
   gc.gridx++;
  }
  headPanel.setBackground(Color.RED);
 // this.add(headPanel, BorderLayout.CENTER);
  this.setVisible(true); 
  this.pack(); 
  return headPanel;
}

 public JScrollPane displayData(ArrayList<Student> students) {
  // Printing heading
  gc.gridx = 0; gc.gridy = 0;
  //headPanel.setBackground(Color.blue);
  int i = 0;
  while(i < heading.size()) {
    dataPanel.add(heading.get(i++), gc);
    gc.gridx++;
   }

   gc.gridy = 1; 
   for (Student student : students) {
          gc.gridy++; gc.gridx = 0;
          ArrayList<String> data = dataFill(student);
          i = 0;
          while (i < heading.size()) {
                dataPanel.add(new Label(data.get(i++)), gc);
                gc.gridx++;
          }
        }

      if (students.size() < 1) {
       mesLab.setText("Record is empty!");
       gc.gridx = 6; gc.gridy = 3;
       dataPanel.add(mesLab, gc);
        System.out.println("Record is empty!");
      } 
        // Adding scrool bar
  JScrollPane sb = new JScrollPane(dataPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
  sb.setPreferredSize(new Dimension(1000, 300));
  cn.add(sb, BorderLayout.NORTH);
  this.setVisible(false);
 dispose();
 return sb;
}

 public ArrayList<String> dataFill(Student student) {
  ArrayList<String> data = new ArrayList<>();

  data.add(student.getName());
  data.add(student.getRollNo());
  data.add(student.getCourse());
  data.add(student.getSession());
  data.add(student.getBranch());
  data.add(student.getSemester());
  data.add(student.getFatherName());
  data.add(student.getMotherName());
  data.add(student.getMobNo());
  data.add(student.getEmailId());
  data.add(student.getDob());
  data.add(student.getGender());
  data.add(student.getAddress());
  data.add(student.getRegDate()+"");
  data.add(student.getPassword());
  data.add(student.getStatus()+"");

  return data;
 }
}
