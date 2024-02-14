
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
public class AmanPasDatabse_Treatment extends Z_DataTable {
    
        Cell ID=new Cell("ID");
    Cell Request=new Cell("Request");
   Cell direction=new Cell("direction");
    
   Z_connection connection;
    Cell[] TableCell;
    Cell[] TableinCell;
    
    public AmanPasDatabse_Treatment(Z_connection con){
    super(con);
    connection=con;
        setTableName("Treatment");
    
    }
    
    public void setControl(IControl Req,
            IControl direc){
    
    ID.setIsKey(true);

    this.Request.setControl(Req);
 direction.setControl(direc);
    
    Cell[] dataCells=new Cell[]{
    ID,this.Request,direction
            
    
    };TableCell=dataCells;
    
    dataCells=new Cell[]{
    this.Request, direction
    };TableinCell=dataCells;
    }
    
    public void dataReqInsert() throws SQLException, ParseException, IOException{
        setCells(TableinCell);
        insert();
    }
    
    public void dataReqUpdate(String id) throws SQLException, ParseException, IOException{
        setCells(TableinCell,ID);
        update_id(id);
    }
    
    public void dataReqDelete(String id) throws SQLException, ParseException, IOException{
        setCells(null,ID);
        delete_id(id);
    }
    
      Z_DataShow dataShow;
    Z_DataFillShow_swing dataTableShow;

    public Z_DataShow getDataShow(){
    return  dataShow;
    }
    
    String getValue(Cell c){
    int r=getDataShow().getCurrentRow();
    if(getDataShow().getCurrentRow()>0)
        return getDataShow().getvalue(r, c);
    else{return "";}
    }
    
    public Z_DataFillShow_swing loadData_id(String id) throws SQLException, ParseException{
    Cell[] dataCells=new Cell[]{
    ID,Request,direction
    };
    
    Cell[] whereCell=new Cell[]{
    ID
    };
    
    ID.SetWhere(setwhere.Equl, setAndor.And, id);
        setCells(dataCells,whereCell);
    dataTableShow=showDattaFill(Load_Where());
    return dataTableShow;
    }
    
    public  DefaultTableModel LoadFile_id_showTableview(String S , Cell cl ) throws SQLException, ParseException{
      ID.setShowInTable(true, "اسم الدواء");
      Request.setShowInTable(true, "حالة الطلب");
      direction.setShowInTable(true, "الجهة");
        Cell [] dataCells=new Cell[]{
           ID,Request
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

    
    public DefaultTableModel showInTable(String id) throws SQLException, ParseException{
    
    ID.setShowInTable(true, "رقم الدواء");
    Request.setShowInTable(true, "حالة الطلب");
    direction.setShowInTable(true, "الجهة");
    
    Cell[] dataCells=new Cell[]{
    ID,Request,direction
    };
  if (id == ""){
setCells(dataCells);

dataTableShow= showDattaFill(Load());
   dataShow = dataTableShow;     
    
}else{   
      
       Cell Wherecell[];
   Request.SetWhere(setwhere.Equl, setAndor.And,id);
   Wherecell =  new Cell[]{this.ID };

   setCells(dataCells,Wherecell);
    dataTableShow= showDattaFill(Load_Where());  
}
  
  DefaultTableModel m = dataTableShow.ShowData();
  close() ;
   return  m;
  
}
    
    void LoadinControl(){
        setCells(TableCell);
        dataTableShow.FillControls();
    }

}
