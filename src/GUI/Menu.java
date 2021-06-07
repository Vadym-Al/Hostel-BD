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
        this.setBounds(750, 350, 400, 100);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pane);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.weighty = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        ActionListener swapPriv = (ActionEvent e) -> manager.swapPrivileges();
        ActionListener swapRoom = (ActionEvent e) -> manager.swapRooms();
        ActionListener swapStud = (ActionEvent e) -> manager.swapStudents();

        JButton button1 = new JButton("Student");
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        gbc.gridy = 0;
        button1.addActionListener(swapStud);
        pane.add(button1, gbc);

        JButton button2 = new JButton("Room");
        gbc.gridx = 2;
        gbc.gridwidth = 1;
        gbc.gridy = 0;
        button2.addActionListener(swapRoom);
        pane.add(button2, gbc);

        JButton button3 = new JButton("Benefits");
        gbc.gridx = 4;
        gbc.gridwidth = 1;
        gbc.gridy = 0;
        button3.addActionListener(swapPriv);
        pane.add(button3, gbc);

        JLabel label1 = new JLabel("");
        gbc.gridx=1;
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
