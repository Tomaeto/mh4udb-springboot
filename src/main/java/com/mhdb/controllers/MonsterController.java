package com.mhdb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MonsterController {

	@Autowired
	MonsterRepository monRepo;
	
		@GetMapping("/api/get/monster/id/{id}")
		public Monster getMon(@PathVariable int id) {
			if (id != 0)
			return monRepo.findByMonsterID(id);
			
			return null;
		}
		
		@GetMapping("/api/get/monster/name/{local_name}")
		public Monster getMonByName(@PathVariable String local_name) {
			if (local_name != null)
				return monRepo.findByLocalName(local_name);
			
			return null;
		}
		
		
		@GetMapping("/api/get/monster/all")
		public List<Monster> getAllMons() {
			return monRepo.findAll();
		}
		
		@DeleteMapping("api/delete/monster/{id}")
		void deleteMonster(@PathVariable String id) {
			monRepo.deleteById(id);
		}
		
}
