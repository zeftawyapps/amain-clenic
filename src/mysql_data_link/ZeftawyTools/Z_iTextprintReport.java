/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql_data_link.ZeftawyTools;


import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.*;
import static com.itextpdf.text.pdf.PdfDictionary.FONT;
import com.itextpdf.text.pdf.languages.ArabicLigaturizer;
import com.itextpdf.text.pdf.languages.LanguageProcessor;
import java.awt.Canvas;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author New
 */
public class Z_iTextprintReport {
    
Document document = new Document();

ArrayList<Paragraph>ReportHeader=new ArrayList<Paragraph>();
ArrayList<Paragraph>PageHeader=new ArrayList<Paragraph>();
ArrayList<Paragraph>ReortFooter=new ArrayList<Paragraph>();
ArrayList<Paragraph>PageFooter=new ArrayList<Paragraph>();
Z_DataShow z_DataShow;

    public void setZ_DataShow(Z_DataShow z_DataShow) {
        this.z_DataShow = z_DataShow;
    }

public  void setValue(String HR , String HP , String FP , String FR) throws DocumentException, IOException{
ReportHeader.add(new Paragraph(HR,setFont(15)));
ReortFooter.add(new Paragraph(FR, setFont(10)));
PageHeader.add(new Paragraph(HP, setFont(10)));
PageFooter.add(new Paragraph(FP , setFont(15)));
}

public void ReportHeader_AddValue(String Vale, int FontSize) throws DocumentException, IOException{
ReportHeader.add(new Paragraph(Vale,setFont(FontSize)));
}



public void PageHeader_AddValue(String Vale, int FontSize) throws DocumentException, IOException{
PageHeader.add(new Paragraph(Vale,setFont(FontSize)));
}


public void ReportFooter_AddValue(String Vale, int FontSize) throws DocumentException, IOException{
ReortFooter.add(new Paragraph(Vale,setFont(FontSize)));
}


public void PageFooter_AddValue(String Vale, int FontSize) throws DocumentException, IOException{
PageFooter.add(new Paragraph(Vale,setFont(FontSize)));
}


Font setFont(int size ) throws DocumentException, IOException{
  BaseFont bf = BaseFont.createFont(
    "arial.ttf",BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
    Font f = new Font(bf, size);
    return f ;
}

Font setFontTableHeader(int size ) throws DocumentException, IOException{
  BaseFont bf = BaseFont.createFont(
    "arial.ttf",BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
    Font f = new Font(bf, size);
    return f ;
}
Font setFontTableCell(int size ) throws DocumentException, IOException{
  BaseFont bf = BaseFont.createFont(
    "arial.ttf",BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
    Font f = new Font(bf, size);
    return f ;
}
    
void  Print_Paragrapht(ArrayList<Paragraph> p ) throws DocumentException, IOException{
  
  
    PdfPTable t = new PdfPTable(1);
  t.setRunDirection(PdfWriter.RUN_DIRECTION_RTL);

  PdfPCell cell = new PdfPCell();
          cell.setBorder(0);

    int i = 0 ; int Size = p.size();
    while (i < Size) { 
        
cell.addElement(p.get(i));
 t.addCell(cell);
  document.add(t);

        i ++;
    }
 
}

void Print_ReportHeader(){
    try {
   Print_Paragrapht(ReportHeader);        
    } catch (Exception e) {
        System.out.println("print header error"+ e);
    }

}

void Print_ReportFooter(){
   try {
   Print_Paragrapht(ReortFooter);        
    } catch (Exception e) {
        System.out.println("print Report F error"+ e);
    }
}

void Print_PageHeader (){
    
     try {
   Print_Paragrapht(PageHeader);        
    } catch (Exception e) {
        System.out.println("print page h  error"+ e);
    }
 

}

void Print_PageFooter (){
    
     try {
   Print_Paragrapht(PageFooter);        
    } catch (Exception e) {
        System.out.println("print page F  error"+ e);
    }
 

}
public  void Print_iTextPDF(){
try {
           
                PdfWriter writer=
                PdfWriter.getInstance(document, new FileOutputStream("me.pdf"));
            document.open();
          
Print_ReportHeader();
Print_PageHeader();
Print_table();
Print_PageFooter();
Print_ReportFooter();

 
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
}
   PdfWriter writer;
             
public  void Print_table(){
try {
        int ic , ir , r , c ;  
       c = z_DataShow.culomntcount;
       r = z_DataShow.rowcount;
       ic = 0 ; ir = 0 ; 
       
  PdfPTable table = new  PdfPTable(c);
   table.setRunDirection(PdfWriter.RUN_DIRECTION_RTL);

// header row:
      //    cell.setBorder(1);
while (ic < c ) {        
   PdfPCell cell = new PdfPCell();   
       String sh = z_DataShow.cell[ic].getCaption();
cell.addElement(new Paragraph(sh,setFont(15)));
table.addCell(cell);
ic ++ ; 
    }
   
 
table.setHeaderRows(1);
 

 ic = 0 ;
 
 
// many data rows:
   while (ir < r ) {        
        while (ic < c ) {
              PdfPCell cell = new PdfPCell();   
       String sh = z_DataShow.getvalue(ir , ic);
cell.addElement(new Paragraph(sh,setFont(15)));
table.addCell(cell);
            ic ++ ; 
        }
        ir ++ ; ic = 0 ; 
  
    }
document.add(table);
        
      
        } catch (Exception e) {
    System.out.println("Error Report Table " + e );
        }
}
public  void OpenPDF() throws IOException{

   Process p ;
         Desktop desktop = Desktop.getDesktop();
File file = new File("me.pdf");
desktop.open(file);
}
}
 
