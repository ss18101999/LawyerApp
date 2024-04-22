package com.SE.LawyerApp;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.SE.LawyerApp.POJO.Chat;

interface ChatRepository extends MongoRepository<Chat,String>{
	Chat findBy_id(int id);
}
