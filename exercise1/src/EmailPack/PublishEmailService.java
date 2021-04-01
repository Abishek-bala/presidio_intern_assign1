package EmailPack;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class PublishEmailService implements Serializable{
	public static void main(String[] args) throws RemoteException, MalformedURLException, AlreadyBoundException {
		SendEmail emailrmi = new SendEmail("javaemailpack@gmail.com");
		LocateRegistry.createRegistry(5000);
		
		System.out.println("Email service deployed....");
		Naming.bind("rmi://localhost:5000/email/sendEmail", emailrmi);
	}
}
