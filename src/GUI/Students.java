package GUI;

import BD.DatabaseHandler;
import Interface.FormManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Students extends JFrame {
    public Students(final FormManager manager){
        DatabaseHandler databaseHandler = new DatabaseHandler();
        JPanel pane = new JPanel(new GridBagLayout());
        this.setTitle("Students");
        this.setBounds(750, 350, 500, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setContentPane(pane);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JTextField textField1 = new JTextField("SNP");
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.gridy = 0;
        pane.add(textField1, gbc);

        JTextField textField2 = new JTextField("Birth Year");
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.gridy = 1;
        pane.add(textField2, gbc);

        JTextField textField3 = new JTextField("Gender");
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.gridy = 2;
        pane.add(textField3, gbc);

        JTextField textField4 = new JTextField("Address");
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.gridy = 3;
        pane.add(textField4, gbc);

        JTextField textField5 = new JTextField("Group");
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.gridy = 4;
        pane.add(textField5, gbc);

        JTextField textField6 = new JTextField("privilege cod");
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.gridy = 5;
        pane.add(textField6, gbc);

        JTextField textField7 = new JTextField("Passport");
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.gridy = 6;
        pane.add(textField7, gbc);

        JTextField textField8 = new JTextField("room");
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.gridy = 7;
        pane.add(textField8, gbc);

        JTextField textField9 = new JTextField("Colonize Date");
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.gridy = 8;
        pane.add(textField9, gbc);

        ActionListener input = (ActionEvent e) -> {
            databaseHandler.fillInStudents(textField1.getText(),textField2.getText(),textField3.getText(),textField4.getText(),textField5.getText(),Integer.parseInt(textField6.getText()),textField7.getText(),Integer.parseInt(textField8.getText()),textField9.getText());
        };
        ActionListener show = (ActionEvent e) -> {
            JOptionPane.showMessageDialog(null, databaseHandler.getInfoStudents().toString(),"Output",JOptionPane.PLAIN_MESSAGE);
        };
        ActionListener swapStud = (ActionEvent e) -> manager.swapStudents();

        JButton button1 = new JButton("Add Info");
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.gridy = 9;
        button1.addActionListener(input);
        pane.add(button1, gbc);

        JButton button2 = new JButton("Show info");
        gbc.gridx = 5;
        gbc.gridwidth = 1;
        gbc.gridy = 0;
        button2.addActionListener(show);
        pane.add(button2, gbc);

        JButton button3 = new JButton("Clear table");
        gbc.gridx = 5;
        gbc.gridwidth = 1;
        gbc.gridy = 1;
        pane.add(button3, gbc);

        JButton button4 = new JButton("Return");
        gbc.gridx = 5;
        gbc.gridwidth = 1;
        gbc.gridy = 2;
        button4.addActionListener(swapStud);
        pane.add(button4, gbc);

        JLabel html1 = new JLabel("");
        gbc.gridx=4;
        gbc.gridwidth=1;
        gbc.gridy=0;
        pane.add(html1,gbc);

        JLabel html2 = new JLabel("");
        gbc.gridx=0;
        gbc.gridwidth=1;
        gbc.gridy=0;
        pane.add(html2,gbc);

        JLabel html3 = new JLabel("");
        gbc.gridx=7;
        gbc.gridwidth=1;
        gbc.gridy=0;
        pane.add(html3,gbc);
    }
}
