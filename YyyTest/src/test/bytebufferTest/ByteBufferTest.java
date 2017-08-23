package test.bytebufferTest;

import java.nio.ByteBuffer;

public class ByteBufferTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println((0x0d & 0x7f) | 0x80);
		/*System.out.println(0x0d & 0x80);
		System.out.println(0x8d);*/
		
		//test1();
		ByteBuffer bb = ByteBuffer.allocate(7);
		ByteBuffer bblong = ByteBuffer.allocate(15);
		bblong.put((byte) 0x01);
		bblong.put((byte) 0x02);
		bblong.put((byte) 0x03);
		bblong.put((byte) 0x03);
		bblong.put((byte) 0x04);
		bblong.put((byte) 0x05);
		bblong.put((byte) 0x06);
		bblong.put((byte) 0x07);
		bblong.put((byte) 0x08);
		bblong.put((byte) 0x09);
		bblong.put((byte) 0x11);
		bblong.put((byte) 0x12);
		bblong.put((byte) 0x13);
		bblong.put((byte) 0x14);
		//bblong.limit(0);
		bblong.flip();
		
		bblong.get();
		bblong.get();
		System.out.println(getAddress((bblong.get(ByteBuffer.allocate(7).array(), 0, 7)).array()));
		
		
	}

	private static void test1() {
		// TODO Auto-generated method stub
		ByteBuffer bb1 = ByteBuffer.allocate(3);
		bb1.put((byte) 0x99);
		bb1.put((byte) 0x45);
		bb1.put((byte) 0x03);
		for (byte b : bb1.array()) {
			System.out.println((b >>4 & 0x0f) + "" + (b & 0x0f));
		}
		
		ByteBuffer b1 = ByteBuffer.allocate(10);
		ByteBuffer b2 = ByteBuffer.allocate(10);
		
		System.arraycopy(b1.array(), 0, b2.array(), b2.position(), b1.position());
		//b2 = b1;
		System.out.println(b1.position());
		b1.put((byte) 0x01);
		b1.put((byte) 0x02);
		b1.put((byte) 0x03);
		System.out.println(b1.position());
		System.out.println(b1.array()[0]);
		b1.clear();
		System.out.println(b1.position());
		b2.put((byte) 0x04);
		
		//System.arraycopy(b1.array(), 0, b2.array(), b2.position(), b1.position());
		//b2.put(b1);
		
		
		for (int i = 0; i < b2.array().length; i++) {
			System.out.println(b1.array()[i]);
			System.out.println(b2.array()[i]);
		}
	}
	
	public static String getAddress(byte[] address) {
        String str = "";
        for (int i = 0; i < address.length; i++) {
            if (i == (address.length - 1)) {
                str += toHex(address[i]);
            }else {
                str += toHex(address[i]);
            }
        }
        return str;
    }
	
	public static String toHex(byte b) {
        String result = Integer.toHexString(b & 0xFF);
        if (result.length() == 1) {
            result = '0' + result;
        }
        return result;
    }
}
