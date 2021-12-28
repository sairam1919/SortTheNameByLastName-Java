package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.JavaTest;

class SortTheStringbyLastNameTest {
	
	@Test
	void test() {
		String[] args = new String[]{"src\\main\\unsorted-names-list"};
		String response = JavaTest.service(args);
		assertEquals("Data written to the file successfuly", response, "Success case");
	}

	@Test
	void test1() {
		String[] args = null;
		String response = JavaTest.service(args);
		assertEquals(null, response, "Failure case");
	}
	
	@Test
	void test2() {
		String[] args = new String[0];
		String response = JavaTest.service(args);
		assertEquals("No valid file path provided as argument", response, "Failure case");
	}
	
	@Test
	void test3() {
		String[] args = new String[]{"src\\main\\unsorted1-names-list"};
		String response = JavaTest.service(args);
		assertEquals("Error while Reading the File Data", response, "Failure case");
	}
	
	@Test
	void test4() {
		String[] args = new String[]{"src\\main\\unsorted-names-list"};
		JavaTest.main(args);
		assertTrue(true);
	}

}
