package com.gymapp;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BMI extends JFrame implements ActionListener {
    JLabel bmiLabel = new JLabel("Calculate Your Body Mass Index");
    JLabel heightLabel = new JLabel("Your Height (centimetres)");
    JTextField heightField = new JTextField();
    JLabel weightLabel = new JLabel("Your Wight (kilograms)");
    JTextField weightField = new JTextField();
    JButton computeBMI = new JButton("Compute BMI");
    JLabel yourBMILabel = new JLabel("Your BMI");
    JTextField yourBMIField = new JTextField();
    JLabel categoriesLabel = new JLabel("BMI Categories");
    JLabel underweightLabel = new JLabel("Underweight = Below 18.5");
    JLabel normalWeightLabel = new JLabel("Normal weight = 18.5 – 24.9");
    JLabel overweightLabel = new JLabel("Overweight  = 25 – 29.9");
    JLabel obesityLabel = new JLabel("Obesity = BMI of 30 or greater");
    JFrame frame = new JFrame();
    JButton backButton = new JButton("Back");
    JButton clearButton = new JButton("Clear");

    BMI() {
        Border border = BorderFactory.createLineBorder(new Color(86,75,99), 1);

        bmiLabel.setBounds(343, 30, 870, 75);
        bmiLabel.setFont(new Font("Poppins", Font.BOLD, 50));
        bmiLabel.setForeground(Color.lightGray);

        heightLabel.setBounds(54, 159, 270, 30);
        heightLabel.setFont(new Font("Poppins", Font.BOLD, 18));
        heightLabel.setForeground(Color.white);

        weightLabel.setBounds(54, 255, 243, 30);
        weightLabel.setFont(new Font("Poppins", Font.BOLD, 18));
        weightLabel.setForeground(Color.white);

        yourBMILabel.setBounds(54, 374, 90, 30);
        yourBMILabel.setFont(new Font("Poppins", Font.BOLD, 18));
        yourBMILabel.setForeground(Color.white);

        categoriesLabel.setBounds(830, 151, 156, 30);
        categoriesLabel.setFont(new Font("Poppins", Font.BOLD, 18));
        categoriesLabel.setForeground(new Color(144, 137, 240));


        underweightLabel.setBounds(779, 240, 260, 30);
        underweightLabel.setFont(new Font("Poppins", Font.BOLD, 18));
        underweightLabel.setForeground(Color.white);

        normalWeightLabel.setBounds(769, 320, 279, 30);
        normalWeightLabel.setFont(new Font("Poppins", Font.BOLD, 18));
        normalWeightLabel.setForeground(Color.white);

        overweightLabel.setBounds(788, 404, 240, 30);
        overweightLabel.setFont(new Font("Poppins", Font.BOLD, 18));
        overweightLabel.setForeground(Color.white);

        obesityLabel.setBounds(758, 480, 300, 30);
        obesityLabel.setFont(new Font("Poppins", Font.BOLD, 18));
        obesityLabel.setForeground(Color.white);

        heightField.setBounds(399, 151, 200, 45);
        heightField.setBackground(new Color(70,60,82));
        heightField.setForeground(Color.lightGray);
        heightField.setFont(new Font("Poppins", Font.BOLD, 18));
        heightField.setBorder(border);

        weightField.setBounds(399, 247, 200, 45);
        weightField.setBackground(new Color(70,60,82));
        weightField.setForeground(Color.lightGray);
        weightField.setFont(new Font("Poppins", Font.BOLD, 18));
        weightField.setBorder(border);

        yourBMIField.setBounds(216, 364, 383, 50);
        yourBMIField.setBackground(new Color(70,60,82));
        yourBMIField.setForeground(Color.lightGray);
        yourBMIField.setFont(new Font("Poppins", Font.BOLD, 18));
        yourBMIField.setBorder(border);
        yourBMIField.setEnabled(false);

        computeBMI.setBounds(54, 460, 200, 50);
        computeBMI.setFocusable(false);
        computeBMI.addActionListener(this);
        computeBMI.setForeground(Color.white);
        computeBMI.setBackground(new Color(144, 137, 240));
        computeBMI.setOpaque(true);
        computeBMI.setFont(new Font("Poppins", Font.BOLD, 16));

        backButton.setBounds(0, 43, 150, 50);
        backButton.setFocusable(false);
        backButton.addActionListener(this);
        backButton.setForeground(Color.white);
        backButton.setBackground(new Color(144, 137, 240));
        backButton.setOpaque(true);
        backButton.setFont(new Font("Poppins", Font.BOLD, 16));

        clearButton.setBounds(400, 460, 200, 50);
        clearButton.addActionListener(this);
        clearButton.setFont(new Font("Poppins", Font.BOLD, 18));
        clearButton.setFocusable(false);
        clearButton.setForeground(Color.white);
        clearButton.setBackground(new Color(144, 137, 240));
        clearButton.setOpaque(true);
        clearButton.setFont(new Font("Poppins", Font.BOLD, 16));

        frame.setTitle(" Body Mass Index");
        frame.add(bmiLabel);
        frame.add(heightLabel);
        frame.add(heightField);
        frame.add(weightLabel);
        frame.add(weightField);
        frame.add(computeBMI);
        frame.add(yourBMILabel);
        frame.add(yourBMIField);
        frame.add(categoriesLabel);
        frame.add(underweightLabel);
        frame.add(normalWeightLabel);
        frame.add(overweightLabel);
        frame.add(obesityLabel);
        frame.add(backButton);
        frame.add(clearButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 600);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(new Color(43, 46, 74));
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            frame.dispose();
            new MainMenu();
        }

        if (e.getSource() == clearButton) {
            weightField.setText("");
            heightField.setText("");
            yourBMIField.setText("");
        }

        if (e.getSource() == computeBMI) {
            double weight = Double.parseDouble(weightField.getText());
            double height = Double.parseDouble(heightField.getText());

            double bmi = (weight / height / height) * 10000;
            yourBMIField.setText(String.valueOf(bmi));
        }
    }
}
