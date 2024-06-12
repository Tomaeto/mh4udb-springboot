package com.mhdb;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import gui.MainFrame;

@SpringBootApplication
@EnableMongoRepositories
public class MongodbDataRestApplication {

	
	public static void main(String[] args) throws IOException {
		SpringApplication.run(MongodbDataRestApplication.class, args);
		
		System.setProperty("java.awt.headless", "false");
		MainFrame frame = new MainFrame();
		frame.setVisible(true);
	}
}
