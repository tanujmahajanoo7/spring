package com.example.demo;

public class Laptop {
	OS os;
	public Laptop(OS os) {
		this.os=os;
	}
	public void build() {
		os.operate();	
		System.out.println("Laptop is building");
	}
}
