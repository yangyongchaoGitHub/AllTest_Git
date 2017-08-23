package test.typeconvertion;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.zip.CRC32;

/**
 * will have a hwaddress to byte
 * @author Administrator
 *
 */
public class StringToByte {
	
	private static String hexString = "0123456789ABCDEF";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//part 1
		/*String str = "2a-33-a0-22-66-cc-11";
		String[] addresss = str.split("-");
		String s = "";
		byte[] b = new byte[7];
		for (int i = 0; i < addresss.length; i++) {
            //System.out.println(addresss[i].getBytes()[0] + " - " +addresss[i].getBytes()[1]);
            //int j = hexString.charAt(addresss[i].getBytes()[0]) * 10;
            //int k = hexString.charAt(addresss[i].getBytes()[1]);
            System.out.print((hexString.indexOf(addresss[i].toUpperCase().charAt(0)) * 16)
            		+ hexString.indexOf(addresss[i].toUpperCase().charAt(1)) + " ");
            b[i] = (byte) ((hexString.indexOf(addresss[i].charAt(0)) * 16)
            		+ hexString.indexOf(addresss[i].charAt(1)));
            //42 51 160 34 102 204 17 
        }*/
		
		//part 2
		/*String str = "2a33a02266cc11";
		char[] address = str.toUpperCase().toCharArray();
		byte[] b = new byte[7];
		for (int i = 0; i < address.length; i = i + 2) {
			System.out.println(hexString.indexOf(address[i])*16 + 
					hexString.indexOf(address[i+1]));
			b[i] = (byte) (hexString.indexOf(address[i])*16 + 
					hexString.indexOf(address[i+1]));
        }*/
		
		
		/*String str = "2a33a02266cc11";
		char[] address = str.toUpperCase().toCharArray();
		byte[] b = new byte[7];
		for (int i = 0; i < address.length; i = i+2) {
			System.out.println(String.valueOf(address[i]) + String.valueOf(address[i+1]) + "   " + i/2);
        }*/
		//System.out.println(SHA("apple"));
		System.out.println(crc32("test"));
		
	}
	/*public static String SHA(String decript) {
		try {
			MessageDigest digest = java.security.MessageDigest
					.getInstance("SHA");
			digest.update(decript.getBytes());
			byte messageDigest[] = digest.digest();
			// Create Hex String
			StringBuffer hexString = new StringBuffer();
			// 字节数组转换为 十六进制 数
			for (int i = 0; i < messageDigest.length; i++) {
				String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
				if (shaHex.length() < 2) {
					hexString.append(0);
				}
				hexString.append(shaHex);
			}
			return hexString.toString();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return "";
	}*/
	public static long crc32(String decript) {
        CRC32 crc32 = new CRC32();
        crc32.update(decript.getBytes());
        return crc32.getValue();
    }
	
}
