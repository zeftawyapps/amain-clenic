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
public class AmanDoctorDatabse_doctorData extends Z_DataTable{
  
    Cell ID=new Cell("doctor_ID");
   public  Cell Name=new Cell("doctor_Name");
    Cell Desc=new Cell("doctor_desc");
    Cell edu=new Cell("doctor_edu");
    Cell Loca=new Cell("doctor_Loc");
    Cell Address=new Cell("doctor_Address");
    
    Z_connection connection ;
    
    Cell[] TableCell;
    Cell[] Tablecellfromvalue;
        public AmanDoctorDatabse_doctorData(Z_connection con)  {
       super(con);
        connection = con;
        setTableName("DoctorData");         
    }
        
        public void setControl(IControl id,IControl Name,
                IControl Desc,IControl edu,IControl Loca,
                IControl Address){
            
        ID.setControl(id);
        
        ID.setIsKey(true);
        
        this.Name.setControl(Name);
        this.Desc.setControl(Desc);
        this.edu.setControl(edu);
        this.Loca.setControl(Loca);
        this.Address.setControl(Address);
        
        Cell[] DataCell=new Cell[]{
        ID,this.Name,this.Desc,this.edu,this.Loca,this.Address
        };
        TableCell=DataCell;
      DataCell=new Cell[]{
        this.Name,this.Desc,this.edu,this.Loca,this.Address
        };
        Tablecellfromvalue = DataCell;
        }
        
        public void doctorDataInsert(String id,String name,
                String edu,String desc,String loca,String Address) throws SQLException, ParseException, IOException
        {
        ID.setValue(id);
        Name.setValue(name);
        this.edu.setValue(edu);
        Desc.setValue(desc);
        Loca.setValue(loca);
        this.Address.setValue(Address);
        
        Cell[] dataCells=new Cell[]{
        ID,Name,this.edu,Desc,Loca,this.Address
        };
            setCells(dataCells);
            insert();
        }
        
        public void doctorNewDataInsert() throws SQLException, ParseException, IOException{
            setCells(Tablecellfromvalue);
            insert();
        }
        
        public void doctorDataUpdate(String id,String name,
                String edu,String desc,String loca,String Address) throws SQLException, ParseException, IOException
 {
             ID.setValue(id);
        Name.setValue(name);
        this.edu.setValue(edu);
        Desc.setValue(desc);
        Loca.setValue(loca);
        this.Address.setValue(Address);
        
        Cell[] dataCells=new Cell[]{
        ID,Name,this.edu,Desc,Loca,this.Address
        };
            setCells(dataCells);
            update_id(id);    
        }
        public void doctorNewDataUpdate(String id) throws SQLException, ParseException, IOException{
            setCells(Tablecellfromvalue);
            update_id(id);
        }
        
          public void deleteme_id(String id) throws SQLException, ParseException, IOException{
      setCells(null,ID);
      this.delete_id(id);
     
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
  ID,Name
  };
  Cell whereCell[]=new Cell[]
  {ID };
 ID.SetWhere(setwhere.Equl, setAndor.And, id);
      setCells(dataCells,whereCell);
 dataShow=showDatta(Load_Where());
 return  dataShow;
  }
  
        
    public DefaultTableModel loadTable_id_showTable(String id) throws SQLException, ParseException
    {
          Name.setShowInTable(true);
    Cell DataCell[]=new Cell[]{Name};
    
    if(id=="")
    {setCells(DataCell);
    dataTableShow=showDattaFill(Load());}
    else{
    Cell whereCell[];
    ID.SetWhere(setwhere.Equl, setAndor.And,id );
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
  System.out.println("no of fields"+ dataTableShow.getCulomntcount());
  
}

    
    
    public  void ComboFill (JComboBox  c , Cell c1) throws SQLException, ParseException{

    Cell [] cell = {c1};
    setCells(cell);
   
    dataTableShow = new Z_DataFillShow_swing(cell);
    dataTableShow.get_Rowslist(Load_Expission_Where()) ;
   dataTableShow.Fillcombo(c, c1);
}

 public int  getNom(String id ) throws SQLException, ParseException{
    ID.SetWhere(setwhere.Equl, setAndor.And, id);
     setCells( new Cell[]{ID} , new Cell[]{ID});
    return  getcount(Load_Where())+1 ;
             
  
 }

  public String  LoadData_doctor(String service) throws SQLException, ParseException{
  Cell[] dataCells=new Cell[]{
  ID,this.Name,edu,Desc,Loca,Address
  };
  Cell whereCell[]=new Cell[]
  {this.Name };
 this.Name.SetWhere(setwhere.Equl, setAndor.And, Name);
      setCells(dataCells,whereCell);
 dataShow=showDatta(Load_Where());
 return  dataShow.getvalue(edu);
  }

public  void movefirst()
        
{dataTableShow.setCell(TableCell); 
    System.out.println("no of fields"+ dataTableShow.getCulomntcount());
    dataTableShow.MoveFirist();
}

public void movepre()
{dataTableShow.setCell(TableCell);
    dataTableShow.MovePrivious();
}

public  void movenext()
{dataTableShow.setCell(TableCell);
    dataTableShow.Movenext();
}

public  void movelast()
{dataTableShow.setCell(TableCell);
    dataTableShow.Movelast();
}

    
}
