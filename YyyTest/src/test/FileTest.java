package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class FileTest {

	public static void main(String[] args) {
		//File file = new File("");
		//file = new File(file.getAbsolutePath() + "/src/test/test.txt");
		File file = new File("d:/test.txt");
		System.out.println(file.getAbsolutePath());
		update(file);

	}
	private static synchronized void update(File file) {
		FileOutputStream fos = null;
		BufferedReader br = null;
		String s = "";
		try {
			br = new BufferedReader(new FileReader(file));
			int i;
			s = br.readLine();
			System.out.println(s);
			if (s != null) {
				i = Integer.parseInt(s);
			} else {
				i = 0;
			}
			i++;
			
			fos = new FileOutputStream(file);

			byte[] o = (i+"").getBytes();
			System.out.println(new String(o));
			fos.write(o);
			fos.flush();
			fos.close();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
