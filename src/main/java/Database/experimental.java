package Database;
import java.util.ArrayList;

import entities.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class experimental {
    public static void main(String[] args) {
        MongoClient client = MongoClients.create("mongodb+srv://admin:admin@cluster0.mcz4www.mongodb.net/test");
        MongoDatabase mongoDatabase = client.getDatabase("csc207db");
        MongoCollection<Document> collection = mongoDatabase.getCollection("db");
        Document found = collection.find(new Document("username", "Kim")).first();
        System.out.println(found.get("username"));
    }
}
