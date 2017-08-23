package socket;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;

import org.agi.hcms.common.dto.ConcentratorDTO;
import org.agi.hcms.common.dto.DeviceDTO;

import com.google.gson.Gson;

public class Myservice {
	private static DeviceDTO deviceDTO=new DeviceDTO();
	private static byte[] outBytes;
	private static Gson gson = new Gson();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Thread(myservice).start();
	}

	private static Runnable myservice =new Thread(){
		public void run() {
			System.out.println("我是服务器，我正在监听9981端口");
			//在9999端口监听
			try {
				//启动监听
				ServerSocket ss= new ServerSocket(10002);
				//不断的等待消息
				while(true){
					//阻塞，等待连接
					final Socket s = ss.accept();
					//得到s的输入流，也就是传入的数据
					byte[] hdr = new byte[CRCProtocol.HDR_SIZE];
					InputStream is = s.getInputStream();

					/*int count = 0;
					while(count == 0){
						count=is.available();
						System.out.println("11");
					}
					byte[] b=new byte[count];
					is.read(b);
					System.out.println(b.toString());*/
					/*
					ByteArrayOutputStream bos=new ByteArrayOutputStream();
					byte[] buffer=new byte[1024];
					int len=-1;
					while ((len = is.read(buffer))!=-1){
						bos.write(buffer,0,len);
					}
					System.out.println(bos.toByteArray().toString());
					*/
					is.read(hdr, 0, CRCProtocol.HDR_SIZE);
                        int size = CRCProtocol.length(ByteBuffer.wrap(hdr));
                        if (size > 0) {
                            byte[] dtu = new byte[size];
                            CRCPacket pkt = new CRCPacket();

                            is.read(dtu, 0, size);
                            pkt.deserializer(ByteBuffer.wrap(hdr), ByteBuffer.wrap(dtu));
                            System.out.println("is read packet==> "+pkt.getLength()+"--"+pkt.getSessionId());
                        }
                    
	                ConcentratorDTO c=new ConcentratorDTO();
	                c.setActuatorCount(1);
	                c.setChannelNum(1);
	                c.setdacycle(1);
	                c.setHeartbeatIp("heartbeatip");
	                c.setPhoneNum("phonenum");
	                c.setHeatmeterCount(1);
	                c.setServerIp("serverip");
	                c.setStrategy("strategy");
	                CRCPacket pkt=new CRCPacket(1, (byte) 0x00, true, 1, c);
	                OutputStream os= s.getOutputStream();
                    ByteBuffer sendpkt = pkt.serializer();
                    os.write(sendpkt.array());
					//oos.write(outBytes);
					System.out.println("send to client ok");
					
					/*Runnable r=new Runnable() {
						@Override
						public void run() {
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
							// TODO Auto-generated method stub
							while(true){
								try {
							        OutputStream os= s.getOutputStream();
							        ByteBuffer sendpkt = pkt.serializer();
				                    os.write(new byte[sendpkt.remaining()]);
							        sleep(5000);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						}
					};
					new Thread(r).start();*/
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
	};
}
	
	/*while ((is.read(hdr, 0, CRCProtocol.HDR_SIZE))!=-1) {
        //In ret = is.read(hdr, 0, CRCProtocol.HDR_SIZE);
        int size = CRCProtocol.length(hdr);
        if (size > 0) {
            byte[] dtu = new byte[size];
            CRCPacket pkt = new CRCPacket();

            is.read(dtu, 0, size);
            pkt.fill(hdr, dtu);
            Log.i("lisn pkt", "id =>"+pkt.getSessionId().toString()+
                    "dtu =>"+pkt.getDtu().toString()+"sn =>"+pkt.getSN());
        }
        continue;*/




	
	
	//读取数据
	/*if(ois.readObject().toString().equals("hello")){
		System.out.println("is child");
		//得到输出流
		ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
		//返回数据
		oos.writeObject("yes");
		oos.write(outBytes);
		System.out.println("yes");
	}else{
		System.out.println("no no no");
		//得到输出流
		ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
		//返回数据
		//oos.writeObject("no");
		oos.write(outBytes);
		
		System.out.println("no");
	}*/

