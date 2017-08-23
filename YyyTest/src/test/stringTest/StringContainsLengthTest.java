package test.stringTest;

import test.first;
import test.test2;

public class StringContainsLengthTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str1 = " 12t3  t345$t tt";
		String str2 = "31934834%2016-12-28 12:18:48=2016-11-11 12:18:47";
		
		String str = "";
		for (int i = 0; i< str1.length(); i+=2) {
			System.out.println(str1.substring(i, i+2));
			
			str += str1.substring(i, i+2).trim();
			
		}
		System.out.println(str.replace(" ", ""));
		System.out.println(str + str.length() + "||" + str1.length());
		System.out.println(str.indexOf("$"));
		System.out.println(str.contains("9"));
		System.out.println(str1.split("r").length);
		System.out.println(str1.trim());
		test(new String[]{"11", "22", "33"});
		System.out.println(str1.substring(0, str1.length()-1));
		System.out.println(str2.split("%").length);
		test(str2.split("%"));
	}
	
	public static void test(String... strings) {
		for(String s: strings) {
			System.out.println(s);	
		}
	}
}

