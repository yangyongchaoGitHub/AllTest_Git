package socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class client2 {
	public void goo(){
		new Thread(client).start();
	}
	
	final private Runnable client = new Runnable() {
        @Override
        public void run() {
            try {
                Socket socket = new Socket("192.168.1.106",10001);
                System.out.println("Socket socket = new Socket('192.168.1.106',10001);");
                new ClientInputThread(socket).start();
                System.out.println("new ClientInputThread(socket).start();");
                new ClientOutputThread(socket,new byte[]{'2','1'}).start();
                System.out.println("new ClientOutputThread(socket,new byte[]{'2','1'}).start();");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    
    
    public class ClientOutputThread extends Thread {
        private Socket socket;
        private byte[] bytes;

        public ClientOutputThread(Socket socket, byte[] bytes) {
            super();
            this.socket = socket;
            this.bytes = bytes;
        }

        @Override
        public void run() {
            try {
                OutputStream os = socket.getOutputStream();
                //DataTransferUnit dataSend = new DataTransferUnit();
                //byte[] bytesSend = dataSend.encode();
                os.write(bytes);
                System.out.println("out");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    
    public class ClientInputThread extends Thread {
        private Socket socket;

        public ClientInputThread(Socket socket) {
            super();
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                //Protocol.DataTransferUnit recvDTU = new Protocol().new DataTransferUnit();
                InputStream is = socket.getInputStream();
                while (true) {
                    byte[] buffer = new byte[1024];
                    int length = is.read(buffer);
                    System.out.println("in");
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
