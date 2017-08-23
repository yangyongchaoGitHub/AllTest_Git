package test.interesting;

public class GlobalVariable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        People people = new People();
        people.using.age = 100;
		people.update();
		int a = people.using.age;
	}
}

class Using{
	String name = "222";
	int age = 0;
}

class Police{
	String name;
	NameNote nn;
	public void output() {
		System.out.println(nn.name + nn.age);
	}
}

class NameNote{
	String name;
	int age;
}

class People{
	static Police police;
	Using using = new Using();
	
	public void update() {
		/*Using u = new Using();
		u.name = "666";
		using = u;*/
		PeopleMapper mapper = new PeopleMapper();

		mapper.us_back = new Using();
		mapper.us_back.name = "face";
		mapper.set(using);
		using = mapper.e();
		pl(mapper.i());
		
		System.out.println(using.name + using.age);
	}
	
	public void pl(Using us) {
	
		police = new Police();
		//police.name = using.name;
		police.nn = new NameNote();
		police.nn.name = us.name;
		police.nn.age = us.age;
		police.output();
		//System.out.println(using.name);
	}
}

class PeopleMapper{
	Using us;
	Using us_back;
	
	public void set(Using u) {
		this.us = u;
	}
	
	public Using e() {
		us.name = "mapper";
		return us;
	}
	
	public Using i() {
		us_back.age = us.age;
		return us_back;
	}
}
