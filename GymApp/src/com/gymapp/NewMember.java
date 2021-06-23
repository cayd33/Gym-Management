package com.gymapp;

import project.ConnectionProvider;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class NewMember implements ActionListener {
    Connection con;

    JFrame frame = new JFrame();
    JLabel newMember = new JLabel("NEW MEMBER");
    JLabel memberID = new JLabel("Member ID");
    JLabel idNumber = new JLabel("00");
    JLabel memberName = new JLabel("Name");
    JTextField memberNameField = new JTextField();
    JLabel mobileNumber = new JLabel("Mobile Number");
    JTextField mobileNumberField = new JTextField();
    JLabel email = new JLabel("Email");
    JTextField emailField = new JTextField();
    JLabel gender = new JLabel("Gender");
    JComboBox genderBox = new JComboBox();
    JLabel gymTime = new JLabel("Gym Time");
    JComboBox timeBox = new JComboBox();
    JLabel cardId = new JLabel("Card ID");
    JTextField cardField = new JTextField();
    JLabel age = new JLabel("Age");
    JTextField ageField = new JTextField();
    JLabel amount = new JLabel("Amount to Pay");
    JTextField amountField = new JTextField();
    JButton saveButton = new JButton("Save");
    JButton clearButton = new JButton("Clear");
    JButton backButton = new JButton("Back");

    NewMember() {
        newMember.setBounds(600, 30, 350, 75);
        newMember.setFont(new Font("Poppins", Font.BOLD, 50));
        newMember.setForeground(Color.lightGray);

        memberID.setBounds(54, 135, 100, 27);
        memberID.setFont(new Font("Poppins", Font.BOLD, 18));
        memberID.setForeground(Color.white);

        idNumber.setBounds(194, 135, 120, 27);
        idNumber.setFont(new Font("Poppins", Font.BOLD, 18));
        idNumber.setForeground(Color.white);

        memberName.setBounds(54, 205, 56, 27);
        memberName.setFont(new Font("Poppins", Font.BOLD, 18));
        memberName.setForeground(Color.white);

        Border border = BorderFactory.createLineBorder(new Color(86,75,99), 1);

        memberNameField.setBounds(54, 232, 400, 40);
        memberNameField.setBackground(new Color(70,60,82));
        memberNameField.setForeground(Color.lightGray);
        memberNameField.setFont(new Font("Poppins", Font.BOLD, 14));
        memberNameField.setBorder(border);

        mobileNumber.setBounds(54, 315, 142, 27);
        mobileNumber.setFont(new Font("Poppins", Font.BOLD, 18));
        mobileNumber.setForeground(Color.white);

        mobileNumberField.setBounds(54, 342, 400, 40);
        mobileNumberField.setBackground(new Color(70,60,82));
        mobileNumberField.setForeground(Color.lightGray);
        mobileNumberField.setFont(new Font("Poppins", Font.BOLD, 15));
        mobileNumberField.setBorder(border);

        email.setBounds(54, 421, 52, 27);
        email.setFont(new Font("Poppins", Font.BOLD, 18));
        email.setForeground(Color.white);

        emailField.setBounds(54, 448, 400, 40);
        emailField.setBackground(new Color(70,60,82));
        emailField.setForeground(Color.lightGray);
        emailField.setFont(new Font("Poppins", Font.BOLD, 15));
        emailField.setBorder(border);

        gender.setBounds(54, 527, 80, 27);
        gender.setFont(new Font("Poppins", Font.BOLD, 18));
        gender.setForeground(Color.white);

        genderBox.setBounds(54, 554, 400, 40);
        genderBox.setModel(new DefaultComboBoxModel<>(new String[]{"Male", "Female", "Others"}));
        genderBox.addActionListener(this);
        genderBox.setBackground(new Color(70,60,82));
        genderBox.setForeground(Color.lightGray);
        genderBox.setFont(new Font("Poppins", Font.BOLD, 15));
        genderBox.setBorder(border);

        gymTime.setBounds(545, 205, 95, 27);
        gymTime.setFont(new Font("Poppins", Font.BOLD, 18));
        gymTime.setForeground(Color.white);

        timeBox.setBounds(545, 232, 400, 40);
        timeBox.setModel(new DefaultComboBoxModel<>(new String[]{"05:00 - 09:00", "09:00 - 13:00", "13:00 - 17:00", "17:00 - 21:00"}));
        timeBox.addActionListener(this);
        timeBox.setBackground(new Color(70,60,82));
        timeBox.setForeground(Color.lightGray);
        timeBox.setFont(new Font("Poppins", Font.BOLD, 15));
        timeBox.setBorder(border);

        cardId.setBounds(545, 315, 80, 27);
        cardId.setFont(new Font("Poppins", Font.BOLD, 20));
        cardId.setForeground(Color.white);

        cardField.setBounds(545, 342, 400, 40);
        cardField.setBackground(new Color(70,60,82));
        cardField.setForeground(Color.lightGray);
        cardField.setFont(new Font("Poppins", Font.BOLD, 15));
        cardField.setBorder(border);

        age.setBounds(545, 421, 37, 27);
        age.setFont(new Font("Poppins", Font.BOLD, 20));
        age.setForeground(Color.white);

        ageField.setBounds(545, 448, 400, 40);
        ageField.setBackground(new Color(70,60,82));
        ageField.setForeground(Color.lightGray);
        ageField.setFont(new Font("Poppins", Font.BOLD, 15));
        ageField.setBorder(border);

        amount.setBounds(545, 527, 150, 27);
        amount.setFont(new Font("Poppins", Font.BOLD, 20));
        amount.setForeground(Color.white);

        amountField.setBounds(545, 554, 400, 40);
        amountField.setBackground(new Color(70,60,82));
        amountField.setForeground(Color.lightGray);
        amountField.setFont(new Font("Poppins", Font.BOLD, 15));
        amountField.setBorder(border);

        backButton.setBounds(0, 43, 150, 50);
        backButton.setFocusable(false);
        backButton.addActionListener(this);
        backButton.setForeground(Color.white);
        backButton.setBackground(new Color(144, 137, 240));
        backButton.setOpaque(true);
        backButton.setFont(new Font("Poppins", Font.BOLD, 16));

        saveButton.setBounds(179, 660, 150, 50);
        saveButton.addActionListener(this);
        saveButton.setFont(new Font("Poppins", Font.BOLD, 18));
        saveButton.setFocusable(false);
        saveButton.setForeground(Color.white);
        saveButton.setBackground(new Color(144, 137, 240));
        saveButton.setOpaque(true);
        saveButton.setFont(new Font("Poppins", Font.BOLD, 16));

        clearButton.setBounds(670, 660, 150, 50);
        clearButton.addActionListener(this);
        clearButton.setFont(new Font("Poppins", Font.BOLD, 18));
        clearButton.setFocusable(false);
        clearButton.setForeground(Color.white);
        clearButton.setBackground(new Color(144, 137, 240));
        clearButton.setOpaque(true);
        clearButton.setFont(new Font("Poppins", Font.BOLD, 16));

        frame.setTitle("New Member");
        frame.add(newMember);
        frame.add(memberID);
        frame.add(idNumber);
        frame.add(memberName);
        frame.add(memberNameField);
        frame.add(mobileNumber);
        frame.add(mobileNumberField);
        frame.add(email);
        frame.add(emailField);
        frame.add(gender);
        frame.add(genderBox);
        frame.add(gymTime);
        frame.add(timeBox);
        frame.add(cardId);
        frame.add(cardField);
        frame.add(age);
        frame.add(ageField);
        frame.add(amount);
        frame.add(amountField);
        frame.add(saveButton);
        frame.add(clearButton);
        frame.add(backButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 800);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(new Color(52, 44, 60));

        try {
            int id = 1;
            String str1 = String.valueOf(id);
            idNumber.setText(str1);
            con = ConnectionProvider.getCon();
            assert con != null;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select max(id) from member");
            while (rs.next()) {
                id = rs.getInt(1);
                id = id + 1;
                String str = String.valueOf(id);
                idNumber.setText(str);
            }
        } catch (Exception e1) {
            JOptionPane.showMessageDialog(null, e1);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == backButton) {
            frame.dispose();
            new MainMenu();
        }

        if (e.getSource() == clearButton) {
            memberNameField.setText("");
            mobileNumberField.setText("");
            emailField.setText("");
            cardField.setText("");
            ageField.setText("");
            amountField.setText("");
        }

        if (e.getSource() == saveButton) {
            String id = idNumber.getText();
            String name = memberNameField.getText();
            String mobile = mobileNumberField.getText();
            String email = emailField.getText();
            String gender = (String) genderBox.getSelectedItem();
            String time = (String) timeBox.getSelectedItem();
            String personalnumber = cardField.getText();
            String age = ageField.getText();
            String amount = amountField.getText();
            try {
                con = ConnectionProvider.getCon();
                assert con != null;
                PreparedStatement ps = con.prepareStatement("insert into member values (?,?,?,?,?,?,?,?,?)");
                ps.setString(1, id);
                ps.setString(2, name);
                ps.setString(3, mobile);
                ps.setString(4, email);
                ps.setString(5, gender);
                ps.setString(6, time);
                ps.setString(7, personalnumber);
                ps.setString(8, age);
                ps.setString(9, amount);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Successfully Saved");
                frame.dispose();
                new NewMember();
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, e1);
            }
        }
    }
}
