package test.interesting;

public class Threshold {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int total3 = 109;
		int total = 120;
		int total1 = 100;
		int pagesize = 20;
		int total2 = 121;
		int total4 = 132;
		System.out.println(total/pagesize);
		System.out.println(total2/pagesize);
		System.out.println(total4/pagesize);
		
		System.out.println(total%pagesize);
		System.out.println(total2%pagesize);
		System.out.println(total4%pagesize);
		
		System.out.println("totalpage = " + ((total/pagesize) + ((total%pagesize) > 0 ? 1:0)));
		System.out.println("totalpage = " + ((total1/pagesize) + ((total1%pagesize) > 0 ? 1:0)));
		System.out.println("totalpage = " + ((total3/pagesize) + ((total3%pagesize) > 0 ? 1:0)));
		System.out.println("totalpage = " + ((total2/pagesize) + ((total2%pagesize) > 0 ? 1:0)));
		System.out.println("totalpage = " + ((total4/pagesize) + ((total4%pagesize) > 0 ? 1:0)));
	}

}
