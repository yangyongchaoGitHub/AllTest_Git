package test.recursionTest;

public class HwaddrReverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		System.out.println(re(new String[]{"q1", "w2", "e3", "r4"}, 4));
		
	}
	
	private static String re(String[] str, int count) {
	        if (count == 0)
	            return "";
	        
	        return str[count-1] + re(str, count-1);
	}
}
