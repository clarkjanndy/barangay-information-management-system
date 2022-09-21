/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package others;

import model.Resident;
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
import java.util.List;

/**
 *
 * @author BISU Clarin
 */
public class PrintResidents {

    float[] column = {4f, 4f, 4f, 4f};
    PdfPTable table = new PdfPTable(column);
    PdfPCell cell;
    Document document;

    public PrintResidents(List<Resident> rs) throws BadElementException, DocumentException, FileNotFoundException, MalformedURLException, IOException, Exception {

        document = new Document(PageSize.LETTER, 10f, 10f, 10f, 10f); //R,L,T,B
        PdfWriter.getInstance(document, new FileOutputStream("C:\\Barangay Management Information System\\prints\\Residents.pdf"));
        document.open();

        header();
        tableHeader();
        body(rs);

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

        cell = new PdfPCell(new Paragraph("LIST OF RESIDENTS", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD)));
        cell.setColspan(4);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBorder(Rectangle.NO_BORDER);
        table.addCell(cell);

        cell = new PdfPCell(new Paragraph("_______", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD)));
        cell.setColspan(4);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBorder(Rectangle.NO_BORDER);
        table.addCell(cell);

    }

    public void tableHeader() throws BadElementException, MalformedURLException, IOException, DocumentException {

        cell = new PdfPCell(new Paragraph("Resident ID", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD)));
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell.setBorder(Rectangle.BOX);
        table.addCell(cell);

        cell = new PdfPCell(new Paragraph("Full Name", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD)));
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell.setBorder(Rectangle.BOX);
        table.addCell(cell);

        cell = new PdfPCell(new Paragraph("Contact", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD)));
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell.setBorder(Rectangle.BOX);
        table.addCell(cell);

        cell = new PdfPCell(new Paragraph("Purok", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD)));
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell.setBorder(Rectangle.BOX);
        table.addCell(cell);

    }

    public void body(List<Resident> rs) throws BadElementException, MalformedURLException, IOException, DocumentException {
        for (int i = 0; i < rs.size(); i++) {

            cell = new PdfPCell(new Paragraph("" + rs.get(i).getR_id(), new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL)));
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell.setBorder(Rectangle.BOX);
            table.addCell(cell);

            cell = new PdfPCell(new Paragraph("" + rs.get(i).getFullName(), new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL)));
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell.setBorder(Rectangle.BOX);
            table.addCell(cell);

            cell = new PdfPCell(new Paragraph("" + rs.get(i).getR_contact(), new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL)));
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell.setBorder(Rectangle.BOX);
            table.addCell(cell);

            cell = new PdfPCell(new Paragraph("Purok " + (rs.get(i).getR_purok() + 1), new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL)));
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell.setBorder(Rectangle.BOX);
            table.addCell(cell);

        }

    }

}
