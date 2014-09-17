/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package balraj.bank;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author anshul
 * This class is about creating new form
 * Here all the JTextField and buttons are being created.
 * Data entered in all these fields will be pass to our AddActionListenerToAccount. 
 */
public class newUserForm extends javax.swing.JFrame {

    public newUserForm(JFrame frame2, ArrayList<accounts> account) {
//We are using GridBagLayout, to give a better look to our interface. 
        JFrame frame = new JFrame();
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.EAST;
        c.insets = new Insets(5, 5, 5, 5);
//Right now its a basic practice project, in our actual application, we will now show all these details to clients, These will be confined to ADMIN only.
        JTabbedPane tabs = new JTabbedPane(); // This is used to show user a new previous created account, 

        JLabel FirstName = new JLabel("First Name :");
        c.gridx = 0;
        c.gridy = 0;
        mainPanel.add(FirstName, c);
        JTextField FirstNameTextField = new JTextField(20);
        c.gridx = 1;
        c.gridy = 0;
        mainPanel.add(FirstNameTextField, c);

        JLabel LastName = new JLabel("Last Name :");
        c.gridx = 0;
        c.gridy = 1;
        mainPanel.add(LastName, c);
        JTextField LastNameTextField = new JTextField(20);
        c.gridx = 1;
        c.gridy = 1;
        mainPanel.add(LastNameTextField, c);

        JLabel age = new JLabel("AGE :");
        c.gridx = 0;
        c.gridy = 2;
        mainPanel.add(age, c);
        JTextField ageTextField = new JTextField(20);
        c.gridx = 1;
        c.gridy = 2;
        mainPanel.add(ageTextField, c);

        JLabel contactNo = new JLabel("Contact No. :");
        c.gridy = 4;
        c.gridx = 0;
        mainPanel.add(contactNo, c);
        JTextField contactNoTextField = new JTextField(20);
        c.gridy = 4;
        c.gridx = 1;
        mainPanel.add(contactNoTextField, c);

        JLabel sin = new JLabel("SIN No. :");
        c.gridy = 5;
        c.gridx = 0;
        mainPanel.add(sin, c);
        JTextField sinTextField = new JTextField(20);
        c.gridy = 5;
        c.gridx = 1;
        mainPanel.add(sinTextField, c);

        JLabel accountNo = new JLabel("accountNo :");
        c.gridy = 6;
        c.gridx = 0;
        mainPanel.add(accountNo, c);
        JTextField accountNoTextField = new JTextField(20);
        c.gridy = 6;
        c.gridx = 1;
        mainPanel.add(accountNoTextField, c);

        JLabel password = new JLabel("Password :");
        c.gridy = 7;
        c.gridx = 0;
        mainPanel.add(password, c);
        JPasswordField passwordTextField = new JPasswordField(20);
        c.gridy = 7;
        c.gridx = 1;
        mainPanel.add(passwordTextField, c);

        JButton validateButton = new JButton("VALIDATE");
        c.gridy = 10;
        c.gridx = 1;

        validateButton.addActionListener(new AddActionListenerToAccounts(FirstNameTextField,
                LastNameTextField, ageTextField, contactNoTextField, sinTextField, accountNoTextField,
                passwordTextField, account, frame, frame2));
        mainPanel.add(validateButton, c);

        // the "order scroll pane" contains the list of existing orders
        JTable showAccounts = new JTable(new showUserAccounts(account));
        showAccounts.setFillsViewportHeight(true);    // table contents won't be visible without this
        JScrollPane orderScrollPane = new JScrollPane(showAccounts);

        // we add two tabs to our window
        tabs.add("New User Information Page", mainPanel);
        tabs.add("View User Acconts", orderScrollPane);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(tabs);
        frame.pack();
        frame.setVisible(true);
    }
}
