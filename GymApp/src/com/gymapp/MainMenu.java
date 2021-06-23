package com.gymapp;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu implements ActionListener {

    JFrame frame = new JFrame();
    JLabel welcomeLabel = new JLabel();
    JButton newMember = new JButton("New Member");
    JButton updateDeleteMember = new JButton("Update & Delete Member");
    JButton memberList = new JButton("List of Members");
    JButton payment = new JButton("Payment");
    JButton logout = new JButton("Logout");
    JButton exit = new JButton("Exit");
    JButton bmi = new JButton("BMI");

    MainMenu() {
        Border border = BorderFactory.createLineBorder(new Color(86,75,99), 1);

        bmi.setBounds(300, 491, 400, 55);
        bmi.setFocusable(false);
        bmi.addActionListener(this);
        bmi.setFocusable(false);
        bmi.setForeground(Color.white);
        bmi.setBackground(new Color(70,60,82));
        bmi.setOpaque(true);
        bmi.setFont(new Font("Poppins", Font.BOLD, 18));
        bmi.setBorder(border);

        welcomeLabel.setBounds(190, 143, 630, 75);
        welcomeLabel.setFont(new Font("Poppins", Font.BOLD, 50));
        welcomeLabel.setText("Hi Caydee, welcome back!");
        welcomeLabel.setForeground(Color.lightGray);

        newMember.setBounds(75, 281, 400, 55);
        newMember.setFocusable(false);
        newMember.addActionListener(this);
        newMember.setFocusable(false);
        newMember.setForeground(Color.white);
        newMember.setBackground(new Color(70,60,82));
        newMember.setOpaque(true);
        newMember.setFont(new Font("Poppins", Font.BOLD, 18));
        newMember.setBorder(border);

        updateDeleteMember.setBounds(540, 281, 400, 55);
        updateDeleteMember.setFocusable(false);
        updateDeleteMember.addActionListener(this);
        updateDeleteMember.setFocusable(false);
        updateDeleteMember.setForeground(Color.white);
        updateDeleteMember.setBackground(new Color(70,60,82));
        updateDeleteMember.setOpaque(true);
        updateDeleteMember.setFont(new Font("Poppins", Font.BOLD, 18));
        updateDeleteMember.setBorder(border);

        memberList.setBounds(75, 386, 400, 55);
        memberList.setFocusable(false);
        memberList.addActionListener(this);
        memberList.setFocusable(false);
        memberList.setForeground(Color.white);
        memberList.setBackground(new Color(70,60,82));
        memberList.setOpaque(true);
        memberList.setFont(new Font("Poppins", Font.BOLD, 18));
        memberList.setBorder(border);

        payment.setBounds(540, 386, 400, 55);
        payment.setFocusable(false);
        payment.addActionListener(this);
        payment.setForeground(Color.white);
        payment.setFocusable(false);
        payment.setBackground(new Color(70,60,82));
        payment.setOpaque(true);
        payment.setFont(new Font("Poppins", Font.BOLD, 18));
        payment.setBorder(border);

        logout.setBounds(0, 43, 150, 50);
        logout.setFocusable(false);
        logout.addActionListener(this);
        logout.setFocusable(false);
        logout.setForeground(Color.white);
        logout.setBackground(new Color(144, 137, 240));
        logout.setOpaque(true);
        logout.setFont(new Font("Poppins", Font.BOLD, 16));

        exit.setBounds(850, 43, 150, 50);
        exit.setFocusable(false);
        exit.addActionListener(this);
        exit.setFocusable(false);
        exit.setForeground(Color.white);
        exit.setBackground(new Color(144, 137, 240));
        exit.setOpaque(true);
        exit.setFont(new Font("Poppins", Font.BOLD, 16));


        frame.setTitle("Main Menu");
        frame.add(bmi);
        frame.add(welcomeLabel);
        frame.add(newMember);
        frame.add(updateDeleteMember);
        frame.add(memberList);
        frame.add(payment);
        frame.add(logout);
        frame.add(exit);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 620);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(new Color(52, 44, 60));
    }


    @Override

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == logout) {
            int yesNo = JOptionPane.showConfirmDialog(null, "Do you want to Logout", "Logout", JOptionPane.YES_NO_OPTION);
            if (yesNo == 0) {
                new LoginPage();
                frame.dispose();
            }
        }

        if (e.getSource() == exit) {
            int yesNo = JOptionPane.showConfirmDialog(null, "Do you want to Exit", "Exit", JOptionPane.YES_NO_OPTION);
            if (yesNo == 0) {
                System.exit(0);
            }
        }

        if (e.getSource() == newMember) {
            new NewMember();
            frame.dispose();
        }

        if (e.getSource() == updateDeleteMember) {
            new UpdateDeleteMember();
            frame.dispose();
        }

        if (e.getSource() == memberList) {
            new MemberList();
            frame.dispose();
        }

        if (e.getSource() == payment) {
            new Payment();
            frame.dispose();
        }

        if (e.getSource() == bmi) {
            new BMI();
            frame.dispose();
        }
    }
}