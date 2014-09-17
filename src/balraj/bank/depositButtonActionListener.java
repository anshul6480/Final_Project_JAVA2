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
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author anshul This class is all about Deposit Transaction. Whenever user
 * enters an amount it will be deposited in his/her account.
 *
 */
class depositButtonActionListener implements ActionListener {
//Three Fields, which are defining deposit, accountList and deposit field
    ArrayList<accounts> accountList;
    accounts a;
    JTextField deposit;

    public depositButtonActionListener(accounts a, JTextField deposit, ArrayList<accounts> accountList) {
// Parametezied constructor, if we see broadly to understand this, we are manipulating 3 things, deposit field, which gives us an no. which is being added to particular accoung in ArrayList.
        this.a = a;//Thats why we need this three field.
        this.deposit = deposit;
        this.accountList = accountList;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
//action listener for deposit buttong.
        try {

            double amt = Double.parseDouble(deposit.getText());
            double currentBal = a.getcurrentBalance();
            System.out.println("Current Balance: " + currentBal);
  
                    String name = a.getFirst();
        String LastName= a.getLast();
        
        JOptionPane.showMessageDialog(null, "Hello  " +name+" " +LastName+ "Current Balance:- " + currentBal, "Current Balance:- " + currentBal, JOptionPane.INFORMATION_MESSAGE);

            JOptionPane.showMessageDialog(null, "Transaction  Successfully Completed...!!", "Transaction  Successfully Completed...!!", JOptionPane.INFORMATION_MESSAGE);

            currentBal = amt + currentBal;
            System.out.println("New Current Balance: " + currentBal);
            JOptionPane.showMessageDialog(null, " New Current Balance:- " + currentBal, "Current Balance" , JOptionPane.INFORMATION_MESSAGE);

            a.setcurrentBalance(currentBal);
//after deposit , new balance will be added MainAccount.data file.
            try {
                FileOutputStream fos = new FileOutputStream("MainAccount.data");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(accountList);
                oos.close();
                System.out.println("The file was saved successfully");
            } catch (IOException ex) {
                System.out.println("Transaction Failed  : " + ex.getMessage());
            }

        } catch (Exception e) {
            System.out.println("Transaction Failed  : " + e.getMessage());
             
        }
    deposit.setText("");
    }

}
