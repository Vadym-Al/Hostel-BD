package GUI;

import BD.DatabaseHandler;
import Interface.FormManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {
    private final FormManager manager;
    private JPanel pane = new JPanel(new GridBagLayout());

    public Menu(final FormManager manager) {
        DatabaseHandler databaseHandler = new DatabaseHandler();
        this.manager = manager;
        this.setTitle("Main Menu");
        this.setBounds(750, 350, 350, 250);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pane);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        String[] items = {
           "Students",
           "Rooms",
           "Privileges"
        };
        JComboBox<String> jComboBox1 = new JComboBox<>(items);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.gridy = 0;
        pane.add(jComboBox1, gbc);

        ActionListener show = (ActionEvent e) -> {
            if (jComboBox1.getSelectedItem()=="Students"){
                JOptionPane.showMessageDialog(null, databaseHandler.getInfoStudents().toString(),"Output",JOptionPane.PLAIN_MESSAGE);
            }else if (jComboBox1.getSelectedItem()=="Rooms"){
                JOptionPane.showMessageDialog(null, databaseHandler.getInfoRoom().toString(),"Output",JOptionPane.PLAIN_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, databaseHandler.getInfoPriv().toString(),"Output",JOptionPane.PLAIN_MESSAGE);
            }
        };
        ActionListener SWAP = (ActionEvent e) -> {
            if (jComboBox1.getSelectedItem()=="Students"){
                manager.swapStudents();
            }else if (jComboBox1.getSelectedItem()=="Rooms"){
                manager.swapRooms();
            } else {
                manager.swapPrivileges();
            }
        };
        ActionListener remove = (ActionEvent e) -> {
            databaseHandler.ClearTable(jComboBox1.getSelectedItem().toString());
        };
        ActionListener sqlswap = (ActionEvent e) -> {
            manager.swapSQL();
        };

        JButton button1 = new JButton("Edit");
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.gridy = 1;
        button1.addActionListener(SWAP);
        pane.add(button1, gbc);

        JButton button2 = new JButton("Clear");
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.gridy = 2;
        button2.addActionListener(remove);
        pane.add(button2, gbc);

        JButton button3 = new JButton("Show");
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.gridy = 3;
        button3.addActionListener(show);
        pane.add(button3, gbc);

        JButton button4 = new JButton("SQL");
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.gridy = 4;
        button4.addActionListener(sqlswap);
        pane.add(button4, gbc);

        JLabel label1 = new JLabel("");
        gbc.gridx=0;
        gbc.gridwidth=1;
        gbc.gridy=0;
        pane.add(label1,gbc);

        JLabel label2 = new JLabel("");
        gbc.gridx=3;
        gbc.gridwidth=1;
        gbc.gridy=0;
        pane.add(label2,gbc);
    }
}
