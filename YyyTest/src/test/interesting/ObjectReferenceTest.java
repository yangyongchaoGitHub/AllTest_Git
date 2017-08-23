package test.interesting;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
class test0 {
	String s;
	String ss;
}
class test extends test0 {
	int a;
	int b;
}

public class ObjectReferenceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test0 t1 = new test();
		t1.s = "1s";
		test0 t2 = t1;
		t2.s = "2s";
		//t2 = null;
					
		System.out.println("OOPS!" + "t1 = " +  t1 + ", t2 =  " + t2);			
	

		List<Balloon> list = new ArrayList<Balloon>();
		String text = "_ _";
		String text_change1 = "OK";
		String text_change2 = "no";
		int line = 1;
		int line3 = 3;
		int line5 = 5;
		Gas gas_H = new Gas();
		gas_H.name = "H";
		Gas gas_He = new Gas();
		gas_He.name = "He";
		
		Balloon b1 = new Balloon();
		b1.ballText = text;
		b1.ballLine = line;
		
		Balloon b2 = b1;
		Balloon b3 = b1;
		list.add(b1);
		list.add(b2);
		list.add(b3);
		
		for(Balloon it : list) {
			System.out.println(it.toString() + " | " + it.ballText + " | " + it.ballText.toString() + " | " +  it.ballLine);
		}
		
		list.get(0).ballText = text_change1;
		
		for(Balloon it : list) {
			System.out.println(it.toString() + " | " + it.ballText + " | " + it.ballText.toString() + " | " +  it.ballLine);
		}
		
		for(Balloon it : list) {
			System.out.println(it.toString() + " | " + it.gas.toString() + " | " + it.gas.name);
		}
		
		list.get(0).gas = gas_H;
		list.get(1).gas = gas_He;
		
		for(Balloon it : list) {
			System.out.println(it.toString() + " | " + it.gas.toString() + " | " + it.gas.name);
		}
		
		list.get(0).gas = null;
		
		for(Balloon it : list) {
			if (it.gas != null) {
				System.out.println(it.toString() + " | " + it.gas.toString() + " | " + it.gas.name);	
			} else {
				System.out.println(it.toString());
			}
		}
		
		list.get(0).gas = gas_H;
		
		for(Balloon it : list) {
			System.out.println(it.toString() + " | " + it.gas.toString() + " | " + it.gas.name);
		}
		
		WeakReference wr = new WeakReference(list.get(0).gas);
		list.get(0).gas = gas_He;
		
		for(Balloon it : list) {
			if (it.gas != null) {
				System.out.println(it.toString() + " | " + it.gas.toString() + " | " + it.gas.name);	
			} else {
				System.out.println(it.toString());
			}
		}
		Balloon balloon = list.get(0);
		//balloon = new Balloon();
		balloon.gas.name = "HxHe";
		
		for(Balloon it : list) {
			System.out.println(it.toString() + " | " + it.gas.toString() + " | " + it.gas.name);
		}
		
		list.add(null);
		
		System.out.println(list.size());
	}
}

class Balloon{
	String ballText = "";
	int ballLine = 0;
	Gas gas = new Gas();
}

class Gas {
	String name = "air";
}