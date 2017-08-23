package test.bytebufferTest;

import java.nio.ByteBuffer;

public class PositionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ByteBuffer b = ByteBuffer.allocate(100);
		
		for(int i = 0; i< b.capacity()-50; i++) {
			b.put((byte) 0x05);
		}
		byte[] bb = {0x02, 0x03, 0x04, (byte) 0x99};
		
		System.out.println(b.position());
		
		System.arraycopy(bb, 0, b.array(), b.position(), bb.length);
		
		System.out.println(b.position());
		//b.flip();
		b.clear();
		b.put((byte) 0x08);
		b.put((byte) 0x08);
		b.put((byte) 0x08);
		b.put((byte) 0x08);
		b.get();
		b.get();
		b.get();
		b.get();
		b.get(40);
		System.out.println(b.get(52));
		for(int o = 0; o < 56; o++) {
			System.out.println(b.get(o) + "posotion = " + b.position());
		}
	}
}
