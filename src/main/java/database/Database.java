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

import java.nio.file.Paths;
import java.nio.file.Files;

import java.io.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Database{

    public static void main(String[] args) {
        getDatabase();
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
                System.out.println(u.getPassword());
                System.out.println(u.getEmail());
                System.out.println(u.getLocation());
                System.out.println(u.getFriendsList().getFriends());
            }
            db = userArrayList;
            return db;
        } catch (Exception e) {
            System.out.println("Exception on getting database!");
            e.printStackTrace();
        }
        return db;
    }

    public static void setDataBase(ArrayList<User> users) {
        try {
            // create writer
            String path = "src/main/java/database/UsersDataBase.json";
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(path));

            // create users list
            List<User> userList = new ArrayList<User>();
            for ()
        } catch (Exception e) {
            System.out.println("Exception on setting database!");
            e.printStackTrace();
        }
    }
}