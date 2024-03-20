package jdbc;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import admin.Admin;
import admin.Admin.Display;
import registrationForm.Form;

public class UserLogin {
 public UserLogin() {
  UserFrame user = new UserFrame();
 }
}
class UserFrame extends JFrame implements ActionListener{
 JLabel rollLeb, emailLeb, msgLeb;
 JTextField rollFd, passwordFd;
 JButton login, homeBtn;

  public UserFrame() {

  setTitle("Login Page");
  setSize(650, 600);
  setLocationRelativeTo(null);
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  Container c = getContentPane();
  c.setLayout(null);
  c.setBackground((Color.decode("#f0e9e9")));

   int lftmgn = 50, topmgn = 50;
      // Taking Roll_No from user
      rollLeb = new JLabel("Enter Roll No");
      rollLeb.setBounds(lftmgn, topmgn+=150, 100, 30);
      c.add(rollLeb);
      rollFd = new JTextField();
      rollFd.setBounds(lftmgn+210, topmgn, 150, 30);
      c.add(rollFd);

      emailLeb = new JLabel("Enter Password ");
      emailLeb.setBounds(lftmgn, topmgn+=50, 200, 30);
      c.add(emailLeb);
      passwordFd = new JTextField();
      passwordFd.setBounds(lftmgn+210, topmgn, 150, 30);
      c.add(passwordFd);

      login = new JButton("Login");
      login.setBounds(lftmgn, topmgn+=100, 100, 30);
      c.add(login);
      login.addActionListener(this);

           // Home button
     homeBtn = new JButton("Home");
     homeBtn.setBounds(lftmgn+150, topmgn, 100, 30);
     c.add(homeBtn);
     homeBtn.addActionListener(this);

      msgLeb = new JLabel("");
      msgLeb.setBounds(lftmgn, topmgn+=50, 550, 30);
      c.add(msgLeb);
      setVisible(true);


  }

  public void actionPerformed(ActionEvent ae) {
    try {
     String clickedBtn = ae.getActionCommand();
    if (clickedBtn.equals("Home")){
       Home home = new Home();
       setVisible(false);
    } else{
      String rollNo = rollFd.getText();
      String orgPassword = DAO.readPassword(rollNo);
    if (passwordFd.getText().equals(orgPassword)) {
    msgLeb.setText("Your are logined!");
    Student student = DAO.readSpData(rollNo, passwordFd.getText());
    Display obj = new Admin().new Display(student);
   }else {
     msgLeb.setText("Password is incorrect! Orginal Pas" + orgPassword);
   }
  }
  } catch(Exception e) {
   System.out.println(e);
  }
  }
}
