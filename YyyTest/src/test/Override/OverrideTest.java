package test.Override;

public class OverrideTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		aa_c1 c1 = new aa_c1();
		aa iAa = c1;
		iAa.setConfig("dfdfdf");
	}

}

abstract class aa{
	String config;
	public void setConfig(String config) {
		System.out.println("aa config = " + config);
		this.config = config;
	}
}

class aa_c1 extends aa{
	
	@Override
	public void setConfig(String config) {
		System.out.println("aa_c1 config = " + config);
		this.config = config;
	}
}