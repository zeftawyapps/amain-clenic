package Reports;




import com.mysql.cj.api.mysqla.result.Resultset;
import mysql_data_link.Passoin.*;
import java.io.IOException;
import java.sql.ResultSet;
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
public class Aman_finish_pasRevenue extends Z_DataTable{
   
    Cell ID=new Cell("ID");
   Cell Name=new Cell("Name");
   Cell Pasid = new Cell("Pasiont_id");
    Cell ExamDate=new Cell("ExamDate");
    Cell ExamType=new Cell("ExamType");
    Cell ExamValue=new Cell("ExamValue");
    Cell InsValue=new Cell("InsValue");
    Cell pasValue=new Cell("PasValue");
    Cell Cash=new Cell("Cash"); 
    Cell operation=new Cell("operation"); 
    Cell Consum=new Cell("Consum"); 
    Cell Srv=new Cell("Srv"); 
    Cell Total=new Cell("Total"); 

    Cell Percent=new Cell("Percent"); 
      Z_connection connection;
      
       Cell [] TablCell;
       Cell[] TableinValue;
          public Aman_finish_pasRevenue(Z_connection con){
    super(con);
    connection =con;
        setTableName("finpasrevenue");
    }
          
       public void setControl(IControl ID,
               IControl Name,IControl exmaDate,
               IControl examType,IControl examValue,
               IControl pasValue,IControl insValue,
              IControl ope,IControl cons,
               IControl srv,IControl total,
               IControl percent)
              {
        this.ID.setIsKey(true);
  
        this.ID.setControl(ID);
     this.Name.setControl(Name);
  ExamDate.setControl(exmaDate);
  ExamType.setControl(examType);
  ExamValue.setControl(examValue);
  this.pasValue.setControl(pasValue);
  InsValue.setControl(insValue);
  operation.setControl(ope);
Consum.setControl(cons);
Srv.setControl(srv);
Total.setControl(total);
Percent.setControl(percent);
    
     
     Cell[] DataCells=new Cell[]{
     this.ID,this.Name,this.ExamDate,this.ExamType,
         this.ExamValue,this.InsValue,
         this.pasValue,Cash,operation,Consum,
         Srv,Total,Percent
     };
       TablCell=DataCells;
       
       DataCells=new Cell[]{
         this.Name,this.ExamDate,this.ExamType,
         this.ExamValue,this.InsValue,
         this.pasValue,Cash,operation,Consum,
         Srv,Total,Percent
       };
       TableinValue=DataCells;
       }

      public  void insert_ExmapRevenue(IControl Exampdate , IControl Examptype 
      
       ,IControl Exampval , String  pasName , String  PaseID , String  Cashs ) throws SQLException, ParseException, IOException{
      
      ExamDate.setControl(Exampdate);
      Name.setValue(pasName);
      Pasid.setValue(PaseID);
      ExamValue.setControl(Exampval);
      ExamType.setControl(Examptype);
     
      double exvalue = Double.parseDouble( Exampval.getValue());
     
      double cashval ; 
       cashval= Double.parseDouble( Cashs);
  Cash.setValue(cashval);
      Total.setValue(exvalue + "");
      pasValue.setValue(exvalue - cashval + "");
      
      
      TableinValue = new Cell[]{ExamType , ExamDate, ExamValue , 
      Pasid , Name , Total , pasValue, Cash};
      pationtDataInsert();
      }
   
      
        public  void insert_Opration_Revenue(String Exampdate 
      
       ,String Opartionpval , String  pasName , String  PaseID , String  Cashs ) throws SQLException, ParseException, IOException{
      
      ExamDate.setValue(Exampdate);
      Name.setValue(pasName);
      Pasid.setValue(PaseID);
      operation.setValue(Opartionpval);

     
      double Opval = Double.parseDouble( Opartionpval);
     
      double cashval ; 
       cashval= Double.parseDouble( Cashs);
  Cash.setValue(cashval);
      Total.setValue(Opval + "");
      pasValue.setValue(Opval - cashval + "");
      
      
      TableinValue = new Cell[]{ExamType , ExamDate, ExamValue , 
      Pasid , Name , Total , pasValue, Cash};
      pationtDataInsert();
      }

      
      public void pationtDataInsert() throws SQLException, ParseException, IOException{
           setCells(TableinValue);
           insert();
       }
       
  
       public void pationtDataUpdate(String id) throws SQLException, ParseException, IOException{
       
        setCells(TableinValue, ID);
        update_id(id);
    
    }
   
       public void deletfile_id( String id ) throws SQLException, ParseException, IOException{
        
        setCells(null, ID);
        delete_id(id);
    
    }

       public  Z_DataFillShow_swing LoadFile_id(String id) throws SQLException, ParseException{
       Cell [] maindataCells;
   maindataCells =  new Cell[]{ID,this.ExamDate ,ExamType,
       ExamValue,
       pasValue, InsValue ,Cash,
     operation , Srv , Total , Percent
  
   };
   
   Cell Wherecell[];
   Pasid.SetWhere(setwhere.Equl, setAndor.And,id);
    Wherecell =  new Cell[]{this.Pasid};
    setCells(maindataCells,Wherecell);
   dataTableShow= showDattaFill(Load_Where());  
   return dataTableShow;  
  
}


       
       
       Z_DataShow dataShow;
    Z_DataFillShow_swing dataTableShow;
    
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


       public DefaultTableModel showinTable(String id) throws SQLException, ParseException{
       ExamDate.setShowInTable(true,"تاريخ الكشف");
       ExamType.setShowInTable(true, "نوع الكشف");
       ExamValue.setShowInTable(true,"قيمة الكشف");
       InsValue.setShowInTable(true,"قيمة التأمين");         pasValue.setShowInTable(true,"قيمة المريض");
       Cash.setShowInTable(true,"الكاش");
       operation.setShowInTable(true, "العمليات");
       Consum.setShowInTable(true, "المستهلكات");
       Srv.setShowInTable(true, "الخدمات");
       Total.setShowInTable(true, "المجموع");
       Percent.setShowInTable(true, "النسبة");
      
       Cell[] dataCells=new Cell[]
     {Name , ExamDate , ExamType,ExamValue,InsValue,pasValue,Cash};
      DefaultTableModel d=dataTableShow.ShowData();
          close();
          return  d;

       }
       
       void LoadinControl() throws SQLException, ParseException{
    setCells(TablCell);
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
    ID.SetWhere(setwhere.Equl, setAndor.And, id);
     setCells( new Cell[]{ID} , new Cell[]{ID});
    return  getcount(Load_Where())+1 ;
             
  
 }
public  String    testsum() throws SQLException, ParseException{
pasValue.setSelectAsSum(true); 
Cell[] cells = new Cell[]{pasValue  };
Pasid.SetWhere(setwhere.Equl, setAndor.And, "1");
    setCells(cells, new Cell[]{Pasid});
ResultSet res =   Load_Expission_Where()  ;
   res.absolute(0);
   res.next();
   return res.getString(1);
}

public  String    getRevenu(Cell ce , String id ) throws SQLException, ParseException{
ce.setSelectAsSum(true); 
Cell[] cells = new Cell[]{ce  };
Pasid.SetWhere(setwhere.Equl, setAndor.And, "1");
    setCells(cells, new Cell[]{Pasid});
ResultSet res =   Load_Expission_Where()  ;
   res.absolute(0);
   res.next();
   return res.getString(1);
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


