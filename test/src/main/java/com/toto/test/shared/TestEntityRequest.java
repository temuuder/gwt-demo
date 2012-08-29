package com.toto.test.shared;

import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;
import com.toto.test.server.domain.TestEntity;

@Service(TestEntity.class)
public interface TestEntityRequest extends RequestContext {

	Request<TestEntityProxy> getFromTab1(TestEntityProxy text);	
	Request<TestEntityProxy> getFromTab2(TestEntityProxy text); 
	
}
