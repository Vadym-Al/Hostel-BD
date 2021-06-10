package GUI;

import BD.DatabaseHandler;
import Interface.FormManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SQL extends JFrame {
    private final FormManager manager;
    private JPanel pane = new JPanel(new GridBagLayout());

    public SQL(final FormManager manager) {
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

        JTextField textField1 = new JTextField("SQL");
        gbc.gridx = 1;
        gbc.gridwidth = 5;
        gbc.gridy = 0;
        pane.add(textField1, gbc);

        ActionListener enter = (ActionEvent e) -> databaseHandler.SQL(textField1.getText());
        ActionListener swap = (ActionEvent e) -> manager.swapSQL();

        JButton button1 = new JButton("Enter");
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.gridy = 1;
        button1.addActionListener(enter);
        pane.add(button1, gbc);

        JButton button2 = new JButton("Return");
        gbc.gridx = 3;
        gbc.gridwidth = 2;
        gbc.gridy = 1;
        button2.addActionListener(swap);
        pane.add(button2, gbc);

        JLabel label1 = new JLabel("");
        gbc.gridx=0;
        gbc.gridwidth=1;
        gbc.gridy=0;
        pane.add(label1,gbc);

        JLabel label2 = new JLabel("");
        gbc.gridx=6;
        gbc.gridwidth=1;
        gbc.gridy=0;
        pane.add(label2,gbc);
    }
}
