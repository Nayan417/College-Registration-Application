package user;

import javax.crypto.spec.GCMParameterSpec;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

import jdbc.DAO;
import jdbc.AdminPr.LogoAdm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Delete extends JFrame implements ActionListener {
    JPanel deletePanel;
    JLabel idLabel, msgLabel;
    JTextField input1;
    JButton deleteBtn, homeBtn;
    GridBagLayout gb;
    GridBagConstraints gc;

    public Delete() {
        this.setTitle("Delete Record");
        this.setLayout(new BorderLayout());
        this.setSize(600, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        gb = new GridBagLayout();
        gc = new GridBagConstraints();
        deletePanel = new JPanel(gb);
        deletePanel.setPreferredSize(new Dimension(400, 200));

        deletePanel.setBackground(Color.cyan);
    }

    public JPanel DeleteData() {

        // What you wants to Delete

        // Taking Roll_No from user
        gc.insets = new Insets(10, 10, 20, 10);
        gc.gridx = 0;
        gc.gridy = 0;
        idLabel = new JLabel("Enter Roll No");
        idLabel.setFont(new Font("Serif", Font.BOLD, 17));
        deletePanel.add(idLabel, gc);

        gc.gridx = 2;
        input1 = new JTextField(10);
        input1.setFont(new Font("Serif", Font.BOLD, 17));

        deletePanel.add(input1, gc);
        gc.gridy = 3;
        gc.gridx = 0;

        deleteBtn = new JButton("Delete");
        deleteBtn.setFont(new Font("Serif", Font.BOLD, 20));
        deletePanel.add(deleteBtn, gc);
        deleteBtn.addActionListener(this);

        msgLabel = new JLabel("");
        gc.gridy++;
        gc.gridx = 0;
        deletePanel.add(msgLabel, gc);

        this.add(deletePanel);
        this.setVisible(true);
        return deletePanel;
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            int status = DAO.deleteData(input1.getText());
            if (status == 1) {
                msgLabel.setText("Data Deleted Successfully!, Click Display Button to show the Updated result");
            } else
                msgLabel.setText("Record does not found! Delete Unsuccessful");
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void main(String args[]) {
        Delete obj = new Delete();
        JPanel temp = obj.DeleteData();
    }
}
