package mysql_data_link.Passoin;


import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import mysql_data_link.ZeftawyTools.Cell;
import mysql_data_link.ZeftawyTools.IControl;
import mysql_data_link.ZeftawyTools.Z_DataFillShow_swing;
import mysql_data_link.ZeftawyTools.Z_DataTable;
import mysql_data_link.ZeftawyTools.Z_connection;
import mysql_data_link.ZeftawyTools.Z_DataShow;
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
public class AmanPasDatabse_ope_srv extends Z_DataTable{
    
    Cell Pasiont_id=new Cell("Pasiont_id");
        Cell PasiontName=new Cell("PasiontName");
    Cell Ope_Date=new Cell("Ope_Date");
    Cell OpeType=new Cell("OpeType");
    Cell OpeNurse=new Cell("OpeNurse");
    Cell OpeDoctor=new Cell("OpeDoctor");
    Cell OpeCost=new Cell("OpeCost");
    Cell Convert_Doc=new Cell("Convert_Doc");
    Cell AssDoctor=new Cell("AssDoctor");
    Cell AnsType=new Cell("AnsType");
    Cell AnsDoctor=new Cell("AnsDoctor");
    Cell TecOpe=new Cell("TecOpe"); 
    Z_connection connection;
    
    Cell [] TablCell;
    public AmanPasDatabse_ope_srv(Z_connection con) {
        super(con);
        connection=con;
        setTableName("pas_dateope");
    }
    
     public void setControl(IControl Pasiont_id,
            IControl PationtName,IControl OpeDate,IControl OpeType,
            IControl OpeNurse,IControl OpeDoctor,
            IControl OpeCost,IControl Convert_Doc,
            IControl AssDoctor,IControl AnsType,
            IControl AnsDoctor, IControl TecOpe) throws SQLException, ParseException {
    
        
        this.Pasiont_id.setControl(Pasiont_id);
        this.Pasiont_id.setIsKey(true);
        PasiontName.setControl(PationtName);
        Ope_Date.setControl(OpeDate);
        this.OpeType.setControl(OpeType);
        this.OpeNurse.setControl(OpeNurse);
        this.OpeDoctor.setControl(OpeDoctor);
        this.OpeCost.setControl(OpeCost);
        this.Convert_Doc.setControl(Convert_Doc);
        this.AssDoctor.setControl(AssDoctor);
        this.AnsType.setControl(AnsType);
        this.AnsDoctor.setControl(AnsDoctor);
        this.TecOpe.setControl(TecOpe);
        Cell[] DataCells=new Cell[]{
        PasiontName,Ope_Date,this.OpeType,
            this.OpeNurse,this.OpeDoctor,this.OpeCost,this.Convert_Doc,
            this.AssDoctor,this.AnsType,this.AnsDoctor,this.TecOpe
  ,this.Pasiont_id};
 
 TablCell = DataCells;
    }
    

    
    public void pastiontData(String Pasiont_id,
            String PationtName,String OpeDate,String OpeType,
            String OpeNurse,String OpeDoctor,
            String OpeCost,String Convert_Doc,
            String AssDoctor,String AnsType,
            String AnsDoctor, String TecOpe) throws SQLException, ParseException, IOException {
    
        
        this.Pasiont_id.setValue(Pasiont_id);
        PasiontName.setValue(PationtName);
        Ope_Date.setValue(OpeDate);
        this.OpeType.setValue(OpeType);
        this.OpeNurse.setValue(OpeNurse);
        this.OpeDoctor.setValue(OpeDoctor);
        this.OpeCost.setValue(OpeCost);
        this.Convert_Doc.setValue(Convert_Doc);
        this.AssDoctor.setValue(AssDoctor);
        this.AnsType.setValue(AnsType);
        this.AnsDoctor.setValue(AnsDoctor);
        this.TecOpe.setValue(TecOpe);
        
        
        Cell[] DataCells=new Cell[]{
        this.Pasiont_id,PasiontName,Ope_Date,this.OpeType,
            this.OpeNurse,this.OpeDoctor,this.OpeCost,this.Convert_Doc,
            this.AssDoctor,this.AnsType,this.AnsDoctor,this.TecOpe
        };
        setCells(DataCells);
        insert();
    }
 public  void insetNewOperation() throws SQLException, ParseException, IOException{
 
     setCells(TablCell);
 insert();
 }
    public void PationtDataEdit(String Pasiont_id,
        String PationtName,String OpeDate,String OpeType,
      String OpeNurse,String OpeDoctor,
       String OpeCost,String Convert_Doc,
      String AssDoctor,String AnsType,
     String AnsDoctor,String TecOpe) throws SQLException, ParseException, IOException {
 

        this.Pasiont_id.setValue(Pasiont_id);
        PasiontName.setValue(PationtName);
        Ope_Date.setValue(OpeDate);
        this.OpeType.setValue(OpeType);
        this.OpeNurse.setValue(OpeNurse);
        this.OpeDoctor.setValue(OpeDoctor);
        this.OpeCost.setValue(OpeCost);
        this.Convert_Doc.setValue(Convert_Doc);
        this.AssDoctor.setValue(AssDoctor);
        this.AnsType.setValue(AnsType);
        this.AnsDoctor.setValue(AnsDoctor);
        this.TecOpe.setValue(TecOpe);
        
    Cell[] DtatCells=new Cell[]{
   PasiontName,Ope_Date,this.OpeType,
        this.OpeNurse,this.OpeDoctor,this.OpeCost,
        this.Convert_Doc,this.AssDoctor,this.AnsType,this.AnsDoctor
    ,this.TecOpe , this.Pasiont_id};
    
            setCells(DtatCells);
        update_id(Pasiont_id);

    }
    
    
 public  void UpdateDataOperation(String id ) throws SQLException, ParseException, IOException{
 
     setCells(TablCell);
     update_id(id);
 }
    
    public void deleteData(String Pationt_id) throws SQLException, ParseException, IOException{
        setCells(null,Pasiont_id);
        delete_id(Pationt_id);
        
    }
     public  void DeleteDataOperation(String id ) throws SQLException, ParseException, IOException{
 
      setCells(null, Pasiont_id);
     delete_id(id);
 }

    
    Z_DataShow dataShow;
    Z_DataFillShow_swing dataTableShow;
    String getValue(Cell cell){
    int i=getDataShow().getCurrentRow();
    if(getDataShow().getCurrentRow()>0)
        return getDataShow().getvalue(i,cell);
    else{return "";}
    }
    
    public Z_DataShow getDataShow(){
    return dataShow;
    }
    
    public Z_DataShow LoadData_id(String Pationt_id) throws SQLException, ParseException{
       Cell[] dataCells=new Cell[]{
    
            PasiontName,Ope_Date, OpeType,
      OpeNurse, OpeDoctor,
      OpeCost, Convert_Doc,
       AssDoctor, AnsType,
     AnsDoctor,TecOpe 
    };
           Cell WhereCell[]=new Cell[]
       {this.Pasiont_id};
    Pasiont_id.SetWhere  (setwhere.Equl, setAndor.And, Pationt_id);
        setCells(dataCells  ,WhereCell);   
        dataShow= showDatta(Load_Where()); 
    return dataShow;
    
    }
    
        public DefaultTableModel loadTable_id_showTable(String Pationt_id) throws SQLException, ParseException
    {
          PasiontName.setShowInTable(true);
    Cell MainDataCell[]=new Cell[]{PasiontName};
    
    if(Pationt_id=="")
    {setCells(MainDataCell);
    dataTableShow=showDattaFill(Load());}
    else{
    Cell whereCell[];
    Pasiont_id.SetWhere(setwhere.Equl, setAndor.And,Pationt_id );
     whereCell =new Cell[]
             {this.Pasiont_id };
             setCells(MainDataCell,whereCell);
            dataTableShow=showDattaFill(Load_Where());}
    
    DefaultTableModel d=dataTableShow.ShowData();
            close();
            return  d;
    }
        
void LoadinControl() throws SQLException, ParseException{
    setCells(TablCell);
dataTableShow = showDattaFill(Load());
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


    }

