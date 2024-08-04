package persistence;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoDBManager {
    private static MongoDatabase database;

    public static MongoDatabase getDatabase() {
        if (database == null) {
            MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
            database = mongoClient.getDatabase("clubDeportivo");
        }
        return database;
    }
}
