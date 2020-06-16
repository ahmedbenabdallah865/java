/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;







////////////////////////////**********PDF *************//////////////////////

import com.itextpdf.text.Document;
import java.io.FileOutputStream;
import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import javafx.scene.control.Label;

/**
 *
 * @author admin
 */
public class reusltat implements Initializable {

        /**
     * ***************PDF VAR******************************
     * 
     */
    private static Font basicFont = new Font(Font.FontFamily.TIMES_ROMAN, 26,
            Font.BOLD);

    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
            Font.BOLD);
    private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.NORMAL, BaseColor.RED);
    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,
            Font.BOLD);
    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.BOLD);
    
    
    
    /**************************************************/
    
    @FXML
    private Label resutat;
    
    private  String S1,S2;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       
        
    }
    
    
    
    public void tranfert (String x, String x0 ){
     S1 = x;
     S2 = x0;
        resutat.setText(x);
    }
    @FXML
    public void  pdf(){
        try {


            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("C:/Users/admin/Documents/output.pdf"));
            document.open();
            addMetaData(document);
            addTitlePage(document,S1 , S2);
            document.close();
            Runtime.getRuntime().exec("explorer.exe C:/Users/admin/Documents/output.pdf");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /*************** PDF ****************************/
    
   private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }

    private static void addMetaData(Document document) {
        document.addTitle("Note ");
        document.addSubject("Note");
        document.addKeywords("Note, PDF");
        document.addAuthor("ahmed");
        document.addCreator("ahmed");
    }
    
    
       private static void addTitlePage(Document document,String note ,String remarque )
        throws DocumentException {
        Paragraph preface = new Paragraph();
        // We add one empty line
        addEmptyLine(preface, 1);
        // Lets write a big header
        Paragraph title = new Paragraph("QUIZZ", basicFont);
        title.setAlignment(Element.ALIGN_CENTER);
        preface.add(title);
        addEmptyLine(preface, 1);
        preface.add(new Paragraph("Resultat", catFont));


        addEmptyLine(preface, 1);
        preface.add(new Paragraph("Date :"+ java.time.LocalDate.now(), redFont));

       

        addEmptyLine(preface, 3);

        PdfPTable table = new PdfPTable(2);

        PdfPCell c1 = new PdfPCell(new Phrase("Note"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        
        
        c1 = new PdfPCell(new Phrase("Remarque"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
       


        table.setHeaderRows(1);

        table.addCell(note);
        table.addCell(remarque);

        preface.add(table);

        document.add(preface);

    }

}
