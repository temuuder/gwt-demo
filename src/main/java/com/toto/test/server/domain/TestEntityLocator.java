package com.toto.test.server.domain;

import com.google.web.bindery.requestfactory.shared.Locator;

public class TestEntityLocator extends Locator<TestEntity, String> {

	@Override
	public TestEntity create(Class<? extends TestEntity> clazz) {
		// TODO Auto-generated method stub
		return new TestEntity();
	}

	@Override
	public TestEntity find(Class<? extends TestEntity> clazz, String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<TestEntity> getDomainType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getId(TestEntity domainObject) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<String> getIdType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getVersion(TestEntity domainObject) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
