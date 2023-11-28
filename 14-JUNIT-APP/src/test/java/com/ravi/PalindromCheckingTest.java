package com.ravi;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PalindromCheckingTest {

	@ParameterizedTest
	@ValueSource(strings = {"racecar","madam","liril","ravi"})
	public void isPalindromeTest(String str) {
		PalindromeChecking p = new PalindromeChecking();
		boolean actualResult = p.isPalindrome(str);
		if(str.equals("ravi")) {
			assertFalse(actualResult);
		}else {
			assertTrue(actualResult);
		}
	}
}
