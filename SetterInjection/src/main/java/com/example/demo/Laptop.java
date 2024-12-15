package com.example.demo;

public class Laptop {
	OS os;
	
	public void build() {
		os.operate();
		System.out.println("Laptop is building");
	}
	
	public void setOs(OS os) {
		this.os = os;
	}
	
}
