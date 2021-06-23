package com.gymapp;

import project.ConnectionProvider;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class UpdateDeleteMember implements ActionListener {

    JFrame frame = new JFrame();
    JLabel updateDeleteMember = new JLabel("UPDATE & DELETE MEMBER");
    JLabel memberID = new JLabel("Member ID");
    JTextField idNumberField = new JTextField();
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
    JButton updateButton = new JButton("Update");
    JButton clearButton = new JButton("Clear");
    JButton backButton = new JButton("Back");
    JButton searchButton = new JButton("Search");
    JButton deleteButton = new JButton("Delete");

    UpdateDeleteMember() {
        Border border = BorderFactory.createLineBorder(new Color(86,75,99), 1);

        updateDeleteMember.setBounds(260, 30, 720, 75);
        updateDeleteMember.setFont(new Font("Poppins", Font.BOLD, 50));
        updateDeleteMember.setForeground(Color.lightGray);

        memberID.setBounds(54, 135, 100, 27);
        memberID.setFont(new Font("Poppins", Font.BOLD, 18));
        memberID.setForeground(Color.white);

        idNumberField.setBounds(194, 135, 120, 27);
        idNumberField.setFont(new Font("Poppins", Font.BOLD, 18));
        idNumberField.setForeground(Color.white);
        idNumberField.setBackground(new Color(70,60,82));
        idNumberField.setBorder(border);

        memberName.setBounds(54, 205, 56, 27);
        memberName.setFont(new Font("Poppins", Font.BOLD, 18));
        memberName.setForeground(Color.white);

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

        updateButton.setBounds(179, 660, 150, 50);
        updateButton.addActionListener(this);
        updateButton.setFont(new Font("Poppins", Font.BOLD, 18));
        updateButton.setFocusable(false);
        updateButton.setForeground(Color.white);
        updateButton.setBackground(new Color(144, 137, 240));
        updateButton.setOpaque(true);
        updateButton.setFont(new Font("Poppins", Font.BOLD, 16));

        clearButton.setBounds(423, 660, 150, 50);
        clearButton.setFocusable(false);
        clearButton.addActionListener(this);
        clearButton.setFont(new Font("Poppins", Font.BOLD, 18));
        clearButton.setFocusable(false);
        clearButton.setForeground(Color.white);
        clearButton.setBackground(new Color(144, 137, 240));
        clearButton.setOpaque(true);
        clearButton.setFont(new Font("Poppins", Font.BOLD, 16));

        searchButton.setBounds(370, 134, 130, 30);
        searchButton.setFocusable(false);
        searchButton.addActionListener(this);
        searchButton.setFocusable(false);
        searchButton.setForeground(Color.white);
        searchButton.setBackground(new Color(144, 137, 240));
        searchButton.setOpaque(true);

        deleteButton.setBounds(670, 660, 150, 50);
        deleteButton.setFocusable(false);
        deleteButton.addActionListener(this);
        deleteButton.setFont(new Font("Poppins", Font.BOLD, 18));
        deleteButton.setFocusable(false);
        deleteButton.setForeground(Color.white);
        deleteButton.setBackground(new Color(144, 137, 240));
        deleteButton.setOpaque(true);
        deleteButton.setFont(new Font("Poppins", Font.BOLD, 16));

        frame.setTitle("Update & Delete Member");
        frame.add(updateDeleteMember);
        frame.add(memberID);
        frame.add(idNumberField);
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
        frame.add(updateButton);
        frame.add(clearButton);
        frame.add(backButton);
        frame.add(searchButton);
        frame.add(deleteButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 800);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(new Color(52, 44, 60));
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
            idNumberField.setText("");
        }

        if (e.getSource() == searchButton) {
            int checkid = 0;
            String id = idNumberField.getText();
            try {
                Connection con = ConnectionProvider.getCon();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select *from member where id='" + id + "'");
                while (rs.next()) {
                    checkid = 1;
                    memberNameField.setText(rs.getString(2));
                    mobileNumberField.setText(rs.getString(3));
                    emailField.setText(rs.getString(4));
                    genderBox.setSelectedItem(rs.getString(5));
                    timeBox.setSelectedItem(rs.getString(6));
                    cardField.setText(rs.getString(7));
                    ageField.setText(rs.getString(8));
                    amountField.setText(rs.getString(9));
                }
                if (checkid == 0) {
                    JOptionPane.showMessageDialog(null, "Member ID does not Exist");
                }
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, e1);
            }
        }

        if (e.getSource() == updateButton) {
            String id = idNumberField.getText();
            String name = memberNameField.getText();
            String mobile = mobileNumberField.getText();
            String email = emailField.getText();
            String gender = (String) genderBox.getSelectedItem();
            String time = (String) timeBox.getSelectedItem();
            String personalnumber = cardField.getText();
            String age = ageField.getText();
            String amount = amountField.getText();
            try {
                Connection con = ConnectionProvider.getCon();
                PreparedStatement ps = con.prepareStatement("update member set name=?,mobile=?,email=?,gender=?,time=?,personalnumber=?,age=?,amount=? where id=?");
                ps.setString(1, name);
                ps.setString(2, mobile);
                ps.setString(3, email);
                ps.setString(4, gender);
                ps.setString(5, time);
                ps.setString(6, personalnumber);
                ps.setString(7, age);
                ps.setString(8, amount);
                ps.setString(9, id);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Successfully Updated");
                frame.dispose();
                new UpdateDeleteMember();
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
                    st.executeUpdate("delete  from member where id='" + id + "'");
                    JOptionPane.showMessageDialog(null, "Successfully Deleted");
                    frame.dispose();
                    new UpdateDeleteMember();
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, e1);
                }
            }
        }
    }

}