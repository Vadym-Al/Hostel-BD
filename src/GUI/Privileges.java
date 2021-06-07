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
        this.setBounds(750, 350, 500, 200);
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
        ActionListener show = (ActionEvent e) -> {
            JOptionPane.showMessageDialog(null, databaseHandler.getInfoPriv().toString(),"Output",JOptionPane.PLAIN_MESSAGE);
        };
        ActionListener swapPriv = (ActionEvent e) -> manager.swapPrivileges();

        JButton button1 = new JButton("Add Info");
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.gridy = 4;
        button1.addActionListener(input);
        pane.add(button1, gbc);

        JButton button2 = new JButton("Show info");
        gbc.gridx = 6;
        gbc.gridwidth = 1;
        gbc.gridy = 0;
        button2.addActionListener(show);
        pane.add(button2, gbc);

        JButton button3 = new JButton("Clear table");
        gbc.gridx = 6;
        gbc.gridwidth = 1;
        gbc.gridy = 1;
        pane.add(button3, gbc);

        JButton button4 = new JButton("Return");
        gbc.gridx = 6;
        gbc.gridwidth = 1;
        gbc.gridy = 2;
        button4.addActionListener(swapPriv);
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
