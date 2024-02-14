
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aman
 */
public class AmanUsersDatabse_users extends Z_DataTable{
    
    Cell USER_ID=new Cell("USER_ID");
    Cell USER=new Cell("USER");
    Cell POWER=new Cell("POWER");
    Cell PASSWORD=new Cell("PASSWORD");
    
    Z_connection connection;
    Cell[] TableCell;
    Cell[] TableinValue;
    
    public AmanUsersDatabse_users(Z_connection con){
    super(con);
    connection=con;
        setTableName("USERS");
    }
    
    public void setControl(IControl user,
            IControl power,IControl pass){
        USER_ID.setIsKey(true);
    
    USER.setControl(user);
    POWER.setControl(power);
    PASSWORD.setControl(pass);
    Cell[] dataCells=new Cell[]{
    USER_ID,USER,POWER,PASSWORD
    };TableCell=dataCells;
    
    dataCells=new Cell[]{
    USER,POWER,PASSWORD
    };TableinValue=dataCells;
    }
    
    public void dataUserInsert() throws SQLException, ParseException, IOException{
        setCells(TableinValue);
        insert();
    }
    
    public void dataUserUpdate(String id) throws SQLException, ParseException, IOException{
        setCells(TableinValue,USER_ID);
        update_id(id);
    }
    
    public void dataUserDelete(String id) throws SQLException, ParseException, IOException{
        setCells(null,USER_ID);
        delete_id(id);
    }
    
           public  Z_DataFillShow_swing LoadFile_id(String id) throws SQLException, ParseException{
       Cell [] maindataCells;
   maindataCells =  new Cell[]{USER_ID,
       USER,POWER,PASSWORD
  
   };
   
   Cell Wherecell[];
   USER_ID.SetWhere(setwhere.Equl, setAndor.And,id);
    Wherecell =  new Cell[]{this.USER_ID};
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
    USER_ID.SetWhere(setwhere.Equl, setAndor.And, id);
     setCells( new Cell[]{USER_ID} , new Cell[]{USER_ID});
    return  getcount(Load_Where())+1 ;
             
  
 }
 
    public String  loadCombo(String id) throws SQLException, ParseException{
  Cell[] dataCells=new Cell[]{
USER_ID,USER,POWER,PASSWORD  };
  Cell whereCell[]=new Cell[]
  {this.USER };
 this.USER.SetWhere(setwhere.Equl, setAndor.And, id);
      setCells(dataCells,whereCell);
 dataShow=showDatta(Load_Where());
 return  dataShow.getvalue(PASSWORD);
 
  }

    
        public String  loadCombo_id(String id) throws SQLException, ParseException{
  Cell[] dataCells=new Cell[]{
USER_ID,USER,POWER,PASSWORD  };
  Cell whereCell[]=new Cell[]
  {this.POWER };
 this.POWER.SetWhere(setwhere.Equl, setAndor.And, id);
      setCells(dataCells,whereCell);
 dataShow=showDatta(Load_Where());
 return  dataShow.getvalue(USER_ID);
 
  }

        


}
