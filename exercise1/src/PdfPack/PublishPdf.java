package PdfPack;

import java.io.Serializable;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;


public class PublishPdf  implements Serializable{
	public static void main(String[] args) throws Exception {
		CreatePdf pdfRmi = new CreatePdf("E://RMIPdf.pdf");
		LocateRegistry.createRegistry(2000);
		
		System.out.println("pdf service deployed....");
		Naming.bind("rmi://localhost:2000/pdf/createPdf", pdfRmi);
	}
}
