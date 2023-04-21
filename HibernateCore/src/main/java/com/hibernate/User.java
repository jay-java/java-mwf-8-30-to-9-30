package com.hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	private int id;
	private String name;
	private double value;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String name, double value) {
		super();
		this.id = id;
		this.name = name;
		this.value = value;
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
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", value=" + value + "]";
	}
	
}
