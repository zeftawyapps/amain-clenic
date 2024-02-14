/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql_data_link.Doctor;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import mysql_data_link.ZeftawyTools.Z_connection;

/**
 *
 * @author aman
 */
public class pnl_contractDoctor extends javax.swing.JPanel
implements IDataEntery{

public boolean isload= true;
public  String cont_id="1";
  Z_connection z_connection=new Z_connection("aman_doctordatabase","root","");
  //AmanDoctorDatabse_doctorData doctorData =new AmanDoctorDatabse_doctorData(z_connection);
  AmanDoctorDatabse_ContracDoctor contrData=new AmanDoctorDatabse_ContracDoctor(z_connection);
  public pnl_contractDoctor() {
      
        initComponents();
        try{
        loadData();}
        catch(Exception e){System.out.println(e);}
    }
  
  public void loadData() throws SQLException, ParseException{
  if(isload)
  {
  contrData.setControl(txtID, cmb_doctorName, txtedu, txt_contrValue, txt_contrPercent);
  contrData.LoadinControl();
  cont_id=txtID.getText();
  }  else{}
  }
  
  void insert() throws SQLException, ParseException, IOException{
  contrData.doctorNewDataInsert();
  }
  
  void update() throws SQLException, ParseException, IOException{
  contrData.doctorNewDataUpdate(cont_id);
  }
  
  void delete() throws SQLException, ParseException, IOException{
  contrData.deleteData_id(cont_id);
  }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        aLable1 = new projict_Class.ALable();
        aLable2 = new projict_Class.ALable();
        aLable3 = new projict_Class.ALable();
        aLable4 = new projict_Class.ALable();
        aLable5 = new projict_Class.ALable();
        aLable6 = new projict_Class.ALable();
        txtID = new projict_Class.TxTf();
        cmb_doctorName = new projict_Class.ACombobox();
        txtedu = new projict_Class.TxTf();
        txt_contrValue = new projict_Class.TxTf();
        txt_contrPercent = new projict_Class.TxTf();

        aLable1.setText("المتعاقدين مع الطبيب");

        aLable2.setText("اسم الدكتور :");

        aLable3.setText("رقم التعاقد :");

        aLable4.setText("التخصص :");

        aLable5.setText("قيمة التعاقد :");

        aLable6.setText("نسبة التعاقد :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(aLable1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(txtedu, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(aLable4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmb_doctorName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 30, Short.MAX_VALUE)
                                        .addComponent(txt_contrPercent, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(aLable6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txt_contrValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(aLable5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(aLable2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(aLable3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(22, 22, 22))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(aLable1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aLable3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aLable2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmb_doctorName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aLable4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtedu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aLable5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aLable6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_contrValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_contrPercent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private projict_Class.ALable aLable1;
    private projict_Class.ALable aLable2;
    private projict_Class.ALable aLable3;
    private projict_Class.ALable aLable4;
    private projict_Class.ALable aLable5;
    private projict_Class.ALable aLable6;
    private projict_Class.ACombobox cmb_doctorName;
    private projict_Class.TxTf txtID;
    private projict_Class.TxTf txt_contrPercent;
    private projict_Class.TxTf txt_contrValue;
    private projict_Class.TxTf txtedu;
    // End of variables declaration//GEN-END:variables

    @Override
    public void Insert() {
        try{
insert(); }  
           catch(Exception e) 
           {System.out.println(e);}
        }

    @Override
    public void Delete() {
try{delete();}
catch(Exception e){System.out.println(e);}
    }

    @Override
    public void Addnew() {
txtID.setText("");
txtedu.setText("");
txt_contrValue.setText("0");
txt_contrPercent.setText("0");    }

    @Override
    public void Update() {
try{update();}
catch(Exception e){System.out.println(e);}
    }
}
