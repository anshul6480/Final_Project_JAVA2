/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package balraj.bank;

import java.util.ArrayList;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author anshul This class show all the user Entered details in TABLE format.
 */
class showUserAccounts extends AbstractTableModel {

    ArrayList<accounts> account;

    //Parameterized constructor.. becase account is having all the field, so we need account(ArrayList) to access all the fields.
    showUserAccounts(ArrayList<accounts> account) {

        this.account = account;
    }

    @Override
    public int getColumnCount() {
        return 7;
    } // because there are 7 fields that is why we need 7 column

    @Override
    public int getRowCount() {
        return account.size();
    }

    @Override //format of the table will be like this, first column will be UserName , second will be password, third will be FirstName and so on.
    public String getColumnName(int column) {
        switch (column) {
            default:
            case 0:
                return "User Name";
            case 1:
                return "Password";
            case 2:
                return "First Name ";

            case 3:
                return "Last Name";
            case 4:
                return "SIN NO. ";
            case 5:
                return "Contact No.";
            case 6:
                return "AGE ";

        }
    }

    @Override // these are the value in the table, same first value will be AccountNo. second will be Account Password, and so on.
    public Object getValueAt(int row, int column) {
        accounts o = account.get(row);
        switch (column) {
            default:
            case 0:
                return o.getId();
            case 1:
                return "***";
            case 2:
                return o.getFirst();

            case 3:
                return o.getLast();
            case 4:
                return o.getSin();
            case 5:
                return o.getMobile();
            case 6:
                return o.getAge();

        }
    }

}
