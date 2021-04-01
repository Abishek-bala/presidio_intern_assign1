package EmailPack;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface EmailService extends Remote{
	public void sendMyMail(String msg) throws RemoteException;
}
