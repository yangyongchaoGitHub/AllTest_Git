package test.timeTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarToSDF {

	static Calendar calendar = Calendar.getInstance();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*calendar.set(2016, 12, 01);
        Date startTime = calendar.getTime();
        Date test = new Date((long)0);
        System.out.println(startTime.getTime());
        System.out.println(test.getTime());*/
		
		/*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		System.out.println(sdf.format(new Date((long)0)));*/
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdf.format(date));
		System.out.println(sdf1.format(date));
		try {
			date = sdf1.parse(sdf.format(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(sdf.format(date));
		System.out.println(sdf1.format(date));
		
		Date startTime = new Date();
		Date endTime = new Date();
		try {
			endTime = sdf.parse("1992-5-13-0-0-0");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(((startTime.getTime() - endTime.getTime()) / (1000 * 3600 * 24)));
		
		calendar.set(2016, 10, 11);
		date = calendar.getTime();
		System.out.println(date.equals(calendar.getTime()));
		calendar.set(2011, 11, 11);
		System.out.println(date.equals(calendar.getTime()));
		
	}
}
