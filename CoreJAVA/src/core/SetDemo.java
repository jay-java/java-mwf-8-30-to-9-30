package core;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetDemo {
	public static void main(String[] args) {
		Set set = new HashSet();
		set.add(1);
		set.add("java");
		set.add(false);
		set.add('g');
		set.add(4544.4);
		set.add(null);
		System.out.println(set);
		Iterator itrIterator = set.iterator();
		while(itrIterator.hasNext()) {
			System.out.println(itrIterator.next());
		}
	}
}
