package test.typeconvertion;
/**
 * String to byte
 */
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringDateToByte {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");

        String[] sdfDate = sdf.format(new Date()).split("-");
        byte[] Y = sdfDate[0].getBytes();
        byte[] M = sdfDate[1].getBytes();
        byte[] D = sdfDate[2].getBytes();
        byte[] H = sdfDate[3].getBytes();
        byte[] m = sdfDate[4].getBytes();
        byte[] s = sdfDate[5].getBytes();
        System.out.println(Y[0] & 0x0f);
        System.out.println(Y[1] & 0x0f);
        System.out.println(Y[2] & 0x0f);
        System.out.println(Y[3] & 0x0f);
        System.out.println(M[0] & 0x0f);
        System.out.println(M[1] & 0x0f);
        System.out.println(H.length);
        System.out.println(m.length);
	}

}
