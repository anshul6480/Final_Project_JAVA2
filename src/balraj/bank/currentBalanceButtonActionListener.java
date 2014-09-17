/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package balraj.bank;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author anshul
 * This class will show user Current Balance..
 */
class currentBalanceButtonActionListener implements ActionListener {

  
      accounts a;
  
    
    public currentBalanceButtonActionListener(accounts a) {

        this.a= a;
    
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
   
        String name = a.getFirst();
        String LastName= a.getLast();
        
        JOptionPane.showMessageDialog(null, "Hello  " +name+" " +LastName+ " Current Balance: " +a.getcurrentBalance(), " CURRENT BALACE ", JOptionPane.INFORMATION_MESSAGE);
    
    }
    
    
    
}
