package com.toto.test.shared;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;
import com.toto.test.server.domain.TestEntity;
import com.toto.test.server.domain.TestEntityLocator;

@ProxyFor(value = TestEntity.class, locator = TestEntityLocator.class)
public interface TestEntityProxy extends EntityProxy {


	public String getName();

	public void setName(String name);
	
}
