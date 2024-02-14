package mysql_data_link.Passoin;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import mysql_data_link.ZeftawyTools.*;

/**
 *
 * @author New
 */
public class AmanPasDatabse_PasdataTable extends Z_DataTable {
      
    Cell ID = new Cell("ID");
    Cell Name = new Cell("Name");
    
     Cell DateBirth = new Cell("DateBirth");
      Cell Gender = new Cell("Gender");
      Cell Age=new Cell("Age");
      Cell Status = new Cell("Status");
       Cell Job = new Cell("Job");
       Cell Address = new Cell("Address");
       Cell Gov = new Cell("Gov");
       Cell Mob = new Cell("Mob");
       Cell HomePhone = new Cell("HomePhone");
       
       
       Cell Weight = new Cell("Weight");
       Cell Height = new Cell("Height");
       Cell Suger = new Cell("Suger");
       Cell hymoglobin = new Cell("hymoglobin");
       Cell Blood = new Cell("Blood");
       Cell See = new Cell("See");
       
    
Z_connection conniction ;

    /**
     *
     * @param con
     */
    public AmanPasDatabse_PasdataTable(Z_connection con)  {
       super(con);
        conniction = con;
        setTableName("pasdata_table");
        
        
    }
    
    public  void newPationfile(String Names ) throws SQLException, ParseException, IOException{
      Name.setValue(Names);
        
        Cell [] insertCells;
        insertCells = new Cell[]{  Name};
        setCells(insertCells);
        insert();
    
    }
    public void PasiontmainData(String  Name ,String age,String maritalStatus, String gender , String Databerth , String job
    ,  String Addriss , String gov , String mob , String hphone 
  ,String wigeht , String higeht , String suger, String see , String blood 
            ,String hymglobine
    
    ) throws SQLException, ParseException, IOException{
        
  this.Name.setValue(Name);
  Age.setValue(age);
  Status.setValue(maritalStatus);
    Gender.setValue(gender);
    DateBirth.setValue(Databerth);
    Job.setValue(job);
    Address.setValue(Addriss);
    Gov.setValue(gov);
    Mob.setValue(mob);
    HomePhone.setValue(hphone);
    
        Weight .setValue(wigeht);
         Height .setValue(higeht);
         Suger.setValue(suger);
         hymoglobin .setValue(hymglobine);
         Blood .setValue(blood);
        this.See.setValue(see);
       
     Cell [] maindataCells;
   maindataCells =  new Cell[]{this.Name ,Age,Gender, Job ,DateBirth,
            Address , Gov , Mob , HomePhone
           
           ,Height ,Weight, Suger,See,hymoglobin,Blood
   };
        setCells(maindataCells);
        insert();
    
    }
    
    
    
        public void PasiontmainDataEdite_id( String id ,  String  Name ,String age,String maritalStatus, String gender , String Databerth , String job
    ,  String Addriss , String gov , String mob , String hphone 
  ,String wigeht , String higeht , String suger, String see , String blood 
            ,String hymglobine
    
    ) throws SQLException, ParseException, IOException{
  this.Name.setValue(Name);
  Age.setValue(age);
  Status.setValue(maritalStatus);
    Gender.setValue(gender);
    DateBirth.setValue(Databerth);
    Job.setValue(job);
    Address.setValue(Addriss);
    Gov.setValue(gov);
    Mob.setValue(mob);
    HomePhone.setValue(hphone);
    
        Weight .setValue(wigeht);
         Height .setValue(higeht);
         Suger.setValue(suger);
         hymoglobin .setValue(hymglobine);
         Blood .setValue(blood);
        this.See.setValue(see);
       ID.setIsKey(true);
       ID.setValue(id);
       
       
     Cell [] maindataCells;
   maindataCells =  new Cell[]{this.Name , Age,Gender,Status, Job ,DateBirth,
            Address , Gov , Mob , HomePhone
           
           ,Height ,Weight, Suger,See,hymoglobin,Blood
   };
        setCells(maindataCells, ID);
        update_id(id);
    
    }
    
    
 
    public void deletfile_id( String id ) throws SQLException, ParseException, IOException{
        
        setCells(null, ID);
        delete_id(id);
    
    }
    
    Z_DataShow dataShow ;
    Z_DataFillShow_swing dataTableShow ;
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
public  Z_DataShow LoadFile_id(String id) throws SQLException, ParseException{
       Cell [] maindataCells;
   maindataCells =  new Cell[]{ID,this.Name ,Age,Status,Gender, Job ,DateBirth,
            Address , Gov , Mob , HomePhone
           
           ,Height ,Weight, Suger,See,hymoglobin,Blood
   };
   
   Cell Wherecell[];
   ID.SetWhere(setwhere.Equl, setAndor.And,id);
    Wherecell =  new Cell[]{this.ID };
    setCells(maindataCells,Wherecell);
   dataShow= showDatta(Load_Where());  
   return dataShow;  
  
}
public  DefaultTableModel LoadFile_id_showTableview_name(String id) throws SQLException, ParseException{
       Cell [] maindataCells;
   Name.setShowInTable(true);
   HomePhone.setShowInTable(true);
   Name.setCaption("اسم المريض");
   HomePhone.setCaption("هاتف المنزل");
       maindataCells =  new Cell[]{this.Name  , ID ,HomePhone , Mob
};
   
  if (id == ""){
setCells(maindataCells);

dataTableShow= showDattaFill(Load());
   dataShow = dataTableShow;     
    
}else{   
      
       Cell Wherecell[];
   Name.SetWhere(setwhere.Equl, setAndor.And,id);
   Wherecell =  new Cell[]{this.ID };

   setCells(maindataCells,Wherecell);
    dataTableShow= showDattaFill(Load_Where());  
}
  
  DefaultTableModel m = dataTableShow.ShowData();
  close() ;
   return  m;
  
}

public  DefaultTableModel LoadFile_id_showTableview(String S , Cell cl ) throws SQLException, ParseException{
       Cell [] maindataCells;
   Name.setShowInTable(true);
   HomePhone.setShowInTable(true);
   Name.setCaption("اسم المريض");
   HomePhone.setCaption("هاتف المنزل");
       maindataCells =  new Cell[]{this.Name  , ID ,HomePhone , Mob
};
   
  if (S == ""){
setCells(maindataCells);

dataTableShow= showDattaFill(Load());
        
    
}else{   
      
       Cell Wherecell[];
   cl.SetWhere(setwhere.Like, setAndor.And,"%"+S+"%");
   Wherecell =  new Cell[]{cl };

   setCells(maindataCells,Wherecell);
    dataTableShow= showDattaFill(Load_Where());  
}
  
  DefaultTableModel m = dataTableShow.ShowData();
  close() ;
   return  m;
  
}

public  DefaultTableModel LoadFile_id_showTableview(String id) throws SQLException, ParseException{
       Cell [] maindataCells;
   maindataCells =  new Cell[]{this.Name ,Age,Gender, Job ,DateBirth,
            Address , Gov , Mob , HomePhone
            
   };
   
  if (id == ""){
setCells(maindataCells);

dataTableShow= showDattaFill(Load());
        
    
}else{   
      
       Cell Wherecell[];
   ID.SetWhere(setwhere.Equl, setAndor.And,id);
   Wherecell =  new Cell[]{this.ID };

   setCells(maindataCells,Wherecell);
    dataTableShow= showDattaFill(Load_Where());  
}
  
  DefaultTableModel m = dataTableShow.ShowData();
  close() ;
   return  m;
  
}
public  void ComboFill3 (JComboBox  c , Cell c1) throws SQLException{

    Cell [] cell = {c1};
    setCells(cell);
   
    dataTableShow = new Z_DataFillShow_swing(cell);
    dataTableShow.get_Rowslist(Load()) ;
   dataTableShow.Fillcombo(c, c1);
}

    //LoadFile in Table in pasData
public  DefaultTableModel LoadFile_id_showTableview_name_dataShow(String id) throws SQLException, ParseException{
       Cell [] maindataCells;
   Name.setShowInTable(true);
   ID.setShowInTable(true);
   Name.setCaption("اسم المريض");
   ID.setCaption("رقم المريض");
       maindataCells =  new Cell[]{this.Name  , ID 
};
   
  if (id == ""){
setCells(maindataCells);

dataTableShow= showDattaFill(Load());
        
    
}else{   
      
       Cell Wherecell[];
   Name.SetWhere(setwhere.Equl, setAndor.And,id);
   Wherecell =  new Cell[]{this.ID };

   setCells(maindataCells,Wherecell);
    dataTableShow= showDattaFill(Load_Where());  
}
  
  DefaultTableModel m = dataTableShow.ShowData();
  close() ;
   return  m;
  
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
    ID.SetWhere(setwhere.Equl, setAndor.And, id);
     setCells( new Cell[]{ID} , new Cell[]{ID});
    return  getcount(Load_Where())+1 ;
             
  
 }


}