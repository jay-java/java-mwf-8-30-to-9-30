package core;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class HashTableDemo {
	public static void main(String[] args) {
		Map map = new Hashtable();
		map.put(1, "c"); //entry
		map.put("java", "java");
		map.put(null, "c++");
//		map.put(null, "python");
		System.out.println(map);
		Set set = map.entrySet();
		Iterator itrIterator = set.iterator();
		while(itrIterator.hasNext()) {
			Map.Entry entery = (Entry) itrIterator.next();
			System.out.println("key : "+entery.getKey());
			System.out.println("value : "+entery.getValue());
//			System.out.println(itrIterator.next());
		}
	}
}
