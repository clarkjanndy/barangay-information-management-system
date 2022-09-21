/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package others;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.Resident;

/**
 *
 * @author BISU Clarin
 */
public class BarangayClearance {

    float[] column = {8f, 8f, 8f};
    PdfPTable table = new PdfPTable(column);
    PdfPCell cell;
    Document document;

    public BarangayClearance(Resident r) throws BadElementException, DocumentException, FileNotFoundException, MalformedURLException, IOException, Exception {

        document = new Document(PageSize.LETTER, 10f, 10f, 10f, 10f); //R,L,T,B
        PdfWriter.getInstance(document, new FileOutputStream("C:\\Barangay Management Information System\\prints\\Residents.pdf"));
        document.open();

        header();
        //tableHeader();
        body(r);

        Paragraph parag = new Paragraph();
        parag.setAlignment(Element.ALIGN_JUSTIFIED_ALL);
        parag.add(table);

        document.add(parag);
        document.setMarginMirroring(true);

        CreateDirectory();
        DisplayOutput();
        document.close();
    }

    public void DisplayOutput() throws Exception {
        try {

            if ((new File("C:\\Barangay Management Information System\\prints\\Residents.pdf")).exists()) {
                Process p = Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler C:\\Barangay Management Information System\\prints\\Residents.pdf");
                p.waitFor();
            } else {
                System.out.println("File does not exists");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void CreateDirectory() {
        File theDir = new File("C:\\Barangay Management Information System\\prints");
        if (!theDir.exists()) {
            boolean result = theDir.mkdir();
            if (result) {
                System.out.println("DIR created");
            }
        } else {

        }
    }

    public void header() throws BadElementException, MalformedURLException, IOException, DocumentException {

        cell = new PdfPCell(new Paragraph("Republic Of the Philippines", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD)));
        cell.setColspan(4);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBorder(Rectangle.NO_BORDER);
        table.addCell(cell);

        cell = new PdfPCell(new Paragraph("Province Of Bohol", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD)));
        cell.setColspan(4);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBorder(Rectangle.NO_BORDER);
        table.addCell(cell);

        cell = new PdfPCell(new Paragraph("Barangay Management Information System", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD)));
        cell.setColspan(4);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBorder(Rectangle.NO_BORDER);
        table.addCell(cell);

        cell = new PdfPCell(new Paragraph("Barangay Clearance", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD)));
        cell.setColspan(4);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBorder(Rectangle.NO_BORDER);
        table.addCell(cell);

    }

    public void tableHeader() throws BadElementException, MalformedURLException, IOException, DocumentException {

        cell = new PdfPCell(new Paragraph("Fullname ", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD)));
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell.setBorder(Rectangle.BOX);
        table.addCell(cell);

        cell = new PdfPCell(new Paragraph("Postiion", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD)));
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell.setBorder(Rectangle.BOX);
        table.addCell(cell);

        cell = new PdfPCell(new Paragraph("Commision", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD)));
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell.setBorder(Rectangle.BOX);
        table.addCell(cell);

    }

    public void body(Resident r) throws BadElementException, MalformedURLException, IOException, DocumentException {

        cell = new PdfPCell(new Paragraph("         ", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL)));
        cell.setColspan(4);
        cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
        cell.setBorder(Rectangle.NO_BORDER);
        table.addCell(cell);

        cell = new PdfPCell(new Paragraph("TO WHOM IT MAY CONCERN: ", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL)));
        cell.setColspan(4);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell.setBorder(Rectangle.NO_BORDER);
        table.addCell(cell);

        cell = new PdfPCell(new Paragraph("         ", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL)));
        cell.setColspan(4);
        cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
        cell.setBorder(Rectangle.NO_BORDER);
        table.addCell(cell);

        cell = new PdfPCell(new Paragraph("This is to certify that " + r.getFullName() + ", " + r.getR_civilstatus() + " is a bonafide resident of this barangay.", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL)));
        cell.setColspan(4);
        cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
        cell.setBorder(Rectangle.NO_BORDER);
        table.addCell(cell);

        cell = new PdfPCell(new Paragraph("         ", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL)));
        cell.setColspan(4);
        cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
        cell.setBorder(Rectangle.NO_BORDER);
        table.addCell(cell);

        cell = new PdfPCell(new Paragraph("This further certifies that, he has no record of infraction of laws or any criminal case pending "
                + "investigation against him as per available records on file in thus barangay as of this date.", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL)));
        cell.setColspan(4);
        cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
        cell.setBorder(Rectangle.NO_BORDER);
        table.addCell(cell);

        cell = new PdfPCell(new Paragraph("         ", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL)));
        cell.setColspan(4);
        cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
        cell.setBorder(Rectangle.NO_BORDER);
        table.addCell(cell);

        cell = new PdfPCell(new Paragraph("This clearance is hereby issued upon verbal request of the above named person for whatever legal purpose"
                + "it may serve.", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL)));
        cell.setColspan(4);
        cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
        cell.setBorder(Rectangle.NO_BORDER);
        table.addCell(cell);

        cell = new PdfPCell(new Paragraph("         ", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL)));
        cell.setColspan(4);
        cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
        cell.setBorder(Rectangle.NO_BORDER);
        table.addCell(cell);

        cell = new PdfPCell(new Paragraph("Issued this " + new SimpleDateFormat("MMMM dd, YYYY").format(new Date()) + ""
                + "at this barangay.", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL)));
        cell.setColspan(4);
        cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
        cell.setBorder(Rectangle.NO_BORDER);
        table.addCell(cell);

        cell = new PdfPCell(new Paragraph("         ", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL)));
        cell.setColspan(4);
        cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
        cell.setBorder(Rectangle.NO_BORDER);
        table.addCell(cell);

        cell = new PdfPCell(new Paragraph("Signed by:", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL)));
        cell.setColspan(4);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setBorder(Rectangle.NO_BORDER);
        table.addCell(cell);

        cell = new PdfPCell(new Paragraph("         ", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL)));
        cell.setColspan(4);
        cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
        cell.setBorder(Rectangle.NO_BORDER);
        table.addCell(cell);

        cell = new PdfPCell(new Paragraph("____________________________", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL)));
        cell.setColspan(4);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setBorder(Rectangle.NO_BORDER);
        table.addCell(cell);
        
        cell = new PdfPCell(new Paragraph("Punong Barangay", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL)));
        cell.setColspan(4);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setBorder(Rectangle.NO_BORDER);
        table.addCell(cell);
    }

}
