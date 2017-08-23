package test.typeconvertion;

public class ByteToDoubleInteface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte[] raw = {0x01, 0x02, 0x03, 0x04, 0x15, 0x56, 0x77, 0x08, 0x09, 0x10, 0x11, 0x30, 0x11, 0x02, 0x10, 0x17, 0x20};
		double db = (raw[6] >> 4 & 0x0f) * 100000 + (raw[6] & 0x0f) * 10000 +
		        (raw[5] >> 4 & 0x0f) * 1000 + (raw[5] & 0x0f) * 100 +
		        (raw[4] >> 4 & 0x0f) * 10 + (raw[4] & 0x0f) +
		        (raw[3] >> 4 & 0x0f) * 0.1 + (raw[3] & 0x0f) * 0.01;
		double db2 = (raw[6] & 0xff) * 10000 +
		        (raw[5] & 0xff) * 100 +
		        (raw[4] & 0xff) +
		        (raw[3] & 0xff) * 0.01;
		double db3 = ((((raw[3] & 0xf0) >> 4) * 10 + (raw[3] & 0x0f)) * 1000000 +
                (((raw[4] & 0xf0) >> 4) * 10 + (raw[4] & 0x0f)) * 10000 +
                (((raw[5] & 0xf0) >> 4) * 10 + (raw[5] & 0x0f)) * 100 +
                (((raw[6] & 0xf0) >> 4) * 10 + (raw[6] & 0x0f)) * 1.00);
		System.out.println(db);
		System.out.println(db2);
		System.out.println(db3);
		System.out.println(getDoubleByReveres(raw, 3, 6, 0.01, 10));
		System.out.println(getDoubleByReveres(raw, 3, 6, 100000, 0.1));
		System.out.println(getDoubleByPositive(raw, 3, 6, 1, 10));
		System.out.println(getDoubleByPositive(raw, 3, 6, 1000000, 0.1));
		System.out.println(gettimesTamp(raw, 10));
	}
	
	public static double getDoubleByReveres(byte[] raw, int star, int end, double base, double mult) {
	    if (star > end) {
	        return 0;
	    }
	    return (raw[star] & 0x0f) * base + (raw[star] >> 4 & 0x0f) * (base*mult) + 
	    		getDoubleByReveres(raw, ++star, end, base*mult*mult, mult);
	}
	
	public static double getDoubleByPositive(byte[] raw, int star, int end, double base, double mult) {
	    if (star > end) {
	        return 0;
	    }
	    return (raw[end] & 0x0f) * base + (raw[end] >> 4 & 0x0f) * (base*mult) + 
	    		getDoubleByPositive(raw, star, --end, base*mult*mult, mult);
	}
	
	public static String gettimesTamp(byte[] raw, int start) {
		return (raw[start+6] >> 4 & 0x0f) + "" + (raw[start+6] & 0x0f) + "" +
                (raw[start+5] >> 4 & 0x0f) + "" + (raw[start+5] & 0x0f) + "-" +
                (raw[start+4] >> 4 & 0x0f) + "" + (raw[start+4] & 0x0f) + "-" +
                (raw[start+3] >> 4 & 0x0f) + "" + (raw[start+3] & 0x0f) + " " +
                (raw[start+2] >> 4 & 0x0f) + "" + (raw[start+2] & 0x0f) + ":" +
                (raw[start+1] >> 4 & 0x0f) + "" + (raw[start+1] & 0x0f) + ":" +
                (raw[start] >> 4 & 0x0f) + "" + (raw[start] & 0x0f);
	}
}
