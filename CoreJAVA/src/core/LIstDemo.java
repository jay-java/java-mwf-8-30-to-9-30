package core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
//<generics>
public class LIstDemo {
	public static void main(String[] args) {
		List list  = new ArrayList();
		list.add(1);
		list.add("name");
		list.add('a');
		list.add(false);
		list.add(45.4);
		list.add(34565687);
		list.add(1);
		System.out.println(list);
		System.out.println("size of list : "+list.size());
		list.remove(3);
		list.add(3, true);
		System.out.println(list);
		Iterator itrIterator = list.iterator();
		while(itrIterator.hasNext()) {
			System.out.println(itrIterator.next());
		}
	}
}
