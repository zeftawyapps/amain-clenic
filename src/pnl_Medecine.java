
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import mysql_data_link.ZeftawyTools.Toast;
import mysql_data_link.ZeftawyTools.Z_connection;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aman
 */
public class pnl_Medecine extends javax.swing.JPanel
implements IDataEntery{

    Z_connection z_connection=new Z_connection("aman_pasiontdatabase","root","");
  AmanPasDatabse_medecine dataMedecine=new AmanPasDatabse_medecine(z_connection);
 
  
  public boolean isload=true;
 public String med_id = "1" , med_Name ,med_treat ;
    public pnl_Medecine() {
        initComponents();
        try{
        loadData();
        SearchEvent();
        }catch(Exception e){System.out.println(e);}
    }
    
    void loadData() throws SQLException, ParseException{
       dataMedecine.setControl(txt_Name, txt_treat);
    if(isload){
    Tble_showData.setModel(dataMedecine.showInTable(""));
        }
    else{}
    }
    
    void SearchEvent(){
    txt_SearchName.getDocument().addDocumentListener(new DocumentListener() {
       String s="";
        
        @Override
        public void insertUpdate(DocumentEvent e) {
          s=txt_SearchName.getText();
           try {
               med_SaarchName(s);
           } catch (SQLException ex) {
               Logger.getLogger(pnl_Medecine.class.getName()).log(Level.SEVERE, null, ex);
           } catch (ParseException ex) {
               Logger.getLogger(pnl_Medecine.class.getName()).log(Level.SEVERE, null, ex);
           }
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
        s=txt_SearchName.getText();
           try {
               med_SaarchName(s);
           } catch (SQLException ex) {
               Logger.getLogger(pnl_Medecine.class.getName()).log(Level.SEVERE, null, ex);
           } catch (ParseException ex) {
               Logger.getLogger(pnl_Medecine.class.getName()).log(Level.SEVERE, null, ex);
           }
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
         s=txt_SearchName.getText();
        }
    });
    }
    
     void med_SaarchName(String s) throws SQLException, ParseException{
Tble_showData.setModel(dataMedecine.LoadFile_id_showTableview(s,dataMedecine.medecine));
 
 }   
     
     void insert(){
         try{
     dataMedecine.dataMedecineInsert();}
         catch(Exception e){System.out.println(e);}
     }
     
     void update(){
     try{
     dataMedecine.dataMedecineUpdate(med_id);
     }
     catch(Exception e){System.out.println(e);}
     }
     
     void delete(){
     try{
     dataMedecine.dataMedecineDelete(med_id);
     }
     catch(Exception e){System.out.println(e);}
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
        txt_SearchName = new projict_Class.TxTf();
        txt_searchID = new projict_Class.TxTf();
        jPanel2 = new javax.swing.JPanel();
        aLable3 = new projict_Class.ALable();
        aLable4 = new projict_Class.ALable();
        txt_Name = new projict_Class.TxTf();
        txt_treat = new projict_Class.TxTf();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tble_showData = new javax.swing.JTable();
        btnSave1 = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnSave2 = new javax.swing.JButton();

        aLable1.setText("اسم الدواء :");

        aLable2.setText("رقم الدواء :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_SearchName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_searchID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(aLable1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aLable2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aLable1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_SearchName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_searchID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aLable2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        aLable3.setText("اسم الدواء :");

        aLable4.setText("الطلب :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txt_Name, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                    .addComponent(txt_treat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(aLable3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aLable4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(aLable3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aLable4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_treat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        Tble_showData.setModel(new javax.swing.table.DefaultTableModel(
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
        Tble_showData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tble_showDataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tble_showData);

        btnSave1.setText("اضافة جديد");
        btnSave1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSave1ActionPerformed(evt);
            }
        });

        btnSave.setText("حذف");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnSave2.setText("حفظ");
        btnSave2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSave2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSave)
                .addGap(4, 4, 4)
                .addComponent(btnSave2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSave1)
                .addGap(66, 66, 66))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSave1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSave)
                        .addComponent(btnSave2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                .addGap(52, 52, 52))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void Tble_showDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tble_showDataMouseClicked
   int row = Tble_showData.rowAtPoint(evt.getPoint());

        int col = Tble_showData.columnAtPoint(evt.getPoint());

        String valueInCell = (String)Tble_showData.getValueAt(row, col);

        String id = dataMedecine.dataTableShow.getvalue(row, dataMedecine.medecine_ID);
        String name = dataMedecine.dataTableShow.getvalue(row, dataMedecine.medecine);
        String treat=dataMedecine.dataTableShow.getvalue(row,dataMedecine.treatment);
        System.out.println("Row " +row + " Coll"+ col + "Value"+ valueInCell
            + "id is " + id );
        med_id = id ; med_Name = name ; med_treat=treat;
             
txt_Name.setText(name);
   txt_treat.setText(treat);
     
                                                   


    }//GEN-LAST:event_Tble_showDataMouseClicked

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
Delete();
Toast t=new Toast();
t.Showtoast("تم الحذف");
    }//GEN-LAST:event_btnSaveActionPerformed
boolean isaddnew;
    private void btnSave1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSave1ActionPerformed
    Addnew();
    isaddnew=true;
    Toast t=new Toast();
    t.Showtoast("تم الاضافة");
    }//GEN-LAST:event_btnSave1ActionPerformed

    private void btnSave2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSave2ActionPerformed
       if(isaddnew)
           Insert();
       else{Update();}
       try{
       loadData();      
       Toast t=new Toast();
       t.Showtoast("تم الحفظ");
}
       catch(Exception e){System.out.println(e);}
    }//GEN-LAST:event_btnSave2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tble_showData;
    private projict_Class.ALable aLable1;
    private projict_Class.ALable aLable2;
    private projict_Class.ALable aLable3;
    private projict_Class.ALable aLable4;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSave1;
    private javax.swing.JButton btnSave2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private projict_Class.TxTf txt_Name;
    private projict_Class.TxTf txt_SearchName;
    private projict_Class.TxTf txt_searchID;
    private projict_Class.TxTf txt_treat;
    // End of variables declaration//GEN-END:variables

    @Override
    public void Insert() {
insert();    }

    @Override
    public void Update() {
update();    }

    @Override
    public void Delete() {
delete();    }

    @Override
    public void Addnew() {
txt_Name.setText("");
txt_treat.setText("");    }
}