package test.stringTest;

import java.util.zip.CRC32;

public class StringLength {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String longString = "风雨不欲阻，建立一个UDP的Socket，这里使用的指令是AT+NSOCR=DGRAM,17,5681,1，第一个参数这"
				+ "里暂时只支持DGRAM，第二个参数是设置Socket使用协议编号，17表示UDP协议，5681为本地socket使用的端口号，官方"
				+ "参考例子使用的是一般默认的5638,实际测试发现无法设置成功，返回错误。因为使用了自动配置模式，可能是该端口已经"
				+ "被占用，用于coap协议。返回0  OK表示建立"
				+ "成功。模块一共支持建立7个Socket，序号分别从0-6自动分配，在收发数据时需要指定是哪个Socket";
		String str = "15-15-26";
		System.out.println(str.length() + "");
		System.out.println(Double.MAX_VALUE);
		System.out.println(Integer.MAX_VALUE + " " + (Integer.MAX_VALUE+"").length());
		
	}
}
