package multicastServer;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

@SuppressWarnings("unused")
public class MulticastServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String host = "234.50.50.50";
		int port = 7001;
		try {
			InetAddress multicastAddress = InetAddress.getByName(host);
			if (multicastAddress.isMulticastAddress()) { 
				
				MulticastSocket receiveMulticast = new MulticastSocket(port);
				//加入广播组
				receiveMulticast.joinGroup(multicastAddress);
				
				DatagramPacket dp = new DatagramPacket(new byte[1024], 1024);
				receiveMulticast.receive(dp);
				
				System.out.println("listen " + new String(dp.getData()).trim());
				receiveMulticast.close();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
