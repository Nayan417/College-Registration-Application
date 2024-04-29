package jdbc.Admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

//import admin.Admin.Display;
import jdbc.DAO;
import jdbc.Home;
import jdbc.Student;
import user.*;
// import user.Display;

public class AdminHome {
  public AdminHome() {
    Templete obj = new Templete();
  }

  public static void main(String[] args) {
    new AdminHome();
  }
}

class Templete extends JFrame implements ActionListener {
  JButton homeBtn, newBtn, updateBtn, displayBtn, reportBtn, deleteBtn;
  JPanel disData, headPanel;
  Container cn;

  public Templete() {
    this.setSize(1300, 900);
    setLocationRelativeTo(null);
    this.setTitle("Admin profile");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // this.setLayout(new BorderLayout());
    cn = getContentPane();
    cn.setLayout(new BorderLayout());

    GridBagLayout gb = new GridBagLayout();
    GridBagConstraints gc = new GridBagConstraints();
    gc.insets = new Insets(10, 15, 10, 15);

    headPanel = new JPanel(gb);
    headPanel.setBackground(Color.pink);
    headPanel.setBackground(Color.red);
    headPanel.setPreferredSize(new Dimension(800, 150));
    cn.add(headPanel, BorderLayout.SOUTH);
    headPanel.setBorder(new EmptyBorder(15, 10, 50, 10));

    disData = new JPanel();
    disData.setLayout(new BorderLayout());
    // disData.setPreferredSize(new Dimension(720, 500));
    cn.add(disData, BorderLayout.NORTH);
    this.setBackground((Color.decode("#f0e9e9")));
    // disData.setBackground(Color.RED);

    // Home button
    homeBtn = new JButton("Home");
    // homeBtn.setBounds(leftColmrgn, topmrgn, btnWidth, textHeight);
    homeBtn.addActionListener(this);

    newBtn = new JButton("New");
    newBtn.addActionListener(this);

    displayBtn = new JButton("Display");
    displayBtn.addActionListener(this);

    reportBtn = new JButton("Report");
    reportBtn.addActionListener(this);

    updateBtn = new JButton("Update");
    updateBtn.addActionListener(this);

    deleteBtn = new JButton("Delete");
    deleteBtn.addActionListener(this);

    gc.gridx = 0;
    gc.gridy = 0;
    headPanel.add(homeBtn, gc);
    gc.gridx++;
    headPanel.add(newBtn, gc);
    gc.gridx++;
    headPanel.add(displayBtn, gc);
    gc.gridx++;
    headPanel.add(reportBtn, gc);
    gc.gridx++;
    headPanel.add(updateBtn, gc);
    gc.gridx++;
    headPanel.add(deleteBtn, gc);

    // Auto data display
    try {
      ADisplay obj = new ADisplay();
      disData.add(obj.displayData(ADAO.readData()), BorderLayout.NORTH);
    } catch (Exception e) {
      System.out.println(e);
    }
    this.setVisible(true);
  }

  public void actionPerformed(ActionEvent ae) {
    String button = ae.getActionCommand();
    try {
 //     Admin admin = new Admin();
      // Redirect to Admin Profile
      disData.removeAll();

      if (button.equals("Home")) {
     //   this.setVisible(false);
     //   this.dispose();
        headPanel.setVisible(false);
        Home homePage = new Home();
        //disData.add(homePage.createLoginPanel(), BorderLayout.CENTER);
      }
       else if (button.equals("New")) {
         AdminForm newAdmin = new AdminForm();
         disData.add(newAdmin.formPanel, BorderLayout.WEST);
      }

      else if (button.equals("Display")) {
        ADisplay obj = new ADisplay();
        disData.add(obj.displayData(ADAO.readData()), BorderLayout.NORTH);
         System.out.println("Both Data is diplaying");
      }
      else if (button.equals("Report")) {
        this.setVisible(false);
        this.dispose();
        Display obj = new Display();
        Report report = new Report();
        disData.add(report.reportData(), BorderLayout.NORTH);
      } 
      
      else if (button.equals("Update")) {
        AUpdate updateDetails = new AUpdate();
        disData.add(updateDetails.loginPanel, BorderLayout.CENTER);
        // disData.add(updateDetails.update(), BorderLayout.NORTH);
        System.out.println("Data is Updating");
      }

      else {
        // admin.new Delete();
        disData.add(new ADelete().DeleteData(), BorderLayout.SOUTH);
        ADisplay obj = new ADisplay();
       disData.add(obj.displayData(ADAO.readData()), BorderLayout.NORTH);
        
        System.out.println("Data is Deleting");
      }
      this.setVisible(true);
    } catch (Exception e) {
      System.out.println(e);
    }
  }

}

