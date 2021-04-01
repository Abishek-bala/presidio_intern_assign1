package day16;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddDemo {
	public static void main(String[] args) throws UnknownHostException {
		InetAddress inet[] = Inet6Address.getAllByName("www.youtube.com");
		for(InetAddress i : inet) {
			System.out.println(i.getHostAddress());
		}
	}
}
