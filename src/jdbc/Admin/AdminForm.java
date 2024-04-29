package jdbc.Admin;

import java.awt.*;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.awt.Color;


import javax.swing.*;
import javax.swing.border.EmptyBorder;

import jdbc.DAO;
import jdbc.Home;
//User defined package for JDBC
import jdbc.Student;
import jdbc.AdminPr.LogoAdm;

public class AdminForm extends JFrame implements ActionListener{
    public static void main(String[] args) {
      AdminForm obj = new AdminForm();
    }

    // Variable declaration
    public JPanel formPanel;
    public Container cn;
    JLabel nameLab, idLab, DOBLab, fatherNameLab, typeLab, mobNoLab, emailLab, genderLab, addressLab, msgLab,
             passwordLab, cofPasswordLab, mes;
    JTextField name, id, fatherName, mobNo, email, cofPassword;
    JPasswordField password;
    JComboBox type, day, month, year;
    JRadioButton male, female;
    JTextArea address;
    JCheckBox terms;
    JButton submit, homeBtn;
    int fieldWidth = 25, fieldHeight = 10, textSize = 16;

       // Taking Data_Of_Birth
  String days[] = { "dd", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15",
 "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
 String months[] = { "mm", "jen", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
 String years[] = {
 "yy", "2024", "2023", "2022", "2021", "2020", "2019", "2018", "2017", "2016", "2015", "2014",
 "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000",
 "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988",
 "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975"
};

String types[] = {"Admin", "Sub_Admin"};


    // Initialize variable
    void init() {
        this.setBackground((Color.decode("#f0e9e9")));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
         cn = getContentPane();
         cn.setLayout(new BorderLayout());
        // cn.setBackground((Color.decode("#f0e9e9")));
        formPanel = new JPanel();
        formPanel.setSize(new Dimension(1800, 900));
        
        JLabel logo = new JLabel("Cambridge Institute of Technology");
        logo.setFont(new Font("Serif", Font.BOLD, textSize+5));
        logo.setForeground(Color.BLUE);
        
        JPanel headingPanel = new JPanel();
        headingPanel.setBorder(new EmptyBorder(40, 90, 5, 10));
        headingPanel.add(logo);
       
        cn.add(headingPanel, BorderLayout.BEFORE_FIRST_LINE);

        // Taking Name from user
        nameLab = new JLabel("Name * ");
        nameLab.setFont(new Font("Serif", Font.BOLD, textSize));
        name = new JTextField(fieldWidth);
        name.setBounds(0, 0, 20, 30);

        // Taking Roll_No from user
        idLab = new JLabel("Login Id * ");
        idLab.setFont(new Font("Serif", Font.BOLD, textSize));
        id = new JTextField(fieldWidth);

        // Taking Father's details
        fatherNameLab = new JLabel("Father's Name * ");
        fatherNameLab.setFont(new Font("Serif", Font.BOLD, textSize));

        fatherName = new JTextField(fieldWidth);

        // Taking Mobile No
        mobNoLab = new JLabel("Mobile No * ");
        mobNoLab.setFont(new Font("Serif", Font.BOLD, textSize));
        mobNo = new JTextField(fieldWidth);

        // Taking email_id
        emailLab = new JLabel("Email Id * ");
        emailLab.setFont(new Font("Serif", Font.BOLD, textSize));
        email = new JTextField(fieldWidth);

        // Taking DOB from user
        DOBLab = new JLabel("DOB * ");
        DOBLab.setFont(new Font("Serif", Font.BOLD, textSize));

        day = new JComboBox(days);
        month = new JComboBox(months);
        year = new JComboBox(years);

        // Admin types
        typeLab = new JLabel("Enter Admin type * ");
        typeLab.setFont(new Font("Serif", Font.BOLD, textSize));

        type = new JComboBox(types);

        // Taking Gender
        genderLab = new JLabel("Gender ");
        genderLab.setFont(new Font("Serif", Font.BOLD, textSize));

        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        male.setFont(new Font("Serif", Font.BOLD, textSize));
        female.setFont(new Font("Serif", Font.BOLD, textSize));

        ButtonGroup gen = new ButtonGroup();
        gen.add(male);  gen.add(female);

        // Taking Password
        passwordLab = new JLabel("Password * ");
        passwordLab.setFont(new Font("Serif", Font.BOLD, textSize));
        password = new JPasswordField(fieldWidth);

        // Conform Password
        cofPasswordLab = new JLabel("Conform Password ");
        cofPasswordLab.setFont(new Font("Serif", Font.BOLD, textSize));
        cofPassword = new JTextField(fieldWidth);

        // Taking Address
        addressLab = new JLabel("Address");
        addressLab.setFont(new Font("Serif", Font.BOLD, textSize));
        address = new JTextArea(3, 30);

        // Terms and Condition
        terms = new JCheckBox();

        mes = new JLabel("Accept terms and condition !");
        mes.setFont(new Font("Serif", Font.BOLD, textSize));

        // Submit Button
        submit = new JButton("Submit");

        homeBtn = new JButton("Home");

        msgLab = new JLabel("");
    }

    public AdminForm() {
        init();
        setTitle("Registration Form");
        setLocationRelativeTo(null);
        this.setSize(1000, 900);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Gridbag layout
        GridBagLayout gb = new GridBagLayout();
        GridBagConstraints gc = new GridBagConstraints();
        formPanel.setLayout(gb);

        gc.insets = new Insets(10, 20, 5, 10);
        gc.gridx = 0;
        gc.gridy = 0;
        formPanel.add(nameLab, gc);
        gc.gridx++;
        formPanel.add(name, gc);
        gc.gridx++;
        formPanel.add(idLab, gc);
        gc.gridx++;
        formPanel.add(id, gc);

        gc.insets = new Insets(20, 20, 5, 10);

        gc.gridy++;
        gc.gridx = 0;
        formPanel.add(fatherNameLab, gc);
        gc.gridx++;
        formPanel.add(fatherName, gc);
       
        gc.gridx ++;
          formPanel.add(typeLab, gc);
          gc.gridx++;
          formPanel.add(type, gc);
  

        gc.gridy++;
        gc.gridx = 0;
      //  gc.insets = new Insets(20, 40, 5, 10);
        formPanel.add(mobNoLab, gc);
        gc.gridx++;
        formPanel.add(mobNo, gc);

        gc.gridx++;
        formPanel.add(emailLab, gc);
        gc.gridx++;
        formPanel.add(email, gc);

        gc.gridy++;
        gc.gridx = 0;
      //  gc.insets = new Insets(5, 0, 5, 10);
        formPanel.add(DOBLab, gc);
        gc.insets = new Insets(5, 0, 5, 0);
        gc.gridx++;
        formPanel.add(day, gc);
        gc.gridx++;
        formPanel.add(month, gc);
        gc.gridx++;
        formPanel.add(year, gc);

        gc.gridy++;
        gc.gridx = 0;
        formPanel.add(genderLab, gc);
        gc.gridx++;
        formPanel.add(male, gc);
        gc.gridx++;
        formPanel.add(female, gc);

        gc.gridy++;
        gc.gridx = 0;
        formPanel.add(passwordLab, gc);
        gc.gridx++;
        formPanel.add(password, gc);

        gc.gridx++;
        formPanel.add(cofPasswordLab, gc);
        gc.gridx++;
        formPanel.add(cofPassword, gc);

        gc.gridy++; gc.gridx = 0;
        formPanel.add(addressLab, gc);
        gc.gridx++;
        formPanel.add(address, gc);
        
        gc.gridy++; gc.gridx = 0;
        formPanel.add(terms,gc);
        gc.gridx++;
        formPanel.add(mes, gc);
 
          gc.gridy += 1; gc.gridx = 0;
          formPanel.add(submit, gc);
          submit.addActionListener(this);

          gc.gridx ++;
          formPanel.add(homeBtn, gc);
          homeBtn.addActionListener(this);

          gc.gridx = 1; gc.gridy += 1;
          formPanel.add(msgLab, gc);

        cn.add(formPanel, BorderLayout.CENTER);
        cn.setVisible(true);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String selectedBtn = ae.getActionCommand();
        if (selectedBtn.equals("Home")) {
            new AdminHome();
            dispose();
        } else {
            String Password = "";
            for (char ch : password.getPassword()) Password += ch;

            if (id.getText().equals("") || name.getText().equals("") || day.getSelectedItem().equals("dd")
                    || month.getSelectedItem().equals("mm") || year.getSelectedItem().equals("yy") ||
                    fatherName.getText().equals("") || Password.equals("")) {
                msgLab.setText("Please complete the form before submiting!");
            } 
            else if (!(Password.equals(cofPassword.getText()))) {
                msgLab.setText("Password not matched, Enter correct Password!");
                System.out.println(Password);
                System.out.println(cofPassword.getText().toString());
            }
            // Verify checkbox is selected or not
            else if (!terms.isSelected()) {
                msgLab.setText("You have to accept terms and condition for submiting the form!");
            } 
            else {
                msgLab.setText("Registration Successfull!");
                String temp = male.isSelected() ? "Male" : "Female";
                JLabel gen = new JLabel(temp);

                // Inserting data in database
                String Name = name.getText();
                String Id = id.getText();
                String DOB = year.getSelectedItem() + "-" + month.getSelectedItem() + "-" + day.getSelectedItem();
                String FatherName = fatherName.getText();
                String MobNo = mobNo.getText();
                String Email = email.getText();
                String Gender = male.isSelected() ? "Male" : "Female";
                String Address = address.getText();
                String Type = type.getSelectedItem() +"";
              
                Admin admin = new Admin(Id, Name, FatherName, MobNo, Email, DOB, Gender, Address, Type,Password, 1);
                try {
                    ADAO.insertAdmData(admin);
                 //   new ConformationForm(student);
                } catch (Exception e) {
                    System.out.println(e);
                }
             //   Display obj = new Admin().new Display(student);
            }
        }
    }
}