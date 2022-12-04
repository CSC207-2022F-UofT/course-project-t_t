package database;
import entities.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
//import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

//import org.json.simple.parser.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Database {

    public static void main(String[] args) {
        getDatabase();
    }
    private static final ArrayList<User> db = new ArrayList<User>();

    public static ArrayList<User> getDatabase() {
        JSONParser parser = new JSONParser();
        ArrayList<User> returnUsers = new ArrayList<>();
        try (Reader reader = new FileReader("src/main/java/database/UsersDataBase.json")) {
            JSONArray listOfUsers = (JSONArray) parser.parse(reader);
            for (Object o: listOfUsers) {
                JSONObject user = (JSONObject) o;
                String username = (String) user.get("username");
                String password = (String) user.get("password");
                String email = (String) user.get("email");
                JSONObject friendsList = (JSONObject) user.get("friendsList");
                JSONObject location = (JSONObject) user.get("location");
                JSONArray timetable = (JSONArray) user.get("timetable");
                User newUser = new User();

            }



//            JSONObject f1 = (JSONObject) user.get("friendsList");
//            JSONArray f2 = (JSONArray) f1.get("friendsList");
            return db;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return db;
    }

    public static void addUser(String username, String password, ArrayList<User> friends, ArrayList<User> blocked) {
        db.add(new User(username, password, friends, blocked));
    }

    public static User getUser(String username) {
        System.out.println(username);
        for (User user : db) {
            System.out.println(user);
            if (Objects.equals(user.getUsername(), username)) {
                return user;
            }
        }
        return null;
    }

    public static ArrayList<Timetable> getDummyTimetablesTemp() {
        ArrayList<Lecture> dummyLectures1 = new ArrayList<>();

        dummyLectures1.add(
                new Lecture(new Interval(2160, 2220), new Location("BA 2222"))
        );
        dummyLectures1.add(
                new Lecture(new Interval(6660, 6720), new Location("BA 2222"))
        );

        ArrayList<Lecture> dummyLectures2 = new ArrayList<>();

        dummyLectures2.add(
                new Lecture(new Interval(2160, 2220), new Location("BA 2222"))
        );
        dummyLectures2.add(
                new Lecture(new Interval(3720, 3840), new Location("BA 2222"))
        );


        ArrayList<Course> dummyCourses1 = new ArrayList<>();

        dummyCourses1.add(
                new Course("KIM101", "LEC 0101", dummyLectures1)
        );
        dummyCourses1.add(
                new Course("JJJ265", "LEC 0101", dummyLectures2)
        );

        ArrayList<Course> dummyCourses2 = new ArrayList<>();

        dummyCourses2.add(
                new Course("KIM101", "LEC 0101", dummyLectures1)
        );
        dummyCourses2.add(
                new Course("JJJ265", "LEC 0101", dummyLectures2)
        );

        Timetable dummyTimetable1 = new Timetable(dummyCourses1);
        Timetable dummyTimetable2 = new Timetable(dummyCourses2);

        ArrayList<Timetable> timetables = new ArrayList<>();
        timetables.add(dummyTimetable1);
        timetables.add(dummyTimetable2);

        return timetables;
    }

}