package test.typeconvertion;

import java.nio.ByteBuffer;

public class AByte {

	final static int OFFSET_RSN=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte d = (byte) 0x80;
		//System.out.println((d & 0xff) / 100);
		System.out.println(((d >> 7) & 0x1) + "-" +
	            ((d >> 6) & 0x1) + "-" +
	            ((d >> 5) & 0x1) + "-" +
	            ((d >> 4) & 0x1) + "-" +
	            ((d >> 3) & 0x1) + "-" +
	            ((d >> 2) & 0x1) + "-" +
	            ((d >> 1) & 0x1) + "-" +
	            ((d >> 0) & 0x1) + "// " + (d & 0x80));
		
		//System.out.println(rsn(false, 390));
		int sendrsn = rsn(false, 390);
		System.out.println("sendrsn >> 16 & 255 = " + (sendrsn >> 16 & 255) +
						"  sendrsn >> 8 & 255 = " + (sendrsn >> 8 & 255) +
						"  sendrsn >> 0 & 255 = " + (sendrsn >> 0 & 255));
		ByteBuffer bbsend = ByteBuffer.allocate(3);
		bbsend.put(0, (byte)(sendrsn >> 16 & 255));
		bbsend.put(1, (byte)(sendrsn >> 8 & 255));
		bbsend.put(2, (byte)(sendrsn >> 0 & 255));
		System.out.println("decode sn = " + sn(bbsend) + 
				" isresponse = " + isResponse(bbsend)
				);
	}

	static final int rsn(boolean isResponse, int v) {
        return isResponse?8388608 | v:v;
    }
	
	static int sn(ByteBuffer raw) {
		return rsn(raw) & 0x7fffff;
	}
	
	static int rsn(ByteBuffer hdr){
		System.out.println("1 ||| = " + ((hdr.get(OFFSET_RSN) & 0xff)<<16) + 
				"2 ||| = " + ((hdr.get(OFFSET_RSN+1) & 0xff)<<8) + "3 ||| = " + (hdr.get(OFFSET_RSN+2) & 0xff));
		
		return (hdr.get(OFFSET_RSN)<<16) | (hdr.get(OFFSET_RSN+1)<<8) | hdr.get(OFFSET_RSN+2);
	}
	
	static boolean isResponse(ByteBuffer raw) {
		return (rsn(raw) & 0x800000) != 0 ? true : false;
	}	
}
