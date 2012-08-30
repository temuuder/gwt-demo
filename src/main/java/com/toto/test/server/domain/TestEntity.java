package com.toto.test.server.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TestEntity {

	@NotNull
	@Size(min = 3, max = 6)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public static TestEntity getFromTab1(TestEntity ent) {
		TestEntity entity = new TestEntity();
		entity.setName(ent.getName() + " - tab1 - " + System.currentTimeMillis());
		return entity;
	}
	
	public static TestEntity getFromTab2(TestEntity ent) {
		TestEntity entity = new TestEntity();
		entity.setName(ent.getName() + " - tab2 - " + System.currentTimeMillis());
		return entity;
	}
}
