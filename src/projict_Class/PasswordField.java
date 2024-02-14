/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projict_Class;

import javax.swing.JPasswordField;
import mysql_data_link.ZeftawyTools.IControl;

/**
 *
 * @author aman
 */
public class PasswordField extends  JPasswordField implements  IControl{

    @Override
    public void setValue(String Val) {
        setText(Val);
    }

    @Override
    public String getValue() {
return getText()+"";
    }
    
}
