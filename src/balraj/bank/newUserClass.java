/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package balraj.bank;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.*;
/**
 *
 * This class is passing Main Frame and account (arraylist) to newUser Form 
 */
public class newUserClass implements ActionListener  {
    private ArrayList<accounts> account;
public JFrame oldFrame;
//parameterized constructor
public newUserClass(JFrame frame, ArrayList<accounts> account)
{
    oldFrame=frame;
    this.account = account;
}
    
    @Override
    public void actionPerformed(ActionEvent ae) {
       this.oldFrame.setVisible(false); //this is false so that, new frame will be visible. It will give a better look to our user interface design.
        JFrame newWindow = new newUserForm(oldFrame, account);
        //newWindow.setVisible(true);
     
    
    }

     
     
}

