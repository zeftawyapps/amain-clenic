package Reports;



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
public class AmanPasDatabse_Cash extends Z_DataTable{
    Cell ID=new Cell("ID");
    Cell DATE=new Cell("DATE");
    Cell CASH_IN=new Cell("CASH_IN");
    Cell CASH_OUT=new Cell("CASH_OUT");
    Cell EXPLAN=new Cell("EXPLAN");
    
    Z_connection connection;
    Cell[] TableCell;
    Cell[] TableinCell;
    
     Cell[] TableinCashIn;
      Cell[] TableinCashOut;
    public AmanPasDatabse_Cash(Z_connection con){
    super(con);
    connection=con;
        setTableName("CASH");
    }
    
    public void setControl(IControl id,IControl data,
            IControl cashIn,IControl cashOut,IControl explain  
    ){
        ID.setIsKey(true);
    ID.setControl(id);
    DATE.setControl(data);
    CASH_IN.setControl(cashIn);
    CASH_OUT.setControl(cashOut);
    EXPLAN.setControl(explain);
    
    
    Cell[] dataCells=new Cell[]{
    ID,DATE,CASH_IN,CASH_OUT,EXPLAN
    };TableCell=dataCells;
    
    dataCells=new Cell[]{
    DATE,CASH_IN,CASH_OUT,EXPLAN
    };TableinCell=dataCells;
    
    }




   public void setControlCashin( String date,
            String cashIn,String explain  
    ){
        ID.setIsKey(true);
   
    DATE.setValue(date);
    CASH_IN.setValue(cashIn);
    CASH_OUT.setValue("00");
    EXPLAN.setValue(explain);
    
    
    
    TableinCashIn=new Cell[]{
    DATE,CASH_IN,CASH_OUT,EXPLAN
    }; 
    
    }
    
   
   
      public void setControlCashOut( String date,
            String cashOut,String explain  
    ){
        ID.setIsKey(true);
   
    DATE.setValue(date);
    CASH_IN.setValue("00");
    CASH_OUT.setValue(cashOut);
    EXPLAN.setValue(explain);
    
    
    
    TableinCashOut=new Cell[]{
    DATE,CASH_IN,CASH_OUT,EXPLAN
    }; 
    
    }
   
    public  void dataInsertCashOut() throws SQLException, ParseException, IOException{
    
    setCells(TableinCashOut);
        insert();
    }
   
    public  void dataInsertCashin() throws SQLException, ParseException, IOException{
    
    setCells(TableinCashIn);
        insert();
    }
    public void dataInsert() throws SQLException, ParseException, IOException{
        setCells(TableinCell);
        insert();
    
    }
    
    public void dataUpdate(String id) throws SQLException, ParseException, IOException{
        setCells(TableinCell,ID);
        update_id(id);
    }
    
    public void dataDelate(String id) throws SQLException, ParseException, IOException{
        setCells(null,ID);
        delete_id(id);
    }
    
    Z_DataShow dataShow;
    Z_DataFillShow_swing dataTableShow;
    public Z_DataFillShow_swing loadData_id(String id) throws SQLException, ParseException{
    Cell[] dataCells=new Cell[]{
    ID,DATE,CASH_IN,CASH_OUT,EXPLAN
    };
    Cell[] whereCell=new Cell[]{ID};
    ID.SetWhere(setwhere.Equl, setAndor.And, id);
        setCells(dataCells,whereCell);
        dataTableShow=showDattaFill(Load_Where());
        return  dataTableShow;
    }
    
        String getValue (Cell cell ){
    int r = getDataShow().getCurrentRow();
  if (getDataShow().getRowcount()>0){
    return getDataShow().getvalue(r, cell);}
  
  else{
      return   "";
  }

}
    public Z_DataShow getDataShow() {
        return dataShow;
    }

    
    public DefaultTableModel loadinTable(String id) throws SQLException, ParseException{
    DATE.setShowInTable(true, "تاريخ المعاملة");
    CASH_IN.setShowInTable(true, "الداخل");
    CASH_OUT.setShowInTable(true, "الخارج");
    EXPLAN.setShowInTable(true, "الشرح");
    
    Cell[] dataCell=new Cell[]{
    ID,DATE,CASH_IN,CASH_OUT,EXPLAN
    };
    if(id==""){
        setCells(dataCell);

dataTableShow= showDattaFill(Load());
   dataShow = dataTableShow;     
    }
   else{
                  Cell Wherecell[];
   ID.SetWhere(setwhere.Equl, setAndor.And,id);
   Wherecell =  new Cell[]{this.ID };

   setCells(dataCell,Wherecell);
    dataTableShow= showDattaFill(Load_Where());  
}

   
    DefaultTableModel d=dataTableShow.ShowData();
    close();
    return d;
    }
    
        void LoadinControl(){
        setCells(TableCell);
        dataTableShow.FillControls();
    }

}
