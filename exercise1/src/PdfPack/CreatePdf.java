package PdfPack;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfWriter;

public class CreatePdf extends UnicastRemoteObject implements PdfGenerator, Serializable {
	
	File f;
	public CreatePdf(String path) throws RemoteException{
		System.out.println(path);
		f= new File(path);
		
	}
	@Override
	public void getPdf(String str) throws RemoteException {
		// TODO Auto-generated method stub
		Document document = new Document();
		try {
			PdfWriter.getInstance(document, new FileOutputStream(f));
	
		document.open();
		
		 Paragraph preface;// = new Paragraph();
	     document.add(new Paragraph());
	        // Lets write a big header
	     Font titleFont = new Font(FontFamily.TIMES_ROMAN,20);
	    preface = new Paragraph(str,titleFont); 
	    System.out.println(str);
	    preface.setAlignment(Element.ALIGN_CENTER);
	    document.add(preface);
	    document.close();
	    System.out.println(document);
		} catch (FileNotFoundException | DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
