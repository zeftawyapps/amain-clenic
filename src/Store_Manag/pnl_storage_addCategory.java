/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Store_Manag;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import mysql_data_link.ZeftawyTools.Toast;
import mysql_data_link.ZeftawyTools.Z_connection;

/**
 *
 * @author aman
 */
public class pnl_storage_addCategory extends javax.swing.JPanel
implements IDataEntery{

        Z_connection z_connection=new Z_connection("aman_doctordatabase","root","");
    amanDatabse_store_categorisRecord  dataCateg=new amanDatabse_store_categorisRecord(z_connection);
  public boolean isload=true;
 public String Codeid = "1" , categ_Name ,categ_Req ;
public  String Payprice , sellprice ;
    /**
     * Creates new form pnl_storage_addCategory
     */
    public pnl_storage_addCategory() {
        initComponents();
       try{
       loadData();
       SearchEvent();
       }
       catch(Exception e){System.out.println(e);}
    }
    
    void loadData() throws SQLException, ParseException{
   //dataCateg.setControl(txt_categName, txt_categRequire);
    if(isload){
//        TbleShowData.setModel(dataCateg.showTable());
    }
    else{}
    }
    
        void SearchEvent(){
    txt_searchName.getDocument().addDocumentListener(new DocumentListener() {
       String s="";
        
        @Override
        public void insertUpdate(DocumentEvent e) {
          s=txt_searchName.getText();
           try {
               categ_SaarchName(s);
           } catch (SQLException ex) {
               Logger.getLogger(pnl_storage_addCategory.class.getName()).log(Level.SEVERE, null, ex);
           } catch (ParseException ex) {
               Logger.getLogger(pnl_storage_addCategory.class.getName()).log(Level.SEVERE, null, ex);
           }
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
        s=txt_searchName.getText();
           try {
               categ_SaarchName(s);
           } catch (SQLException ex) {
               Logger.getLogger(pnl_storage_addCategory.class.getName()).log(Level.SEVERE, null, ex);
           } catch (ParseException ex) {
               Logger.getLogger(pnl_storage_addCategory.class.getName()).log(Level.SEVERE, null, ex);
           }
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
         s=txt_searchName.getText();
        }
    });
    }
    
     void categ_SaarchName(String s) throws SQLException, ParseException{
//TbleShowData.setModel(dataCateg.LoadFile_id_showTableview(s,dataCateg.category_name));
 
 }
     
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        aLable1 = new projict_Class.ALable();
        aLable2 = new projict_Class.ALable();
        txt_searchName = new projict_Class.TxTf();
        txt_searchID = new projict_Class.TxTf();
        jPanel2 = new javax.swing.JPanel();
        aLable3 = new projict_Class.ALable();
        aLable4 = new projict_Class.ALable();
        txt_categName = new projict_Class.TxTf();
        txt_categRequire = new projict_Class.TxTf();
        jScrollPane1 = new javax.swing.JScrollPane();
        TbleShowData = new javax.swing.JTable();

        aLable1.setText("اسم الصنف :");

        aLable2.setText("رقم الصنف :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_searchName, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(aLable1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_searchID, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(aLable2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aLable1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_searchName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aLable2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_searchID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        aLable3.setText("اسم الصنف :");

        aLable4.setText("كود الصنف");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_categName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_categRequire, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(aLable4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aLable3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aLable3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_categName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aLable4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_categRequire, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TbleShowData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TbleShowData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbleShowDataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TbleShowData);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
boolean isAddnew=true;
    private void TbleShowDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbleShowDataMouseClicked
          int row = TbleShowData.rowAtPoint(evt.getPoint());

        int col = TbleShowData.columnAtPoint(evt.getPoint());

        String valueInCell = (String)TbleShowData.getValueAt(row, col);

        String code = dataCateg.dataTableShow.getvalue(row, dataCateg.code_ID);
        String name = dataCateg.dataTableShow.getvalue(row, dataCateg.category_name);
       String PayP = dataCateg.dataTableShow.getvalue(row, dataCateg.price_buy);   
       String sellP = dataCateg.dataTableShow.getvalue(row, dataCateg.price_sell);
            
txt_categName.setText(name);
   txt_categRequire.setText(code);
    Codeid = code ;
    categ_Name = name ;
    Payprice=PayP;
   sellprice= sellP;

    }//GEN-LAST:event_TbleShowDataMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TbleShowData;
    private projict_Class.ALable aLable1;
    private projict_Class.ALable aLable2;
    private projict_Class.ALable aLable3;
    private projict_Class.ALable aLable4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private projict_Class.TxTf txt_categName;
    private projict_Class.TxTf txt_categRequire;
    private projict_Class.TxTf txt_searchID;
    private projict_Class.TxTf txt_searchName;
    // End of variables declaration//GEN-END:variables

    @Override
    public void Insert() {
//        insert();
 }

    @Override
    public void Update() {
    //    update();
 }

    @Override
    public void Delete() {
     //   delete();
 }

    @Override
    public void Addnew() {
txt_categName.setText("");
txt_categRequire.setText("");    }
}
