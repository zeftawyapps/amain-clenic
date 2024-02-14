/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql_data_link.Doctor;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import javax.swing.JComboBox;
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
public class AmanDatabse_doctorService extends Z_DataTable{
    
       public  Cell ID=new Cell("ID");
  public       Cell service=new Cell("service");
    public  Cell price=new Cell("price");

        Z_connection connection;
    
    Cell [] TablCell;
    Cell[] TableinputCell;
    public AmanDatabse_doctorService(Z_connection con) {
        super(con);
        connection=con;
        setTableName("doctor_service");
    }
    
       public void setControl(IControl ID,
            IControl srv,IControl price){
    
        
        this.ID.setControl(ID);
        this.service.setControl(srv);
        this.price.setControl(price);
        
        Cell[] DataCells=new Cell[]{
        this.ID,service,this.price,
  };
 
 TablCell = DataCells;
 
         DataCells=new Cell[]{
       service,this.price,
           
  };
         TableinputCell=DataCells;

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
  ID,service,price
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

    public  void ComboFill (JComboBox  c , Cell c1) throws SQLException, ParseException{

    Cell [] cell = {c1};
    setCells(cell);
   
    dataTableShow = new Z_DataFillShow_swing(cell);
    dataTableShow.get_Rowslist(Load_Expission_Where()) ;
   dataTableShow.Fillcombo(c, c1);
}

  public String  LoadData_service(String service) throws SQLException, ParseException{
  Cell[] dataCells=new Cell[]{
  ID,this.service,price
  };
  Cell whereCell[]=new Cell[]
  {this.service };
 this.service.SetWhere(setwhere.Equl, setAndor.And, service);
      setCells(dataCells,whereCell);
 dataShow=showDatta(Load_Where());
 return  dataShow.getvalue(price);
  }
  
public  void movefirst()
{ dataTableShow.setCell(TablCell);
    dataTableShow.MoveFirist();}

public void movepre()
{dataTableShow.MovePrivious();  }

public  void movenext()
{dataTableShow.Movenext();}

public  void movelast()
{dataTableShow.Movelast();}

}
