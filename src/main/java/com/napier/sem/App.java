package com.napier.sem;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class App {
    public static void main(String[] args) {
        //System.out.println("Boo yah!");
        MongoClient mongoClient = new MongoClient("mongo-dbserver");

        MongoDatabase database = mongoClient.getDatabase("mydb");

        MongoCollection<Document> collection = database.getCollection("test");

        Document doc = new Document("name", "Patrikas Lukosius")
                .append("class", "Software Engineering Methods")
                .append("year", "2022")
                .append("result", new Document("CW", 95).append("EX",85));
        collection.insertOne(doc);

        Document myDoc = collection.find().first();
        System.out.println(myDoc.toJson());
    }


}
