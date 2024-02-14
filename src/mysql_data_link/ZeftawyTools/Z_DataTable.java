/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql_data_link.ZeftawyTools;

import com.sun.javafx.binding.StringFormatter;
import java.io.IOException;
import java.sql.*;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
 
 

/**
 *
 *  
 */
public class Z_DataTable {
   
    Cell []cells; Cell[] Wherecells;  
    String TableName;
    String SQLstatment = "";
    String primaryKeyField ;
ResultSet resultSet ;
    ArrayList<String> prpsStringses = new ArrayList<String>() ;

    public void setWherecells(Cell[] Wherecells) {
        this.Wherecells = Wherecells;
        
    }


    public void setCells(Cell[] cells) {
    Wherecells = null;
        
        this.cells = cells;
    }
    
     public void setCells(Cell[] cells,Cell[] Wherecells) {
        this.Wherecells = Wherecells;
        this.cells = cells;
    }
      public void setCells(Cell[] cells,Cell primarykey) {
          
          primaryKeyField = primarykey.name ;
        this.cells = cells;
    }
      
void getValufromControl(){
int i = 0  ; 
    while (i < cells.length) {   
        
        if ( cells[i].getControl() == null || cells[i].isIsKey()) {
            i++;
  continue ; 
    
    }else {
        cells[i].setValue(cells[i].getControl().getValue());
     i++;}
}  }    
void setprpString(){
    getValufromControl();
int i = 0 ; 
int c  = cells.length;
prpsStringses.clear();
    while (i<c) {
        if (cells[i].isKey){i ++ ; continue; }
      prpsStringses.add(cells[i].Value+"");
      i++;
    }

}
    public void setTableName(String TableName) {
        this.TableName = TableName;
    }
    
    Z_connection z_connection ;
    
   
          String SQL_Selectfields(){
    String s = "";
  
      if (cells != null){
            int c = cells.length;
    int i = 0;
        while (i< c){
            if (cells[i].isKey){ primaryKeyField =  cells[i].getName();}
            if (i == 0 ){s = cells[i].name; i ++ ; continue;}else  {
                s= s+","+cells[i].name ;} i++;
        }
        
        
        SQLstatment = "Select "+ s+ " From " + TableName ;
          System.out.println(SQLstatment);
        return  SQLstatment;
        
        }else{
                SQLstatment = "Select * From " + TableName ;
    
          return  SQLstatment;
      
        }
    
}
   
          String SQL_Selectfields(String Where){
        String s = "";
      
        if (cells != null){
              int c = cells.length;
        int i = 0;
        while (i< c){
            if (cells[i].isKey){ primaryKeyField =  cells[i].getName();}
            if (i == 0 ){s = cells[i].name; i ++ ; continue;}else  {
                s= s+","+cells[i].name ;} i++;
        }
        
        
        SQLstatment = "Select "+ s+ " From " + TableName + " Where "+ Where;
      System.out.println(SQLstatment);
        return  SQLstatment;
        }else{
                SQLstatment = "Select * From " + TableName + " Where "+ Where;
            System.out.println(SQLstatment);
          return  SQLstatment;
      
        }
    }
String SQL_SelectExp(String Where){
String s = "";
      
        if (cells != null){
              int c = cells.length;
        int i = 0;
        while (i< c){
            if (cells[i].isKey){ primaryKeyField =  cells[i].getName();}
            if (i == 0 ){s = selectsum(cells[i]); i ++ ; continue;}else  {
                s= s+","+ selectsum(cells[i]) ;} i++;
        }
        
        i = 0 ;
        String grob = "";
        while (i< c){
       
            if (grob == "" ){ 
                 if (cells[i].isSelectAsSum()){i++ ; continue; }else {
                grob = cells[i].name ; i ++ ; continue;}}else  {
                
                  if (cells[i].isSelectAsSum()){i++ ; continue; }else {
             
                grob =  grob+","+ selectsum(cells[i]) ;} i++;
        }}
        String Groupby ;
         
        if (grob == "" ){
            Groupby = "";
         }else {
          Groupby = "  GROUP BY  "+ grob;}
        
        String Wheres  ;
        if (Where == "" ){
            Wheres = "";
         }else {
          Wheres = " WHERE "+ Where;}
        
        SQLstatment = "Select "+ s+ " From " + TableName + " " + Wheres +  " "+ Groupby ;
      System.out.println(SQLstatment);
        return  SQLstatment;
        }else{
                SQLstatment = "Select * From " + TableName + " Where ";
            System.out.println(SQLstatment);
          return  SQLstatment;
      
        }
 
}
String  selectsum(Cell cell){
if (cell.isSelectAsSum() ){
return cell.selectsum();
}else{return cell.name ;}

}
       String SQL_Insertfields(){
     String s = "";
    int c = cells.length;
    int i = 0;
    
    String s1 = "";
    while (i< c){
     
        if (i == 0 ){s = cells[i].name; i ++ ; continue;}else  {
            s= s+","+cells[i].name ;} i++;
    }
    i = 0;
             
          while (i< c){
                  
        if (i == 0 ){s1 = "?"; i ++ ; continue;}else  {
            s1= s1+","+ "?";} i++;
    }
        String stament = "insert into " + TableName + "("+s+") values "+"("+s1+")";
           System.out.println(stament);
        return  stament;
    }
    
    
         String SQL_updatefields(String where){
     String s = "";
    int c = cells.length;
    int i = 0;
    
    String s1 = "";
    
    
    while (i< c){
        if (i == 0 ){
           if (cells[i].isKey){ primaryKeyField =  cells[i].getName();i++; continue;}
   
          s = cells[i].name+"=?"; i ++ ; continue;}else  {
          if (cells[i].isKey){ primaryKeyField =  cells[i].getName();i++; continue;}
   
            s= s+","+cells[i].name +"=?";} i++;
    }
   String swhere ;
             if (where == "") {
               swhere = primaryKeyField +"=?"   ;
              }else {swhere = where ;}
           
         
        String stament = "UPDATE  " + TableName + " set "+s+" where "+ swhere+" ;";
  System.out.println(stament);
        return  stament;
    }
  
      
           String SQL_delete(String where){
     String s = "";
     
   int i = 0; 
    String s1 = "";
   
   String swhere ;
             if (where == "") {
               swhere = primaryKeyField +"=?"   ;
              }else {swhere = where ;}
           
         
        String stament = "delete from "+TableName+" where "+swhere+" ;";
        System.out.println(stament);
    return  stament;
    }
  
        String SQL_deleteAll(){
     String s = "";
    int c = cells.length;
    int i = 0; 
    String s1 = "";
    
     while (i< c){
        if (cells[i].isKey){ primaryKeyField =  cells[i].getName();i++; continue;}
     }
  
         
        String stament = "delete from "+TableName+";";
            System.out.println(stament );
    return  stament;
    }
     
  public    String SQL_Where()
     {
         // حتى لا يتم تكرار المعاملات و لا يتكرر الشرط
    
         int i = 0 ;int c = Wherecells.length;
     String s = "";
         while (i<c) {             
             if (i==0){
                 if (Wherecells[i].isbetween){
                 prpsStringses.add(Wherecells[i].getDates()[0]);
                  prpsStringses.add(Wherecells[i].getDates()[1]);
                  s =  Wherecells[i].getWhereString(); 
                i++;
                  continue;
                 }else{
                     
          s = Wherecells[i].getWhereString();  } 
             }else{
                 if (Wherecells[i].isbetween){
                   prpsStringses.add(cells[i].getDates()[0]);
                  prpsStringses.add(cells[i].getDates()[1]);
                  s =s+Wherecells[i].getWhereString(); 
                i++;
                  continue;
                 }else{
             s=s+Wherecells[i].getAndor()+" "+Wherecells[i].getWhereString();
                 } }
                prpsStringses.add(Wherecells[i].getValue()+"");
             i++;
         }
         System.out.println(s);
     return s;
     }
    public Z_DataTable(Z_connection z_connection) {
        this.z_connection = z_connection;
    }

    public Z_DataTable(String host , String Dbname , String user , String pas) {
  z_connection = new Z_connection(host , Dbname , user, pas);
    
    }
    public  ResultSet Load() throws SQLException{
        try {
      
        Statement st = z_connection.ConnectionStatement();
if (st == null ){st= z_connection.ConnectionStatement(); }
resultSet= st.executeQuery(SQL_Selectfields());
        System.out.println(SQLstatment);
 return resultSet;
         
        } catch (Exception e) {
      return null;
        }
    }
  
    
       public  ResultSet Load_Where() throws SQLException, ParseException{
prpsStringses.clear();
           try {
               
         
           Statement st = z_connection.ConnectionStatement();
if (st == null){st = z_connection.ConnectionStatement();}
         setpreparedstatmentQuery(SQL_Selectfields(SQL_Where()));
    
   return resultSet;
     } catch (Exception e) {
               System.out.println(" load wher error"+ e );
     return  null; 
     }
    }
  
  
         public  ResultSet Load_Expission_Where() throws SQLException, ParseException{
prpsStringses.clear();
           try {
               
         
           Statement st = z_connection.ConnectionStatement();
if (st == null){st = z_connection.ConnectionStatement();}
if (Wherecells == null ){
 resultSet= st.executeQuery(SQL_SelectExp(""));;
    
}else{
 setpreparedstatmentQuery(SQL_SelectExp(SQL_Where()));

}
       

   return resultSet;
     } catch (Exception e) {
               System.out.println(" load wher error"+ e );
     return  null; 
     }
    }
  
    public  void close() throws SQLException{
   z_connection.close();
    }
    public  void setvalue(){
        int i = 0 ;
        int c = cells.length ;
        while (i <c) {            
            if (cells[i].getControl() == null){
            i++; continue;
            }else{
            cells[i].setValue(cells[i].getControl().getValue());
            i++;
            }
            
        }
    
    
    
    }
    
    @SuppressWarnings("empty-statement")
    void setpreparedstatment(String Sql) throws SQLException, ParseException, IOException{
    
            
        
        Connection cn =z_connection.Connecte();
         
        
        PreparedStatement prs = cn.prepareStatement(Sql);

        int i = 0 ; int ic = 1 ; int c = prpsStringses.size();
        while (i<c) {
      String s =       prpsStringses.get(i) +"";
           if (isint(s)){
           prs.setDouble(ic,Integer.parseInt(s));
           
           }else if(isdouble(s)){
               prs.setDouble(ic,Double.parseDouble(s));
            
        }else if (isdate(s)){
java.util.Date m =new Date();
m= new OtherMethods().GetStringVal(s);
java.sql.Date D= new java.sql.Date(m.getTime());
prs.setDate(ic, D);


    }else{
        prs.setString(ic, s);
        }
    ic ++ ;
    i++ ;}
        prs.execute();
        close();
 
    }
   
    
    
       @SuppressWarnings("empty-statement")
    void setpreparedstatmentQuery(String Sql) throws SQLException, ParseException{
           try {
               
         
        Connection cn =z_connection.Connecte();
         
        
        PreparedStatement prs = cn.prepareStatement(Sql);

        int i = 0 ; int ic = 1 ; int c = prpsStringses.size();
        while (i<c) {
      String s =       prpsStringses.get(i) +"";
           if (isint(s)){
           prs.setDouble(ic,Integer.parseInt(s));
           
           }else if(isdouble(s)){
               prs.setDouble(ic,Double.parseDouble(s));
            
        }else if (isdate(s)){
  java.util.Date m =new Date();
m= new OtherMethods().GetStringVal(s);
java.sql.Date D= new java.sql.Date(m.getTime());
prs.setDate(ic, D);


    }else{
        prs.setString(ic, s);
        }
    ic ++ ;
    i++ ;}
       resultSet =  prs.executeQuery();

  } catch (Exception e) {
               System.out.println("setPrp Error"+e );
  }
    }
   
    public  void insert() throws SQLException, ParseException, IOException{
        setprpString();
        setpreparedstatment(SQL_Insertfields());
        System.out.println("inserted");
          }
   
       public  void update(String where ) throws SQLException, ParseException, IOException{
            
           setpreparedstatment(SQL_updatefields(where));
    }
 
       
           public  void update_id(Object key ) throws SQLException, ParseException, IOException{
            setprpString();
               System.out.println("key is "+ key);  
            prpsStringses.add(key+"");
        
            setpreparedstatment(SQL_updatefields(""));
            System.out.println("updataed");
    }
 
          public  void delete(String where ) throws SQLException, ParseException, IOException{
                           
        
            setpreparedstatment(SQL_delete(where));
  
    }
 
          
             public  void delete_id(Object key ) throws SQLException, ParseException, IOException{                
          prpsStringses.clear();
                 prpsStringses.add(key+"");
            setpreparedstatment(SQL_delete(""));
    }
 
      public  void deleteALL() throws SQLException{
          try {
              
        
          Connection cn =z_connection.Connecte();
        SQLstatment = SQL_deleteAll();
              System.out.println(SQLstatment);
        PreparedStatement prs = cn.prepareStatement(SQLstatment);
        prs.execute();
        close();
           
            } catch (Exception e) {
          } 
    }
    
    boolean isnumiric(String val){
    
   NumberFormat formatter = NumberFormat.getInstance();
  ParsePosition pos = new ParsePosition(0);
  formatter.parse(val, pos);
  return val.length() == pos.getIndex();  
    }
     boolean  isdouble(String val){
   try
{
  Double.parseDouble(val);
  return  true;
}
catch(NumberFormatException e)
{
 return  false ;
}
   }
    public   boolean  isint(String val){
   try
{
  Integer.parseInt(val);
  return  true;
}
catch(NumberFormatException e)
{
 return  false ;
}
   }
       boolean isdate(String val){
    DateFormat formatter ; 
Date date ; 

           
           formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = formatter.parse(val);
           
            return true;
            // TODO add your handling code here:
        } catch (ParseException ex) {
        return false;
        }
    }
 
  
  
  
       
     
       public  void test() throws SQLException{
       Z_DataShow dataShow = new Z_DataShow(cells) ;
resultSet = Load();
       dataShow.get_Rowslist(resultSet);
 

  int c = dataShow.getCulomntcount();  int r = dataShow.getRowcount(); int ic = 0;int ir =  0;
           while (ir < r ) {
               
          
   
    while (ic<c) {            
        
            System.out.println(dataShow.getvalue(ir, ic ));
    ic++;
        } 
           ir ++ ;
           }
        this.close();
    
    }
    
       
  public  Z_DataShow showDatta(ResultSet res) throws SQLException, ParseException{
       Z_DataShow dataShow = new Z_DataShow(cells) ;
resultSet = res;
       dataShow.get_Rowslist(resultSet);
 

 
        this.close();
    return dataShow;
    }
   
         public  Z_DataFillShow_swing showDattaFill(ResultSet res) throws SQLException, ParseException{
       Z_DataFillShow_swing dataShow = new Z_DataFillShow_swing(cells) ;
resultSet = res;
       dataShow.get_Rowslist(res);
 

 
        this.close();
    return dataShow;
    }
  
   public  int  getcount(ResultSet res) throws SQLException, ParseException{
       Z_DataFillShow_swing dataShow = new Z_DataFillShow_swing(cells) ;
resultSet = res;
       dataShow.get_Rowslist(resultSet);
 

 
        this.close();
    return dataShow.getRowcount();
    }
 
  
  
                public  void test(ResultSet res) throws SQLException, ParseException{
       Z_DataShow dataShow = new Z_DataShow(cells) ;
resultSet = res;
       dataShow.get_Rowslist(resultSet);
 

  int c = dataShow.getCulomntcount();  int r = dataShow.getRowcount(); 
  int ic = 0;int ir =  0;
           while (ir < r ) {
    while (ic<c) {            
        
            System.out.println(dataShow.getvalue(ir, ic ));
    ic++;
        } 
           ir ++ ;
           ic=0;
           }
        this.close();
  
    }
    public  void ComboFill (JComboBox  c , Cell c1) throws SQLException, ParseException{

    Cell [] cell = {c1};
    setCells(cell);
   
    Z_DataFillShow_swing dataFillShow_swing = new Z_DataFillShow_swing(cell);
    dataFillShow_swing.get_Rowslist(Load_Expission_Where()) ;
   dataFillShow_swing.Fillcombo(c, c1);
}

    public void Load_Fillcondeol(ResultSet rs) throws SQLException, ParseException{
       Z_DataFillShow_swing dataFillShow_swing = new Z_DataFillShow_swing(this.cells);
 
    dataFillShow_swing = showDattaFill(rs);
dataFillShow_swing.FillControls();
}
    }
    
     


 
