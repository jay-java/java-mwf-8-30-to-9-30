package com.core;

public class User {
	private int id;
	private String name;
	private long contact;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(int id, String name, long contact) {
		super();
		System.out.println("setting values by cons");
		this.id = id;
		this.name = name;
		this.contact = contact;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		System.out.println("settting iD");
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		System.out.println("setting name");
		this.name = name;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		System.out.println("setting contact");
		this.contact = contact;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", contact=" + contact + "]";
	}
	
}
