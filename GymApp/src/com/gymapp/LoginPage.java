package com.gymapp;


import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginPage implements ActionListener {

    JFrame frame = new JFrame();
    JLabel loginLabel = new JLabel("Log in");
    JLabel userLabel = new JLabel("Username");
    JTextField usernameField = new JTextField();
    JLabel passLabel = new JLabel("Password");
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("Log in");
    JButton resetButton = new JButton("Reset");
    JCheckBox showPass = new JCheckBox("Show password");
    JLabel messageLabel = new JLabel();


    LoginPage() {
        loginLabel.setBounds(190, 50, 119, 60);
        loginLabel.setFont(new Font("Poppins", Font.BOLD, 40));
        loginLabel.setForeground(Color.white);

        userLabel.setBounds(100, 189, 63, 18);
        userLabel.setForeground(Color.white);
        userLabel.setFont(new Font("Poppins", Font.BOLD, 12));

        passLabel.setBounds(100,269,59,18);
        passLabel.setForeground(Color.white);
        passLabel.setFont(new Font("Poppins", Font.BOLD, 12));

        messageLabel.setBounds(199, 509, 150, 20);
        messageLabel.setFont(new Font(null, Font.BOLD, 12));
        messageLabel.setForeground(new Color(216,90,81));

        Border border = BorderFactory.createLineBorder(new Color(86,75,99), 1);

        usernameField.setBounds(100, 207, 300, 45);
        usernameField.setBackground(new Color(70,60,82));
        usernameField.setForeground(Color.lightGray);
        usernameField.setBorder(border);
        usernameField.setFont(new Font("Poppins", Font.BOLD, 14));

        passwordField.setBounds(100, 287, 300, 45);
        passwordField.setBackground(new Color(70,60,82));
        passwordField.setForeground(Color.lightGray);
        passwordField.setBorder(border);
        passwordField.setFont(new Font("Poppins", Font.BOLD, 14));

        loginButton.setBounds(100, 360, 120, 45);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);
        loginButton.setForeground(Color.white);
        loginButton.setBackground(new Color(144, 137, 240));
        loginButton.setOpaque(true);
        loginButton.setFont(new Font("Poppins", Font.BOLD, 14));

        resetButton.setBounds(280, 360, 120, 45);
        resetButton.addActionListener(this);
        resetButton.setFocusable(false);
        resetButton.setForeground(Color.white);
        resetButton.setBackground(new Color(144, 137, 240));
        resetButton.setOpaque(true);
        resetButton.setFont(new Font("Poppins", Font.BOLD, 14));

        showPass.setBounds(175, 439, 150, 30);
        showPass.setFocusable(false);
        showPass.addActionListener(this);
        showPass.setForeground(new Color(105,90,121));
        showPass.setFont(new Font("Poppins", Font.BOLD, 14));
        showPass.setBackground(new Color(52, 44, 60));
        showPass.setOpaque(true);


        frame.setTitle("Login");
        frame.getContentPane().setBackground(new Color(52, 44, 60));
        frame.add(userLabel);
        frame.add(passLabel);
        frame.add(messageLabel);
        frame.add(usernameField);
        frame.add(passwordField);
        frame.add(loginButton);
        frame.add(resetButton);
        frame.add(loginLabel);
        frame.add(showPass);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Show Password
        if (showPass.isSelected()) {
            passwordField.setEchoChar((char) 0);
        } else {
            passwordField.setEchoChar('•');
        }

        // Reset Button
        if (e.getSource() == resetButton) {
            usernameField.setText("");
            passwordField.setText("");
        }

        // Login Button
        if (e.getSource() == loginButton) {

            String username = usernameField.getText();
            String password = String.valueOf(passwordField.getPassword());

            if (username.equals("caydee") && password.equals("123123")) {
                frame.dispose();
                new MainMenu();
            } else if (!username.equals("caydee")) {
                messageLabel.setText("Username not found");
                messageLabel.setBounds(185, 512, 150, 20);
            } else {
                messageLabel.setText("Wrong password");
            }
        }
    }
}