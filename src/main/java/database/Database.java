package database;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import entities.User;
import entities.Timetable;
import entities.Location;
import entities.FriendsList;
import entities.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
<<<<<<< HEAD
import java.lang.runtime.ObjectMethods;
import java.util.Iterator;

import java.lang.reflect.Type;

//import com.github.cliftonlabs.json_simple.JsonArray;
//import com.github.cliftonlabs.json_simple.Jsoner;
//import com.github.dozermapper.core.DozerBeanMapperBuilder;
//import com.github.dozermapper.core.Mapper;
import org.json.JSONArray;
import org.json.JSONObject;
=======
import java.util.Iterator;

>>>>>>> c35187f2c0f0fbb44135af20b04aeb88d21173ab

import java.nio.file.Paths;
import java.nio.file.Files;

import java.io.*;

import java.util.ArrayList;
import java.util.List;
import org.json.simple.parser.*;

public class Database{
    public static void main(String[] args) {
//        Location jonlocation = new Location("jonhouse");
//        ArrayList<User> empty = new ArrayList<>();
//        FriendsList jonfl = new FriendsList(empty, empty);
//        Interval interval = new Interval(0, 1);
//        Lecture lecture = new Lecture(interval, jonlocation);
//        ArrayList<Lecture> lectures = new ArrayList<Lecture>();
//        lectures.add(lecture);
//        Course course = new Course("csc207", "100", lectures);
//        ArrayList<Course> courses = new ArrayList<Course>();
//        courses.add(course);
//        Timetable timetable = new Timetable(courses);
//
//
//        User user1 = new User("jon", "jonpassword", "jonemail", jonlocation, timetable, jonfl);
//        ArrayList<User> users = new ArrayList<User>();
//        users.add(user1);
//
//        setDatabase(users);

        ArrayList<User> temp =  getDatabase();
    }

    private static ArrayList<User> db = new ArrayList<>();

    public static ArrayList<User> getDatabase() {
        JSONParser jsonParser = new JSONParser();
        try {
            String filename = "src/main/java/database/UsersDataBase.json";
<<<<<<< HEAD
=======

            // creates reader
            Reader reader = Files.newBufferedReader(Paths.get(filename));
>>>>>>> c35187f2c0f0fbb44135af20b04aeb88d21173ab

            JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(filename));
//
//            // creates reader
//            Reader reader = Files.newBufferedReader(Paths.get(filename));
//
//            // read JSON from the file
//            JSONArray objects = Jsoner.deserializeMany(reader);
//
//            // create a Dozer mapper
//            Mapper mapper = DozerBeanMapperBuilder.buildDefault();
//
//            // convert JsonArray to List<User>
//            JsonArray jsonArrayList = (JsonArray) objects.get(0);
//            Object j = jsonArrayList.getJSONObject();
//            System.out.println(jsonArrayList);
//            System.out.printf("U----:%s\n", j);
//            List<User> userList = jsonArrayList.stream()
//                    .map(obj -> mapper.map(obj, User.class)).toList();
//
//            // convert List<User> to ArrayList<User>
//            ArrayList<User> userArrayList = new ArrayList<>(userList);
//
//            for (User u : userArrayList) {
//                System.out.println(u.toString());
//                System.out.println("\n");
//            }
//
//            db = userArrayList;
//            return db;
        } catch (Exception e) {
            System.out.println("Exception on getting database!");
            e.printStackTrace();
        }
        return db;
    }

<<<<<<< HEAD
    public static void setDataBase(ArrayList<User> users) {}


=======

>>>>>>> c35187f2c0f0fbb44135af20b04aeb88d21173ab
    public static void setDatabase(ArrayList<User> users){
        File directory = new File("./" + "src\\main\\java\\database\\UsersDataBase.json");
        JsonArray jsonArray = new JsonArray(users);

        try {
                FileWriter writer = new FileWriter(directory.getAbsolutePath(), true);
                writer.write(jsonArray.toJson());
                writer.flush();
                writer.close();
            }
            catch(Exception ex) {
                ex.printStackTrace();
            }
    }
}