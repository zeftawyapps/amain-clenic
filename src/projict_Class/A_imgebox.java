/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projict_Class;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author New
 */
public class A_imgebox extends javax.swing.JPanel {
    Image image ;int width , hight ;
String Imgresource ;

    public String getImgresource() {
        return Imgresource;
    }

    public void setImgresource(String Imgresource) {
        this.Imgresource = Imgresource;
        ImageIcon iis = new ImageIcon(this.getClass().getResource(Imgresource));
        setImage(iis.getImage());

        
    }

   
    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
        width =getWidth();
        hight = getHeight();
      Dimension size = new Dimension(getWidth() , getHeight());
        setMaximumSize(size);
        setMinimumSize(size);
        setSize(size);
        setPreferredSize(size);
        setOpaque(false);
        
    }
    
     
    public A_imgebox() {
        initComponents();
            
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 103, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 106, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics g) {
       if(image != null){
       g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
       
       }
        
    
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables


}
