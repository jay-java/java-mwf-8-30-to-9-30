package com.orm;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	private int id;
	private String name;
	private long contat;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(int id, String name, long contat) {
		super();
		this.id = id;
		this.name = name;
		this.contat = contat;
	}

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
	public long getContat() {
		return contat;
	}
	public void setContat(long contat) {
		this.contat = contat;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", contat=" + contat + "]";
	}
	
}
