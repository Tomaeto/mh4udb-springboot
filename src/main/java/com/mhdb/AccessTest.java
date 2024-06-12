package com.mhdb;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.springframework.web.client.RestTemplate;

import com.mhdb.controllers.Monster;

public class AccessTest {
	private RestTemplate template = new RestTemplate();
	private Monster monster;
	private LinkedHashMap<String, ?> mondata;
	
	public AccessTest(int id) {
		monster = template.getForObject("http://localhost:8080/api/get/monster/id/" + id, Monster.class);
		mondata = monster.getMonster();
	}
	
	public AccessTest(String name) {
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
