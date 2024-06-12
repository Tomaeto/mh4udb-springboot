package com.mhdb.controllers;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface MonsterRepository extends MongoRepository<Monster, String> {
	@Query("{'monster.local_name':'?0'}")
	Monster findByLocalName(String local_name);
	
	@Query("{'monster.id':?0}")
	Monster findByMonsterID(int id);
	
	
	public long count();
}
