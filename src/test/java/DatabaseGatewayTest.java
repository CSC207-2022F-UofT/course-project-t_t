import Gateway.DatabaseGateway;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import entities.*;

import java.util.ArrayList;
import java.util.Objects;

import org.json.simple.JSONObject;

import org.json.simple.parser.JSONParser;
import org.junit.Before;
import org.junit.Test;

import org.bson.Document;

import javax.xml.crypto.Data;

import static org.junit.Assert.*;

public class DatabaseGatewayTest {

    static String connectionString = "mongodb+srv://admin:admin@cluster0.1jn32wd.mongodb.net/test";
    static String databaseName = "csc207";
    static String collectionName = "db";
    static MongoClient client = MongoClients.create(connectionString);
    static MongoDatabase mongoDatabase = client.getDatabase(databaseName);
    static MongoCollection<Document> collection = mongoDatabase.getCollection(collectionName);

    @Test(timeout = 3000)
    public void testAddUser() {
        User user1 = new User("michael", "jordan", new ArrayList<>(), new ArrayList<>());
        DatabaseGateway.addUser(user1);
        Document search = collection.find(new Document("username", "michael")).first();
        try {
            JSONParser jsonParser = new JSONParser();
            assert search != null;
            JSONObject user = (JSONObject) jsonParser.parse(search.toJson());
            String username = (String) user.get("username");
            String password = (String) user.get("password");
            assertEquals("michael", username);
            assertEquals("jordan", password);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 3000)
    public void testGetUser() {
        User user1 = new User("michael", "jordan", new ArrayList<>(), new ArrayList<>());
        DatabaseGateway.addUser(user1);
        User user2 = DatabaseGateway.getUser("michael");
        assert user2 != null;
        String username = user2.getUsername();
        String password = user2.getPassword();
        assertEquals("michael", username);
        assertEquals("jordan", password);
    }

    @Test(timeout = 3000)
    public void testContains() {
        User user1 = new User("donald", "duck", new ArrayList<>(), new ArrayList<>());
        DatabaseGateway.addUser(user1);
        assertTrue(DatabaseGateway.contains("donald"));
    }

    @Test(timeout = 3000)
    public void testUpdate() {
        User user1 = new User("adam", "eve", new ArrayList<>(), new ArrayList<>());
        DatabaseGateway.addUser(user1);
        User user2 = new User("adam", "canada", new ArrayList<>(), new ArrayList<>());
        DatabaseGateway.update(user2);
        assertEquals("canada", Objects.requireNonNull(DatabaseGateway.getUser("adam")).getPassword());
    }
}
