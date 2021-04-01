package excelpack;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ExcelGenerator extends Remote {
	public void getExcel(String s) throws RemoteException;
}
