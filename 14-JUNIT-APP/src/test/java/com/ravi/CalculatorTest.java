package com.ravi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

	@Test
	public void addTest() {
		Calculator calculator = new Calculator();
		int actualResult = calculator.add(10, 20);
		int expectedResult = 30;
		assertEquals(actualResult, expectedResult);
	}
	
	@Test
	public void divTest() {
		Calculator calculator = new Calculator();
		int actualResult = calculator.div(10, 2);
		int expectedResult = 5;
		assertEquals(actualResult, expectedResult);
	}
}
