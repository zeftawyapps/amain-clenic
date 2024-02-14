/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql_data_link.Doctor;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
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
public class AmanDatabse_imployee extends Z_DataTable{
    
    Cell ID=new Cell("ID");
     Cell Name=new Cell("Name");
      Cell phone=new Cell("phone_num");
       Cell DateBirth=new Cell("DateBirth");
       
               Z_connection connection;
    
    Cell [] TablCell;
    Cell[] TableinputCell;
    public AmanDatabse_imployee(Z_connection con) {
        super(con);
        connection=con;
        setTableName("doctors_imployee");
    }
    
           public void setControl(IControl ID,
            IControl name,IControl phone,IControl DateBirth){
    
        
        this.ID.setControl(ID);
        this.Name.setControl(name);
        this.phone.setControl(phone);
        this.DateBirth.setControl(DateBirth);
        
        Cell[] DataCells=new Cell[]{
        this.ID,Name,this.phone,this.DateBirth
  };
 
 TablCell = DataCells;
 
         DataCells=new Cell[]{
       Name,this.phone,this.DateBirth
  };TableinputCell=DataCells;

    }

 public  void NewDataInsert() throws SQLException, ParseException, IOException{
 
     setCells(TableinputCell);
 insert();
 }
 
    
    
 public  void NewDataUpdate(String id ) throws SQLException, ParseException, IOException{
 
     setCells(TableinputCell);
     update_id(id);
 }
 
     public  void DeleteData_id(String id ) throws SQLException, ParseException, IOException{
 
      setCells(null, ID);
     delete_id(id);
 }

            Z_DataShow dataShow;
    Z_DataFillShow_swing dataTableShow;

   public Z_DataShow LoadData_id(String id) throws SQLException, ParseException{
  Cell[] dataCells=new Cell[]{
  ID,Name,phone,DateBirth
  };
  Cell whereCell[]=new Cell[]
  {this.ID };
 ID.SetWhere(setwhere.Equl, setAndor.And, id);
      setCells(dataCells,whereCell);
 dataShow=showDatta(Load_Where());
 return  dataShow;
  }
               
    void LoadinControl() throws SQLException, ParseException{
    setCells(TablCell);
dataTableShow = showDattaFill(Load());
dataTableShow.FillControls();
}

 public  void movefirst()
{
    dataTableShow.MoveFirist();
}

public void movepre()
{
    dataTableShow.MovePrivious();
}

public  void movenext()
{
    dataTableShow.Movenext();
}

public  void movelast()
{
    dataTableShow.Movelast();
}



    
    

}
