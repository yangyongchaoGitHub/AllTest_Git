package test.stringTest;

import java.util.Collection;

public class StringToByte {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String hwaddr_ = "00000000000000";
		String string = "ddgh123467890123";
		byte b[] = string.getBytes();
		byte address[] = new byte[7];
		
		for (int o = 0; o < address.length && o < b.length; o++) {
			address[o] = b[o];
		}
		
		for (byte c : address) {
			System.out.println(c);
		}
		
		if (string.length() < 14) {
			string += hwaddr_.substring(0, 14-string.length());
		}
		
		if (string.length() > 14) {
			string = string.substring(0, 14);
		}
		System.out.println(string);
	}
}
