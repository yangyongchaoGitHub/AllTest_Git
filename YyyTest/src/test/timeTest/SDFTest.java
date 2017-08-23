package test.timeTest;

import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SDFTest {
	
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(System.currentTimeMillis());
		try {
			System.out.println(sdf.parse("2017-03-07 03:52:46").getTime());
			for (String str: getdataArray(sdf.parse("2017-03-07 03:52:46"))) {
				System.out.println(str);
			}
			System.out.println(getprivatePswd());
			
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public static String[] getdataArray(Date date) {

        String nowDate = sdf.format(date);
        return nowDate.split("-");
    }
	
	public static String getprivatePswd() {
        String[] currDateArrayym;
		try {
			currDateArrayym = sdf.format(sdf.parse("2017-03-07 07:15:46").getTime()).split("-");
			String[] currDateArraydhms = currDateArrayym[2].split(" ");
			String[] currDateArrayhms = currDateArraydhms[1].split(":");
			System.out.println(currDateArrayym[0] + " " + 
        					currDateArrayym[1] + " " + 
        					currDateArraydhms[0] + " " + 
        					currDateArrayhms[0] + " " + 
        					(Integer.parseInt(currDateArrayhms[0]) + 1));
			return SHA("agivision" + currDateArrayym[0] + currDateArrayym[1] + currDateArraydhms[0] + (currDateArrayhms[0])).substring(10, 16);
        } catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "";
    }
	
	public static String SHA(String decript) {
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

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
