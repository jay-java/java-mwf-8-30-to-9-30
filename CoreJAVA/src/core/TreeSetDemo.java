package core;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetDemo {
	public static void main(String[] args) {
		Set set = new TreeSet();
		set.add(-211);
		set.add(22);
		set.add(-36);
		set.add(0);
		set.add(56845);
		set.add(10);
		System.out.println(set);
		Iterator itrIterator = set.iterator();
		while(itrIterator.hasNext()) {
			System.out.println(itrIterator.next());
		}
	}
}
