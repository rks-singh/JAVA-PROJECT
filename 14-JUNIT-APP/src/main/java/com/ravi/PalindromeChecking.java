package com.ravi;

public class PalindromeChecking {

	public boolean isPalindrome(String str) {
		
		StringBuffer sb = new StringBuffer(str);
		String reverseStr = sb.reverse().toString();
		if(reverseStr.equals(str)) {
			return true;
		}else {
			return false;
		}
	}
}
