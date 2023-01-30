package core;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapDemo {
	public static void main(String[] args) {
		Map map = new HashMap();
		map.put(1, "c"); //entry
		map.put("java", "java");
		map.put(3, "c++");
		map.put(3, "python");
		map.put(null, null);
		map.put(null, 324);
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
