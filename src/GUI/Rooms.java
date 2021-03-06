package GUI;

import BD.DatabaseHandler;
import Interface.FormManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Rooms extends JFrame {
    public Rooms(final FormManager manager){
        DatabaseHandler databaseHandler = new DatabaseHandler();
        JPanel pane = new JPanel(new GridBagLayout());
        this.setTitle("Rooms");
        this.setBounds(750, 350, 350, 250);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setContentPane(pane);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JTextField textField0 = new JTextField("Number");
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.gridy = 0;
        pane.add(textField0, gbc);

        JTextField textField1 = new JTextField("Value");
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.gridy = 1;
        pane.add(textField1, gbc);

        JTextField textField2 = new JTextField("Amount");
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.gridy = 2;
        pane.add(textField2, gbc);

        JTextField textField3 = new JTextField("Tools");
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.gridy = 3;
        pane.add(textField3, gbc);

        JTextField textField4 = new JTextField("Flour");
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.gridy = 4;
        pane.add(textField4, gbc);

        ActionListener input = (ActionEvent e) -> {
            databaseHandler.fillInRoom(Integer.parseInt(textField0.getText()),Integer.parseInt(textField1.getText()),Integer.parseInt(textField2.getText()),textField3.getText(),textField4.getText());
        };
        ActionListener swapRoom = (ActionEvent e) -> manager.swapRooms();

        JButton button1 = new JButton("Add Info");
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.gridy = 5;
        button1.addActionListener(input);
        pane.add(button1, gbc);

        JButton button4 = new JButton("Return");
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.gridy = 6;
        button4.addActionListener(swapRoom);
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
