/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projict_Class;

import java.util.Date;
import mysql_data_link.ZeftawyTools.IControl;
import mysql_data_link.ZeftawyTools.OtherMethods;
import org.jdesktop.swingx.JXDatePicker;

/**
 *
 * @author aman
 */
public class ACalender  extends JXDatePicker implements  IControl{

    public ACalender() {
        setFormats("yyyy-MM-dd");
    }
 

   
    @Override
    public void setValue(String Val) {
        OtherMethods o = new OtherMethods();
        try {  setDate(
           o.GetStringVal(Val)) ;
        }catch(Exception ex ){
            
            
        }}
 

    @Override
    public String getValue() {
 String s = new Date()+"" ;
 OtherMethods o = new OtherMethods();
 try { s =   o.ChangeFrmat( getDate());}catch(Exception e){}
return s ;
}
    
}
