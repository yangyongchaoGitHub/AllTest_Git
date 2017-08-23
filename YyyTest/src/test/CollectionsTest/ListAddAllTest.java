package test.CollectionsTest;

import java.awt.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class ListAddAllTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<String> list1 = new LinkedList<String>();
		LinkedList<String> list2 = new LinkedList<String>();
		ArrayList<Human> list3 = new ArrayList<Human>();
		ArrayList<Human> list4 = new ArrayList<Human>();
		
		list1.add("1");
		list1.add("2");
		list1.add("3");
		
		list2.add("4");
		list2.add("5");
		
		//list1.addAll(list2);
		//list3.addAll(list2);
		//list4.addAll(list3);
		
		for (String str: list1) {
			System.out.println(str);
		}
		
		list3.add(new Human());
		list3.add(new Human());
		list3.add(new Human());
		list3.add(new Human());
		
		list4.addAll(list3);
		
		for (int i = 0; i < list4.size() ; i++) {
			for (int j = 0; j < list3.size(); j++) {
				list4.remove(list3.get(j));
			}
		}
		System.out.println(list4.size());
		System.out.println(list3.size());
	}
}

class Human{
	int age;
}
