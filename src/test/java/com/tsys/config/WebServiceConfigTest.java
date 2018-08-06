package com.tsys.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.SimpleWsdl11Definition;

@RunWith(SpringRunner.class)
@SpringBootTest

public class WebServiceConfigTest {

	@InjectMocks
	MessageDispatcherServlet servlet = new MessageDispatcherServlet();
	
	@InjectMocks
	ApplicationContext applicationContext;

	@InjectMocks
	SimpleWsdl11Definition wsdl11Definition = new SimpleWsdl11Definition();

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
	public void test_MessageDispatcherServlet(ApplicationContext applicationContext) {
		this.servlet.setApplicationContext(applicationContext);
		assertNotNull(this.servlet);
		assertNotNull(this.applicationContext);
		assertEquals(this.servlet, new ServletRegistrationBean(servlet, "/tsys/ws/*"));

	}

	/**
	 * This test case is for testing WSDL return schema for the test method
	 * DefaultWsdl11Definition
	 */
	@Test
	public void test_DefaultWsdl11Definition() {
		this.wsdl11Definition.setWsdl(new ClassPathResource("/wsdl/helloworld.wsdl"));
		assertNotNull(this.wsdl11Definition);
		assertEquals(this.wsdl11Definition, new ClassPathResource("/wsdl/helloworld.wsdl"));

	}

}
