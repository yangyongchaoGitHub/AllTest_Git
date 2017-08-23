package test.CollectionsTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ConcurrentMapTest {

	//static Map<A, List<String>> groups = new HashMap<A, List<String>>();
	//static ConcurrentMap<A, List<String>> groups = new ConcurrentHashMap<A, List<String>>();
	static ConcurrentMap<Integer, List<String>> groups = new ConcurrentHashMap<Integer, List<String>>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a1 = new A();
		a1.setAge(11);
		a1.setName("qq");
		
		add(a1, "first");
		
		A a2 = new A();
		a2.setAge(12);
		a2.setName("ww");
		
		add(a2, "ss");
		
		A a3 = new A();
		a3.setAge(11);
		a3.setName("qq");
		
		add(a3, null);
		
		for (Entry<Integer, List<String>> entry: groups.entrySet()) {
			System.out.println(entry.getKey() + "  " + entry.getValue().get(0));
		}
		

		System.out.println(groups.size());
	}
	
	static void add(A a, String ss) {
		List<String> strs = groups.get(a);
		if (strs == null) {
			strs = new ArrayList<String>();
			groups.put(1, strs);
		} 
		
		strs.add(ss);
	}
}

class A {

	int age;
	String name;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	/*@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (this == obj) 
			return true;
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		A a = (A)obj;
		if (a.age != age) {
			return false;
		}
		if (a.name == null) {
			if (name != null) {
				return false;
			}
		}else if (!name.equals(a.name)) {
			return false;
		}
		return true;
	}*/
	
}
