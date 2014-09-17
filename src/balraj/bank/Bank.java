/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package balraj.bank;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alisha
 */
public class Bank {

    public static void main(String[] args) {
        ArrayList<accounts> account = new ArrayList<accounts>();
//This try catch block read ths MainAccount.data file. ..in this whole project we are reading whole file at once in this section.
        try {
            FileInputStream fis = new FileInputStream("MainAccount.data"); // name of the file is : MainAccount.data
            ObjectInputStream ois = new ObjectInputStream(fis);
            account = (ArrayList<accounts>) ois.readObject();
            ois.close();
            } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage()); // in case if compiler unable to process the try block it will process this catch block... This is exception handling.
            }
  
        
        JTabbedPane tabs = new JTabbedPane(); // tabbed pane, as we see in our google crome, same is in this GUI Project.

        System.out.println("Welcome to IndiaN Bank :"); 

        JFrame frame = new JFrame(); // frame is like a book where we add pages or in other words its like a body for GUI
        JPanel mainPanel = new JPanel(new GridBagLayout());// Panel is like a page, which is being added in frame.We are using Grid Bag Layout, just to give a simple and sober touch to our user Interface (GUI).
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.EAST;
        c.insets = new Insets(5, 5, 5, 5);

        //Following below are the fields. 
        JLabel accountNumber = new JLabel("Account No. :");
        c.gridx = 0;
        c.gridy = 0;

        mainPanel.add(accountNumber, c);
        JTextField accountNumberTextField = new JTextField(20);
        c.gridx = 1;
        c.gridy = 0;

        mainPanel.add(accountNumberTextField, c);

        JLabel password = new JLabel("Password :");
        c.gridx = 0;
        c.gridy = 1;

        mainPanel.add(password, c);
        JPasswordField passwordTextField = new JPasswordField(20);
        c.gridx = 1;
        c.gridy = 1;
        c.anchor = GridBagConstraints.WEST;

        mainPanel.add(passwordTextField, c);

        //when the user click on this submit button , actionListener is being called and pass userId and pass , accround and frame to submib button action lister. for further manipulations.
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new submitButtonActionListener(accountNumberTextField, passwordTextField, account, frame));
        c.gridx = 1;
        c.gridy = 2;
        c.anchor = GridBagConstraints.WEST;

        mainPanel.add(submitButton, c);
//If user is not having any account, he will cilcking of this newUserButton, to create his/her account and it will be redirected to a new a frame.
        JButton newUserButton = new JButton("New User, Click Here");
        newUserButton.addActionListener(new newUserClass(frame, account));
        c.gridx = 1;
        c.gridy = 2;
        c.anchor = GridBagConstraints.EAST;

        mainPanel.add(newUserButton, c);

        // This enables to user to see table in panned tabs...
        JTable showAccounts = new JTable(new showUserAccounts(account));
        showAccounts.setFillsViewportHeight(true);    // table contents won't be visible without this
        JScrollPane orderScrollPane = new JScrollPane(showAccounts);

        // we add two tabs to our window
        tabs.add("Sign Up Page", mainPanel); // we are giving names (Title names) to our current layout window.
        tabs.add("View User Acconts", orderScrollPane);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(tabs); 
        frame.pack();
        frame.setVisible(true); // we have to make this visible true to, So that user can see the frame itself.

    }

}
