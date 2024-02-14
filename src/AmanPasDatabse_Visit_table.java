


import mysql_data_link.Passoin.*;
import java.awt.JobAttributes;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import mysql_data_link.ZeftawyTools.Cell;
import mysql_data_link.ZeftawyTools.*;
import mysql_data_link.ZeftawyTools.Z_DataFillShow_swing;
import mysql_data_link.ZeftawyTools.Z_DataShow;
import mysql_data_link.ZeftawyTools.Z_DataTable;
import mysql_data_link.ZeftawyTools.Z_connection;
import mysql_data_link.ZeftawyTools.setAndor;
import mysql_data_link.ZeftawyTools.setwhere;
//import sun.management.resources.agent;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aman
 */
public class AmanPasDatabse_Visit_table extends Z_DataTable{
  Cell 	Time = new Cell("Time");
  Cell 	Date = new Cell("Date");
  Cell Doctor = new Cell("Doctor");
  Cell 	ExamType = new Cell("ExamType");
  Cell 	ExamValue = new Cell("ExamValue");
  Cell 	pasName = new Cell("pasName");
  Cell 	ID = new Cell("ID");
  Cell  Vist_Case = new Cell("Vist_Case");
  Cell  Pasiont_id = new Cell("Pasiont_id");
    Z_connection connection;
Cell [] Tablecell ; 



public String HAGZ_bY_pHONE="حجز بالهاتف";
public String HAGZ_BY_HODOR="حجز بالحضور";
public String HAGZ_BY_SADAD="حجز مع السداد";
public String DOCTOR_INTER="دخول للطبيب";

 public   Z_DataFillShow_swing datashw ;
    
    public AmanPasDatabse_Visit_table(Z_connection con){
    super(con);
    connection =con;
        setTableName("visit_table");
    }
   public  void setconrotl(IControl id, IControl pas ,  IControl Exm,
        IControl val , IControl doc , IControl time,
           IControl date){
     Pasiont_id.setControl(id);
   pasName.setControl(pas);
   ExamType.setControl(Exm);
   ExamValue.setControl(val);
   Doctor.setControl(doc);
  Time.setControl(time);
   Date.setControl(date);
   Tablecell = new Cell[]
   {pasName , ExamType ,ExamValue , Doctor,Time,Date,Pasiont_id};
   }
   
   void LoadSelected_pas(String id ) throws SQLException, ParseException{
        Date d1 = new Date();
       Date d2 = new OtherMethods().AddDate_Day(d1, 1);
      Date.SetWhereDateBetween(setAndor.And, 
             new OtherMethods().ChangeFrmat(d1),
            new OtherMethods().ChangeFrmat(d2));
       Pasiont_id.SetWhere(setwhere.Equl, setAndor.And, id);
       setCells(Tablecell, new Cell[]{ Date, Pasiont_id});
       Load_Fillcondeol(Load_Where());
}
   String getvalue_id  ( int r ){
       
   return " ";
   }
  
   
 public int  getVisetNom(String id ) throws SQLException, ParseException{
    Pasiont_id.SetWhere(setwhere.Equl, setAndor.And, id);
     setCells( new Cell[]{Pasiont_id} , new Cell[]{Pasiont_id});
    return  getcount(Load_Where())+1 ;
             
  
 }
   
   public void Insert_newVisit(String Time ,
 
  String Date ,
  String Doctor,
  String ExamType ,
  String pasName,
  String  Vist_Case,
  String  Pasiont_id
   ,String  ExamValue) throws SQLException, ParseException, IOException{
       
       this.Time.setValue(Time);
       this.Date.setValue(Date);
       this.Doctor.setValue(Doctor);
       this.ExamType.setValue(ExamType);
        this.ExamValue.setValue(ExamValue);
        this.Pasiont_id.setValue(Pasiont_id);
        this.pasName.setValue(pasName);
        this.Vist_Case.setValue(Vist_Case);
        
        
        
       Cell maneCell[] ;
       maneCell= new Cell[]{this.Time , this.Date , 
       this.Doctor , this.ExamType , this.ExamValue , this.Pasiont_id 
       , this.pasName , this.Vist_Case };
       
       
       setCells(maneCell); insert();
       
   
   }
   
   
   
     public void Update_newVisit(
  String  Vist_Case,
  String  id
     ) throws SQLException, ParseException, IOException{
       
              this.ID.setValue(Pasiont_id);
        this.ID.setIsKey(true);      
         this.Vist_Case.setValue(Vist_Case);
       Cell maneCell[] ;
       maneCell= new Cell[]{   
       this.Vist_Case };
  
       setCells(maneCell, ID); update_id(id);

   }
     
     
     public  void  Drob_ELahgz ( String id ) throws SQLException, ParseException, IOException{
         setCells(null, ID);
         delete_id(id);
     }
Z_DataFillShow_swing showDattaFill ;
   public  DefaultTableModel showInmainTable() throws ParseException, SQLException{
    
       Date.setShowInTable(true);
       pasName.setShowInTable(true);
       Date.setCaption("التاريخ"); pasName.setCaption("اسم المريض");
      ExamType.setShowInTable(true,"نوع الحجز");
      Vist_Case.setShowInTable(true,"حالة الزيارة");
       Cell maneCell[] ;
       maneCell= new Cell[]{this.Time , this.Date , 
       this.Doctor , this.ExamType , this.ExamValue , this.Pasiont_id 
       , this.pasName , this.Vist_Case , ID};
       
       
      Date d1 = new Date();
       Date d2 = new OtherMethods().AddDate_Day(d1, 1);
      Date.SetWhereDateBetween(setAndor.And, 
             new OtherMethods().ChangeFrmat(d1),
            new OtherMethods().ChangeFrmat(d2));
       Cell[] Where= new Cell[]{Date} ; 
      
       setCells(maneCell, Where); 
       
datashw = new Z_DataFillShow_swing(maneCell);
datashw.get_Rowslist(Load_Where());
  datashw = showDattaFill(Load_Where());
return datashw.ShowData();
}

    Z_DataFillShow_swing dataTableShow;
    
           void LoadinControl() throws SQLException, ParseException{
    setCells(Tablecell);
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
     Z_DataShow dataShow;

    public String  loadCombo(String type) throws SQLException, ParseException{
  Cell[] dataCells=new Cell[]{
this.Time , this.Date , 
       this.Doctor , this.ExamType , this.ExamValue , this.Pasiont_id 
       , this.pasName , this.Vist_Case , ID};  
  Cell whereCell[]=new Cell[]
  {this.ExamType };
 this.ExamType.SetWhere(setwhere.Equl, setAndor.And, type);
      setCells(dataCells,whereCell);
 dataShow=showDatta(Load_Where());
 return  dataShow.getvalue(ExamValue);
 
  }



}
   

