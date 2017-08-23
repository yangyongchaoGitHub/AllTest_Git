package test.interesting;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Input {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
        try {

            date = sdf.parse("2016-07-10 00:00:00");

        } catch (ParseException e) {
            e.printStackTrace();
        }

        double flowing = 0;
        double heating = 0;
        long aday = 86400000;
		
		   for (int i = 0; i< 100 ; i++) {
			   long idate = date.getTime() + aday*i;
			   
	            for (int j = 0; j < 3; j++) {

	            	String currdate = sdf.format(aday / (3 - j) + idate);
	            	flowing = (1 + Math.random()) * 5;
	                heating = (1 + Math.random()) * 10;
	                try {
						System.out.println(flowing + "  " + heating + " " + currdate + " " + sdf.parse(currdate).getTime());
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            }
		   }
	}
}
