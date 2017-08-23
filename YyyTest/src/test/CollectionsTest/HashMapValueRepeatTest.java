package test.CollectionsTest;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HashMapValueRepeatTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, String> m1 = new HashMap<String, String>();
		m1.put("1", "2");
		m1.put("1", "2");
		m1.put("1", "2");
		m1.put("1", "2");
		System.out.println(m1.size());
	}

}
