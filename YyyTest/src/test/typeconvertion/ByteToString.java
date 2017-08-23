package test.typeconvertion;

import java.nio.ByteBuffer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class ByteToString {
	final static public byte[] memoryBytes = new byte[1024];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	        /*SimpleDateFormat format = new SimpleDateFormat("MMddHHmmss", Locale.getDefault());
	        Date date = new Date();
	        String key = format.format(date);

	        Random r = new Random();
	        key = key + r.nextInt();
	        System.out.println(key);
	        key = key.substring(0, 15);
	        System.out.println(key);*/
		/*byte[] bs = new byte[]{0x10, 0x01};
		System.out.println(bs[0] + "" + bs[1]);*/
		/*String str = "0x2e";
		ByteBuffer buffer = ByteBuffer.allocate(str.length());
		buffer.put(str.getBytes());
		System.out.println(new String(buffer.array()));*/
		
		//System.out.println(bytess.length);
		/*byte s = (byte) 0xee;
		System.out.println(s & 0xff);*/
		/*byte[] data = new byte[]{68, 20, 51, 21, 31, 17, 00, 11, 11, 81, 0x2E, 0x1F, 90, 12, 00, 00, 00, 00, 05, 00, 
				00, 00, 00, 05, 00, 00, 00, 00, 14, 00, 00, 00, 00, 35, 19, 00, 00, 00,
				0x2C, 76, 30, 00, 68, 30, 00, 73, 02, 00, 32, 41, 11, 12, 0x09, 07, 20, 04, 00, (byte) 0xE9, 16};*/
		byte[] data = new byte[]{0x68, 0x20, 0x26, 0x72, 0x15, 0x11, 0x10, 0x20, 0x00, (byte) 0x81, 0x2E, (byte) 0x90, 0x1F, 0x00, 0x00, 0x00, 0x00, 
				0x00, 0x05, 0x21, 0x03, 0x00, 0x00, 0x05, 0x49, 0x16, 0x76, 0x09, (byte) 0x91, 0x00, 0x00, 0x00, 0x00, 0x35, (byte) 0x93, 0x24, 0x00, 0x00, 0x2C,
				0x48, 0x16, (byte) 0xB7, 0x63, 0x15, 0x24, 0x03, 0x00, 0x00, 0x07, 0x30, 0x15, 0x27, 0x12, 0x10, 0x20, 0x00, 0x00, (byte) 0xF2, 0x16};
		
		String cooler = getHex(new byte[]{data[17], data[16], data[15], data[14]});
        String heat = getHex(new byte[]{data[22], data[21], data[20], data[19]}) + "." + getHex(new byte[]{data[25], data[24]});
        String water = getHex(new byte[]{data[37], data[36], data[35], data[34]}) + "." + getHex(new byte[]{data[28], data[27], data[26]});
        String flowRate = getHex(new byte[]{data[32], data[31]}) + "." + getHex(new byte[]{data[30], data[29]});
        String tempWaterSupply = getHex(new byte[]{data[40]}) + "." + getHex(new byte[]{data[39]});
        String tempWaterReturn = getHex(new byte[]{data[43]}) + "." + getHex(new byte[]{data[42]});

        String uptime = getHex(new byte[]{data[47], data[46], data[45]});
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String ts = getHex(new byte[]{data[54], data[53], data[52], data[51], data[50], data[49], data[48]}); 
        try {
			ts = format2.format(format.parse(ts));
		} catch (ParseException e) {
			e.printStackTrace();
		}
        String heatmeterStatus = getHex(new byte[]{data[56], data[55]});

		System.out.println("cooler = " + cooler + " | " + "heat = " + heat + " | " + "water = " + water + " | " + 
				"flowRate = " + flowRate + " | " + "tempWaterSupply = " + tempWaterSupply + " | " + 
				"tempWaterReturn = " + tempWaterReturn + " | " + "uptime = " + uptime + " | " + "ts = " + ts + " | " + 
				"heatmeterStatus = " + heatmeterStatus);
	}
	
	private static String getHex(byte[] bytes) {
		String result = "";
		for(byte b: bytes) {
			String str = Integer.toHexString(b & 0xFF);
	        if (str.length() == 1) {
	        	str = '0' + str;
	        }
	        result += str;
		}
		return result;
	}
}