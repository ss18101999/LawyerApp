package com.SE.LawyerApp.POJO;
import java.util.*;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Chats")
public class Chat {
	private ArrayList<Query> queries;
	private String title;
	private int _id;
	public ArrayList<Query> getQueries() {
		return queries;
	}
	public void setQueries(ArrayList<Query> queries) {
		this.queries = queries;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	@Override
	public String toString() {
		return "Chat [queries=" + queries + ", title=" + title + ", _id=" + _id + "]";
	}
	
	
	
	
	
}
