package jdbc.Admin;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import jdbc.Home;
import jdbc.AdminPr.LogoAdm;

public class AdLoginFm {
 public AdLoginFm(Boolean admin) {
  AdminFrame obj = new AdminFrame(admin);
 }
 
}

class AdminFrame extends JFrame implements ActionListener{
 JLabel rollLeb, passLab, msgLeb;
 JTextField rollFd, passwordFd;
 JButton login, homeBtn;
 Boolean admin;

  public AdminFrame(Boolean admin) {
  this.admin = admin;
  setTitle("Admin Login Page");
  setSize(650, 600);
  setLocationRelativeTo(null);
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  Container c = getContentPane();
  c.setLayout(null);
  c.setBackground((Color.decode("#f0e9e9")));

  //Atemplete temp = new Atemplete();
 // c.add(c);

      int lftmgn = 50, topmgn = 100, btnWidth=100, btnHeight = 30;
      // Taking Roll_No from user
      rollLeb = new JLabel("Enter Login Id");
      rollLeb.setFont(new Font("Serif", Font.BOLD, 20));
      rollLeb.setBounds(lftmgn, topmgn+=150, 150, 30);
      c.add(rollLeb);
      rollFd = new JTextField();
      rollFd.setBounds(lftmgn+210, topmgn, 150, 30);
      c.add(rollFd);

      passLab = new JLabel("Enter Password ");
      passLab.setBounds(lftmgn, topmgn+=50, 200, 30);
      passLab.setFont(new Font("Serif", Font.BOLD, 20));
      c.add(passLab);
      passwordFd = new JTextField();
      passwordFd.setBounds(lftmgn+210, topmgn, 150, 30);
      c.add(passwordFd);

      login = new JButton("Login");
      login.setBounds(lftmgn, topmgn+=100, btnWidth, btnHeight);
      c.add(login);
      login.addActionListener(this);

     // Home button
     homeBtn = new JButton("Home");
     homeBtn.setBounds(30, 10, btnWidth, btnHeight);
     c.add(homeBtn);
     homeBtn.addActionListener(this);

      msgLeb = new JLabel("");
      msgLeb.setBounds(lftmgn, topmgn+=150, 150, 30);
      c.add(msgLeb);
      setVisible(true);
  }

  public void actionPerformed(ActionEvent ae) {
   try {
    String clickedBtn = ae.getActionCommand();
    if (clickedBtn == "Home") {
      Home Home = new Home();
      setVisible(false);
    } else{
     String userName = rollFd.getText();
     String orgPassword = ADAO.readPassword(userName);
   if (orgPassword.equals(passwordFd.getText() )) {
    if (admin == true) {
       if (ADAO.readAdmType(userName).equals("Admin")) {
            new AdminHome();
            dispose();
       }
    } else {
     msgLeb.setText("Your are logined!");
     LogoAdm aHome = new LogoAdm();
     dispose();
    }
  }
   else {
     msgLeb.setText("Id or Password was incorrect! Please try again");
   }
  }
  } catch(Exception e) {
   System.out.println(e);
  }
  }
  public static void main(String[] args) {
    new AdLoginFm(false);
  }
}

