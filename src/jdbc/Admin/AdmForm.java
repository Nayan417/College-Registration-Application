package jdbc.Admin;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import jdbc.DAO;
//User defined package for JDBC
import jdbc.Student;

public class AdmForm {
    MyFrame obj;
    public AdmForm() {
    MyFrame obj = new MyFrame();
    }
    public static void main(String args[]) {
        MyFrame obj = new MyFrame();
    }
}
class MyFrame extends JFrame implements ActionListener {

    JLabel nameLab, DOBLab, fatherNameLab, mobNoLab, emailIdLab, genderLab, addressLab, msgLab, passwordLab1, passwordLab2;
    JTextField name, rollNo, fatherName, password, confPassword, mobNo, emailId;
    JComboBox course, semester, day, month, year;
    JRadioButton male, female;
    JTextArea address;
    JCheckBox terms;
    JButton button;

 //Taking Data_Of_Birth
   String days[] = {"dd","1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15",
            "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
   String months[] = {"mm","jen", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
   String years[] = {
            "yy", "2024", "2023", "2022", "2021", "2020", "2019", "2018", "2017", "2016", "2015", "2014",
            "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000",
            "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988",
            "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975"
        };
        
   int scwidth = 900, scheight = 1000;

    public MyFrame() {
        // Basic Setup   
        setTitle("Admin Registration Form");
        setSize(scwidth, scheight);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(null);
        c.setBackground((Color.decode("#f0e9e9")));
         
        int leftColmrgn = 20, leftColmrgnInplft = 130, rightColmrgnInplft = 450, rightColmrgnInpRt = 550, topmrgn = 0, textWidth = 165, textHeight = 30;
        
        // Taking Name from user
        nameLab = new JLabel("Name");
        nameLab.setBounds(leftColmrgn, topmrgn+=50, textWidth, textHeight);
        c.add(nameLab);
        name = new JTextField();
        name.setBounds(leftColmrgnInplft, topmrgn, textWidth, textHeight);
        c.add(name);

        // Taking Father's details
        fatherNameLab = new JLabel("Father's Name");
        fatherNameLab.setBounds(leftColmrgn, topmrgn+=50, textWidth, textHeight);
        c.add(fatherNameLab);
        fatherName = new JTextField();
        fatherName.setBounds(leftColmrgnInplft, topmrgn, textWidth, textHeight);
        c.add(fatherName);

        // Taking Mobile No
        mobNoLab = new JLabel("Mobile No");
        mobNoLab.setBounds(leftColmrgn, topmrgn+=50, textWidth, textHeight);
        c.add(mobNoLab);
        mobNo = new JTextField();
        mobNo.setBounds(leftColmrgnInplft, topmrgn, textWidth, textHeight);
        c.add(mobNo);

        //Taking email_id
        emailIdLab = new JLabel("Email Id");
        emailIdLab.setBounds(rightColmrgnInplft, topmrgn, textWidth, textHeight);
        c.add(emailIdLab);
        emailId = new JTextField();
        emailId.setBounds(rightColmrgnInpRt, topmrgn, textWidth, textHeight);
        c.add(emailId);

        // Taking DOB from user
        DOBLab = new JLabel("DOB");
        DOBLab.setBounds(leftColmrgn, topmrgn+=50, textWidth, textHeight);
        c.add(DOBLab);
        day = new JComboBox(days);
        month = new JComboBox(months);
        year = new JComboBox(years);
        c.add(day);
        c.add(month);
        c.add(year);

        day.setBounds(leftColmrgnInplft, topmrgn, textWidth-95, textHeight);
        month.setBounds(leftColmrgnInplft+80, topmrgn, textWidth-95, textHeight);
        year.setBounds(leftColmrgnInplft+160, topmrgn, textWidth-90, textHeight);

        // Taking Gender
        genderLab = new JLabel("Gender");
        genderLab.setBounds(leftColmrgn, topmrgn+=50, textWidth, textHeight);
        c.add(genderLab);

        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        male.setBounds(leftColmrgnInplft, topmrgn, textWidth-100, textHeight);
        female.setBounds(leftColmrgnInplft+80, topmrgn, textWidth-75, textHeight);
        c.add(male);
        c.add(female);

        ButtonGroup gen = new ButtonGroup();
        gen.add(male);
        gen.add(female);

        // Taking Address
        addressLab = new JLabel("Address");
        addressLab.setBounds(leftColmrgn, topmrgn+=50, textWidth, textHeight);
        c.add(addressLab);
        address = new JTextArea();
        address.setBounds(leftColmrgnInplft, topmrgn, textWidth, textHeight);
        c.add(address);

        passwordLab1 = new JLabel("Enter Password");
        addressLab.setBounds(leftColmrgn, topmrgn+=50, textWidth, textHeight);
        c.add(passwordLab1);
        password = new JTextField();
        address.setBounds(leftColmrgnInplft, topmrgn, textWidth, textHeight);
        c.add(password);

        passwordLab2 = new JLabel("Conform Password");
        addressLab.setBounds(leftColmrgn, topmrgn+=50, textWidth, textHeight);
        c.add(passwordLab2);
        confPassword = new JTextField();
        address.setBounds(rightColmrgnInpRt, topmrgn, textWidth, textHeight);
        c.add(confPassword);

        // Terms and Condition
        terms = new JCheckBox();
        terms.setBounds(leftColmrgn, topmrgn+=50, 20, 20);
        c.add(terms);
        JLabel mes = new JLabel("Accept terms and condition");
        mes.setBounds(leftColmrgn+30, topmrgn, textWidth+100, 20);
        c.add(mes);

        // Submit Button
        button = new JButton("Add");
        button.setBounds(leftColmrgn, topmrgn+=50, textWidth, textHeight);
        c.add(button);

        msgLab = new JLabel("");
        msgLab.setBounds(leftColmrgn, topmrgn+=50, textWidth+300, textHeight);
        c.add(msgLab);

        button.addActionListener(this);
         
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if(rollNo.getText().equals("") || name.getText().equals("") || day.getSelectedItem().equals("dd") || month.getSelectedItem().equals("mm") || year.getSelectedItem().equals("yy")) {
            msgLab.setText("Pleas complete the form before submiting!");
        }
       
        // Verify checkbox is selected or not
        else if (terms.isSelected()) {
            msgLab.setText("Registration Successfull!");
            String temp = male.isSelected() ? "Male" : "Female";
            JLabel gen = new JLabel(temp);

            // Inserting data in database
            String Name = name.getText();
            String FatherName = fatherName.getText();
            String dob =  year.getSelectedItem()+"-" + month.getSelectedItem() + "-" + day.getSelectedItem();
            String MobNo = mobNo.getText();
            String Email = emailId.getText();
            String Gender = male.isSelected() ? "Male" : "Female";
            String Address = address.getText();
            String Password = password.getText();

            Admin admin = new Admin(1, Name, FatherName,  MobNo, Email, dob, Gender, Address, Password, 1);
            try{
            ADAO.insertAdmData(admin);
            } catch(Exception e) {
                System.out.println(e);
            }
           // OutPutFrame obj = new OutPutFrame(student);
       
        } else {
            msgLab.setText("You have to accept terms and condition for submiting the form!");
        }
    }


//}
// Displaying the output
/* 
    class OutPutFrame extends JFrame {

        JTextArea userInfo;
        JLabel msg;

        public OutPutFrame(Student student) {
            setSize(700, 700);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Container cn = getContentPane();
            cn.setLayout(null);
            setTitle("Registration Successfull!");

            msg = new JLabel("");
            msg.setBounds(140, 20, 400, 30);
            cn.add(msg);
            msg.setText("This is your Registration details");

            // Printing details of user
            String Name = student.getName();
            String RollNo = student.getRollNo();
            String Course = student.getCourse();
            String Semester = student.getSemester();
            String MobNo = student.getMobNo();
            
            String FatherName = fatherName.getText();
            String MotherName = motherName.getText();
            String dob = day.getSelectedItem() + "-" + month.getSelectedItem() + "-" + year.getSelectedItem();
            String Email = emailId.getText();
            String Gender = male.isSelected() ? "Male" : "Female";
            String Address = address.getText();

            String data = "\tName : " + Name + "\n\tRoll No : " + RollNo + "\n\tFather's Name : " + FatherName + "\n\tMother's Name" + MotherName + 
                          "\n\tMobile No : " + MobNo + "\n\tEmail Id : " + Email + "\n\tDoB : " + dob + "\n\tGender : " + Gender + "\n\tAddress :  " + Address;
            

            userInfo = new JTextArea();
            userInfo.setBounds(30, 50, 700, 700);
            userInfo.setText(data);
            cn.add(userInfo);

            setVisible(true);
        }
    }
*/
   }

// color (Color.decode("#f0e9e9"))
