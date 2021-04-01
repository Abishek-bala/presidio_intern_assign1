package ControllerPack;

import java.io.FileInputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Enumeration;
import java.util.Properties;

public class ControllerImpl extends UnicastRemoteObject implements Controller,Serializable {
	public ControllerImpl() throws RemoteException {
		// TODO Auto-generated constructor stub
	}
	public Object getAckAppObject(AcknowledgementImpl ack) throws RemoteException{
		int count=0;
		if(ack==null) {
			ack=new AcknowledgementImpl();
		}
		try {
			Properties prop=new Properties();
			prop.load(new FileInputStream("service-config.properties"));
			Enumeration counten=prop.elements();
			int noofservices=0;
			while(counten.hasMoreElements()) {
				noofservices=noofservices+1;
				System.out.println(counten.nextElement());
			}
			System.out.println("No of services...:"+noofservices);
			Class c[]=new Class[noofservices];
			Object o[]=new Object[noofservices];
			Enumeration en=prop.elements();
			while(en.hasMoreElements()) {
				String serviceConfigFile=(String)en.nextElement();
				System.out.println("service files...:"+serviceConfigFile);
				Properties servicesProp=new Properties();
				servicesProp.load(new FileInputStream(serviceConfigFile));
				String urlstr=servicesProp.getProperty("url");
				String interfacename=servicesProp.getProperty("interfacename");
				System.out.println(urlstr+ " "+interfacename);
				o[count]=Naming.lookup(urlstr);	
				c[count]=Class.forName(interfacename);
				//list.add(Class.forName(interfacename));
				//list.add(interfacename);
				++count;
				}
			
			Object obj=Proxy.newProxyInstance(ack.getClass().getClassLoader(), 
					c,new MyInvocationHandler(o));
			System.out.println("The object...:"+obj);
			return obj;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
