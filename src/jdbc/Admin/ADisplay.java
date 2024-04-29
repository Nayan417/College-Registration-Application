package jdbc.Admin;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Label;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import jdbc.DAO;
import jdbc.Student;

public class ADisplay extends JFrame {
 JLabel name, id, fatherName, mobNo, emailId, DOB, gender, address, type, regDate, password, status;
 JPanel headPanel, dataPanel; 
 GridBagLayout gb;  GridBagConstraints gc;
 public Container cn; 
 ArrayList<JLabel> heading = new ArrayList<>();
 int headtextSize = 18, dataTextSize = 18;
 
 
public ADisplay() {
  this.setTitle("Display Data");
  this.setSize(1800, 1200);
  this.setDefaultCloseOperation(EXIT_ON_CLOSE);
  this.setLocationRelativeTo(null);
  this.setLayout(new BorderLayout());
  cn = getContentPane();
  
  init();
  //cn.add(dataPanel, BorderLayout.NORTH);
  //cn.add(headPanel, BorderLayout.NORTH);
  this.setVisible(false);
  this.dispose();

}

void init() {
  gb = new GridBagLayout();
  gc = new GridBagConstraints();
  headPanel = new JPanel(gb);
  dataPanel = new JPanel(gb);
 // dataPanel.setPreferredSize(new Dimension(800, 600));
  gc.insets = new Insets(10, 5, 10, 5);
  dataPanel.setBackground((Color.decode("#f0e9e9")));
  headPanel.setBackground((Color.decode("#f0e5e7")));
  //gc.BorderLayout = 

  // Taking Name from user
  name = new JLabel("Name  ");
  name.setFont(new Font("Serif", Font.BOLD, headtextSize));

  // Taking Roll_No from user
  id = new JLabel("Id ");
  id.setFont(new Font("Serif", Font.BOLD, headtextSize));

  // Taking Father's details
  fatherName = new JLabel("Father's Name  ");
  fatherName.setFont(new Font("Serif", Font.BOLD, headtextSize));

  // Taking Mobile No
  mobNo = new JLabel("Mobile No  ");
  mobNo.setFont(new Font("Serif", Font.BOLD, headtextSize));

  //Taking email_id
  emailId = new JLabel("Email Id  ");
  emailId.setFont(new Font("Serif", Font.BOLD, headtextSize));
   
  // Taking DOB from user
  DOB = new JLabel("DOB  ");
  DOB.setFont(new Font("Serif", Font.BOLD, headtextSize));

  // Taking Gender
  gender = new JLabel("Gender ");
  gender.setFont(new Font("Serif", Font.BOLD, headtextSize));

  //Taking Password
  password = new JLabel("Password  ");
  password.setFont(new Font("Serif", Font.BOLD, headtextSize));
  
   // Taking Address
   address = new JLabel("Address");
   address.setFont(new Font("Serif", Font.BOLD, headtextSize));
  
   // Taking Type
   type = new JLabel("Admin_Type");
   type.setFont(new Font("Serif", Font.BOLD, headtextSize));
  
   regDate = new JLabel("RegDate");
   regDate.setFont(new Font("Serif", Font.BOLD, headtextSize));

   status = new JLabel("Status");
   status.setFont(new Font("Serif", Font.BOLD, headtextSize));

  // Adding all element in heading
  heading.add(name);
  heading.add(id);
  heading.add(fatherName);
  heading.add(mobNo);
  heading.add(emailId);
  heading.add(DOB);
  heading.add(gender);
  heading.add(address);
  heading.add(type);
  heading.add(regDate);
  heading.add(password);
  heading.add(status);
  this.add(dataPanel);
}
 
 public JPanel displayHeading() {

 gc.gridx = 0; gc.gridy = 0;
 int i = 0;
 while(i < heading.size()) {
   headPanel.add(heading.get(i++), gc);
   gc.gridx++;
  }
  headPanel.setBackground(Color.RED);
 // this.add(headPanel, BorderLayout.CENTER);
  this.setVisible(true); 
  this.pack(); 
  return headPanel;
}

 public JPanel displayData(ArrayList<Admin> admins) {
  // Printing heading
  gc.gridx = 0; gc.gridy = 0;
  headPanel.setBackground(Color.blue);
  int i = 0;
  while(i < heading.size()) {
    dataPanel.add(heading.get(i++), gc);
    gc.gridx++;
   }

   // Printing details of user
   if (admins == null ) {
    JLabel msg = new JLabel("Record is empty!");
    dataPanel.add(msg);
    // return dataPanel;
}
   dataPanel.setBounds(0, 0, 700, 600);

   gc.gridy = 1; 
   for (Admin admin : admins) {
          gc.gridy++; gc.gridx = 0;
          ArrayList<String> data = dataFill(admin);
          i = 0;
          while (i < heading.size()) {
                dataPanel.add(new Label(data.get(i++)), gc);
                gc.gridx++;
          }
        }
//  this.add(dataPanel, BorderLayout.NORTH);
 cn.add(dataPanel, BorderLayout.NORTH);
 this.setVisible(true);
 return dataPanel;
}

 public ArrayList<String> dataFill(Admin admin) {
  ArrayList<String> data = new ArrayList<>();

  data.add(admin.getName());
  data.add(admin.getId()+"");
  data.add(admin.getFatherName());
  data.add(admin.getMobNo());
  data.add(admin.getEmailId());
  data.add(admin.getDob());
  data.add(admin.getGender());
  data.add(admin.getAddress());
  data.add(admin.getType());
  data.add(admin.getRegDate()+"");
  data.add(admin.getPassword());
  data.add(admin.getStatus()+"");

  return data;
 }
}

