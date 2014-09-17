/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package balraj.bank;

import java.io.Serializable;
import javax.swing.JTextField;

/**
 *
 * This class is basically describing all the datafields used in this project.
 */

public class accounts implements Serializable{
   String first, last,age, mobile, sin,   id, pass;

  double currentBalance =1000; //initial value of new account is $1000. WEHNEVER anyone creates a new account , its initial value would be $1000... !
   double deposit, withdraw;  
    
   //parameterized constructor
    public accounts(String first, String last, String age, String mobile, String sin, String id, String pass) {
        this.first = first;
        this.last = last;
        this.age = age;
        this.mobile = mobile;
        this.sin = sin;
        this.id = id;
        this.pass = pass;
    }
        
    ///below are all the getters and setters of the above datafield.
    public double getcurrentBalance() {
        return currentBalance;
    }

      
    public void setcurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }
      
     
    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getWithdraw() {
        return withdraw;
    }

    public void setWithdraw(double withdraw) {
        this.withdraw = withdraw;
    }
 
    
    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSin() {
        return sin;
    }

    public void setSin(String sin) {
        this.sin = sin;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

     
     
}
