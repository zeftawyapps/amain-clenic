


import mysql_data_link.Passoin.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import mysql_data_link.ZeftawyTools.OtherMethods;
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
public class pnl_insert_opeSrv extends javax.swing.JPanel
 implements  IDataEntery{ 

    public boolean isload= true;
public  String Pas_id="2"; public  String Pas_name ;
   Z_connection z_connection=new Z_connection("aman_pasiontdatabase","root","");
       AmanPasDatabse_PasdataTable pasDatabse =new AmanPasDatabse_PasdataTable(z_connection);
       AmanPasDatabse_ope_srv pas_ope_srv=new AmanPasDatabse_ope_srv(z_connection);
         
       /**
     * Creates new form _insert_opeSrv
     */
    public pnl_insert_opeSrv() {
        try{
        initComponents();
     showCombo();
      // loadData();
        }
        
        catch(Exception e)
        {System.out.println("Load error "+ e);}
    }
    
    
    
    public void loadData() throws SQLException, ParseException{

if (isload){
     txtPas_ID.setText(Pas_id);
     txtPas_Name.setText(Pas_name);
pas_ope_srv.setControl(txtPas_ID, txtPas_Name, ClnOpe_Date, Cmb_opeType, Cmbope_Nurse, Cmbope_Doctor, txt_opeCost, CmbConvrt_Doc, CmbAssist_Doctor, CmbAnthes_Type, CmbAneths_Doctor, Cmbope_Technical);
//pas_ope_srv.LoadinControl();

}
else{
    
     txtPas_ID.setText(Pas_id);
     txtPas_Name.setText(Pas_name);
pas_ope_srv.setControl(txtPas_ID, txtPas_Name, ClnOpe_Date, Cmb_opeType, Cmbope_Nurse, Cmbope_Doctor, txt_opeCost, CmbConvrt_Doc, CmbAssist_Doctor, CmbAnthes_Type, CmbAneths_Doctor, Cmbope_Technical);
//pas_ope_srv.LoadinControl();
} 
    }
    
    
    void insert(){
try{ pas_ope_srv.insetNewOperation();
}catch(Exception ex){
    System.out.println("insert opration error "+ ex);
}
}
    
    void update(){
    try{pas_ope_srv.UpdateDataOperation(Pas_id);}
    catch(Exception e){System.out.println(e);}
    }
    
        void delete(){
    try{pas_ope_srv.DeleteDataOperation(Pas_id);}
    catch(Exception e){System.out.println(e);}
    }

 
void showCombo(){
    try{
    pas_ope_srv.ComboFill(CmbConvrt_Doc, pas_ope_srv.Convert_Doc);
 pas_ope_srv.ComboFill(Cmb_opeType, pas_ope_srv.OpeType);
 pas_ope_srv.ComboFill(CmbAneths_Doctor, pas_ope_srv.AnsDoctor);
pas_ope_srv.ComboFill(CmbAnthes_Type, pas_ope_srv.AnsType);
pas_ope_srv.ComboFill(Cmbope_Doctor, pas_ope_srv.OpeDoctor);
pas_ope_srv.ComboFill(Cmbope_Nurse, pas_ope_srv.OpeNurse);
pas_ope_srv.ComboFill(CmbAssist_Doctor, pas_ope_srv.AssDoctor);
pas_ope_srv.ComboFill(Cmbope_Technical, pas_ope_srv.TecOpe);


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
        jLabel1 = new javax.swing.JLabel();
        Lbl_opeType = new javax.swing.JLabel();
        Lbl_AnethDoctor = new javax.swing.JLabel();
        Lbl_opeDoctor = new javax.swing.JLabel();
        Lbl_AssistDoctor = new javax.swing.JLabel();
        Lbl_opeCost = new javax.swing.JLabel();
        Lbl_AnesthType = new javax.swing.JLabel();
        Lbl_opeNurse = new javax.swing.JLabel();
        Lbl_opeTechnical = new javax.swing.JLabel();
        LblPas_ID = new javax.swing.JLabel();
        LblPas_Name = new javax.swing.JLabel();
        LblOpe_Date = new javax.swing.JLabel();
        LblConrt_Doc = new javax.swing.JLabel();
        txtPas_ID = new projict_Class.TxTf();
        txtPas_Name = new projict_Class.TxTf();
        txt_opeCost = new projict_Class.TxTf();
        ClnOpe_Date = new projict_Class.ACalender();
        CmbConvrt_Doc = new projict_Class.ACombobox();
        CmbAneths_Doctor = new projict_Class.ACombobox();
        Cmbope_Doctor = new projict_Class.ACombobox();
        CmbAssist_Doctor = new projict_Class.ACombobox();
        Cmb_opeType = new projict_Class.ACombobox();
        CmbAnthes_Type = new projict_Class.ACombobox();
        Cmbope_Nurse = new projict_Class.ACombobox();
        Cmbope_Technical = new projict_Class.ACombobox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tble_ope_Data = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtTotal_Revenue = new javax.swing.JTextField();
        LblNotce_Doc = new javax.swing.JLabel();
        txtNotice_Doc = new javax.swing.JTextField();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("بيانات العمليات :");

        Lbl_opeType.setText("نوع العملية :");

        Lbl_AnethDoctor.setText("طبيب التخدير :");

        Lbl_opeDoctor.setText("طبيب العملية  :");

        Lbl_AssistDoctor.setText("الطبيب المساعد :");

        Lbl_opeCost.setText("تكلفة العمليات :");

        Lbl_AnesthType.setText("نوع التخدير :");

        Lbl_opeNurse.setText("ممرضة العمليات :");

        Lbl_opeTechnical.setText("فنى عمليات :");

        LblPas_ID.setText("رقم المريض :");

        LblPas_Name.setText("اسم المريض :");

        LblOpe_Date.setText("تاريخ العملية :");

        LblConrt_Doc.setText("طبيب التحويل");

        txtPas_ID.setNextFocusableComponent(txtPas_Name);

        txtPas_Name.setNextFocusableComponent(ClnOpe_Date);

        txt_opeCost.setText("0");
        txt_opeCost.setNextFocusableComponent(CmbAneths_Doctor);

        ClnOpe_Date.setNextFocusableComponent(Cmb_opeType);

        CmbConvrt_Doc.setNextFocusableComponent(txt_opeCost);

        CmbAneths_Doctor.setNextFocusableComponent(CmbAnthes_Type);

        Cmbope_Doctor.setNextFocusableComponent(Cmbope_Nurse);

        CmbAssist_Doctor.setNextFocusableComponent(Cmbope_Technical);

        Cmb_opeType.setNextFocusableComponent(CmbConvrt_Doc);

        CmbAnthes_Type.setNextFocusableComponent(Cmbope_Doctor);

        Cmbope_Nurse.setNextFocusableComponent(CmbAssist_Doctor);

        jButton1.setText("...");
        jButton1.setToolTipText("ادخال جديد");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("...");
        jButton2.setToolTipText("ادخال جديد");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("...");
        jButton3.setToolTipText("ادخال جديد");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("...");
        jButton4.setToolTipText("ادخال جديد");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("...");
        jButton5.setToolTipText("ادخال جديد");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("...");
        jButton6.setToolTipText("ادخال جديد");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("...");
        jButton7.setToolTipText("ادخال جديد");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("...");
        jButton8.setToolTipText("ادخال جديد");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtPas_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_opeCost, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Cmb_opeType, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                            .addComponent(CmbAnthes_Type, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Cmbope_Nurse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Cmbope_Technical, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Lbl_opeCost)
                            .addComponent(Lbl_opeType)
                            .addComponent(Lbl_opeNurse)
                            .addComponent(Lbl_AnesthType)
                            .addComponent(Lbl_opeTechnical))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Cmbope_Doctor, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                                    .addComponent(CmbAssist_Doctor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Lbl_opeDoctor)
                                    .addComponent(Lbl_AssistDoctor)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CmbAneths_Doctor, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ClnOpe_Date, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CmbConvrt_Doc, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(LblConrt_Doc)
                                        .addComponent(LblOpe_Date))
                                    .addComponent(Lbl_AnethDoctor))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(LblPas_Name)
                                .addGap(18, 18, 18)
                                .addComponent(txtPas_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(LblPas_ID)
                                .addGap(0, 17, Short.MAX_VALUE)))
                        .addGap(47, 47, 47))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblPas_ID)
                    .addComponent(LblPas_Name)
                    .addComponent(txtPas_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPas_Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblOpe_Date)
                    .addComponent(Lbl_opeType)
                    .addComponent(ClnOpe_Date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cmb_opeType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Lbl_opeCost)
                        .addComponent(txt_opeCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(LblConrt_Doc)
                        .addComponent(CmbConvrt_Doc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Lbl_AnesthType)
                            .addComponent(CmbAnthes_Type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Lbl_opeNurse)
                            .addComponent(Cmbope_Nurse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton7)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CmbAneths_Doctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Lbl_AnethDoctor)
                            .addComponent(jButton2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Lbl_opeDoctor)
                            .addComponent(Cmbope_Doctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Lbl_AssistDoctor)
                    .addComponent(Lbl_opeTechnical)
                    .addComponent(CmbAssist_Doctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cmbope_Technical, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4)
                    .addComponent(jButton8))
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("صرف مستهلك عمليات أو أدوية بسعر البيع :");

        Tble_ope_Data.setForeground(new java.awt.Color(255, 255, 255));
        Tble_ope_Data.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(Tble_ope_Data);

        jLabel3.setText("اجمالى منصرف المستهلك أو الأدوية :");

        LblNotce_Doc.setText("ملاحظات الطبيب :");

        txtNotice_Doc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNotice_DocActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtNotice_Doc, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(213, 213, 213)
                        .addComponent(LblNotce_Doc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTotal_Revenue, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTotal_Revenue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LblNotce_Doc))
                        .addGap(0, 11, Short.MAX_VALUE))
                    .addComponent(txtNotice_Doc))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtNotice_DocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNotice_DocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNotice_DocActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String test1= JOptionPane.showInputDialog("الرجاء ادخال التخصص الجديد  ");
        CmbConvrt_Doc.addItem(test1);
        CmbConvrt_Doc.getSelectedItem();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String test1= JOptionPane.showInputDialog("الرجاء ادخال التخصص الجديد  ");
CmbAneths_Doctor.addItem(test1);
CmbAneths_Doctor.getSelectedItem();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         String test1= JOptionPane.showInputDialog("الرجاء ادخال التخصص الجديد  ");
Cmbope_Doctor.addItem(test1);
Cmbope_Doctor.getSelectedItem();

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String test1= JOptionPane.showInputDialog("الرجاء ادخال التخصص الجديد  ");
CmbAssist_Doctor.addItem(test1);
CmbAssist_Doctor.getSelectedItem();

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
         String test1= JOptionPane.showInputDialog("الرجاء ادخال التخصص الجديد  ");
Cmb_opeType.addItem(test1);
Cmb_opeType.getSelectedItem();

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
         String test1= JOptionPane.showInputDialog("الرجاء ادخال التخصص الجديد  ");
CmbAnthes_Type.addItem(test1);
CmbAnthes_Type.getSelectedItem();

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        String test1= JOptionPane.showInputDialog("الرجاء ادخال التخصص الجديد  ");
Cmbope_Nurse.addItem(test1);
Cmbope_Nurse.getSelectedItem();

    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
         String test1= JOptionPane.showInputDialog("الرجاء ادخال التخصص الجديد  ");
Cmbope_Technical.addItem(test1);
Cmbope_Technical.getSelectedItem();

    }//GEN-LAST:event_jButton8ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private projict_Class.ACalender ClnOpe_Date;
    private projict_Class.ACombobox CmbAneths_Doctor;
    private projict_Class.ACombobox CmbAnthes_Type;
    private projict_Class.ACombobox CmbAssist_Doctor;
    private projict_Class.ACombobox CmbConvrt_Doc;
    private projict_Class.ACombobox Cmb_opeType;
    private projict_Class.ACombobox Cmbope_Doctor;
    private projict_Class.ACombobox Cmbope_Nurse;
    private projict_Class.ACombobox Cmbope_Technical;
    private javax.swing.JLabel LblConrt_Doc;
    private javax.swing.JLabel LblNotce_Doc;
    private javax.swing.JLabel LblOpe_Date;
    private javax.swing.JLabel LblPas_ID;
    private javax.swing.JLabel LblPas_Name;
    private javax.swing.JLabel Lbl_AnesthType;
    private javax.swing.JLabel Lbl_AnethDoctor;
    private javax.swing.JLabel Lbl_AssistDoctor;
    private javax.swing.JLabel Lbl_opeCost;
    private javax.swing.JLabel Lbl_opeDoctor;
    private javax.swing.JLabel Lbl_opeNurse;
    private javax.swing.JLabel Lbl_opeTechnical;
    private javax.swing.JLabel Lbl_opeType;
    private javax.swing.JTable Tble_ope_Data;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtNotice_Doc;
    private projict_Class.TxTf txtPas_ID;
    private projict_Class.TxTf txtPas_Name;
    private javax.swing.JTextField txtTotal_Revenue;
    private projict_Class.TxTf txt_opeCost;
    // End of variables declaration//GEN-END:variables
    @Override
    public void Insert() {
 insert();
      
 
    }

    @Override
    public void Update() {
        update();
    }
      
     /* OtherMethods o = new OtherMethods();
      
       
       try{pas_ope_srv.pastiontData(
                txtPas_ID.getText(),
                txtPas_Name.getText(),
           
         new SimpleDateFormat("yyyy-MM-dd").format(   ClnOpe_Date.getDate()),
            
            CmbConvrt_Doc.getSelectedItem()+"",
            CmbAneths_Doctor.getSelectedItem()+"",
            Cmbope_Doctor.getSelectedItem()+"",
            CmbAssist_Doctor.getSelectedItem()+"",
            Cmb_opeType.getSelectedItem()+"",
            txt_opeCost.getText(),
            CmbAnthes_Type.getSelectedItem()+"",
            Cmbope_Nurse.getSelectedItem()+"",
            Cmbope_Technical.getSelectedItem()+"");
        }catch(Exception ex){
            System.out.println("Error" + ex);

       }
       
    }*/

    @Override
    public void Delete() {
     delete();
}

    @Override
    public void Addnew() {
   txtPas_ID.setText("");
     txtPas_Name.setText("");
     txt_opeCost.setText("");

    }


}
