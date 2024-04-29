package user;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.Document;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.PrintJob;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

// import com.itextpdf.text.Document;
// import com.itextpdf.text.DocumentException;
// import com.itextpdf.text.Paragraph;
// import com.itextpdf.text.pdf.PdfWriter;

public class saveAsPdf extends JFrame implements ActionListener{
JLabel label1, label2, titleLab;
JTextField input1, input2;
JPanel panel;
JButton submit;

 public saveAsPdf() {
 this.setSize(600, 700);
 this.setDefaultCloseOperation(EXIT_ON_CLOSE);
 this.setTitle("Registration Details");
 panel = new JPanel();
 panel.setSize(400, 400);
 titleLab = new JLabel();
 titleLab.setText("Cambridge Instutite Of Technology Ranchi");
 titleLab.setBounds(130, 30, 70, 30);
 
 label1 = new JLabel("Enter name");
 input1 = new JTextField(20);
 
 label2 = new JLabel("Enter Branch");
 input2 = new JTextField(20);
 
 label1.setBounds(30, 100, 70, 30);
 input1.setBounds(130, 190, 70, 30);
 label2.setBounds(30, 220, 70, 30);
 input2.setBounds(130, 350, 70, 30);
 submit = new JButton("Submit");
 submit.setBounds(0, 200, 170, 30);

 panel.add(titleLab);
 panel.add(label1);
 panel.add(input1);
 panel.add(label2);
 panel.add(input2);
 this.add(submit);

 submit.addActionListener(this);
this.add(panel);
this.setVisible(true);
 }
 

 public void actionPerformed(ActionEvent ae) {

 Toolkit tkp = panel.getToolkit();
 PrintJob pjp = tkp.getPrintJob(this, null, null);
 Graphics g = pjp.getGraphics();
 panel.print(g);
 g.dispose();
 pjp.end();
 }

 public static void main(String[] args) {
  new saveAsPdf();
 }
}
