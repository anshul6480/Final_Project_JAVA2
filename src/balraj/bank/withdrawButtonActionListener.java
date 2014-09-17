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
 *
 * @author anshul This class demonstrate withdrawButtonActionlistener,
 * information entered in withdraw button is being accessed and manipulated in
 * this class. After completing transaction, file new balance is being written
 * in MainAccount.data file.
 *
 */
class withdrawButtonActionListener implements ActionListener {

    ArrayList<accounts> accountList;
    accounts a;
    JTextField withdraw;
// for doing this , we need accountList, id and pass and withdrawed amount, thats why us use this three fields
    public withdrawButtonActionListener(accounts a, JTextField withdraw, ArrayList<accounts> accountList) {

        this.a = a;
        this.withdraw = withdraw;
        this.accountList = accountList;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
//action listener for performing this operation.
        try {

            double amt = Double.parseDouble(withdraw.getText());
            double currentBal = a.getcurrentBalance();
            double newBal;
            if (currentBal >= amt) {
                System.out.println("CURRENT BALANCE : " + currentBal);
                JOptionPane.showMessageDialog(null, "Current Balance:- " + currentBal, "Current Balance:- " + currentBal, JOptionPane.INFORMATION_MESSAGE);

                newBal = currentBal - amt;

                JOptionPane.showMessageDialog(null, "Transaction  Successfully Completed...!!", "Transaction  Successfully Completed...!!", JOptionPane.INFORMATION_MESSAGE);

                a.setcurrentBalance(newBal);
                System.out.println("new CURRENT BALANCE : " + newBal);
                        String name = a.getFirst();
        String LastName= a.getLast();
        
        JOptionPane.showMessageDialog(null, "Hello  " +name+" " +LastName+ " New Current Balance:- " + newBal, "New Current Balance:- " + newBal, JOptionPane.INFORMATION_MESSAGE);
//File is being written, after executing above code.
                try {
                    FileOutputStream fos = new FileOutputStream("MainAccount.data");
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    oos.writeObject(accountList);
                    oos.close();
                    System.out.println("The file was saved successfully");
                } catch (IOException ex) {
                    System.out.println("There was an exception: " + ex.getMessage());
                }
                
                if (amt>currentBal)
                {
       JOptionPane.showMessageDialog(null, "Hello  " +name+" " +LastName+ " Sorry, Insufficient Balance " + a.getcurrentBalance(), "TRANSACTION FAILED ", JOptionPane.INFORMATION_MESSAGE);
                }
                   
                         
            }
        } catch (Exception e) {
            System.out.println("Insufficited Balance, error : " + e.getMessage());
        }
        withdraw.setText("");
    }
}
