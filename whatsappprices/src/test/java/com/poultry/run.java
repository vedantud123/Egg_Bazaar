package com.poultry;

public class run {

	public static void main(String[] args) {
		String value = "maderf";
		
		String value2 = new StringBuilder(value).reverse().toString();
		
		if(value.equals(value2)) {
			System.out.println("It is a palindrome");
		}else {
			System.out.println("It is not a palindrome");
		}
		
	}

}
