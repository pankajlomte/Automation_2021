package Reports;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class pdfReportsetUp {
	
public static Document doc;
	
	public static void openPdfPath() throws FileNotFoundException, DocumentException{
		
		String fileName = new File("").getAbsoluteFile().toString()+"/TestReport/pdf-"+System.currentTimeMillis()+".pdf";
		
		FileOutputStream fos = new FileOutputStream(fileName);
		
		doc = new Document();
		
		PdfWriter.getInstance(doc, fos);//When this PdfWriter is added to a certain PdfDocument, 
		//the PDF representation of every Element added to this Document will be written to the outputstream.
		
		doc.open();
	}
	
	public void addMetaData(String authorName, String title, String description){
		doc.addAuthor(authorName);
		doc.addTitle(title);
		doc.addSubject(description);
	}
	
	public void addParagraph(String text) throws DocumentException{
		doc.add(new Paragraph(text));
	
	}

	public void closePdf(){
		doc.close();
}
	
}

