package com.mhdb;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.springframework.web.client.RestTemplate;

import com.mhdb.controllers.Monster;
//Data Accessor for getting monster data from MongoDB via Spring Boot API
//Uses RestTemplate to query local API and return data
//Created By Adrian Faircloth
//6-10-24

public class MonsterData {
	private RestTemplate template = new RestTemplate();
	private Monster monster;
	private LinkedHashMap<String, ?> mondata;
	
	public MonsterData(int id) {
		monster = template.getForObject("http://localhost:8080/api/get/monster/id/" + id, Monster.class);
		mondata = monster.getMonster();
	}
	
	public MonsterData(String name) {
		monster = template.getForObject("http://localhost:8080/api/get/monster/name/" + name, Monster.class);
		mondata = monster.getMonster();
	}
	
	public LinkedHashMap<String, ?> getMonData() {
		return mondata;
	}
	
	public String getLocalName() {
		return (String) mondata.get("local_name");
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<LinkedHashMap<String, ?>> getBodyParts() {
		return (ArrayList<LinkedHashMap<String, ?>>) mondata.get("monsterbodyparts");
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<LinkedHashMap<String, ?>> getWeaponEffects() {
		return (ArrayList<LinkedHashMap<String, ?>>) mondata.get("weaponspecialattacks");
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<LinkedHashMap<String, ?>> getItemEffects() {
		ArrayList<LinkedHashMap<String, ?>> itemeffects = (ArrayList<LinkedHashMap<String, ?>>) mondata.get("itemeffects");
		LinkedHashMap<String, ?> canopytrap = (LinkedHashMap<String, ?>) mondata.get("canopytrap");
		itemeffects.add(canopytrap);
		return itemeffects;
	}
}
