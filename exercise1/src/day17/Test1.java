package day17;

import java.rmi.Naming;

import ControllerPack.AcknowledgementImpl;
import ControllerPack.Controller;
import EmailPack.EmailService;
import PdfPack.PdfGenerator;
import excelpack.ExcelGenerator;


public class Test1 {
	public static void main(String[] args)throws Exception {
		AcknowledgementImpl ack = new AcknowledgementImpl();
		Controller c = (Controller) Naming.lookup("rmi://localhost:6000/control/controllerservice");
		Object obj=c.getAckAppObject(ack);
		
		ExcelGenerator excel=(ExcelGenerator)obj;
		excel.getExcel("Hello");
	
//		PdfGenerator pdf = (PdfGenerator)obj;
//		pdf.getPdf("Hello");
		
		EmailService es = (EmailService)obj;
		es.sendMyMail("hello there");
	}
}
