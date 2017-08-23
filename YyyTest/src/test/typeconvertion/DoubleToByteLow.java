package test.typeconvertion;
/**
 * Double to byte test
 * @author Administrator
 *
 */
public class DoubleToByteLow {

	private static String hexString = "0123456789";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double d = 121314.78;
		byte b = 0x0d;
		String s = (Double.toString(d)).split("\\.")[0] + (Double.toString(d)).split("\\.")[1];
		for (byte it: s.getBytes()) {
			//function 1
			//System.out.println(hexString.indexOf(it));
			
			//function 2
			System.out.print((it & 0x0f) + " ");
			
		}
		d=d*100;
		System.out.println(((int)d/10000000 << 4)|(int)d/1000000 % 10);
		System.out.println(((int)d/100000 % 10 << 4)|(int)d/10000 % 10);
		System.out.println(((int)d/1000 % 10 << 4)|(int)d/100 % 10);
		System.out.println(((int)d/10 % 10 << 4)|(int)d % 10);

	}
}
