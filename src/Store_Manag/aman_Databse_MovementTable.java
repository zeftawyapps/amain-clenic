 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Store_Manag;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
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
public class aman_Databse_MovementTable extends Z_DataTable{
   
     Cell ID=new Cell("ID");
     Cell code_ID=new Cell("code_ID");
     Cell category=new Cell("category");
     Cell buy_quantity=new Cell("buy_quantity");
     Cell sell_quantity=new Cell("sell_quantity");
     Cell buy_price=new Cell("buy_price");
     Cell sell_price=new Cell("sell_price");
     Cell buy_value=new Cell("buy_value");
     Cell sell_value=new Cell("sell_value");
     Cell bill_Num=new Cell("bill_Num");
     Cell client=new Cell("client");
     Cell client_ID=new Cell("client_ID");
     Cell cgs=new Cell("cgs");
     Cell BBQ=new Cell("BBQ");
     Cell user=new Cell("user");
     Cell Date=new Cell("Date");
     Cell Request=new Cell("Request");
     Cell user_ID=new Cell("user_ID");
     
     Z_connection connection;
     Cell[] TableCell,TableinputCell;
             
     
     public aman_Databse_MovementTable(Z_connection con){
     super (con);
     connection=con;
         setTableName("Movement_Table");
     }
     
     public void setControlBuy(IControl ID,IControl code_id,
             IControl categ,IControl quantityBuy,
             IControl priceBuy,IControl valueBuy,
             IControl BillNum,IControl Request,
             IControl client,IControl client_id,
             IControl user,IControl user_id,
             IControl date){
         
         this.ID.setIsKey(true);
         
     this.ID.setControl(ID);
     
     code_ID.setControl(code_id);
     category.setControl(categ);
    buy_quantity .setControl(quantityBuy);
    buy_price.setControl(priceBuy);
    buy_value.setControl(valueBuy);
    bill_Num.setControl(BillNum);
    this.Request.setControl(Request);
    this.client.setControl(client);
    client_ID.setControl(client_id);
     this.user.setControl(user);
     user_ID.setControl(user_id);
     Date.setControl(date);
    Cell[] dataCells=new Cell[]{
    this.ID,code_ID,category,buy_quantity,buy_price,
        buy_value,bill_Num,this.Request,this.client,
        client_ID,this.user,user_ID,Date
    };
         TableCell=dataCells;
          dataCells=new Cell[]{
         code_ID,category,buy_quantity,buy_price,
        buy_value,bill_Num,this.Request,this.client,
        client_ID,this.user,user_ID,Date
         };
          
          TableinputCell=dataCells;
     }
     
     public void setControlSell(IControl ID,IControl code_id,
            IControl categ,IControl quntitySell, IControl priceSell,
            IControl valueSell,IControl Bill_Num,IControl Request,
            IControl client,IControl client_id,
            IControl user,IControl user_id,IControl date
             ){
     this.ID.setIsKey(true);
     
     this.ID.setControl(ID);
       this.ID.setIsKey(true);
     code_ID.setControl(code_id);
     category.setControl(categ);
    sell_quantity.setControl(quntitySell);
    sell_price.setControl(priceSell);
    sell_value.setControl(valueSell);
    bill_Num.setControl(Bill_Num);
    this.Request.setControl(Request);
    this.client.setControl(client);
    client_ID.setControl(client_id);
    this.user.setControl(user);
    user_ID.setControl(user_id);
    Date.setControl(date);

    Cell[] dataCells=new Cell[]{
    this.ID,code_ID,category,sell_quantity,sell_price,
        sell_value,bill_Num,this.Request,this.client,
        client_ID,this.user,user_ID,Date
    };
     TableCell=dataCells;
     
     dataCells=new Cell[]{
     code_ID,category,sell_quantity,sell_price,
        sell_value,bill_Num,this.Request,this.client,
        client_ID,this.user,user_ID,Date
     };
     TableinputCell=dataCells;
     }
     
     public void setControl_SellCgs(IControl ID,IControl code_id,
            IControl categ,IControl quntitySell, IControl priceSell,
            IControl valueSell,IControl Bill_Num,IControl Request,
            IControl client,IControl client_id,
            IControl user,IControl user_id,IControl date,
            IControl cgs){
          this.ID.setIsKey(true);
     
     this.ID.setControl(ID);
       this.ID.setIsKey(true);
     code_ID.setControl(code_id);
     category.setControl(categ);
    sell_quantity.setControl(quntitySell);
    sell_price.setControl(priceSell);
    sell_value.setControl(valueSell);
    bill_Num.setControl(Bill_Num);
    this.Request.setControl(Request);
    this.client.setControl(client);
    client_ID.setControl(client_id);
    this.user.setControl(user);
    user_ID.setControl(user_id);
    Date.setControl(date);
    this.cgs.setControl(cgs);
    
    Cell[] dataCells=new Cell[]{
    this.ID,code_ID,category,sell_quantity,sell_price,
        sell_value,bill_Num,this.Request,this.client,
        client_ID,this.user,user_ID,Date,this.cgs
    };
     TableCell=dataCells;
     
     dataCells=new Cell[]{
     code_ID,category,sell_quantity,sell_price,
        sell_value,bill_Num,this.Request,this.client,
        client_ID,this.user,user_ID,Date,this.cgs
     };
    TableinputCell =dataCells;
     }

 public void setControl_BBQ(IControl ID,
     IControl code_id, IControl categ,
     IControl date,IControl request,
     IControl billNum,IControl buyPrice,IControl buyQuqntity,
     IControl sellPrice,IControl sellQuantity){
     
         this.ID.setControl(ID);
           this.ID.setIsKey(true);
         code_ID.setControl(code_id);
         category.setControl(categ);
         Date.setControl(date);
         Request.setControl(request);
         bill_Num.setControl(billNum);
         buy_price.setControl(buyPrice);
         buy_quantity.setControl(buyQuqntity);
         sell_price.setControl(sellPrice);
         sell_quantity.setControl(sellQuantity);
     
         Cell[] datacells=new Cell[]{
         this.ID,code_ID,category,Date,Request,bill_Num,
             buy_price,buy_quantity,sell_price,sell_quantity
         
         };
         TableCell=datacells;
         
         datacells=new Cell[]{
         code_ID,category,Date,Request,bill_Num,
             buy_price,buy_quantity,sell_price,sell_quantity
         };
        TableinputCell=datacells;
     }
     
   
     public void NewDataInsert() throws SQLException, ParseException, IOException{
         setCells(TableinputCell);
         insert();
     }
     
     
   
     public void NewDataUpdate(String id) throws SQLException, ParseException, IOException{
         setCells(TableinputCell,ID);
         update_id(id);
     }

     public void DeleteData(String id) throws SQLException, ParseException, IOException{
         setCells(null,ID);
         delete_id(id);
     }
     
     Z_DataShow dataShow;
     Z_DataFillShow_swing dataTableShow;
     
     public Z_DataShow LoadData_id() throws SQLException, ParseException{
           Cell[] dataCells=new Cell[]{
     ID,code_ID,category,buy_quantity,sell_quantity,
         buy_price,sell_price,buy_value,sell_value,
         bill_Num,this.client,client_ID,this.cgs,
         this.BBQ,this.user,Date,Request,user_ID
     };

         setCells(dataCells);
     dataShow=showDatta(Load_Where());
     return  dataShow;
     }
 
    void LoadinControl() throws SQLException, ParseException{
        setCells(TableCell);
        dataTableShow=showDattaFill(Load());
    dataTableShow.FillControls();
    }
    
    public  DefaultTableModel LoadFile_id_showTableview_nameBuy(String id) throws SQLException, ParseException{
       Cell [] dataCells;
       category.setShowInTable(true);
       buy_quantity.setShowInTable(true);
       buy_price.setShowInTable(true);
       buy_value.setShowInTable(true);
       bill_Num.setShowInTable(true);
       Request.setShowInTable(true);
       client.setShowInTable(true);
       client_ID.setShowInTable(true);
       user.setShowInTable(true);
       user_ID.setShowInTable(true);
       Date.setShowInTable(true);
       
   category.setCaption("اسم الصنف");
   buy_quantity.setCaption("كمية الشراء ");
   buy_price.setCaption(" سعر الشراء");
   buy_value.setCaption("قيمة الشراء ");
   bill_Num.setCaption(" رقم الفاتورة");
   Request.setCaption(" حالة الطلب");
   client.setCaption(" المريض");
   client_ID.setCaption(" رقم المريض");
   user.setCaption("المستخدم ");
   user_ID.setCaption("رقم المستخدم ");
   Date.setCaption("تاريخ الشراء ");
   
    dataCells =new Cell[]{this.category,buy_quantity ,
        buy_price,buy_value,bill_Num,Request,client,
        client_ID,user,user_ID,Date
};
   
  if (id == ""){
setCells(dataCells);

dataTableShow= showDattaFill(Load());
   dataShow = dataTableShow;     
    
}else{   
      
       Cell Wherecell[];
   ID.SetWhere(setwhere.Equl, setAndor.And,id);
   Wherecell =  new Cell[]{this.ID };

   setCells(dataCells,Wherecell);
    dataTableShow= showDattaFill(Load_Where());  
}
  
  DefaultTableModel m = dataTableShow.ShowData();
  close() ;
   return  m;
   }

    
public  DefaultTableModel LoadFile_id_showTableview_nameSell(String id) throws SQLException, ParseException{
       Cell [] dataCells;
       
       category.setShowInTable(true,"اسم الصنف");
       sell_quantity.setShowInTable(true,"كمية البيع");
       sell_price.setShowInTable(true,"سعر البيع");
       sell_value.setShowInTable(true,"قيمة البيع");
       bill_Num.setShowInTable(true,"رقم الفاتورة");
       Request.setShowInTable(true,"حالة الطلب");
       client.setShowInTable(true,"إسم المريض");
       client_ID.setShowInTable(true,"رقم المريض");
       user.setShowInTable(true,"المستخدم");
       user_ID.setShowInTable(true,"رقم المستخدم");
       Date.setShowInTable(true,"تاريخ البيع");
       
    dataCells =new Cell[]{this.category,sell_quantity ,
        sell_price,sell_value,bill_Num,Request,client,
        client_ID,user,user_ID,Date
};
   
  if (id == ""){
setCells(dataCells);

dataTableShow= showDattaFill(Load());
   dataShow = dataTableShow;     
    
}else{   
      
       Cell Wherecell[];
   ID.SetWhere(setwhere.Equl, setAndor.And,id);
   Wherecell =  new Cell[]{this.ID };

   setCells(dataCells,Wherecell);
    dataTableShow= showDattaFill(Load_Where());  
}
  
  DefaultTableModel m = dataTableShow.ShowData();
  close() ;
   return  m;
        }
        
        
    public  DefaultTableModel LoadFile_id_showTableview_nameCgs(String id) throws SQLException, ParseException{
       Cell [] dataCells;
       category.setShowInTable(true,"اسم الصنف");
       sell_quantity.setShowInTable(true,"كمية البيع");
       sell_price.setShowInTable(true,"سعر البيع");
       sell_value.setShowInTable(true,"قيمة البيع");
       bill_Num.setShowInTable(true,"رقم الفاتورة");
       Request.setShowInTable(true,"حالة الطلب");
       client.setShowInTable(true,"إسم المريض");
       client_ID.setShowInTable(true,"رقم المريض");
       user.setShowInTable(true,"المستخدم");
       user_ID.setShowInTable(true,"رقم المستخدم");
       Date.setShowInTable(true,"تاريخ البيع");
       cgs.setShowInTable(true, "تكلفة البضاعة المباعة");
    dataCells =new Cell[]{this.category,sell_quantity ,
        sell_price,sell_value,bill_Num,Request,client,
        client_ID,user,user_ID,Date,
};
   
  if (id == ""){
setCells(dataCells);

dataTableShow= showDattaFill(Load());
   dataShow = dataTableShow;     
    
}else{   
      
       Cell Wherecell[];
   ID.SetWhere(setwhere.Equl, setAndor.And,id);
   Wherecell =  new Cell[]{this.ID };

   setCells(dataCells,Wherecell);
    dataTableShow= showDattaFill(Load_Where());  
}
  
  DefaultTableModel m = dataTableShow.ShowData();
  close() ;
   return  m;
        }


   public  DefaultTableModel LoadFile_id_showTableview_nameBBQ(String id) throws SQLException, ParseException{
       Cell [] dataCells;
       category.setShowInTable(true,"اسم الصنف");
       buy_quantity.setShowInTable(true, "كمية الشراء");
       buy_price.setShowInTable(true, "سعر الشراء");
       sell_quantity.setShowInTable(true,"كمية البيع");
       sell_price.setShowInTable(true,"سعر البيع");
       bill_Num.setShowInTable(true,"رقم الفاتورة");
       Request.setShowInTable(true,"حالة الطلب");
       client.setShowInTable(true,"إسم المريض");
       client_ID.setShowInTable(true,"رقم المريض");
       user.setShowInTable(true,"المستخدم");
       user_ID.setShowInTable(true,"رقم المستخدم");
       Date.setShowInTable(true,"تاريخ البيع");
     
    dataCells =new Cell[]{this.category,buy_quantity,
        sell_quantity ,buy_price,
        sell_price,bill_Num,Request,client,
        client_ID,user,user_ID,Date
};
   
  if (id == ""){
setCells(dataCells);

dataTableShow= showDattaFill(Load());
   dataShow = dataTableShow;     
    
}else{   
      
       Cell Wherecell[];
   ID.SetWhere(setwhere.Equl, setAndor.And,id);
   Wherecell =  new Cell[]{this.ID };

   setCells(dataCells,Wherecell);
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


}
     

