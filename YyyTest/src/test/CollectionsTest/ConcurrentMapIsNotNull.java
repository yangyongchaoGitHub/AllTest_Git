package test.CollectionsTest;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ConcurrentMapIsNotNull {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConcurrentMap<Integer, String> fds = new ConcurrentHashMap<Integer, String>();
		fds.put(111, null);
		System.out.println(fds.size());
	}

}
