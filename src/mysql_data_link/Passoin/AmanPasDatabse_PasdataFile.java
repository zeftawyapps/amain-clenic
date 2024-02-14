package mysql_data_link.Passoin;


import java.awt.JobAttributes;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import javax.swing.table.DefaultTableModel;
import mysql_data_link.ZeftawyTools.Cell;
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
public class AmanPasDatabse_PasdataFile extends Z_DataTable{
    Cell ID=new Cell("ID");
    Cell PasData_id = new Cell("PasData_id");
    Cell Name=new Cell("Name");
     Cell NumVist=new Cell("NumVisit");
    Cell TypeService=new Cell("TypeService");
    Cell ExamType=new Cell("ExamType");
    Cell TreatDoctor=new Cell("TreatDoctor");
    Cell TimeVisit=new Cell("TimeVisit");
    Cell DateVisit=new Cell("DateVisit");
    Cell ConvertDoctor=new Cell("ConvertDoctor");
    Cell ExamValue=new Cell("ExamValue");
    Cell MaritalStatus=new Cell("MaritalStatus");
    
    Cell Drugs=new Cell("Drugs");
    Cell NxVstDate=new Cell ("NxVstDate");
    Cell StatueDetails=new Cell("StatueDetails");
    Cell TreatRequest1=new Cell("TreatmentRequst1");
    Cell TreatRequest2=new Cell("TreatmentRequst2");
    Cell TreatRequest3=new Cell("TreatmentRequst3");
    Cell TreatRequest4=new Cell("TreatmentRequst4");
    
    Z_connection connection;
    
    public AmanPasDatabse_PasdataFile(Z_connection con){
    super(con);
    connection =con;
        setTableName("pasfile_table");
    }
    
    public void newPationtFile(String Names) throws SQLException, ParseException, IOException
    {
    Name.setValue(Names);
    Cell[] insertCell=new Cell[]
    {Name};
        setCells(insertCell);
        insert();
    }
    
    public void PationtFileData( String id,String Name ,
       String typeSrv,
     String examType,String treatDoc,String timeVist,
      String dateVist, String nxtVistDate,
      String drugs,
      String details, String TrQust1,String TrQust2,
     String TrQust3,String TrQust4) throws SQLException, ParseException, IOException          
{
    ID.setValue(id);
   this.Name.setValue(Name);//1
   TypeService.setValue(typeSrv);//2
   ExamType.setValue(examType); //3
   TreatDoctor.setValue(treatDoc); //4
   TimeVisit.setValue(timeVist); //5
   DateVisit.setValue(dateVist); //6
 NxVstDate.setValue(nxtVistDate);  //7
 Drugs.setValue(drugs); //8
   StatueDetails.setValue(details); //9
   TreatRequest1.setValue(TrQust1); //10
      TreatRequest2.setValue(TrQust2); //11
   TreatRequest3.setValue(TrQust3); //12
   TreatRequest4.setValue(TrQust4); //13

   Cell[] MainDataCells=new Cell[]
   {
  this.Name,TypeService,ExamType,TreatDoctor,TimeVisit,
   DateVisit,ConvertDoctor,ExamValue,MaritalStatus,Drugs,
   NxVstDate,StatueDetails,TreatRequest1,TreatRequest2,
   TreatRequest3,TreatRequest4};
   
    setCells(MainDataCells);
    insert();
    }
    
    public void PasiontFileDataEdit(String id,String name,
            String typeSrv,
            String examType,String treatDoc,String timeVist,
            String dateVist,String nxVstDate,
            String drugs,
            String details,String TrRqst1,String TrRqst2,
            String TrRqust3,String TrRqust4) throws SQLException, ParseException, IOException{
        ID.setValue(id);
        
        Name.setValue(name);
        TypeService.setValue(typeSrv);
        ExamType.setValue(examType);
        TreatDoctor.setValue(treatDoc);
        TimeVisit.setValue(timeVist);
         DateVisit.setValue(dateVist);
      NxVstDate.setValue(nxVstDate); 
      Drugs.setValue(drugs);
      StatueDetails.setValue(details);
        TreatRequest1.setValue(TrRqst1);
        TreatRequest2.setValue(TrRqst2);
        TreatRequest3.setValue(TrRqust3);
        TreatRequest4.setValue(TrRqust4);
        
        ID.setIsKey(true);
        ID.setValue(id);
        
        Cell[] MainDataCells=new Cell[]
        {
        Name,TypeService,ExamType,TreatDoctor,
            TimeVisit,DateVisit,ConvertDoctor,ExamValue,
           Drugs,NxVstDate,StatueDetails,
            TreatRequest1,TreatRequest2,TreatRequest3,TreatRequest4
        };
        setCells(MainDataCells,ID);
        update_id(id);
    
    }
    
    public void DeleteFile(String id) throws SQLException, ParseException, IOException
    {
        setCells(null,ID);
        delete_id(id);
    }
    
     
    
    Z_DataShow dataShow;
    Z_DataFillShow_swing dataTableShow;
    String getValue(Cell cell){
       int r = getDataShow().getCurrentRow();
  if (getDataShow().getRowcount()>0){
    return getDataShow().getvalue(r, cell);}
  
  else{
      return   "";
  }
    }
        public Z_DataShow getDataShow()
    {
    return dataShow;
    }

    
    public Z_DataShow LoadFile_id(String id) throws SQLException, ParseException
    {
       Cell[] MainDataCells=new Cell[]
   {
  this.Name,NumVist,TypeService,ExamType,TreatDoctor,
              ConvertDoctor  ,TimeVisit,
   DateVisit,   NxVstDate,Drugs,StatueDetails,
TreatRequest1,TreatRequest2,
   TreatRequest3,TreatRequest4 , PasData_id};

       Cell WhereCell[]=new Cell[]
       {this.PasData_id};
       PasData_id.SetWhere(setwhere.Equl, setAndor.And, id);
        setCells(MainDataCells  ,WhereCell);   
        dataShow= showDatta(Load_Where()); 
    return dataShow;
    }
    

    
    public DefaultTableModel loadTable_id_showTable(String id) throws SQLException, ParseException
    {
          Name.setShowInTable(true);
    Cell MainDataCell[]=new Cell[]{Name};
    
    if(id=="")
    {setCells(MainDataCell);
    dataTableShow=showDattaFill(Load());}
    else{
    Cell whereCell[];
    ID.SetWhere(setwhere.Equl, setAndor.And, id);
     whereCell =new Cell[]
             {this.ID };
             setCells(MainDataCell,whereCell);
            dataTableShow=showDattaFill(Load_Where());}
    
    DefaultTableModel d=dataTableShow.ShowData();
            close();
            return  d;
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

