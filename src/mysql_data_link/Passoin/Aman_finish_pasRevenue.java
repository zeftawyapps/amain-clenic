package mysql_data_link.Passoin;


import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import mysql_data_link.ZeftawyTools.Cell;
import mysql_data_link.ZeftawyTools.IControl;
import mysql_data_link.ZeftawyTools.Z_DataFillShow_swing;
import mysql_data_link.ZeftawyTools.Z_DataShow;
import mysql_data_link.ZeftawyTools.Z_DataTable;
import mysql_data_link.ZeftawyTools.Z_connection;
import mysql_data_link.ZeftawyTools.setAndor;
import mysql_data_link.ZeftawyTools.setwhere;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aman
 */
public class Aman_finish_pasRevenue extends Z_DataTable{
   Cell ID=new Cell("ID");
   Cell Name=new Cell("Name");
   Cell Pasid = new Cell("Pasiont_id");
    Cell ExamDate=new Cell("ExamDate");
    Cell ExamType=new Cell("ExamType");
    Cell ExamValue=new Cell("ExamValue");
    Cell InsValue=new Cell("InsValue");
    Cell pasValue=new Cell("Pas_Value");
    Cell Cash=new Cell("Cash"); 
    Cell operation=new Cell("operation"); 
    Cell Consum=new Cell("Consum"); 
    Cell Srv=new Cell("Srv"); 
    Cell Total=new Cell("Total"); 

    Cell Percent=new Cell("Percent"); 
      Z_connection connection;
      
       Cell [] TablCell;
          public Aman_finish_pasRevenue(Z_connection con){
    super(con);
    connection =con;
        setTableName("finpasrevenue");
    }
          
       public void setControl(IControl ID,
               IControl Name)
              {
        
     this.ID.setControl(ID);
     this.Name.setControl(Name);
  
     
    
     
     Cell[] DataCells=new Cell[]{
     this.ID,this.ExamDate,this.ExamType,
         this.ExamValue,this.InsValue,
         pasValue,Cash,operation,Consum,
         Srv,Total,Percent
     };
       TablCell=DataCells;
       }

       public void insertDataRevenue(String ID,String ExamDate,
               String ExamType,String ExamValue,String InsValue,
      String pasValue,String Cash,
       String ope,String consum,String srv,
       String total,String percent) throws SQLException, ParseException, IOException{
       
           this.ID.setValue(ID);
           this.ExamDate.setValue(ExamDate);
           this.ExamType.setValue(ExamType);
           this.ExamValue.setValue(ExamValue);
           this.InsValue.setValue(InsValue);
           this.pasValue.setValue(pasValue);
           this.Cash.setValue(Cash);
           operation.setValue(ope);
           Consum.setValue(consum);
           Srv.setValue(srv);
           Total.setValue(total);
           Percent.setValue(percent);
           Cell[] dataCells=new Cell[]{
           this.ID,this.ExamDate,this.ExamType,
               this.ExamValue,this.InsValue,
               this.pasValue,this.Cash,operation,
               Consum,Srv,Total,Percent
           };
           setCells(dataCells);
           insert();
       }
       
       public void insertNewData() throws SQLException, ParseException, IOException{
           setCells(TablCell);
           insert();
       }
           Z_DataShow dataShow;
    Z_DataFillShow_swing dataTableShow;

       public DefaultTableModel showinTable(String id) throws SQLException, ParseException{
    Name .setShowInTable(true,"الاسم ");
       ExamDate.setShowInTable(true,"تاريخ الكشف");
       ExamType.setShowInTable(true, "نوع الكشف");
              ExamValue.setShowInTable(true,"قيمة الكشف");
              InsValue.setShowInTable(true,"قيمة التأمين");
              pasValue.setShowInTable(true,"قيمة المريض");
              Cash.setShowInTable(true,"الكاش");
              
      Cell[] dataCells=new Cell[]
     {Name , ExamDate , ExamType,ExamValue,InsValue,pasValue,Cash};
          if(id=="")
    {setCells(dataCells);
    dataTableShow=showDattaFill(Load());}
    else{
    Pasid.SetWhere(setwhere.Equl, setAndor.And,id );
  
              Cell[] whereCell=new Cell[]{Pasid};
          
             
             setCells(dataCells,whereCell);
            dataTableShow=showDattaFill(Load_Where());}
    DefaultTableModel d=dataTableShow.ShowData();
            close();
            return  d;

       }
       
       void LoadinControl() throws SQLException, ParseException{
    setCells(TablCell);
dataTableShow = showDattaFill(Load());
dataTableShow.FillControls();
}
       
           public  void ComboFill (JComboBox  c , Cell c1) throws SQLException{

    Cell [] cell = {c1};
    setCells(cell);
   
    dataTableShow = new Z_DataFillShow_swing(cell);
    dataTableShow.get_Rowslist(Load()) ;
   dataTableShow.Fillcombo(c, c1);
}

 public int  getNom(String id ) throws SQLException, ParseException{
    ID.SetWhere(setwhere.Equl, setAndor.And, id);
     setCells( new Cell[]{ID} , new Cell[]{ID});
    return  getcount(Load_Where())+1 ;
             
  
 }


}
