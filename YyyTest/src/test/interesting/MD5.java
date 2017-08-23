package test.interesting;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(SHAL("123456") + " | " + SHAS("123456"));
	}
	
	public static String SHAL(String decript) {
        try {
            MessageDigest digest = MessageDigest
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
    }

	public static String SHAS(String decript) {
        try {
            MessageDigest digest = java.security.MessageDigest
                    .getInstance("SHA");

            digest.update(decript.getBytes());
            return getString(digest.digest());

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
	
	public static String getString(byte[] strs) {
        String str = "";
        for (byte  b: strs) {
            str += toHex(b);
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
