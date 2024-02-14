/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Store_Manag;

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
public class amanDatabse_store_categorisRecord extends Z_DataTable{

    Cell code_ID=new Cell("code_ID");
    Cell category_ID=new Cell("category_ID");
    Cell category_name=new Cell("category_name");
    Cell category_Type=new Cell("category_Type");
    Cell category_unit=new Cell("category_unit");
    Cell price_buy=new Cell("price_buy");
    Cell price_sell=new Cell("price_sell");
    Cell Request=new Cell ("Request");
    Z_connection connection;
    
    Cell[] TableCell , TableInputCell;
    public amanDatabse_store_categorisRecord (Z_connection con){
    super(con);
    connection=con;
        setTableName("storage_categories");
    }
    
    public void setControl(IControl categ_ID,
            IControl categ_name,IControl categ_type,
            IControl categ_unit,IControl price_buy,
            IControl price_sell,IControl requst ,
    IControl  Code ){
        
        category_ID.setIsKey(true);
        
  category_ID.setControl(categ_ID);
  category_name.setControl(categ_name);
  category_Type.setControl(categ_type);
  category_unit.setControl(categ_unit);
  this.price_buy.setControl(price_buy);
  this.price_sell.setControl(price_sell);
  code_ID.setControl(Code);
  Request.setControl(requst);
    
  Cell[] DataCell=new Cell[]{
  category_ID,code_ID , category_name,category_Type,
      category_unit,this.price_buy,this.price_sell,
          Request
  };
  TableCell=DataCell;
    DataCell=new Cell[]{
 code_ID, category_name,category_Type,
      category_unit,this.price_buy,this.price_sell,
          Request 
  };
  TableInputCell = DataCell;
    }
    
    
    public void insertDataCategory() throws SQLException, ParseException, IOException{
        setCells(TableInputCell);
        insert();
    }
    
    
    public void updateDataCategory(String id) throws SQLException, ParseException, IOException{
        setCells(TableInputCell,category_ID);
        update_id(id);
    }
    
    
    public void deleteDataCategory(String id) throws SQLException, ParseException, IOException{
        setCells(null,category_ID);
        delete_id(id);
    }
    
    Z_DataShow dataShow;
    Z_DataFillShow_swing dataTableShow;
    
    public Z_DataFillShow_swing LoadData_id(String id) throws SQLException, ParseException{
    Cell[] dataCells=new Cell[]{
    code_ID,category_name,
        category_Type,category_unit,price_buy,
        price_sell,Request
    };
    
    Cell[] whereCell=new Cell[]{category_ID};
    category_ID.SetWhere(setwhere.Equl, setAndor.And, id);
        setCells(dataCells,whereCell);
        dataTableShow=showDattaFill(Load_Where());
        return dataTableShow;
    } 
 
    
    
       public Z_DataShow LoadData_id() throws SQLException, ParseException{
    Cell[] dataCells=new Cell[]{
    code_ID,category_ID,category_name,
        category_Type,category_unit,price_buy,
        price_sell,Request
    };
    
 
        setCells(dataCells);
        dataShow=showDatta(Load_Where());
        return dataShow;
    } 
 
    void LoadinControl() throws SQLException, ParseException{
        setCells(TableCell);
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
    category_ID.SetWhere(setwhere.Equl, setAndor.And, id);
     setCells( new Cell[]{category_ID} , new Cell[]{category_ID});
    return  getcount(Load_Where())+1 ;
             
  
 }
 
   public String  loadCombo(String service) throws SQLException, ParseException{
  Cell[] dataCells=new Cell[]{
    code_ID,category_ID,category_name,
        category_Type,category_unit,price_buy,
        price_sell,Request
  };
  Cell whereCell[]=new Cell[]
  {this.category_Type };
 this.category_Type.SetWhere(setwhere.Equl, setAndor.And, service);
      setCells(dataCells,whereCell);
 dataShow=showDatta(Load_Where());
 return  dataShow.getvalue(category_name);
 
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
