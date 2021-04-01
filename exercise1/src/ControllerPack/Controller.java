package ControllerPack;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Controller extends Remote {
	public Object getAckAppObject(AcknowledgementImpl ack) throws RemoteException;
}
