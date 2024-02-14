/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql_data_link.ZeftawyTools;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author New
 */
public class Z_connection {
    Connection connection ;
    Statement statment  ;
    
    
    String  DATABASEName  ;
    String unicode= "?useUnicode=yes&characterEncoding=UTF-8";

    String Hostname ="localhost";
    String username ; String pasward ;

    public String getDATABASEName() {
        return DATABASEName;
    }

    public String getHostname() {
        return Hostname;
    }

    public void setDATABASEName(String DATABASEName) {
        this.DATABASEName = DATABASEName;
    }

    public void setHostname(String Hostname) {
        this.Hostname = Hostname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPasward(String pasward) {
        this.pasward = pasward;
    }
    

    public Z_connection() {
    }
    
     public Z_connection(String hst ,String  dbname, String user , String pass ) {
         DATABASEName = dbname;
         Hostname = hst;
         username  = user ;
         pasward = pass ;
    }
        public Z_connection(String  dbname, String user , String pass ) {
         DATABASEName = dbname;
         Hostname = "localhost";
         username  = user ;
         pasward = pass ;
    }
  
    public  Connection Connecte () throws SQLException, IOException{
         try{
            Class.forName("com.mysql.jdbc.Driver"); 
       System.out.println("welcom "); 
     //  Runmysql();
            // provider 
connection =  DriverManager.getConnection(  
"jdbc:mysql://"+Hostname+"/"+DATABASEName+unicode,username,pasward); 
// database name user nam
//here sonoo is database name, root is username and password  
System.out.println("Conncted");
return  connection;
}catch(Exception e){ System.out.println("error Connection" + e  );
close();
Runmysql();
return  null ; } 

    }
    
     public  Statement ConnectionStatement () throws SQLException, IOException{
         try{
            Class.forName("com.mysql.jdbc.Driver"); 
       System.out.println("welcom ");  
       Runmysql();
            // provider 
connection =  DriverManager.getConnection(  
"jdbc:mysql://"+Hostname+"/"+DATABASEName+unicode,username,pasward); 
// database name user nam
//here sonoo is database name, root is username and password  
System.out.println("Conncted");
statment =   connection.createStatement();
System.out.println("statment created");
         return statment ;
         }catch(Exception e){ System.out.println("error Connection "
                 + "c " + e  );
close();
Runmysql();
         return  null ; } 
         
         

    }
     
     void Runmysql() throws IOException{
//Process process = Runtime.getRuntime().exec("C:/xampp/mysql/bin/mysqld.exe");
   
     }
   
public  void close() throws SQLException{
    connection.close();
}
}
