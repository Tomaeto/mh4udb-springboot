package com.mhdb.controllers;

import java.util.LinkedHashMap;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("monsters")
public class Monster {
	@Id
	private String id;
	
	private LinkedHashMap<String, ?> monster;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LinkedHashMap<String, ?> getMonster() {
		return monster;
	}

	public void setMonster(LinkedHashMap<String, ?> monster) {
		this.monster = monster;
	}

	public Monster(String id, LinkedHashMap<String, ?> monster) {
		super();
		this.id = id;
		this.monster = monster;
	}
}
