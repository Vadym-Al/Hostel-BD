package GUI;

import BD.DatabaseHandler;
import Interface.FormManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Privileges extends JFrame {
    public Privileges(final FormManager manager){
        DatabaseHandler databaseHandler = new DatabaseHandler();
        JPanel pane = new JPanel(new GridBagLayout());
        this.setTitle("Privileges");
        this.setBounds(750, 350, 350, 250);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setContentPane(pane);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JTextField textField1 = new JTextField("Type");
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.gridy = 0;
        pane.add(textField1, gbc);

        JTextField textField2 = new JTextField("Discount");
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.gridy = 1;
        pane.add(textField2, gbc);

        ActionListener input = (ActionEvent e) -> {
            databaseHandler.fillInPrivilege(textField1.getText(), Integer.parseInt(textField2.getText()));
        };
        ActionListener swapPriv = (ActionEvent e) -> manager.swapPrivileges();

        JButton button1 = new JButton("Add Info");
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.gridy = 2;
        button1.addActionListener(input);
        pane.add(button1, gbc);

        JButton button4 = new JButton("Return");
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.gridy = 3;
        button4.addActionListener(swapPriv);
        pane.add(button4, gbc);

        JLabel html1 = new JLabel("");
        gbc.gridx=0;
        gbc.gridwidth=1;
        gbc.gridy=0;
        pane.add(html1,gbc);

        JLabel html2 = new JLabel("");
        gbc.gridx=3;
        gbc.gridwidth=1;
        gbc.gridy=0;
        pane.add(html2,gbc);
    }
}
