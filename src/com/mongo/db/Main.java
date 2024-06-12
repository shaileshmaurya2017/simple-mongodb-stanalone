package com.mongo.db;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;



public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("In main.....");
		
		MongoClient mongoClient = MongoClients.create();
		MongoDatabase db =  mongoClient.getDatabase("mydb");
		//db.createCollection("student");
		MongoCollection<Document> collection = db.getCollection("student");
		Document searchQuery = new Document();
		searchQuery.put("name", "Shubham");
		FindIterable<Document> cursor = collection.find(searchQuery);
		try (final MongoCursor<Document> cursorIterator = cursor.cursor()) {
		    while (cursorIterator.hasNext()) {
		        System.out.println(cursorIterator.next().get("name"));
		    }
		}
		System.out.println(collection.countDocuments());
		insert("govind","giri");
		//mongoClient.close();
	}
	
	public static void insert(String name , String company) {
		
		MongoClient mongoClient = MongoClients.create();
		MongoDatabase db =  mongoClient.getDatabase("mydb");
		//db.createCollection("student");
		MongoCollection<Document> collection = db.getCollection("student");
		Document document = new Document();
		document.put("name", name);
		document.put("company", company);
		System.out.println(document);
	//	collection.insertOne(document);
		//mongoClient.close();
	}

}
