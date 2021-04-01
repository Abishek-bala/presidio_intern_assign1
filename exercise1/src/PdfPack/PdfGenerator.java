package PdfPack;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PdfGenerator extends Remote{
	public void getPdf(String s) throws RemoteException;
}
