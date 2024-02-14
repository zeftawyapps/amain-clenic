


import mysql_data_link.Passoin.*;
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aman
 */
public class AmanPasDatabse_InsRevenue extends Z_DataTable{
    
    Cell ID=new Cell("insID");
   Cell Pasiont_id=new Cell("Pasiont_id");
    Cell Name=new Cell("PasName");
    Cell ExamDate=new Cell("ExamDate");
    Cell ExamType=new Cell("ExamType");
    Cell ExamValue=new Cell("ExamValue");
    Cell PasValue=new Cell("PasValue");
    Cell InsValue=new Cell("InsValue");
    
    Z_connection connection;
    Cell[] TableCell;
    Cell[] TableinputCell;
    
    public AmanPasDatabse_InsRevenue(Z_connection con){
    super(con);
    connection=con;
        setTableName("fin_insrevenue");
    }
    
    public void setControl(IControl id,IControl name,
            IControl examDate,IControl examType,
            IControl examValue,IControl pasValue,
            IControl insValue){
    
        ID.setControl(id);
        Name.setControl(name);
        ExamDate.setControl(examDate);
        ExamType.setControl(examType);
        ExamValue.setControl(examValue);
        PasValue.setControl(pasValue);
        InsValue.setControl(insValue);
        
        Cell[] dataCells=new Cell[]{
        ID,Name,ExamDate,ExamType,ExamValue,
            PasValue,InsValue
        
        };TableCell=dataCells;
        
        dataCells=new Cell[]{
        Name,ExamDate,ExamType,ExamValue,
            PasValue,InsValue
        
        };TableinputCell=dataCells;
    
    }
    
    public void pationtDataInsert() throws SQLException, ParseException, IOException{
        setCells(TableinputCell);
        insert();
    }
    
    public void pationtDataUpdate(String id) throws SQLException, ParseException, IOException{
        setCells(TableinputCell,ID);
        update_id(id);
    }
    
    public void pationtDataDelete(String id) throws SQLException, ParseException, IOException{
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

      public  Z_DataFillShow_swing LoadData_id(String id) throws SQLException, ParseException{
       Cell [] dataCells;
   dataCells =  new Cell[]{ ExamDate
           ,ExamType,ExamValue, PasValue ,InsValue,       
   };
   
   Cell Wherecell[];
   Pasiont_id.SetWhere(setwhere.Equl, setAndor.And,id);
    Wherecell =  new Cell[]{this.Pasiont_id };
    setCells(dataCells,Wherecell);
   dataTableShow= showDattaFill(Load_Where());  
   return dataTableShow;  
  
}
       public DefaultTableModel showinTable(String id) throws SQLException, ParseException{
      
           ExamDate.setShowInTable(true,"تاريخ الكشف");
       ExamType.setShowInTable(true, "نوع الكشف");
              ExamValue.setShowInTable(true,"قيمة الكشف");
             PasValue.setShowInTable(true, "قيمة المريض");
              InsValue.setShowInTable(true,"قيمة التأمين");
      
              Cell[] dataCells=new Cell[]
     {Name , ExamDate , ExamType,ExamValue,
                  PasValue,InsValue};
         DefaultTableModel d=dataTableShow.ShowData();
            close();
            return  d;

       }

          void LoadinControl() throws SQLException, ParseException{
    setCells(TableCell);
dataTableShow.FillControls();
}
          
              public  void ComboFill (JComboBox  c , Cell c1) throws SQLException{

    Cell [] cell = {c1};
    setCells(cell);
   
    dataTableShow = new Z_DataFillShow_swing(cell);
    dataTableShow.get_Rowslist(Load()) ;
   dataTableShow.Fillcombo(c, c1);
}

          
           public int  getNom(String id ) throws SQLException, ParseException{
    Pasiont_id.SetWhere(setwhere.Equl, setAndor.And, id);
     setCells( new Cell[]{Pasiont_id} , new Cell[]{Pasiont_id});
    return  getcount(Load_Where())+1 ;
             
  
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





