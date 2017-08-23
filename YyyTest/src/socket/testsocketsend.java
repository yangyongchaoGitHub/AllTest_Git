package socket;

import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;

import org.agi.hcms.common.dto.ConcentratorDTO;

public class testsocketsend {
	public static void main(String[] args) {
		
		Runnable r=new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
		        	Socket socket = new Socket("192.168.1.106", 9981);
					socket.setSoTimeout(100000);
					ConcentratorDTO c=new ConcentratorDTO();
	                c.setActuatorCount(1);
	                c.setChannelNum(1);
	                c.setdacycle(1);
	                c.setHeartbeatIp("heartbeatip");
	                c.setPhoneNum("phonenum");
	                c.setHeatmeterCount(1);
	                c.setServerIp("serverip");
	                c.setStrategy("strategy");
	                CRCPacket pkt=new CRCPacket(1, (byte) 0x00, false, 1, c);
			        OutputStream os= socket.getOutputStream();
			        ByteBuffer sendpkt = pkt.serializer();
                    os.write(new byte[sendpkt.remaining()]);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
	}

}

