package mousclick;

import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MousClickView extends JFrame implements ActionListener,KeyListener {
	static Robot robot = null;
	static int RUN=1;
	//按钮
	private JButton jb=null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MousClickView mcv=new MousClickView();
		try {
			robot=new Robot();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		new Thread(click).start();
		
	}
	//构造函数
	public MousClickView() {
		// TODO Auto-generated constructor stub
		jb=new JButton("开始");
		//设置监听
		jb.addActionListener(this);
		
		addKeyListener(this);
		setFocusable(true);
		this.add(jb);
		this.setSize(300,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(jb)){
			//当jb被点击
			/*Mous m=new Mous();
			Thread t=new Thread(m);
			t.start();*/
			System.out.println("sss");
			
		}
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_W)
		{
			System.out.println("wwww");
		}else if(e.getKeyCode()==KeyEvent.VK_D)
		{
			System.out.println("dddd");
		}else if(e.getKeyCode()==KeyEvent.VK_S)
		{
			System.out.println("ssss");
		}else if(e.getKeyCode()==KeyEvent.VK_A)
		{
			System.out.println("aaaa");
		}
		System.out.println("eeeeeeeeeeeeeeeee");
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	static Runnable click = new Runnable() {
	public void run() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		click();
	};
		public void click(){
			if (RUN<3) {
				robot.keyPress(KeyEvent.VK_W);
				robot.delay(10);
				robot.keyRelease(KeyEvent.VK_W);
				RUN++;
			}else if(RUN<5){
				robot.keyPress(KeyEvent.VK_A);
				robot.delay(10);
				robot.keyRelease(KeyEvent.VK_A);
				RUN++;
			}else if(RUN==5){
				RUN=1;
			}
			
		}
	};
}
