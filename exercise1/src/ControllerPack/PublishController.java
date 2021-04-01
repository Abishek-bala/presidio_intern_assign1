package ControllerPack;
import java.io.Serializable;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;



public class PublishController implements Serializable{
	public static void main(String[] args) throws Exception {
		ControllerImpl controllerRmi = new ControllerImpl();
		
		LocateRegistry.createRegistry(6000);
		
		System.out.println("controller service deployed....");
		Naming.bind("rmi://localhost:6000/control/controllerservice", controllerRmi);
	}
}
