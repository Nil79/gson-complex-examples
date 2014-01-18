package com.nicolasodano.gson.example1;

public class Contact {
	private int id;
	private String name;
	private Address[] addresses;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Address[] getAddresses() {
		return addresses;
	}
	public void setAddresses(Address[] addresses) {
		this.addresses = addresses;
	}
	
	
}
