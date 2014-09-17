/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package balraj.bank;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author anshul
 * This class define, when user enter their account number and password, It will open their account Information. 
 * This class also define, basic 2 labels, textfield and 2 buttons, i.e. WITHDRAW AND DEPOSIT
 *And information which is being added in withdraw field will be passed to withdrawButtonActionListener.
 *And information which is being added in deposit field will be passed to depositButtonActionListener.
 * 
 */
class userAccount extends javax.swing.JFrame {

    ArrayList<accounts> account = new ArrayList<accounts>();
// for doing this , we need THEIR account id and pass , frame and account(arrayList)
    public userAccount(accounts a, JFrame frame2, ArrayList<accounts> account) {
//Parametezied constructor.
 
         JFrame frame = new JFrame();
//GridBagLayout will gives a better user interface .
         JPanel userPanel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.EAST;
        c.insets = new Insets(5, 5, 5, 5);

        System.out.println("welcome to home menu");
//fields and labels and buttons are defined
        JLabel withdraw = new JLabel("Withdrawl :");
        c.gridx = 0;
        c.gridy = 0;

        userPanel.add(withdraw, c);
        JTextField withdrawTextField = new JTextField(20);
        c.gridx = 1;
        c.gridy = 0;

        userPanel.add(withdrawTextField, c);
//information which is being added in withdraw field will be passed to withdrawButtonActionListener
        JButton withdrawButton = new JButton("Withdraw...!!");
        withdrawButton.addActionListener(new withdrawButtonActionListener(a, withdrawTextField, account));
        c.gridx = 1;
        c.gridy = 2;
        c.anchor = GridBagConstraints.EAST;

        userPanel.add(withdrawButton, c);

        JLabel deposit = new JLabel("Deposit");
        c.gridx = 0;
        c.gridy = 1;

        userPanel.add(deposit, c);
        JTextField depositTextField = new JTextField(20);
        c.gridx = 1;
        c.gridy = 1;
        userPanel.add(depositTextField, c);

//information which is being added in deposit field will be passed to depositButtonActionListener
        JButton depositButton = new JButton("Deposit !!!");
        depositButton.addActionListener(new depositButtonActionListener(a, depositTextField, account));
        c.gridx = 1;
        c.gridy = 2;
        c.anchor = GridBagConstraints.WEST;
        userPanel.add(depositButton, c);

 //information which is being added in deposit field will be passed to depositButtonActionListener
        JButton currentBalanceButton = new JButton("CURRENT BALANCE !!!");
        currentBalanceButton.addActionListener(new currentBalanceButtonActionListener(a));
        c.gridx = 2;
        c.gridy = 4;
        c.anchor = GridBagConstraints.WEST;
        userPanel.add(currentBalanceButton, c);

        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(userPanel);
        frame.pack();
        frame2.setVisible(false); //disable this frame and
        frame.setVisible(true);// open this frame. 

    }

}
