/**
 * ��������ѽ�������Ľ���
 * ��Ϊ�ͻ���Ҫ���ڶ�ȡ��״̬���������ǰ�������һ���߳�
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
		jb = new JButton("����");
		jb.addActionListener(this);
		jb1 = new JButton("���͵�androd");
		jb1.addActionListener(this);
		jp = new JPanel();
		jp.add(jtf);
		jp.add(jb);
		jp.add(jb1);
		
		this.add(jsp,"Center");
		this.add(jp,"South");
		this.setTitle("test");
		//����ͼ��
		//this.setIconImage((new ImageIcon("image/qq.gif")).getImage());
		this.setSize(300,200);
		this.setVisible(true);
		
	}
	
	/*//һ����qqchat��ʾ��Ϣ�ķ���
	public void showMessage(Message m){
		String info = m.getSender()+"��"+ m.getGetter()+"˵"+m.getCon()+"\r\n";
		this.jta.append(info);
	}
*/
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//����û�����˷��Ͱ�ť
		if(e.getSource()==jb){
			
			try {
				
				Socket s=new Socket("192.168.1.106", 9981);
				//s = new Socket("127.0.0.1",9990);
				//����һ������
				ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
				oos.writeObject("hello");
				System.out.println("���ͳɹ�");
				
				//�õ���������Ҳ���Ƿ��������ص���Ϣ
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
