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
public class AmanDoctorDatabse_InsCompany extends Z_DataTable{
        Cell doc_ID=new Cell("doctor_ID");
    Cell Name=new Cell("companyName");
    Cell ID=new Cell("ID");
    Cell percent=new Cell("percent");
    
    Z_connection connection ;
    
    Cell[] TableCell;
    Cell[] TableinputCell;
            public AmanDoctorDatabse_InsCompany(Z_connection con)  {
       super(con);
        connection = con;
        setTableName("Insurance_company");         
    }
            
        public void setControl(IControl id,IControl Name,
               
                IControl percent){
        ID.setControl(id);
        this.Name.setControl(Name);
      
        this.percent.setControl(percent);
        
        Cell[] DataCell=new Cell[]{
        ID,this.Name,this.doc_ID,this.percent
        };
        TableCell=DataCell;
        
                DataCell=new Cell[]{
        this.Name,this.doc_ID,this.percent
        };
        TableCell=DataCell;

        }
            
        
        public void NewDataInsert() throws SQLException, ParseException, IOException{
            setCells (TableinputCell);
            insert();
        }
        
        public void NewDataUpdate(String id) throws SQLException, ParseException{
            setCells(TableinputCell);
            try {
  update_id(id);                
            } catch (Exception e) {
                System.out.println("Error update "+ e);
            }

        }
        
       public void deleteData_id(String id) throws SQLException, ParseException{
      setCells(null,ID);
           try {
            delete_id(id);    
           } catch (Exception e) {
              System.out.println("Error update "+ e);
        
           }
 
  }

       Z_DataShow dataShow;
    Z_DataFillShow_swing dataTableShow;

   public Z_DataShow LoadData_id(String id) throws SQLException, ParseException{
  Cell[] dataCells=new Cell[]{
  ID,Name,percent
  };
  Cell whereCell[]=new Cell[]
  {this.doc_ID };
 doc_ID.SetWhere(setwhere.Equl, setAndor.And, id);
      setCells(dataCells,whereCell);
 dataShow=showDatta(Load_Where());
 return  dataShow;
  }
               
    void LoadinControl() throws SQLException, ParseException{
    setCells(TableCell);
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



