package test.interesting;

public class AndOr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = null;
		if (str == null || str.equals("123456")) {
			System.out.println("null");
			System.out.println(Long.MAX_VALUE);
		}
		Object a = null;
		String s = (String) a;
	}

}
