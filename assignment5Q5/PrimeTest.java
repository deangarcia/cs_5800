package assignment5Q5;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PrimeTest {
	
	public PrimeTest(){
		
	}
	
	Prime prime = new Prime();
	
	@Test
	public void test1() {
		assertTrue(1 + " should be prime.", this.prime.isPrime(1));
	}
	@Test
	public void test2() {
		assertTrue(2 + " should be prime.", this.prime.isPrime(2));
	}
	@Test
	public void test3() {
		assertTrue(3 + " should be prime.", this.prime.isPrime(3));
	}
	@Test
	public void test4() {
		assertTrue(4 + " should be prime.", this.prime.isPrime(4));
	}
	@Test
	public void test5() {
		assertTrue(5 + " should be prime.", this.prime.isPrime(5));
	}
	@Test
	public void test6() {
		assertTrue(6 + " should be prime.", this.prime.isPrime(6));
	}

}
