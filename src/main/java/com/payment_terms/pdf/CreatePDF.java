package com.payment_terms.pdf;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.payment_terms.entity.User;
 
public class CreatePDF {
    private List<User> listUsers;
     
    public CreatePDF(List<User> listUsers) {
        this.listUsers = listUsers;
    }
 
    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
      
        cell.setPadding(5);
        cell.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
         
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
       
         
        cell.setPhrase(new Phrase("User ID", font));
         
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Code", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Description", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("CreationDate", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Days", font));
        table.addCell(cell);   
        
        cell.setPhrase(new Phrase("RemindBeforeDays", font));
        table.addCell(cell); 
    }
     
    private void writeTableData(PdfPTable table) {
        for (User user : listUsers) {
            table.addCell(String.valueOf(user.getId()));
            table.addCell(user.getCode());
            table.addCell(user.getDescription());
            table.addCell(user.getCreationDate());
            table.addCell(String.valueOf(user.getDays()));
            table.addCell(String.valueOf(user.getRemindBeforeDays()));
            
            
        }
    }
     
    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
         
        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        
        font.setSize(18);
 
         
        Paragraph p = new Paragraph("List of Users", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
         
        document.add(p);
         
        PdfPTable table = new PdfPTable(6);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.5f, 1.5f, 3.5f, 2.0f, 1.0f,1.0f});
        table.setSpacingBefore(10);
         
        writeTableHeader(table);
        writeTableData(table);
         
        document.add(table);
         
        document.close();
         
    }
}