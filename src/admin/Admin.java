package admin;

import java.awt.Color;
import java.awt.Container;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import jdbc.DAO;
import jdbc.Home;
import jdbc.Student;
import jdbc.Admin.AHome;
import registrationForm.Frame;

public class Admin {
  static JLabel Optlb, Idlb, NDlb, msgLab;
  static JTextField input1, input2;
  JButton button1, button2, homeBtn;
  static String btnLeve1, btnLevel2, ms = "Not Changed";

  int btnWidth = 100, btnHeight = 30, lftmgn = 50, topmgn = 130;
  
  // Read from database
  public class Display extends JFrame implements ActionListener {

    public Display(ArrayList<Student> students) {
      setTitle("Student Registration details");
      setSize(1500, 1000);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Container cn = getContentPane();
      cn.setLayout(null);

      String heading = " RollNo \t\t Name \t Course \t  Semester\tFather's Name \t MotherName\tMobNo\tEmail \t DOB \t Gender\t\taddress \t RegDate \t status";
      TextArea head = new TextArea();
      head.setText(heading);
      int leftmrgn = 20, topmrgn = 75, width = 1300, height = 25;
      head.setBounds(leftmrgn, topmrgn, width, height + 25);
      head.setBackground(Color.LIGHT_GRAY);
      head.setForeground(Color.BLACK);
      cn.add(head);
      cn.setLayout(null);
      cn.setBackground((Color.decode("#f0e9e9")));
      for (Student student : students) {
        // Printing details of user
        String Name = student.getName();
        String RollNo = student.getRollNo();
        String Course = student.getCourse();
        String Semester = student.getSemester();
        String FatherName = student.getFatherName();
        String MotherName = student.getMotherName();
        String MobNo = student.getMobNo();
        String Email = student.getEmailId();
        String dob = student.getDob();
        String Gender = student.getGender();
        String Address = student.getAddress();
        Date RegDate = student.getRegDate();
        int status = student.getStatus();
        String gap = " \t ";
        String data = " " + RollNo + gap + Name + "\t" + Course + gap + Semester + gap + FatherName + gap + MotherName
            + gap
            + MobNo + gap + Email + gap + dob + gap + Gender + gap + Address + gap + RegDate + gap + status;
        JTextArea userInfo = new JTextArea();
        userInfo.setText(data);
        userInfo.setBounds(leftmrgn, topmrgn += 50, width, height);
        cn.add(userInfo);

        homeBtn = new JButton("Home");
        homeBtn.setBounds(30, 10, btnWidth, btnHeight);

        cn.add(homeBtn);
        homeBtn.addActionListener(this);
      }
      setVisible(true);
    }
   
    // Display specific data    
    public Display(Student student) {
         JTextArea userInfo;
         JLabel msg;
         setSize(700, 700);
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          Container cn = getContentPane();
          cn.setLayout(null);
          setTitle("Registration Successfull!");

          msg = new JLabel("");
          msg.setBounds(200, 50, 400, 30);
          cn.add(msg);
          msg.setText("This is your Registered details");

          // Printing details of user
          String Name = student.getName();
          String RollNo = student.getRollNo();
          String Course = student.getCourse();
          String Semester = student.getSemester();
          String MobNo = student.getMobNo();
          String FatherName = student.getFatherName();
          String MotherName = student.getMotherName();
          String dob = student.getDob();
          String Email = student.getEmailId();
          String Gender = student.getGender();
          String Address = student.getAddress();
          String Password = student.getPassword();
          Date RegDate = student.getRegDate();
          

          String data = "\n\t Name : " + Name + "\n\n\tRoll No : " + RollNo + "\n\n\t Father's Name : " + FatherName + "\n\n\t Mother's Name" + MotherName + 
                        "\n\n\t Mobile No : " + MobNo + "\n\n\tEmail Id : " + Email + "\n\n\tDoB : " + dob + "\n\n\tGender : " + Gender + "\n\n\tAddress :  " + Address + "\n\n\t Password :  " + Password + "\n\n\t Registration Date :  " + RegDate;
          

          userInfo = new JTextArea();
          userInfo.setBounds(30, 100, 700, 700);
          userInfo.setText(data);
          cn.add(userInfo);

          setVisible(true);
      }
  
    // Action performed
    public void actionPerformed(ActionEvent ae) {
      // Redirect to Admin Profile
      AHome admin = new AHome();
      setVisible(false);

    }
  }

  // Update_Class for data updation
  public class Update extends JFrame implements ActionListener {
    JComboBox option;
    String options[] = { "select", "name", "Course", "semester", "mobileNo", "emailId",
        "fatherName", "motherName", "dob", "gender"
    };

    public Update() {
      String FTitle = "Update Registered Data";
      int width = 650, height = 600;
      // Container c = new Frame().newFrame(FTitle, width, height);
      setTitle(FTitle);
      setSize(width, height);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      Container c = getContentPane();
      c.setBackground((Color.decode("#f0e9e9")));
      c.setLayout(null);

      // What he wants to update
      Optlb = new JLabel("Select What you want to update");
      Optlb.setBounds(lftmgn, topmgn, 200, 30);
      c.add(Optlb);
      option = new JComboBox(options);
      option.setBounds(lftmgn + 200, topmgn, 150, 30);
      c.add(option);
      String mes = option.getSelectedItem() + " ";
      System.out.println(mes);

      button1 = new JButton("Enter");
      // btnLeve1 = button1.getLabel();
      button1.setBounds(lftmgn + 400, topmgn, btnWidth, btnHeight);
      c.add(button1);
      button1.addActionListener(this);
      System.out.println(ms);

      // Taking Roll_No from user
      Idlb = new JLabel("Enter Roll No");
      Idlb.setBounds(lftmgn, topmgn+=150, 100, 30);
      c.add(Idlb);
      input1 = new JTextField();
      input1.setBounds(lftmgn+210, topmgn, 150, 30);
      c.add(input1);

      NDlb = new JLabel("Enter new data ");
      NDlb.setBounds(lftmgn, topmgn+=50, 200, 30);
      c.add(NDlb);
      input2 = new JTextField();
      input2.setBounds(lftmgn+210, topmgn, 150, 30);
      c.add(input2);

      button2 = new JButton("Update");
      button2.setBounds(lftmgn, topmgn+=100, btnWidth, btnHeight);
      c.add(button2);
      button2.addActionListener(this);

      msgLab = new JLabel("");
      msgLab.setBounds(lftmgn, topmgn+=50, 550, 30);
      c.add(msgLab);

      // Home button
      homeBtn = new JButton("Home");
      homeBtn.setBounds(30, 10, btnWidth, btnHeight);
      c.add(homeBtn);
      homeBtn.addActionListener(this);
      setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
      try {
        String clickedBtn = ae.getActionCommand();
        String select = option.getSelectedItem()+"";
        if(select.equals("mobileNo")) select = "mobNo";

        if (clickedBtn == "Home") {
          AHome homePage = new AHome();
          setVisible(false);
        } else if (clickedBtn == "Enter") {
          String updateData = option.getSelectedItem() + "";
          NDlb.setText("Enter new " + updateData);
          System.out.println("You are updating " + updateData);
        } else {
          if (option.getSelectedItem().equals("select") || input1.getText() == "" || input2.getText() == "") {
            msgLab.setText("You have to give all details to Update information!");
          } else {
            DAO.updateData(input1.getText(), select, input2.getText());
            msgLab.setText("Your " + option.getSelectedItem() + " has updated successfullay");
          }
        }
      } catch (Exception e) {
        System.out.println(e);
      }

    }

  }

  // Delete Opearion
  public class Delete extends JFrame implements ActionListener {
    public Delete() {
      String FTitle = "Deleted Registered Data";
      int width = 650, height = 600;
      FTitle = "Delete student registered record";
      setTitle(FTitle);
      setSize(width, height);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Container c = getContentPane();
      c.setLayout(null);
      c.setBackground((Color.decode("#f0e9e9")));

      // What you wants to Delete

      // Taking Roll_No from user
      Idlb = new JLabel("Enter Roll No");
      Idlb.setBounds(50, 100, 100, 30);
      c.add(Idlb);
      input1 = new JTextField();
      input1.setBounds(150, 100, 150, 30);
      c.add(input1);
      button1 = new JButton("Delete");
      button1.setBounds(50, 180, 100, 30);
      c.add(button1);
      button1.addActionListener(this);

      // Home button
      homeBtn = new JButton("Home");
      homeBtn.setBounds(30, 10, btnWidth, btnHeight);
      c.add(homeBtn);
      homeBtn.addActionListener(this);
      setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
      try {
        String clickedBtn = ae.getActionCommand();
        if (clickedBtn == "Home") {
          AHome admHome = new AHome();
          setVisible(false);
        } else {
          DAO.deleteData(input1.getText());
        }
      } catch (Exception e) {
        System.out.println(e);
      }
    }
    
  }

}
