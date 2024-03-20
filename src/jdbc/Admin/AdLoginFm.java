package jdbc.Admin;

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
import jdbc.Home;
import registrationForm.Form;

public class AdLoginFm {
 public AdLoginFm() {
  AdminFrame admin = new AdminFrame();
 }
}
class AdminFrame extends JFrame implements ActionListener{
 JLabel rollLeb, emailLeb, msgLeb;
 JTextField rollFd, passwordFd;
 JButton login, homeBtn;

  public AdminFrame() {

  setTitle("Login Page");
  setSize(650, 600);
  setLocationRelativeTo(null);
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  Container c = getContentPane();
  c.setLayout(null);
  c.setBackground((Color.decode("#f0e9e9")));

   int lftmgn = 50, topmgn = 100, btnWidth=100, btnHeight = 30;
      // Taking Roll_No from user
      rollLeb = new JLabel("Enter Name");
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
      login.setBounds(lftmgn, topmgn+=100, btnWidth, btnHeight);
      c.add(login);
      login.addActionListener(this);

     // Home button
     homeBtn = new JButton("Home");
     homeBtn.setBounds(30, 10, btnWidth, btnHeight);
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
    if (clickedBtn == "Home") {
      Home Home = new Home();
      setVisible(false);
    } else{
     String userName = rollFd.getText();
     String orgPassword = "111";
   if (userName.equals("Nayan") && ( passwordFd.getText().equals(orgPassword) )) {
    msgLeb.setText("Your are logined!");
     AHome aHome = new AHome();
     setVisible(false);
   }else if(userName.equals("Ashu") && passwordFd.getText().equals("222")){
    msgLeb.setText("Your are logined!");
    AHome aHome = new AHome();
    setVisible(false);
   }
   else {
     msgLeb.setText("Password is incorrect! ");
   }
  }
  } catch(Exception e) {
   System.out.println(e);
  }
  }
}

