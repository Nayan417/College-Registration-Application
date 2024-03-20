package jdbc;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import jdbc.Admin.AHome;
import jdbc.Admin.AdLoginFm;
import registrationForm.Form;

public class Home {
  static HomeFrame obj;
  public Home() {
    obj = new HomeFrame();
  }
 public static void main(String[] args) {
  obj = new HomeFrame();
 }
}

class HomeFrame extends JFrame implements ActionListener{
  JLabel admnLeb, regLeb, userLeb;
  JButton admBtn, regBtn, userBtn;
  
  public HomeFrame() {
   setTitle("Home Page");
   setSize(650, 600);
   setLocationRelativeTo(null);
   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   Container c = getContentPane();
   c.setBackground((Color.decode("#f0e9e9")));
   c.setLayout(null);
   // c.setBackground((Color.decode("#f0e9e9")));

   int lftmrgn = 50, leftColmrgn = 230, topmrgn = 100, textWidth = 300, btnWidth = 100, textHeight = 40;
   admnLeb = new JLabel("To Admin login click here");
   admnLeb.setBounds(lftmrgn, topmrgn, textWidth, textHeight);
   c.add(admnLeb);
   admBtn = new JButton("Login");
   admBtn.setBounds(leftColmrgn, topmrgn, btnWidth, textHeight);
   c.add(admBtn);
   admBtn.addActionListener(this);

   regLeb = new JLabel("For Registration Click here");
   regLeb.setBounds(lftmrgn, topmrgn+=80, textWidth, textHeight);
   c.add(regLeb);
   regBtn = new JButton(" New ");
   regBtn.setBounds(leftColmrgn, topmrgn, btnWidth, textHeight);
   c.add(regBtn);
   regBtn.addActionListener(this);

   userLeb = new JLabel("For User login click here");
   userLeb.setBounds(lftmrgn, topmrgn+=80, textWidth, textHeight);
   c.add(userLeb);
   userBtn = new JButton("User");
   userBtn.setBounds(leftColmrgn, topmrgn, btnWidth, textHeight);
   c.add(userBtn);
   userBtn.addActionListener(this);
   
   setVisible(true);
  }

  public void actionPerformed(ActionEvent ae) { 
    String button = ae.getActionCommand();
    
    // Redirect to Admin Profile
    if (button.equals("Login")) {
      // AHome admin = new AHome();
         AdLoginFm admin = new AdLoginFm();
      // frameToClose.dispose();
      System.out.println("Admin profile");
    }
    else if (button == " New ") {
       Form newUser = new Form();
      System.out.println("New user is registered!");
    } else {
      UserLogin login = new UserLogin();
      System.out.println("user is Login!");
    }
    setVisible(false);
  }

}

