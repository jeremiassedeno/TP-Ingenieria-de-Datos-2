package com.tp;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoDBConnection implements AutoCloseable {

    private static final String URI = "mongodb://localhost:27017";
    private static final String DATABASE = "logistica";

    

    private MongoClient mongoClient;
    private MongoDatabase database;

    public void connect() {

        mongoClient = MongoClients.create(URI);

        database = mongoClient.getDatabase(DATABASE);

        // Fuerza una operación real contra MongoDB
        database.runCommand(new org.bson.Document("ping", 1));

        System.out.println("MongoDB conectado correctamente.");
    }

    public MongoDatabase getDatabase() {
        return database;
    }

    public void close() {

        if (mongoClient != null) {
            mongoClient.close();
            mongoClient = null;
            database = null;
        }
    }
}