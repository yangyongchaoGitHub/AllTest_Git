package test.timeTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ADayDateLongValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		System.out.println(System.currentTimeMillis());
		
		try {
			System.out.println(sdf.parse("2016-08-23 00:00:00").getTime());
			System.out.println(sdf.parse("2016-08-24 00:00:00").getTime());
			System.out.println(sdf.parse("2016-08-24 00:00:00").getTime() - sdf.parse("2016-08-23 00:00:00").getTime());
			
			
			
			System.out.println(sdf.parse("2017-10-01 00:00:00").getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
