package jdbc;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import jdbc.Admin.AdLoginFm;
import jdbc.Admin.AdminHome;
import user.foclone;


public class Home extends JFrame implements ActionListener {
  JLabel admnLeb, regLeb, userLeb, subAdmLab;
  JButton admBtn, subAdmBtn, regBtn, userBtn;
  private JPanel loginPanel;
  GridBagConstraints gc;

  public Home() {
    setTitle("Home Page");
    setSize(1800, 1000);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    loginPanel = new JPanel();
    loginPanel.setLayout(new GridBagLayout());
    gc = new GridBagConstraints();
    loginPanel.setSize(700, 700);
    loginPanel.setBackground((Color.cyan));

    createLoginPanel();
  }

  public JPanel createLoginPanel(){
    gc.insets = new Insets(90,20 ,20,20);
    gc.gridx = 0; gc.gridy = 1;
    admnLeb = new JLabel("To Admin login click here");
    admnLeb.setFont(new Font("Serif", Font.BOLD, 20));
    loginPanel.add(admnLeb, gc);
    
    gc.gridx++;
    admBtn = new JButton("Login");
    admBtn.setFont(new Font("Serif", Font.BOLD, 20));
    loginPanel.add(admBtn,gc);
    admBtn.addActionListener(this);

    gc.insets = new Insets(20,20 ,20,20);
    gc.gridx = 0; gc.gridy ++;
    subAdmLab = new JLabel("To Sub-Admin login click here");
    subAdmLab.setFont(new Font("Serif", Font.BOLD, 20));
    loginPanel.add(subAdmLab, gc);
    
    gc.gridx++;
    subAdmBtn = new JButton(" Login ");
    subAdmBtn.setFont(new Font("Serif", Font.BOLD, 20));
    loginPanel.add(subAdmBtn,gc);
    subAdmBtn.addActionListener(this);
    
    gc.gridx = 0; gc.gridy++;
    regLeb = new JLabel("For Registration Click here");
    regLeb.setFont(new Font("Serif", Font.BOLD, 20));
    loginPanel.add(regLeb, gc);

    gc.gridx++;
    regBtn = new JButton(" New ");
    regBtn.setSize(100, 50);
    regBtn.setFont(new Font("Serif", Font.BOLD, 20));
    loginPanel.add(regBtn, gc);
    regBtn.addActionListener(this);

    gc.gridx = 0; gc.gridy ++;
    userLeb = new JLabel("For User login click here");
    userLeb.setFont(new Font("Serif", Font.BOLD, 20));
    loginPanel.add(userLeb, gc);

    gc.gridx++;
    userBtn = new JButton("User");
    userBtn.setFont(new Font("Serif", Font.BOLD, 20));
    loginPanel.add(userBtn, gc);
    userBtn.addActionListener(this);
    
    loginPanel.setVisible(true);
    this.add(loginPanel);
    this.setVisible(true);

    return loginPanel;
  }

  public void actionPerformed(ActionEvent ae) {
    String button = ae.getActionCommand();

    // Redirect to Admin Profile
    if (button.equals("Login")) {
      AdLoginFm admin = new AdLoginFm(true);
      System.out.println("Admin profile");
    } 
        // Redirect to Sub-Admin Profile
    else if (button.equals(" Login ")) {
      AdLoginFm sub_admin = new AdLoginFm(false);
    }

    else if (button == " New ") {
      foclone newUser = new foclone();
      System.out.println("New user is registered!");
    } else {
      UserLogin login = new UserLogin();
      System.out.println("user is Login!");
    }
    setVisible(false);
  }

  // Main function
  public static void main(String[] args) {
    Home obj = new Home();
    obj.createLoginPanel();
  }
}