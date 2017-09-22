package multicastServer;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String host = "234.50.50.50";
		int port = 7001;
		try {
			InetAddress multicastAddress = InetAddress.getByName(host);
			
			if (multicastAddress.isMulticastAddress()) { 
				MulticastSocket socket = new MulticastSocket(port);
				socket.setTimeToLive(1);
				byte[] sendMSG = "11#msg".getBytes();
				DatagramPacket dp = new DatagramPacket(sendMSG, sendMSG.length, multicastAddress, port);
				socket.send(dp);
				socket.close();
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*try {
			InetAddress multicastAddress = InetAddress.getByName(host);
			
			if (multicastAddress.isMulticastAddress()) { 
				DatagramSocket socket = new DatagramSocket();
				
				byte[] sendMSG = "11#msg".getBytes();
				DatagramPacket dp = new DatagramPacket(sendMSG, sendMSG.length, multicastAddress, port);
				socket.send(dp);
				socket.close();
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

}
