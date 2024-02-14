 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doctor_Files;


import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import mysql_data_link.ZeftawyTools.Z_connection;



/**
 *
 * @author aman
 */
public class pnl_DoctorData extends javax.swing.JPanel
implements IDataEntery{

public boolean isload= true;
public  String doc_id="1";
  Z_connection z_connection=new Z_connection("aman_doctordatabase","root","");

  AmanDoctorDatabse_doctorData doctorData =new AmanDoctorDatabse_doctorData(z_connection);
    public pnl_DoctorData() {
        try{
        initComponents();
        ShowcomboDoctor();
        LoadData();
   
        
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void LoadData() throws SQLException, ParseException{
    if(isload){
    doctorData.setControl(txt_doctorID, txt_doctorName, txt_doctorDesc, cmb_edu, txt_doctorLoc, txt_doctorAddress);
    doctorData.LoadinControl();
    doc_id = txt_doctorID.getText();
    }
    else{}
    }
    
    void insert(){
        try{
    doctorData.doctorNewDataInsert();}
        catch(Exception e){
            System.out.println(e);
         }
    }
    
    void update(){
    try{
    doctorData.doctorNewDataUpdate(doc_id);
    System.out.println("id "+ doc_id);
    }catch(Exception e){System.err.println(e);}
    }
    
        void delete(){
    try{
    doctorData.deleteData_id(doc_id);
    
        System.out.println("id "+ doc_id);
    }catch(Exception e){System.err.println(e);}
    }

        
public  void movefirst(){doctorData.movefirst();
 doc_id = txt_doctorID.getText();
} 
public void movepre(){doctorData.movepre();
 doc_id = txt_doctorID.getText();}
public  void movenext(){doctorData.movenext();
 doc_id = txt_doctorID.getText();} 
public  void movelast(){doctorData.movelast();
 doc_id = txt_doctorID.getText();}


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        aLable3 = new projict_Class.ALable();
        aLable4 = new projict_Class.ALable();
        aLable5 = new projict_Class.ALable();
        aLable6 = new projict_Class.ALable();
        aLable7 = new projict_Class.ALable();
        aLable8 = new projict_Class.ALable();
        aLable9 = new projict_Class.ALable();
        txt_doctorID = new projict_Class.TxTf();
        txt_doctorName = new projict_Class.TxTf();
        txt_doctorDesc = new projict_Class.TxTf();
        txt_doctorLoc = new projict_Class.TxTf();
        txt_doctorAddress = new projict_Class.TxTf();
        cmb_edu = new projict_Class.ACombobox();
        jButton1 = new javax.swing.JButton();

        aLable3.setText("البيانات الأساسية :");
        aLable3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        aLable4.setText("رقم الطبيب :");

        aLable5.setText("التخصص :");

        aLable6.setText("الوصف :");

        aLable7.setText("اسم الطبيب :");

        aLable8.setText("موقع العيادة :");

        aLable9.setText("عنوان العيادة");

        txt_doctorID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_doctorIDActionPerformed(evt);
            }
        });

        txt_doctorName.setNextFocusableComponent(txt_doctorAddress);

        jButton1.setText("...");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(txt_doctorAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(aLable9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txt_doctorLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(aLable8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmb_edu, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txt_doctorDesc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(aLable5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(aLable6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addComponent(aLable3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addComponent(txt_doctorName, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(aLable7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(27, 27, 27)
                            .addComponent(txt_doctorID, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(aLable4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(46, 46, 46)))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(aLable3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aLable4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_doctorID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aLable7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_doctorName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aLable8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aLable5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmb_edu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(txt_doctorLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aLable9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_doctorDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aLable6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_doctorAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 String test1= JOptionPane.showInputDialog("الرجاء ادخال التخصص الجديد  ");
cmb_edu.addItem(test1);
cmb_edu.getSelectedItem();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_doctorIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_doctorIDActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_txt_doctorIDActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private projict_Class.ALable aLable3;
    private projict_Class.ALable aLable4;
    private projict_Class.ALable aLable5;
    private projict_Class.ALable aLable6;
    private projict_Class.ALable aLable7;
    private projict_Class.ALable aLable8;
    private projict_Class.ALable aLable9;
    private projict_Class.ACombobox cmb_edu;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel3;
    private projict_Class.TxTf txt_doctorAddress;
    private projict_Class.TxTf txt_doctorDesc;
    private projict_Class.TxTf txt_doctorID;
    private projict_Class.TxTf txt_doctorLoc;
    private projict_Class.TxTf txt_doctorName;
    // End of variables declaration//GEN-END:variables

    @Override
    public void Insert() {
insert();    }

    @Override
    public void Update() {
update();    }

    @Override
    public void Delete() {
delete();

    }

    @Override
    public void Addnew() {
txt_doctorID.setText("");
txt_doctorName.setText("");
txt_doctorDesc.setText("");
txt_doctorLoc.setText("");
txt_doctorAddress.setText("");    }
    
    
void ShowcomboDoctor()  {
       try {
     doctorData.ComboFill(cmb_edu, doctorData.edu);
     txt_doctorID.setText(doctorData.getNom(doc_id)+"");
// TODO add your handling code here:
        } catch (SQLException ex) {
            Logger.getLogger(pnl_DoctorData.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("fill compo error"+ex);
        } catch (ParseException ex) {
            Logger.getLogger(pnl_DoctorData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}