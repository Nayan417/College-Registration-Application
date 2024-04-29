package user;

import javax.crypto.spec.GCMParameterSpec;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import jdbc.DAO;
import jdbc.Student;
import jdbc.AdminPr.LogoAdm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Report extends JFrame implements ActionListener{
 public JPanel reportPanel , dataPanel;
 JLabel courseLab, sessionLab, branchLab, semesterLab, msgLab;
 JComboBox course, session, branch, semester;
 JButton reportBtn, homeBtn;
 Container cn;
 GridBagLayout gb;
 GridBagConstraints gc;

 private int textSize = 15;
 
 public Report() {
   this.setTitle("Report");
   this.setLayout(new BorderLayout());
   this.setDefaultCloseOperation(EXIT_ON_CLOSE);
   this.setLocationRelativeTo(null);
   cn = getContentPane();
   this.setSize(1500, 1000);

  // this.setLayout(new BorderLayout());

  cn.setLayout(new BorderLayout());

  dataPanel = new JPanel();
  dataPanel.setLayout(new BorderLayout());
 // dataPanel.setPreferredSize(new Dimension(1000, 400));
 
  gb = new GridBagLayout();
  gc = new GridBagConstraints();
  reportPanel = new JPanel(gb);
  reportPanel.setPreferredSize(new Dimension(800, 200));
  reportPanel.setBorder(new EmptyBorder(80, 10, 20, 10));
  
  dataPanel.setBorder(new EmptyBorder(10, 10, 20, 10));

  reportPanel.setBackground(Color.CYAN);
  cn.add(dataPanel, BorderLayout.NORTH);
  cn.add(reportPanel, BorderLayout.SOUTH);
  this.setVisible(true);
 }
 
 public JPanel reportData() {

  // Taking Course
  gc.gridx = 0; gc.gridy = 0;
  courseLab = new JLabel("Filter Based on Course ");
  courseLab.setFont(new Font("Serif", Font.BOLD, textSize));
  reportPanel.add(courseLab, gc);

  gc.insets = new Insets(10, 10, 5, 10);
  gc.gridx++;
  course = new JComboBox(Student.getCourses());
  course.setFont(new Font("Serif", Font.BOLD, textSize));

 reportPanel.add(course, gc);
 

  // Taking Session
  
  gc.gridx++;
  sessionLab = new JLabel("Filter Based on Session ");
  sessionLab.setFont(new Font("Serif", Font.BOLD, textSize));
  reportPanel.add(sessionLab, gc);
  
  gc.gridx++;
  session = new JComboBox(Student.getSessions());
  session.setFont(new Font("Serif", Font.BOLD, textSize));
  reportPanel.add(session, gc);
 
  // Based on Semester 
  gc.insets = new Insets(20,10, 20, 10);
  gc.gridx = 0; gc.gridy ++;
  semesterLab = new JLabel("Filter Based on Semester ");
  semesterLab.setFont(new Font("Serif", Font.BOLD, textSize));
  reportPanel.add(semesterLab, gc);
  
  gc.gridx++;
  semester = new JComboBox(Student.getSemesters());
  semester.setFont(new Font("Serif", Font.BOLD, textSize));
  reportPanel.add(semester, gc);
 
  // Based on Branch
  gc.gridx++; 
  branchLab = new JLabel("Filter Based on Branch ");
  branchLab.setFont(new Font("Serif", Font.BOLD, textSize));
  reportPanel.add(branchLab, gc);
  
 gc.gridx++;
 branch = new JComboBox(Student.getBranchs());
 branch.setFont(new Font("Serif", Font.BOLD, textSize));
 reportPanel.add(branch, gc);

 gc.gridx = 1; gc.gridy = 2;
 reportBtn = new JButton("Show Report");
 reportBtn.setFont(new Font("Serif", Font.BOLD, textSize+2));
 reportPanel.add(reportBtn, gc);
 
 gc.gridx ++; 
 homeBtn = new JButton("Home");
 homeBtn.setFont(new Font("Serif", Font.BOLD, textSize+2));
 
 reportPanel.add(homeBtn, gc);

 reportBtn.addActionListener(this);
 homeBtn.addActionListener(this);

 msgLab = new JLabel("");
 gc.gridy++; gc.gridx = 0;
 reportPanel.add(msgLab, gc);

 this.setVisible(true);

 return reportPanel;
}

public void actionPerformed(ActionEvent ae) {
  String clickedBtn = ae.getActionCommand();
  if (clickedBtn.equals("Home")) {
    new LogoAdm();
  } else {
    dataPanel.removeAll();
   reportPre();
  }
}

public JPanel reportPre() {
  try {
    System.out.println("Report : ");
    String sesSelected = this.session.getSelectedItem() + "";
    String semSelected = this.semester.getSelectedItem() + "";
    String brnSelected = this.branch.getSelectedItem() + "";
    String couSelected = this.course.getSelectedItem() +"";
    Display obj = new Display();

    // Course, Session, Semester and Branch
     if (!couSelected.equals("Course") && !sesSelected.equals("Session") && !semSelected.equals("Semester") && !brnSelected.equals("Branch"))
    {
      dataPanel.add(obj.displayData(DAO.readCouSesSemBranch(couSelected, sesSelected, semSelected, brnSelected)), BorderLayout.NORTH);
      System.out.printf("%s %s %s %s ",couSelected, sesSelected, semSelected, brnSelected);
     } 
    // Course, Session, and Semester 
    else if (!couSelected.equals("Course") && !sesSelected.equals("Session") && !semSelected.equals("Semester"))
    {
      dataPanel.add(obj.displayData(DAO.readCourseSessionSemester(couSelected, sesSelected, semSelected)));
      System.out.printf("%s %s %s ",couSelected, sesSelected, semSelected);
     } 
     // Course Session and Branch
     else if (!couSelected.equals("Course") && !sesSelected.equals("Session")  && !brnSelected.equals("Branch"))
    {
      dataPanel.add(obj.displayData(DAO.readCourseSessionBranch(couSelected, sesSelected, brnSelected)));
      System.out.printf("%s %s %s  ",couSelected, sesSelected, brnSelected);
     } 
    // Session , Semester and Branch
    else if (!sesSelected.equals("Session") && !semSelected.equals("Semester") && !brnSelected.equals("Branch"))
    {
      dataPanel.add(obj.displayData(DAO.readSesSemBranch(sesSelected, semSelected, brnSelected)));
     } 
     // Course and Session 
     else if (!couSelected.equals("Course") && !sesSelected.equals("Session")) {
      dataPanel.add(obj.displayData(DAO.readCourseSession(couSelected, sesSelected))); 
      System.out.printf("Course %d and session %d" , semSelected , sesSelected);
     } 
     // Course and semester
     else if (!couSelected.equals("Course") && !semSelected.equals("Semester")) {
       dataPanel.add(obj.displayData(DAO.readCourseSemester(couSelected, semSelected)));
       System.out.printf("Course %s and semester %s" , semSelected , sesSelected);

     }
      // course and branch
      else if (!couSelected.equals("Course") && !brnSelected.equals("Branch")) {
       dataPanel.add(obj.displayData(DAO.readCourseBranch(couSelected, brnSelected)));
       System.out.printf("Course %s and Branch %s" , couSelected , brnSelected);
     }
     // Session and semester
     else if (!sesSelected.equals("Session") && !semSelected.equals("Semester")) {
      dataPanel.add(obj.displayData(DAO.readSessionSemester(sesSelected, semSelected)));
      System.out.printf("Semester %s and sessiom %s" , semSelected , sesSelected);
     } 
     // Session and branch 
      else if (!sesSelected.equals("Session") && !brnSelected.equals("Branch")) {
        System.out.printf("Semester %s and branch %s" , sesSelected , brnSelected);
        dataPanel.add(obj.displayData(DAO.readSessionBranch(sesSelected, brnSelected)));    
     } 
     // Semester and branch
     else if (!semSelected.equals("Semester") && !brnSelected.equals("Branch")) {       
       dataPanel.add(obj.displayData(DAO.readSemesterBranch(semSelected, brnSelected)));          
       System.out.printf("Semester %s and branch %s" , semSelected , brnSelected);
       }
     else if (!couSelected.equals("Course")) {
       dataPanel.add(obj.displayData(DAO.readCourse(couSelected)), BorderLayout.NORTH);
       System.out.println("Course " + couSelected);
      }
     else if (!sesSelected.equals("Session")) {
      dataPanel.add(obj.displayData(DAO.readSession(sesSelected)), BorderLayout.NORTH);
      System.out.println("Session " + sesSelected);
     }
     else if (!semSelected.equals("Semester")) {
       dataPanel.add(obj.displayData(DAO.readSemester(semSelected)), BorderLayout.NORTH);              
       System.out.println("Semester " + semSelected);
      } 
      else if (!brnSelected.equals("Branch")) {
        dataPanel.add(obj.displayData(DAO.readBranch(brnSelected)), BorderLayout.NORTH);
       //cn.add(obj.displayData(DAO.readBranch(brnSelected)), BorderLayout.NORTH);
       System.out.println("Branch " + brnSelected);
       } else {
         System.out.println("All data is printing");
         dataPanel.add(obj.displayData(DAO.readData()), BorderLayout.NORTH);
       }
       this.setVisible(true);
    } catch (Exception e) {
 System.out.println(e);
}
return null;
}
public static void main(String args[]) {
 Report obj = new Report();
 JPanel temp = obj.reportData();
}
}
