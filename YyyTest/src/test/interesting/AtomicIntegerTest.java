package test.interesting;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicIntegerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AtomicLong courrent = new AtomicLong();
		System.out.println(courrent.incrementAndGet());
		System.out.println(courrent.incrementAndGet());
	}

}
