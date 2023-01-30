package core;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class VectorDemo {
	public static void main(String[] args) {
		Vector list  = new Vector();
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
		Enumeration enumeration  = list.elements();
		while(enumeration.hasMoreElements()) {
			System.out.println(enumeration.nextElement());
		}
//		Iterator itrIterator = list.iterator();
//		while(itrIterator.hasNext()) {
//			System.out.println(itrIterator.next());
//		}
	}
}
