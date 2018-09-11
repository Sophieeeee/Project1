package test;

import implementation.SearchMap;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestSearchMap {

	@Test
	public void testRemoveWhiteSpace() {
		String result = SearchMap.removeWhiteSpace("one two three four");
		assertEquals("onetwothreefour", result);
	}
	
}
