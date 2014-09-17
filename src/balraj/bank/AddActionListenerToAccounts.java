
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package balraj.bank;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * This class is validating the data as input by the user, when making new
 * account. If account already created , then it will show error
 */
public class AddActionListenerToAccounts implements ActionListener {

    JTextField first, last, age, mobile, sin, id, pass;
    private ArrayList<accounts> account;
    JFrame frame, frame2; // this is because, after creating new account, same old logic page will open.
//Parameterized Constructor
    public AddActionListenerToAccounts(JTextField first, JTextField last, JTextField age,
            JTextField mobile, JTextField sin, JTextField id, JTextField pass,
            ArrayList<accounts> account, JFrame frame, JFrame frame2) {
        this.first = first;
        this.last = last;
        this.age = age;
        this.mobile = mobile;
        this.sin = sin;
        this.id = id;
        this.pass = pass;
        this.account = account;
        this.frame = frame;
        this.frame2 = frame2;

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        accounts o = new accounts(first.getText(), last.getText(), age.getText(), mobile.getText(), sin.getText(), id.getText(), pass.getText());
        //for checking the existing list if any acc. created or not.
        for (accounts anyName : account) {

            if (anyName.getId().equals(id.getText())) {
                System.out.println("ERROR: ACCOUNT ALREADY EXISTS");

                JOptionPane.showMessageDialog(null,
                        "ACCOUNT ALREADY EXISTS  ",
                        "ACCOUNT ALREADY EXISTS...",
                        JOptionPane.PLAIN_MESSAGE);

                return;
            }

        }
        JOptionPane.showMessageDialog(null, "Congratulations, Account Created !", "Login", JOptionPane.INFORMATION_MESSAGE);
        account.add(o);
//writing all the details of user in MainAccount.data file.
        try {
            FileOutputStream fos = new FileOutputStream("MainAccount.data");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this.account);
            oos.close();
            System.out.println("The file was saved successfully");
        } catch (IOException ex) {
            System.out.println("There was an exception: " + ex.getMessage());
        }

        frame.setVisible(false);
        frame2.setVisible(true);

        /*
         first.setText("");
         last.setText("");
         age.setText("");
         mobile.setText("");
         sin.setText("");
         id.setText("");
         pass.setText("");
         */
    }

}
