/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Store_Manag;

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

/**
 *
 * @author aman
 */
public class amanDatabse_store_AddCategory extends Z_DataTable{

Cell categ_id=new Cell("categ_id");
Cell categ_Name=new Cell("categ_Name");
Cell categ_Require=new Cell("categ_Require");

    Z_connection connection;
    Cell[] TableCell;
    Cell[] TableinputCell;
    
    public amanDatabse_store_AddCategory(Z_connection con){
    super(con);
    connection=con;
        setTableName("add_category");
    
    }
    
    public void setControl(IControl name,IControl req){
    categ_Name.setControl(name);
    categ_Require.setControl(req);
    
    Cell[] dataCells=new Cell[]{
    categ_id,categ_Name,categ_Require
    };TableCell=dataCells;
    
    dataCells=new Cell[]{
    categ_Name,categ_Require
    };
    TableinputCell=dataCells;
    
    }
    
    public void categDataInsert() throws SQLException, ParseException, IOException{
        setCells(TableCell);
        insert();
    }
    
    public void categDataUpdate(String id) throws SQLException, ParseException, IOException{
        setCells(TableCell,categ_id);
        update_id(id);
    }
    
    public void categDataDelete(String id) throws SQLException, ParseException, IOException{
        setCells(null,categ_id);
        delete_id(id);
    }
    

    Z_DataShow dataShow;
    Z_DataFillShow_swing dataTableShow; 
    
    public Z_DataShow getDataShow(){
    return dataShow;
    }
    
    String getValue(Cell c){
    int r=getDataShow().getCurrentRow();
    if(getDataShow().getCurrentRow()>0)
    {
    return getDataShow().getvalue(r, c);
    }
    else{return "";}
    
    }
    
    public Z_DataFillShow_swing loadData(String id) throws SQLException, ParseException{
    Cell [] dataCells=new Cell[]{
    categ_id,categ_Name,categ_Require
    };
    Cell[] whereCell =new Cell[]{
    categ_id
    };
    categ_id.SetWhere(setwhere.Equl, setAndor.And, id);
        setCells(dataCells,whereCell);
        dataTableShow=showDattaFill(Load_Where());
        return  dataTableShow;
    }
    
    public DefaultTableModel loadTable (String s,Cell c) throws SQLException, ParseException{
    categ_id.setShowInTable(true, "رقم الصنف");
    categ_Name.setShowInTable(true, "اسم الصنف");
    categ_Require.setShowInTable(true, "الطلب على الصنف");
    
    Cell[] dataCells=new Cell[]{
    categ_id,categ_Name,categ_Require
    };
    
   if(s=="")
   {
       setCells(dataCells);
       dataTableShow=showDattaFill(Load());
   }
   
   else{
   Cell[] whereCell=new Cell[]{categ_id};
      categ_Name.SetWhere(setwhere.Like, setAndor.And,"%"+s+"%");
       setCells(dataCells,whereCell);
       dataTableShow=showDattaFill(Load_Where());
   
   }
   DefaultTableModel d=dataTableShow.ShowData();
   close();
   return d;
    }
    
   public  DefaultTableModel LoadFile_id_showTableview(String S , Cell cl ) throws SQLException, ParseException{
      categ_Name.setShowInTable(true, "اسم الصنف");
      categ_Require.setShowInTable(true, " الطلب على الصنف");
        Cell [] dataCells=new Cell[]{
           categ_id,categ_Name,categ_Require
};
   
  if (S == ""){
setCells(dataCells);

dataTableShow= showDattaFill(Load());
        
    
}else{   
      
       Cell Wherecell[];
   cl.SetWhere(setwhere.Like, setAndor.And,"%"+S+"%");
   Wherecell =  new Cell[]{cl };

   setCells(dataCells,Wherecell);
    dataTableShow= showDattaFill(Load_Where());  
}
  
  DefaultTableModel m = dataTableShow.ShowData();
  close() ;
   return  m;
  
}

    
    
        public DefaultTableModel showTable ( String id) throws SQLException, ParseException{
    categ_id.setShowInTable(true, "رقم الصنف");
    categ_Name.setShowInTable(true, "اسم الصنف");
    categ_Require.setShowInTable(true, "الطلب على الصنف");
    
    Cell[] dataCells=new Cell[]{
    categ_id,categ_Name,categ_Require
    };
    if(id==""){
       setCells(dataCells);
       dataTableShow=showDattaFill(Load());
      dataShow = dataTableShow;     
    }
    else{
   Cell whereCell[];
      categ_Name.SetWhere(setwhere.Equl, setAndor.And,id);

    whereCell=new Cell[]{categ_id};
       setCells(dataCells,whereCell);
       dataTableShow=showDattaFill(Load_Where());
   
    }
   DefaultTableModel d=dataTableShow.ShowData();
   close();
   return d;
    }

    
    void loadinControl(){
        setCells(TableCell);
        dataTableShow.FillControls();
    }
       
}
