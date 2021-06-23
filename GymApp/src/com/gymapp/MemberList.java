package com.gymapp;

import project.ConnectionProvider;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class MemberList extends JFrame implements ActionListener {
    DefaultTableModel mTableModel;
    JButton backButton = new JButton("Back");
    JFrame frame = new JFrame();
    JTable table;

    MemberList() {

        Object[][] rowData = {};
        String[] columnNames = {"Member ID", "Name", "Mobile Number", "Email", "Gender", "Gym Time", "Personal Number", "Age", "Amount"};

        mTableModel = new DefaultTableModel(rowData, columnNames);
        table = new JTable(mTableModel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.setTitle("Member List");
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setSize(1440, 600);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.add(backButton, BorderLayout.WEST);
        table.setBackground(new Color(52, 44, 60));
        table.setOpaque(false);
        table.setFillsViewportHeight(true);
        table.getTableHeader().setBackground(new Color(149, 130, 168));
        table.getTableHeader().setFont(new Font("Poppins", Font.BOLD, 14));
        table.setFont(new Font("Poppins", Font.BOLD, 12));
        table.setForeground(Color.white);
        table.setEnabled(false);

        Border border = BorderFactory.createLineBorder(new Color(86,75,99), 1);
        table.getTableHeader().setBorder(border);

        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(mTableModel);
        table.setRowSorter(sorter);

        backButton.setFocusable(false);
        backButton.addActionListener(this);
        backButton.setFocusable(false);
        backButton.setForeground(Color.white);
        backButton.setBackground(new Color(144, 137, 240));
        backButton.setOpaque(true);
        backButton.setFont(new Font("Poppins", Font.BOLD, 14));

        Connection con;
        try {
            con = ConnectionProvider.getCon();
            assert con != null;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM member");

            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                String mobile = rs.getString("mobile");
                String email = rs.getString("email");
                String gender = rs.getString("gender");
                String time = rs.getString("time");
                String personalnumber = rs.getString("personalnumber");
                String age = rs.getString("age");
                String amount = rs.getString("amount");
                mTableModel.addRow(new Object[]{id, name, mobile, email, gender, time, personalnumber, age, amount});

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
    }
}
