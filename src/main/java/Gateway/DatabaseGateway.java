package Gateway;
import entities.*;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class DatabaseGateway {
    public static void main(String[] args) {
        getUser("user one");
        System.out.println(getUser("user one").getFriends());
    }

    public static void addUser(User user){

        if(contains(user.getUsername())){
            return;
        }

        JSONObject juser = new JSONObject();
        juser.put("username", user.getUsername());
        juser.put("password", user.getPassword());

        // Friendslist JSONobject
        ArrayList<String> friends = new ArrayList<>();
        ArrayList<String> blocked = new ArrayList<>();

        //Adding friends & blocked to <friends> and <blocked>
        for (User f : user.getFriends()) {
            friends.add(f.getUsername());
        }
        for (User b : user.getBlocked()) {
            blocked.add(b.getUsername());
        }

        juser.put("friendsList", friends);
        juser.put("blockedList", blocked);
        juser.put("location", user.getLocation().getName());


        JSONArray timetable = new JSONArray();
        //loop through  user timetable
        for (Course c : user.getTimetable().getCourses()) {
            JSONObject course = new JSONObject();
            course.put("courseCode", c.getCourseCode());
            course.put("section", c.getSectionCode());

            JSONArray lectures = new JSONArray();
            for (Lecture l : c.getLectures()) {
                JSONObject lecture = new JSONObject();
                lecture.put("start", l.getInterval().getStart());
                lecture.put("end", l.getInterval().getEnd());
                lecture.put("location", l.getLocation().getName());
                lectures.add(lecture);
            }
            course.put("lectures", lectures);
            timetable.add(course);
        }
        juser.put("timetable", timetable);

        MongoClient client = MongoClients.create("mongodb+srv://admin:admin@cluster0.mcz4www.mongodb.net/test");
        MongoDatabase mongoDatabase = client.getDatabase("csc207db");
        MongoCollection<Document> collection = mongoDatabase.getCollection("db");
        Document doc = Document.parse( juser.toString() );

        collection.insertOne(doc);
    }

    public static User getUser(String username1) {
        MongoClient client = MongoClients.create("mongodb+srv://admin:admin@cluster0.mcz4www.mongodb.net/test");
        MongoDatabase mongoDatabase = client.getDatabase("csc207db");
        MongoCollection<Document> collection = mongoDatabase.getCollection("db");

        Document search = (Document) collection.find(new Document("username", username1)).first();

        if (search == null){
            return null;
        }

        try{
            JSONParser jsonParser = new JSONParser();
            JSONObject user = (JSONObject) jsonParser.parse(search.toJson());
            // string information
            String username = (String) user.get("username");
            String password = (String) user.get("password");

            //location information
            Location location = new Location((String) user.get("location"));

            // empty friendsList
            ArrayList<User> friends = new ArrayList<>();
            ArrayList<User> blocked = new ArrayList<>();

            // timetable Object
            ArrayList<Course> courses = new ArrayList<>();
            JSONArray timetableArray = (JSONArray) user.get("timetable");
            for (Object course : timetableArray) {
                JSONObject courseObject = (JSONObject) course;

                // courseCode
                String courseCode = (String) courseObject.get("courseCode");
                // sectionCode
                String sectionCode = (String) courseObject.get("section");
                // lecture
                ArrayList<Lecture> lectures = new ArrayList<>();
                JSONArray lectureArray = (JSONArray) courseObject.get("lectures");
                for (Object lectureObject: lectureArray) {
                    JSONObject lecture = (JSONObject) lectureObject;

                    // location
                    Location locationOfLecture = new Location((String) lecture.get("location"));

                    // interval
                    int s = ((Long) lecture.get("start")).intValue();
                    int e = ((Long) lecture.get("end")).intValue();
                    Interval interval = new Interval(s, e);

                    Lecture newLecture = new Lecture(interval, locationOfLecture);
                    lectures.add(newLecture);
                }
                Course newCourse = new Course(courseCode, sectionCode, lectures);
                courses.add(newCourse);
            }
            Timetable timetable = new Timetable(courses);
            User newUser = new User(username, password, friends, blocked, location, timetable);

           //TODO
            JSONArray friendsList = (JSONArray) user.get("friendsList");
            for (Object o : friendsList){
                String f = (String) o;
                if (contains(f)){

                }
            }

            return newUser;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        User user = new User();
        return user;
    }

    public static boolean contains(String username){
        MongoClient client = MongoClients.create("mongodb+srv://admin:admin@cluster0.mcz4www.mongodb.net/test");
        MongoDatabase mongoDatabase = client.getDatabase("csc207db");
        MongoCollection<Document> collection = mongoDatabase.getCollection("db");
        Document search = collection.find(new Document("username", username)).first();
        if (search == null){
            return false;
        }
        return true;
    }
}