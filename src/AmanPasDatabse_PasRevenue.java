


import mysql_data_link.Passoin.*;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
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
public class AmanPasDatabse_PasRevenue extends Z_DataTable{
    Cell ID=new Cell("ID");
    Cell Name=new Cell("PasName");
    
    Z_connection connection ;
    
     Cell[] TableCell;
     
    public AmanPasDatabse_PasRevenue(Z_connection con)  {
       super(con);
        connection = con;
        setTableName("pas_revenue");}
    
  public void setControl(IControl ID,IControl Name){
  this.ID.setControl(ID);
  this.Name.setControl(Name);
       
   Cell[] DataCells=new Cell[]{
   this.ID,this.Name
   };
    TableCell=DataCells;
           }  
  
  public void pasiontDataInsert(String ID,String Name) throws SQLException, ParseException, IOException{
  this.ID.setValue(ID);
  this.Name.setValue(Name);
  
  Cell[] DataCells=new Cell[]{
  this.ID,this.Name
  };
      setCells(DataCells);
      insert();
  }
  
  public void insertNewOperation() throws SQLException, ParseException, IOException{
      setCells(TableCell);
      insert();
  }
  
  public void pastiontDataEdit(String ID,String Name) throws SQLException, ParseException, IOException{
  this.ID.setValue(ID);
  this.Name.setValue(Name);
  
  Cell[] DataCells=new Cell[]{
  this.ID,this.Name
  };
      setCells(DataCells);
      update_id(ID);
  }
  
  public void EditDataOperation(String id) throws SQLException, ParseException, IOException{
      setCells(TableCell);
      update_id(id);
  }
  
  public void delete_id(String id){
      setCells(null,ID);
      delete_id(id);
  }
  
  public void deleteData_id(String id){
      setCells(null,ID);
      delete_id(id);
  }
  
  Z_DataShow dataShow;
    Z_DataFillShow_swing dataTableShow;
    String getValue(Cell c){
    int r=getDataShow().getCurrentRow();
    if(getDataShow().getCurrentRow()>0)
        return getDataShow().getvalue(r,c);
    else{return "";}
    }
    
    
  public Z_DataShow getDataShow(){
  return  dataShow;
  }
  
  public Z_DataShow LoadData_id(String id) throws SQLException, ParseException{
  Cell[] dataCells=new Cell[]{
  ID,Name
  };
  Cell whereCell[]=new Cell[]
  {ID };
 ID.SetWhere(setwhere.Equl, setAndor.And, id);
      setCells(dataCells,whereCell);
 dataShow=showDatta(Load_Where());
 return  dataShow;
  }
  
          public DefaultTableModel loadTable_id_showTable(String Pationt_id) throws SQLException, ParseException
    {
          Name.setShowInTable(true);
    Cell DataCell[]=new Cell[]{Name};
    
    if(Pationt_id=="")
    {setCells(DataCell);
    dataTableShow=showDattaFill(Load());}
    else{
    Cell whereCell[];
    ID.SetWhere(setwhere.Equl, setAndor.And,Pationt_id );
     whereCell =new Cell[]
             {this.ID };
             setCells(DataCell,whereCell);
            dataTableShow=showDattaFill(Load_Where());}
    
    DefaultTableModel d=dataTableShow.ShowData();
            close();
            return  d;
    }
          
          void LoadinControl() throws SQLException, ParseException{
    setCells(TableCell);
dataTableShow = showDattaFill(Load());
dataTableShow.FillControls();
}


}
