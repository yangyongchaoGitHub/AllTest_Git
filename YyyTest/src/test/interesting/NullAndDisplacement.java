package test.interesting;

public class NullAndDisplacement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (null == null) {
			System.out.println("222");
		}
		
		byte b = 0x00;
		byte c = 0x28;
		System.out.println(((b << 8) | c) & 0xff);
		
		Poi poi;
		poi = getPoi(10);
		
		if (poi != null && poi.age > 1 && poi.name.equals("poi")) {
			System.out.println("ex???");
		}
		
		if (poi == null || poi.age < 0 || poi.name.equals("poi")) {
			System.out.println("ex2???");
		}
	}
	
	public static Poi getPoi(int op) {
		return null;
	}
}

class Poi {
	int age;
	int o_pi;
	String name;
}
