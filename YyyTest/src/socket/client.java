/**
 * 这是与好友进行聊天的界面
 * 因为客户端要处于读取的状态，所以我们把他做成一个线程
 */

package socket;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class client extends JFrame implements ActionListener {

	JTextArea jta;
	JTextField jtf;
	JButton jb,jb1;
	JPanel jp;
	JScrollPane jsp;
	String ownerId;
	String friendId;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		client qqChat = new client();
		
	}
	
	public client(){
		jta = new JTextArea();
		jsp = new JScrollPane(jta);
		jtf = new JTextField(15);
		jb = new JButton("发送");
		jb.addActionListener(this);
		jb1 = new JButton("发送到androd");
		jb1.addActionListener(this);
		jp = new JPanel();
		jp.add(jtf);
		jp.add(jb);
		jp.add(jb1);
		
		this.add(jsp,"Center");
		this.add(jp,"South");
		this.setTitle("test");
		//设置图标
		//this.setIconImage((new ImageIcon("image/qq.gif")).getImage());
		this.setSize(300,200);
		this.setVisible(true);
		
	}
	
	/*//一个让qqchat显示消息的方法
	public void showMessage(Message m){
		String info = m.getSender()+"对"+ m.getGetter()+"说"+m.getCon()+"\r\n";
		this.jta.append(info);
	}
*/
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//如果用户点击了发送按钮
		if(e.getSource()==jb){
			
			try {
				
				Socket s=new Socket("192.168.1.106", 9981);
				//s = new Socket("127.0.0.1",9990);
				//发送一个对象
				ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
				oos.writeObject("hello");
				System.out.println("发送成功");
				
				//得到输入流，也就是服务器返回的信息
				ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
				System.out.println(ois.readObject().toString()+"yes is service");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource()==jb1) {
			
			
		}
	}

}
