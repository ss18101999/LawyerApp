package com.SE.LawyerApp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SE.LawyerApp.POJO.Chat;
import com.SE.LawyerApp.POJO.Query;

@RestController
public class ChatController {
	
	@Autowired
	private ChatRepository repo;
	
	@Autowired
	private ChatService chatService;
	 
	@GetMapping("/getChats")
	public List<Chat> getAllChats(){
		return repo.findAll();
	}
	
	@PostMapping("/{chatId}/chat")
    public Chat processMessage(@PathVariable String chatId, @RequestBody String message) {
        // Process the message to generate a response
        String response = chatService.generateResponse(message);

        // Add the query (message and response) to the MongoDB for the specific chat ID
        return chatService.addQueryToChat(chatId, new Query(message, response));
    }
	
	@PostMapping("/createChat")
    public Chat createNewChat(@RequestBody Chat request) {
        return chatService.createNewChat(request.getTitle(), request.getQueries());
    }
	
//	@PostMapping("/{chatId}/queries")
//	public Chat addQueryToChat(@PathVariable String chatId, @RequestBody Query query) {
//	        return chatService.addQueryToChat(chatId, query);
//	}
}
