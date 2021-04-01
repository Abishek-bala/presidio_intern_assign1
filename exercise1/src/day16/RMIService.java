package day16;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class RMIService extends UnicastRemoteObject implements Stock {
	public RMIService() throws RemoteException{
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int getStockPrice(String stockName) throws RemoteException {
		if(stockName.equals("coda")) {
			return 100;
		}
		else {
			return 50;
		}
	}
	
	public static void main(String[] args)throws Exception {
		RMIService rmiService=new RMIService();
		
		LocateRegistry.createRegistry(2010);
		
		System.out.println("Server Ready....");
		
		Naming.bind("rmi://localhost:2010/rmiservice/stockService", rmiService);
		
		
	}
}
