package test.stringTest;

public class StringIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "rttert||f4r34545e5||";
		int o = str.indexOf("||");
		System.out.println(str.indexOf("||"));
		System.out.println(str.substring(0, o));
		System.out.println(str.substring(o+2, str.length()));
	}

}
