package com.firstmaven01;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class JUnit01 {
	//JUnit testing, we are using Annotations @ 
	//Create first method
	// @Test is used to CREATE TEST CASES
	// with @Test, we no longer need a main method
	

	//Create a method and name setUp and print "this is before method"
	@Before
	public void setUp() {
		System.out.println("This is before method");

	}
	
	@Test
	public void test1(){
		System.out.println("This is my first test case");
	}
	
	//Skipping(ignore) a test case we use @Ignore annotation
	//@Ignore
	@Test
	public void test2() {
		
		System.out.println("This is my second test case");
	}
	
	@Test
	public void test3() {
		System.out.println("This is my third test case");
	}
	
	
	@After
	public void tearDown() {
		System.out.println("This is my after method");
	}
	
	
	
	
}
	
	
