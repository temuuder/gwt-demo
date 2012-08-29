package com.toto.test.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.junit.client.GWTTestCase;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.toto.test.client.clientfactory.ClientFactory;
import com.toto.test.shared.TestEntityProxy;
import com.toto.test.shared.TestEntityRequest;

public class JunitExampleTest extends GWTTestCase {

	private ClientFactory clientFactory = GWT.create(ClientFactory.class);
	
	@Override
	public String getModuleName() {
		return "com.toto.test.TestModule";
	}

	
	public void testJsonJSNIAccess() {
		TestEntityRequest context = clientFactory.getRequestFactory().getTestEntityRequest();
		TestEntityProxy proxy = context.create(TestEntityProxy.class);
		proxy.setName(clientFactory.getView().getTextbox1Text());
		context.getFromTab1(proxy).fire(new Receiver<TestEntityProxy>() {

			@Override
			public void onSuccess(TestEntityProxy response) {
				System.out.print(response.getName());
			}
			
		});
		
//		assertEquals("Jimmy Webber", Customer.getCustomerArray().get(0).getFullName());
//		assertEquals("Alan Dayal", Customer.getCustomerArray().get(1).getFullName());
//		assertEquals("Keanu Spoon", Customer.getCustomerArray().get(2).getFullName());
//		assertEquals("Emily Rudnick", Customer.getCustomerArray().get(3).getFullName());
	}
}
