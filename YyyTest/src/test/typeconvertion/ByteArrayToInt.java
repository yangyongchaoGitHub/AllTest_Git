package test.typeconvertion;

import java.nio.ByteBuffer;

public class ByteArrayToInt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str="012345000";
		ByteBuffer buff=ByteBuffer.wrap(str.getBytes());
		/*buff.get();
		buff.get();
		buff.get();
		buff.get();*/
		byte[] bytes = new byte[4];
		//System.out.println(buff.get(bytes));
		buff.get(bytes);
		int id=0;
		System.out.println(bytes[3]);
		System.out.println(id=c2n(bytes));
		System.out.println(n2c(id)[3]);
		System.out.println(buff.get());
		
	}
	//将字节数组转化为int
	public static int c2n(byte[] b) {
        int n =0;
        for(int i=0; i<4; i++) {
            int shift = (4-1-i)*8;
            n += (b[i] & 0x000000FF) << shift;
        }
        return n;
    }
	//将int转化为byte
	private static byte[] n2c(int n) {
        byte[] b = new byte[4];
        for(int i=0; i<b.length; i++)
            b[3-i] = (byte) (n >>> (i*8));
        return b;
    }
}

