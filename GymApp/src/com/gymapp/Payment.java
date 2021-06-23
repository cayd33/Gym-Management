package com.gymapp;

import project.ConnectionProvider;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Payment implements ActionListener {
    JFrame frame = new JFrame();
    JLabel payment = new JLabel("PAYMENT");
    JLabel memberID = new JLabel("Member ID");
    JTextField idNumberField = new JTextField();
    JLabel memberName = new JLabel("Name");
    JTextField memberNameField = new JTextField();
    JLabel mobileNumber = new JLabel("Mobile Number");
    JTextField mobileNumberField = new JTextField();
    JLabel email = new JLabel("Email");
    JTextField emailField = new JTextField();
    JLabel amount = new JLabel("Amount to Pay");
    JTextField amountField = new JTextField();
    JButton saveButton = new JButton("Save");
    JButton clearButton = new JButton("Clear");
    JButton backButton = new JButton("Back");
    JButton searchButton = new JButton("Search");
    JPanel panel = new JPanel();
    JLayeredPane panel2 = new JLayeredPane();
    JLabel dateLabel = new JLabel("Date");
    JLabel paymentDate = new JLabel("DD/MM/YYYY");
    JTable memberTable;
    DefaultTableModel mTableModel;
    JButton deleteButton = new JButton("Delete");

    Payment() {
        Border border = BorderFactory.createLineBorder(new Color(86,75,99), 1);

        payment.setBounds(319, 30, 250, 75);
        payment.setFont(new Font("Poppins", Font.BOLD, 50));
        payment.setForeground(Color.lightGray);

        dateLabel.setBounds(54, 204, 44, 27);
        dateLabel.setFont(new Font("Poppins", Font.BOLD, 18));
        dateLabel.setForeground(Color.white);

        paymentDate.setBounds(209, 204, 124, 27);
        paymentDate.setFont(new Font("Poppins", Font.BOLD, 18));
        paymentDate.setForeground(Color.white);

        memberID.setBounds(54, 135, 100, 27);
        memberID.setFont(new Font("Poppins", Font.BOLD, 18));
        memberID.setForeground(Color.white);

        idNumberField.setBounds(209, 135, 200, 30);
        idNumberField.setFont(new Font("Poppins", Font.BOLD, 18));
        idNumberField.setForeground(Color.white);
        idNumberField.setBackground(new Color(70,60,82));
        idNumberField.setBorder(border);

        memberName.setBounds(54, 273, 56, 27);
        memberName.setFont(new Font("Poppins", Font.BOLD, 18));
        memberName.setForeground(Color.white);

        memberNameField.setBounds(54, 300, 540, 40);
        memberNameField.setBackground(new Color(70,60,82));
        memberNameField.setForeground(Color.lightGray);
        memberNameField.setFont(new Font("Poppins", Font.BOLD, 14));
        memberNameField.setBorder(border);
        memberNameField.setEnabled(false);

        mobileNumber.setBounds(54, 383, 142, 27);
        mobileNumber.setFont(new Font("Poppins", Font.BOLD, 18));
        mobileNumber.setForeground(Color.white);

        mobileNumberField.setBounds(54, 410, 540, 40);
        mobileNumberField.setBackground(new Color(70,60,82));
        mobileNumberField.setForeground(Color.lightGray);
        mobileNumberField.setFont(new Font("Poppins", Font.BOLD, 15));
        mobileNumberField.setBorder(border);
        mobileNumberField.setEnabled(false);

        email.setBounds(54, 489, 52, 27);
        email.setFont(new Font("Poppins", Font.BOLD, 18));
        email.setForeground(Color.white);

        emailField.setBounds(54, 516, 540, 40);
        emailField.setBackground(new Color(70,60,82));
        emailField.setForeground(Color.lightGray);
        emailField.setFont(new Font("Poppins", Font.BOLD, 15));
        emailField.setBorder(border);
        emailField.setEnabled(false);

        amount.setBounds(54, 595, 150, 27);
        amount.setFont(new Font("Poppins", Font.BOLD, 20));
        amount.setForeground(Color.white);

        amountField.setBounds(54, 622, 540, 40);
        amountField.setBackground(new Color(70,60,82));
        amountField.setForeground(Color.lightGray);
        amountField.setFont(new Font("Poppins", Font.BOLD, 15));
        amountField.setBorder(border);
        amountField.setEnabled(false);

        backButton.setBounds(0, 43, 150, 50);
        backButton.setFocusable(false);
        backButton.addActionListener(this);
        backButton.setForeground(Color.white);
        backButton.setBackground(new Color(144, 137, 240));
        backButton.setOpaque(true);
        backButton.setFont(new Font("Poppins", Font.BOLD, 16));

        saveButton.setBounds(54, 710, 150, 50);
        saveButton.addActionListener(this);
        saveButton.setFont(new Font("Poppins", Font.BOLD, 18));
        saveButton.setFocusable(false);
        saveButton.setForeground(Color.white);
        saveButton.setBackground(new Color(144, 137, 240));
        saveButton.setOpaque(true);
        saveButton.setFont(new Font("Poppins", Font.BOLD, 16));

        clearButton.setBounds(249, 710, 150, 50);
        clearButton.setFocusable(false);
        clearButton.addActionListener(this);
        clearButton.setFont(new Font("Poppins", Font.BOLD, 18));
        clearButton.setFocusable(false);
        clearButton.setForeground(Color.white);
        clearButton.setBackground(new Color(144, 137, 240));
        clearButton.setOpaque(true);
        clearButton.setFont(new Font("Poppins", Font.BOLD, 16));

        searchButton.setBounds(464, 134, 130, 30);
        searchButton.setFocusable(false);
        searchButton.addActionListener(this);
        searchButton.setFocusable(false);
        searchButton.setForeground(Color.white);
        searchButton.setBackground(new Color(144, 137, 240));
        searchButton.setOpaque(true);

        deleteButton.setBounds(444, 710, 150, 50);
        deleteButton.setFocusable(false);
        deleteButton.addActionListener(this);
        deleteButton.setFont(new Font("Poppins", Font.BOLD, 18));
        deleteButton.setFocusable(false);
        deleteButton.setForeground(Color.white);
        deleteButton.setBackground(new Color(144, 137, 240));
        deleteButton.setOpaque(true);
        deleteButton.setFont(new Font("Poppins", Font.BOLD, 16));

        String[] columns = new String[]{
                "Month", "Amount"
        };

        Object[][] data = new Object[][]{
        };

        mTableModel = new DefaultTableModel(data, columns);
        memberTable = new JTable(mTableModel);
        JScrollPane scrollPane = new JScrollPane(memberTable);

        panel.add(scrollPane, BorderLayout.CENTER);
        panel.setPreferredSize(new Dimension(700, 700));
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(0), "Payment", TitledBorder.CENTER, TitledBorder.TOP));
        memberTable.setPreferredScrollableViewportSize(new Dimension(700, 1000));
        //memberTable.setFillsViewportHeight(true);
        memberTable.setFont(new Font("Poppins", Font.PLAIN, 14));
        memberTable.getTableHeader().setBackground(new Color(149, 130, 168));
        memberTable.getTableHeader().setFont(new Font("Poppins", Font.BOLD, 14));
        memberTable.getTableHeader().setBorder(border);
        memberTable.setBackground(new Color(52, 44, 60));
        memberTable.setForeground(Color.white);
        memberTable.setEnabled(false);
        memberTable.setFont(new Font("Poppins", Font.BOLD, 12));

        panel2.setPreferredSize(new Dimension(700, 1000));


        panel.add(new JScrollPane(memberTable));
        frame.add(panel, BorderLayout.EAST);
        frame.add(panel2, BorderLayout.WEST);
        frame.setTitle("Member List");
        frame.setSize(1440, 900);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        frame.getContentPane().setBackground(new Color(52, 44, 60));
        panel2.setBackground(new Color(52, 44, 60));
        frame.setTitle("Payment");
        panel2.add(deleteButton);
        panel2.add(payment);
        panel2.add(memberID);
        panel2.add(idNumberField);
        panel2.add(memberName);
        panel2.add(memberNameField);
        panel2.add(mobileNumber);
        panel2.add(mobileNumberField);
        panel2.add(email);
        panel2.add(emailField);
        panel2.add(amount);
        panel2.add(amountField);
        panel2.add(saveButton);
        panel2.add(clearButton);
        panel2.add(backButton);
        panel2.add(searchButton);
        panel2.add(dateLabel);
        panel2.add(paymentDate);
        frame.setSize(1400, 900);
        frame.setLayout(new BorderLayout());
    }

    public void tableDetails() {
        DefaultTableModel dtm = (DefaultTableModel) memberTable.getModel();
        dtm.setRowCount(0);
        String id = idNumberField.getText();
        try {
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select *from payment where id='" + id + "'");
            while (rs.next()) {
                dtm.addRow(new Object[]{rs.getString(2), rs.getString(3)});
            }
        } catch (Exception e1) {
            JOptionPane.showMessageDialog(null, e1);
        }
    }

    public void date() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        Date date = new Date();
        String month = dateFormat.format(date);
        paymentDate.setText(month);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            frame.dispose();
            new MainMenu();
        }

        if (e.getSource() == clearButton) {
            frame.dispose();
            new Payment();
        }

        date();

        if (e.getSource() == searchButton) {
            tableDetails();
            int checkid = 0;
            String id = idNumberField.getText();
            String month = paymentDate.getText();
            try {
                Connection con = ConnectionProvider.getCon();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select *from member where id='" + id + "'");
                while (rs.next()) {
                    checkid = 1;
                    idNumberField.setEditable(false);
                    memberNameField.setText(rs.getString(2));
                    mobileNumberField.setText(rs.getString(3));
                    emailField.setText(rs.getString(4));
                    amountField.setText(rs.getString(9));
                }
                if (checkid == 0) {
                    JOptionPane.showMessageDialog(null, "Member ID does not Exist");

                    ResultSet rs1 = st.executeQuery("select *from payment inner join member where payment.month='" +
                            month + "' and payment.id'" + id + "' and member.id='" + id + "'");
                    while (rs1.next()) {
                        saveButton.setVisible(false);
                        JOptionPane.showMessageDialog(null, "Payment is already done for this month");
                    }
                }
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, e1);
            }
        }
        if (e.getSource() == saveButton) {
            String id = idNumberField.getText();
            String month = paymentDate.getText();
            String amount = amountField.getText();
            try {
                Connection con = ConnectionProvider.getCon();
                PreparedStatement ps = con.prepareStatement("insert into payment values (?,?,?)");
                ps.setString(1, id);
                ps.setString(2, month);
                ps.setString(3, amount);
                ps.executeUpdate();
                //tableDetails();
                JOptionPane.showMessageDialog(null, "Successfully Saved");
                frame.dispose();
                new Payment();
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, e1);
            }
        }

        if (e.getSource() == deleteButton) {
            int yesNo = JOptionPane.showConfirmDialog(null, "Do you want to Delete", "Select", JOptionPane.YES_NO_OPTION);
            if (yesNo == 0) {
                String id = idNumberField.getText();
                try {
                    Connection con = ConnectionProvider.getCon();
                    Statement st = con.createStatement();
                    st.executeUpdate("delete  from payment where id='" + id + "'");
                    JOptionPane.showMessageDialog(null, "Successfully Deleted");
                    frame.dispose();
                    new Payment();
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, e1);
                }
            }
        }
    }
}
