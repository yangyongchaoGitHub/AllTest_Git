package test.typeconvertion;

public class StringToCharArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String hwaddr = "16044788001121";
		
		char[] cs = hwaddr.toCharArray();
		char h;
		char l;
		
		
		
		for (char c : cs) {
			System.out.println(c);
			
		}
	}
}
