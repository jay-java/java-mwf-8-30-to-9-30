package collectionType;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {
	private int id;
	private String name;
	private List<Long> contact;
	private Set<String> strings;
	private Map<Integer, String> maps;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Long> getContact() {
		return contact;
	}

	public void setContact(List<Long> contact) {
		this.contact = contact;
	}

	public Set<String> getStrings() {
		return strings;
	}

	public void setStrings(Set<String> strings) {
		this.strings = strings;
	}

	public Map<Integer, String> getMaps() {
		return maps;
	}

	public void setMaps(Map<Integer, String> maps) {
		this.maps = maps;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", contact=" + contact + ", strings=" + strings + ", maps=" + maps
				+ "]";
	}

}
