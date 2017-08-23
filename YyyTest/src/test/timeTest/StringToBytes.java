package test.timeTest;

import java.text.SimpleDateFormat;

public class StringToBytes {

	
	public static SimpleDateFormat sdf_nospace = new SimpleDateFormat("yyyyMMddHHmmss");
	static String hexString = "0123456789ABCDEF";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String data = sdf_nospace.format(System.currentTimeMillis());
		System.out.println(data);
		byte[] b = data.getBytes();
		for (byte c : b) {
			System.out.println(c);
		}
		
		byte[] c = addrToBytes(data);
		for (byte c2 : c) {
			System.out.println(c2);
		}
	}

	public static byte[] addrToBytes(String addrstr) {
        if (addrstr.length() != 14) {
            return null;
        }
        char[] address = addrstr.toUpperCase().toCharArray();

        byte[] addrBytes = new byte[7];
        for (int i = 0; i < address.length; i = i + 2) {
            addrBytes[i / 2] = (byte) (hexString.indexOf(address[i]) * 16 +
                    hexString.indexOf(address[i + 1]));
        }
        return addrBytes;
    }
}
