package com.tsys.endpoint;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tsys.InputSOATest;
import com.tsys.ObjectFactory;
import com.tsys.OutputSOATest;

@RunWith(SpringRunner.class)
@SpringBootTest

public class WebServiceEndPointTest {


	@InjectMocks
	OutputSOATest OutputSOATest = new OutputSOATest();
	
	
	@InjectMocks
	ObjectFactory ObjectFactory = new ObjectFactory();
	
	@InjectMocks
	InputSOATest InputSOATest = new InputSOATest();
	
	

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	

	/**
	 * 
	 * @param applicationContext
	 *            This test case is for testing the application context set for
	 *            particular application context object to return data
	 */

	@Test
	public void test_MessageSample(InputSOATest request) {
		
		assertNotNull(this.OutputSOATest);
		assertNotNull(this.ObjectFactory);
		assertNotNull(this.InputSOATest);
		assertEquals(this.ObjectFactory.createOutputSOATest(), "mock message");

	}
}
