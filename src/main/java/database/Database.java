package database;

import entities.User;
import entities.Timetable;
import entities.Location;
import entities.FriendsList;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.Jsoner;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import java.nio.file.Paths;
import java.nio.file.Files;

import java.io.*;

import java.util.ArrayList;
import java.util.List;

public class Database{

    public static void main(String[] args) {
        getDatabase();
    }

    private static ArrayList<User> db = new ArrayList<>();

    public static ArrayList<User> getDatabase() {
        try {
            String filename = "src/main/java/database/UsersDataBase.json";
            // creates reader
            Reader reader = Files.newBufferedReader(Paths.get(filename));

            // read JSON from the file
            JsonArray objects = Jsoner.deserializeMany(reader);

            // create a Dozer mapper
            Mapper mapper = DozerBeanMapperBuilder.buildDefault();

            // convert JsonArray to List<User>
            JsonArray jsonArrayList = (JsonArray) objects.get(0);
            List<User> userList = jsonArrayList.stream()
                    .map(obj -> mapper.map(obj, User.class)).toList();

            // convert List<User> to ArrayList<User>
            ArrayList<User> userArrayList = new ArrayList<>(userList);

            for (User u : userArrayList) {
                System.out.println(u.toString());
                System.out.println("\n");
            }

            db = userArrayList;
            return db;
        } catch (Exception e) {
            System.out.println("Exception on getting database!");
            e.printStackTrace();
        }
        return db;
    }

    public static void setDataBase(ArrayList<User> users) {}
}