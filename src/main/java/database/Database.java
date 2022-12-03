package database;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsonable;
import com.github.cliftonlabs.json_simple.Jsoner;
import com.github.dozermapper.core.DozerBeanMapper;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import entities.User;
import entities.Timetable;
import entities.Location;
import entities.FriendsList;
import entities.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;


import java.nio.file.Paths;
import java.nio.file.Files;

import java.io.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    private static ArrayList<User> db = new ArrayList<User>();

    public static ArrayList<User> getDatabase() {
        try {
            String filename = "src/main/java/database/UsersDataBase.json";

            // creates reader
            Reader reader = Files.newBufferedReader(Paths.get(filename));

            // read JSON from the file
            JsonArray objects = Jsoner.deserializeMany(reader);

            // create a Dozer mapper
            Mapper mapper = DozerBeanMapperBuilder.buildDefault();

            // convert JsonArray to ArrayList<User>
            JsonArray jsonArrayList = (JsonArray) objects.get(0);
            List<User> userList = jsonArrayList.stream()
                    .map(obj -> mapper.map(obj, User.class)).toList();
            ArrayList<User> userArrayList = new ArrayList<>(userList);

            // convert list to ArrayList
            for (User u : userArrayList) {
                System.out.println(u.getUsername());
            }
            db = userArrayList;
            return db;
        } catch (Exception e) {
            System.out.println("Exception Caught!");
            e.printStackTrace();
        }
        return db;
    }


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