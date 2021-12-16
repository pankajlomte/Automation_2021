package Reports;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class createPDFReport {
	
	public static Document docu;
	public static void openPdfPath() throws FileNotFoundException, DocumentException{
	
		String fileName = new File("").getAbsoluteFile().toString()+"/test-output"+System.currentTimeMillis()+".pdf";
	
	FileOutputStream fos = new FileOutputStream(fileName);
	
	docu = new Document();
	PdfWriter.getInstance(docu, fos);
	docu.open();
	}
	public static void addData(String authorName, String title, String description){
	docu.addAuthor(authorName);
	docu.addTitle(title);
	docu.addSubject(description);
	}
	public static void addParagraph(String text) throws DocumentException{
	docu.add(new Paragraph(text));
	}
	public static void closePdf(){
	docu.close();
	
	}

}
