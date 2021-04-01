package ControllerPack;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class AcknowledgementImpl implements Acknowledgement,Serializable{
	@Override
	public void getAcked() {
		// TODO Auto-generated method stub
		System.out.println("acknowledging...");
	}
}
