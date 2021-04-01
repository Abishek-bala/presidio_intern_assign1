package excelpack;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class CreateExcel extends UnicastRemoteObject implements ExcelGenerator, Serializable {
	File f;
	public CreateExcel(String path) throws RemoteException{
		// TODO Auto-generated constructor stub
		System.out.println(path);
		f = new File(path);
	}
	
	@Override
	public void getExcel(String s) throws RemoteException {
		// TODO Auto-generated method stub
		WritableWorkbook mybook = null;
		try {
			  mybook = Workbook.createWorkbook(f);

	            // create an Excel sheet
	            WritableSheet excelSheet = mybook.createSheet("Sheet 1", 0);

	            // add something into the Excel sheet
	            Label label = new Label(0, 0, s);
	            excelSheet.addCell(label);
	            
	            mybook.write();
		}catch (IOException e) {
            e.printStackTrace();
        } catch (WriteException e) {
            e.printStackTrace();
        } finally {

            if (mybook != null) {
                try {
                    mybook.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (WriteException e) {
                    e.printStackTrace();
                }
		
            }
        }
	}
}
	
