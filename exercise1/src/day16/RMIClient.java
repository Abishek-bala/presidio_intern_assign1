package day16;

import java.rmi.Naming;

public class RMIClient {
	public static void main(String[] args) throws Exception{
		Stock stock=(Stock)Naming.lookup("rmi://localhost:2010/rmiservice/stockService");
		
		int price=stock.getStockPrice("coda");
		
		System.out.println("The stock price of coda is...:"+price);
		
	}
}
