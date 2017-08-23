package test.stringTest;

import java.nio.ByteBuffer;

public class StringSub {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String it = "122 ";
		String show = "";
		int i = 0;
		if (it.length() > 2) {
	        do {
				show += it.substring(i, i + 2) + " ";
				i += 2;
	        } while(i < it.length()-2);
	        show += it.substring(i, it.length());
        } else {
        	show = it;
        }
        System.out.println(show);
        
		/*String it = "testster";
		int i = 0;
        do {
            System.out.println(it.substring(i, i + 2));
            i += 2;
        } while(i < it.length());*/
		
		/*String it = "testster";
		it = it.substring(0, it.length() - 1);
		System.out.println(it);*/
		
		/*ByteBuffer buffer = ByteBuffer.allocate(0);
		if (buffer == null) {
			System.out.println(-31 & 0x01);
		}
		System.out.println(buffer.array());*/
	}
}
