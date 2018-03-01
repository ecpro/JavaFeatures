package com.piyush.core;

public class StringABC {
	public String x;
	
	@Override
	public boolean equals(Object that) {
		if(that == null) return false;
		if(this == that) {
			return true;
		}
		if(that instanceof StringABC) {
			that = (StringABC) that;
			return this.x.equals(((StringABC) that).x);
		}
		if(that instanceof String) {
			that = (String) that;
			return this.x.equals(that);
		}
		return false;
	}
	
	public static void main(String[] args) {
		StringABC abc = new StringABC();
		abc.x = "xyz";
		System.out.println(abc.equals("xyz"));
		
		System.out.println("xyz".equals(abc));
	}
}
