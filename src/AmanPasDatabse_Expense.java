
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
public class AmanPasDatabse_Expense extends  Z_DataTable{
        Cell ID=new Cell("ID");
    Cell DATE=new Cell("DATE");
    Cell CASH=new Cell("CASH");
    Cell EXPENSE_TYPE=new Cell("EXPENSE_TYPE");
    Cell EXPENSE_ACCOUNT=new Cell("EXPENSE_ACCOUNT");
    
    Z_connection connection;
    Cell[] TableCell;
    Cell[] TableinCell;
    
    public AmanPasDatabse_Expense(Z_connection con){
    super(con);
    connection=con;
        setTableName("expense");
    }
    
    public void setControl(IControl id,IControl data,
            IControl cash,IControl ExType,IControl ExAccount  
    ){
        ID.setIsKey(true);
    ID.setControl(id);
    DATE.setControl(data);
    CASH.setControl(cash);
    EXPENSE_TYPE.setControl(ExType);
    EXPENSE_ACCOUNT.setControl(ExAccount);
    
    
    Cell[] dataCells=new Cell[]{
    ID,DATE,CASH,EXPENSE_TYPE,EXPENSE_ACCOUNT
    };TableCell=dataCells;
    
    dataCells=new Cell[]{
    DATE,CASH,EXPENSE_TYPE,EXPENSE_ACCOUNT
    };TableinCell=dataCells;
    
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
    ID,DATE,CASH,EXPENSE_TYPE,EXPENSE_ACCOUNT
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
    CASH.setShowInTable(true, "النقدية");
    EXPENSE_TYPE.setShowInTable(true, "نوع المصروفات");
    EXPENSE_ACCOUNT.setShowInTable(true, "المصروفات");
    
    Cell[] dataCell=new Cell[]{
    ID,DATE,CASH,EXPENSE_TYPE,EXPENSE_ACCOUNT
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

    

