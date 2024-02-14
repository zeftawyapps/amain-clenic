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
public class AmanDoctorDatabse_ContracDoctor extends Z_DataTable{

    Cell ID=new Cell("ID");
    Cell Name=new Cell("Name");
    Cell edu=new Cell("edu");
    Cell ContValue=new Cell("contrac_Value");
    Cell ContPercent=new Cell("contrac_percent"); 
    Cell doc_id=new Cell("doc_id");
    Z_connection connection ;
    
    Cell[] TableCell;
Cell[] TableinputCell;
            public AmanDoctorDatabse_ContracDoctor(Z_connection con)  {
       super(con);
        connection = con;
        setTableName("contractor_doctors");         
    }
            
    public void setControl(IControl id,IControl Name,
            IControl edu,IControl contValue,
            IControl contPercent){
        ID.setControl(id); ID.setIsKey(true);
        this.Name.setControl(Name);
        this.edu.setControl(edu);
        this.ContValue.setControl(contValue);
        this.ContPercent.setControl(contPercent);
        
        Cell[] DataCell=new Cell[]{
        doc_id,ID,this.Name,this.edu,this.ContValue,this.ContPercent
        };
        TableCell=DataCell;
        
                 DataCell=new Cell[]{
       doc_id, this.Name,this.edu,this.ContValue,this.ContPercent
        };
TableinputCell=DataCell;
        }
                    
        
        public void doctorNewDataInsert() throws SQLException, ParseException, IOException{
            setCells (TableinputCell);
            insert();
        }
        
        public void doctorNewDataUpdate(String id) throws SQLException, ParseException, IOException{
            setCells(TableinputCell);
            update_id(id);
        }
        
  
       public void deleteData_id(String id) throws SQLException, ParseException, IOException{
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
  ID,Name,edu,ContValue,ContPercent
  };
  Cell whereCell[]=new Cell[]
  {ID };
 ID.SetWhere(setwhere.Equl, setAndor.And, id);
      setCells(dataCells,whereCell);
 dataShow=showDatta(Load_Where());
 return  dataShow;
  }
               
    void LoadinControl() throws SQLException, ParseException{
    setCells(TableCell);
dataTableShow = showDattaFill(Load());
dataTableShow.FillControls();
}

void comboFill(JComboBox c,Cell c1) throws SQLException{
Cell[] cell={c1};
    setCells(cell);
    dataTableShow =new Z_DataFillShow_swing(cell);
    dataTableShow.get_Rowslist(Load());
    dataTableShow.Fillcombo(c, c1);


}
public  void movefirst(){dataTableShow.MoveFirist();} 
public void movepre(){dataTableShow.MovePrivious();  }
public  void movenext(){dataTableShow.Movenext();}

public  void movelast(){dataTableShow.Movelast();}
 

 public int  getNom_id(String id ) throws SQLException, ParseException{
    doc_id.SetWhere(setwhere.Equl, setAndor.And, id);
     setCells( new Cell[]{doc_id} , new Cell[]{doc_id});
    return  getcount(Load_Where())+1 ;
             
  
 }


           


}
