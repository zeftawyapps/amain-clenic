/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projict_Class;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.lang.annotation.Annotation;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import mysql_data_link.ZeftawyTools.IControl;


/**
 *
 * @author aman
 */

     public class TxTf extends JTextField implements FocusListener , IControl 
     {
   
         Color enterBackground =Color.decode("#f8fcc7"); 
         Color outBackground =Color.WHITE;

    public Color getEnterBackground() {
        return enterBackground;
    }

  
boolean isNumber ;

  

    public boolean isIsNumber() {
        return isNumber;
    }

    public void setIsNumber(boolean isNumber) {
        this.isNumber = isNumber;
    }
  
    public void setEnterBackground(Color enterBackground) {
        this.enterBackground = enterBackground;
    }

    public Color getOutBackground() {
        return outBackground;
    }

    public void setOutBackground(Color outBackground) {
        this.outBackground = outBackground;
    }
         
         public TxTf (){
        addFocusListener(this);
             setBackground(outBackground);
             setText("");
    }

    @Override
    public void focusGained(FocusEvent event) {
        setBackground(enterBackground);
    }

    @Override
    public void focusLost(FocusEvent event) {
        setBackground(outBackground);
    }

    @Override
    public void setValue(String Val) {
        setText(Val);
    
    }

    @Override
    public String getValue() {
        if (isNumber){
        if ( isnumiric(getText())){
          
        return getText();
        }else{
            setText(0+"");
        return getText();
        }
        
        }
        
          return getText();
    }

     boolean isnumiric(String val){
    
   NumberFormat formatter = NumberFormat.getInstance();
  ParsePosition pos = new ParsePosition(0);
  formatter.parse(val, pos);
  return val.length() == pos.getIndex();  
    }
  

     }