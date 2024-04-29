package jdbc.AdminPr;

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
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

//import admin.Admin.Display;
import jdbc.DAO;
import jdbc.Home;
import jdbc.Student;
import user.*;
// import user.Display;

public class LogoAdm {
  public LogoAdm() {
    Templete obj = new Templete();
  }

  public static void main(String[] args) {
    new LogoAdm();
  }
}

class Templete extends JFrame implements ActionListener {
  JButton homeBtn, newBtn, updateBtn, displayBtn, reportBtn, deleteBtn;
  JPanel disData, headPanel;
  Container cn;

  public Templete() {
    this.setSize(1300, 1000);
    setLocationRelativeTo(null);
    this.setTitle("Admin profile");
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
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

    // Home button
    homeBtn = new JButton("Home");
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
      Display obj = new Display();
      disData.add(obj.displayData(DAO.readData()), BorderLayout.NORTH);
    } catch (Exception e) {
      System.out.println(e);
    }
    this.setVisible(true);
  }

  public void actionPerformed(ActionEvent ae) {
    String button = ae.getActionCommand();
    try {
      // Redirect to Admin Profile
      disData.removeAll();

      if (button.equals("Home")) {
        this.setVisible(false);
        Home homePage = new Home();
        dispose();
      }
       else if (button.equals("New")) {
        JLabel logo2 = new JLabel("Cambridge Institute of Technology");
        logo2.setFont(new Font("Serif", Font.BOLD, 17));
        logo2.setForeground(Color.BLUE);
        JPanel headingPanel = new JPanel();
        headingPanel.add(logo2);
        headingPanel.setBorder(new EmptyBorder(10, 90, 5, 10));
        
        disData.add(headingPanel, BorderLayout.BEFORE_FIRST_LINE);
        
       foclone stu = new foclone();
        disData.add(stu.formPanel, BorderLayout.CENTER);
      }

      else if (button.equals("Display")) {
        Display obj = new Display();
        obj.cn.setVisible(false);
        disData.add(obj.displayData(DAO.readData()), BorderLayout.NORTH);
        System.out.println("Both Data is diplaying");
      }
      else if (button.equals("Report")) {
        dispose();
        Report report = new Report();
        report.reportData();
      } 
      
      else if (button.equals("Update")) {
        dispose();
        Update updateDetails = new Update();
        disData.add(updateDetails.loginPanel, BorderLayout.CENTER);
        // disData.add(updateDetails.update(), BorderLayout.NORTH);
        System.out.println("Data is Updating");
      }

      else {
        disData.add(new Delete().DeleteData(), BorderLayout.SOUTH);
        Display obj = new Display();
     //   disData.add(obj.displayData(DAO.readData()), BorderLayout.NORTH);
        
        System.out.println("Data is Deleting");
      }
      this.setVisible(true);
    } catch (Exception e) {
      System.out.println(e);
    }
  }

}
