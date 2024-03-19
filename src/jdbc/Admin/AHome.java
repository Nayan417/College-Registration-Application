package jdbc.Admin;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import admin.Admin;
import jdbc.DAO;
import jdbc.Home;

import registrationForm.Form;

public class AHome extends JFrame implements ActionListener{
 JLabel insertLeb, displayLeb, updateLeb, deleteLeb, admLabel;
 JButton insertBtn, displayBtn, updateBtn, deleteBtn, admBtn, homeBtn;
 
 public AHome() {
  setTitle("Home Page");
  setSize(650, 600);
  setLocationRelativeTo(null);
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  Container c = getContentPane();
  c.setLayout(null);
  c.setBackground((Color.decode("#f0e9e9")));

  int lftmrgn = 30, leftColmrgn = 300, topmrgn = 110, textWidth = 320, btnWidth = 100, textHeight = 40;
  
  insertLeb = new JLabel("For new registration click here");
  insertLeb.setBounds(lftmrgn, topmrgn, textWidth, textHeight);
  c.add(insertLeb);
  insertBtn = new JButton(" New ");
  insertBtn.setBounds(leftColmrgn, topmrgn, btnWidth, textHeight);
  c.add(insertBtn);
  insertBtn.addActionListener(this);

  displayLeb = new JLabel("For Display Registered Student Details Click");
  displayLeb.setBounds(lftmrgn, topmrgn+=50, textWidth, textHeight);
  c.add(displayLeb);
  displayBtn = new JButton("Display");
  displayBtn.setBounds(leftColmrgn, topmrgn, btnWidth, textHeight);
  c.add(displayBtn);
  displayBtn.addActionListener(this);

  updateLeb = new JLabel("For Update Registered Detials Click here");
  updateLeb.setBounds(lftmrgn, topmrgn+=50, textWidth, textHeight);
  c.add(updateLeb);
  updateBtn = new JButton("Update");
  updateBtn.setBounds(leftColmrgn, topmrgn, btnWidth, textHeight);
  c.add(updateBtn);
  updateBtn.addActionListener(this);

  deleteLeb = new JLabel("For Delete Details Click here");
  deleteLeb.setBounds(lftmrgn, topmrgn+=50, textWidth, textHeight);
  c.add(deleteLeb);
  deleteBtn = new JButton("Delete");
  deleteBtn.setBounds(leftColmrgn, topmrgn, btnWidth, textHeight);
  c.add(deleteBtn);
  deleteBtn.addActionListener(this);
  
  // Home button
  homeBtn = new JButton("Home");
  homeBtn.setBounds(30, 10, btnWidth, textHeight);
  c.add(homeBtn);
  homeBtn.addActionListener(this);
  setVisible(true);
 }

  public void actionPerformed(ActionEvent ae) { 
    String button = ae.getActionCommand();
    try {
     Admin admin = new Admin();
    // Redirect to Admin Profile
    if (button == "Home") {
       Home homePage = new Home(); 
    }
    else if (button == " New ") {
      Form newUser = new Form();
    } else if (button == "Display") {
      admin.new Display(DAO.readData());
      System.out.println("Data is diplaying");
    }
     else if (button == "Update") {
      admin.new Update();
      System.out.println("Data is Updating");
    } else {
      admin.new Delete();
      System.out.println("Data is Deleting");
    }
    setVisible(false);      
   } catch (Exception e) {
    System.out.println(e);
   }
  }

}
