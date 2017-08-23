package test.ThreadTest;

public class ThreadTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		long begin = System.currentTimeMillis();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();

		
		System.out.println("begin = " + begin + " end = " + end + " dif = " + (end - begin));
		
	}
}
