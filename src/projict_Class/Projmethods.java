/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projict_Class;

import mysql_data_link.ZeftawyTools.Z_connection;

/**
 *
 * @author aman
 */
public class Projmethods{
    public  Z_connection ConnectToPasDataBase(){
      Z_connection z_connection=new Z_connection("aman_pasiontdatabase","root","");
 
    return z_connection;
    }
    
}
