package balraj.bank;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * This class is about when the user/client enter his/her account no. and
 * password, their account INformation will be Opened. And if they enters an
 * invalid information, error message will be displayed.
 */
public class submitButtonActionListener implements ActionListener {

    ArrayList<accounts> account;
    JTextField id, pass;
    JFrame frame;
//For doing this, we need id, pass, frame [to enable new frame, where user acc. info is stored] and arrayList {which contains user information}.

    public submitButtonActionListener(JTextField id, JTextField pass, ArrayList<accounts> account, JFrame frame) {
        this.account = account;
        this.id = id;
        this.pass = pass;
        this.frame = frame;
    }//Parametezied constructor.

    @Override
    public void actionPerformed(ActionEvent ae) {
        //Actions listener for validating correct user information. 
        try {
            FileInputStream fis = new FileInputStream("MainAccount.data");
            ObjectInputStream ois = new ObjectInputStream(fis);
            account = (ArrayList<accounts>) ois.readObject();
            boolean foundAccount = false;

            for (accounts a : account) {

                if (a.getId().equals(id.getText()) && a.getPass().equals(pass.getText())) {
                    System.out.println("Login Successfully..!!1");
                    JOptionPane.showMessageDialog(null, "Successfuly Login", "Welcome ", JOptionPane.INFORMATION_MESSAGE);
                    foundAccount = true;

                    JFrame user = new userAccount(a, frame, account);

                }
            }

            if (foundAccount == false) {
                System.out.println("Invalid User ID or Password");
                JOptionPane.showMessageDialog(null, "Login Failed", "Invalid User Id or Password ", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            ois.close();

        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }

    }

}
