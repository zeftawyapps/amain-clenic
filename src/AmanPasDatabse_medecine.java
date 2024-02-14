
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
public class AmanPasDatabse_medecine extends Z_DataTable{
    
    Cell medecine_ID=new Cell("medecine_ID");
    Cell medecine=new Cell("medecine");
    Cell treatment=new Cell("treatment");

    Z_connection connection;
    Cell[] TableCell;
    Cell[] TableinCell;
    
    public AmanPasDatabse_medecine(Z_connection con){
    super(con);
    connection=con;
        setTableName("medecine");
    
    }
    
    public void setControl(IControl medecine,
            IControl treat){
    
    medecine_ID.setIsKey(true);
    
 
    this.medecine.setControl(medecine);
    treatment.setControl(treat);
    
    Cell[] dataCells=new Cell[]{
    medecine_ID,this.medecine,treatment
    
    };TableCell=dataCells;
    
    dataCells=new Cell[]{
    this.medecine,treatment
    };TableinCell=dataCells;
    }
    
    public void dataMedecineInsert() throws SQLException, ParseException, IOException{
        setCells(TableinCell);
        insert();
    }
    
    public void dataMedecineUpdate(String id) throws SQLException, ParseException, IOException{
        setCells(TableinCell,medecine_ID);
        update_id(id);
    }
    
    public void dataMedecineDelete(String id) throws SQLException, ParseException, IOException{
        setCells(null,medecine_ID);
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
    medecine_ID,medecine,treatment
    };
    
    Cell[] whereCell=new Cell[]{
    medecine_ID
    };
    
    medecine_ID.SetWhere(setwhere.Equl, setAndor.And, id);
        setCells(dataCells,whereCell);
    dataTableShow=showDattaFill(Load_Where());
    return dataTableShow;
    }
    
    public  DefaultTableModel LoadFile_id_showTableview(String S , Cell cl ) throws SQLException, ParseException{
      medecine.setShowInTable(true, "اسم الدواء");
      treatment.setShowInTable(true, "حالة الطلب");
        Cell [] dataCells=new Cell[]{
           medecine_ID,medecine,treatment
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
    
    medecine_ID.setShowInTable(true, "رقم الدواء");
    medecine.setShowInTable(true, "اسم الدواء");
    treatment.setShowInTable(true, "حالة الطلب");
    
    Cell[] dataCells=new Cell[]{
    medecine_ID,medecine,treatment
    };
  if (id == ""){
setCells(dataCells);

dataTableShow= showDattaFill(Load());
   dataShow = dataTableShow;     
    
}else{   
      
       Cell Wherecell[];
   medecine.SetWhere(setwhere.Equl, setAndor.And,id);
   Wherecell =  new Cell[]{this.medecine_ID };

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
