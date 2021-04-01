package excelpack;

import java.io.Serializable;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class PublishExcel implements Serializable {
	public static void main(String[] args) throws Exception {
		CreateExcel excelRmi = new CreateExcel("E://RMIExcel.xls");
		LocateRegistry.createRegistry(3000);
		
		System.out.println("Excel service deployed....");
		Naming.bind("rmi://localhost:3000/excel/createExcel", excelRmi);
	}
}
